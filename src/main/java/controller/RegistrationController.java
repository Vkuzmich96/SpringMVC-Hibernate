package controller;

import data.Game;
import data.Profile;
import data.dao.GameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class RegistrationController {

    private String PROFILE_PAGE = "profile";


    @Autowired
    GameDAO gameDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("profileKey", new Profile());
        return PROFILE_PAGE;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registrationValid(
            @Valid @ModelAttribute("profileKey") Profile profile,
            BindingResult bindingResult,
            HttpServletResponse response,
            HttpSession session
    ) {
        if (bindingResult.getErrorCount()>0){
            return PROFILE_PAGE;
        }
        cookieAdder(response,profile);
        putKeyObjectInSession(session);

        return "redirect:/controller";
    }

    private void cookieAdder(HttpServletResponse response, Profile profile){
        Cookie cookie = new Cookie(profile.getLogin(),"welcome");
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    private void putKeyObjectInSession (HttpSession session){
        session.setAttribute("gameKey", gameDAO.firstSave(new Game()));
    }
}
