package abc.wuyan.controller;

import abc.wuyan.model.Pri;
import abc.wuyan.model.Role;
import abc.wuyan.model.User;
import abc.wuyan.service.PriService;
import abc.wuyan.service.RoleService;
import abc.wuyan.service.UserRoleService;
import abc.wuyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PriService priService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("list")
    public String findById(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user_session");
        int user_id = user.getId();
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        model.addAttribute("userList", userList);
        return "user/list";
    }

    /**
     * 用户登录功能实现：
     * 如果是普通用户则跳转到普通户信息展示界面
     * 如果是管理员用户则跳转到管理员用户信息展示界面
     * 如果是系统管理员则跳转到系统管理员界面
     */

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String userLogin(@RequestParam String username, @RequestParam String password,
                            @RequestParam String gender, HttpSession session) {
        User user = userService.findByNameAndPasswordAndGender(username, password, gender);
        if (user == null) {
            return "redirect:relogin.do";
        } else {
            /**
             * 登录时将用户信息存入session
             * 并校验权限确定返回界面
             */
            int user_id = user.getId();
            int role_id = userRoleService.findRoleIdByUserId(user_id);
            Role role = roleService.findById(role_id);
            int pri_id = role.getRole_pri();
            Pri pri = priService.findById(pri_id);
            session.setAttribute("user_session", user);
            if (pri.getId() == 1) {
                return "redirect:list.do";
            } else if (pri.getId() == 2) {
                return "redirect:/admin/list.do";
            } else {
                return "redirect:/sadmin/list.do";
            }
        }
    }

    /**
     * 返回登录首页
     */
    @RequestMapping(value = "relogin")
    public String UserReLogin(Model model) {
        model.addAttribute("msg", "您还没有登录，请先登录！");
        return "user/login";
    }

    /**
     * 新用户注册
     */
    @RequestMapping(value = "newUserInsert")
    public String insert(User user, HttpServletRequest request ){
        boolean isUserExist = false;
        String username = user.getUsername();
        List<User> userList = userService.findAll();
        for (User temp : userList) {
            if (temp.getUsername().equals(username)) {
                isUserExist = true;
            }
        }
        if (isUserExist) {
            //不符合条件的给出提示信息，并转发到登录页面
            request.setAttribute("msg", "该用户名已被使用！");
            return "user/register";
        } else {
            userService.insert(user);
            user = userService.findByNameAndPasswordAndGender(user.getUsername(), user.getPassword(), user.getGender());
            int userId = user.getId();
            int roleId = 1;
            userRoleService.insertByUserId(userId, roleId);
            return "user/login";
        }
    }

    /**
     * 退出页面
     */
    @RequestMapping("logout")
    public String logout() {
        return "user/logout";
    }

    @RequestMapping("register")
    public String register() {
        return "user/register";
    }
}
