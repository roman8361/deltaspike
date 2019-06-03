package ru.kravchenko.deltaspike;

import lombok.NonNull;
import ru.kravchenko.deltaspike.bootstrap.Bootstrap;

import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.inject.spi.CDI;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        SeContainerInitializer.newInstance().addPackages(App.class).initialize();

        @NonNull final Bootstrap bootstrap = CDI.current().select(Bootstrap.class).get();
        bootstrap.init();

    }

}
