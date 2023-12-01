package ui.components;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public enum TradingDropdownElements {

    CRYPTOCURRENCIES(Selenide.$(By.className("[class='menu-cryptocurrencies'] a")),
            Selenide.$x("//a[contains(span, 'Cryptocurrencies')]"),
            "cryptocurrencies"),
    STOCKS(Selenide.$("[class='menu-stocks'] a"),
            Selenide.$x("//a[contains(span, 'Stock CFDs')]"),
            "stocks");

    TradingDropdownElements(final SelenideElement elementForBigResolution, final SelenideElement elementForSmallResolution,
                            final String url) {
        this.elementForSmallResolution = elementForSmallResolution;
        this.elementForBigResolution = elementForBigResolution;
        this.url = url;
    }

    public final SelenideElement elementForBigResolution;
    public final SelenideElement elementForSmallResolution;

    public final String url;

}
