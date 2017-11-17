package pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.modells.Market;
import pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.modells.entities.UserInput2;


@Controller
public class MarketController {

    private Market market = new Market();

    @GetMapping("/mar") public String marketGet(Model model){
        model.addAttribute("availableList", market.showAllItems());
        model.addAttribute("userInput2", new UserInput2());
        return "market";
    }

    @PostMapping("/mar") public String marketPost(@ModelAttribute UserInput2 userInput2, Model model){
        model.addAttribute("availableList", market.showAllItems());
        market.addItem(market.parseEnum(userInput2.getInputKey()), market.parseInt(userInput2.getInputValue()));
        model.addAttribute("shopList", market.showCurrentList());
        model.addAttribute("totalCost", market.calculatePrice());
        return "market";
    }
}