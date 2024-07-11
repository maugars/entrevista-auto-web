package com.everis.base.stepDefinitions;

import com.everis.base.task.mercadoLIbre.NavigateToML;
import com.everis.base.task.mercadoLIbre.actions.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BuscarProdutoSD {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que {actor} esta en la pagina principal de la tienda de Mercadolibre")
    public void que_Jesus_Esta_En_La_Pagina_Principal_De_La_Tienda_De_Mercadolibre(Actor actor) {
        actor.wasAbleTo(NavigateToML.theMercadoLibrePage());
    }

    @When("ingresa el producto {string} en el campo de búsqueda")
    public void ingresa_El_Producto_En_El_Campo_De_Búsqueda(String producto) {
        theActorInTheSpotlight().attemptsTo(WriteProducto.correctly(producto));
    }

    @And("selecciona el boton buscar")
    public void selecciona_El_Boton_Buscar() {
        theActorInTheSpotlight().attemptsTo(SelectBuscar.altaOption());
    }

    @And("selecciona el primer ítem de la lista de resultados")
    public void selecciona_El_Primer_Ítem_De_La_Lista_De_Resultados() {
        theActorInTheSpotlight().attemptsTo(SelectProducto.altaOption());
    }


}
