package br.com.alura.projetos.conversorDeMoedas.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyConverter {
    public static float convertCurrency(String baseCurrency , String targetCurrency , float amount){

        float result = 0;
        try{
            String uri = "https://v6.exchangerate-api.com/v6/4f933d85f1192df2f996312d/pair/" +
                    baseCurrency + "/" + targetCurrency + "/" + amount;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
            HttpResponse<String> response = client.send(request , HttpResponse.BodyHandlers.ofString());

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

            ExchangeRateData data = gson.fromJson(response.body() , ExchangeRateData.class);

            result = data.conversionResult();

        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return result;
    }
}
