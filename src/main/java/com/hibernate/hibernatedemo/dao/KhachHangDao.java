package com.hibernate.hibernatedemo.dao;

import com.hibernate.hibernatedemo.entity.KhachHang;

import java.util.List;

public interface KhachHangDao {
    List<KhachHang> findAll(String diachi);
}
