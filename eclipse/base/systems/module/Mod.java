package eclipse.base.systems.module;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Mod { // TODO: Module annotation, for the mod info
    String name();
    String description();
    int key();
}