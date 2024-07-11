package com.everis.base.task.latam.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectAgregaVueloVuelta implements Task {

    String elemento = "//li[@class='sc-jbWsrJ eSNJcs'][3]//span[contains(text(),'@categoria')]";
    String vueloVuelta;

    public SelectAgregaVueloVuelta(String vueloVuelta) {
        this.vueloVuelta = vueloVuelta;
    }

    public static SelectAgregaVueloVuelta correctly(String vueloVuelta) {
        return instrumented(SelectAgregaVueloVuelta.class, vueloVuelta);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target tag = Target.the("agregar vuelo de vuelta plus").located(By.xpath(elemento.replace("@categoria", vueloVuelta)));
        actor.attemptsTo(Click.on(tag));
    }
}
