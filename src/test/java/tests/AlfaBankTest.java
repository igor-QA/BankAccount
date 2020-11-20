package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTest {
    int count = 5;

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true; //размер задать как например 640-480???.
    }

    @Test
    void testCountDeposit() {

        open("https://alfabank.ru/make-money/");
        $$(byText("Депозиты")).find(visible).parent().click();
        $("[data-widget-name='Heading']").shouldHave(text("Вклады"));
        $$(byText("Архивные счета и депозиты")).find(visible).click();
        $("body").shouldHave(text("Архивные счета и депозиты"));
        $$(byText("Депозиты")).find(visible).click();
        $("#filter").findAll("[data-widget-name=CatalogCard]").shouldHaveSize(count);


    }
}




