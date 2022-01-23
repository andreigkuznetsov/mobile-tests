package tests;

import com.codeborne.selenide.Selenide;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AndroidTests extends TestBase {

    @Test
    void gettingStartedScreensTest() {

        step("Проверяем, что первый экран содержит контент", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });

        step("1", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/addLangContainer")).click());

        step("2", () ->
                $(byClassName("android.widget.ImageView")).click());

        step("3", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/menu_search_language")).click());

        step("4", () ->
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Russian"));

        step("5", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/language_subtitle")).click());

        step("6", () ->
                $(byClassName("android.widget.ImageButton")).click());

        step("7", () -> {
            $$(MobileBy.id("org.wikipedia.alpha:id/option_label"))
                    .shouldHave(texts("1.\t\tEnglish", "2.\t\tРусский"));
        });

        step("Переходим на следующий экран", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Проверяем, что второй экран содержит контент", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
        });

        step("Переходим на следующий экран", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Проверяем, что третий экран содержит контент", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
        });

        step("Переходим на следующий экран", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Проверяем, что четвертый экран содержит контент", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Send anonymous data"));
        });

        step("Выключаем анонимную передачу пользовательских данных", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/switchView")).click());

        step("Проверяем, что четвертый экран содержит контент", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/switchView"))
                    .shouldHave(text("Send usage data OFF"));
        });
    }

}














