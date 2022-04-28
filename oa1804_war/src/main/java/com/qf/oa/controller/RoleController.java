package com.qf.oa.controller;

import com.qf.oa.entity.Role;
import com.qf.oa.service.IRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    @RequiresPermissions("/role/rolelist")
    @RequestMapping("/rolelist")
    public  String  roleManager(Model model){
        List<Role> roles = iRoleService.queryAll();
        model.addAttribute("roles",roles);
        return "rolelist";
    }

    @RequiresPermissions("/role/insert")
    @RequestMapping("/insert")
    public  String roleInsert(Role role){
        iRoleService.insertOrUpdatetrole(role);

        return "redirect:/role/rolelist" ;
    }


    /**
     * ajax 查询角色列表，并且会获得一个职工的id,根据职工的id,获得改职工的所有角色
     * @param eid
     * @return
     */
    @RequestMapping("/queryall")
    @ResponseBody
    public List<Role> queryAllAjax(Integer eid){
        List<Role> roles = iRoleService.queryRolesByEid(eid);
        System.out.println("roles的值是"+roles);
        return roles;
    }

    /**
     * 选择职工的角色
     * @param eid
     * @param rid
     * @return
     */
    @RequiresPermissions("/emp/selectrole")
    @RequestMapping("/selectroles")
    public  String selectRoles(Integer eid,Integer[] rid){
        System.out.println(eid+"选择了"+ Arrays.toString(rid));
        iRoleService.selectRoles(eid,rid);
        return "redirect:/emp/emplist";
    }

}
