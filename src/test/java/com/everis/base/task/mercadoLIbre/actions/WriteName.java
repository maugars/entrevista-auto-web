package com.everis.base.task.mercadoLIbre.actions;

import com.everis.base.page.MercadoLibrePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WriteName implements Task {

    private static String name;

    public synchronized static void setName(String name) {
        WriteName.name = name;
    }

    public WriteName(String name) {
        setName(name);
    }

    public static WriteName correctly(String name) {
        return instrumented(WriteName.class, name);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Enter.theValue(name).into(MercadoLibrePage.textoNombre));

    }
}
