package com.codingprh.demo.rocketmq_demo.produce;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 描述:
 * 同步生产者
 *
 * @author codingprh
 * @create 2018-12-17 2:57 PM
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
                DefaultMQProducer("codingprh_group");
        // Specify name server addresses.
        producer.setNamesrvAddr("localhost:9876");//
        //Launch the instance.
        producer.start();
        for (int i = 0; i < 1; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTest" /* Topic */,
                    //"DI" /* Tag */,
                    "hello".getBytes(RemotingHelper.DEFAULT_CHARSET)
                    //("{\"statInfo\":{\"loadFailCount\":0,\"maxGetTime\":0,\"minLoadTime\":9223372036854775807,\"getMissCount\":0,\"minGetTime\":9223372036854775807,\"statStartTime\":1566299770001,\"loadCount\":0,\"putCount\":0,\"cacheName\":\"ResultCache\",\"avgPutTime\":0.0,\"loadSuccessCount\":0,\"minRemoveTime\":9223372036854775807,\"maxPutTime\":0,\"getCount\":0,\"removeCount\":0,\"putSuccessCount\":0,\"avgLoadTime\":0.0,\"loadTimeSum\":0,\"avgGetTime\":0.0,\"putFailCount\":0,\"removeTimeSum\":0,\"getHitCount\":0,\"maxRemoveTime\":0,\"hitRate\":0.0,\"putTps\":0.0,\"statEndTime\":1566299780001,\"minPutTime\":9223372036854775807,\"maxLoadTime\":0,\"getExpireCount\":0,\"getTimeSum\":0,\"qps\":0.0,\"putTimeSum\":0,\"removeSuccessCount\":0,\"getFailCount\":0,\"avgRemoveTime\":0.0,\"removeTps\":0.0,\"removeFailCount\":0,\"loadQps\":0.0},\"startTime\":1566299770001,\"endTime\":1566299780001,\"machineInfo\":{\"address\":\"172.34.26.66\",\"host\":\"di-beta-1\",\"serviceName\":\"DI\"}}" +
                            //i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}