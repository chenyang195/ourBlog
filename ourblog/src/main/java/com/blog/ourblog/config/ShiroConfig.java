package com.blog.ourblog.config;

import com.blog.ourblog.realm.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        /**
         * shiro内置过滤器，可以实现权限相关的拦截器
         *  常用的过滤器
         *      anon:无需认证
         *      authc:必须认证
         *      user:如果使用remeberMe可以直接访问
         *      perms:该资源必须得到资源权限才能访问
         *      role:该资源必须得到角色权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/test","anon");
        filterMap.put("/log","anon");

        filterMap.put("/update","authc");
        filterMap.put("/logout","authc");

        //授权过滤器
        filterMap.put("/add","perms[user:add]");

        filterMap.put("/*","authc");
        //设置未认证跳转页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //设置未授权跳转页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }
    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    /**
     * 创建Realm
     */
    @Bean(name ="userRealm" )
    public UserRealm getRealm(){
        return new UserRealm();
    }
}
