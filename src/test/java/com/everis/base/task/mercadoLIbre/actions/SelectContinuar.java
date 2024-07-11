package com.everis.base.task.mercadoLIbre.actions;

import com.everis.base.page.MercadoLibrePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectContinuar implements Task {

    public static SelectContinuar button() {
        return instrumented(SelectContinuar.class, "");
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Click.on(MercadoLibrePage.buttonContinuar));
    }
}
