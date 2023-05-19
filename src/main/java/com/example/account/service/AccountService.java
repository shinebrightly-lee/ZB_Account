package com.example.account.service;

import com.example.account.domain.*;
import com.example.account.dto.*;
import com.example.account.exception.*;
import com.example.account.repository.*;
import com.example.account.type.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.*;

import static com.example.account.type.AccountStatus.IN_USE;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountUserRepository accountUserRepository;

    /**  사용자가 있는지 조회
          계좌의 번호를 생성하고,
          계좌를 저장하고,  그 정보를 넘긴다.
     */
    @Transactional
    public AccountDto createAccount(Long userId, Long initialBalance) {
        AccountUser accountUser = accountUserRepository.findById(userId).orElseThrow(() -> new AccountException(ErrorCode.USER_NOT_FOUND));
        // new RuntimeException
        // new IllegalStateException
        // new IllegalArgumentException
        // 이런 비슷한 exception 사용 가능 혹은 customException 사용

        validateCreateAccount(accountUser);

        String newAccountNumber = accountRepository.findFirstByOrderByIdDesc()
                                                    .map(account -> (Integer.parseInt(account.getAccountNumber())) + 1 + "")
                                                    .orElse("1000000000");

        return AccountDto.fromEntity(
                        accountRepository.save(Account.builder()
                            .accountUser(accountUser)
                            .accountStatus(IN_USE)
                            .accountNumber(newAccountNumber)
                            .balance(initialBalance)
                            .registeredAt(LocalDateTime.now())
                            .build())
        );
    }

    private void validateCreateAccount(AccountUser accountUser) {
        if (accountRepository.countByAccountUser(accountUser) >= 10){
            throw new AccountException(ErrorCode.MAX_ACCOUNT_PER_USER_10);
        }
    }

    @Transactional
    public Account getAccount(Long id) {
        if(id < 0){
            throw new RuntimeException("Minus");
        }
        return accountRepository.findById(id).get();
    }
}
