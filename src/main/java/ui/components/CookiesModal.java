package ui.components;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

public class CookiesModal {

    private static final SelenideElement cookiesPopup = Selenide.$(By.className("cookie-modal__defaultBlock"));
    private static final SelenideElement acceptAll = Selenide.$(".cookie-modal__defaultBlock .js-acceptDefaultCookie");

    public void acceptCookies() {
        acceptAll.click();
        cookiesPopup.should(Condition.disappear);
    }

}
