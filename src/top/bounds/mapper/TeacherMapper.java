package top.bounds.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import top.bounds.pojo.Teacher;

public interface TeacherMapper {

	/**
	 * 查询所有
	 * @return
	 */
	public List<Teacher> listTeacher(@Param("start")int start, @Param("limit")int limit);

	/**
	 * 根据Id（内码）查找
	 * @param id
	 * @return
	 */
	public List<Teacher> selectById(int id);
	
	/**
	 * 更新记录
	 * @param teacher
	 */
	public int updateTeacher(Teacher teacher);
	
	/**
	 * 删除记录
	 * @param id
	 * @return
	 */
	public int deleteTeacher(int id);
	
	/**
	 * 增加记录
	 * @param teacher
	 * @return
	 */
	public int addTeacher(Teacher teacher); 
	
	/**
	 * 获取数据总数
	 * @return
	 */
	public int total();
	
	/**
	 * 根据获取数据总数
	 * @return
	 */
	public int selectCountById(int id);
}
