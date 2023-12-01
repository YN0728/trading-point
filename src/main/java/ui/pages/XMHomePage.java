package ui.pages;

import ui.components.HeaderComponent;
import ui.components.TradingDropdownElements;

public class XMHomePage extends BasePage{

    private final HeaderComponent headerComponent = new HeaderComponent();

    public XMHomePage(final String resolution) {
        super(resolution);
    }

    public void open() {
        open(baseUrl);
    }

    public void chooseOptionFromTradingDropdown(final TradingDropdownElements tradingOption) {
        headerComponent.openTradingDropdown();
        headerComponent.clickOnSectionOnDropdown(tradingOption);
    }

    public void chooseOptionFromTradingDropdownSmallResolution(final TradingDropdownElements tradingOption) {
        headerComponent.openTradingDropdownSmallRes();
        headerComponent.clickOnSectionOnDropdownSmallRes(tradingOption);
    }

    public void openMenu() {
        headerComponent.openHeaderMenu();
    }

}
