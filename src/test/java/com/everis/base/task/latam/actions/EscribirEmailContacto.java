package com.everis.base.task.latam.actions;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EscribirEmailContacto implements Task {

    private static String emailContacto;

    public synchronized static void setEmailContacto(String emailContacto) {
        EscribirEmailContacto.emailContacto = emailContacto;
    }

    public EscribirEmailContacto(String emailContacto) {
        setEmailContacto(emailContacto);
    }

    public static EscribirEmailContacto correctly(String emailContacto) {
        return instrumented(EscribirEmailContacto.class, emailContacto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(emailContacto).into(LatamPage.txtEmail));
    }
}
