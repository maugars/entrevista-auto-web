package com.everis.base.task.latam.actions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarFechaVuelo implements Task {

    private static String fecha;
    private static String dia;

    public synchronized static void setFecha(String fecha) {
        SeleccionarFechaVuelo.fecha = fecha;
    }
    public synchronized static void setDia(String dia) {
        SeleccionarFechaVuelo.dia = dia;
    }

  /*  public SeleccionarFechaVuelo(String fecha, String dia) {
        setFecha(fecha);
        setDia(dia);
    }
*/
    public static SeleccionarFechaVuelo withData(String fecha, String dia) {
        setFecha(fecha);
        setDia(dia);
        return instrumented(SeleccionarFechaVuelo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {

            Thread.sleep(10000);
        }
        catch (Exception e){
            System.out.println(e);
        }
       WebElement element= Serenity.getDriver().findElement(By.xpath("//*[contains(text(), '"+fecha+" 2024')]/../..//*[text()='"+dia+"']"));
        element.click();


    }
}
