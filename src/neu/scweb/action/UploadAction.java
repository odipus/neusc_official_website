package neu.scweb.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;


import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;



import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value="json-default")
//@ParentPackage(value="struts-default")
@Results({
	@Result(name="uploadPicnews", type="json",params={"includeProperties","success"}),
	@Result(name="uploadAttach",type="json",params={"includeProperties","success"}),
	@Result(name="uploadPicnewsUp", type="json",params={"includeProperties","success"}),
	@Result(name="uploadPicnewsSubUp", type="json",params={"includeProperties","success"})
	//@Result(name="queryAllAdmins",type="json",params={"excludeProperties","success,admin,adminPrivilege"}),
})
public class UploadAction extends ActionSupport{
	private static final int BUFFER_SIZE = 16 * 1024;

	private File newsPic;
	private File newsPicUp;
	private File subNewsPicUp;
	private File tchImageUp;
	private File[] attach;
	private String newsPicFileName;
	private String newsPicUpFileName;
	private String subNewsPicUpFileName;
	private String tchImageUpFileName;
	private String[] attachFileName;
	private String newsPicContentType;
	private String newsPicUpContentType;
	private String subNewsPicUpContentType;
	private String[] attachContentType;
	private String newsPicSavePath;
	private String newsPicUpSavePath;
	private String subNewsPicUpSavePath;
	private String attachSavePath;
	private String success;
	private String result;
	private String savePath;

	@Action(value="uploadAction",params={"savePath","/upload/picnews"})

