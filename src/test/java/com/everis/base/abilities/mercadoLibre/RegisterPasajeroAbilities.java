package com.everis.base.abilities.mercadoLibre;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import util.exceptions.CannotAuthenticateException;

public class RegisterPasajeroAbilities implements Ability {

    private final String catIda;
    private final String catVuelta;
    private final String nombres;
    private final String apellidos;
    private final String nacimiento;
    private final String genero;
    private final String tipoDocumento;
    private final String documento;
    private final String email;
    private final String numero;

    public String catIda() {
        return catIda;
    }

    public String catVuelta() {
        return catVuelta;
    }

    public String nombres() {
        return nombres;
    }

    public String apellidos() {
        return apellidos;
    }

    public String nacimiento() {
        return nacimiento;
    }

    public String genero() {
        return genero;
    }

    public String tipoDocumento() {
        return tipoDocumento;
    }

    public String documento() {
        return documento;
    }

    public String email() {
        return email;
    }

    public String numero() {
        return numero;
    }

    public RegisterPasajeroAbilities(String catIda, String catVuelta, String nombres, String apellidos, String nacimiento, String genero,
                                     String tipoDocumento, String documento, String email, String numero) {
        this.catIda = catIda;
        this.catVuelta = catVuelta;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.genero = genero;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.email = email;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "RegisterPasajeroAbilities{" +
                "catIda='" + catIda + '\'' +
                ", catVuelta='" + catVuelta + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nacimiento='" + nacimiento + '\'' +
                ", genero='" + genero + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", documento='" + documento + '\'' +
                ", email='" + email + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }

    public static RegisterPasajeroAbilities withData(String catIda, String catVuelta, String nombres, String apellidos,
                                                     String nacimiento, String genero, String tipoDocumento, String documento, String email, String numero) {
        return new RegisterPasajeroAbilities(catIda, catVuelta, nombres, apellidos, nacimiento, genero, tipoDocumento, documento, email, numero);
    }

    public static RegisterPasajeroAbilities as(Actor actor) {
        if (actor.abilityTo(RegisterPasajeroAbilities.class) == null) {
            throw new CannotAuthenticateException(actor.getName());
        }
        return actor.abilityTo(RegisterPasajeroAbilities.class);
    }
}
