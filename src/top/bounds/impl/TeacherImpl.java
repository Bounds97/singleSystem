package top.bounds.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.bounds.mapper.TeacherMapper;
import top.bounds.pojo.Teacher;
import top.bounds.service.TeacherService;

@Service
public class TeacherImpl implements TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;

	@Override
	public List<Teacher> selectById(int id) {

		return teacherMapper.selectById(id);
	}

	@Override
	public int updateTeacher(Teacher teacher) {

		return teacherMapper.updateTeacher(teacher);
	}

	@Override
	public int deleteTeacher(int id) {

		return teacherMapper.deleteTeacher(id);
	}

	@Override
	public int addTeacher(Teacher teacher) {
		return teacherMapper.addTeacher(teacher);
	}

	@Override
	public List<Teacher> listTeacher(int start, int limit) {

		return teacherMapper.listTeacher(start,limit);
	}

	@Override
	public int total() {

		return teacherMapper.total();
	}

	@Override
	public int selectCountById(int id) {

		return teacherMapper.selectCountById(id);
	}

}
