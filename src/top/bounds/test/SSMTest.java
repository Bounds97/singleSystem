package top.bounds.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.bounds.pojo.Teacher;
import top.bounds.service.TeacherService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:top/bounds/config/springConfig.xml")
public class SSMTest {
	@Autowired
	private TeacherService teacherService;

	/**
	 * 测试事务管理
	 */
	@Test
	public void testFour() {
		Teacher teacher = new Teacher();
		for(int i=0;i<100;i++){
			teacher.setName("老师"+i);
			teacherService.addTeacher(teacher);
		}
	}
}
