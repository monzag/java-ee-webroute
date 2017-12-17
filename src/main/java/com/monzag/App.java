package com.monzag;

import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class App
{
    public static void main( String[] args ) throws Exception
    {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        try {
            server.createContext("/", new MainHandler());
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
