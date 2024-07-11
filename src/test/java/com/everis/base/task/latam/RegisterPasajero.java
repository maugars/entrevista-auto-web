package com.everis.base.task.latam;

import com.everis.base.abilities.mercadoLibre.RegisterPasajeroAbilities;
import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegisterPasajero implements Task {

    String elementoCategoriaIda = "//li[@class='sc-jbWsrJ eSNJcs'][4]//span[contains(text(),'@categoriaIda')]";
    String elementoCategoriaVuelta = "//li[@class='sc-jbWsrJ eSNJcs'][3]//span[contains(text(),'@categoriaVuelta')]";
    String elementoGenero = "//li[@data-value='@genero']";
    String elementoTipoDocumento = "//li[@data-value='@tipoDocumento']";

    public static RegisterPasajero correctly() {
        return instrumented(RegisterPasajero.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target tagCatIda = Target.the("agregar vuelo de ida premium").located(By.xpath(elementoCategoriaIda.replace("@categoriaIda", registerPasajeroAbilities(actor).catIda())));
        Target tagCatVuelta = Target.the("agregar vuelo de vuelta plus ").located(By.xpath(elementoCategoriaVuelta.replace("@categoriaVuelta", registerPasajeroAbilities(actor).catVuelta())));
        Target tagGenero = Target.the("seleccionar genero").located(By.xpath(elementoGenero.replace("@genero", registerPasajeroAbilities(actor).genero())));
        Target tagTipoDoc = Target.the("seleccionar tipo de documento").located(By.xpath(elementoTipoDocumento.replace("@tipoDocumento", registerPasajeroAbilities(actor).tipoDocumento())));

        actor.attemptsTo(
                Click.on(LatamPage.btnCerrar),
                Switch.toFrame(""),
                Click.on(tagCatIda),
                WaitUntil.the(LatamPage.lblResumen, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(LatamPage.lstVueloVuelta),
                Click.on(tagCatVuelta),
                Click.on(LatamPage.btnContinuarA),
                WaitUntil.the(LatamPage.lblAsientoIda, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(LatamPage.btnAsientoIda),
                Click.on(LatamPage.btnSiguienteVuelo),
                WaitUntil.the(LatamPage.lblAsientoVuelta, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(LatamPage.btnAsientoVuelta),
                Click.on(LatamPage.btnConfirmar),
                Click.on(LatamPage.btnContinuarB),
                Enter.theValue(registerPasajeroAbilities(actor).nombres()).into(LatamPage.txtNombres),
                Enter.theValue(registerPasajeroAbilities(actor).apellidos()).into(LatamPage.txtApellidos),
                Enter.theValue(registerPasajeroAbilities(actor).nacimiento()).into(LatamPage.txtFecNacimiento),
                Click.on(LatamPage.cboGenero),
                Click.on(tagGenero),
                Click.on(LatamPage.cboDocumento),
                Click.on(tagTipoDoc),
                Enter.theValue(registerPasajeroAbilities(actor).documento()).into(LatamPage.txtDocumento),
                Enter.theValue(registerPasajeroAbilities(actor).email()).into(LatamPage.txtEmail),
                Enter.theValue(registerPasajeroAbilities(actor).numero()).into(LatamPage.txtNumero),
                Click.on(LatamPage.btnGuardar),
                WaitUntil.the(LatamPage.lblNombres, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(LatamPage.btnContinuarC),
                WaitUntil.the(LatamPage.lblConfirmacion, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(LatamPage.btnPagar));
    }

    private RegisterPasajeroAbilities registerPasajeroAbilities(Actor actor) {
        return RegisterPasajeroAbilities.as(actor);
    }
}
