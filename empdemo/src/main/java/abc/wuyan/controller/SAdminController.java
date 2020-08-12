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
import java.util.List;

@Controller
@RequestMapping("sadmin")
public class SAdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private PriService priService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("list")
    public String showSAdminList(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user_session");
        model.addAttribute("myUser", user);
        List<User> userList = new ArrayList<User>();
        model.addAttribute("userList", userList);
        return "sadmin/list";
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
        return "sadmin/list";
    }

    @RequestMapping("listAllAdmin")
    public String findAllAdmin(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user_session");
        model.addAttribute("myUser", user);
        List<User> userList = userService.findAll();
        List<User> userListAdmin = new ArrayList<User>();
        for (User emp : userList) {
            int userId = emp.getId();
            int roleId = userRoleService.findRoleIdByUserId(userId);
            if (roleId == 2) {
                userListAdmin.add(emp);
            } else {
                continue;
            }
        }
        model.addAttribute("userList", userListAdmin);
        return "sadmin/list";
    }

    @RequestMapping("listAdminByCondition")
    public String listAdminByCondition(@RequestParam String username, @RequestParam String gender,
                                       @RequestParam String attendance, Model model, HttpSession session) {
        User myUser = (User) session.getAttribute("user_session");
        model.addAttribute("myUser", myUser);
        List<User> userList = new ArrayList<User>();
        if (username == null && gender == null && attendance == null) {
            return "redirect:listAllAdmin.do";
        } else if (username == "" && gender == "" && attendance != "") {
            userList = userService.findByAttendance(attendance);
            userList = getAdminList(userList);
            model.addAttribute("userList", userList);
            return "sadmin/list";
        } else if (username == "" && gender != "" && attendance == "") {
            userList = userService.findByGender(gender);
            userList = getAdminList(userList);
            model.addAttribute("userList", userList);
            return "sadmin/list";
        } else if (username != "" && gender == "" && attendance == "") {
            userList = userService.findByName(username);
            userList = getAdminList(userList);
            model.addAttribute("userList", userList);
            return "sadmin/list";
        } else if (username == "" && gender != "" && attendance != "") {
            userList = userService.findByGenderAndAttend(gender, attendance);
            userList = getAdminList(userList);
            model.addAttribute("userList", userList);
            return "sadmin/list";
        } else if (username != "" && gender == "" && attendance != "") {
            userList = userService.findByNameAndAttend(username, attendance);
            userList = getAdminList(userList);
            model.addAttribute("userList", userList);
            return "sadmin/list";
        } else if (username != "" && gender != "" && attendance == "") {
            userList = userService.findByNameAndGender(username, gender);
            userList = getAdminList(userList);
            model.addAttribute("userList", userList);
            return "sadmin/list";
        } else {
            userList = userService.findByNameAndGenderAndAttend(username, gender, attendance);
            userList = getAdminList(userList);
            model.addAttribute("userList", userList);
            return "sadmin/list";
        }
    }

    @RequestMapping("listUserByCondition")
    public String listUserByCondition(@RequestParam String username, @RequestParam String gender,
                                      @RequestParam String attendance, Model model, HttpSession session) {
        User myUser = (User) session.getAttribute("user_session");
        model.addAttribute("myUser", myUser);
        List<User> userList = new ArrayList<User>();
        if (username == null && gender == null && attendance == null) {
            return "redirect:listAllAdmin.do";
        } else if (username == "" && gender == "" && attendance != "") {
            userList = userService.findByAttendance(attendance);
            model.addAttribute("userList", userList);
            return "sadmin/list";
        } else if (username == "" && gender != "" && attendance == "") {
            userList = userService.findByGender(gender);
            userList = getUserList(userList);
            model.addAttribute("userList", userList);
            return "sadmin/list";
        } else if (username != "" && gender == "" && attendance == "") {
            userList = userService.findByName(username);
            userList = getUserList(userList);
            model.addAttribute("userList", userList);
            return "sadmin/list";
        } else if (username == "" && gender != "" && attendance != "") {
            userList = userService.findByGenderAndAttend(gender, attendance);
            userList = getUserList(userList);
            model.addAttribute("userList", userList);
            return "sadmin/list";
        } else if (username != "" && gender == "" && attendance != "") {
            userList = userService.findByNameAndAttend(username, attendance);
            userList = getUserList(userList);
            model.addAttribute("userList", userList);
            return "sadmin/list";
        } else if (username != "" && gender != "" && attendance == "") {
            userList = userService.findByNameAndGender(username, gender);
            userList = getUserList(userList);
            model.addAttribute("userList", userList);
            return "sadmin/list";
        } else {
            userList = userService.findByNameAndGenderAndAttend(username, gender, attendance);
            userList = getUserList(userList);
            model.addAttribute("userList", userList);
            return "sadmin/list";
        }
    }

    @RequestMapping("edit")
    public String editUser(Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "sadmin/edit";
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

    @RequestMapping("addAdmin")
    public String addAdmin() {
        return "sadmin/addAdmin";
    }

    @RequestMapping("addUser")
    public String addUser() {
        return "sadmin/addUser";
    }

    @RequestMapping("insertAdmin")
    public String insertAdmin(User user) {
        userService.insert(user);
        user = userService.findByNameAndPasswordAndGender(user.getUsername(), user.getPassword(), user.getGender());
        int userId = user.getId();
        int roleId = 2;
        userRoleService.insertByUserId(userId, roleId);
        return "redirect:listAllUser.do";
    }

    @RequestMapping("insertUser")
    public String insertUser(User user) {
        userService.insert(user);
        user = userService.findByNameAndPasswordAndGender(user.getUsername(), user.getPassword(), user.getGender());
        int userId = user.getId();
        int roleId = 1;
        userRoleService.insertByUserId(userId, roleId);
        return "redirect:listAllUser.do";
    }

    /**
     * 普通用户筛选
     *
     * @param userList
     * @return
     */
    private List<User> getUserList(List<User> userList) {
        List<User> tmpList = new ArrayList<User>();
        for (User user : userList) {
            int userId = user.getId();
            int roleId = userRoleService.findRoleIdByUserId(userId);
            if (roleId == 1) {
                tmpList.add(user);
            }
        }
        return tmpList;
    }

    /**
     * 管理员筛选
     *
     * @param userList
     * @return
     */
    private List<User> getAdminList(List<User> userList) {
        List<User> tmpList = new ArrayList<User>();
        for (User user : userList) {
            int userId = user.getId();
            int roleId = userRoleService.findRoleIdByUserId(userId);
            if (roleId == 2) {
                tmpList.add(user);
            }
        }
        return tmpList;
    }
}
