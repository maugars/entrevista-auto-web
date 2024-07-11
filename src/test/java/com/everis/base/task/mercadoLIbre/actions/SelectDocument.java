package com.everis.base.task.mercadoLIbre.actions;

import com.everis.base.page.MercadoLibrePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectDocument implements Task {

    private static String type;

    public synchronized static void setType(String type) {
        SelectDocument.type = type;
    }

    public SelectDocument(String type) {
        setType(type);
    }

    public static SelectDocument typeDNI() {
        return instrumented(SelectDocument.class, "DNI");
    }

    public static SelectDocument typeCE() {
        return instrumented(SelectDocument.class, "C.E");
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                SelectFromOptions.byVisibleText(type).from(MercadoLibrePage.tipoDocumento));
    }
}
