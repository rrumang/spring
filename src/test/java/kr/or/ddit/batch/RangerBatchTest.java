package kr.or.ddit.batch;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/application-batch-dev.xml"})
public class RangerBatchTest {

	@Resource(name="jobLauncher")
	private JobLauncher jobLauncher;
	
	@Resource(name="rangerJob")
	private Job rangerJob;
	
	/**
	 * 
	* Method : RangerBatchTest
	* 작성자 : PC08
	* 변경이력 :
	* @throws Exception
	* Method 설명 :레인저스 이름 수정 배치 테스트
	 */
	@Test
	public void RangerBatchTest() throws Exception {
		/***Given***/

		/***When***/
		JobExecution jobExcution = jobLauncher.run(rangerJob, new JobParameters());

		/***Then***/
		assertEquals(ExitStatus.COMPLETED, jobExcution.getExitStatus());
	}

}
