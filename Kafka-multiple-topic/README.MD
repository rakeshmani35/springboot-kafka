Spring Kafka library provided JsonSerializer and JsonDeserializer classes for storing and retrieving JSON from Apache Kafka topics and returning Java model objects.

Application.proeprties
======================
1) spring.kafka.consumer.group-id - specifies a unique string that identifies the consumer group this consumer belongs to.

2) spring.kafka.consumer.auto-offset-reset property - specifies what to do when there is no initial offset in Kafka or if the current offset does not exist anymore on the server (e.g. because that data has been deleted):
 - earliest: automatically reset the offset to the earliest offset
 - latest: automatically reset the offset to the latest offset
 - none: throw an exception to the consumer if no previous offset is found for the consumer’s group
 - anything else: throw an exception to the consumer.

3) spring.kafka.consumer.key-deserializer - specifies the deserializer class for keys.

4) spring.kafka.consumer.value-deserializer - specifies the deserializer class for values.

5) spring.kafka.producer.key-deserializer - specifies the serializer class for keys.

6) spring.kafka.producer.value-deserializer - specifies the serializer class for values.


KafkaTopicConfig 
=================
NewTopic: To create a topic on startup, add a bean of type NewTopic. If the topic already exists, the bean is ignored.

Request
========
POST: http://localhost:8080/api/v1/kafka/publish
{
"id":1,
"firstName":"rakesh",
"lastName":"roshan"
}


create multiple topic 
=======================
final String[] topicNames = new String[] {"topic1", "topic2"};
final SingletonBeanRegistry beanRegistry;

    public TopicCreation(GenericApplicationContext context) {
        this.beanRegistry = context.getBeanFactory();
    }

    @PostConstruct
    public void createTopics() {
        for (String topic : topicNames) {
            NewTopic newTopic = TopicBuilder.name(topic)
                    .replicas(1)
                    .partitions(1)
                    .build();
            beanRegistry.registerSingleton("topic-" + topic, newTopic);
        }
    }

