package com.ecommerce.runners;

import io.cucumber.junit.CucumberOptions;
//import mainframe.com.bdd.util.UtilMainframe;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.cucumber.CucumberWithSerenity;

import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

import static net.serenitybdd.annotations.ClearCookiesPolicy.BeforeEachTest;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        //plugin = {"json:target/build/cucumber.json"},
        features = "src/test/resources/features",
        glue = "com.ecommerce.stepDefinitions",
        tags = "@ESC05_CLIENTE_"
)

public class TestRunner {
    @Managed(uniqueSession = true, clearCookies = BeforeEachTest)
    WebDriver driver;

    @BeforeClass
    public static void beforeAll() {
        Logger.getLogger(TestRunner.class.getName()).info("Before all execution >>>");
    }

    public static final String WELCOME =

            " #######     ###     ######   ######   #######   ######   ######   ######## \n" +
            " ##    ##   ## ##    ##         ##     ##          ##     ##       ##    ## \n" +
            " ##    ##  ##   ##   ##         ##     ##          ##     ##       ##    ## \n" +
            " ######    ##   ##   ##         ##     #####       ##     ##       ##    ## \n" +
            " ##        #######   ##         ##     ##          ##     ##       ##    ## \n" +
            " ##        ##   ##   ##         ##     ##          ##     ##       ##    ## \n" +
            " ##        ##   ##   ######   ######   ##        ######   ######   ######## \n" +
            "==================================================================================\n" +
            "                                                                                 \n";

   /*@BeforeClass
   public static void messages() {
        System.out.println(ANSI_GREEN + WELCOME + ANSI_GREEN);
    }*/

//    @AfterClass
//    public static void message() {
//        System.out.println(ANSI_GREEN + WELCOME + ANSI_GREEN);
//    }


    /*@AfterClass
    public static void afterAll(){
        System.out.println(ANSI_GREEN + WELCOME + ANSI_GREEN);
        Logger.getLogger(TestRunner.class.getName()).info("After all execution >>>");
        String cucumberJsonPath = "/target/build/cucumber.json";
        boolean isJiraOn = Boolean.parseBoolean(EnvironmentSpecificConfiguration.from(envs).getProperty("jira.xray.update.evidence"));

        if (isJiraOn){
            Logger.getLogger(TestRunner.class.getName()).info("Actualizando resultados en Jira Xray");
            JiraXrayIntegration.importCucumberResult(cucumberJsonPath);
        }
        else{
            Logger.getLogger(TestRunner.class.getName()).info("No se actualizaron los resultados en Jira Xray");
        }
    }*/
}
