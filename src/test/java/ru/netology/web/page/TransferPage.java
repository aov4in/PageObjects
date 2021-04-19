package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;

public class TransferPage {
    private SelenideElement heading = $(byText("Пополнение карты"));

    private SelenideElement amount = $("[data-test-id=amount] .input__control");
    private SelenideElement from = $("[data-test-id=from] .input__control");
    private SelenideElement transferButton = $("[data-test-id=action-transfer]");
    private SelenideElement cancelButton = $("[data-test-id=action-cancel]");

    public TransferPage(){
        heading.shouldBe(Condition.visible);
    }

    public DashboardPage validVerify1(DataHelper.Cards transferInfo, int value) {
        amount.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        amount.sendKeys(Keys.BACK_SPACE);
        amount.setValue(String.valueOf(value));
        from.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        from.sendKeys(Keys.DELETE);
        from.setValue(transferInfo.getCardNumber());
        transferButton.click();
        return new DashboardPage();
    }

    public DashboardPage noValidVerify(DataHelper.Cards transferInfo, int value) {
        amount.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        amount.sendKeys(Keys.BACK_SPACE);
        amount.setValue(String.valueOf(value));
        from.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        from.sendKeys(Keys.DELETE);
        from.setValue(transferInfo.getCardNumber());
        cancelButton.click();
        return new DashboardPage();
    }

}
