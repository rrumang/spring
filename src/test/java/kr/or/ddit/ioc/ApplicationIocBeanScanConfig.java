package kr.or.ddit.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

//defaultFilter : @Controller, @Service, @Repository, @Component
// useDefaultFilter를  false로 선언하면 개발자가 원하는 어노테이션만 스캔 가능
// ex : @Controller만 스캔
@Configuration
@ComponentScan(basePackages = {"kr.or.ddit.board"}, useDefaultFilters = true)
public class ApplicationIocBeanScanConfig {

}
