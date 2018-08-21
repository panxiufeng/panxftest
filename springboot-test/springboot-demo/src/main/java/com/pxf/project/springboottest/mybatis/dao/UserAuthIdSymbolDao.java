package com.pxf.project.springboottest.mybatis.dao;


import com.pxf.project.springboottest.mybatis.model.UserAuthIdSymbol;

public interface UserAuthIdSymbolDao {

    public UserAuthIdSymbol findByAuthId(String authId);

    public UserAuthIdSymbol findByAuthIdByJdbc(String authId);

    public int update(UserAuthIdSymbol auth) ;
}
