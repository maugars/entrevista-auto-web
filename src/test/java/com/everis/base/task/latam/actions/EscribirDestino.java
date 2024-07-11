package com.everis.base.task.latam.actions;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EscribirDestino implements Task {

    private static String destino;

    public synchronized static void setDestino(String destino) {
        EscribirDestino.destino = destino;
    }

    public EscribirDestino(String destino) {
        setDestino(destino);
    }

    public static EscribirDestino correctly(String destino) {
        return instrumented(EscribirDestino.class, destino);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(destino).into(LatamPage.txtDestino));
    }
}
