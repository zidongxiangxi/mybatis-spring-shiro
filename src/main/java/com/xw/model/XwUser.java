package com.xw.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xw_user")
public class XwUser {
    @Id
    @Column(name = "user_id")
    private String userId;

    private String username;

    private String identification;

    private String password;

    private String salt;

    private Integer status;

    @Column(name = "true_name")
    private String trueName;

    private Float balance;

    @Column(name = "history_balance")
    private Float historyBalance;

    private Integer discount;

    private Float credit;

    private String admin;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return identification
     */
    public String getIdentification() {
        return identification;
    }

    /**
     * @param identification
     */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return true_name
     */
    public String getTrueName() {
        return trueName;
    }

    /**
     * @param trueName
     */
    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    /**
     * @return balance
     */
    public Float getBalance() {
        return balance;
    }

    /**
     * @param balance
     */
    public void setBalance(Float balance) {
        this.balance = balance;
    }

    /**
     * @return history_balance
     */
    public Float getHistoryBalance() {
        return historyBalance;
    }

    /**
     * @param historyBalance
     */
    public void setHistoryBalance(Float historyBalance) {
        this.historyBalance = historyBalance;
    }

    /**
     * @return discount
     */
    public Integer getDiscount() {
        return discount;
    }

    /**
     * @param discount
     */
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    /**
     * @return credit
     */
    public Float getCredit() {
        return credit;
    }

    /**
     * @param credit
     */
    public void setCredit(Float credit) {
        this.credit = credit;
    }

    /**
     * @return admin
     */
    public String getAdmin() {
        return admin;
    }

    /**
     * @param admin
     */
    public void setAdmin(String admin) {
        this.admin = admin;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}