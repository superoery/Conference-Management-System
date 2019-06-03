package team.softwarede.confersys.bizImpl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.biz.LeaveExaminationBiz;
import team.softwarede.confersys.entity.LeaveApplication;
/**
 * 
 * @author SunRonglin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class LeaveExaminationBizImplTest {

	@Autowired
	LeaveExaminationBiz leaveExaminationBiz;
	
	@Test
	public void testLeaveExamination() {
		LeaveApplication record = new LeaveApplication();
		String msg;
		record.setMeetingId(1);
		record.setUserId("41624544");
		record.setReason("感冒");
		msg = leaveExaminationBiz.leaveExamination(record, 1);
		Logger logger = Logger.getLogger(getClass());
		logger.info(msg);
	}

}
