package com.project.DuAnTotNghiep.dto.AddressShipping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressShippingDtoAdmin {
    private Long id;
    private String address;
    private Long customerId;
    private int provinceId;
    private int districtId;
    private int wardId;
}