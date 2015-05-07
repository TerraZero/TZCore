package tz.core.logger;

/**
 * 
 * @author terrazero
 * @created May 6, 2015
 * 
 * @file DefaultLogger.java
 * @project TZCore
 * @identifier tz.core.logger
 *
 */
public class DefaultLogger implements Logger {

	/* 
	 * @see tz.core.logger.Logger#log(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean log(String prio, String ident, String message) {
		if (Log.IDENT_NONE.equals(ident)) {
			System.out.println("[" + prio.toUpperCase() + "] " + message);
		} else {
			System.out.println("[" + prio.toUpperCase() + "::" + ident.toUpperCase() + "] " + message);
		}
		return true;
	}

}
