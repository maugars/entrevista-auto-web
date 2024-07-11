package com.everis.base.task.latam.actions;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectVueloVuelta implements Task {

    public static SelectVueloVuelta correctly() {
        return instrumented(SelectVueloVuelta.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(LatamPage.lblResumen, isVisible()).forNoMoreThan(10).seconds());
        actor.attemptsTo(Click.on(LatamPage.lstVueloVuelta));
    }
}
