package abc.wuyan.Intercept;

import abc.wuyan.model.Pri;
import abc.wuyan.model.Role;
import abc.wuyan.model.User;
import abc.wuyan.service.PriService;
import abc.wuyan.service.RoleService;
import abc.wuyan.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ResourcesInterceptor implements HandlerInterceptor {
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PriService priService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //获取请求的RUi:去除http:localhost:8080这部分剩下的
        String uri = request.getRequestURI();
        //UTL:除了login.jsp是可以公开访问的，其他的URL都进行拦截控制
        if (uri.contains("login") || uri.contains("register")||uri.contains("newUserInsert")||uri == "/") {
            System.out.println(uri);
            return true;
        }
        /**
         * 根据用户id获得角色id
         * 根据角色id获得角色内容
         * 根据角色获得权限id
         * 根据权限id获得权限范围和权限访问资源的关键字
         */
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user_session");
        int user_id = user.getId();
        int role_id = userRoleService.findRoleIdByUserId(user_id);
        Role role = roleService.findById(role_id);
        int pri_id = role.getRole_pri();
        Pri pri = priService.findById(pri_id);
        /**
         * 如果访问管理员路径资源要求pri==2
         * 如果访问系统管理员资源要求pri==3
         * 如果访问普通资源要求pri==1(所有普通用户pri==1)
         */
        if (uri.contains("sadmin") && user != null && pri.getId() == 3) {
            return true;
        } else if (uri.contains("admin") && user != null && pri.getId() == 2) {
            return true;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
