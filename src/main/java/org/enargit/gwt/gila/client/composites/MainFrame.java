package org.enargit.gwt.gila.client.composites;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;
import org.enargit.gwt.gila.client.GilaGwtMain;
import org.enargit.gwt.gila.client.data.dispatcher.BasicAuthDispatcher;
import org.enargit.gwt.gila.client.data.dispatcher.Credentials;
import org.enargit.gwt.gila.client.data.rest.CountryService;
import org.enargit.gwt.gila.client.dto.CountryDto;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.text.SimpleDateFormat;
import java.util.List;

public class MainFrame extends Composite {

    public static final DateTimeFormat SIMPLE_DATE_FORMAT = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss");

    interface MainFrameUiBinder extends UiBinder<Widget, MainFrame> {
    }

    private static final MainFrame.MainFrameUiBinder uiBinder = GWT.create(MainFrame.MainFrameUiBinder.class);



    private AsyncDataProvider<CountryDto> asyncDataProvider;

    @UiField
    CellTable<CountryDto> countryDtoCellTable = new CellTable<>();


    TextColumn<CountryDto> idColumn;

    TextColumn<CountryDto> nameColumn;

    TextColumn<CountryDto> domainColumn;

    TextColumn<CountryDto> abbrColumn;

    TextColumn<CountryDto> phoneColumn;

    TextColumn<CountryDto> createdColumn;

    public MainFrame() {
        initWidget(uiBinder.createAndBindUi(this));
        initTableColumns();
        initData();

    }

    public void initTableColumns() {




        idColumn = new TextColumn<CountryDto>() {
            @Override
            public String getValue(CountryDto object) {
                return Long.toString(object.getId());
            }
        };

        nameColumn = new TextColumn<CountryDto>() {
            @Override
            public String getValue(CountryDto object) {
                return object.getName();
            }
        };

        domainColumn = new TextColumn<CountryDto>() {
            @Override
            public String getValue(CountryDto object) {
                return object.getDomain();
            }
        };

        abbrColumn = new TextColumn<CountryDto>() {
            @Override
            public String getValue(CountryDto object) {
                return object.getAbbreviation();
            }
        };

        phoneColumn = new TextColumn<CountryDto>() {
            @Override
            public String getValue(CountryDto object) {
                return object.getPhone();
            }
        };

        createdColumn = new TextColumn<CountryDto>() {
            @Override
            public String getValue(CountryDto object) {
                return SIMPLE_DATE_FORMAT.format(object.getCreated());
            }
        };

        idColumn.setSortable(true);
        nameColumn.setSortable(true);
        domainColumn.setSortable(true);
        abbrColumn.setSortable(true);
        phoneColumn.setSortable(true);
        createdColumn.setSortable(true);

    }




    public void initData() {
        asyncDataProvider = new AsyncDataProvider<CountryDto>() {
            @Override
            protected void onRangeChanged(HasData<CountryDto> display) {

                Range range = display.getVisibleRange();

                long offset = range.getStart();
                int limit = range.getLength();
                Credentials.INSTANCE.setUserName("tadams");
                Credentials.INSTANCE.setPassword("tadams");
                Defaults.setServiceRoot("http://localhost:9900");
                Defaults.setDispatcher(new BasicAuthDispatcher());

                CountryService countryService = GWT.create(CountryService.class);

                countryService.findAll(offset, limit, new MethodCallback<List<CountryDto>>() {
                    @Override
                    public void onFailure(Method method, Throwable throwable) {
                        GWT.log(throwable.getMessage());
                    }

                    @Override
                    public void onSuccess(Method method, List<CountryDto> countryDtos) {
                        countryDtoCellTable.setRowData(Long.valueOf(offset).intValue(), countryDtos);
                    }
                });

            }
        };
        asyncDataProvider.addDataDisplay(countryDtoCellTable);
        ColumnSortEvent.AsyncHandler columnSortHandler = new ColumnSortEvent.AsyncHandler(countryDtoCellTable);
        countryDtoCellTable.addColumnSortHandler(columnSortHandler);
        countryDtoCellTable.getColumnSortList().push(idColumn);

    }

}
