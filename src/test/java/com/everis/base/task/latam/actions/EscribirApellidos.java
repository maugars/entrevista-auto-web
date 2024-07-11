package com.everis.base.task.latam.actions;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EscribirApellidos implements Task {

    private static String apellidos;

    public synchronized static void setApellidos(String apellidos) {
        EscribirApellidos.apellidos = apellidos;
    }

    public EscribirApellidos(String apellidos) {
        setApellidos(apellidos);
    }

    public static EscribirApellidos correctly(String apellidos) {
        return instrumented(EscribirApellidos.class, apellidos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(apellidos).into(LatamPage.txtApellidos));
    }
}
