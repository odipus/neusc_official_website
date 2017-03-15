package neu.scweb.service;

import java.util.List;

import neu.scweb.po.Teacher;

public interface TeacherService {
	public List<Teacher> queryAllTches();
	public List<Teacher> queryAllTchesByPage(int start, int limit);
	public int queryTchAmount();
	public boolean saveOrUpdateTch(Teacher tch);
	public List<Teacher> queryTchesByOrgTitle(int orgId ,String orgTitle);
	public List<Teacher> queryTchesByOrgId(int orgId);
	public boolean deleteTch(Teacher tch);
	public Teacher queryTch(Teacher tch);
	public boolean updateTch(Teacher tch);
	public Teacher queryTchById(int tchId);
	public List<Teacher> queryFullTches();
	public List<Teacher> queryTchesByAbbr(String tchAbbr);
}
