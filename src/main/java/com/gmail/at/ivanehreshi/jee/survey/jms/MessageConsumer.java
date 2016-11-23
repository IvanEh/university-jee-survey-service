package com.gmail.at.ivanehreshi.jee.survey.jms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven( activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup",
                propertyValue = "SurveyTopic"),
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "javax.jms.Topic")
        }
)
public class MessageConsumer implements MessageListener {
    private static Logger LOGGER = LogManager.getLogger(MessageConsumer.class);

    @Override
    public void onMessage(Message message) {
        try {
            LOGGER.info("Notification received: " + message.getBody(String.class));
        } catch (JMSException e) {
            LOGGER.warn("Error while consuming JMS message. Probably cannot cast body to String", e);
        }
    }
}
