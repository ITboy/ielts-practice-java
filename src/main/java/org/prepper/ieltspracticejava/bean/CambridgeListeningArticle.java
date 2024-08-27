package org.prepper.ieltspracticejava.bean;

import lombok.Data;

import java.util.List;

@Data
public class CambridgeListeningArticle {
    private Integer id;

    private Integer bookNum;

    private Integer testNum;

    private Integer partNum;

    private String videoPath;

    private List<CambridgeListeningItem> items;
}
