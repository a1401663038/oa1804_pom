package com.qf.oa.controller;

import com.qf.oa.entity.Resc;
import com.qf.oa.service.IRescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.net.idn.Punycode;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/resc")
public class RescController {
    @Autowired
    private IRescService iRescServiceL;

    @RequestMapping("/resclist")
    public String rescManager(Model model){
        List<Resc> rescs = iRescServiceL.queryAll();
        model.addAttribute("rescs",rescs);
        return "resclist";
    }

    @RequestMapping("/queryall")
    @ResponseBody
    public List<Resc> queryAll( ){
        List<Resc> rescs = iRescServiceL.queryAll();
        return rescs;
    }
    

    @RequestMapping("/insert")
    public String insertRest(Resc resc){
        iRescServiceL.insertRest(resc);
        return "redirect:/resc/resclist";
    }

    @RequestMapping("/selectresc")
    @ResponseBody
    public  Integer selectResc( Integer rid,Integer [] reids){
        System.out.println("rid为"+ rid + "reids为"+ Arrays.toString(reids));
        int i = iRescServiceL.updateRescAndRole(rid, reids);
        return i;
    }
}
