package edu.neu.springcloud.provider_1.bean;

public class TbUser {
    private Integer id;

    private String loginName;

    private String username;

    private String password;

    public TbUser(Integer id, String loginName, String username, String password) {
        this.id = id;
        this.loginName = loginName;
        this.username = username;
        this.password = password;
    }

    public TbUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}