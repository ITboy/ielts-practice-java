package org.prepper.ieltspracticejava.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
/**
 * create table cambridge_listening_item (id int not null, item_type tinyint not null, english text, chinese text, start_time bigint not null, stop_time bigint not null, article_id int not null);
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CambridgeListeningItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String english;

    private String chinese;

    private Long startTime;

    private Long endTime;

    /**
     * @see org.prepper.ieltspracticejava.enums.CambridgeListeningItemType
     *
     * 0 - prologue
     * 1 - content
     * 2 - interlude
     * 3 - epilogue
     */
    private Byte itemType;

    private Integer articleId;
}
