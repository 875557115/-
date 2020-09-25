package cn.com.system.employee.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VoUser implements java.io.Serializable{
    private String username;
    //@JsonIgnore// 序列化成json的时候，该属性不能序列化

    private String password;
}
