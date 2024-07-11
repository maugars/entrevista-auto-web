package com.everis.base.questions.latam;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TarifaBodega implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return LatamPage.lblBodega.resolveFor(actor).getText();
    }

    public static TarifaBodega getText() {
        return new TarifaBodega();
    }
}
