package neu.scweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.TeacherDao;
import neu.scweb.po.SubNews;
import neu.scweb.po.Teacher;
import neu.scweb.util.BaseDao;

@Component(value="tchDao")
public class TeacherDaoImpl implements TeacherDao {

	private BaseDao baseDao;

	public List<Teacher> queryAllTches() {
		return baseDao.listAll("Teacher");
	}
	
	public List<Teacher> queryFullTches() {
		return baseDao.query("from Teacher where tch_orgId =6 or tch_orgId =7 or tch_orgId =8 or tch_orgId =9 or tch_orgId =10 order by tchName desc");
	}
	
	public List<Teacher> queryTchesByAbbr(String tchAbbr) {
		return baseDao.query("from Teacher where tchAbbr ='"+tchAbbr+"'");

	}

	public List<Teacher> queryAllTchesByPage(int start, int limit) {
		return baseDao.queryPage("from Teacher", start, limit);
	}

	public int queryTchAmount() {
		return baseDao.listAll("Teacher").size();
	}

	public boolean saveOrUpdateTch(Teacher tch) {
		boolean state=false;
		try {
			baseDao.saveOrUpdate(tch);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public List<Teacher> queryTchesByOrgTitle(int orgId ,String orgTitle){
	
		return baseDao.query("from Teacher where tch_orgId="+ orgId+" and tchOrgTitle='"+orgTitle+"'");
	
	}


	public boolean deleteTch(Teacher tch) {
		boolean state=false;
		try {
			baseDao.delete(tch);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public Teacher queryTch(Teacher tch) {
		return (Teacher) baseDao.loadObject("from Teacher where teacherId=" + tch.getTeacherId());
	}

	public boolean updateTch(Teacher tch) {
		boolean state=false;
		try {
			baseDao.saveOrUpdate(tch);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}


	public List<Teacher> queryTchesByOrgId(int orgId) {
	
		return baseDao.query("from Teacher where tch_orgId="+ orgId);
	
	}

	public Teacher queryTchById(int tchId) {
		return (Teacher) baseDao.loadObject("from Teacher where teacherId=" + tchId);
	}

	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}




}
