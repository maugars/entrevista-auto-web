package com.everis.base.task.latam.actions;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EscribirDocumento implements Task {

    private static String documento;

    public synchronized static void setDocumento(String documento) {
        EscribirDocumento.documento = documento;
    }

    public EscribirDocumento(String documento) {
        setDocumento(documento);
    }

    public static EscribirDocumento correctly(String documento) {
        return instrumented(EscribirDocumento.class, documento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(documento).into(LatamPage.txtDocumento));
    }
}
