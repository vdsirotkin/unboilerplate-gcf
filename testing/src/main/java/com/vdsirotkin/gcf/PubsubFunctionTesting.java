package com.vdsirotkin.gcf;

import com.google.events.cloud.pubsub.v1.MessagePublishedData;
import io.cloudevents.CloudEvent;

public class PubsubFunctionTesting extends PubSubFunction<TestDto> {
    public PubsubFunctionTesting() {
        super(TestDto.class);
    }

    @Override
    public void accept(TestDto message, MessagePublishedData data, CloudEvent event) {
        System.out.println("message = " + message);
    }
}
