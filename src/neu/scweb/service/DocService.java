package neu.scweb.service;

import java.util.List;

import neu.scweb.po.Document;

public interface DocService {

	public Document queryDocById(int docId);
	public boolean addDoc(Document document);
	public boolean deleteDoc(Document document);
	public List<Document> queryAllDocs();
	public Document queryDoc(Document doc);
	public int queryDocsAmount();



}
