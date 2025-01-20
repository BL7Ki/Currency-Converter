package com.example.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper; 
// Facilita o trabalho com JSON, convertendo automaticamente entre objetos Java e JSON.

public class ApiClient {
    public static Map<String, Object> obterTaxasDeCambio(String moedaBase) throws Exception {
        String url = CurrencyConverter.URL_API + moedaBase; // https://api.exchangerate-api.com/v4/latest/USD exemplo

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();

        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
        if (resposta.statusCode() != 200) {
            throw new Exception("Falha ao acessar a API. Código: " + resposta.statusCode());
        }

        // Usando Jackson para processar JSON
        ObjectMapper mapeador = new ObjectMapper();
        Map<String, Object> respostaJson = mapeador.readValue(resposta.body(), HashMap.class);
        return (Map<String, Object>) respostaJson.get("rates");
    }
}
