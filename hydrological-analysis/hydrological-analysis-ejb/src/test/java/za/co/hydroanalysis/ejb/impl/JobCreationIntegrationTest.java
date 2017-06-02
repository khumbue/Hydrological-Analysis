package za.co.jobcreation.ejb.impl;

import org.junit.*;
import org.slf4j.*;
import za.co.jobcreation.ejb.AbstractIntegrationTest;

/**
 *
 * @author khumbu
 */
@Ignore
public class JobCreationIntegrationTest extends AbstractIntegrationTest {

    private static final Logger logger =
            LoggerFactory.getLogger(JobCreationIntegrationTest.class);
    
    /*IStockManagerService service;

    @BeforeClass
    public static void beforeClass() throws Exception {
        logger.info("Entering beforeClass method of {}",
                StockManagerServiceIntegrationTest.class);
        setUpBeforeClass();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        logger.info("Entering afterClass method of {}",
                StockManagerServiceIntegrationTest.class);
        tearDownAfterClass();
    }

    @Before
    public void setUp() throws Exception {
        logger.info("Entering setUp of method {}",
                testMethod.getMethodName());
        
        service = (IStockManagerService)context.lookup("stockwiz/stock-manager/StockManagerService!"+ IStockManagerService.class.getName());
    }
    
    
    @Test
    public void testGetProductCatalogue() throws Exception {
        logger.info("About to execute test method {}", testMethod.getMethodName());
        
        
        WSProductCatalogue catalogue = service.getProductCatalogue("1BB");
        
        Assert.assertNotNull(catalogue);
        
        JAXBContext jc = JAXBContext.newInstance("za.co.jobcreation.ws.api.dto");

        Marshaller marshaller = jc.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(catalogue, stringWriter);
        String result = stringWriter.toString();
        
        System.out.println(result);
        
        logger.info("Finished executing test method {}", testMethod.getMethodName());
    }*/

}
