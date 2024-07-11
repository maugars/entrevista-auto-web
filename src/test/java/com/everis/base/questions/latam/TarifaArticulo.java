package com.everis.base.questions.latam;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TarifaArticulo implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return LatamPage.lblArticulo.resolveFor(actor).getText();
    }

    public static TarifaArticulo getText() {
        return new TarifaArticulo();
    }
}
