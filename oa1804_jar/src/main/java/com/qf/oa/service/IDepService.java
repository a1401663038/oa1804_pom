package com.qf.oa.service;

import com.qf.oa.entity.Department;

import java.util.List;

public interface IDepService {
    List<Department>queryAllByPage();

    int insertDao(Department department) ;

    int deletDeps(int did);
}
