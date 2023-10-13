package com.hibernate.hibernatedemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "khach_hang")
@Getter
@Setter
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "makh")
    private int id;

    @Column(name = "tenkh")
    private String tenKH;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "tuoi")
    private int tuoi;
}
