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
	
	public boolean init() default true;
	
}
