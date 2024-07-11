package com.everis.base.task.latam.actions;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectFechaIda implements Task {

    String elemento = "//*[contains(@aria-label,' @fechaIda')]";
    String fechaIda;

    public SelectFechaIda(String fechaIda) {
        this.fechaIda = fechaIda;
    }

    public static SelectFechaIda correctly(String fechaIda) {
        return instrumented(SelectFechaIda.class, fechaIda);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LatamPage.txtIda));
        actor.attemptsTo(Click.on(Target.the("selecciona fecha de ida").located(By.xpath(elemento.replace("@fechaIda", fechaIda)))));
    }
}
