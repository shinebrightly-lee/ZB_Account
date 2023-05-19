package com.example.account.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.time.*;

public class CreateAccount {
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter@Setter
    public static class Request {
        @NotNull
        @Min(1)
        private Long userId;

        @NotNull
        @Min(100)
        private Long initialBalance;
    }
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter@Setter
    public static class Response{
        private Long userId;
        private  String accountNumber;
        private LocalDateTime registeredAt;

        public static Response from(AccountDto accountDto){
            return Response.builder()
                    .userId(accountDto.getUserId())
                    .accountNumber(accountDto.getAccountNumber())
                    .registeredAt(accountDto.getRegisteredAt())
                    .build();
        }
    }

}
