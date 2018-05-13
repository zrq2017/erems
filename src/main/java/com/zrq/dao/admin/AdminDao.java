package com.zrq.dao.admin;

import com.zrq.entity.Address;
import com.zrq.entity.Room;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zrq on 2018-5-12.
 */
@Repository
public interface AdminDao {
    /**
     *查询所有考点区域
     * @return
     */
    @Select("select * from address")
    public List<Address> findArea();

    /**
     *根据id查询所有考点区域
     * @return
     */
    @Select("select * from address where id=#{id}")
    public Address findAreaById(Integer id);

    /**
     * 根据考点名及考试区域查询
     * @param name
     * @param area
     * @return
     */
    @Select("<script>"+
            "select * from room as r join address as a on r.address_id=a.id where 1=1" +
            "<if test='name!=null and name != \"\"'>" +
            "and r.name like CONCAT('%',#{name},'%')" +
            "</if>" +
            "<if test='areaId!=null'>" +
            "and r.address_id=#{areaId}" +
            "</if>" +
            "</script>")
    @Results({
            @Result(property="address",
                    column = "address_id",
                    one = @One(select = "com.zrq.dao.admin.AdminDao.findAreaById")
            )
    })
    public List<Room> searchByNameAndArea(@Param("name")String name,@Param("areaId")Integer area);
}
