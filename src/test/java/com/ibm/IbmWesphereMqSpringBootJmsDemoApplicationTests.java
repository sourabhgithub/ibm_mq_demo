package com.ibm;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IbmWesphereMqSpringBootJmsDemoApplicationTests {

    @Autowired
    private JmsOperations jmsOperations;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendMsg() {
        // replace first param with the queue name
        jmsOperations.convertAndSend("ORDER.REQUEST", "hello world");
    }

    @Test
    public void receiveMsg() {
        // replace first param with the queue name
        jmsOperations.receiveAndConvert("ORDER.REQUEST");
    }

    @Test
    @Transactional(value = "jmsTransactionManager")
    public void transaction() {
        // replace first param with the queue name
        jmsOperations.convertAndSend("ORDER.REQUEST", "transaction test");
    }


}
