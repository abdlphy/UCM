package com.deloitte.UCM.models;


public class User {
    private String userId;
    private Long roleId;
    private String fullname;
    private String email;
    private String phoneCode;
    private String phone;
    private String password;
    private Boolean isActive;
    private Boolean isDeleted;
    private String profile; 

 
    public User() {}


    public User(String userId, Long roleId, String fullname, String email,
                String phoneCode, String phone, String password,
                Boolean isActive, Boolean isDeleted, String profile) {
        this.userId = userId;
        this.roleId = roleId;
        this.fullname = fullname;
        this.email = email;
        this.phoneCode = phoneCode;
        this.phone = phone;
        this.password = password;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.profile = profile;
    }

   
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public Long getRoleId() { return roleId; }
    public void setRoleId(Long roleId) { this.roleId = roleId; }

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneCode() { return phoneCode; }
    public void setPhoneCode(String phoneCode) { this.phoneCode = phoneCode; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }

    public String getProfile() { return profile; }
    public void setProfile(String profile) { this.profile = profile; }
}
