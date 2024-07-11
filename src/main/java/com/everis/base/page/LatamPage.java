package com.everis.base.page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

@DefaultUrl("https://www.latamairlines.com/pe/es")
public class LatamPage extends PageObject {

    public static final Target CrearCuenta = Target.the("elemento crear cuenta")
            .located(By.id("secondary-button"));
    public static final Target InicioSesion = Target.the("elemento inicio sesion")
            .located(By.id("header__profile__lnk-sign-in"));

    public static final Target txtOrigen = Target.the("campo de origen")
            .located(By.id("txtInputOrigin_field"));

    public static final Target lstOrigen = Target.the("lista origen")
            .located(By.id("btnItemAutoComplete_0"));

    public static final Target txtDestino = Target.the("campo destino")
            .located(By.id("txtInputDestination_field"));

    public static final Target lstDestino = Target.the("lista destino")
            .located(By.id("btnItemAutoComplete_0"));

    public static final Target txtIda = Target.the("campo fecha de ida")
            .located(By.id("departureDate"));

    public static final Target lstIda = Target.the("seleccionar fecha de ida")
            .located(By.xpath("//*[contains(@aria-label,' 14 de junio')]"));//-----------------------------------------------


    public static final Target txtFecha = Target.the("seleccionar fecha de ida")
            .located(By.xpath("//*[@id='inputSection']/form/div/div[3]/div/div[1]"));//-----------------------------------------------
    public static final Target lstVuelta = Target.the("seleccionar fecha de vuelta")
            .located(By.xpath("//*[contains(@aria-label,' 20 de junio')]"));//------------------------------------------------

    public static final Target btnBuscar = Target.the("boton de buscar")
            .located(By.id("btnSearchCTA"));

    public static final Target lstVueloIda = Target.the("seleccionar vuelo de ida recomendado")
            .located(By.xpath("//*[@id='WrapperCardFlight0']/div"));

    public static final Target linkDetalles = Target.the("Link detalles de tarifa")
            .located(By.xpath("//*[@id='bundle-detail-2-flight-select']"));

    //QUESTIONS DETALLE TARIFA
    public static final Target lblAsiento = Target.the("Asiento")
            .located(By.xpath("//span[contains(text(),'Asiento del medio bloqueado')]"));

    public static final Target lblMenu = Target.the("menu")
            .located(By.xpath("//span[contains(text(),'Disfruta de un excelente menú')]"));

    public static final Target lblEquipaje = Target.the("equipaje")
            .located(By.xpath("//span[contains(text(),'1 equipaje de mano')]"));

    public static final Target lblArticulo = Target.the("articulo")
            .located(By.xpath("//span[contains(text(),'Artículo personal')]"));

    public static final Target lblBodega = Target.the("bodega")
            .located(By.xpath("//span[contains(text(),'3 equipajes de bodega')]"));

    public static final Target lblSeleccion = Target.the("seleccion")
            .located(By.xpath("//span[contains(text(),'Selección de asiento')]"));
    //----------------------------------------------------------------------------------------

