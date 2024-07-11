package com.everis.base.abilities.mercadoLibre;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import util.exceptions.CannotAuthenticateException;

public class RegisterVueloAbilities implements Ability {

    private final String origen;
    private final String destino;
    private final String fechaIda;
    private final String fechaVuelta;

    public String origen() {
        return origen;
    }

    public String destino() {
        return destino;
    }

    public String fechaIda() {
        return fechaIda;
    }

    public String fechaVuelta() {
        return fechaVuelta;
    }

    public RegisterVueloAbilities(String origen, String destino, String fechaIda, String fechaVuelta) {
        this.origen = origen;
        this.destino = destino;
        this.fechaIda = fechaIda;
        this.fechaVuelta = fechaVuelta;
    }

    @Override
    public String toString() {
        return "RegisterVueloAbilities{" +
                "origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", fechaIda='" + fechaIda + '\'' +
                ", fechaVuelta='" + fechaVuelta + '\'' +
                '}';
    }

    public static RegisterVueloAbilities withData(String origen, String destino, String fechaIda, String fechaVuelta) {
        return new RegisterVueloAbilities(origen, destino, fechaIda, fechaVuelta);
    }

    public static RegisterVueloAbilities as(Actor actor) {
        if (actor.abilityTo(RegisterVueloAbilities.class) == null) {
            throw new CannotAuthenticateException(actor.getName());
        }
        return actor.abilityTo(RegisterVueloAbilities.class);
    }
}
