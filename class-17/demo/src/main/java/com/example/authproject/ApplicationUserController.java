package com.example.authproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.jws.WebParam;
import java.security.Principal;
import java.util.ArrayList;

@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup.html";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login.html";
    }

    @PostMapping("/signup")
    public RedirectView signup(@RequestParam(value="username") String username, @RequestParam(value="password") String password){
        ApplicationUser newUser = new ApplicationUser(username,bCryptPasswordEncoder.encode(password));
        newUser = applicationUserRepository.save(newUser);

//        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/login");
    }

    @GetMapping("/myprofile")
    public String getUserProfilePage(Principal p,Model m){
        m.addAttribute("user", ((UsernamePasswordAuthenticationToken)p).getPrincipal());
        return "profile.html";
    }

    @GetMapping("/profiles/{id}")
    public String getUserProfile(Principal p, Model m, @PathVariable Integer id){
        ApplicationUser requiredProfile = applicationUserRepository.findById(id).get();
        if(requiredProfile != null){
            m.addAttribute("user", requiredProfile);
            String loggedInUserName= p.getName();
            ApplicationUser loggedInUser = applicationUserRepository.findByUsername(loggedInUserName);
            boolean isAllowedToEdit = loggedInUser.getId() == id;
            m.addAttribute("isAllowedToEdit",isAllowedToEdit);
            return "profile.html";
        } else {
            m.addAttribute("message","this user doesn't exist");
            return "error.html";
        }
    }

    @PutMapping("/profiles/{id}")
    public RedirectView editProfile(Principal p, @PathVariable Integer id, @RequestParam String username){
        System.out.println("we are editing !");
        String loggedInUserName = p.getName();
        ApplicationUser loggedInUser = applicationUserRepository.findByUsername(loggedInUserName);
        if(loggedInUser.getId() == id) {
            loggedInUser.setUsername(username);
            applicationUserRepository.save(loggedInUser);
            return new RedirectView("/profiles/"+id);
        } else {
            return new RedirectView("/error?message=Unauthorized");
        }
    }

    @GetMapping("/error")
    public String getErrorPage(@RequestParam String message, Model m){
        m.addAttribute("message", message);
        return "error.html";
    }

}
