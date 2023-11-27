package com.example.software.serviceImpl;


import com.example.software.bean.Task;
import com.example.software.mapper.TaskMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {
    private static final String FILE_NAME = "export.xlsx";
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    public void exportTableToExcel(HttpServletResponse response) throws IOException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            TaskMapper mapper = session.getMapper(TaskMapper.class);
            List<Task> records = mapper.getAllTasks();
            // 创建Excel工作簿和工作表
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Sheet1");

            // 添加标题行
            Row titleRow = sheet.createRow(0);
            titleRow.createCell(0).setCellValue("任务名称");
            titleRow.createCell(1).setCellValue("企业");
            titleRow.createCell(2).setCellValue("检查类型");
            titleRow.createCell(3).setCellValue("隐患数");
            titleRow.createCell(4).setCellValue("检查人");
            titleRow.createCell(5).setCellValue("开始");
            titleRow.createCell(6).setCellValue("结束");
            // 可以根据需要添加其他标题列的内容

            // 将数据写入工作表
            int rowIndex = 1; // 从第二行开始写数据
            for (Task record : records) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(record.getTaskName());
                row.createCell(1).setCellValue(record.getCompany());
                row.createCell(2).setCellValue(record.getInspectionType());
                row.createCell(3).setCellValue(record.getHiddenDangerCount());
                row.createCell(4).setCellValue(record.getInspector());
                row.createCell(5).setCellValue(record.getstartDate());
                row.createCell(6).setCellValue(record.getEndDate());
                // 根据需要重复添加其他列的数据
            }
            // 设置响应头，告诉浏览器返回的是Excel文件
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=" + FILE_NAME);

            // 将工作簿写入响应输出流中
            workbook.write(response.getOutputStream());
        }
    }
}


