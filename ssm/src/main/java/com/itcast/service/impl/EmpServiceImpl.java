package com.itcast.service.impl;

import com.itcast.dao.IEmpDao;
import com.itcast.domain.Employee;
import com.itcast.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("empService")
public class EmpServiceImpl implements IEmpService {
    @Autowired
    private IEmpDao dao;

    @Override
    public List<Employee> doFindAll() {
        System.out.println("业务层查询所有...");
        return dao.doFindAll();
    }

    @Override
    public void doSave(Employee employee) {
        System.out.println("业务层保存信息...");
        dao.doSave(employee);
    }
}
