package org.footgoat.player;


import lombok.RequiredArgsConstructor;
import org.footgoat.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PlayerViewController {

    private final PlayerService playerService;

    @GetMapping("/players")
    public String players(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            Model model) {

        Page<Player> playersPage =
                playerService.getPlayers(page, size);

        model.addAttribute("playersPage", playersPage);
        model.addAttribute("currentPage", page);

        return "players";
    }
}
