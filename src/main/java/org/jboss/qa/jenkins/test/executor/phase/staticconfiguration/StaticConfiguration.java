package org.jboss.qa.jenkins.test.executor.phase.staticconfiguration;

import org.jboss.qa.phaser.Id;
import org.jboss.qa.phaser.Order;
import org.jboss.qa.phaser.ParentId;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface StaticConfiguration {

	@Id
	String id() default "";

	@ParentId
	String download() default "";

	@Order
	int order() default 0;
}