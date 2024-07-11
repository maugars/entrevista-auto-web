package com.everis.base.task.latam.actions;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectDocumento implements Task {

    String elemento = "//li[@data-value='@documento']";
    String documento;

    public SelectDocumento(String documento) {
        this.documento = documento;
    }

    public static SelectDocumento correctly(String documento) {
        return instrumented(SelectDocumento.class, documento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LatamPage.cboDocumento));
        Target tag = Target.the("seleccionar documento").located(By.xpath(elemento.replace("@documento", documento)));
        actor.attemptsTo(Click.on(tag));
    }
}
