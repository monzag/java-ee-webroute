package com.monzag;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class Controller {

    String response;

    @WebRoute(value="/")
    public void hello(HttpExchange httpExchange) throws IOException {
        response = "hello";
        sendOKResponse(response, httpExchange);
    }

    @WebRoute(value="/test")
    public void onTest(HttpExchange httpExchange) throws IOException {
        response = "just test";
        sendOKResponse(response, httpExchange);
    }

    @WebRoute(value="/contact")
    public void onContact(HttpExchange httpExchange) throws IOException {
        response = "on contact page";
        sendOKResponse(response, httpExchange);
    }

    public void sendOKResponse(String response, HttpExchange httpExchange) throws IOException{
        final byte[] finalResponseBytes = response.getBytes("UTF-8");
        httpExchange.sendResponseHeaders(200, finalResponseBytes.length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(finalResponseBytes);
        os.close();
    }
}
