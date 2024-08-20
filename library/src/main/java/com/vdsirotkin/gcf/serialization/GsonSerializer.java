package com.vdsirotkin.gcf.serialization;

import com.google.gson.Gson;

public class GsonSerializer implements Serializer {
    private final Gson gson;

    public GsonSerializer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public <T> T deserialize(String data, Class<T> clazz) {
        return gson.fromJson(data, clazz);
    }
}
