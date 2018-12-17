package top.bounds.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import top.bounds.pojo.Teacher;

public interface TeacherMapper {

	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Teacher> listTeacher(@Param("start")int start, @Param("limit")int limit);

	/**
	 * ����Id�����룩����
	 * @param id
	 * @return
	 */
	public List<Teacher> selectById(int id);
	
	/**
	 * ���¼�¼
	 * @param teacher
	 */
	public int updateTeacher(Teacher teacher);
	
	/**
	 * ɾ����¼
	 * @param id
	 * @return
	 */
	public int deleteTeacher(int id);
	
	/**
	 * ���Ӽ�¼
	 * @param teacher
	 * @return
	 */
	public int addTeacher(Teacher teacher); 
	
	/**
	 * ��ȡ��������
	 * @return
	 */
	public int total();
	
	/**
	 * ���ݻ�ȡ��������
	 * @return
	 */
	public int selectCountById(int id);
}
