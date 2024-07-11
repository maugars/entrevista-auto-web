package com.everis.base.stepDefinitions;

import com.everis.base.abilities.mercadoLibre.RegisterPasajeroAbilities;
import com.everis.base.abilities.mercadoLibre.RegisterVueloAbilities;
import com.everis.base.questions.latam.*;
import com.everis.base.task.latam.NavigateToLatam;
import com.everis.base.task.latam.RegisterPasajero;
import com.everis.base.task.latam.RegisterVuelo;
import com.everis.base.task.latam.actions.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.aNewActor;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class LatamSD {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que {actor} ingresa a la web de LATAM")
    public void queOmarIngresaALaWebDeLATAM(Actor actor) {
        actor.wasAbleTo(NavigateToLatam.LatamWebPage());
        actor.can(RegisterVueloAbilities.withData("Lima", "Cusco", "14 de junio", "20 de junio"));
        actor.can(RegisterPasajeroAbilities.withData("TOP", "PLUS", "Omar Arturo", "Anticona Cruz",
                "04-08-1990", "MALE", "DNI", "71053913", "oanticon@gmail.com", "981355917"));
    }

    @When("ingresa origen: {string}")
    public void ingresaOrigen(String origen) {
        theActorInTheSpotlight().attemptsTo(EscribirOrigen.correctly(origen));
    }

    @And("selecciona la primera opcion origen")
    public void seleccionaLaPrimeraOpcionOrigen() {
        theActorInTheSpotlight().attemptsTo(SelectOrigen.correctly());
    }

    @And("ingresa destino: {string}")
    public void ingresaDestino(String destino) {
        theActorInTheSpotlight().attemptsTo(EscribirDestino.correctly(destino));
    }

    @And("selecciona la primera opcion destino")
    public void seleccionaLaPrimeraOpcionDestino() {
        theActorInTheSpotlight().attemptsTo(SelectDestino.correctly());
    }

    @And("selecciona fecha de ida: {string}")
    public void  ingresaFechaDeIda(String fechaIda) {
        theActorInTheSpotlight().attemptsTo(SelectFechaIda.correctly(fechaIda));
    }

    @And("selecciona fecha de vuelta: {string}")
    public void ingresaFechaDeVuelta(String fechaVuelta) {
        theActorInTheSpotlight().attemptsTo(SelectFechaVuelta.correctly(fechaVuelta));
    }

    @And("selecciona el boton de buscar")
    public void seleccionaElBotonDeBuscar() {
        theActorInTheSpotlight().attemptsTo(SelectBuscar.correctly());
    }

    @And("selecciona vuelo de ida Recomendado")
    public void seleccionaVueloDeIdaRecomendado() {
        theActorInTheSpotlight().attemptsTo(SelectVueloIda.correctly());
    }

    @And("selecciona detalles de tarifa PremiumEconomy")
    public void seleccionaDetallesDeTarifaPremiumEconomy() {
        theActorInTheSpotlight().attemptsTo(SelectDetalles.correctly());
    }

    @And("valida detalles de tarifa")
    public void validaDetallesDeTarifa() {

    //        ID's faltantes mapearlos en seccion LatamPage
    //
    //        siguiente para ver asiento
    //*[@id="button9"]
    //
    //        vuelvo de ida
    //*[@id="cabins-group"]/div[1]/div[3]/div[5]/div/button
    //
    //        ir a seleccion de otro asiento de vuelta
    //*[@id="btn-next-flight"]
    //
    //        vuelo de vuelta
    //*[@id="cabins-group"]/div/div[2]/div[2]/div/button
    //
    //        agregar y continuar
    //*[@id="btn-confirm-and-continue"]/span
    //
    //        click siguiente en equipaje
    //*[@id="BAGS-continue-button"]/span
    //
    //        click en continuar para ver detalles del viaje
    //*[@id="button-cart-confirm"]

        //Modificar validaciones si ya no estan presentes en la pagina
        theActorInTheSpotlight().should(seeThat(TarifaAsiento.getText(), equalTo("Asiento del medio bloqueado")));
        theActorInTheSpotlight().should(seeThat(TarifaMenu.getText(), equalTo("Disfruta de un excelente menú")));
        theActorInTheSpotlight().should(seeThat(TarifaEquipaje.getText(), equalTo("1 equipaje de mano")));
        theActorInTheSpotlight().should(seeThat(TarifaArticulo.getText(), equalTo("Artículo personal")));
        theActorInTheSpotlight().should(seeThat(TarifaBodega.getText(), equalTo("3 equipajes de bodega")));
        theActorInTheSpotlight().should(seeThat(TarifaSeleccion.getText(), equalTo("Selección de asiento")));
    }

    @And("selecciona boton cerrar")
    public void seleccionaBotonCerrar() {
        theActorInTheSpotlight().attemptsTo(SelectCerrar.correctly());
    }

    @And("selecciona categoria ida: {string}")
    public void seleccionaCategoriaIdaPremiumEconomy(String categoria) {
        theActorInTheSpotlight().attemptsTo(SelectAgregaVueloIda.correctly(categoria));
    }

    @And("selecciona vuelo de vuelta Recomendado")
    public void seleccionaVueloDeVueltaRecomendado() {
        theActorInTheSpotlight().attemptsTo(SelectVueloVuelta.correctly());
    }

    @And("selecciona categoria vuelta: {string}")
    public void seleccionaCategoriaVueltaPlus(String categoria) {
        theActorInTheSpotlight().attemptsTo(SelectAgregaVueloVuelta.correctly(categoria));
    }

    @And("selecciona el boton continuarA")
    public void seleccionaElBotonContinuarA() {
        theActorInTheSpotlight().attemptsTo(SelectContinuarA.correctly());
    }

    @And("selecciona asiento de ida disponible")
    public void seleccionaAsientoDeIdaDisponible() {
        theActorInTheSpotlight().attemptsTo(SelectAsientoIda.correctly());
    }

    @And("selecciona el boton siguiente vuelo")
    public void seleccionaElBotonSiguienteVuelo() {
        theActorInTheSpotlight().attemptsTo(SelectSiguienteVuelo.correctly());
    }

    @And("selecciona asiento de vuelta disponible")
    public void seleccionaAsientoDeVueltaDisponible() {
        theActorInTheSpotlight().attemptsTo(SelectAsientoVuelta.correctly());
    }

    @And("selecciona el boton confirmar")
    public void seleccionaElBotonConfirmar() {
        theActorInTheSpotlight().attemptsTo(SelectConfirmar.correctly());
    }

    @And("selecciona el boton continuarB")
    public void seleccionaElBotonContinuarB() {
        theActorInTheSpotlight().attemptsTo(SelectContinuarB.correctly());
    }

    @And("ingresa sus nombres: {string}")
    public void ingresaSusNombres(String nombres) {
        theActorInTheSpotlight().attemptsTo(EscribirNombres.correctly(nombres));
    }

    @And("ingresa sus apellidos: {string}")
    public void ingresaSusApellidos(String apellidos) {
        theActorInTheSpotlight().attemptsTo(EscribirApellidos.correctly(apellidos));
    }

    @And("ingresa su fecha de nacimiento: {string}")
    public void ingresaSuFechaDeNacimiento(String nacimiento) {
        theActorInTheSpotlight().attemptsTo(EscribirFecNacimiento.correctly(nacimiento));
    }

    @And("selecciona su genero: {string}")
    public void seleccionaSuGenero(String genero) {
        theActorInTheSpotlight().attemptsTo(SelectGenero.correctly(genero));
    }

    @And("selecciona tipo de documentos: {string}")
    public void seleccionaTipoDeDocumentos(String documento) {
        theActorInTheSpotlight().attemptsTo(SelectDocumento.correctly(documento));
    }

    @And("ingresa numero de documento: {string}")
    public void ingresaNumeroDeDocumento(String documento) {
        theActorInTheSpotlight().attemptsTo(EscribirDocumento.correctly(documento));
    }

    @And("ingresa email de contacto: {string}")
    public void ingresaEmailDeContacto(String email) {
        theActorInTheSpotlight().attemptsTo(EscribirEmailContacto.correctly(email));
    }

    @And("ingresa numero de contacto: {string}")
    public void ingresaNumeroDeContacto(String nroContacto) {
        theActorInTheSpotlight().attemptsTo(EscribirNroContacto.correctly(nroContacto));
    }

    @And("selecciona el boton guardar")
    public void seleccionaElBotonGuardar() {
        theActorInTheSpotlight().attemptsTo(SelectGuardar.correctly());
    }

    @And("selecciona el boton continuarC")
    public void seleccionaElBotonContinuarC() {
        theActorInTheSpotlight().attemptsTo(SelectContinuarC.correctly());
    }

    @And("selecciona el boton pagar")
    public void seleccionaElBotonPagar() {
        theActorInTheSpotlight().attemptsTo(SelectPagar.correctly());
    }

    @Then("valida confirmacion de compra")
    public void validaConfirmacionDeCompra() {
        theActorInTheSpotlight().should(seeThat(ValidarPrecio.getText(), notNullValue()).because("Pago realizado con éxito"));
    }

    @When("realizar el registro de vuelo")
    public void realizarElRegistroDeVuelo() {
        theActorInTheSpotlight().attemptsTo(RegisterVuelo.correctly());
    }

    @And("realiza el registro de datos")
    public void realizaElRegistroDeDatos() {
        theActorInTheSpotlight().attemptsTo(RegisterPasajero.correctly());
    }

    @When("realizar el registro de vuelo tabla")
    public void realizarElRegistroDeVueloTabla(List<Map<String, String>> vuelo) {
        theActorInTheSpotlight().attemptsTo(
                EscribirOrigen.correctly(vuelo.get(0).get("origen")),
                SelectOrigen.correctly(),
                EscribirDestino.correctly(vuelo.get(0).get("destino")),
                SelectDestino.correctly(),
                SelectFechaIda.correctly(vuelo.get(0).get("fechaIda")),
                SelectFechaVuelta.correctly(vuelo.get(0).get("fechaVuelta")),
                SelectBuscar.correctly(),
                SelectVueloIda.correctly(),
                SelectDetalles.correctly()
        );
    }

    @And("realiza el registro de datos tabla")
    public void realizaElRegistroDeDatosTabla(List<Map<String, String>> pasajero) {
        theActorInTheSpotlight().attemptsTo(
                SelectCerrar.correctly(),
                SelectAgregaVueloIda.correctly(pasajero.get(0).get("categoriaIda")),
                SelectVueloVuelta.correctly(),
                SelectAgregaVueloVuelta.correctly(pasajero.get(0).get("categoriaVuelta")),
                SelectContinuarA.correctly(),
                SelectAsientoIda.correctly(),
                SelectSiguienteVuelo.correctly(),
                SelectAsientoVuelta.correctly(),
                SelectConfirmar.correctly(),
                SelectContinuarB.correctly(),
                EscribirNombres.correctly(pasajero.get(0).get("nombres")),
                EscribirApellidos.correctly(pasajero.get(0).get("apellidos")),
                EscribirFecNacimiento.correctly(pasajero.get(0).get("nacimiento")),
                SelectGenero.correctly(pasajero.get(0).get("genero")),
                SelectDocumento.correctly(pasajero.get(0).get("tipoDocumento")),
                EscribirDocumento.correctly(pasajero.get(0).get("documento")),
                EscribirEmailContacto.correctly(pasajero.get(0).get("email")),
                EscribirNroContacto.correctly(pasajero.get(0).get("numero")),
                SelectGuardar.correctly(),
                SelectContinuarC.correctly(),
                SelectPagar.correctly()
        );
    }

    @Given("que Omar ingresa a la web de Latam para el registro")
    public void queOmarIngresaALaWebDeLatamParaElRegistro(Actor actor) {
        actor.wasAbleTo(NavigateToWebPage.WebPage());
        //actor.can(RegisterVueloAbilities.withData("Lima","Cusco",));
    }

    @When("ingresa a seccion de registo")
    public void ingresaASeccionDeRegisto() {
        theActorInTheSpotlight().attemptsTo(ClickOnButton.correctly());
        theActorInTheSpotlight().attemptsTo(ClickOnButtonCreateAccount.correctly());
        theActorInTheSpotlight().attemptsTo(EscribirNumeroDocumento.correctly("71401090"));

    }


}