package com.everis.base.questions.latam;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TarifaSeleccion implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return LatamPage.lblSeleccion.resolveFor(actor).getText();
    }

    public static TarifaSeleccion getText() {
        return new TarifaSeleccion();
    }
}
