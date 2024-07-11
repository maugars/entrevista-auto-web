package com.everis.base.task.latam.actions;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EscribirOrigen implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(EscribirOrigen.class);

    private static String origen;

    public synchronized static void setOrigen(String origen) {
        EscribirOrigen.origen = origen;
    }

    public EscribirOrigen(String origen) {
        setOrigen(origen);
    }

    public static EscribirOrigen correctly(String origen) {
        return instrumented(EscribirOrigen.class, origen);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("escribe el origen {}", origen);
        actor.attemptsTo(Enter.theValue(origen).into(LatamPage.txtOrigen));
    }
}
