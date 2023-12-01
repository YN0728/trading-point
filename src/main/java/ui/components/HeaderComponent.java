package ui.components;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import ui.pages.BasePage;
import utils.TestUtils;

import static org.testng.Assert.assertEquals;

public class HeaderComponent {

    private static final SelenideElement home = Selenide.$(By.className("main_nav_home"));
    private static final SelenideElement tradingIconBigResolution = Selenide.$(".main_nav_trading");
    private static final SelenideElement tradingIconSmallResolution = Selenide.$("[aria-controls='tradingMenu']");
    private static final SelenideElement tradingDropdownContentBigResolution = Selenide.$(".main_nav_trading .container .capitalize_text");
    private static final SelenideElement tradingDropdownContentSmallResolution = Selenide.$("[id='tradingMenu']");
    private static final SelenideElement menuIconSmallRes = Selenide.$("[class='toggleLeftNav']");


    public void openTradingDropdown() {
        tradingIconBigResolution.click();
        tradingDropdownContentBigResolution.should(Condition.appear);
    }

    public void openTradingDropdownSmallRes() {
        tradingIconSmallResolution.click();
        tradingDropdownContentSmallResolution.should(Condition.appear);
    }

    public void clickOnSectionOnDropdown(TradingDropdownElements tradingOption) {
        tradingOption.getElementForBigResolution().click();
        final SelenideElement pageTitle = Selenide.$("[title='"
                + TestUtils.capitalizeAndSeparate(tradingOption.getUrl()) + "']");
        pageTitle.shouldBe(Condition.visible);
        final String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(currentUrl, BasePage.baseUrl + tradingOption.getUrl(), "Incorrect redirection");
    }

    public void clickOnSectionOnDropdownSmallRes(TradingDropdownElements tradingOption) {
        tradingOption.getElementForSmallResolution().click();
        final SelenideElement pageTitle = Selenide.$("[title='"
                + TestUtils.capitalizeAndSeparate(tradingOption.getUrl()) + "']");
        pageTitle.shouldBe(Condition.visible);
        final String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(currentUrl, BasePage.baseUrl + tradingOption.getUrl(), "Incorrect redirection");
    }

    public void openHeaderMenu() {
        menuIconSmallRes.click();
    }

}
