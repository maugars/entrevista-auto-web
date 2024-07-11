package com.everis.base.task.mercadoLIbre.actions;

import com.everis.base.page.MercadoLibrePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectBuscar implements Task {
    public static SelectBuscar altaOption() {
        return instrumented(SelectBuscar.class, "");
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Click.on(MercadoLibrePage.btnBuscar));
    }
}
