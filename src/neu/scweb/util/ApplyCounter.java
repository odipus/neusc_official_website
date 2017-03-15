package neu.scweb.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ApplyCounter implements HttpSessionListener, ServletRequestListener {
	HttpServletRequest request;

	public void sessionCreated(HttpSessionEvent hse) {
		HttpSession hs = hse.getSession();
		String ip = request.getRemoteAddr();
		if (ip != null) {

			Connection con = ConnectDBFactory.getConnection();
			String clientInfo = getClientInfo();
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = formatter.format(date);
			String sessionId = hs.getId();
			StringBuffer url = request.getRequestURL();
			System.out.println("新访问用户 " + ip + "时间：" + dateString);
			String sql = "insert into counter(counterId,clientIp,clientInfo,accessDate,url,sessionId) values(" + null + ",'" + ip + "','" + clientInfo + "','" + dateString + "'," + "'" + url + "','" + sessionId + "')";
			PreparedStatement preStatement;
			try {
				preStatement = con.prepareStatement(sql);
				preStatement.executeUpdate();
				preStatement.close();
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public String getClientInfo() {
		String Agent = request.getHeader("User-Agent");
		StringTokenizer st = new StringTokenizer(Agent, ";");
		String clientInfo = st.nextToken();
		System.out.println("clientInfo" + clientInfo);
		return clientInfo;

	}

	public int getCounterAmount() {
		int count = 0;
		Connection con = ConnectDBFactory.getConnection();
		String sql = "select count(*) from counter ";
		try {
			PreparedStatement preStatement = con.prepareStatement(sql);
			ResultSet rs = preStatement.executeQuery(sql);
			rs.next();
			count = rs.getInt(1);
			preStatement.close();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public void sessionDestroyed(HttpSessionEvent hse) {

		HttpSession hs = hse.getSession();
		String sessionId = hs.getId();
		long lastAccessedTime = hs.getLastAccessedTime();
		Date lat = new Date(lastAccessedTime);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String leaveDate = formatter.format(lat);
		System.out.println("用户session失效,记录其离开时间:" + leaveDate);
		Connection con = ConnectDBFactory.getConnection();
		String sql = "update counter set leaveDate='" + leaveDate + "' where sessionId='" + sessionId + "'";
		PreparedStatement preStatement;
		try {
			preStatement = con.prepareStatement(sql);
			preStatement.executeUpdate();
			preStatement.close();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void requestDestroyed(ServletRequestEvent sRequestEvent) {

	}

	public void requestInitialized(ServletRequestEvent sRequestEvent) {
		request = (HttpServletRequest) sRequestEvent.getServletRequest();
	}

}