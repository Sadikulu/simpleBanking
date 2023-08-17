package com.eteration.simplebanking.repository;

import com.eteration.simplebanking.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    @Query("select t from Transaction t where t.account.id=:accountId")
    List<Transaction> findAllByAccount_Id(@Param("accountId") Long accountId);
}
