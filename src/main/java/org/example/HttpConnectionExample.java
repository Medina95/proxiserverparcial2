package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class HttpConnectionExample {

    private static final String USER_AGENT = "Mozilla/5.0";

    private static int roundrobin=0;

    private static List<String> dominios = Arrays.asList("54.175.189.94:4587","54.82.155.172:4587");
    private static final String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=fb&apikey=Q1QZFVJQ21K7C6XM";

    public static String getResponse(String valor, String operacion, String lista) throws IOException{

        String dominio = dominios.get(roundrobin);

        URL obj = new URL(("http://"+dominio+operacion+"?list="+lista+"&value="+valor)) ;
        System.out.println("Te atendio la maquina ec2 "+dominio);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        String responsestring =  "Error";

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            responsestring= response.toString();
            // print result
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        roundrobin= (roundrobin+1)%(dominios.size());
        return responsestring;
    }


}
