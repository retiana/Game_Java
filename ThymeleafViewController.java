package co.id.fwd.challange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafViewController {

    @GetMapping("/tictactoe")
    public String getGamePage() {
        return "start-game";
    }
}
