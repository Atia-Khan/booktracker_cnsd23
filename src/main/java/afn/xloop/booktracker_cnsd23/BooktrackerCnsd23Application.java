package afn.xloop.booktracker_cnsd23;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooktrackerCnsd23Application {

	public static void main(String[] args) {
		SpringApplication.run(BooktrackerCnsd23Application.class, args);
	}

		@RabbitListener(queues = "hello")
	public void receiver(String in) throws Exception {
		System.out.println(" [x] Received '" + in + "'");
	}

}

