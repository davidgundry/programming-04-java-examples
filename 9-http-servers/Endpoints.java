import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Endpoints {
    public static void main(String[] args)
    {
        InetSocketAddress port = new InetSocketAddress(8080);
        try {
            HttpServer server = HttpServer.create(port, 0);
            server.setExecutor(Executors.newCachedThreadPool());

            server.createContext("/dogs/list", new DogsListHandler());
            server.createContext("/dogs/photo", new DogsPhotoHandler());
            server.start();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

/**
 * Implements the `dogs/list/` endpoint. Returns a JSON document
 * listing all of the dogs in the database
 * 
 * [{
 *      "name": "Fido",
 *      "breed": "Dachshund"
 *      "photo": "example.com/dogs/photo/324235"
 *  }]
 */
class DogsListHandler implements HttpHandler {
    public void handle(HttpExchange ex) throws IOException {
        InputStream in = ex.getRequestBody();
        OutputStream out = ex.getResponseBody();
        // ...

        // process a GET request
        // check for attributes used for filtering
        // ?breed=
        // ?age=
        // etc.

        // request a list of dogs from our database, filtering
        // based on the filters supplied
        // format that list as JSON
        // return a 400 with the JSON document
    }
}


/**
 * Implements the `dogs/photo/<dog-id>` endpoint. Returns a
 * JPG photo of the dog
 */
class DogsPhotoHandler implements HttpHandler {
    public void handle(HttpExchange ex) throws IOException {
        InputStream in = ex.getRequestBody();
        OutputStream out = ex.getResponseBody();
        // ...

        // process GET request
        // check for `width` and `height` GET attributes

        // If the dog id is valid
        // load the image file from disk
        // resize the image to `width x height`
        // return a 200 with the image in the document body

        // if the dog ID is invalid
        // return a 404
    }


}