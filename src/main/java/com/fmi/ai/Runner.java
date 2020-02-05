package com.fmi.ai;

import java.io.IOException;

public class Runner {

    public static void main(String... args) throws IOException {
        RestCaller restCaller = new RestCaller();
        WordResult result = restCaller.call("sad"); // contains the result from the api call
        String s = "";
    }
}
