package com.qf.oa.service;

import com.qf.oa.entity.Employee;
import com.qf.oa.entity.Resc;
import com.qf.oa.entity.Role;

import javax.print.DocFlavor;
import java.util.List;

public interface IRescService {

    List<Resc> queryAll();

    List<Role> queryAll2(Integer rid);

    int insertRest(Resc resc);

    int updateRescAndRole(Integer rid,Integer[] reids);


}
