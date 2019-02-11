package com.admin.dvdstore.consumer;

import com.admin.dvdstore.dvd.DVDEntry;
import com.admin.dvdstore.sendemail.DVDMailer;
import com.admin.dvdstore.sendemail.EmailMessage;
import com.admin.dvdstore.sendemail.SendDVDEmail;
import com.admin.dvdstore.writetofile.WriteDVD;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created by Robi on 11/21/2018.
 */

@Component
public class DVDConsumer {
    @RabbitListener(queues="${jsa.rabbitmq.queue}")
    public void recievedDVDEntry(DVDEntry dvdEntry) {
        System.out.println("Recieved Message: " + dvdEntry.toString());
        WriteDVD writeDVD = new WriteDVD();
        writeDVD.writeDVDToFile(dvdEntry);

        DVDMailer dvdMailer = new DVDMailer();
        dvdMailer.notifySubscribers(dvdEntry);
    }
}
