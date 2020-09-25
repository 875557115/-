package cn.com.system.employee.controller;

import cn.com.system.employee.res.ResultResponse;
import cn.com.system.employee.service.IUserService;
import cn.com.system.employee.utils.Constants;
import cn.com.system.employee.utils.JwtUtil;
import cn.com.system.employee.vo.VoToken;
import cn.com.system.employee.vo.VoUser;
import cn.com.system.employee.vo.VoUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/user/logout")
    public ResultResponse logout(@RequestHeader("X-Token") String token){
        ResultResponse res = new ResultResponse();
        // 验证token的合法和有效性
        String tokenValue = JwtUtil.verity(token);// success:zhangsan1
        // 获取token中的用户名
        String username = tokenValue.replaceFirst(JwtUtil.TOKEN_SUCCESS, "");
        // 移除session中的登录标记（或者redis中的登录标记）
        res.setMessage("logout success");
        res.setData("logout success");
        res.setCode(Constants.STATUS_OK);

        return res;
    }
    @GetMapping("/user/info")
    public ResultResponse info(@RequestParam("token") String token){
        ResultResponse res = new ResultResponse();

        // 验证token的合法和有效性
        String tokenValue = JwtUtil.verity(token);// success:zhangsan1
        if(tokenValue != null && tokenValue.startsWith(JwtUtil.TOKEN_SUCCESS)) {
            // 如果ok-》返回需要的用户信息
            // zhangsan1
            String username = tokenValue.replaceFirst(JwtUtil.TOKEN_SUCCESS, "");
//            VoUser user = this.userService.searchUserByUserName(username);
            VoUserInfo info = new VoUserInfo();
            info.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            info.setIntroduction("测试用户");
            info.setName(username);
            List<String> roles = Arrays.asList("admin");
            info.setRoles(roles);

            res.setData(info);
            res.setMessage(Constants.MESSAGE_OK);
            res.setCode(Constants.STATUS_OK);
        }else {
            // 否则：500
            res.setCode(Constants.STATUS_FAIL);
            res.setMessage(Constants.MESSAGE_FAIL);
        }

        return res;
    }

    @PostMapping("/user/login")
    public ResultResponse login(@RequestBody VoUser user){
        ResultResponse res = new ResultResponse();
        try {
            log.info("request user:"+ user);
            // 调用UserService完成username和password的验证
            VoUser u = this.userService.verify(user);
            log.info("verfiy result:" + u);
            // 根据验证结果，组成响应对象返回
            if(u != null){
                // 创建一个token数据，封装到res对象中
                String token = JwtUtil.sign(user.getUsername(), "-1");
                res.setCode(Constants.STATUS_OK);
                res.setMessage(Constants.MESSAGE_OK);
                res.setData(new VoToken(token));
            }else{
                res.setCode(Constants.STATUS_FAIL);
                res.setMessage(Constants.MESSAGE_FAIL+"username_and_password_do_not_match");
                res.setData("fail");
            }
        }catch(Exception e){
            res.setCode(Constants.STATUS_FAIL);
            res.setMessage(Constants.MESSAGE_FAIL+e.getMessage());
            res.setData("fail");
            e.printStackTrace();
        }
        return res;
    }
}
