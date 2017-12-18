package com.monzag;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MainHandler implements HttpHandler {

    public void handle(HttpExchange httpExchange) throws IOException {

        String path = httpExchange.getRequestURI().getPath();

        try {
            Class controller = Controller.class;

            for (Method method: controller.getDeclaredMethods()) {
                if (method.isAnnotationPresent(WebRoute.class)) {
                    Annotation annotation = method.getAnnotation(WebRoute.class);
                    WebRoute route = (WebRoute) annotation;

                    if (path.equals(route.value())) {
                        method.invoke(controller.newInstance(), httpExchange);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
