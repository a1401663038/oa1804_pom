package com.qf.oa.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Employee implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.email
     *
     * @mbggenerated
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.phone
     *
     * @mbggenerated
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.sex
     *
     * @mbggenerated
     */
    private Integer sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.birthday
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.image
     *
     * @mbggenerated
     */
    private String image;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.einfo
     *
     * @mbggenerated
     */
    private String einfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.entrytime
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date entrytime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.aid
     *
     * @mbggenerated
     */
    private Integer aid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.did
     *
     * @mbggenerated
     */
    private Integer did;

    public List<Resc> getRescs() {
        return rescs;
    }

    public void setRescs(List<Resc> rescs) {
        this.rescs = rescs;
    }

    private List<Resc>rescs;

    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table employee
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.id
     *
     * @return the value of employee.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.id
     *
     * @param id the value for employee.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.email
     *
     * @return the value of employee.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.email
     *
     * @param email the value for employee.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.password
     *
     * @return the value of employee.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.password
     *
     * @param password the value for employee.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.name
     *
     * @return the value of employee.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.name
     *
     * @param name the value for employee.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.phone
     *
     * @return the value of employee.phone
     *
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.phone
     *
     * @param phone the value for employee.phone
     *
     * @mbggenerated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.sex
     *
     * @return the value of employee.sex
     *
     * @mbggenerated
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.sex
     *
     * @param sex the value for employee.sex
     *
     * @mbggenerated
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.birthday
     *
     * @return the value of employee.birthday
     *
     * @mbggenerated
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.birthday
     *
     * @param birthday the value for employee.birthday
     *
     * @mbggenerated
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.image
     *
     * @return the value of employee.image
     *
     * @mbggenerated
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.image
     *
     * @param image the value for employee.image
     *
     * @mbggenerated
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.einfo
     *
     * @return the value of employee.einfo
     *
     * @mbggenerated
     */
    public String getEinfo() {
        return einfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.einfo
     *
     * @param einfo the value for employee.einfo
     *
     * @mbggenerated
     */
    public void setEinfo(String einfo) {
        this.einfo = einfo == null ? null : einfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.entrytime
     *
     * @return the value of employee.entrytime
     *
     * @mbggenerated
     */
    public Date getEntrytime() {
        return entrytime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.entrytime
     *
     * @param entrytime the value for employee.entrytime
     *
     * @mbggenerated
     */
    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.aid
     *
     * @return the value of employee.aid
     *
     * @mbggenerated
     */
    public Integer getAid() {
        return aid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.aid
     *
     * @param aid the value for employee.aid
     *
     * @mbggenerated
     */
    public void setAid(Integer aid) {
        this.aid = aid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.did
     *
     * @return the value of employee.did
     *
     * @mbggenerated
     */
    public Integer getDid() {
        return did;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.did
     *
     * @param did the value for employee.did
     *
     * @mbggenerated
     */
    public void setDid(Integer did) {
        this.did = did;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Employee other = (Employee) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getEinfo() == null ? other.getEinfo() == null : this.getEinfo().equals(other.getEinfo()))
            && (this.getEntrytime() == null ? other.getEntrytime() == null : this.getEntrytime().equals(other.getEntrytime()))
            && (this.getAid() == null ? other.getAid() == null : this.getAid().equals(other.getAid()))
            && (this.getDid() == null ? other.getDid() == null : this.getDid().equals(other.getDid()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getEinfo() == null) ? 0 : getEinfo().hashCode());
        result = prime * result + ((getEntrytime() == null) ? 0 : getEntrytime().hashCode());
        result = prime * result + ((getAid() == null) ? 0 : getAid().hashCode());
        result = prime * result + ((getDid() == null) ? 0 : getDid().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", image=").append(image);
        sb.append(", einfo=").append(einfo);
        sb.append(", entrytime=").append(entrytime);
        sb.append(", aid=").append(aid);
        sb.append(", did=").append(did);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}