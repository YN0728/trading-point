package ui.pages;

import ui.components.StockCFDTableComponent;
import ui.components.StockCFDTableFilters;
import ui.components.TradingDropdownElements;
import org.json.JSONObject;

public class StocksPage extends BasePage {

    private final StockCFDTableComponent stockTableComponent = new StockCFDTableComponent();

    public StocksPage(final String resolution) {
        super(resolution);
    }

    public void open() {
        open(baseUrl + TradingDropdownElements.STOCKS.getUrl());
    }

    public JSONObject getStockDataAndNavigateToDetails(final String stockName){
        stockTableComponent.filterStocks(StockCFDTableFilters.NORWAY);
        stockTableComponent.searchForStock(stockName);
        final JSONObject stockData = stockTableComponent.getDataOfStockByOrder(0);
        stockTableComponent.navigateToStockDetailsByOrder(0);
        return stockData;
    }

    public JSONObject getStockDataAndNavigateToDetailsSmallRes(final String stockName){
        stockTableComponent.filterStocks(StockCFDTableFilters.NORWAY);
        stockTableComponent.searchForStock(stockName);
        final JSONObject stockData = stockTableComponent.getDataOfStockByOrderSmallRes(0);
        stockTableComponent.navigateToStockDetailsByOrderSmallRes(0);
        return stockData;
    }

    public JSONObject getStockDataAndNavigateToDetailsMeanRes(final String stockName){
        stockTableComponent.filterStocks(StockCFDTableFilters.NORWAY);
        stockTableComponent.searchForStock(stockName);
        final JSONObject stockData = stockTableComponent.getDataOfStockByOrderMeanRes(0);
        stockTableComponent.navigateToStockDetailsByOrderSmallRes(0);
        return stockData;
    }

}
