package com.gmail.at.ivanehreshi.jee.survey.jms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private static Logger LOGGER = LogManager.getLogger(NotificationService.class);

    @Resource(lookup = "java:/SurveyTopic")
    private Topic topic;

    @Inject
    private JMSContext jmsContext;


    public void notify(String message) {
        try {
            jmsContext.createProducer().send(topic, message);
        } catch (Exception e) {
            LOGGER.warn("Exception while producing notification", e);
        }
    }

    public String receive() {
        try {
            JMSConsumer consumer = jmsContext.createConsumer(topic);
            return consumer.receive().getBody(String.class);
        } catch (Exception e) {
            LOGGER.warn("Exception while consuming notification", e);
            return null;
        }
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
