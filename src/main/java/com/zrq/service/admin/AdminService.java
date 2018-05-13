package com.zrq.service.admin;

import com.zrq.dao.admin.AdminDao;
import com.zrq.entity.Address;
import com.zrq.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zrq on 2018-5-12.
 */
@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    /**
     * 查询所有考点区域
     * @return
     */
    public List<Address> findArea() {
        return adminDao.findArea();
    }

    /**
     * 根据考点名及考试区域查询
     * @param name
     * @param area
     * @return
     */
    public List<Room> searchByNameAndArea(String name, Integer area) {
        return adminDao.searchByNameAndArea(name,area);
    }
}
