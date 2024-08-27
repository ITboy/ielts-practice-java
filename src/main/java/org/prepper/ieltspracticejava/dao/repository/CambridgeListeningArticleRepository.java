package org.prepper.ieltspracticejava.dao.repository;

import org.prepper.ieltspracticejava.dao.entity.CambridgeListeningArticle;
import org.springframework.data.repository.CrudRepository;

public interface CambridgeListeningArticleRepository extends CrudRepository<CambridgeListeningArticle, Long> {
    CambridgeListeningArticle findFirstByBookNumAndTestNumAndPartNum(Integer bookNum, Integer testNum, Integer partNum);

    CambridgeListeningArticle findById(Integer id);

}