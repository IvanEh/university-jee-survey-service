package com.gmail.at.ivanehreshi.jee.survey.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Topic;


@Stateless
@Named
public class NotificationService {
    @Resource(lookup = "java:/SurveyTopic")
    private Topic topic;

    @Inject
    private JMSContext jmsContext;


    public void notify(String message) {
        try {
            jmsContext.createProducer().send(topic, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String receive() {
        try {
            JMSConsumer consumer = jmsContext.createConsumer(topic);
            return consumer.receive().getBody(String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public JMSContext getJmsContext() {
        return jmsContext;
    }

    public void setJmsContext(JMSContext jmsContext) {
        this.jmsContext = jmsContext;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
