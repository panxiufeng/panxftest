package com.pxf.project.mybatis.entity;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户角色
 * </p>
 *
 * @author panxiufeng
 * @since 2019-04-26
 */
public class UserRoleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 描述
     */
    private String descript;

    /**
     * 角色类型 EnumRoleType
     */
    private Integer type;

    /**
     * 状态 EnumCommonStatus
     */
    private Integer status;

    /**
     * 创建人
     */
    private Integer creator;

    /**
     * 创建时间
     */
    private LocalDateTime created;

    /**
     * 修改人
     */
    private Integer modifier;

    /**
     * 修改时间
     */
    private LocalDateTime modified;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "UserRoleInfo{" +
        "id=" + id +
        ", name=" + name +
        ", code=" + code +
        ", descript=" + descript +
        ", type=" + type +
        ", status=" + status +
        ", creator=" + creator +
        ", created=" + created +
        ", modifier=" + modifier +
        ", modified=" + modified +
        "}";
    }
}
