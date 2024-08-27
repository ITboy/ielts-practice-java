package org.prepper.ieltspracticejava.service.impl;

import com.jayway.jsonpath.Configuration;
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

    private void doInit(String dataJson) {
        List<org.prepper.ieltspracticejava.dao.entity.CambridgeListeningItem> items = JsonPath.parse(dataJson)
                .read("$.returnData.mockListenList[*]", new TypeRef<List<org.prepper.ieltspracticejava.dao.entity.CambridgeListeningItem>>() {});
        log.info("items: {}", items);
        items.stream().forEach(item -> {
            item.setItemType(CambridgeListeningItemType.CONTENT.getValue());
            item.setArticleId(252);
            cambridgeListeningItemRepository.save(item);
        });
    }

    @Override
    public void initData() {
        String jsonData = "{\n" +
                "    \"returnState\": \"OK\",\n" +
                "    \"returnMsg\": \"查询成功\",\n" +
                "    \"returnData\": {\n" +
                "        \"mockListenList\": [\n" +
                "            {\n" +
                "                \"listId\": 10860,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 126701,\n" +
                "                \"endTime\": 127590,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"Hello?\",\n" +
                "                \"chinese\": \"你好？\",\n" +
                "                \"questionNumber\": null,\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 126701,\n" +
                "                \"endTimeD\": 127590\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10861,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 127591,\n" +
                "                \"endTime\": 135440,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"Oh, hello.I wanted to enquire about hiring a room in the Village Hall, for the evening of September the first.\",\n" +
                "                \"chinese\": \"哦,你好。我想打听一下9月1日晚上在村厅租一个房间的事。\",\n" +
                "                \"questionNumber\": \"\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 127591,\n" +
                "                \"endTimeD\": 135440\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10862,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 135441,\n" +
                "                \"endTime\": 150220,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"Let me just see ...Yes, we have both rooms available that evening.There's our Main Hall - that's got seating for  200 people.Or there's the Charlton Room ...\",\n" +
                "                \"chinese\": \"让我看看......是的，我们那天晚上有两个房间。那里是我们的主厅——有 200 人的座位。或者还有查尔顿厅......\",\n" +
                "                \"questionNumber\": null,\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 135441,\n" +
                "                \"endTimeD\": 150220\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10863,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 150221,\n" +
                "                \"endTime\": 151210,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"Sorry?\",\n" +
                "                \"chinese\": \"对不起？\",\n" +
                "                \"questionNumber\": null,\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 150221,\n" +
                "                \"endTimeD\": 151210\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10864,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 151211,\n" +
                "                \"endTime\": 158760,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"The Charlton Room - C-H-A-R L-T-O-N.(Q1)\",\n" +
                "                \"chinese\": \"查尔顿厅 - C-H-A-R L-T-O-N。(Q1)\",\n" +
                "                \"questionNumber\": \"1\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 151211,\n" +
                "                \"endTimeD\": 158760\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10865,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 158761,\n" +
                "                \"endTime\": 162080,\n" +
                "                \"name\": \"\",\n" +
                "                \"english\": \"That's got seating for up to one hundred.\",\n" +
                "                \"chinese\": \"最多可容纳一百个座位。\",\n" +
                "                \"questionNumber\": \"1\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 158761,\n" +
                "                \"endTimeD\": 162080\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10866,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 162081,\n" +
                "                \"endTime\": 177320,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"Well, we're organising a dinner to raise money for a charity, and we're hoping for at least 150 people, so I think we'll go for the Main Hall.How much would that cost?\",\n" +
                "                \"chinese\": \"嗯，我们正在组织一场晚宴来为慈善机构筹集资金，我们希望至少有 150 人参加，所以我想我们会去主厅。那要花多少钱？\",\n" +
                "                \"questionNumber\": \"2\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 162081,\n" +
                "                \"endTimeD\": 177320\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10867,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 177321,\n" +
                "                \"endTime\": 182700,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"Let's see.You wanted it for the evening of September 1st?\",\n" +
                "                \"chinese\": \"让我们看看。你想要 9 月 1 日晚上的吗？\",\n" +
                "                \"questionNumber\": \"2\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 177321,\n" +
                "                \"endTimeD\": 182700\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10868,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 182701,\n" +
                "                \"endTime\": 184830,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"Yes, that's a Saturday.\",\n" +
                "                \"chinese\": \"是的，那是星期六。\",\n" +
                "                \"questionNumber\": \"2\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 182701,\n" +
                "                \"endTimeD\": 184830\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10869,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 184831,\n" +
                "                \"endTime\": 197210,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"So from six pm to midnight that'd be ￡115 - that's the weekend price, it's ￡75 on weekdays.(Q2)\",\n" +
                "                \"chinese\": \"所以从下午 6 点到午夜是 115 英镑 - 这是周末价格，工作日是 75 英镑。(Q2)\",\n" +
                "                \"questionNumber\": \"2\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 184831,\n" +
                "                \"endTimeD\": 197210\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10870,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 197211,\n" +
                "                \"endTime\": 198790,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"That's all right.\",\n" +
                "                \"chinese\": \"没关系。\",\n" +
                "                \"questionNumber\": \"2\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 197211,\n" +
                "                \"endTimeD\": 198790\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10871,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 198791,\n" +
                "                \"endTime\": 212630,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"And I have to tell you there's also a deposit of ￡250, which is returnable of course as long as there's no damage.But we do insist that this is paid in cash, (Q3)\",\n" +
                "                \"chinese\": \"而且我得告诉你还有￡250的押金，只要没有损坏当然可以退还。但我们坚持以现金支付，(Q3)\",\n" +
                "                \"questionNumber\": \"2,3\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 198791,\n" +
                "                \"endTimeD\": 212630\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10872,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 212631,\n" +
                "                \"endTime\": 223000,\n" +
                "                \"name\": \"\",\n" +
                "                \"english\": \"we don't take cards for that.You can pay the actual rent of the room however you like though - cash, credit card, cheque ...\",\n" +
                "                \"chinese\": \"我们不接受卡。你可以支付房间的实际租金，但你喜欢 - 现金，信用卡，支票......\",\n" +
                "                \"questionNumber\": \"3\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 212631,\n" +
                "                \"endTimeD\": 223000\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10873,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 223001,\n" +
                "                \"endTime\": 231340,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"Oh, well I suppose that's OK.So does the charge include use of tables and chairs and so on?\",\n" +
                "                \"chinese\": \"哦，我想那没问题。那么收费是否包括使用桌椅之类的费用？\",\n" +
                "                \"questionNumber\": \"4\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 223001,\n" +
                "                \"endTimeD\": 231340\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10874,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 231341,\n" +
                "                \"endTime\": 232830,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"Oh, yes.\",\n" +
                "                \"chinese\": \"哦是的。\",\n" +
                "                \"questionNumber\": \"4\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 231341,\n" +
                "                \"endTimeD\": 232830\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10875,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 232831,\n" +
                "                \"endTime\": 235120,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"And what about Parking?(Q4)\",\n" +
                "                \"chinese\": \"那么停车呢？(Q4)\",\n" +
                "                \"questionNumber\": \"4\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 232831,\n" +
                "                \"endTimeD\": 235120\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10876,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 235121,\n" +
                "                \"endTime\": 243620,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"Yeah.that's all included.The only thing that isn't included is ...you said you were organising a dinner?\",\n" +
                "                \"chinese\": \"是的，这都包括在内了。唯一没有包括的是......你说你在组织晚餐？\",\n" +
                "                \"questionNumber\": \"4\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 235121,\n" +
                "                \"endTimeD\": 243620\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10877,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 243621,\n" +
                "                \"endTime\": 244300,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"Yeah.\",\n" +
                "                \"chinese\": \"是的。\",\n" +
                "                \"questionNumber\": \"4\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 243621,\n" +
                "                \"endTimeD\": 244300\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10878,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 244301,\n" +
                "                \"endTime\": 257000,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"Well, you'll have to pay extra for the kitchen if you want to use that.It's ￡25.It's got very good facilities - good quality cookers and fridges and so on.\",\n" +
                "                \"chinese\": \"嗯，如果你想使用它，你必须支付额外的厨房费用。它是￡25。它有很好的设施——优质的炊具和冰箱等等。\",\n" +
                "                \"questionNumber\": null,\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 244301,\n" +
                "                \"endTimeD\": 257000\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10879,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 257001,\n" +
                "                \"endTime\": 263730,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"OK, well I suppose that's all right.We can cover the cost in our entry charges.\",\n" +
                "                \"chinese\": \"好吧，我想那没问题。我们可以在入场费中支付费用。\",\n" +
                "                \"questionNumber\": null,\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 257001,\n" +
                "                \"endTimeD\": 263730\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10880,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 263731,\n" +
                "                \"endTime\": 273200,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"Right.So I'll make a note of that.Now there are just one or two things you need to think about before the event.\",\n" +
                "                \"chinese\": \"是的。所以我会记下。现在你只需要在活动开始前考虑一两件事。\",\n" +
                "                \"questionNumber\": \"5\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 263731,\n" +
                "                \"endTimeD\": 273200\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10881,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 273201,\n" +
                "                \"endTime\": 280370,\n" +
                "                \"name\": \"\",\n" +
                "                \"english\": \"For example, you'll have to see about getting a licence if you're planning to have any music during the meal.(Q5)\",\n" +
                "                \"chinese\": \"例如，如果你计划在用餐期间播放音乐，你必须考虑获得许可证。(Q5)\",\n" +
                "                \"questionNumber\": \"5\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 273201,\n" +
                "                \"endTimeD\": 280370\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10882,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 280371,\n" +
                "                \"endTime\": 281540,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"Oh, really?\",\n" +
                "                \"chinese\": \"哦真的吗？\",\n" +
                "                \"questionNumber\": null,\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 280371,\n" +
                "                \"endTimeD\": 281540\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10883,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 281541,\n" +
                "                \"endTime\": 292480,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"It's quite straightforward, I'll give you the details later on.And about a week or ten days before your event you'll need to contact the caretaker,\",\n" +
                "                \"chinese\": \"这很简单，我稍后会告诉你细节。大约在活动前一周或十天，你需要联系管理员，\",\n" +
                "                \"questionNumber\": \"6\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 281541,\n" +
                "                \"endTimeD\": 292480\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10884,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 292481,\n" +
                "                \"endTime\": 298820,\n" +
                "                \"name\": \"\",\n" +
                "                \"english\": \"that's Mr Evans, to make the arrangements for entry - he'll sort that out with you.(Q6)\",\n" +
                "                \"chinese\": \"也就是埃文斯先生，安排入场——他会和你解决这个问题。(Q6)\",\n" +
                "                \"questionNumber\": \"6\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 10884,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 292481,\n" +
                "                \"endTimeD\": 298820\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10885,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 298821,\n" +
                "                \"endTime\": 301800,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"And do I give him the payment as well?\",\n" +
                "                \"chinese\": \"我也要给他付款吗？\",\n" +
                "                \"questionNumber\": null,\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 298821,\n" +
                "                \"endTimeD\": 301800\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10886,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 301801,\n" +
                "                \"endTime\": 343090,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"No, you do that directly with me.\",\n" +
                "                \"chinese\": \"不，你直接跟我说。\",\n" +
                "                \"questionNumber\": \"\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 301801,\n" +
                "                \"endTimeD\": 343090\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10887,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 343091,\n" +
                "                \"endTime\": 349000,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"Right.Now is there anything I need to know about what happens during the event?\",\n" +
                "                \"chinese\": \"对了。现在有什么我需要知道的关于活动期间发生的事情吗？\",\n" +
                "                \"questionNumber\": \"\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 343091,\n" +
                "                \"endTimeD\": 349000\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10888,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 349001,\n" +
                "                \"endTime\": 354680,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"Well, as you'll be aware, of course the building is no smoking throughout.\",\n" +
                "                \"chinese\": \"嗯，正如你所知道的，当然这座建筑是全面禁止吸烟的。\",\n" +
                "                \"questionNumber\": null,\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 349001,\n" +
                "                \"endTimeD\": 354680\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10889,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 354681,\n" +
                "                \"endTime\": 355920,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"Of course.\",\n" +
                "                \"chinese\": \"当然。\",\n" +
                "                \"questionNumber\": null,\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 354681,\n" +
                "                \"endTimeD\": 355920\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10890,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 355921,\n" +
                "                \"endTime\": 358110,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"Now, are you having a band?\",\n" +
                "                \"chinese\": \"现在，你有乐队吗？\",\n" +
                "                \"questionNumber\": \"7\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 355921,\n" +
                "                \"endTimeD\": 358110\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10891,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 358111,\n" +
                "                \"endTime\": 359230,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"Yes.\",\n" +
                "                \"chinese\": \"是的。\",\n" +
                "                \"questionNumber\": \"7\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 358111,\n" +
                "                \"endTimeD\": 359230\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10892,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 359231,\n" +
                "                \"endTime\": 369140,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"Well, they'll have a lot of equipment, so rather than using the front door they should park their van round the back and use the stage door there.(Q7)\",\n" +
                "                \"chinese\": \"嗯，他们会有很多设备，所以与其使用前门，不如把他们的面包车停在后面，然后使用那里的舞台门。(Q7)\",\n" +
                "                \"questionNumber\": \"7\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 359231,\n" +
                "                \"endTimeD\": 369140\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10893,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 369142,\n" +
                "                \"endTime\": 374000,\n" +
                "                \"name\": null,\n" +
                "                \"english\": \"You can open that from inside but don't forget to lock it at the end.\",\n" +
                "                \"chinese\": \"你可以从里面打开它，但不要忘记在最后锁上它.\",\n" +
                "                \"questionNumber\": null,\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 369142,\n" +
                "                \"endTimeD\": 374000\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10894,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 374001,\n" +
                "                \"endTime\": 375000,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"OK.\",\n" +
                "                \"chinese\": \"好的。\",\n" +
                "                \"questionNumber\": null,\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 374001,\n" +
                "                \"endTimeD\": 375000\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10895,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 375001,\n" +
                "                \"endTime\": 385690,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"And talking of bands, I'm sure I don't need to tell you this, but you must make sure that no one fiddles about with the black box by the fire door -\",\n" +
                "                \"chinese\": \"说到乐队，我确定我不需要告诉你这个，但你必须确保没有人摆弄防火门旁边的黑匣子——\",\n" +
                "                \"questionNumber\": null,\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 375001,\n" +
                "                \"endTimeD\": 385690\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10896,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 385691,\n" +
                "                \"endTime\": 392670,\n" +
                "                \"name\": \"\",\n" +
                "                \"english\": \"that's a system that cuts in when the volume reaches a certain level.It's a legal requirement.\",\n" +
                "                \"chinese\": \"这是一个系统，当音量达到一定的水平时，它就会加入。这是一个法律要求。\",\n" +
                "                \"questionNumber\": \"\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 385691,\n" +
                "                \"endTimeD\": 392670\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10897,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 392671,\n" +
                "                \"endTime\": 407000,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"Sure.Anyway, we want people to be able to talk to one another so we don't want anything too loud.Oh, that reminds me, we'll be having speeches - are there any microphones available?\",\n" +
                "                \"chinese\": \"当然。无论如何，我们希望人们能够相互交谈，所以我们不希望任何声音太大。哦，这提醒我，我们将进行演讲 - 是否有可用的麦克风？\",\n" +
                "                \"questionNumber\": null,\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 392671,\n" +
                "                \"endTimeD\": 407000\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10898,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 407001,\n" +
                "                \"endTime\": 418460,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"Yeah.Just let the caretaker know, he'll get those for you.Right, now when the event is over we do ask that the premises are left in good condition.\",\n" +
                "                \"chinese\": \"是的。让管理员知道，他会帮你拿的。对了，现在活动结束后，我们确实要求场地保持良好状态。\",\n" +
                "                \"questionNumber\": \"8\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": \"\",\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 407001,\n" +
                "                \"endTimeD\": 418460\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10899,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 418461,\n" +
                "                \"endTime\": 430740,\n" +
                "                \"name\": null,\n" +
                "                \"english\": \"So there's a locked cupboard and you'll be informed of the code you need to open that.It's got all the cleaning equipment, brushes and detergent and so on.(Q8)\",\n" +
                "                \"chinese\": \"所以有一个上锁的橱柜，你会被告知密码你需要打开它。里面有所有的清洁设备，刷子和清洁剂等等。(Q8)\",\n" +
                "                \"questionNumber\": \"8\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 10899,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 418461,\n" +
                "                \"endTimeD\": 430740\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10900,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 430741,\n" +
                "                \"endTime\": 438000,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"Right.So what do we need to do after everyone's gone?Sweep the floors I suppose?(Q9)\",\n" +
                "                \"chinese\": \"是的。那么大家都走了之后我们需要做什么？我想是扫地吧？(Q9)\",\n" +
                "                \"questionNumber\": \"9\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 430741,\n" +
                "                \"endTimeD\": 438000\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10901,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 438001,\n" +
                "                \"endTime\": 451000,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"Well, actually they have to be washed, not just swept.Then you'll be provided with black plastic bags, so all the rubbish must be collected up and left outside the door.\",\n" +
                "                \"chinese\": \"嗯，其实他们是要洗的，不光是扫。然后你会得到黑色的塑料袋，所以所有的垃圾都必须收集起来放在门外。\",\n" +
                "                \"questionNumber\": \"9\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 438001,\n" +
                "                \"endTimeD\": 451000\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10902,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 451001,\n" +
                "                \"endTime\": 461000,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"Of course.We'll make sure everything's left tidy.Oh, and I forgot to ask, I presume we can have decorations in the room?(Q10)\",\n" +
                "                \"chinese\": \"当然。我们会确保一切都保持整洁。哦，我忘了问，我想我们可以在房间里装饰一下吗？(Q10)\",\n" +
                "                \"questionNumber\": \"10\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 451001,\n" +
                "                \"endTimeD\": 461000\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10903,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 461001,\n" +
                "                \"endTime\": 464530,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"Yes, but you must take them down afterwards.\",\n" +
                "                \"chinese\": \"是的，但您必须在之后将它们取下。\",\n" +
                "                \"questionNumber\": \"10\",\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 461001,\n" +
                "                \"endTimeD\": 464530\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10904,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 464531,\n" +
                "                \"endTime\": 465410,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"Sure.\",\n" +
                "                \"chinese\": \"当然。\",\n" +
                "                \"questionNumber\": null,\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 464531,\n" +
                "                \"endTimeD\": 465410\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10905,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 465411,\n" +
                "                \"endTime\": 471000,\n" +
                "                \"name\": \"OFFICIAL\",\n" +
                "                \"english\": \"And the chairs and tables should be stacked up neatly at the back of the room.\",\n" +
                "                \"chinese\": \"并且椅子和桌子应该整齐地堆放在房间的后面。\",\n" +
                "                \"questionNumber\": null,\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 465411,\n" +
                "                \"endTimeD\": 471000\n" +
                "            },\n" +
                "            {\n" +
                "                \"listId\": 10906,\n" +
                "                \"lId\": 119,\n" +
                "                \"sort\": 0,\n" +
                "                \"startTime\": 471001,\n" +
                "                \"endTime\": 474000,\n" +
                "                \"name\": \"WOMAN\",\n" +
                "                \"english\": \"I'll make sure I've got a few people to help me.\",\n" +
                "                \"chinese\": \"我会确保我有几个人来帮助我。\",\n" +
                "                \"questionNumber\": null,\n" +
                "                \"listCreateDate\": 1623315011000,\n" +
                "                \"delFlag\": false,\n" +
                "                \"enshrineListenId\": 0,\n" +
                "                \"listenNotes\": null,\n" +
                "                \"answer\": false,\n" +
                "                \"startTimeD\": 471001,\n" +
                "                \"endTimeD\": 474000\n" +
                "            }\n" +
                "        ],\n" +
                "        \"isName\": true,\n" +
                "        \"mockListens\": [\n" +
                "            {\n" +
                "                \"lId\": 119,\n" +
                "                \"lSort\": 0,\n" +
                "                \"lType\": 1,\n" +
                "                \"lType2\": 0,\n" +
                "                \"lTitle\": \"剑11-Test1-Part1\",\n" +
                "                \"lReadTitle\": \"\",\n" +
                "                \"lReadTitle2\": \"\",\n" +
                "                \"lStatus\": true,\n" +
                "                \"lProblem\": 11,\n" +
                "                \"lTest\": 1,\n" +
                "                \"lPart\": 1,\n" +
                "                \"lFileUrl\": \"9043358fff334698b21a587f1d91c22c.mp3\",\n" +
                "                \"lRemark\": \"0，1\",\n" +
                "                \"lCreatTime\": 1623028764000,\n" +
                "                \"lUpdateTime\": 1668407323000,\n" +
                "                \"lWritingScore\": 0.0,\n" +
                "                \"lWritingWordCount\": 0,\n" +
                "                \"delFlag\": false\n" +
                "            }\n" +
                "        ],\n" +
                "        \"listen\": {\n" +
                "            \"lId\": 119,\n" +
                "            \"lSort\": 0,\n" +
                "            \"lType\": 1,\n" +
                "            \"lType2\": 0,\n" +
                "            \"lTitle\": \"剑11-Test1-Part1\",\n" +
                "            \"lReadTitle\": \"\",\n" +
                "            \"lReadTitle2\": \"\",\n" +
                "            \"lStatus\": true,\n" +
                "            \"lProblem\": 11,\n" +
                "            \"lTest\": 1,\n" +
                "            \"lPart\": 1,\n" +
                "            \"lFileUrl\": \"9043358fff334698b21a587f1d91c22c.mp3\",\n" +
                "            \"lRemark\": \"0，1\",\n" +
                "            \"lCreatTime\": 1623028764000,\n" +
                "            \"lUpdateTime\": 1668407323000,\n" +
                "            \"lWritingScore\": 0.0,\n" +
                "            \"lWritingWordCount\": 0,\n" +
                "            \"delFlag\": false\n" +
                "        },\n" +
                "        \"mockReadVocabularyList\": null\n" +
                "    }\n" +
                "}";
        doInit(jsonData);
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
