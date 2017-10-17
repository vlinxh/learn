package com.xhlim.rocketmq.consumer;


import com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer;
import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author xhlim 2017/8/9
 */
public class Consumer {

    public final static String addr = "122.114.226.115:9876";

    public static void main(String[] args) throws MQClientException {


        /**
         * 一个应用创建一个Consumer，由应用来维护此对象，可以设置为全局对象或者单例<br>
         * 注意：ConsumerGroupName需要由应用来保证唯一
         */
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ConsumerGroupName");
        consumer.setNamesrvAddr(addr);
        consumer.setInstanceName("consumer");

        /**
         * 订阅指定topic下tags分别等于TagA或TagC或TagD
         */
        consumer.subscribe("topic1", "tag1 || tag2 || tag4");

        /**
         * 订阅指定topic下所有消息<br>
         * 注意：一个consumer对象可以订阅多个topic
         */
        consumer.subscribe("topic2", "*");

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            /**
             * 默认msgs里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息
             */
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.println(Thread.currentThread().getName() + " Receive New Messages: " + msgs.size());
                MessageExt msg = msgs.get(0);
                if (msg.getTopic().equals("topic1")) {
                    // 执行TopicTest1的消费逻辑
                    if (msg.getTags() != null && msg.getTags().equals("tag1")) {
                        // 执行TagA的消费
                        System.out.println(new String(msg.getBody()));
                    } else if (msg.getTags() != null && msg.getTags().equals("tag2")) {
                        // 执行TagC的消费
                    } else if (msg.getTags() != null && msg.getTags().equals("tag4")) {
                        // 执行TagD的消费
                    }
                } else if (msg.getTopic().equals("topic2")) {
                    System.out.println(new String(msg.getBody()));
                }

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });


        /**
         * Consumer对象在使用之前必须要调用start初始化，初始化一次即可<br>
         */

        consumer.start();

        System.out.println("Consumer Started.");
    }

}
