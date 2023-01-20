package eclipse.base.systems.command;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Cmd {
    String name();
    String[] aliases() default {};
    String description() default "";
    String usage() default "";
}
