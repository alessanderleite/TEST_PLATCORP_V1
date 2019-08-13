package br.com.alessanderleite.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(clients = {IpVigilanteClient.class, MetaweatherClient.class})
public class FeignConfig {

}
