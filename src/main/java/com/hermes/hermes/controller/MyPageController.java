package com.hermes.hermes.controller;

import com.hermes.hermes.dto.User;
import com.hermes.hermes.mapper.MyPageMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPageController {

    @Autowired
    private MyPageMapper myPageMapper;

    @GetMapping("/mypage")
    public String my_page(Model model, HttpSession session) {

        /*
        @PathVariable int userId, Model model
        User user = userprofileService.getUser(userId);
        model.addAttribute("user", user);
         */

        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("user", loggedInUser);
        } else {
            model.addAttribute("user", new User(1, "user1", "pw1", null, "answer1", "username"));
        }
        return "mypage";
    }

}
