package com.example.software.serviceImpl;

import com.example.software.bean.Info;
import com.example.software.mapper.InfoMapper;
import com.example.software.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoMapper infoMapper;

    @Override
    public List<Info> AllInfo() {
        return infoMapper.getAllInfo();
    }

    @Override
    public void addInfo(Info info) {
        infoMapper.addInfo(info);
    }
}
