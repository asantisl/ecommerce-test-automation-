package com.ecommerce.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WaitImplicitly implements Interaction {
    private final int seconds;

    public WaitImplicitly(int seconds) {
        this.seconds = seconds;
    }

    public static Performable withSeconds(int seconds) {
        return instrumented(WaitImplicitly.class, seconds);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

