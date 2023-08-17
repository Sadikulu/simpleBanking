package com.eteration.simplebanking.mapper;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.dto.AccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BillPaymentMapper.class, TransactionMapper.class})
public interface AccountMapper {

    @Mapping(source = "transactions",target = "transactions")
    @Mapping(source = "billPayments",target = "billPayments")
    AccountDTO accountToAccountDTO (Account account);
}
