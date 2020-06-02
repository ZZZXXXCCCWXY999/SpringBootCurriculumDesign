package xyz.zxcwxy999.curriculumdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.ArrayList;
import java.util.List;

/**
 * 主页控制器
 */
@Controller
public class MainController {



    @GetMapping("/")
    public String root(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errMsg", "登录失败，用户名或密码错误！！！");
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

//    /**
//     * 注册用户
//     * @param user
//     * @return
//     */
//    @PostMapping("/register")
//    public String registerUser(User user){
//        List<Authority> authorities=new ArrayList<>();
//        authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID).get());
//        user.setAuthorities(authorities);
//        userService.registerUser(user);
//        return "redirect:/login";
//    }
}
