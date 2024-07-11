package com.everis.base.task.latam.actions;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateToWebPage {

    public static Performable WebPage() {
        return Task.where("{0} abre la pagina de Latam", Open.browserOn().the(LatamPage.class));
    }
}
