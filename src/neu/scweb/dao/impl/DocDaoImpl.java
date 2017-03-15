package neu.scweb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.DocDao;
import neu.scweb.po.Document;
import neu.scweb.util.BaseDao;

@Component(value="docDao")
public  class DocDaoImpl implements DocDao {

	private BaseDao baseDao;
	
	public Document queryDocById(int docId) {
		return (Document) baseDao.loadObject("from Document where docId=" + docId);
	}


	public int queryDocsAmount() {
		
		return baseDao.listAll("Document").size();

	}


	public boolean addDoc(Document document) {
		boolean state = false;
		try {
			baseDao.saveOrUpdate(document);
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}


	public boolean deleteDoc(Document document) {
		boolean state=false;
		try {
			baseDao.delete(document);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}


	public List<Document> queryAllDocs() {
		
		return baseDao.listAll("Document");
	}

	
	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}





}
