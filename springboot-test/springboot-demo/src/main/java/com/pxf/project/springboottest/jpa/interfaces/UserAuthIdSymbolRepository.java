package com.pxf.project.springboottest.jpa.interfaces;

import com.pxf.project.springboottest.jpa.model.UserAuthIdSymbol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthIdSymbolRepository  extends JpaRepository<UserAuthIdSymbol, String> {

    UserAuthIdSymbol findByAuthId(String authId);

    UserAuthIdSymbol findBySymbolId(String symbolId);

}
