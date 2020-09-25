package cn.com.system.employee.service.impl;

import cn.com.system.employee.service.IEmployeeService;
import cn.com.system.employee.vo.VoEmployee;
import cn.com.system.employee.vo.VoPage;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private Map<Integer, VoEmployee> idMaps = new TreeMap<>();
    private Map<String, VoEmployee> userNameMaps = new HashMap<>();
    {
        VoEmployee user = null;
        for(int i=1;i<23;i++){
            user = new VoEmployee(i, "zhangsan" + i, "123456" + i, "sex" + i, 16+i, new Date(System.currentTimeMillis()));
            idMaps.put(user.getEmpId(), user);
            userNameMaps.put(user.getEmpName(), user);
        }
    }

//    @Override
//    public boolean verify(String userName, String password) {
//        boolean bool = false;
//        VoEmployee user = this.searchByName(userName);
//        if(user == null){
//            throw new RuntimeException("用户不存在");
//        }else{
//            bool = user.getEmpPassword().equals(password);
//        }
//        return bool;
//    }

    @Override
    public VoEmployee addEmployee(VoEmployee user) {
        this.userNameMaps.put(user.getEmpName(), user);
        this.idMaps.put(user.getEmpId(), user);
        return user;
    }

    @Override
    public VoPage searchEmployees(int pageNo, int limit, String idSorted) {
        VoPage page = null;

        List<VoEmployee> userList = new ArrayList<>();
        userList.addAll(this.idMaps.values());
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(userList);
        }
        int total = userList.size();
        int maxPageNo = userList.size()%limit == 0? userList.size()/limit:userList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new VoPage(userList.subList(beginIndex, endIndex), total);

        return page;
    }

    @Override
    public VoEmployee updateEmployee(VoEmployee user) {
        this.userNameMaps.put(user.getEmpName(), user);
        this.idMaps.put(user.getEmpId(), user);
        return user;
    }

    @Override
    public VoEmployee deleteEmployee(VoEmployee user) {
        this.idMaps.remove(user.getEmpId());
        user = this.userNameMaps.remove(user.getEmpName());
        return user;
    }

    @Override
    public VoEmployee searchById(Integer id) {
        return this.idMaps.get(id);
    }

    @Override
    public VoEmployee searchByName(String userName) {
        return this.userNameMaps.get(userName);
    }
}
