package com.example.android.jokes_supply;

import com.example.android.jokeslibrary.JokesFactory;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;

/**
 * Created by Dawid on 2017-06-04.
 */
@Api(
        name = "myApi",
        version = "v2",
        namespace = @ApiNamespace(
                ownerDomain = "jokes-supply.gradleautomation.android.mobileallin.com",
                ownerName = "jokes-supply.gradleautomation.android.mobileallin.com",
                packagePath = ""
        )
)

public class JokesEndpoint {

    /**
     * Endpoint method that takes a name and displays welcome message
     */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setJokesData("Welcome, " + name + " have fun!");

        return response;
    }

    @ApiMethod(name = "tellRandomJoke")
    public MyBean tellRandomJoke() {
        MyBean response = new MyBean();
        response.setJokesData(JokesFactory.randomJoke());

        return response;
    }

    @ApiMethod(name = "testMethod")
    public MyBean testMethod (){
        return new MyBean();
    }
}
