package com.hibernate.hibernatedemo.service.impl;

import com.hibernate.hibernatedemo.dao.KhachHangDao;
import com.hibernate.hibernatedemo.dto.KhachHangDto;
import com.hibernate.hibernatedemo.entity.KhachHang;
import com.hibernate.hibernatedemo.service.KhachHangService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangDao khachHangDao;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<KhachHangDto> findAll(String diachi) {
        diachi = "null".equals(diachi) ? null : diachi;
        return khachHangDao.findAll(diachi).stream().map(this::convertToDto).collect(Collectors.toList());
    }
    private KhachHangDto convertToDto(KhachHang khachHang){
        KhachHangDto khachHangDto = modelMapper.map(khachHang, KhachHangDto.class);
        khachHangDto.setMaKH(khachHang.getId());
        return khachHangDto;
    }
}
