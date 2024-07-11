@LATAM
Feature: Registro de vuelo en LATAM

  @SCREENPLAY1
  Scenario: Usuario realiza registro de vuelo en la web A
    Given que Omar ingresa a la web de LATAM
    When ingresa origen: "Lima"
    And  selecciona la primera opcion origen
    And ingresa destino: "Cusco"
    And selecciona la primera opcion destino
    And selecciona fecha de ida: "14 de junio"
    And selecciona fecha de vuelta: "20 de junio"
    And selecciona el boton de buscar
    And selecciona vuelo de ida Recomendado
    And selecciona detalles de tarifa PremiumEconomy
    And valida detalles de tarifa
    And selecciona boton cerrar
    And selecciona categoria ida: "TOP"
    And selecciona vuelo de vuelta Recomendado
    And selecciona categoria vuelta: "PLUS"
    And selecciona el boton continuarA
    And selecciona asiento de ida disponible
    And selecciona el boton siguiente vuelo
    And selecciona asiento de vuelta disponible
    And selecciona el boton confirmar
    And selecciona el boton continuarB
    And ingresa sus nombres: "Omar Arturo"
    And ingresa sus apellidos: "Anticona Cruz"
    And ingresa su fecha de nacimiento: "04-08-1990"
    And selecciona su genero: "MALE"
    And selecciona tipo de documentos: "DNI"
    And ingresa numero de documento: "71053913"
    And ingresa email de contacto: "oanticon@gmail.com"
    And ingresa numero de contacto: "981355917"
    And selecciona el boton guardar
    And selecciona el boton continuarC
    And selecciona el boton pagar
    Then valida confirmacion de compra

  @SCREENPLAY2
  Scenario: Usuario realiza registro de vuelo en la web B
    Given que Omar ingresa a la web de LATAM
    When realizar el registro de vuelo
    And valida detalles de tarifa
    And realiza el registro de datos
    Then valida confirmacion de compra

  @SCREENPLAY3
  Scenario: Usuario realiza registro de vuelo en la web C
    Given que Omar ingresa a la web de LATAM
    When realizar el registro de vuelo tabla
      | origen | destino | fechaIda    | fechaVuelta |
      | Lima   | Cusco   | 14 de junio | 20 de junio |
    And valida detalles de tarifa
    And realiza el registro de datos tabla
      | categoriaIda | categoriaVuelta | nombres     | apellidos     | nacimiento | genero | tipoDocumento | documento | email              | numero    |
      | TOP          | PLUS            | Omar Arturo | Anticona Cruz | 04-08-1990 | MALE   | DNI           | 71053913  | oanticon@gmail.com | 981355917 |
    Then valida confirmacion de compra

    @Registro
    Scenario: Usuario se registra en latam
      Given que Omar ingresa a la web de Latam para el registro
      When ingresa a seccion de registo