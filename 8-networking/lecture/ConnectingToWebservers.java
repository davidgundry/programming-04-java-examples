import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ConnectingToWebservers {
  public static void main(String[] args) {

    try {
        URL url = new URI("https://programming04.netlify.app").toURL();
        URLConnection urlConnection = url.openConnection();
        Scanner s = new Scanner(urlConnection.getInputStream());
        while(s.hasNext())
            System.out.println(s.nextLine());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }
}