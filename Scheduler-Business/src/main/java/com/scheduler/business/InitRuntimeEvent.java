package com.scheduler.business;

import com.alibaba.fastjson.JSONObject;
import com.scheduler.business.config.mainconfig.BaseConfig;
import com.scheduler.business.config.manager.EmailManager;
import com.scheduler.business.domain.EmailMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Properties;
/**
 * 1.@PostConstruct用在无参非静态的方法上，在这个方法所在的bean被加载完成后开始执行，如果此方法需要引用其他bean则可能会出现其他bean没有被加载的情况，导致报空。
 * 如果@PostConstruct方法内的逻辑处理时间较长，就会增加SpringBoot应用初始化Bean的时间，进而增加应用启动时间。因为只有在Bean初始化完成后，SpringBoot应用才会打开端口提供服务，所以在此之前，应用不可访问
 *
 * 2.实现ApplicationListener的onApplicationEvent，此方法在所有bean加载完后，spring ioc容器会发送一个RefreshedEvent事件，刷新容器里的bean，
 * 此时可以在方法内加载其他bean不会报空，可以引用其他bean
 *
 * 3.实现CommandLineRunner或者ApplicationRunner接口，重写run方法,两者区别是参数不同
 *
 * 三者加载顺序 @PostConstruct--->>>ApplicationListener--->>>CommandLineRunner/ApplicationRunner
 *
 * https://blog.csdn.net/lucky_love816/article/details/120972585
 * */
@Component
public class InitRuntimeEvent implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(InitRuntimeEvent.class);

    @Autowired
    private BaseConfig baseConfig;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        String emailConfig=baseConfig.getEmailMainConfig();
        if(StringUtils.isEmpty(emailConfig)){
            logger.error("加载邮件配置信息失败！"+emailConfig);
            return;
        }
        List<EmailMain> emailMains = JSONObject.parseArray(emailConfig, EmailMain.class);
        for (EmailMain config: emailMains){
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost(config.getHost());
            mailSender.setPort(config.getPort());
            mailSender.setUsername(config.getUsername());
            mailSender.setPassword(config.getPassword());
            mailSender.setProtocol(config.getProtocol());
            //加认证机制
            Properties javaMailProperties = new Properties();
            javaMailProperties.put("mail.smtp.ssl.enable", config.isSslEnable());
            mailSender.setJavaMailProperties(javaMailProperties);
            EmailManager singleInstance = EmailManager.getSingleInstance();
            singleInstance.addMimeMessages(config.getType(),mailSender);
            logger.info("加载邮件配置信息:{}", config.getType()+ ","+mailSender.getHost() + "," + mailSender.getPort() + "," + mailSender.getUsername() + "," + mailSender.getPassword());
        }
    }
}
