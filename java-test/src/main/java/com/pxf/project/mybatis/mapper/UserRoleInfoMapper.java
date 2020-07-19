package com.pxf.project.mybatis.mapper;

import com.pxf.project.mybatis.entity.UserRoleInfo;

/**
 * <p>
 * 用户角色 Mapper 接口
 * </p>
 *
 * @author panxiufeng
 * @since 2019-04-26
 */
public interface UserRoleInfoMapper{

    UserRoleInfo selectById(Integer id);
}
