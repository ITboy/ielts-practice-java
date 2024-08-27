package org.prepper.ieltspracticejava.dao.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.prepper.ieltspracticejava.dao.entity.CambridgeListeningArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CambridgeListeningArticleRepositoryTest {
    @Autowired
    CambridgeListeningArticleRepository cambridgeListeningArticleRepository;

    private CambridgeListeningArticle cambridgeListeningArticle;

    @BeforeEach
    void setup() {
        cambridgeListeningArticle = new CambridgeListeningArticle();
        cambridgeListeningArticle.setBookNum(11);
        cambridgeListeningArticle.setTestNum(1);
        cambridgeListeningArticle.setPartNum(1);
        cambridgeListeningArticle.setVideoPath("/ielts/practice");
    }

    @Test
    void testSave() {
        CambridgeListeningArticle savedArticle = cambridgeListeningArticleRepository.save(cambridgeListeningArticle);
        Assertions.assertNotNull(savedArticle.getId());
    }

    @Test
    void testFindById() {
        CambridgeListeningArticle article = cambridgeListeningArticleRepository.findFirstByBookNumAndTestNumAndPartNum(11,1, 1);
        Assertions.assertEquals(11, article.getBookNum());
        Assertions.assertEquals(1, article.getTestNum());
        Assertions.assertEquals(1, article.getPartNum());
        Assertions.assertEquals("/ielts/practice", article.getVideoPath());
    }
}
