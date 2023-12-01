package ui.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.json.JSONObject;

public class StockCFDTableComponent {

    private static final SelenideElement searchBox = Selenide.$("[id='DataTables_Table_0_filter'] [type='search']");
    private static final ElementsCollection descriptionElements = Selenide.$$("[data-xm-qa-name='symbolWithDescription']");
    private static final ElementsCollection mt5Symbol = Selenide.$$("[data-xm-qa-name='symbol']");
    private static final ElementsCollection minSpread = Selenide.$$("[data-xm-qa-name='minSpread']");
    private static final ElementsCollection minMaxTradeSize = Selenide.$$("[data-xm-qa-name='minMaxTradeSize']");
    private static final ElementsCollection marginPercentage = Selenide.$$("[data-xm-qa-name='marginRequirement']");
    private static final ElementsCollection longSwapValue = Selenide.$$("[data-xm-qa-name='swapLong']");
    private static final ElementsCollection shortSwapValue = Selenide.$$("[data-xm-qa-name='swapShort']");
    private static final ElementsCollection shortSwapValueSmallRes = Selenide.$$("[data-dtr-index='7'] [class='dtr-data']");
    private static final ElementsCollection limitAndStopValue = Selenide.$$("[data-xm-qa-name='limitStopLevel']");
    private static final ElementsCollection limitAndStopValueSmallRes = Selenide.$$("[data-dtr-index='8'] [class='dtr-data']");
    private static final ElementsCollection readMore = Selenide.$$("[data-xm-qa-name='url']");
    private static final ElementsCollection readMoreSmallRes = Selenide.$$("[data-dtr-index='9']  [class='btn btn-green']");

    public static final String DESCRIPTION_AND_SYMBOL = "Description";
    public static final String MT5_SYMBOL = "MT5 Symbol";
    public static final String SPREAD_AS_LOW_AS = "Spread as low as";
    public static final String MIN_MAX_TRADE_SIZE = "Min/Max trade size";
    public static final String MARGIN_PERCENTAGE = "Margin percentage";
    public static final String LONG_SWAP_VALUE = "Long swap value";
    public static final String SHORT_SWAP_VALUE = "Short swap value";
    public static final String LIMIT_AND_STOP_LEVELS = "Limit and stop levels";

    public void  filterStocks(final StockCFDTableFilters filter) {
        filter.getElement().scrollTo();
        filter.getElement().click();
    }

    public void searchForStock(final String stockName) {
        searchBox.setValue(stockName);
    }

    public JSONObject getDataOfStockByOrder(final int order) {
        final JSONObject stockData = new JSONObject();
        stockData.put(DESCRIPTION_AND_SYMBOL, descriptionElements.get(order).getText());
        stockData.put(MT5_SYMBOL, mt5Symbol.get(order).getText());
        stockData.put(SPREAD_AS_LOW_AS, minSpread.get(order).getText());
        stockData.put(MIN_MAX_TRADE_SIZE, minMaxTradeSize.get(order).getText());
        stockData.put(MARGIN_PERCENTAGE, marginPercentage.get(order).getText());
        stockData.put(LONG_SWAP_VALUE, longSwapValue.get(order).getText());
        stockData.put(SHORT_SWAP_VALUE, shortSwapValue.get(order).getText());
        stockData.put(LIMIT_AND_STOP_LEVELS, limitAndStopValue.get(order).getText());
        return stockData;
    }

    public JSONObject getDataOfStockByOrderSmallRes(final int order) {
        final JSONObject stockData = new JSONObject();
        stockData.put(DESCRIPTION_AND_SYMBOL, descriptionElements.get(order).getText());
        stockData.put(MT5_SYMBOL, mt5Symbol.get(order).getText());
        stockData.put(SPREAD_AS_LOW_AS, minSpread.get(order).getText());
        stockData.put(MIN_MAX_TRADE_SIZE, minMaxTradeSize.get(order).getText());
        stockData.put(MARGIN_PERCENTAGE, marginPercentage.get(order).getText());
        stockData.put(LONG_SWAP_VALUE, longSwapValue.get(order).getText());
        descriptionElements.get(0).click();
        stockData.put(SHORT_SWAP_VALUE, shortSwapValueSmallRes.get(order).getText());
        stockData.put(LIMIT_AND_STOP_LEVELS, limitAndStopValueSmallRes.get(order).getText());
        return stockData;
    }

    public JSONObject getDataOfStockByOrderMeanRes(final int order) {
        final JSONObject stockData = new JSONObject();
        stockData.put(DESCRIPTION_AND_SYMBOL, descriptionElements.get(order).getText());
        stockData.put(MT5_SYMBOL, mt5Symbol.get(order).getText());
        stockData.put(SPREAD_AS_LOW_AS, minSpread.get(order).getText());
        stockData.put(MIN_MAX_TRADE_SIZE, minMaxTradeSize.get(order).getText());
        stockData.put(MARGIN_PERCENTAGE, marginPercentage.get(order).getText());
        stockData.put(LONG_SWAP_VALUE, longSwapValue.get(order).getText());
        stockData.put(SHORT_SWAP_VALUE, shortSwapValue.get(order).getText());
        stockData.put(LIMIT_AND_STOP_LEVELS, limitAndStopValue.get(order).getText());
        descriptionElements.get(0).click();
        return stockData;
    }

    public void navigateToStockDetailsByOrder(final int order) {
        readMore.get(order).click();
    }
    public void navigateToStockDetailsByOrderSmallRes(final int order) {
        readMoreSmallRes.get(order).click();
    }



}
