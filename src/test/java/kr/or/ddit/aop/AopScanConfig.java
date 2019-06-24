package kr.or.ddit.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;


//<context:annotaion-config/> 역할을 @Confiurtation에서 담당
@Configuration//자바로 만든다는 표시
@ComponentScan(basePackages = {"kr.or.ddit.board"},
				includeFilters = @ComponentScan.Filter(type=FilterType.ANNOTATION, value = Aspect.class))
@EnableAspectJAutoProxy
public class AopScanConfig {
	
	
	//application-aop-scan.xml 을 자바로 바꿔보는 클래스!
	
	/*<!--@Controller, @Service, @Repository, @Component 4가지 어노페이견이 붙은 클래스를 스프링빈으로 등록  -->
	<context:component-scan base-package="kr.or.ddit">
		<context:include-filter type="annotation" expression="org.aspectj.lang.annotation.Aspect"/>
	</context:component-scan>
	
	<aop:aspectj-autoproxy/>
	
	<!--스프링빈에 스프링빈을 넣기 위한 구조  -->	
	<context:annotation-config/>*/
	

}
