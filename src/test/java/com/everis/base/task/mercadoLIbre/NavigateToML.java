package com.everis.base.task.mercadoLIbre;

import com.everis.base.page.MercadoLibrePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateToML {
    public static Performable theMercadoLibrePage() {
        return Task.where("{0} opens Mercado Libre page", Open.browserOn().the(MercadoLibrePage.class));
    }
}
