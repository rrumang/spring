package kr.or.ddit.config.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


//kr/or/ddit/config/spring/root-context.xml을 자바 config으로 변경
//@Service, @Repository 두 어노테이션을 대상으로 스캔
@Configuration
@ComponentScan(basePackages = "kr.or.ddit", useDefaultFilters = false,
				includeFilters = @Filter(type = FilterType.ANNOTATION,classes = {Service.class, Repository.class}))
public class RootContext {

}
