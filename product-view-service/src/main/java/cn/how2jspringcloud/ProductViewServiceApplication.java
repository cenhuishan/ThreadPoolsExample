package cn.how2jspringcloud;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class ProductViewServiceApplication {

	public static void main(String[] args) {
		int port = 0;
		int defaultPort = 8010;
		Future<Integer> future = ThreadUtil.execAsync(()->{
			int p=0;
			System.out.println("请与5秒钟输入端口号，推荐 8001，8002等等，超过五秒钟后将默认为8001");
			Scanner scanner = new Scanner(System.in);
			while(true){
				String strPort = scanner.nextLine();
				if(!NumberUtil.isInteger(strPort)){
					System.out.println("自能是数字");
					continue;
				}
				else
				{
					p = Convert.toInt(strPort);
					scanner.close();
					break;
				}
			}
			return p;
		});

		try {
			port = future.get(5, TimeUnit.SECONDS);

		}catch (InterruptedException | ExecutionException | TimeoutException e){
			port = defaultPort;
		}
		if(!NetUtil.isUsableLocalPort(port)){
			System.out.printf("端口被占用d%",port);
			System.exit(1);

		}
		new SpringApplicationBuilder(ProductViewServiceApplication.class).properties("server.port ="+port).run(args);


	}
//	@Bean
//	@LoadBalanced
//	RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

}
