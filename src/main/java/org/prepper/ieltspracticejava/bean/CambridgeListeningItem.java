package org.prepper.ieltspracticejava.bean;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.prepper.ieltspracticejava.enums.CambridgeListeningItemType;

@Data
public class CambridgeListeningItem {
    private Integer id;

    private String english;

    private String chinese;

    private Long startTime;

    private Long endTime;

    private CambridgeListeningItemType itemType;

    @JsonIgnore
    private CambridgeListeningArticle article;

    @JsonGetter
    public int getItemType() {
        return itemType.ordinal();
    }
}
