package neu.scweb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 图片与  Blob  的相互转化
public class ScImgUtil {

	

	public static byte[] readFromImg(String ImgPath){
		System.out.println(ImgPath);
		InputStream imgStream = null;
		byte[] picContent = null;
		try {
			File file = new File(ImgPath);
			if (!file.exists()) {
				System.out.println("!file.exists() send read null");
				return null;
			}
			imgStream = new FileInputStream(file);
			picContent = new byte[imgStream.available()];
			imgStream.read(picContent);
			System.out.println("开始处理文件");
			imgStream.close();
			/**
			 * 阅后即焚233333
			 */
			boolean d = file.delete();
			System.out.println("执行文件删除结束");
			file.deleteOnExit();	
			if (d||!file.exists()) {
				System.out.print("删除成功！");
			} else{
				System.out.print("删除失败！");
			}
			return picContent;	
		} catch (FileNotFoundException e) {
			System.out.println(" FileNotFoundException send read null");
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.out.println(" IOException send read null");
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static ArrayList<String> GetImgPic(String newsContent){
		ArrayList<String> list = new ArrayList<String>();
		Pattern p = Pattern.compile("\\/upload/images/.*?\\\"");
		Matcher m = p.matcher(newsContent);
		while (m.find()) {// 遍历找到的所有大括号
			String param = m.group().replaceAll("\"", "");;
			list.add(param);
		}
		if (list.size() == 0) {
			return null;
		}else {
			return list;	
		}
	}
	
}
