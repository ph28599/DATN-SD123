package com.project.DuAnTotNghiep.dto.Account;

import com.project.DuAnTotNghiep.dto.AddressShipping.AddressShippingDto;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class AccountDto {
    private String phoneNumber;
    private String name;
    private String email;
    private String password;
    private List<AddressShippingDto> addressShippingList;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;
}
