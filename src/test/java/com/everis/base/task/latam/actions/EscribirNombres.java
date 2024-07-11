package com.everis.base.task.latam.actions;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EscribirNombres implements Task {

    private static String nombres;

    public synchronized static void setNombres(String nombres) {
        EscribirNombres.nombres = nombres;
    }

    public EscribirNombres(String nombres) {
        setNombres(nombres);
    }

    public static EscribirNombres correctly(String nombres) {
        return instrumented(EscribirNombres.class, nombres);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(nombres).into(LatamPage.txtNombres));
    }
}
