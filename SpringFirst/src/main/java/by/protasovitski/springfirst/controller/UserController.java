package by.protasovitski.springfirst.controller;


import by.protasovitski.springfirst.dto.RegisterUserDto;
import by.protasovitski.springfirst.entities.User;
import by.protasovitski.springfirst.exceptions.RegistrationException;
import by.protasovitski.springfirst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping
public class UserController {

    private List<User> users;

    @Autowired
    private UserService userService;

    @GetMapping("/registerUser")
    public ModelAndView userList(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registerUser");
        model.addAttribute("registerUserDto", new RegisterUserDto());
        return modelAndView;
    }

    @PostMapping(value = {"/registerUser"})
    public ModelAndView savePerson(Model model, @Valid @ModelAttribute("registerUserDto") RegisterUserDto registerUserDto,
                                   Errors errors) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.register(registerUserDto);
        } catch (RegistrationException e) {
            e.printStackTrace();
            modelAndView.setViewName("registerUser");
        }
        modelAndView.setViewName("redirect:/index");
        return modelAndView;
    }


}
