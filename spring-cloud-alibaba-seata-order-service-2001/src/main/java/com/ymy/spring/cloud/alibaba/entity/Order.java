package com.ymy.spring.cloud.alibaba.entity;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 映射到 seata_order库下的 t_order表
 */
public class Order {

    /**
     * 编号
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 产品ID
     */
    private Integer productId;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 订单状态
     * 0：创建中
     * 1：已完成
     */
    private Integer status;

    public Order() {

    }

    public Order(Integer id, Integer userId, Integer productId, Integer count, BigDecimal money, Integer status) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.count = count;
        this.money = money;
        this.status = status;
    }

    public Order(Integer userId, Integer productId, Integer count, BigDecimal money, Integer status) {
        this(null, userId, productId, count, money, status);
    }

    public Order(Integer userId, Integer productId, Integer count, BigDecimal money) {
        this(null, userId, productId, count, money, null);
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", count=" + count +
                ", money=" + money +
                ", status=" + status +
                '}';
    }
}
