package com.example.software.controller;


import com.example.software.serviceImpl.ExcelService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class ExportController {
    @Autowired
    private ExcelService excelService;
    @RequestMapping("/table")
    public void exportTable(HttpServletResponse response) throws IOException {
        excelService.exportTableToExcel(response);
    }
}

