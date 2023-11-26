package com.example.software.controller;

import com.example.software.bean.company;
import com.example.software.mapper.companyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class companyController {
    @Autowired
    companyMapper companyMapper;
    @GetMapping("/allcompanies")
    public List<company> getAllcompanies() {
        List company=companyMapper.getAllcompanies();
        return company;
    }
}
