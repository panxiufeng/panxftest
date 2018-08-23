package com.pxf.project.springboottest.mybatis.dao.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pxf.project.springboottest.mybatis.dao.UserAuthIdSymbolDao;
import com.pxf.project.springboottest.mybatis.mapper.UserAuthIdSymbolMapper;
import com.pxf.project.springboottest.mybatis.model.UserAuthIdSymbol;
import com.pxf.project.springboottest.mybatis.model.UserAuthIdSymbolExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class UserAuthIdSymbolDaoImpl implements UserAuthIdSymbolDao {

    @Autowired
    private UserAuthIdSymbolMapper userAuthIdSymbolMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserAuthIdSymbol findByAuthId(String authId) {

        try {
            UserAuthIdSymbolExample example = new UserAuthIdSymbolExample();
            UserAuthIdSymbolExample.Criteria criteria = example.createCriteria();
            criteria.andAuthIdEqualTo(authId);
            criteria.andTenantIdEqualTo("000");
            List<UserAuthIdSymbol> list = userAuthIdSymbolMapper.selectByExample(example);
            if(CollectionUtils.isEmpty(list)){
                return null;
            }
            return list.get(0);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;
    }

    @Override
    public PageInfo<UserAuthIdSymbol> findByPage(Integer pageNum, Integer pageSize) {
        try {
            pageNum = pageNum == null ? 1 : pageNum;
            pageSize = pageSize == null ? 10 : pageSize;
            PageHelper.startPage(pageNum, pageSize);
            UserAuthIdSymbolExample example = new UserAuthIdSymbolExample();
            UserAuthIdSymbolExample.Criteria criteria = example.createCriteria();
            criteria.andTenantIdEqualTo("000");
            List<UserAuthIdSymbol> list = userAuthIdSymbolMapper.selectByExample(example);
            PageInfo pageInfo = new PageInfo(list);
            Page page = (Page) list;
            return pageInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public UserAuthIdSymbol findByAuthIdByJdbc(String authId) {

        String sql = "select * from console_user_auth_id_symbol where tenant_id='000' and authId=? ";
        return this.jdbcTemplate.queryForObject(sql, new RowMapper<UserAuthIdSymbol>() {

            @Override
            public UserAuthIdSymbol mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserAuthIdSymbol auth = new UserAuthIdSymbol();
                auth.setAuthId(rs.getString("authId"));
//                .......
                return auth;
            }
        },authId);
    }

    @Override
    public int update(UserAuthIdSymbol auth) {
        String sql = " update console_user_auth_id_symbol set CREATOR = ? where authId = ? ";
        return this.jdbcTemplate.update(
                sql,
                auth.getCreator(),
                auth.getAuthId()
        );
    }
}
