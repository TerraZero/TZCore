package tz.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Plugin {

	public String name();
	
	/**
	 * When set call the method by start
	 * @return static method
	 */
	public String init() default "";
	
}
