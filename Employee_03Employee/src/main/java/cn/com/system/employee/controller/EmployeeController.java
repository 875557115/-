package cn.com.system.employee.controller;

import cn.com.system.employee.res.ResultResponse;
import cn.com.system.employee.service.IEmployeeService;
import cn.com.system.employee.utils.Constants;
import cn.com.system.employee.vo.VoEmployee;
import cn.com.system.employee.vo.VoPage;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class EmployeeController {
    @Autowired
    private IEmployeeService userService;

    @PostMapping("/employee/delete")
    public ResultResponse deleteEmployee(@RequestParam("empId") int urId){
        ResultResponse res = null;
        VoEmployee user = new VoEmployee();
        user.setEmpId(urId);
        user = this.userService.deleteEmployee(user);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, user);
        return res;
    }

    @PostMapping("/employee/update")
    public ResultResponse updateEmployee(@RequestBody VoEmployee user){
        ResultResponse res = null;
        this.userService.updateEmployee(user);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, user);
        return res;
    }
    @GetMapping("/employee/list")
    public ResultResponse queryEmployee(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        VoPage page = this.userService.searchEmployees(pageNo, limit, idSort);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, page);
        return res;
    }

    @PostMapping("/employee/create")
    public ResultResponse create(@RequestBody VoEmployee user){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        user.setEmpId(id);
        this.userService.addEmployee(user);
        log.info("create user:" + user);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, user);
        return res;
    }
}
