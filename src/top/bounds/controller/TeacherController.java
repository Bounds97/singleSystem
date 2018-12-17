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
	 * 查询
	 * 
	 * @ResponseBody 该注解代表的是将返回的数据转换成json格式
	 * @RequestParam GET和POST请求传的参数会自动转换赋值到@RequestParam 所注解的变量上。
	 * 					required：是否必须有值。
	 *               	defaultValue：默认值。
	 * @param teacherPage
	 * 
	 * @return
	 * 		返回的map由@ResponseBody转换成了json格式，且含code、msg、count、data四个key值，data必须是数组形式。
	 * 		这是前端layui数据表格的接口约束，必须遵守
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
	 * 更新 地址重定向
	 * @ResponseBody 该注解代表的是将返回的数据转换成json格式
	 * @RequestBody 该注解接收的是一个Json对象的字符串
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
	 * 删除 地址重定向
	 * 
	 * @Pathvariable 该注解绑定它传过来的值到方法的参数上 就是将@RequestMapping(value =
	 *               "/teacher/{id}")中的{id}值绑定到该方法的id参数上
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
	 * 新增 地址重定向
	 * @ResponseBody 该注解代表的是将返回的数据转换成json格式
	 * @RequestBody 该注解接收的是一个Json对象的字符串
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
	 * 根据id查询
	 * @Pathvariable 该注解绑定它传过来的值到方法的参数上 就是将@RequestMapping(value =
	 *               "/teacher/{id}")中的{id}值绑定到该方法的id参数上
	 * @param id
	 * @return
	 * 		返回的map由@ResponseBody转换成了json格式，且含code、msg、count、data四个key值，data必须是数组形式。
	 * 		这是前端layui数据表格的接口约束，必须遵守
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
