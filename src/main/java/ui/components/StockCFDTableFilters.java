package ui.components;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public enum StockCFDTableFilters {

    ALL_STOCKS(Selenide.$("[data-value='']")),
    SPAIN(Selenide.$("[data-value='Spain']")),
    NORWAY(Selenide.$("[data-value='Norway']"));

    StockCFDTableFilters(SelenideElement element) {
        this.element = element;
    }

    public final SelenideElement element;
}
