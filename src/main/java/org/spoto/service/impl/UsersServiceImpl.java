package org.spoto.service.impl;

import org.apache.ibatis.session.RowBounds;
import org.spoto.dao.UsersMapper;
import org.spoto.dto.UsersDto;
import org.spoto.model.Users;
import org.spoto.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    //定义为全局变量，加上@Resource注解，由SpringIOC通过注解new对象
    @Resource
    private UsersMapper mapper;

    // 设置一页显示几条数据
    private static int pageSize = 4;

    @Override
    @Transactional(rollbackFor = Exception.class)   // 让该方法执行事务：有异常的时候回滚，没有异常直接提交；没加注解默认全部提交
    public boolean delete(List<Integer> ids) {
        for (Integer id : ids) {
            Integer delete = mapper.delete(id);
            if (delete < 0) {
                return false;
            }
        }
        return true;
    }

    //批量删除
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deletes(List<Integer> ids) {
        //直接将int数组传递给dao
        Integer delete = mapper.deletes(ids);
        if (delete > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(Users user) {
        if (user.getId() > 0) {
            //有id就执行更新
            Integer update = mapper.update(user.getId(), user.getUsername(), user.getPassword());
            if (update > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            //没有id就执行新增
            Integer add = mapper.add(user);
            if (add > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Users> getList(Integer index, String username, String password, String nickname) {
        //分页数据计算：mysql实现分页需要有两个参数
        //跳过几行数据
        int offset = (index - 1) * pageSize;
        //读取几行数据
        int limit = pageSize;

        //MyBatis实现分页
        RowBounds rowBounds = new RowBounds(offset, limit);

        List<Users> usersList = mapper.getList(rowBounds, username, password, nickname);
        return usersList;
    }

    @Override
    public Integer getListCount(String username, String password, String nickname) {
        Integer count = mapper.getListCount(username, password, nickname);

        //计算最大页数：可以被整除取商，不能被整除取商+1
        int max = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize + 1);
        return max;
    }

    @Override
    public List<UsersDto> getUsersAndMoney() {
        List<UsersDto> list = mapper.getUsersAndMoney();
        return list;
    }
}
