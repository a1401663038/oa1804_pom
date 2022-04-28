package com.qf.oa.service.imp;

import com.qf.oa.dao.RescMapper;
import com.qf.oa.dao.RoleMapper;
import com.qf.oa.entity.Employee;
import com.qf.oa.entity.Resc;
import com.qf.oa.entity.Role;
import com.qf.oa.service.IRescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RescServiceImpl implements IRescService {
    @Autowired
    private RescMapper rescMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Resc> queryAll() {
        return rescMapper.queryAll();
    }

    @Override
    public List<Role> queryAll2(Integer rid) {
        return rescMapper.queryAll2(rid);
    }

    @Override
    public int insertRest(Resc resc) {
        return rescMapper.insert(resc);
    }

    @Override
    @Transactional
    public int updateRescAndRole(Integer rid, Integer[] reids) {
        roleMapper.deleteRoleRescTable(rid);

        return rescMapper.insertRoleAndResc(rid,reids);
    }


}
