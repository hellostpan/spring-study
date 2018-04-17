package com.stpan.springstudy.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ShiroTest {
    private SimpleAccountRealm realm;

    @Before
    public void setupMockMvc() throws Exception {
        realm = new SimpleAccountRealm();
        realm.addAccount("stpan","123456","admin","user");
    }

    @Test
    public void testShiro(){
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("stpan","123456");
        subject.login(token);

        System.out.println("-----------: "+subject.isAuthenticated());
        subject.checkRoles("admin","user");
        System.out.println("-----------: "+subject.isAuthenticated());
    }
}
