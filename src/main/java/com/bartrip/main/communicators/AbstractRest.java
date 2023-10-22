package com.bartrip.main.communicators;

import java.util.Map;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import io.netty.channel.ChannelOption;
import reactor.netty.http.client.HttpClient;
//TODO : Продумать схему общения
public abstract class AbstractRest {

    protected int BASE_TIMEOUT = 10000;


    protected WebClient webClient;

    protected WebClient createWebClient(String url) {

        return WebClient.builder()
                .baseUrl(url)
                .clientConnector(new ReactorClientHttpConnector(
                        HttpClient
                                .newConnection()
                                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, BASE_TIMEOUT)

                ))

                .build();
    }


    protected ResponseSpec get(Map<String,Object> params) {
        return webClient.get().uri("/").retrieve();
    }


}
