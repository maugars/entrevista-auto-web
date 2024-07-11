package com.everis.base.task.mercadoLIbre.actions;

import com.everis.base.page.MercadoLibrePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WriteLastName implements Task {

    private static String lastName;

    public synchronized static void setLastName(String lastName) {
        WriteLastName.lastName = lastName;
    }

    public WriteLastName(String lastName) {
        setLastName(lastName);
    }

    public static WriteLastName correctly(String lastName) {
        return instrumented(WriteLastName.class, lastName);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Enter.theValue(lastName).into(MercadoLibrePage.textoApellido));
    }
}
