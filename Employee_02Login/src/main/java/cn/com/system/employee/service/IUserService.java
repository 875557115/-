package cn.com.system.employee.service;

import cn.com.system.employee.vo.VoUser;

public interface IUserService {
    /**
     * 如果验证成功，返回VoUser对象
     * 否则的话，返回null或throws Exception
     * */
    public VoUser verify(VoUser user);
}
