package com.everis.base.task.mercadoLIbre;

import com.everis.base.abilities.mercadoLibre.Register;
import com.everis.base.page.MercadoLibrePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegisterUsuarioML implements Task {

    public static RegisterUsuarioML correctly() {
        return instrumented(RegisterUsuarioML.class);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Click.on(MercadoLibrePage.btnCrearCuenta),
                Enter.theValue(register(theActorInTheSpotlight()).name()).into(MercadoLibrePage.textoNombre),
                Enter.theValue(register(theActorInTheSpotlight()).lastName()).into(MercadoLibrePage.textoApellido),
                SelectFromOptions.byVisibleText("DNI").from(MercadoLibrePage.tipoDocumento),
                Enter.theValue(register(theActorInTheSpotlight()).documentNumber()).into(MercadoLibrePage.writeDocumento),
                Enter.theValue(register(theActorInTheSpotlight()).email()).into(MercadoLibrePage.textoCorreo),
                Enter.theValue(register(theActorInTheSpotlight()).password()).into(MercadoLibrePage.textoClave),
                JavaScriptClick.on(MercadoLibrePage.checkTerminos),
                Click.on(MercadoLibrePage.buttonContinuar));
    }

    private Register register(Actor actor) {
        return Register.as(actor);
    }
}
