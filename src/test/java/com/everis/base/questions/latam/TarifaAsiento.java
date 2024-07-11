package com.everis.base.questions.latam;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TarifaAsiento implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return LatamPage.lblAsiento.resolveFor(actor).getText();
    }

    public static TarifaAsiento getText() {
        return new TarifaAsiento();
    }
}
