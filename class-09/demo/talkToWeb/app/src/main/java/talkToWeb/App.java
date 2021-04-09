/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package talkToWeb;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.security.cert.TrustAnchor;

public class App {


    public static void main(String[] args) {

        String apiURL = "http://numbersapi.com/random/trivia?json";

        try {
            URL url = new URL(apiURL);
            String jsonData = getJsonFromAPI(url);
            TriviaNumber triviaNumber = getTriviaNumberAsObject(jsonData);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static String getJsonFromAPI(URL url) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int status = connection.getResponseCode();
        String content = "";
        if(status == 200) {
            BufferedReader reader = getBufferedReader(connection);
            content = getContent(reader);
            reader.close();
        } else{
            System.out.println("Error in the API");
        }

        connection.disconnect();

        return content;
    }

    private static String getContent(BufferedReader reader) throws IOException {    //String vs StringBuilder
        StringBuilder builder = new StringBuilder();
        String currentLine = reader.readLine();

        while(currentLine != null){
            builder.append(currentLine);
            currentLine = reader.readLine();
        }
        return builder.toString();
    }

    private static BufferedReader getBufferedReader(HttpURLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        return new BufferedReader(inputStreamReader);
    }


    private static TriviaNumber getTriviaNumberAsObject(String jsonData) {
        Gson gson = new Gson();
        TriviaNumber triviaNumber = gson.fromJson(jsonData, TriviaNumber.class);
        return triviaNumber;
    }
}