	public String uploadAttach() {
		try {
			File[] attachFile = this.getAttach();
			String[] attachFileName = this.getAttachFileName();
//			String dstPath = ServletActionContext.getServletContext().getRealPath(this.getSavePath())+ "\\";
			String dstPath = ServletActionContext.getServletContext().getRealPath(this.getSavePath())+ "/";
			System.out.println("sadadadadad:"+dstPath);
			for(int i = 0; i < attachFile.length; i++) {

				dstPath = dstPath + attachFileName[i];
				File dstFile = new File(dstPath);
				System.out.println("文件大小是11："+attachFile[i].length()/1024 +"kb");
				copy(attachFile[i], dstFile);
				System.out.println(dstPath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.success = SUCCESS;
		return "uploadAttach";
	}
	
	public String uploadTchImage() {
		//System.out.println(this.getNewsPicSavePath());
		//System.out.println("上传的文件的类型："+ this.getNewsPicContentType());
		//System.out.println(ServletActionContext.getServletContext().getRealPath(this.getNewsPicSavePath()));
//		String dstPath = ServletActionContext.getServletContext().getRealPath("/upload/teachers")
//                + "\\" + this.getTchImageUpFileName();
		String dstPath = ServletActionContext.getServletContext().getRealPath("/upload/teachers")
                + "/" + this.getTchImageUpFileName();
        /*
		String dstPath = "D:\\ScWeb\\eclipse-jee\\workspace\\ScWeb\\WebContent\\upload\\picnews"
                + "\\" + this.getNewsPicFileName();
		*/
		
		System.out.println(dstPath);
		File dstFile = new File(dstPath);
		copy(this.tchImageUp, dstFile);
		this.success = SUCCESS;
		return "uploadTchImage";
	}
	public String uploadPicnews() {
		//System.out.println(this.getNewsPicSavePath());
		//System.out.println("上传的文件的类型："+ this.getNewsPicContentType());
		//System.out.println(ServletActionContext.getServletContext().getRealPath(this.getNewsPicSavePath()));
//		String dstPath = ServletActionContext.getServletContext().getRealPath("/upload/picnews")
//                + "\\" + this.getNewsPicFileName();
		String dstPath = ServletActionContext.getServletContext().getRealPath("/upload/picnews")
                + "/" + this.getNewsPicFileName();
        /*
		String dstPath = "D:\\ScWeb\\eclipse-jee\\workspace\\ScWeb\\WebContent\\upload\\picnews"
                + "\\" + this.getNewsPicFileName();
		*/
		
		System.out.println(dstPath);
		File dstFile = new File(dstPath);
		copy(this.newsPic, dstFile);
		this.success = SUCCESS;
		return "uploadPicnews";
	}

	public String uploadPicnewsUp() {
		/*
		String dstPath = ServletActionContext.getServletContext().getRealPath(this.getNewsPicSavePath())
                         + "\\" + this.getNewsPicFileName();
        */
        /*
		String dstPath = "D:\\ScWeb\\eclipse-jee\\workspace\\ScWeb\\WebContent\\upload\\picnews"
                + "\\" + this.getNewsPicUpFileName();
		*/
//		String dstPath = ServletActionContext.getServletContext().getRealPath("/upload/picnews")
//                + "\\" + this.getNewsPicUpFileName();
		String dstPath = ServletActionContext.getServletContext().getRealPath("/upload/picnews")
                + "/" + this.getNewsPicUpFileName();
		System.out.println("上传的文件的类型："+ this.getNewsPicUpContentType());
		System.out.println(dstPath);
		File dstFile = new File(dstPath);
		copy(this.newsPicUp, dstFile);
		this.success = SUCCESS;
		return "uploadPicnewsUp";
	}

	public String uploadPicnewsSubUp() {
		/*
		String dstPath = ServletActionContext.getServletContext().getRealPath(this.getNewsPicSavePath())
                         + "\\" + this.getNewsPicFileName();
        
		String dstPath = "D:\\ScWeb\\eclipse-jee\\workspace\\ScWeb\\WebContent\\upload\\picnews"
                + "\\" + this.getSubNewsPicUpFileName();
		*/
//		String dstPath = ServletActionContext.getServletContext().getRealPath("/upload/picnews")
//                + "\\" + this.getNewsPicFileName();
		String dstPath = ServletActionContext.getServletContext().getRealPath("/upload/picnews")
                + "/" + this.getNewsPicFileName();
		System.out.println("上传的文件的类型："+ this.getSubNewsPicUpContentType());
		System.out.println(dstPath);
		File dstFile = new File(dstPath);
		copy(this.subNewsPicUp, dstFile);
		this.success = SUCCESS;
		return "uploadPicnewsSubUp";
	}

	private static void copy(File src, File dst) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


	public File getNewsPic() {
		return newsPic;
	}

	public void setNewsPic(File newsPic) {
		this.newsPic = newsPic;
	}

	public String getNewsPicFileName() {
		return newsPicFileName;
	}

	public void setNewsPicFileName(String newsPicFileName) {
		this.newsPicFileName = newsPicFileName;
	}

	public String getNewsPicContentType() {
		return newsPicContentType;
	}

	public void setNewsPicContentType(String newsPicContentType) {
		this.newsPicContentType = newsPicContentType;
	}

	public String getNewsPicSavePath() {
		return newsPicSavePath;
	}

	public void setNewsPicSavePath(String newsPicSavePath) {
		this.newsPicSavePath = newsPicSavePath;
	}

	public String getAttachSavePath() {
		return attachSavePath;
	}

	public void setAttachSavePath(String attachSavePath) {
		this.attachSavePath = attachSavePath;
	}

	public String[] getAttachContentType() {
		return attachContentType;
	}

	public void setAttachContentType(String[] attachContentType) {
		this.attachContentType = attachContentType;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}


	public File[] getAttach() {
		return attach;
	}

	public void setAttach(File[] attach) {
		this.attach = attach;
	}

	public String[] getAttachFileName() {
		return attachFileName;
	}

	public void setAttachFileName(String[] attachFileName) {
		this.attachFileName = attachFileName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public File getNewsPicUp() {
		return newsPicUp;
	}

	public void setNewsPicUp(File newsPicUp) {
		this.newsPicUp = newsPicUp;
	}

	public String getNewsPicUpFileName() {
		return newsPicUpFileName;
	}

	public void setNewsPicUpFileName(String newsPicUpFileName) {
		this.newsPicUpFileName = newsPicUpFileName;
	}

	public String getNewsPicUpContentType() {
		return newsPicUpContentType;
	}

	public void setNewsPicUpContentType(String newsPicUpContentType) {
		this.newsPicUpContentType = newsPicUpContentType;
	}

	public String getNewsPicUpSavePath() {
		return newsPicUpSavePath;
	}

	public void setNewsPicUpSavePath(String newsPicUpSavePath) {
		this.newsPicUpSavePath = newsPicUpSavePath;
	}

	public File getSubNewsPicUp() {
		return subNewsPicUp;
	}

	public void setSubNewsPicUp(File subNewsPicUp) {
		this.subNewsPicUp = subNewsPicUp;
	}

	public String getSubNewsPicUpFileName() {
		return subNewsPicUpFileName;
	}

	public void setSubNewsPicUpFileName(String subNewsPicUpFileName) {
		this.subNewsPicUpFileName = subNewsPicUpFileName;
	}

	public String getSubNewsPicUpContentType() {
		return subNewsPicUpContentType;
	}

	public void setSubNewsPicUpContentType(String subNewsPicUpContentType) {
		this.subNewsPicUpContentType = subNewsPicUpContentType;
	}

	public String getSubNewsPicUpSavePath() {
		return subNewsPicUpSavePath;
	}

	public void setSubNewsPicUpSavePath(String subNewsPicUpSavePath) {
		this.subNewsPicUpSavePath = subNewsPicUpSavePath;
	}

	public String getTchImageUpFileName() {
		return tchImageUpFileName;
	}

	public void setTchImageUpFileName(String tchImageUpFileName) {
		this.tchImageUpFileName = tchImageUpFileName;
	}

	public File getTchImageUp() {
		return tchImageUp;
	}

	public void setTchImageUp(File tchImageUp) {
		this.tchImageUp = tchImageUp;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

}
