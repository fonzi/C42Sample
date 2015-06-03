package Rules;

import java.lang.annotation.*;

/**
 * Allows for @Retry to be set as a rule on test cases/suits and will retry only once; if test fails twice in a row
 * it will make the test case fail.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Retry {}