package Rules;

import Rules.Retry;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/**
 * This is for selenium control, in case the network is slow, and selenium tries to access a web element that has not yet been loaded
 * The assert will fail and this will make that test run only once.
 */
public class RetryRule implements MethodRule
{
    @Override public Statement apply(final Statement base, final FrameworkMethod method, Object target)
    {
        return new Statement()
        {
            @Override public void evaluate() throws Throwable
            {
                try
                {
                    base.evaluate();
                } catch (Throwable t)
                {
                    Retry retry = method.getAnnotation(Retry.class);
                    if (retry != null && base != null)
                    {
                        System.out.println("*** Retrying:  Exception was:  " + t.toString());
                        t.printStackTrace();
                        base.evaluate();
                    }
                    else
                    {
                        throw t;
                    }
                }
            }
        };
    }
}