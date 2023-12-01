package ui.pages;

import ui.components.TradingConditionsComponent;
import org.json.JSONObject;

public class StockDetailsPage extends BasePage {

    private final TradingConditionsComponent tradingConditionsComponent = new TradingConditionsComponent();

    public StockDetailsPage(final String resolution) {
        super(resolution);
    }

    public void compareTradingConditionDetailsWithStockValues(final JSONObject valuesFromStockPage) {
        tradingConditionsComponent.compareTradingConditionDetailsWithStockValues(valuesFromStockPage);
    }
}
