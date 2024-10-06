package com.project.DuAnTotNghiep.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DonViVanChuyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String maDonVi;
    String tenDonVi;
    String diaChi;
    String api;
    String tokenApi;
    Timestamp ngayTao;
    Timestamp ngaySua;
    int trangThai;
}
