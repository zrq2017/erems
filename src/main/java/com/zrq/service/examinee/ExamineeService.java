package com.zrq.service.examinee;

import com.zrq.dao.examinee.ExamineeDao;
import com.zrq.entity.examinee.Examinee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zrq on 2018-4-18.
 */
@Service
public class ExamineeService {
    @Autowired
    private ExamineeDao examineeDao;

    public List<Examinee> findAll(){
        return examineeDao.findAll();
    }
}
