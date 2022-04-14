package com.example.twitter.demo.config;

import com.example.twitter.demo.proxy.twitter.TwitterConnectionApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.Objects;

@EnableScheduling
@Configuration
public class RestClientConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(RestClientConfiguration.class);
    @Value("${com.twitter.demo.twitter.base-url}")
    private String urlTwitterPublic;
    @Value("${com.twitter.demo.twitter.token}")
    private String twitterToken;

    private Retrofit retrofitApiGatewayTwitter;

    private void apiGatewayCustomerRetroFitConfiguration() {
        this.retrofitApiGatewayTwitter = this.retroFitConfiguration(urlTwitterPublic);
    }

    @Bean
    TwitterConnectionApi twitterApi() {
        if (Objects.isNull(retrofitApiGatewayTwitter)) {
            this.apiGatewayCustomerRetroFitConfiguration();
        }
        return retrofitApiGatewayTwitter.create(TwitterConnectionApi.class);
    }

    private Retrofit retroFitConfiguration(String url) {
        LOG.info("Cargando configuracion para conexion a twitter...");

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}
