package ui.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;

public class StickyBarComponent {

    private static final SelenideElement stickyBarContent = Selenide.$("[class='sticky-bar active']");
    private static final SelenideElement stickyBarCloseBtn = Selenide.$("[class='sticky-bar active'] [class='fa fa-times']");

    public void closeStickyBar() {
        Selenide.executeJavaScript("window.scrollBy(0,2000);");
        stickyBarContent.shouldBe(Condition.visible);
        stickyBarCloseBtn.click();

        stickyBarContent.should(Condition.disappear);
    }
}
