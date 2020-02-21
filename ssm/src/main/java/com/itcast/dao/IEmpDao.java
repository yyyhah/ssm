package com.itcast.dao;

import com.itcast.domain.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IEmpDao {
    /**
     * 查询全部信息
     * @return
     */
    @Results(
            id = "empMap",
            value = {
                    @Result(property = "departId",column="depart_id")
            }
    )
    @Select("select * from employee")
    List<Employee> doFindAll();

    /**
     * 保存一条信息
     * @param employee
     */
    @ResultMap("empMap")
    @Insert("insert into employee(name,age,depart_id) values(#{name},#{age},#{departId})")
    void doSave(Employee employee);
}
