package abc.wuyan.controller;

import abc.wuyan.model.User;
import abc.wuyan.service.PriService;
import abc.wuyan.service.RoleService;
import abc.wuyan.service.UserRoleService;
import abc.wuyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminContrller {
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
        model.addAttribute("myUser", user);
        List<User> userList = new ArrayList<User>();
        model.addAttribute("userList", userList);
        return "admin/list";
    }

    @RequestMapping("listAllUser")
    public String findAllUser(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user_session");
        model.addAttribute("myUser", user);
        List<User> userList = userService.findAll();
        List<User> userListExpAdmin = new ArrayList<User>();
        for (User emp : userList) {
            int userId = emp.getId();
            int roleId = userRoleService.findRoleIdByUserId(userId);
            if (roleId == 1) {
                userListExpAdmin.add(emp);
            } else {
                continue;
            }
        }
        model.addAttribute("userList", userListExpAdmin);
        return "admin/list";
    }

    @RequestMapping("listByCondition")
    public String listByCondition(@RequestParam String username, @RequestParam String gender,
                                  @RequestParam String attendance, Model model, HttpSession session) {
        User myUser = (User) session.getAttribute("user_session");
        model.addAttribute("myUser", myUser);
        List<User> userList = new ArrayList<User>();
        if (username == null && gender == null && attendance == null) {
            return "redirect:listAllUser.do";
        } else if (username == "" && gender == "" && attendance != "") {
            userList = userService.findByAttendance(attendance);
            model.addAttribute("userList", userList);
            return "admin/list";
        } else {
            return "redirect:listAllUser.do";
        }
    }

    @RequestMapping("edit")
    public String editUser(Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "admin/edit";
    }

    @RequestMapping("update")
    public String update(User user) {
        userService.update(user);
        return "redirect:listAllUser.do";
    }

    @RequestMapping("delete")
    public String delete(Integer id) {
        userService.delete(id);
        return "redirect:listAllUser.do";
    }

    @RequestMapping("add")
    public String add() {
        return "admin/add";
    }

    @RequestMapping("insert")
    public String insert(User user) {
        userService.insert(user);
        user = userService.findByNameAndPasswordAndGender(user.getUsername(), user.getPassword(), user.getGender());
        int userId = user.getId();
        int roleId = 1;
        userRoleService.insertByUserId(userId, roleId);
        return "redirect:listAllUser.do";
    }
}
