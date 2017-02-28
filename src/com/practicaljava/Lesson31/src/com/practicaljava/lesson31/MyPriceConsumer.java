package com.practicaljava.lesson31;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", 
				propertyValue = "javax.jms.Queue")
		})
public class MyPriceConsumer implements MessageListener {

    public MyPriceConsumer() {

    }
	
    public void onMessage(Message message) {
        
    }

}
