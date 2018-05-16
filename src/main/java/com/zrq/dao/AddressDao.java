package com.zrq.dao;

import com.zrq.entity.Address;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by zrq on 2018-5-14.
 */
@Repository
public interface AddressDao {
    /**
     * 根据id查询地址
     * @param id
     * @return
     */
    @Select("select * from address where id=#{id}")
    public Address findById(Integer id);
}
