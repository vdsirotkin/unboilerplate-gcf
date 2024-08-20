package com.vdsirotkin.gcf;

import io.cloudevents.CloudEvent;

public class PubsubFunctionTesting extends PubSubFunction<TestDto> {
    public PubsubFunctionTesting() {
        super(TestDto.class);
    }

    @Override
    public void accept(TestDto message, CloudEvent event) {
        System.out.println("message = " + message);
    }
}
