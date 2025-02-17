package org.prepper.ieltspracticejava.controller;

import org.prepper.ieltspracticejava.bean.CambridgeListeningArticle;
import org.prepper.ieltspracticejava.service.CambridgeListeningPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CambridgeListeningPlayerController {

    @Autowired
    private CambridgeListeningPlayerService cambridgeListeningPlayerService;

    @GetMapping(path = "/cambridge-listening/player/article")
    public CambridgeListeningArticle queryArticle(@RequestParam Integer bookNum, @RequestParam Integer testNum, @RequestParam Integer partNum) {
        return cambridgeListeningPlayerService.findArticle(bookNum, testNum, partNum);
    }

    @GetMapping(path = "/cambridge-listening/player/init-data")
    public String initData() {
        cambridgeListeningPlayerService.initData();
        return "success";
    }
}
