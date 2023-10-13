package com.hibernate.hibernatedemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_kh")
@Getter
@Setter
public class OrderKh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private int id;

    @Column(name = "makh")
    private int maKH;

    @Column(name = "soluong")
    private int soLuong;
}
