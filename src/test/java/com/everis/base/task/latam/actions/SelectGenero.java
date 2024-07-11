package com.everis.base.task.latam.actions;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectGenero implements Task {

    String elemento = "//li[@data-value='@genero']";
    String genero;

    public SelectGenero(String genero) {
        this.genero = genero;
    }

    public static SelectGenero correctly(String genero) {
        return instrumented(SelectGenero.class, genero);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LatamPage.cboGenero));
        Target tag = Target.the("seleccionar genero").located(By.xpath(elemento.replace("@genero", genero)));
        actor.attemptsTo(Click.on(tag));
    }
}
