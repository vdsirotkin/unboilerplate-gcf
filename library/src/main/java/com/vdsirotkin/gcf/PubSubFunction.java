package com.vdsirotkin.gcf;

import com.google.cloud.functions.CloudEventsFunction;
import com.google.events.cloud.pubsub.v1.MessagePublishedData;
import com.google.gson.Gson;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.vdsirotkin.gcf.serialization.GsonSerializer;
import com.vdsirotkin.gcf.serialization.Serializer;
import io.cloudevents.CloudEvent;
import io.cloudevents.CloudEventData;

import java.nio.charset.StandardCharsets;

public abstract class PubSubFunction<T> implements CloudEventsFunction {
    private final Class<T> messageType;
    private final Serializer serializer;
    protected final Gson gson = new Gson();

    public PubSubFunction(Class<T> messageType) {
        this.messageType = messageType;
        this.serializer = new GsonSerializer(gson);
    }

    public PubSubFunction(Class<T> messageType, Serializer serializer) {
        this.messageType = messageType;
        this.serializer = serializer;
    }

    @Override
    public void accept(CloudEvent event) throws InvalidProtocolBufferException {
        CloudEventData eventData = event.getData();
        if (eventData == null) {
            return;
        }
        String cloudEventData = new String(eventData.toBytes(), StandardCharsets.UTF_8);
        MessagePublishedData.Builder dataBuilder = MessagePublishedData.newBuilder();
        JsonFormat.parser().merge(cloudEventData, dataBuilder);
        MessagePublishedData data = dataBuilder.build();
        String decodedData = data.getMessage().getData().toString(StandardCharsets.UTF_8);
        accept(serializer.deserialize(decodedData, messageType), data, event);
    }

    public abstract void accept(T message, MessagePublishedData data, CloudEvent event);
}
