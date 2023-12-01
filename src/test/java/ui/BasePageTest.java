package ui;

import ui.components.CookiesModal;
import ui.components.RiskBlock;
import ui.components.StickyBarComponent;
import org.testng.annotations.AfterMethod;
import ui.pages.BasePage;

public class BasePageTest {

    public void acceptCookies() {
        final CookiesModal cookies = new CookiesModal();
        cookies.acceptCookies();
    }

    public void closeStickyBar() {
        final StickyBarComponent stickyBarComponent = new StickyBarComponent();
        stickyBarComponent.closeStickyBar();
    }

    public void closeRiskBlock() {
        final RiskBlock riskBlock = new RiskBlock();
        riskBlock.closeRisk();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        BasePage.quitDriver();
    }
}
