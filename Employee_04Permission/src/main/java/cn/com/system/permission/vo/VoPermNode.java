package cn.com.system.permission.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
//        Include.Include.ALWAYS 默认
//        Include.NON_DEFAULT 属性为默认值不序列化
//        Include.NON_EMPTY 属性为 空（""） 或者为 null 都不序列化
//        Include.NON_NULL 属性为NULL 不序列化
public class VoPermNode {
    //@JsonIgnore  // 指定属性不要对json进行序列化
    private String path;
    private String component;
    private String name;
    private String redirect;
    private VoPermMeta meta;
    private List<VoPermNode> children;
}
