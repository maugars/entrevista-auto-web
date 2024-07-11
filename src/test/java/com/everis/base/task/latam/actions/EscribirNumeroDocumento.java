package com.everis.base.task.latam.actions;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EscribirNumeroDocumento implements Task {

    private static String numeroDocumento;

    public synchronized static void setNumeroDocumento(String numeroDocumento) {
        EscribirNumeroDocumento.numeroDocumento = numeroDocumento;
    }

    public EscribirNumeroDocumento(String nombres) {
        setNumeroDocumento(nombres);
    }

    public static EscribirNumeroDocumento correctly(String nombres) {
        return instrumented(EscribirNumeroDocumento.class, nombres);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(numeroDocumento).into(LatamPage.txtNombres));
    }
}
