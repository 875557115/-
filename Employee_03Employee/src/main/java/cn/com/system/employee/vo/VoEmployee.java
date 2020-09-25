package cn.com.system.employee.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VoEmployee implements java.io.Serializable{
    private Integer empId;
    private String empName;
    @JsonIgnore
    private transient String empPassword;
    private String empSex;
    private Integer empAge;
    private Date empBirthDay;
}
