package com.example.account.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class AccountInfo {

    private String accountNumber;
    private Long balance;

}
