package top.bounds.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.bounds.pojo.Teacher;
import top.bounds.service.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	TeacherService teacherService;

	/**
	 * ��ѯ
	 * 
	 * @ResponseBody ��ע�������ǽ����ص�����ת����json��ʽ
	 * @RequestParam GET��POST���󴫵Ĳ������Զ�ת����ֵ��@RequestParam ��ע��ı����ϡ�
	 * 					required���Ƿ������ֵ��
	 *               	defaultValue��Ĭ��ֵ��
	 * @param teacherPage
	 * 
	 * @return
	 * 		���ص�map��@ResponseBodyת������json��ʽ���Һ�code��msg��count��data�ĸ�keyֵ��data������������ʽ��
	 * 		����ǰ��layui���ݱ��Ľӿ�Լ������������
	 */
	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> listTeacher(
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "10") int limit) {
		int start = page * limit - limit;
		List<Teacher> list = teacherService.listTeacher(start, limit);
		int total = teacherService.total();
		Object[] teacherArray = (Object[]) list.toArray();
		Map<String, Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", total);
		map.put("data", teacherArray);
		return map;
	}

	/**
	 * ���� ��ַ�ض���
	 * @ResponseBody ��ע�������ǽ����ص�����ת����json��ʽ
	 * @RequestBody ��ע����յ���һ��Json������ַ���
	 * @param teacher
	 * @return
	 */
	@RequestMapping(value = "/teacher", method = RequestMethod.PUT)
	public @ResponseBody Map<String, Object> updateTeacher(@RequestBody Teacher t) {
		int status = teacherService.updateTeacher(t);
		Map<String, Object> map = new HashMap<>();
		map.put("status", status);
		return map;
	}

	/**
	 * ɾ�� ��ַ�ض���
	 * 
	 * @Pathvariable ��ע�������������ֵ�������Ĳ����� ���ǽ�@RequestMapping(value =
	 *               "/teacher/{id}")�е�{id}ֵ�󶨵��÷�����id������
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/teacher/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Map<String, Object> deleteTeacher(@PathVariable int id) {
		int status = teacherService.deleteTeacher(id);
		Map<String, Object> map = new HashMap<>();
		map.put("status", status);
		return map;
	}

	/**
	 * ���� ��ַ�ض���
	 * @ResponseBody ��ע�������ǽ����ص�����ת����json��ʽ
	 * @RequestBody ��ע����յ���һ��Json������ַ���
	 * @param teacher
	 * @return
	 */
	@RequestMapping(value = "/teacher", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> addTeacher(@RequestBody Teacher t) {
		int status = teacherService.addTeacher(t);
		Map<String, Object> map = new HashMap<>();
		map.put("status", status);
		return map;
	}

	/**
	 * ����id��ѯ
	 * @Pathvariable ��ע�������������ֵ�������Ĳ����� ���ǽ�@RequestMapping(value =
	 *               "/teacher/{id}")�е�{id}ֵ�󶨵��÷�����id������
	 * @param id
	 * @return
	 * 		���ص�map��@ResponseBodyת������json��ʽ���Һ�code��msg��count��data�ĸ�keyֵ��data������������ʽ��
	 * 		����ǰ��layui���ݱ��Ľӿ�Լ������������
	 */
	@RequestMapping(value = "/teacher/{id}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> selectById(@PathVariable int id) {
		List<Teacher> list = teacherService.selectById(id);
		int total = teacherService.selectCountById(id);
		Object[] teacherArray = (Object[]) list.toArray();
		Map<String, Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", total);
		map.put("data", teacherArray);
		return map;
	}
}
