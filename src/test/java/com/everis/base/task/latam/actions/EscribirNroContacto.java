package com.everis.base.task.latam.actions;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EscribirNroContacto implements Task {

    private static String nroContacto;

    public synchronized static void setNroContacto(String nroContacto) {
        EscribirNroContacto.nroContacto = nroContacto;
    }

    public EscribirNroContacto(String nroContacto) {
        setNroContacto(nroContacto);
    }

    public static EscribirNroContacto correctly(String nroContacto) {
        return instrumented(EscribirNroContacto.class, nroContacto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(nroContacto).into(LatamPage.txtNumero));
    }
}
