package com.bulimas.informationhub;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EnableScheduling
public class InformationHubApiApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(InformationHubApiApplication.class, args);
    }

//    public static void restart() {
//        ApplicationArguments args = context.getBean(ApplicationArguments.class);
//
//        Thread thread = new Thread(() -> {
//           context.close();
//           context = SpringApplication.run(InformationHubApiApplication.class, args.getSourceArgs());
//        });
//
//        thread.setDaemon(false);
//        thread.start();
//    }
}
