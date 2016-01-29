package junit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Test {

	Class<?> expected() default None.class;

	long timeout() default 0L;

}
