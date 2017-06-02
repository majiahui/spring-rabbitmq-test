package service;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by bl05356 on 2017/6/1.
 */
@Component
public class InitHelper implements ApplicationListener<ContextRefreshedEvent> {

    @PostConstruct
    public void initData() {
        System.out.println("PostConstruct ...");
    }

    @Async
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            System.out.println("onApplicationEvent ...");
            throw new RuntimeException("onApplicationEvent 出错了");
        }
    }
}
