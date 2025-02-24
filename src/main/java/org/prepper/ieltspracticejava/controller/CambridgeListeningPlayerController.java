package org.prepper.ieltspracticejava.controller;

import org.prepper.ieltspracticejava.bean.CambridgeListeningArticle;
import org.prepper.ieltspracticejava.service.CambridgeListeningPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CambridgeListeningPlayerController {

    @Autowired
    private CambridgeListeningPlayerService cambridgeListeningPlayerService;

    @GetMapping(path = "/cambridge-listening/player/articles")
    public List<CambridgeListeningArticle> queryArticles() {
        return cambridgeListeningPlayerService.findArticles();
    }

    @GetMapping(path = "/cambridge-listening/player/article")
    public CambridgeListeningArticle queryArticle(@RequestParam Integer bookNum, @RequestParam Integer testNum, @RequestParam Integer partNum) {
        return cambridgeListeningPlayerService.findArticle(bookNum, testNum, partNum);
    }

    @GetMapping(path = "/cambridge-listening/player/split-item")
    public String splitItem(@RequestParam Long splitItemId, @RequestParam Long nextItemId, @RequestParam Long splitTime) {
        cambridgeListeningPlayerService.splitItem(splitItemId, nextItemId, splitTime);
        return "success";
    }

    @PostMapping(path = "/cambridge-listening/player/save-article")
    public String saveArticle(@RequestParam Integer bookId, @RequestParam Integer testId, @RequestParam Integer partId, @RequestBody String body) {
        cambridgeListeningPlayerService.saveArticle(bookId, testId, partId, body);
        return "success";
    }
}
