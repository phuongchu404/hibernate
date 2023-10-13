package com.hibernate.hibernatedemo.controller;

import com.hibernate.hibernatedemo.dto.KhachHangDto;
import com.hibernate.hibernatedemo.service.KhachHangService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/all")
    public ResponseEntity findAll(@RequestParam String diachi){
        return ResponseEntity.ok(khachHangService.findAll(diachi));
    }
}
