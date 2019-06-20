package kr.or.ddit.typeConvert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class StringDateConverter implements Converter<String, Date> {
	
	private String pattern = "yyyy-MM-dd";
	
	@Override
	public Date convert(String source) {
		//source : 2019-08-08
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date dt = null;
		try {
			dt = sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt;
	}
	//외부에서 패턴을 바꿀 수 있도록 setpattern을 만들어준다
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}
