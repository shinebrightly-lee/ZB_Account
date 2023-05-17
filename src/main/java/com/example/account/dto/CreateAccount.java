package com.example.account.dto;

import lombok.*;

import java.time.*;

public class CreateAccount {
    @Getter@Setter
    public static class Request{
        private Long useId;
        private  Long initialBalance;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter@Setter
    public static class Response{
        private Long useId;
        private  Long accountNumber;
        private LocalDateTime registeredAt;
    }

}
