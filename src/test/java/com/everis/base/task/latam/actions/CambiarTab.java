package com.everis.base.task.latam.actions;

import com.everis.base.page.LatamPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.ArrayList;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CambiarTab implements Task {

    private static int numTab;

    public synchronized static void setNumTab(int numTab) {
        CambiarTab.numTab = numTab;
    }

    public CambiarTab(int tab) {
        setNumTab(tab);
    }

    public static CambiarTab correctly(int tab) {
        return instrumented(CambiarTab.class, tab);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
      try
      {
          Thread.sleep(5000);
      }catch (Exception e){
          System.out.println(e);
      }
      //  Serenity.getDriver().switchTo().window("Selección de vuelos | LATAM Airlines");
        ArrayList<String> tabs = new ArrayList<String> (Serenity.getDriver().getWindowHandles());
        Serenity.getDriver().switchTo().window(tabs.get(numTab));


    }
}
