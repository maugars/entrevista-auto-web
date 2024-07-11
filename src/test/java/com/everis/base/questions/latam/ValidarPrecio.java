package com.everis.base.questions.latam;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarPrecio implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return LatamPage.lblValidarPrecio.resolveFor(actor).getText();
    }

    public static ValidarPrecio getText() {
        return new ValidarPrecio();
    }
}
