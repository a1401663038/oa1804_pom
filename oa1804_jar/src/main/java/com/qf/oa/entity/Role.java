package com.qf.oa.entity;

import java.io.Serializable;

public class Role implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.rolename
     *
     * @mbggenerated
     */
    private String rolename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.roledesc
     *
     * @mbggenerated
     */
    private String roledesc;


    private Boolean isHave;

    public Boolean getHave() {
        return isHave;
    }

    public void setHave(Boolean have) {
        isHave = have;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.rolestate
     *
     * @mbggenerated
     */
    private Integer rolestate=1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table role
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.id
     *
     * @return the value of role.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.id
     *
     * @param id the value for role.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.rolename
     *
     * @return the value of role.rolename
     *
     * @mbggenerated
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.rolename
     *
     * @param rolename the value for role.rolename
     *
     * @mbggenerated
     */
    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.roledesc
     *
     * @return the value of role.roledesc
     *
     * @mbggenerated
     */
    public String getRoledesc() {
        return roledesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.roledesc
     *
     * @param roledesc the value for role.roledesc
     *
     * @mbggenerated
     */
    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc == null ? null : roledesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.rolestate
     *
     * @return the value of role.rolestate
     *
     * @mbggenerated
     */
    public Integer getRolestate() {
        return rolestate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.rolestate
     *
     * @param rolestate the value for role.rolestate
     *
     * @mbggenerated
     */
    public void setRolestate(Integer rolestate) {
        this.rolestate = rolestate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
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
        Role other = (Role) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRolename() == null ? other.getRolename() == null : this.getRolename().equals(other.getRolename()))
            && (this.getRoledesc() == null ? other.getRoledesc() == null : this.getRoledesc().equals(other.getRoledesc()))
            && (this.getRolestate() == null ? other.getRolestate() == null : this.getRolestate().equals(other.getRolestate()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRolename() == null) ? 0 : getRolename().hashCode());
        result = prime * result + ((getRoledesc() == null) ? 0 : getRoledesc().hashCode());
        result = prime * result + ((getRolestate() == null) ? 0 : getRolestate().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
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
        sb.append(", rolename=").append(rolename);
        sb.append(", roledesc=").append(roledesc);
        sb.append(", rolestate=").append(rolestate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}