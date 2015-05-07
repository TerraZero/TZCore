package tz.core.logger;

/**
 * 
 * @author terrazero
 * @created May 6, 2015
 * 
 * @file Log.java
 * @project TZCore
 * @identifier tz.core.logger
 *
 */
public class Log {
	
	public static final String PRIO_NORMAL = "normal";
	public static final String PRIO_WARNING = "warning";
	public static final String PRIO_FATAL = "fatal";
	public static final String PRIO_CRITICAL = "critical";
	public static final String PRIO_SUCCESS = "success";
	
	public static final String IDENT_NONE = "none";
	
	public static final String IDENT_SEPERATOR = ":";
	
	private static Log log;
	
	public static Log log() {
		if (Log.log == null) {
			Log.log = new Log();
		}
		return Log.log;
	}
	
	public static Log log(Logger logger) {
		return Log.log().logger(logger);
	}
	
	public static boolean log(String message) {
		return Log.log(Log.PRIO_NORMAL, Log.IDENT_NONE, message);
	}
	
	public static boolean log(String ident, String message) {
		return Log.log(Log.PRIO_NORMAL, ident, message);
	}
	
	public static boolean log(String prio, String ident, String message, String... placeholders) {
		if (placeholders != null) {
			for (int i = 0; i < placeholders.length; i++) {
				message = message.replaceAll("\\[" + i + "\\]", "'" + placeholders[i] + "'");
			}
		}
		return Log.log().logger.log(prio, ident, message);
	}
	
	public static boolean normal(String ident, String message, String... placeholders) {
		return Log.log(Log.PRIO_NORMAL, ident, message, placeholders);
	}
	
	public static boolean success(String ident, String message, String... placeholders) {
		return Log.log(Log.PRIO_SUCCESS, ident, message, placeholders);
	}
	
	public static boolean warning(String ident, String message, String... placeholders) {
		return Log.log(Log.PRIO_WARNING, ident, message, placeholders);
	}
	
	public static boolean fatal(String ident, String message, String... placeholders) {
		return Log.log(Log.PRIO_FATAL, ident, message, placeholders);
	}
	
	public static boolean critical(String ident, String message, String... placeholders) {
		return Log.log(Log.PRIO_CRITICAL, ident, message, placeholders);
	}
	
	public static String ident(String... idents) {
		if (idents == null || idents.length == 0) return Log.IDENT_NONE;
		
		String ident = "";
		for (int i = 0; i < idents.length; i++) {
			ident += idents[i] + Log.IDENT_SEPERATOR;
		}
		return ident.substring(0, ident.length() - 1);
	}

	private Logger logger;
	
	public Log() {
		this.logger = new DefaultLogger();
	}
	
	public Log logger(Logger logger) {
		this.logger = logger;
		return this;
	}
	
}
