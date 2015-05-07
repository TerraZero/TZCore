package tz.core.annotations;

/**
 * 
 * @author terrazero
 * @created May 5, 2015
 * 
 * @file Plugin.java
 * @project TZCore
 * @identifier tz.core.annotations
 *
 */
public @interface Plugin {

	public String name();
	
	/**
	 * When set call the method by start
	 * @return static method
	 */
	public String init() default "";
	
}
