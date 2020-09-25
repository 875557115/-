package cn.com.system.employee.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

//"avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif","
// name":"Super Admin"}
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VoUserInfo {
    private List<String> roles;
    private String introduction;
    private String avatar;
    private String name;
}
