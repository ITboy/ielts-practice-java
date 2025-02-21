package org.prepper.ieltspracticejava.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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

    @Column(length=4096)
    private String english;

    @Column(length=4096)
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
