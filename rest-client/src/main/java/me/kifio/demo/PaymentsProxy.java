package me.kifio.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PaymentsProxy {

    private final WebClient webClient;

    public PaymentsProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> createPayment(
            String requestId
    ) {
        return webClient
                .post()
                .uri("http://localhost:8080/payment")
                .header("requestId", requestId)
                .retrieve()
                .bodyToMono(String.class);
    }
}
