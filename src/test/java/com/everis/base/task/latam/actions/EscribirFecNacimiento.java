package com.everis.base.task.latam.actions;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EscribirFecNacimiento implements Task {

    private static String fecNacimiento;

    public synchronized static void setFecNacimiento(String fecNacimiento) {
        EscribirFecNacimiento.fecNacimiento = fecNacimiento;
    }

    public EscribirFecNacimiento(String fecNacimiento) {
        setFecNacimiento(fecNacimiento);
    }

    public static EscribirFecNacimiento correctly(String fecNacimiento) {
        return instrumented(EscribirFecNacimiento.class, fecNacimiento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(fecNacimiento).into(LatamPage.txtFecNacimiento));
    }
}
