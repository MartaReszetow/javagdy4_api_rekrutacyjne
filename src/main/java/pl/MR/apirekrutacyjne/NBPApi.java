package pl.MR.apirekrutacyjne;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NBPApi {

    private final static String API_BID_ASK_ENDPOINT = "http://api.nbp.pl/api/exchangerates/rates/C/{currency}/{startDate}/{endDate}/?format=json";

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();


    public void requestBidAskRates(NBPApiParameters parameters) {
        String requestURl = prepareRequestURL(parameters);
        System.out.println("Request URL:" + requestURl);

        HttpRequest request = HttpRequest.newBuilder()      // stworz zapytanie
                .GET()                                      // typu get
                .uri(URI.create(requestURl))                // na adres
                .build();                                   // sfinalizuj stworzenie obiektu


        try {
            //wyśij zapytanie
            // spodziewamy sie odpowiedzi w postaci Stringa (bodyhandlers)
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // jeśli zapytanie sie powiedzie
            if (response.statusCode() == 200) {
                System.out.println("Response:" + response.body());
            } else {
                System.err.println("Error:" + response.statusCode());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            }


    private String prepareRequestURL(NBPApiParameters parameters) {
        return API_BID_ASK_ENDPOINT
                .replaceAll("\\{currency\\}", parameters.getCurrency().getShortName())
                .replaceAll("\\{startDate\\}", parameters.getStartDate().toString())
                .replaceAll("\\{endDate\\}", parameters.getEndDate().toString());
    }


}

