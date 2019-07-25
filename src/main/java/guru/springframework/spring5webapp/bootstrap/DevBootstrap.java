package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.repository.AlertRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AlertRepository alertRepository;

    public DevBootstrap(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){


    }
}
