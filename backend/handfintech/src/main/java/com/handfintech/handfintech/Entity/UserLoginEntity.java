package com.handfintech.handfintech.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_login_tbl")
public class UserLoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // serial4 in PostgreSQL
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name", length = 100, nullable = false, unique = true)
    private String userName;

    @Column(name = "user_password", length = 100, nullable = false)
    private String userPassword;

    @Column(name = "user_last_login_time")
    private LocalDate userLastLoginTime;

    @Column(name = "user_last_logout_time")
    private LocalDate userLastLogoutTime;

    @Column(name = "user_acct_expiry_date")
    private LocalDate userAcctExpiryDate;

    @Column(name = "user_del_flg", length = 1)
    private String userDelFlg = "N";

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public LocalDate getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public void setUserLastLoginTime(LocalDate userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    public LocalDate getUserLastLogoutTime() {
        return userLastLogoutTime;
    }

    public void setUserLastLogoutTime(LocalDate userLastLogoutTime) {
        this.userLastLogoutTime = userLastLogoutTime;
    }

    public LocalDate getUserAcctExpiryDate() {
        return userAcctExpiryDate;
    }

    public void setUserAcctExpiryDate(LocalDate userAcctExpiryDate) {
        this.userAcctExpiryDate = userAcctExpiryDate;
    }

    public String getUserDelFlg() {
        return userDelFlg;
    }

    public void setUserDelFlg(String userDelFlg) {
        this.userDelFlg = userDelFlg;
    }
}
