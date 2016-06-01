package cn.cua.listener;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Pattern;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.cua.utils.FileUtil;
import cn.cua.utils.SystemConfig;

/**
 * @author �r��
 * @version  ��˵���������������¼��־
 *          ��Ҫ��systemconfig.properties ���������²��� ����url��������ʽ������ʱ��������
 *          logurlpattern=(.jsp$)|(.action$)|(.html$)|(.htm$)|(/$)
 *          logreqpath=D:/project/xxt_mes/visitlog/ ��¼��־�ļ���ŵط�
 */
public class VistLogListener implements ServletContextListener,
		ServletRequestListener {
	protected static Thread thread = null;
	protected static StringBuffer logMsg = new StringBuffer();
	private static boolean RUNFLAG = true;
	private static Pattern urlPattern = null;
	private static String LogPath = null;
	private final static String[] LogKey = new String[] { "session id", "IP",
			"user", "URL", "PREURL" };
	protected static Queue<String[]> container = new ConcurrentLinkedQueue<String[]>();

	/**
	 * ServletRequestListener.requestDestroyed
	 */
	public void requestDestroyed(ServletRequestEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * ServletRequestListener.requestInitialized
	 */
	public void requestInitialized(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		ServletRequest request = event.getServletRequest();
		if (request instanceof HttpServletRequest) {
			HttpServletRequest req = (HttpServletRequest) request;
			String URI = req.getRequestURI();
			if (needLog(URI)) {
				// Map<String,Object> logMap=new HashMap<String,Object>();
				String tmp = null;
				try {
					tmp = req.getQueryString() != null ? new String(req
							.getQueryString().getBytes("ISO8859_1"), "utf-8")
							: null;
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				add(new String[] { req.getSession().getId(),
						req.getRemoteAddr(),
						new MySession(req.getSession()).toString(),
						tmp != null ? URI + "?" + tmp : URI,
						req.getHeader("Referer") });
			}

		}
	}

	/**
	 * ServletContextListener.contextDestroyed
	 */
	public void contextDestroyed(ServletContextEvent event) {
		// thread.stop();
		RUNFLAG = false;
		FormartTime.stop();
		event.getServletContext().log("��־�����ر�");

	}

	/**
	 * ServletContextListener.contextInitialized
	 */
	public void contextInitialized(ServletContextEvent event) {
		String urlpattern = null;
		urlpattern = SystemConfig.getCfgValue("logurlpattern");
		LogPath = SystemConfig.getCfgValue("logreqpath");
		if (urlpattern != null && urlpattern.length() > 0) {
			urlPattern = Pattern.compile(urlpattern);
		}
		FormartTime.begin();
		logToFile();
		event.getServletContext().log("��־���������ɹ���");
	}

	/**
	 * ������¼��־��������
	 */
	private static void logToFile() {

		thread = new Thread() {
			private String[] row = null;
			private StringBuffer log = new StringBuffer();
			private int count = 0;

			public void run() {
				SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
				String pretime = format.format(new Date());
				float timeGap = 0;
				while (RUNFLAG) {
					if (container.size() == 0) {
						try {
							Thread.sleep(1000);
							// Logger.getLogger(this.getClass().getName()).info("�޷��ʣ���Ϣ1s");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					while (RUNFLAG && container.size() > 0) {
						// TODO Log
						row = container.poll();
						logMsg.delete(0, logMsg.length());
						String nowTime = FormartTime.hhmmss;

						try {

							Long time1 = format.parse(nowTime).getTime();
							Long time2 = format.parse(pretime).getTime();
							timeGap = (time1 - time2) / (1 * 1000);
							System.out.println("time1:" + nowTime + ",time2:"
									+ pretime + "_______________________"
									+ timeGap + "��");
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						logMsg.append(FormartTime.hhmmss);
						pretime = nowTime;
						for (int i = 0; i < LogKey.length; i++) {
							logMsg.append(LogKey[i] + ":" + row[i] + ",");
						}
						// JSONģʽ
						// Logger.getLogger(this.getClass().getName()).info("{"+logMsg.substring(0,
						// logMsg.length()-1)+"}");
						// ��ͨģʽ

						if (count > 2000 && log.length() > 0) {
							System.out.println(log.toString());
							FileUtil.appendAsFile(log.toString(), LogPath
									+ FormartTime.yyyyMMdd + "visit.log");
							count = 0;
							log.delete(0, log.length());
						}
						log.append(container.size() + "|" + logMsg.toString()
								+ "�����ͣ��ʱ�L:" + timeGap + "s\n");
						count++;
						// Logger.getLogger(this.getClass().getName()).info(container.size()+"|"+logMsg.toString());
					}
					if (log.length() > 0) {
						System.out.println(log.toString());

						String path = LogPath + FormartTime.yyyyMMdd
								+ "visit.log";
						FileUtil.appendAsFile(log.toString(), path);
						count = 0;
						log.delete(0, log.length());
					}
				}
			}
		};
		thread.setName("VistLogToFileThread");
		thread.start();
	}

	/**
	 * ��־�������Ԫ��
	 */
	private static void add(String[] row) {
		container.offer(row);// queue.offer("Hello");
	}

	/**
	 * �жϴ���URL�Ƿ���Ҫ��¼
	 */
	private static boolean needLog(String url) {
		if (urlPattern == null) {
			return true;
		} else {
			return urlPattern.matcher(url).find();
		}
	}

	/**
	 * ��ȡ Session
	 * 
	 * @author �Ź���
	 * @since 2010-2-22 ����02:50:01
	 */
	private class MySession {
		StringBuffer sb = new StringBuffer();

		public MySession(HttpSession session) {
			Enumeration enu = session.getAttributeNames();
			while (enu != null && enu.hasMoreElements()) {
				String name = enu.nextElement().toString();
				sb.append(name + ":{" + session.getAttribute(name) + "}");
			}
		}

		public String toString() {
			return sb.toString();
		}
	}

	/**
	 * ÿ������һ��ʱ�䴮
	 * 
	 * @author �Ź���
	 * 
	 */
	static class FormartTime {
		private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		private static SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		protected static String yyyyMMdd = getFormat1(new Date());
		protected static String hhmmss = getFormat2(new Date());

		private static final Timer timer = new Timer();

		public static void begin() {
			TimerTask tt = new TimerTask() {
				@Override
				public void run() {
					Date tmp = new Date();
					yyyyMMdd = getFormat1(tmp);
					hhmmss = getFormat2(tmp);
				}
			};
			timer.schedule(tt, 1000, 1000);
		}

		public static void stop() {
			timer.cancel();
		}

		private static String getFormat1(Date date) {
			return sdf1.format(date);
		}

		private static String getFormat2(Date date) {
			return sdf2.format(date);
		}
	}

}
