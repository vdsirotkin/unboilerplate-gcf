package com.vdsirotkin.gcf.serialization;

public interface Serializer {
    <T> T deserialize(String data, Class<T> clazz);
}
