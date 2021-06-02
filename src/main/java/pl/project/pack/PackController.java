package pl.project.pack;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.project.user.UserService;

@Controller
public class PackController {
    private PackRepository packRepository;
    private PackService packService;

    public PackController(PackRepository packRepository, PackService packService) {
        this.packRepository = packRepository;
        this.packService = packService;
    }

    @GetMapping("/pack")
    public String getPackForm(ModelMap modelMap, UserService userService) {
        modelMap.addAttribute("pack", new Pack());
        modelMap.addAttribute("userId", userService.getCustomUserId());
        return "pack";
    }

    @PostMapping("/pack")
    public String addPack(ModelMap modelMap, @Validated Pack pack, UserService userService, BindingResult bindingResult) {
        modelMap.addAttribute("pack", pack);
        ModelMap model = modelMap.addAttribute("checkbox", true);
        if (bindingResult.hasErrors()) {
            return "pack";
        }
        try {
            if(model.containsValue(true)){
                pack.setPackToWarehouse(true);
                pack.setUser(userService.getCustomUser());
                pack.setPackId(packRepository.findFirstEmptyPlaceToStorePack());
                packService.save(pack);
            }
        } catch (DataIntegrityViolationException e) {
            return "pack";
        }
        return "user";
    }
}
