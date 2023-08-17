package com.eteration.simplebanking.mapper;

import com.eteration.simplebanking.model.BillPayment;
import com.eteration.simplebanking.model.dto.BillPaymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BillPaymentMapper {

//    @Mapping(target = "id",ignore = true)
//    @Mapping(target = "account",ignore = true)
    List<BillPaymentDTO> billPaymentToBillPaymentDTO (List<BillPayment> billPayments);
}
