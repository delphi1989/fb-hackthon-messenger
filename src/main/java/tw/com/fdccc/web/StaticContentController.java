package tw.com.fdccc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticContentController {

    @RequestMapping("/")
    public String returnIndex() {
        return "main/index";
    }

    @RequestMapping("/fans")
    public String returnFans() {
        return "main/fans";
    }

    @RequestMapping("/awards")
    public String returnAwards() {
        return "main/awards";
    }

    @RequestMapping("/quests")
    public String returnQuests() {
        return "main/quests";
    }
}
