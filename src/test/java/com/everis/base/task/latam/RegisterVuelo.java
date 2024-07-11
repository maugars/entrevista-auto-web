package com.everis.base.task.latam;

import com.everis.base.abilities.mercadoLibre.RegisterVueloAbilities;
import com.everis.base.page.LatamPage;
import com.everis.base.task.latam.actions.CambiarTab;
import com.everis.base.task.latam.actions.SeleccionarFechaVuelo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterVuelo implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterVuelo.class);

    String elementoFechaIda = "//*[contains(@aria-label,' @fechaIda')]";
    String elementoFechaVuelta = "//*[contains(@aria-label,' @fechaVuelta')]";

    public static RegisterVuelo correctly() {
        return instrumented(RegisterVuelo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.can(RegisterVueloAbilities.withData("Lima", "Cusco", "14 de junio", "20 de junio"));
        LOGGER.info("Los datos del origen son: {} y el destino: {} ", registerVueloAbilities(actor).origen(), registerVueloAbilities(actor).destino());
        Target tagIda = Target.the("seleccionar fecha de ida").located(By.xpath(elementoFechaIda.replace("@genero", registerVueloAbilities(actor).fechaIda())));
        Target tagVuelta = Target.the("seleccionar fecha de vuelta").located(By.xpath(elementoFechaVuelta.replace("@genero", registerVueloAbilities(actor).fechaVuelta())));
        actor.attemptsTo(
                Enter.theValue(registerVueloAbilities(actor).origen()).into(LatamPage.txtOrigen),
                Click.on(LatamPage.lstOrigen),
                Enter.theValue(registerVueloAbilities(actor).destino()).into(LatamPage.txtDestino),
                Click.on(LatamPage.lstDestino),
                //NUEVO CLICK
                Click.on(LatamPage.txtFecha)
                );
        actor.attemptsTo(SeleccionarFechaVuelo.withData("mayo","20"));
        actor.attemptsTo(SeleccionarFechaVuelo.withData("mayo","24"));
        actor.attemptsTo(
                //Click.on(LatamPage.txtIda),
            //    Click.on(tagIda),
              //  Click.on(tagVuelta),
                Click.on(LatamPage.btnBuscar)
                // Click.on(LatamPage.lstVueloIda),
               // Click.on(LatamPage.linkDetalles)
        );
        actor.attemptsTo(CambiarTab.correctly(1));

        actor.attemptsTo(
                Click.on(LatamPage.lstVueloIda),
                Click.on(LatamPage.linkDetalles)
        );

        try{
            Thread.sleep(5000);
        }catch (Exception e)
        {
            System.out.println(e);
        }


        actor.attemptsTo(
                Click.on(LatamPage.lstVueloIda),
                Click.on(LatamPage.linkDetalles)
        );
    }

    private RegisterVueloAbilities registerVueloAbilities(Actor actor) {
        return RegisterVueloAbilities.as(actor);
    }
}
