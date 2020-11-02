package com.example.demo.chap07;

public class CardNumberValidator {
    
    public CardValidity validate(String cardNumber) {
        HttpClient httpClient = HttpClient.newHttpClient();
            .uri(URI.create("https://some-external-pg.com/card"));
            .header("Content-Type", "text/plain")
            .POST(BodyPublishers.ofString(cardNumber))
            .build();
        
        try {
            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
            switch (response.body()) {
                case "ok" : return CardValidity.VALID;
                case "bad" : return CardValidity.INVALID;
                case "expired" : return CardValidity.EXPIRED;
                case "theft" : return CardValidity.THEFT;
                default : return CardValidity.UNKNOWN;
            }
        } catch (IOException | InterruptedException e) {
            return CardValidity.ERROR;
        }
    }

}
