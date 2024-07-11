package com.everis.base.task.latam;

import com.everis.base.page.LatamPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateToLatam {

    public static Performable LatamWebPage() {
        return Task.where("{0} opens Latam Web page", Open.browserOn().the(LatamPage.class));
    }
}
