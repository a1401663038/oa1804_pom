package com.qf.oa.service;

import com.qf.oa.entity.Employee;

import java.util.List;

public interface IEmpService {
    List<Employee>queryAll();

    int insertOrUpdatetEmp(Employee employee);

    Employee queryOne(Integer  id);

    Employee queryByEmail(String email);
}
