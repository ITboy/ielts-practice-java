package org.prepper.ieltspracticejava.service;

import org.prepper.ieltspracticejava.bean.CambridgeListeningArticle;

import java.util.List;

public interface CambridgeListeningPlayerService {

    void saveArticle(int bookId, int testId, int partId, String htmlBody);

    CambridgeListeningArticle findArticle(int bookNum, int testNum, int partNum);

    List<CambridgeListeningArticle> findArticles();
}
