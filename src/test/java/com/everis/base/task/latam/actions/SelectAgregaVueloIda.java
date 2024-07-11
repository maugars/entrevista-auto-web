package com.everis.base.task.latam.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectAgregaVueloIda implements Task {

    String elemento = "//li[@class='sc-jbWsrJ eSNJcs'][4]//span[contains(text(),'@categoria')]";
    String vueloIda;

    public SelectAgregaVueloIda(String vueloIda) {
        this.vueloIda = vueloIda;
    }

    public static SelectAgregaVueloIda correctly(String vueloIda) {
        return instrumented(SelectAgregaVueloIda.class, vueloIda);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target tag = Target.the("agregar vuelo de ida premium").located(By.xpath(elemento.replace("@categoria", vueloIda)));
        actor.attemptsTo(Click.on(tag));
    }
}
