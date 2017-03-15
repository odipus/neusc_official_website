package neu.scweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.DocDao;
import neu.scweb.po.Document;
import neu.scweb.service.DocService;

@Component(value="docService")
public class DocServiceImpl implements DocService {

	private DocDao docDao;
	
	public Document queryDocById(int docId) {
		return docDao.queryDocById(docId);
		
	}


	public int queryDocsAmount() {

		return docDao.queryDocsAmount();
	}
	
	public boolean addDoc(Document document) {
		
		return docDao.addDoc(document);
	}


	public boolean deleteDoc(Document document) {

		return docDao.deleteDoc(document);
	}


	public List<Document> queryAllDocs() {
		
		return docDao.queryAllDocs();
	}
	
	public Document queryDoc(Document doc) {
		return docDao.queryDocById(doc.getDocId());
	}
	
	@Resource(name="docDao")
	public void setDocDao(DocDao docDao) {
		this.docDao = docDao;
	}







}
