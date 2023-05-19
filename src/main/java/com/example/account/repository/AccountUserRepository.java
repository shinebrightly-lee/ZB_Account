package com.example.account.repository;

import com.example.account.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface AccountUserRepository extends JpaRepository<AccountUser, Long> {
}
