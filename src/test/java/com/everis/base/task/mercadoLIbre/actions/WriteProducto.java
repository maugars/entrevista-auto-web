package com.everis.base.task.mercadoLIbre.actions;

import com.everis.base.page.MercadoLibrePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WriteProducto implements Task {
    private static String name;

    public synchronized static void setName(String name) {
        WriteProducto.name = name;
    }

    public WriteProducto(String name) {
        setName(name);
    }

    public static WriteProducto correctly(String name) {
        return instrumented(WriteProducto.class, name);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Enter.theValue(name).into(MercadoLibrePage.textoBuscar));

    }
}
