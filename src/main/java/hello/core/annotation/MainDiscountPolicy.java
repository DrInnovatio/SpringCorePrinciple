package hello.core.annotation;

import javax.inject.Qualifier;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
//@Qualifier("MainDiscountPolicy")

public @interface MainDiscountPolicy {
}
