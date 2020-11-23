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
        $("[data-test-id=tabs-list-tabTitle-0]").sibling(0).click();
        // $$(byText("Страхование вкладов")).find(visible).click(); Этот варинт проще, что на шаге 34 по феншую как нужно в задании
        $("[data-test-id='accordion-item-0']").shouldBe(text("Альфа-Банк является участником системы обязательного страхования вкладов"));
    }
}
