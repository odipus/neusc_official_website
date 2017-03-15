package neu.scweb.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
import neu.scweb.po.Document;
import neu.scweb.po.News;
import neu.scweb.service.DocService;


@ParentPackage(value="json-default")
@Results({
	@Result(name="queryAllDocs", type="json", params={"excludeProperties","docId"}),
	@Result(name="queryDocById", type="json", params={"excludeProperties","docId"}),
	@Result(name="queryDocsAmount", type="json", params={"excludeProperties","docId"})

})
public class DocAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private DocService docService;
	private List<Document> docList;
	private Document document;
	private int docId;
	private String success;
	private String docArray;
	private int docsAmount;
	
	@Action(value="docAction")
	public String queryAllDocs(){
		docList = docService.queryAllDocs();
		return "queryAllDocs";
	}
	
	public String queryDocsAmount(){
		docsAmount = docService.queryDocsAmount();
		return "queryDocsAmount";
		
	}
	
	public String queryDocById(){
		this.getDocId();
		document = docService.queryDocById(docId);
		return "queryDocById";
	}
	
	public String addDoc(){
		this.getDocument();
		docService.addDoc(document);
		return "addDoc";
	}
	
	public String deleteDoc(){
		String stmp = this.getDocArray();
		stmp = stmp.substring(1, stmp.length() - 1);
		JSONObject jsonObject = JSONObject.fromObject(stmp);
		Document doc = docService.queryDoc((Document) jsonObject.toBean(jsonObject, Document.class));
		System.out.println("delete news"+doc.getDocId());
		if(docService.deleteDoc(doc)) {
			this.success = SUCCESS;
		}
		return "deleteDoc";
	}

	public List<Document> getDocList() {
		return docList;
	}

	public void setDocList(List<Document> docList) {
		this.docList = docList;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}



	public String getDocArray() {
		return docArray;
	}

	public void setDocArray(String docArray) {
		this.docArray = docArray;
	}

	public int getDocsAmount() {
		return docsAmount;
	}

	public void setDocsAmount(int docsAmount) {
		this.docsAmount = docsAmount;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	@Resource(name="docService")
	public void setDocService(DocService docService) {
		this.docService = docService;
	}
	
	

}
