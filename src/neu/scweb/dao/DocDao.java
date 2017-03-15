package neu.scweb.dao;

import java.util.List;

import neu.scweb.po.Document;

public interface DocDao {

	public Document queryDocById(int docId);

	public boolean addDoc(Document document);

	public boolean deleteDoc(Document document);

	public List<Document> queryAllDocs();

	public int queryDocsAmount();


}
