package ui.components;

import com.codeborne.selenide.*;

public class RiskBlock {

    private static final SelenideElement riskBlockContent = Selenide.$("[id='risk-block']");
    private static final SelenideElement riskBlockCloseBtn = Selenide.$("[id='js-riskCloseButton']");

    public void closeRisk() {
        if (riskBlockContent.isDisplayed()) {
            riskBlockCloseBtn.click();
        }
        riskBlockContent.should(Condition.disappear);
    }

}

