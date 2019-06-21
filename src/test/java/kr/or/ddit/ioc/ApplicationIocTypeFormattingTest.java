package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import kr.or.ddit.typeConvert.model.FormattingVo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-type-formatting.xml")
public class ApplicationIocTypeFormattingTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationIocTypeFormattingTest.class);
	
	@Resource(name="formattingVo")
	private FormattingVo formattingVo;

	@Test
	public void formattingTest() {
		/***Given***/
		/***When***/
		SimpleDateFormat sdf = new SimpleDateFormat("MM-yyyy-dd");
		String reg_dt = sdf.format(formattingVo.getReg_dt());
		String mod_dt = sdf.format(formattingVo.getMod_dt());
		
		logger.debug("reg_dt : {}", formattingVo.getReg_dt());
		logger.debug("mod_dt : {}", formattingVo.getMod_dt());

		/***Then***/
		assertEquals("06-2019-21", reg_dt);
		assertEquals("06-2019-21", mod_dt);
		assertEquals(6000, formattingVo.getNumber()); // "6,000" -> 6000
		
	}

}
