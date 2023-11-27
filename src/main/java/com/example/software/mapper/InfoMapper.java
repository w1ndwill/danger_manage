package com.example.software.mapper;
import com.example.software.bean.Info;
import com.example.software.bean.Official;
import com.example.software.bean.Task;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface InfoMapper {
    List<Info> getAllInfo();

    void addInfo(Info info);

    void deleteInfo(Info info);
}
