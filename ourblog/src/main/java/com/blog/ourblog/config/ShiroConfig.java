package com.blog.ourblog.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.blog.ourblog.realm.UserRealm;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSession;
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
        //放行静态资源
        filterMap.put("/layui/**","anon");
        filterMap.put("/css/**","anon");
        filterMap.put("/release/**","anon");
        filterMap.put("/wangEditor/**","anon");

        filterMap.put("/","anon");
        filterMap.put("/getVerificationCode","anon");
        filterMap.put("/log","anon");
        filterMap.put("/reg","anon");
        filterMap.put("/login","anon");
        filterMap.put("/register","anon");
        filterMap.put("/favicon.ico","anon");
        filterMap.put("/getImage","anon");
        filterMap.put("/getHomePage","anon");
        filterMap.put("/showArticle","anon");




        filterMap.put("/logoutme","user");
        filterMap.put("/getProfilePhoto","user");
        filterMap.put("/editor","user");
        filterMap.put("/uploadImage","user");


        //授权过滤器
        filterMap.put("/test","perms[user:read]");
        filterMap.put("/admin","perms[admin:administrate]");


        filterMap.put("/*","user");
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

        securityManager.setRememberMeManager(rememberMeManager());

        return securityManager;
    }
    /**
     * 创建Realm
     */
    @Bean(name ="userRealm" )
    public UserRealm getRealm(HashedCredentialsMatcher hashedCredentialsMatcher){
        UserRealm userRealm= new UserRealm();
        //配置加密
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return userRealm;
    }


    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 采用MD5方式加密
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        // 设置加密次数
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }
/**
  * cookie对象;
   * rememberMeCookie()方法是设置Cookie的生成模版，比如cookie的name，cookie的有效时间等等。
   * @return
*/
    @Bean
    public SimpleCookie rememberMeCookie(){
              //System.out.println("ShiroConfiguration.rememberMeCookie()");
            //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
              SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
               //<!-- 记住我cookie生效时间30天 ,单位秒;-->
               simpleCookie.setMaxAge(60*60*24*30);
              return simpleCookie;
    }
    /**
     * cookie管理对象;
     * rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
      * @return
     */
 @Bean
 public CookieRememberMeManager rememberMeManager(){
               //System.out.println("ShiroConfiguration.rememberMeManager()");
             CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
               cookieRememberMeManager.setCookie(rememberMeCookie());
              //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)

              cookieRememberMeManager.setCipherKey(Base64.decode("6ZmI6I2j5Y+R5aSn5ZOlAA=="));
           return cookieRememberMeManager;
         }



    @Bean(name = "shiroDialect")

    public ShiroDialect shiroDialect(){

        return new ShiroDialect();

    }



}
