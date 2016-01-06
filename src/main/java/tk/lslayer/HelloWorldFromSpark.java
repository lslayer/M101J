package tk.lslayer;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by vgogilchyn on 1/6/2016.
 */
public class HelloWorldFromSpark {
    public static void main(String[] args) {
        Spark.get("/hw", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                return "Hello world";
            }
        });
    }
}
