package com.gmail.at.ivanehreshi.jee.survey.jms;

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
public class MessageConsumer implements MessageListener{
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Notification received: " + message.getBody(String.class));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
