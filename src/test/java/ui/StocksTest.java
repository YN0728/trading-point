package ui;

import ui.components.TradingDropdownElements;
import org.json.JSONObject;
import org.testng.annotations.*;
import ui.pages.StockDetailsPage;
import ui.pages.*;

public class StocksTest extends BasePageTest {

    @Test
    @Parameters({"resolution"})
    public void compareStockDetailsWithTradingConditionsMaxResolution(final String resolution) {
        final XMHomePage homePage = new XMHomePage(resolution);
        homePage.open();
        acceptCookies();
        homePage.chooseOptionFromTradingDropdown(TradingDropdownElements.STOCKS);

        final StocksPage stocksPage = new StocksPage(resolution);
        closeStickyBar();
        final JSONObject stockDetails = stocksPage.getStockDataAndNavigateToDetails("Orkla ASA");

        final StockDetailsPage stockDetailsPage = new StockDetailsPage(resolution);
        closeStickyBar();
        stockDetailsPage.compareTradingConditionDetailsWithStockValues(stockDetails);
    }

    @Parameters({"resolution"})
    @Test
    public void compareStockDetailsWithTradingConditionsMinResolution(final String resolution) {
        final XMHomePage homePage = new XMHomePage(resolution);
        homePage.open();
        acceptCookies();
        homePage.openMenu();
        homePage.chooseOptionFromTradingDropdownSmallResolution(TradingDropdownElements.STOCKS);

        final StocksPage stocksPage = new StocksPage(resolution);
        closeRiskBlock();
        final JSONObject stockDetails = stocksPage.getStockDataAndNavigateToDetailsSmallRes("Orkla ASA");

        final StockDetailsPage stockDetailsPage = new StockDetailsPage(resolution);
        closeRiskBlock();
        stockDetailsPage.compareTradingConditionDetailsWithStockValues(stockDetails);
    }


    @Parameters({"resolution"})
    @Test
    public void compareStockDetailsWithTradingConditionsMidResolution(final String resolution) {
        final XMHomePage homePage = new XMHomePage(resolution);
        homePage.open();
        acceptCookies();
        homePage.chooseOptionFromTradingDropdown(TradingDropdownElements.STOCKS);

        final StocksPage stocksPage = new StocksPage(resolution);
        closeRiskBlock();
        final JSONObject stockDetails = stocksPage.getStockDataAndNavigateToDetailsMeanRes("Orkla ASA");

        final StockDetailsPage stockDetailsPage = new StockDetailsPage(resolution);
        closeRiskBlock();
        stockDetailsPage.compareTradingConditionDetailsWithStockValues(stockDetails);
    }

}
