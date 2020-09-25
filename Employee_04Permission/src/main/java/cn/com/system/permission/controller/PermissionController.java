package cn.com.system.permission.controller;

import cn.com.system.employee.res.ResultResponse;
import cn.com.system.employee.utils.Constants;
import cn.com.system.permission.vo.VoPermMeta;
import cn.com.system.permission.vo.VoPermNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PermissionController {
    @GetMapping("/perm/search")
    public ResultResponse search(){
        ResultResponse res = new ResultResponse();

        res.setCode(Constants.STATUS_OK);
        res.setMessage(Constants.MESSAGE_OK);

//        List<VoPermNode> firstPerms = new ArrayList<>();
//        List<VoPermNode> secondPerms = null;
//        VoPermMeta meta = null;
//        VoPermNode firstPermNode = null;
//        VoPermNode secondPermNode = null;
//        for(int i=1;i<10;i++){
//            firstPermNode = new VoPermNode();
//            firstPermNode.setPath("path"+i);
////            firstPermNode.setName("name" + i);
////            firstPermNode.setComponent("component" + i);
////            firstPermNode.setRedirect("redirect" + i);
//            firstPermNode.setMeta(new VoPermMeta("title"+i, "icon"+i,true, Arrays.asList("admin")));
//
//            secondPerms = new ArrayList<>();
//            for(int j=1;j<5;j++){
//                secondPermNode = new VoPermNode();
//                secondPermNode.setPath("s"+i+"path"+j);
////                secondPermNode.setName("s"+i+"name" + j);
////                secondPermNode.setComponent("s"+i+"component" + j);
////                secondPermNode.setRedirect("s"+i+"redirect" + j);
//                secondPermNode.setMeta(new VoPermMeta(i+"title"+j, i+"icon"+j,true, Arrays.asList("admin")));
//
//                secondPerms.add(secondPermNode);
//            }
//            firstPermNode.setChildren(secondPerms);
//            firstPerms.add(firstPermNode);
//        }
//        res.setData(firstPerms);

        return res;
    }
}
