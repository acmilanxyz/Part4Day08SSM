package org.spoto.controller;

import com.alibaba.fastjson.JSONObject;
import org.spoto.dto.UsersDto;
import org.spoto.model.Users;
import org.spoto.service.UsersService;
import org.spoto.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {
    //定义为全局变量，加上@Resource注解，由SpringIOC通过注解new对象
    @Resource
    private UsersService us;

    @RequestMapping("/user-save.ajax")
    @ResponseBody
    public JSONObject save(Users user) {
        boolean save = us.save(user);

        JSONObject data = new JSONObject();
        data.put("save", save);
        return data;
    }

    //合并单个删除和批量删除
    @RequestMapping("/user-delete.ajax")
    @ResponseBody
    public JSONObject delete(String ids) {
        JSONObject data = new JSONObject();

        if (StringUtils.isEmpty(ids)) {
            data.put("delete", false);
            return data;
        }

        //将Str字符串转换为String数组，再转换为int数组
        String[] idsListStr = ids.split(",");
        List<Integer> idsList = new ArrayList<>();
        for (String itsStr : idsListStr) {
            int id = Integer.parseInt(itsStr);
            idsList.add(id);
        }

        //将int数组类型的参数传入Service方法
//        boolean delete = us.delete(idsList);
        //调用新的deletes方法
        boolean delete = us.deletes(idsList);

        data.put("delete", delete);
        return data;
    }

    @RequestMapping("/user-list.ajax")
    @ResponseBody
    public JSONObject getList(Integer index, String username, String password, String nickname) {
        List<Users> list = us.getList(index, username, password, nickname);
        Integer maxSize = us.getListCount(username, password, nickname);

        JSONObject data = new JSONObject();
        data.put("list", list);
        data.put("maxSize", maxSize);
        return data;
    }

    @RequestMapping("/user-money-list.ajax")
    @ResponseBody
    public JSONObject getUsersAndMoney() {
        List<UsersDto> list = us.getUsersAndMoney();
        JSONObject data = new JSONObject();
        data.put("list", list);
        for (UsersDto dto : list) {
            System.out.println(dto.toString());
        }
        return data;
    }

}
