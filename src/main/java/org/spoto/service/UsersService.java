package org.spoto.service;

import org.spoto.dto.UsersDto;
import org.spoto.model.Users;

import java.util.List;

public interface UsersService {
    boolean delete(List<Integer> ids);

    boolean save(Users user);

    List<Users> getList(Integer index, String username, String password, String nickname);

    Integer getListCount(String username, String password, String nickname);

    //联表查询
    List<UsersDto> getUsersAndMoney();

    //批量删除
    boolean deletes(List<Integer> ids);
}
