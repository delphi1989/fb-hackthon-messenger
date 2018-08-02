package tw.com.fdccc.messenger.webhookevent.dto.constant;

import lombok.Getter;

public enum  WebhookEventType {

    MISSION_LIST("進行中的任務"),
    CURRENT_PROPERTY("金幣查詢"),
    RANKING_BOARD("Ranking Board"),
    GET_STARTED("Get Started"),
    APPLY_REWARD("兌換獎勵");

    @Getter
    private String eventType;

    WebhookEventType(String eventType) {
        this.eventType = eventType;
    }

}
