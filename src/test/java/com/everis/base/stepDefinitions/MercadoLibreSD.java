package com.everis.base.stepDefinitions;

import com.everis.base.abilities.mercadoLibre.Register;
import com.everis.base.questions.TitleLogin;
import com.everis.base.task.mercadoLIbre.NavigateToML;
import com.everis.base.task.mercadoLIbre.RegisterUsuarioML;
import com.everis.base.task.mercadoLIbre.actions.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author jovallep
 */

public class MercadoLibreSD {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que {actor} no es usuario de Mercadolibre")
    public void que_Cesar_acceda_a_la_web_de_Mercadolibre(Actor actor) {
        actor.wasAbleTo(NavigateToML.theMercadoLibrePage());
        actor.can(Register.withData("AAAAA", "BBBBB", "CCCCCCC@C.COM", "12345678", "12345678"));
    }

    @When("accede a la opción de apertura cuenta")
    public void selecciona_crear_cuenta() {
        theActorInTheSpotlight().attemptsTo(Select.altaOption());
    }

    @When("el se da de alta como cliente nuevo tabla")
    public void elSeDaDeAltaComoClienteNuevoTabla(List<Map<String, String>> user) {
        theActorInTheSpotlight().attemptsTo(
                Select.altaOption(),
                WriteName.correctly(user.get(0).get("name")),
                WriteLastName.correctly(user.get(0).get("lastName")),
                SelectDocument.typeDNI(),
                WriteDocument.correctly(user.get(0).get("document")),
                WriteMail.correctly(user.get(0).get("email")),
                WritePasswod.correctly(user.get(0).get("password"))
        );
    }

    @When("el se da de alta como cliente nuevo")
    public void elSeDaDeAltaComoClienteNuevo() {
        theActorInTheSpotlight().attemptsTo(
                RegisterUsuarioML.correctly()
        );
    }

    @And("ingresa su nombre: {string}")
    public void escribe_nombre_de_usuario(String nombre) {
        theActorInTheSpotlight().attemptsTo(WriteName.correctly(nombre));
    }

    @And("ingresa su apellido: {string}")
    public void escribe_apellido_de_usuario(String apellido) {
        theActorInTheSpotlight().attemptsTo(WriteLastName.correctly(apellido));
    }

    @And("selecciona tipo de documento DNI")
    public void seleccionaTipoDeDocumentoDNI() {
        theActorInTheSpotlight().attemptsTo(SelectDocument.typeDNI());
    }

    @And("selecciona tipo de documento CE")
    public void seleccionaTipoDeDocumentoCE() {
        theActorInTheSpotlight().attemptsTo(SelectDocument.typeCE());
    }

    @And("ingresa su numero de documento: {string}")
    public void ingresaSuNumeroDeDocumento(String document) {
        theActorInTheSpotlight().attemptsTo(WriteDocument.correctly(document));
    }

    @And("ingresa su email: {string}")
    public void escribe_email_de_usuario(String email) {
        theActorInTheSpotlight().attemptsTo(WriteMail.correctly(email));
    }

    @Then("ingresa su password: {string}")
    public void escribe_clave_de_usuario(String clave) {
        theActorInTheSpotlight().attemptsTo(WritePasswod.correctly(clave));
    }

    @And("acepta terminos")
    public void aceptaTerminos() {
        theActorInTheSpotlight().attemptsTo(CheckTerminos.accepted());
    }

    @And("selecciona el boton continuar")
    public void seleccionaElBotonContinuar() {
        theActorInTheSpotlight().attemptsTo(SelectContinuar.button());
    }

    @Then("valida el producto")
    public void valida_El_Producto() {
        theActorInTheSpotlight().should(seeThat(
                TitleLogin.getText(), equalTo("Laptop Lenovo Ideapad Slim 3 15 Amd Ryzen 3 8gb 512gb Ssd | Cuotas sin interés")));
    }
}
