# unboilerplate-gcf

[![Maven Central Version](https://img.shields.io/maven-central/v/com.vdsirotkin/unboilerplate-gcf)](https://central.sonatype.com/artifact/com.vdsirotkin/unboilerplate-gcf)

A tiny library to reduce boilerplate code in Google Cloud Functions

# Usage

Currently only PubSub is supported.

## PubSub

Features:
* Deserialization of PubSub message to it's protobuf representation (`MessagePublishedData`)
* Automatic deserialization of PubSub message payload to DTO

```java
public class PubsubFunctionTesting extends PubSubFunction<TestDto> {
    public PubsubFunctionTesting() {
        super(TestDto.class);
    }

    @Override
    public void accept(TestDto message, MessagePublishedData data, CloudEvent event) {
        System.out.println("message = " + message);
    }
}
```