package ui.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.json.JSONObject;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class TradingConditionsComponent {

    private static final SelenideElement marginRequirementValue = Selenide.$("[data-xm-qa-name='margin_requirement__value']");
    private static final SelenideElement symbolsValue = Selenide.$("[data-xm-qa-name='symbols__value']");
    private static final SelenideElement descriptionValue = Selenide.$("[data-xm-qa-name='description__value']");
    private static final SelenideElement minPriceFluctuationValue = Selenide.$("[data-xm-qa-name='fc_min_price_fluctuation__value']");
    private static final SelenideElement valueOfMinPriceFluctuationValue = Selenide.$("[data-xm-qa-name='value_of_minimum_price_fluctuation__value']");
    private static final SelenideElement valueOfOneLotValue = Selenide.$("[data-xm-qa-name='value_one_lot__value']");
    private static final SelenideElement speedAsLowAsValue = Selenide.$("[class='table pull-right'] [data-xm-qa-name='spreads_as_low_as__value'] [class='red']");
    private static final SelenideElement minMaxTradeSizeValue = Selenide.$("[data-xm-qa-name='min_max_trade_size__value']");
    private static final SelenideElement swapValueLong = Selenide.$("[data-xm-qa-name='swap_value_in_margin_currency_long__value']");
    private static final SelenideElement swapValueShort = Selenide.$("[data-xm-qa-name='swap_value_in_margin_currency_short__value']");
    private static final SelenideElement limitAndStopLevels = Selenide.$("[data-xm-qa-name='limit_and_stop_levels__title'] [class='red']");
    private static final SelenideElement totalVolumeLimit = Selenide.$("[data-xm-qa-name='cryptocurrency_total_volume_limit_new__title'] [class='red']");

    public void compareTradingConditionDetailsWithStockValues(final JSONObject stockValues) {
        marginRequirementValue.shouldHave(Condition.text(stockValues.getString(StockCFDTableComponent.MARGIN_PERCENTAGE)));
        symbolsValue.shouldHave(Condition.text(stockValues.getString(StockCFDTableComponent.MT5_SYMBOL)));
        assertTrue(stockValues.getString(StockCFDTableComponent.DESCRIPTION_AND_SYMBOL).contains(descriptionValue.getText()));
        speedAsLowAsValue.shouldHave(Condition.text(stockValues.getString(StockCFDTableComponent.SPREAD_AS_LOW_AS)));
        minMaxTradeSizeValue.shouldHave(Condition.text(stockValues.getString(StockCFDTableComponent.MIN_MAX_TRADE_SIZE)));
        swapValueLong.shouldHave(Condition.text(stockValues.getString(StockCFDTableComponent.LONG_SWAP_VALUE)));
        swapValueShort.shouldHave(Condition.text(stockValues.getString(StockCFDTableComponent.SHORT_SWAP_VALUE)));
        limitAndStopLevels.shouldHave(Condition.text(stockValues.getString(StockCFDTableComponent.LIMIT_AND_STOP_LEVELS)));
    }

}
