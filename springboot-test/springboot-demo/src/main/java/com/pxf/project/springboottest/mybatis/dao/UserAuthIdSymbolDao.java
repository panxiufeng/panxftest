package com.pxf.project.springboottest.mybatis.dao;


import com.github.pagehelper.PageInfo;
import com.pxf.project.springboottest.mybatis.model.UserAuthIdSymbol;

public interface UserAuthIdSymbolDao {

    public UserAuthIdSymbol findByAuthId(String authId);

    public PageInfo<UserAuthIdSymbol> findByPage(Integer pageNum, Integer pageSize);

    public UserAuthIdSymbol findByAuthIdByJdbc(String authId);

    public int update(UserAuthIdSymbol auth) ;
}
