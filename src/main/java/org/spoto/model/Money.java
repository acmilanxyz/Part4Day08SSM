package org.spoto.model;

public class Money {
    private Integer id;
    private Integer userId;
    private double sum;

    public Money() {
    }

    public Money(Integer id, Integer userId, double sum) {
        this.id = id;
        this.userId = userId;
        this.sum = sum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Money{" +
                "id=" + id +
                ", userId=" + userId +
                ", sum=" + sum +
                '}';
    }
}
