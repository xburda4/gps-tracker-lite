package burda.springtest.controllers;

import burda.springtest.dto.UserDto;
import burda.springtest.exceptions.EmailExistsException;
import burda.springtest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

public class RegistrationController {
    @Autowired
    UserService service;

    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = UserDto.emptyUser();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/user/registration")
    public ModelAndView registerUserAccount
            (@ModelAttribute("user") @Valid UserDto accountDto,
             BindingResult result, WebRequest request, Errors errors) {
        User registered = null;
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        // TODO:rest of the implementation
        return null;
    }

    private User createUserAccount(UserDto accountDto, BindingResult result) {
        User registered = null;
        try {
            registered = service.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            return null;
        }
        return registered;
    }
}
