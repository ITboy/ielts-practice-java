package org.prepper.ieltspracticejava.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
/**
 * create table cambridge_listening_article (id int not null, book_num int not null, part_num int not null, video_path varchar(1024) not null);
 * ALTER TABLE cambridge_listening_article add primary key (id);
 */
public class CambridgeListeningArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer bookNum;

    private Integer testNum;

    private Integer partNum;

    private String videoPath;
}
