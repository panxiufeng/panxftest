package com.pxf.project.springboottest.springscurity.config;

import com.pxf.project.springboottest.springscurity.entrypoint.RestAuthenticationEntryPoint;
import com.pxf.project.springboottest.springscurity.filter.RestPreAuthenticatedProcessingFilter;
import com.pxf.project.springboottest.springscurity.handler.MyAuthenticationSuccessHandler;
import com.pxf.project.springboottest.springscurity.provider.RestAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


/**
 * 安全控制中心
 */
@Configuration
@EnableWebSecurity//@EnableWebMvcSecurity 注解开启Spring Security的功能
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    /**
     * 为验证拦截器设置AuthenticationManager (由于用了springboot注入方式)
     * @return
     * @throws Exception
     */
    private RestPreAuthenticatedProcessingFilter getPreAuthenticatedProcessingFilter() throws Exception {
        RestPreAuthenticatedProcessingFilter filter =
                new RestPreAuthenticatedProcessingFilter();
        filter.setAuthenticationManager(this.authenticationManagerBean());
        return  filter;
    }

    /**
    * 指定provider
    */
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.authenticationProvider(new RestAuthenticationProvider());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }

    /**
     * 设置用户密码的加密方式
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/hello/**", "/mybatis/**","/jpa/**").permitAll()//访问无需登录认证权限
//                .anyRequest().authenticated()//其他地址的访问均需验证权限

                .authorizeRequests()  //authorizeRequests()
                    .antMatchers("/auth/**").authenticated() //需要认证的url
                    .anyRequest().permitAll()//其他所有资源都不需要认证
                .and()
                    .formLogin()
                    .loginPage("/loginPage")
                    .defaultSuccessUrl("/index")//登录成功后默认跳转到"/hello"
//                    .failureUrl("/403")
                    .successHandler(myAuthenticationSuccessHandler)//登陆成功处理
                    .permitAll()
                .and()
                    .logout().permitAll().logoutSuccessUrl("/")//退出登录后的默认url是"/home"
//                .and()
//                    .rememberMe()//登录后记住用户，下次自动登录,数据库中必须存在名为persistent_logins的表
//                    .tokenValiditySeconds(1209600)
                .and()
                    .httpBasic().authenticationEntryPoint(new RestAuthenticationEntryPoint())//设置统一信息返回处理
                .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//无状态请求 不需要session
                .and()
                    .addFilter(getPreAuthenticatedProcessingFilter())//添加自定义登录验证过滤器
        ;

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
        //可以仿照上面一句忽略静态资源
    }


    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }


}
