package com.eteration.simplebanking.mapper;

import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.model.dto.TransactionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

//    @Mapping(target = "id",ignore = true)
//    @Mapping(target = "account",ignore = true)
    List<TransactionDTO> TransactionsToTransactionDTOs (List<Transaction> transactions);
}
