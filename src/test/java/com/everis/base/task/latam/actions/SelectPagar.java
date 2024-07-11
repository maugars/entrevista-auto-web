package com.everis.base.task.latam.actions;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectPagar implements Task {

    public static SelectPagar correctly() {
        return instrumented(SelectPagar.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(LatamPage.lblConfirmacion, isVisible()).forNoMoreThan(10).seconds());
        actor.attemptsTo(Click.on(LatamPage.btnPagar));
    }
}
