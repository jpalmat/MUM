package mum.cs.controller;
import mum.cs.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
@Controller
public class UserController {
    @RequestMapping(value={"/", "/add"}, method = RequestMethod.GET)
    public String defaultPage(@ModelAttribute("user") User user, Model model){
        return "userForm";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String addNewUser(@Valid  @ModelAttribute("user") User user, BindingResult result, RedirectAttributes redirectAttributes, Model model){
        if(result.hasErrors()){
            return "userForm";
        }
        else{
            redirectAttributes.addFlashAttribute(user);
            return "redirect:/displayDetails";
        }
    }
    @RequestMapping(value = "/displayDetails")
    public String displayUsers( ){
        return "successPage";
    }
}