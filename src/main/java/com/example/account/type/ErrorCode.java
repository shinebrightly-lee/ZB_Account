package com.example.account.type;

import lombok.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND("사용자가 있습니다."),
    MAX_ACCOUNT_PER_USER_10("사용자 최대 계좌는 10개 입니다.");
    private String description;


}
