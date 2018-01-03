package com.nz2dev.wordtrainer.app.utils.helpers;

/**
 * Created by nz2Dev on 10.12.2017
 */
public class ErrorsDescriber {

    public static String describe(Throwable throwable) {
        // it's possible to decide what message to return looking on appropriate type of throwable there
        // for example:
        // if (throwable instanceof NoInternetConnection) {
        //    return "No internet connection, torn it ON";
        // }
        // or alternative way is to transform this class to singleton instance and contain there instance
        // on Context and fetch string resource file that filter each throwable in other languages.
        return throwable.getMessage();
    }

}