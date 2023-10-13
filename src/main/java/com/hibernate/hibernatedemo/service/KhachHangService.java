package com.hibernate.hibernatedemo.service;

import com.hibernate.hibernatedemo.dto.KhachHangDto;
import com.hibernate.hibernatedemo.entity.KhachHang;

import java.util.List;

public interface KhachHangService {
    public List<KhachHangDto> findAll(String diachi);
}
