package winirnd.yn21.server.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
class RabbitConfig {

	private static final String queueName = "queueB";
	private static final String topicExchangeName = "sensor";
	private static final String routingKey = "sample.sensor.B";

	@Bean
	Queue queue() {
		return new Queue(queueName, true);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routingKey);
	}

//	@Bean
//	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
//		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
//		return rabbitTemplate;
//	}

//	@Bean
//	public ConnectionFactory connectionFactory() {
//		CachingConnectionFactory factory = new CachingConnectionFactory();
//		factory.setHost("192.168.1.128");
//		factory.setPort(61613);
//		factory.setUsername("kje");
//		factory.setPassword("1q2w3e");
//		factory.setVirtualHost("vhost1");
//		return factory;
//	}

	@Bean
	public RestTemplate restTemplate() {

		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(5000); // 읽기시간초과, ms
		factory.setConnectTimeout(3000); // 연결시간초과, ms

		HttpClient httpClient = HttpClientBuilder.create().setMaxConnTotal(100) // connection pool 적용
				.setMaxConnPerRoute(5) // connection pool 적용
				.build();

		factory.setHttpClient(httpClient); // 동기실행에 사용될 HttpClient 세팅
		RestTemplate restTemplate = new RestTemplate(factory);

		return restTemplate;
	}
}
