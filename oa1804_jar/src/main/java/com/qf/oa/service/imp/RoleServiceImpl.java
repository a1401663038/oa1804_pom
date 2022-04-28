package com.qf.oa.service.imp;

import com.qf.oa.dao.EmployeeMapper;
import com.qf.oa.dao.RoleMapper;
import com.qf.oa.entity.Role;
import com.qf.oa.service.IEmpService;
import com.qf.oa.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl  implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Role> queryAll() {
        return roleMapper.queryAll();
    }



    @Override
    public List<Role> queryRolesByEid(Integer eid) {
        return roleMapper.queryRolesByEid(eid);
    }

    @Override
    public int insertOrUpdatetrole(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    @Transactional
    public int selectRoles(Integer eid, Integer[] rid) {
        int i = employeeMapper.deleteRolsByEid(eid);
        roleMapper.inserRolesAndEmp(eid, rid);
        return 1;
    }
}
