package com.pxf.project.springboottest.mybatis.controller;

import com.github.pagehelper.PageInfo;
import com.pxf.project.springboottest.mybatis.dao.UserAuthIdSymbolDao;
import com.pxf.project.springboottest.mybatis.model.UserAuthIdSymbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/mybatis")
public class MybatisTestController {


    @Autowired
    private UserAuthIdSymbolDao userAuthIdSymbolDao;


    @RequestMapping("/findSymbol/{authId}")
    @ResponseBody
    public UserAuthIdSymbol findSymbol(@PathVariable("authId") String authId ){
        UserAuthIdSymbol userAuthIdSymbol =  userAuthIdSymbolDao.findByAuthId(authId);
        System.out.println("userAuthIdSymbol---------->"+userAuthIdSymbol.toString());
        return userAuthIdSymbol;
    }

    @RequestMapping("/findByPage")
    @ResponseBody
    public PageInfo<UserAuthIdSymbol> findByPage(){
        PageInfo<UserAuthIdSymbol> pageInfo =  userAuthIdSymbolDao.findByPage(1,5);
        List<UserAuthIdSymbol> list =  pageInfo.getList();
        if(list != null && list.size()>0){
            for(UserAuthIdSymbol userAuthIdSymbol : list){
                System.out.println("userAuthIdSymbol---------->"+userAuthIdSymbol.toString());
            }
        }
        return pageInfo;
    }


}
