package org.prepper.ieltspracticejava.dao.repository;

import org.prepper.ieltspracticejava.dao.entity.CambridgeListeningArticle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CambridgeListeningArticleRepository extends CrudRepository<CambridgeListeningArticle, Long> {
    CambridgeListeningArticle findFirstByBookNumAndTestNumAndPartNum(Integer bookNum, Integer testNum, Integer partNum);

    CambridgeListeningArticle findById(Integer id);

    List<CambridgeListeningArticle> findAll();
}