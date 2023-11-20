package com.thehecklers.kcmspringai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
public class AppConfig {
    @Bean
    public WebClient client(@Value("${openai.baseurl}") String baseUrl,
            @Value("${OPEN_AI_KEY}") String apiKey) {
        return WebClient.builder()
//                .baseUrl("https://api.openai.com/v1")
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }

    @Bean
    public OpenAIInterface openAIInterface(WebClient client) {
        return HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client))
                .blockTimeout(Duration.of(2, ChronoUnit.MINUTES))
                .build()
                .createClient(OpenAIInterface.class);
    }
}
