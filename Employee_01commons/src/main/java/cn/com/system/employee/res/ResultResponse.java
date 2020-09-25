package cn.com.system.employee.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultResponse implements java.io.Serializable{
    private int code;
    private String message;
    private Object data;
}
