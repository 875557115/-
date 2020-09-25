package cn.com.system.employee.service.impl;

import cn.com.system.employee.service.IUserService;
import cn.com.system.employee.vo.VoUser;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    private Map<String, VoUser> users = new HashMap<String, VoUser>();
    {
        //  代码块（普通）
        VoUser user = null;
        for(int i=1;i<10;i++){
            user = new VoUser("zhangsan"+i, "password"+i);
            users.put(user.getUsername(), user);
        }
    }

    @Override
    public VoUser verify(VoUser user) {
        VoUser u = null;
        u = this.users.get(user.getUsername());
        if(u != null){
            if(!u.getPassword().equals(user.getPassword())){
                u = null;
            }
        }
        return u;
    }
}
