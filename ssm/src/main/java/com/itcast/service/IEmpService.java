package com.itcast.service;

import com.itcast.domain.Employee;

import java.util.List;

public interface IEmpService {
    /**
     * 查询全部信息
     * @return
     */
    List<Employee> doFindAll();

    /**
     * 保存一条信息
     * @param employee
     */
    void doSave(Employee employee);
}
