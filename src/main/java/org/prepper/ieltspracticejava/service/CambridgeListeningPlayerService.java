package org.prepper.ieltspracticejava.service;

import org.prepper.ieltspracticejava.bean.CambridgeListeningArticle;

public interface CambridgeListeningPlayerService {

    void initData();

    CambridgeListeningArticle findArticle(int bookNum, int testNum, int partNum);
}
