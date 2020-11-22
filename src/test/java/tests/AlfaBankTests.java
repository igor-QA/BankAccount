package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void testCountDeposit() {
        open("https://alfabank.ru/make-money/");
        $$(byText("Депозиты")).find(visible).parent().click();
        $("[data-widget-name='Heading']").shouldHave(text("Вклады"));
        $$(byText("Архивные счета и депозиты")).find(visible).click();
        $("body").shouldHave(text("Архивные счета и депозиты"));
        $$(byText("Депозиты")).find(visible).click();
        $("#filter").findAll("[data-widget-name=CatalogCard]").shouldHaveSize(5);
    }

    @Test
    void depositInsuranceTest() {
        open("https://alfabank.ru");
        $(byText("Вклады")).click();
        $("[data-widget-name='Heading']").shouldHave(text("Накопительные продукты"));
        $("[data-test-id='tabs-list']").sibling(0).click();
        $("[data-widget-name='BlockV2']").sibling(2).shouldBe(visible);
    }

}