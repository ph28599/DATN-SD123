package com.project.DuAnTotNghiep.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "AddressShipping")
public class AddressShipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "province_id", nullable = false)
    private int provinceId;

    @Column(name = "district_id", nullable = false)
    private int districtId;

    @Column(name = "ward_id", nullable = false)
    private int wardId;

    @Nationalized
    @Column(nullable = false, length = 150)
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "so_dien_thoai_nhan", length = 15, nullable = false)
    private String soDienThoaiNhan;
}
