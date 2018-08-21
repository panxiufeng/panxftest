package com.pxf.project.springboottest.jpa.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="console_user_auth_id_symbol")
public class UserAuthIdSymbol implements Serializable {

    /**
     * 标识ID
     */
    @Id
    private String symbolId;

    /**
     * 租户ID
     */
    @Column()
    private String tenantId;

    /**
     * 通行证ID
     */
    @Column()
    private String authId;

    /**
     * 标识编号
     */
    @Column()
    private String identifiers;

    /**
     * 标识类型 0:用户名、1:手机、2:邮箱、3:QQ、4:微博、5:微信
     */
    @Column()
    private String identifyKind;

    /**
     * 标识状态
     */
    @Column()
    private String idStatus;

    /**
     * 创建日期
     */
    @Column()
    private Date createTime;

    /**
     * 创建人
     */
    @Column()
    private String creator;

    /**
     * 修改日期
     */
    @Column()
    private Date updateTime;

    /**
     * 修改人
     */
    @Column()
    private String modifier;

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(String identifiers) {
        this.identifiers = identifiers;
    }

    public String getIdentifyKind() {
        return identifyKind;
    }

    public void setIdentifyKind(String identifyKind) {
        this.identifyKind = identifyKind;
    }

    public String getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(String idStatus) {
        this.idStatus = idStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getSymbolId() {
        return symbolId;
    }

    public void setSymbolId(String symbolId) {
        this.symbolId = symbolId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }


    @Override
    public String toString() {
        return "UserAuthIdSymbol{" +
                "symbolId='" + symbolId + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", authId='" + authId + '\'' +
                ", identifiers='" + identifiers + '\'' +
                ", identifyKind='" + identifyKind + '\'' +
                ", idStatus='" + idStatus + '\'' +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", updateTime=" + updateTime +
                ", modifier='" + modifier + '\'' +
                '}';
    }
}