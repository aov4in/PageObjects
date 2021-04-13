package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import java.util.Collection;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");

    private SelenideElement upBalanceCard1 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] button");
    private SelenideElement upBalanceCard2 = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] button");
    private SelenideElement updateBalance = $("[data-test-id=action-reload]");
    private SelenideElement cancelTransfer = $("data-test-id=action-cancel");

    private ElementsCollection cards = $$(".list__item");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    DashboardPage(){
        heading.shouldBe(visible);
    }

    public int getFirstCardBalance() {
        val text = cards.first().text();
        return extractBalance(text);
    }
    public int getSecondCardBalance() {
        val text = cards.last().text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public TransferPage validToTransferCard1() {
        upBalanceCard1.click();
        return new TransferPage();
    }

    public TransferPage validToTransferCard2() {
        upBalanceCard2.click();
        return new TransferPage();
    }

    public TransferPage TransferCardPage(){
        updateBalance.click();
        return new TransferPage();
    }

}
