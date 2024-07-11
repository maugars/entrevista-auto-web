package com.everis.base.task.latam.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectFechaVuelta implements Task {

    String elemento = "//*[contains(@aria-label,' @fechaVuelta')]";
    String fechaVuelta;

    public SelectFechaVuelta(String fechaVuelta) {
        this.fechaVuelta = fechaVuelta;
    }

    public static SelectFechaVuelta correctly(String fechaVuelta) {
        return instrumented(SelectFechaVuelta.class, fechaVuelta);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target tag = Target.the("selecciona fecha de vuelta").located(By.xpath(elemento.replace("@fechaVuelta", fechaVuelta)));
        actor.attemptsTo(Click.on(tag));
    }
}
