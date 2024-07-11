package com.everis.base.abilities.mercadoLibre;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import util.exceptions.CannotAuthenticateException;

public class Register implements Ability {
    @Override
    public String toString() {
        return "Register{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private final String name;
    private final String lastName;
    private final String email;
    private final String documentNumber;
    private final String password;

    public String name() {
        return name;
    }

    public String lastName() {
        return lastName;
    }

    public String email() {
        return email;
    }

    public String documentNumber() {
        return documentNumber;
    }

    public String password() {
        return password;
    }


    // instantiates the Ability and enables fluent DSL
    public static Register withData(String name, String lastName, String email, String documentNumber, String password) {
        return new Register(name, lastName, email, documentNumber, password);
    }


    public static Register as(Actor actor) {
        // complain if someone's asking the impossible
        if (actor.abilityTo(Register.class) == null) {
            throw new CannotAuthenticateException(actor.getName());
        }

        return actor.abilityTo(Register.class);
    }

    public Register(String name, String lastName, String email, String documentNumber, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.documentNumber = documentNumber;
        this.password = password;
    }
}
