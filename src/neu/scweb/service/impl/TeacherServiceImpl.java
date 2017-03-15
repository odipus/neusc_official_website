package neu.scweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.TeacherDao;
import neu.scweb.po.Teacher;
import neu.scweb.service.TeacherService;

@Component(value="tchService")
public class TeacherServiceImpl implements TeacherService{
	private TeacherDao tchDao;

	public List<Teacher> queryAllTches() {
		return tchDao.queryAllTches();
	}
	public List<Teacher> queryFullTches() {
		return tchDao.queryFullTches();
	}

	public List<Teacher> queryTchesByAbbr(String tchAbbr) {
	
		return tchDao.queryTchesByAbbr(tchAbbr);
	}
	
	public List<Teacher> queryTchesByOrgId(int orgId){
		return tchDao.queryTchesByOrgId(orgId);
	}
	public List<Teacher> queryTchesByOrgTitle(int orgId ,String orgTitle){
		return tchDao.queryTchesByOrgTitle(orgId, orgTitle);
	}

	public boolean saveOrUpdateTch(Teacher tch) {
		return tchDao.saveOrUpdateTch(tch);
	}

	public boolean deleteTch(Teacher tch) {
		return tchDao.deleteTch(tch);
	}

	public Teacher queryTch(Teacher tch) {
		return tchDao.queryTch(tch);
	}

	public boolean updateTch(Teacher tch) {
		return tchDao.updateTch(tch);
	}

	public List<Teacher> queryAllTchesByPage(int start, int limit) {
		return tchDao.queryAllTchesByPage(start, limit);
	}

	public int queryTchAmount() {
		return tchDao.queryTchAmount();
	}

	public Teacher queryTchById(int tchId) {
		return tchDao.queryTchById(tchId);
	}

	@Resource(name="tchDao")
	public void setTchDao(TeacherDao tchDao) {
		this.tchDao = tchDao;
	}



}
