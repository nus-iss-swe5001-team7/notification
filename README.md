# Notification Service using Apache Kafka

## Download and install Kafka

Apache Kafka website: https://kafka.apache.org/downloads

Download the http link from https://www.apache.org/dyn/closer.cgi?path=/kafka/3.8.0/kafka_2.13-3.8.0.tgz

## Start the ZooKeeper service

tar -xzf kafka_2.13-3.x.tgz

cd kafka_2.13-3.x

bin/zookeeper-server-start.sh config/zookeeper.properties

## Start the Kafka broker service

Open another terminal to start 

cd kafka_2.13-3.x

bin/kafka-server-start.sh config/server.properties
