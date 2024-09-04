package org.prepper.ieltspracticejava.service.impl;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.TypeRef;
import lombok.extern.slf4j.Slf4j;
import org.prepper.ieltspracticejava.bean.*;
import org.prepper.ieltspracticejava.dao.repository.CambridgeListeningArticleRepository;
import org.prepper.ieltspracticejava.dao.repository.CambridgeListeningItemRepository;
import org.prepper.ieltspracticejava.enums.CambridgeListeningItemType;
import org.prepper.ieltspracticejava.service.CambridgeListeningPlayerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CambridgeListeningPlayerServiceImpl implements CambridgeListeningPlayerService {
    @Autowired
    private CambridgeListeningArticleRepository cambridgeListeningArticleRepository;

    @Autowired
    private CambridgeListeningItemRepository cambridgeListeningItemRepository;

    @Autowired
    private Configuration itongzhuoConfiguration;

    private void doSave(int bookId, int testId, int partId, String dataJson) {
        org.prepper.ieltspracticejava.dao.entity.CambridgeListeningArticle article = new org.prepper.ieltspracticejava.dao.entity.CambridgeListeningArticle();
        article.setBookNum(bookId);
        article.setTestNum(testId);
        article.setPartNum(partId);
        DocumentContext documentContext = JsonPath.parse(dataJson);
        String fileUrl = documentContext.read("$.returnData.listen.lFileUrl");
        article.setVideoPath(fileUrl);
        article = cambridgeListeningArticleRepository.save(article);
        List<org.prepper.ieltspracticejava.dao.entity.CambridgeListeningItem> items = documentContext
                .read("$.returnData.mockListenList[*]", new TypeRef<List<org.prepper.ieltspracticejava.dao.entity.CambridgeListeningItem>>() {});
        log.info("items: {}", items);
        for (org.prepper.ieltspracticejava.dao.entity.CambridgeListeningItem item : items) {
            item.setItemType(CambridgeListeningItemType.CONTENT.getValue());
            item.setArticleId(article.getId());
            cambridgeListeningItemRepository.save(item);
        }
    }

    @Override
    public void saveArticle(int bookId, int testId, int partId, String htmlBody) {
        doSave(bookId, testId, partId, htmlBody);
    }

    @Override
    public List<CambridgeListeningArticle> findArticles() {
        List<org.prepper.ieltspracticejava.dao.entity.CambridgeListeningArticle> originArticles = cambridgeListeningArticleRepository.findAll();
        return originArticles.stream().map(originArticle -> {
            CambridgeListeningArticle article = new CambridgeListeningArticle();
            BeanUtils.copyProperties(originArticle, article);
            return article;
        }).collect(Collectors.toList());
    }

    @Override
    public void splitItem(long splitItemId, long nextItemId, long splitTime) {
        org.prepper.ieltspracticejava.dao.entity.CambridgeListeningItem currentItem = cambridgeListeningItemRepository.findById(splitItemId);
        org.prepper.ieltspracticejava.dao.entity.CambridgeListeningItem nextItem = cambridgeListeningItemRepository.findById(nextItemId);

        org.prepper.ieltspracticejava.dao.entity.CambridgeListeningItem newItem = new org.prepper.ieltspracticejava.dao.entity.CambridgeListeningItem();
        currentItem.setEndTime(splitTime);
        newItem.setStartTime(splitTime);
        newItem.setEndTime(nextItem.getStartTime());
        newItem.setArticleId(currentItem.getArticleId());
        newItem.setItemType(CambridgeListeningItemType.INTERLUDE.getValue());
        cambridgeListeningItemRepository.save(currentItem);
        cambridgeListeningItemRepository.save(newItem);
    }

    @Override
    public CambridgeListeningArticle findArticle(int bookNum, int testNum, int partNum) {
        org.prepper.ieltspracticejava.dao.entity.CambridgeListeningArticle  article = cambridgeListeningArticleRepository.findFirstByBookNumAndTestNumAndPartNum(bookNum, testNum, partNum);
        if (Objects.isNull(article)) {
            log.info("can't find any cambridge article by bootNum: {}, testNum: {}, partNum: {}", bookNum, testNum, partNum);
            return null;
        }

        List<org.prepper.ieltspracticejava.dao.entity.CambridgeListeningItem > items = cambridgeListeningItemRepository.findByArticleId(article.getId());
        if (!CollectionUtils.isEmpty(items)) {
            CambridgeListeningArticle cambridgeListeningArticle = new CambridgeListeningArticle();
            BeanUtils.copyProperties(article, cambridgeListeningArticle);
            List<CambridgeListeningItem> cambridgeListeningItems = items.stream().map(item -> {
                CambridgeListeningItem cambridgeListeningItem = new CambridgeListeningItem();;
                BeanUtils.copyProperties(item, cambridgeListeningItem);
                cambridgeListeningItem.setItemType(CambridgeListeningItemType.valueOf(item.getItemType()));
                cambridgeListeningItem.setArticle(cambridgeListeningArticle);
                return cambridgeListeningItem;
            }).collect(Collectors.toList());
            cambridgeListeningArticle.setItems(cambridgeListeningItems);
            return cambridgeListeningArticle;
        }
        return null;
    }
}
