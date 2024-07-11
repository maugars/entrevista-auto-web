package com.everis.base.task.mercadoLIbre.actions;

import com.everis.base.page.MercadoLibrePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CheckTerminos implements Task {

    public static CheckTerminos accepted() {
        return instrumented(CheckTerminos.class, "");
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                JavaScriptClick.on(MercadoLibrePage.checkTerminos)
        );
    }
}
