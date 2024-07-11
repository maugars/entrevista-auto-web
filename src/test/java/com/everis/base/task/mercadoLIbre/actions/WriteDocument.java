package com.everis.base.task.mercadoLIbre.actions;

import com.everis.base.page.MercadoLibrePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WriteDocument implements Task {

    private static String document;

    public synchronized static void setDocument(String document) {
        WriteDocument.document = document;
    }

    public WriteDocument(String document) {
        setDocument(document);
    }

    public static WriteDocument correctly(String document) {
        return instrumented(WriteDocument.class, document);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Enter.theValue(document).into(MercadoLibrePage.writeDocumento));

    }
}
