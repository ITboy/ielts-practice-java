package org.prepper.ieltspracticejava.dao.repository;

import org.prepper.ieltspracticejava.dao.entity.CambridgeListeningItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CambridgeListeningItemRepository extends CrudRepository<CambridgeListeningItem, Long> {

    List<CambridgeListeningItem> findByArticleId(long articleId);

    CambridgeListeningItem findById(long id);
}
