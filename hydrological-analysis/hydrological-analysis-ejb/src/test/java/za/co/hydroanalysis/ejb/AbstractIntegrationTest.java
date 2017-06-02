package za.co.jobcreation.ejb;

import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import org.junit.*;
import org.junit.rules.TestName;
import org.slf4j.*;

/**
 *
 * @author khumbu
 */
public class AbstractIntegrationTest {

    private static final Logger logger =
            LoggerFactory.getLogger(AbstractIntegrationTest.class);
    
    protected static Context context;
    
    @Rule
    public TestName testMethod = new TestName();

    /**
     * The setup routine to be used by all
     * <code>@BeforeClass</code> methods. This is static, since it must be
     * invoked from static methods in actual IntegrationTest classes.
     *
     * @throws Exception
     */
    public static void setUpBeforeClass() throws Exception {
        final Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "remote://localhost:4447");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        context = new InitialContext(jndiProperties);
        traverseJndiNode("/", context);
    }

    /**
     * The tear down routine to be used by
     * <code>@AfterClass</code> methods. This is static as it must be invoked
     * from static methods in IntegrationTest classes.
     *
     * @throws Exception
     */
    public static void tearDownAfterClass() throws Exception {
    }
    
    private static void traverseJndiNode(String nodeName, Context context)  {
        try {
            NamingEnumeration<NameClassPair> list = context.list(nodeName);
            while (list.hasMore()){
                String childName = nodeName + "/" + list.next().getName();
                logger.info(childName);
                traverseJndiNode(childName, context);
            }
        } catch (NamingException ex) {
            // We reached a leaf
        }
    }

}