    public static final Target btnCerrar = Target.the("boton cerrar")
            .located(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root sc-jwKygS bngFCS']"));

    public static final Target lstAgregarVueloIda = Target.the("agregar vuelo de ida premium")
            .located(By.xpath("//li[@class='sc-jbWsrJ eSNJcs'][4]//span[contains(text(),'TOP')]"));//-----------------------------

    //---------------Validacion interna --------------------------
    public static final Target lblResumen = Target.the("seleccion")
            .located(By.xpath("//strong[contains(text(),'vuelo de vuelta')]"));
    //------------------------------------------------------------

    public static final Target lstVueloVuelta = Target.the("seleccionar vuelo de vuelta recomendado")
            .located(By.xpath("//li[@class='sc-gFXMyG lgyLMd'][1]//span[contains(text(),'CUZ')]"));

    public static final Target lstAgregarVueloVuelta = Target.the("agregar vuelo de vuelta plus")
            .located(By.xpath("//li[@class='sc-jbWsrJ eSNJcs'][3]//span[contains(text(),'PLUS')]"));//--------------------------------

    public static final Target btnContinuarA = Target.the("click en boton continuarA")
            .located(By.xpath("//span[contains(text(),'Continuar')]"));

    //---------------Validacion interna --------------------------
    public static final Target lblAsientoIda = Target.the("Validacion de Asiento ida")
            .located(By.xpath("//*[(@class='IndicatorSeat__IndicatorBox-sc-1q36z6f-1 ewqHXn')]"));
    //------------------------------------------------------------

    public static final Target btnAsientoIda = Target.the("click en asiento ida")
            .located(By.xpath("//button[contains(@aria-label,'`2A`')][@data-available='true']"));

    public static final Target btnSiguienteVuelo = Target.the("boton siguiente vuelo")
            .located(By.id("btn-next-flight"));

    //---------------Validacion interna --------------------------
    public static final Target lblAsientoVuelta = Target.the("Validacion de Asiento vuelta")
            .located(By.xpath("//*[(@class='IndicatorSeat__IndicatorBox-sc-1q36z6f-1 ewqHXn')]"));
    //------------------------------------------------------------

    public static final Target btnAsientoVuelta = Target.the("click en asiento vuelta")
            .located(By.xpath("//button[contains(@aria-label,'`5A`')][@data-available='true']"));

    public static final Target btnConfirmar = Target.the("boton confirmar")
            .located(By.xpath("//button[@id='btn-confirm-and-continue']//span[@class='MuiButton-label']"));

    public static final Target btnContinuarB = Target.the("click en continuarB")
            .located(By.id("button-cart-confirm"));

    public static final Target txtNombres = Target.the("escribir nombres")
            .located(By.id("passengerDetails-firstName-ADT_1"));

    public static final Target txtApellidos = Target.the("escribir apellidos")
            .located(By.id("passengerDetails-lastName-ADT_1"));

    public static final Target txtFecNacimiento = Target.the("escribir nacimiento")
            .located(By.id("passengerInfo-dateOfBirth-ADT_1"));

    public static final Target cboGenero = Target.the("click en genero")
            .located(By.id("mui-component-select-passengerInfo.gender"));

    public static final Target lstGenero = Target.the("seleccionar genero")
            .located(By.xpath("//li[@data-value='MALE']"));//------------------------------------------------------------------

    public static final Target cboDocumento = Target.the("click en documento")
            .located(By.id("mui-component-select-documentInfo.documentType"));

    public static final Target lstDocumento = Target.the("seleccionar documento")
            .located(By.xpath("//li[@data-value='DNI']"));//----------------------------------------------------------

    public static final Target txtDocumento = Target.the("escribir documento")
            .located(By.id("documentInfo-documentNumber-ADT_1"));

    public static final Target txtEmail = Target.the("escribir email")
            .located(By.id("passengerInfo-emails-ADT_1"));

    public static final Target txtNumero = Target.the("escribir numero")
            .located(By.id("passengerInfo-phones0-number-ADT_1"));

    public static final Target btnGuardar = Target.the("click en guardar")
            .located(By.id("passengerFormSubmitButtonADT_1"));

    //---------------Validacion interna --------------------------
    public static final Target lblNombres = Target.the("Validacion de nombres")
            .located(By.xpath("//span[@class='nameText']"));
    //------------------------------------------------------------

    public static final Target btnContinuarC = Target.the("click en boton continuarC")
            .located(By.xpath("//span[contains(text(),'Continuar')]"));

    //---------------Validacion interna --------------------------
    public static final Target lblConfirmacion = Target.the("Validacion confirmacion de compra")
            .located(By.xpath("//h1[contains(text(),'Confirmación de compra')]"));
    //------------------------------------------------------------

    public static final Target btnPagar = Target.the("click en pagar")
            .located(By.id("InlinePayButtonID"));

    public static final Target lblValidarPrecio = Target.the("Validacion de precio final")
            .located(By.xpath("//*[@class='sc-pRStN jTbOhh totalSection']"));
}