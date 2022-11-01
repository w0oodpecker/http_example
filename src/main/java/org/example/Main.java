package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {

        String url = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();


        HttpGet request = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(request);

        //Arrays.stream(response.getAllHeaders()).forEach(System.out::println);
        String body = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
        //System.out.println(body);

        Gson gson = new Gson();
        Type factOfCatType = new TypeToken<ArrayList<FactOfCat>>() {
        }.getType();
        List<FactOfCat> factOfCatList = gson.fromJson(body, factOfCatType);
        List<FactOfCat> tmp = factOfCatList.stream().filter(value -> value.getUpvotes() != null && value.getUpvotes() == 0).toList();
        System.out.println(tmp.toString());
    }
}