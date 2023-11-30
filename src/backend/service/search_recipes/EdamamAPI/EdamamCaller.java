package backend.service.search_recipes.EdamamAPI;

import backend.service.search_recipes.application_business_rules.API_Interface.APICaller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EdamamCaller implements APICaller {
    @Override
    public String execute(String pullRequestURL) {
        try {
            URL url = new URL(pullRequestURL);

            // Open the connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Get the response
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder responseContent = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                responseContent.append(inputLine);
            }
            in.close();

            return responseContent.toString();

        } catch (Exception e) {
            return "no results";
        }
    }
}