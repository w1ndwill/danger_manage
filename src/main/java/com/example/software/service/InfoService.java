package com.example.software.service;

import com.example.software.bean.Info;
import java.util.List;

public interface InfoService {
    List<Info> AllInfo();
    void addInfo(Info info);
}
