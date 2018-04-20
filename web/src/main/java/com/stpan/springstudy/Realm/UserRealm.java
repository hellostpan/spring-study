package com.stpan.springstudy.Realm;

import com.stpan.springstudy.pojo.Role;
import com.stpan.springstudy.pojo.RoleExample;
import com.stpan.springstudy.pojo.User;
import com.stpan.springstudy.pojo.UserExample;
import com.stpan.springstudy.service.PermissionService;
import com.stpan.springstudy.service.RoleService;
import com.stpan.springstudy.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String name = (String) principalCollection.getPrimaryPrincipal();
        UserExample userExample = new UserExample();
        userExample.or().andUserNameEqualTo(name);
        User user = userService.queryUserList(userExample).get(0);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        RoleExample roleExample = new RoleExample();


        List<Role> roles = roleService.findRoles(roleExample);

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        return null;
    }
}
