package com.psjw.springbootpractice;

import com.psjw.springbootpractice.properties.MyProperties;
import com.psjw.springbootpractice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@ConfigurationPropertiesScan
@RequiredArgsConstructor
@EnableCaching
public class PsjwSpringBootPracticeApplication {

    private final MyProperties myProperties;
    private final StudentService studentService;
    public static void main(String[] args) {
        SpringApplication.run(PsjwSpringBootPracticeApplication.class, args);
    }
    //Spring Cache는 모든 빈들이 모두 로딩되었을때 정의
    // @PostConstruct : 해당 클래스의 의존성이 모두 완성된뒤 -> 지금은 MyProperties와 StudentService가 주입되면 시작
    @EventListener(ApplicationReadyEvent.class)//Application이 준비가 끝났을때 이벤트 발생
    public void init() {
//        System.out.println("내 키는: " + myProperties.getHeight());
        studentService.printStudent("jack");
        studentService.printStudent("jack");
        studentService.printStudent("jack");
        studentService.printStudent("fred");
        studentService.printStudent("cassie");
        studentService.printStudent("cassie");
    }
}
