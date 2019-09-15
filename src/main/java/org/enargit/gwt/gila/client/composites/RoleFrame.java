package org.enargit.gwt.gila.client.composites;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.ColumnSortList;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;
import org.enargit.gwt.gila.client.GilaGwtMain;
import org.enargit.gwt.gila.client.data.dispatcher.BasicAuthDispatcher;
import org.enargit.gwt.gila.client.data.dispatcher.BasicAuthHeaderDispatcherFilter;
import org.enargit.gwt.gila.client.data.dispatcher.Credentials;
import org.enargit.gwt.gila.client.data.request.RoleRequest;
import org.enargit.gwt.gila.client.data.request.SortDirection;
import org.enargit.gwt.gila.client.data.rest.CountryService;
import org.enargit.gwt.gila.client.data.rest.RoleService;
import org.enargit.gwt.gila.client.dto.CountryDto;
import org.enargit.gwt.gila.client.dto.RoleDto;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import javax.management.Query;
import java.util.List;
import java.util.Map;

public class RoleFrame extends Composite {

    public static final DateTimeFormat SIMPLE_DATE_FORMAT = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss");

    interface RoleFrameUiBinder extends UiBinder<Widget, RoleFrame> {
    }

    private static final RoleFrame.RoleFrameUiBinder uiBinder = GWT.create(RoleFrame.RoleFrameUiBinder.class);


    private AsyncDataProvider<RoleDto> asyncDataProvider;

    @UiField
    CellTable<RoleDto> roleDtoCellTable = new CellTable<>();


    TextColumn<RoleDto> idColumn;

    TextColumn<RoleDto> nameColumn;


    public RoleFrame() {
        initWidget(uiBinder.createAndBindUi(this));
        initTableColumns();
        initData();

    }

    public void initTableColumns() {


        idColumn = new TextColumn<RoleDto>() {
            @Override
            public String getValue(RoleDto object) {
                return Long.toString(object.getId());
            }
        };

        nameColumn = new TextColumn<RoleDto>() {
            @Override
            public String getValue(RoleDto object) {
                return object.getRole();
            }
        };

        idColumn.setSortable(true);
        nameColumn.setSortable(true);

        roleDtoCellTable.addColumn(idColumn, "ID");
        roleDtoCellTable.addColumn(nameColumn, "ROLE");
    }


    public void initData() {
        asyncDataProvider = new AsyncDataProvider<RoleDto>() {
            @Override
            protected void onRangeChanged(HasData<RoleDto> display) {

                Range range = display.getVisibleRange();

                long offset = range.getStart();
                int limit = range.getLength();
                Credentials.INSTANCE.setUserName("tadams");
                Credentials.INSTANCE.setPassword("tadams");
                Defaults.setServiceRoot("http://localhost:9900");
                Defaults.setDispatcher(new BasicAuthDispatcher());
                RoleService roleService = GWT.create(RoleService.class);

                roleService.findAll(createRoleRequest(offset, limit), new MethodCallback<List<RoleDto>>() {
                    @Override
                    public void onFailure(Method method, Throwable throwable) {
                        GWT.log(throwable.getMessage());
                    }

                    @Override
                    public void onSuccess(Method method, List<RoleDto> roleDtos) {
                        roleDtoCellTable.setRowData(Long.valueOf(offset).intValue(), roleDtos);
                    }
                });

            }
        };
        asyncDataProvider.addDataDisplay(roleDtoCellTable);
        ColumnSortEvent.AsyncHandler columnSortHandler = new ColumnSortEvent.AsyncHandler(roleDtoCellTable);
        roleDtoCellTable.addColumnSortHandler(columnSortHandler);
        roleDtoCellTable.getColumnSortList().push(idColumn);
    }


    private RoleRequest createRoleRequest(long offset, int limit) {
        ColumnSortList.ColumnSortInfo info = roleDtoCellTable.getColumnSortList().get(0);
        RoleRequest roleRequest = new RoleRequest();
        roleRequest.setLimit(limit);
        roleRequest.setOffset(offset);
        roleRequest.getSortParams().put("sort", info.getColumn().getDataStoreName());
        String sortDirection = info.isAscending() ? "asc" : "desc";
        roleRequest.getSortParams().put(info.getColumn().getDataStoreName() + ".dir", sortDirection);
        return roleRequest;
    }
}
