package com.everis.base.task.mercadoLIbre.actions;

import com.everis.base.page.MercadoLibrePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WriteMail implements Task {

    private static String email;

    public synchronized static void setMail(String email) {
        WriteMail.email = email;
    }

    public WriteMail(String email) {
        setMail(email);
    }

    public static WriteMail correctly(String email) {
        return instrumented(WriteMail.class, email);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Enter.theValue(email).into(MercadoLibrePage.textoCorreo));

    }
}
