package org.example;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Compare {

    public String compareCourses(List<String> list1, List<String> list2) {
        String differences = "Results of comparison";

        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic("courseComparisonTopic");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);

            TextMessage message = session.createTextMessage(differences);
            producer.send(message);

            session.close();
            connection.close();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return differences;
    }
}
