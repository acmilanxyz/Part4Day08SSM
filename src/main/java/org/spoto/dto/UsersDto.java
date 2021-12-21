package org.spoto.dto;

import org.spoto.model.Money;
import org.spoto.model.Users;

public class UsersDto extends Users {
    private Money money;

    public UsersDto() {
    }

    public UsersDto(Money money) {
        this.money = money;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "UsersDto{" +
                //调用父类的toString()方法
                "user = " + super.toString() +
                ", money = " + money +
                '}';
    }
}
