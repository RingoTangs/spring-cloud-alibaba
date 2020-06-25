package com.ymy.spring.cloud.alibaba.entity;

import java.math.BigDecimal;

public class Account {

    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户总额度
     */
    private BigDecimal total;

    /**
     * 已用余额
     */
    private BigDecimal used;

    /**
     * 剩余可用额度
     */
    private BigDecimal residue;

    public Account() {

    }

    public Account(Integer id, Integer userId, BigDecimal total, BigDecimal used, BigDecimal residue) {
        this.id = id;
        this.userId = userId;
        this.total = total;
        this.used = used;
        this.residue = residue;
    }

    public Account(Integer userId, BigDecimal total, BigDecimal used, BigDecimal residue) {
        this(null, userId, total, used, residue);
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getUsed() {
        return used;
    }

    public void setUsed(BigDecimal used) {
        this.used = used;
    }

    public BigDecimal getResidue() {
        return residue;
    }

    public void setResidue(BigDecimal residue) {
        this.residue = residue;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userId=" + userId +
                ", total=" + total +
                ", used=" + used +
                ", residue=" + residue +
                '}';
    }
}
