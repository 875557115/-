package cn.com.system.employee.service;

import cn.com.system.employee.vo.VoEmployee;
import cn.com.system.employee.vo.VoPage;

public interface IEmployeeService {
    public VoEmployee addEmployee(VoEmployee user);
    public VoPage searchEmployees(int pageNo, int limit, String idSorted);
    public VoEmployee updateEmployee(VoEmployee user);
    public VoEmployee deleteEmployee(VoEmployee user);
    public VoEmployee searchById(Integer id);
    public VoEmployee searchByName(String name);
}
