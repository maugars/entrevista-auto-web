package com.everis.base.task.mercadoLIbre.actions;

import com.everis.base.page.MercadoLibrePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WritePasswod implements Task {

    private static String password;

    public synchronized static void setPassword(String password) {

        WritePasswod.password = password;
    }

    public WritePasswod(String password) {
        setPassword(password);
    }

    public static WritePasswod correctly(String password) {
        return instrumented(WritePasswod.class, password);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Enter.theValue(password).into(MercadoLibrePage.textoClave));

    }
}
