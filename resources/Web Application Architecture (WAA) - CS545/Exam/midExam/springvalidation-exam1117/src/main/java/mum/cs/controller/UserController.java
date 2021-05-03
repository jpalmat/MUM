package mum.cs.controller;

import mum.cs.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
@Controller
public class UserController {
//How to mount the collection to ModelAttribute is stated in video 42, from 17' to 19'
    @ModelAttribute("roles")
    private Map<String, String> populatedRoles( Model  model){
        Map<String, String> roleMap= new HashMap<>();
        roleMap.put("Admin ", "Admin");
        roleMap.put("DBA", "DBA");
        return roleMap;
    }

    @GetMapping(value = {"/","/user/add"})
    public  String getUserForm(@ModelAttribute("user") User user,  Model model){
        return "userForm";
    }

    @PostMapping("/user/add")
    public String saveUser(@Valid User user, BindingResult bindingResult,  RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "userForm";
        }
        redirectAttributes.addFlashAttribute(user);
        return "redirect:/user/userDetails";
    }

    @GetMapping("/user/userDetails")
    public String displayDetail(){
        return "success";
    }
}