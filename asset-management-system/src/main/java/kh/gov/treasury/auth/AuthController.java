package kh.gov.treasury.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthController {

	@GetMapping("/login")
    public String login(@RequestParam(name = "loginRequired", required = false) final Boolean loginRequire,
            @RequestParam(name = "loginError", required = false) final Boolean loginErro,
            @RequestParam(name = "logoutSuccess", required = false) final Boolean logoutSucces,
            final Model model) {
        model.addAttribute("authentication", new AuthLoginRequest());
        if (loginRequire == Boolean.TRUE) {
            model.addAttribute("message", "authentication.login.required");
        }
        if (loginErro == Boolean.TRUE) {
            model.addAttribute("message", "authentication.login.error");
        }
        if (logoutSucces == Boolean.TRUE) {
            model.addAttribute("message", "authentication.logout.success");
        }
        return "auth/Login";
    }
	
	// Redirect to home page
	@GetMapping
    public String handleCssRequest() {
		return "redirect:/home";
    }
	
}
