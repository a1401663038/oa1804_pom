package com.qf.oa.controller;

import com.qf.oa.entity.Department;
import com.qf.oa.service.IDepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dep")
public class DepController {
    @Autowired
    private IDepService iDepService;

    @RequestMapping("/deplist")
    public String depMapper(Model model){
        List<Department> deps = iDepService.queryAllByPage();
        model.addAttribute("deps",deps);
        return  "deplist";
    }
    @RequestMapping("/insert")
    public  String inserDep(Department department){
        iDepService.insertDao(department);
        return "redirect:/dep/deplist";

    }
    @RequestMapping("/queryAll")
    @ResponseBody
    public  List<Department> queryAllAjax(){
        List<Department> deps = iDepService.queryAllByPage();
        return deps;
    }

    @RequestMapping("/delete/{did}")
    public  String deleteById(@PathVariable("did") Integer did){
        System.out.println("进来了"+did);
        iDepService.deletDeps(did);
        return "redirect:/dep/deplist";
    }



}
