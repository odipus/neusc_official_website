package neu.scweb.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDBFactory
{
	static String url="jdbc:mysql://localhost:53306/scweb";
	static String userName = "ATXJyfPhLp8xTVgE";
	static String password = "8Q2n3nOuD9TXzhVy6ODhTLoaEcj050oh";

	static Connection con = null;
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (Exception ex)
		{
			ex.printStackTrace();
			System.out.println("加载驱动器类时出现异常");
		}
		try
		{
			con = DriverManager.getConnection(url,userName,password);
		}catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("出现SQLException异常");
		 }
		 System.out.println("加载驱动器成功");
		 return con;
	}
	
}
