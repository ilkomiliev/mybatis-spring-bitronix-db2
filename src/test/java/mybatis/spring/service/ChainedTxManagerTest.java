package mybatis.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
@ContextConfiguration("/app-context.xml")
public class ChainedTxManagerTest {

    @Autowired
    private CombinedService combinedService;

    @Autowired
    private Schema1Service schema1Service;

    @Autowired
    private Schema2Service schema2Service;

    @Test
    public void testRollback() throws Exception {
        try {
            combinedService.insert2RowsSchema1And1RowSchema2AndRollbackEverything();
            fail("we need exception!");
        }
        catch (Exception e) {
            // expected
        }
        assertEquals(0, schema1Service.getAllNames().size());
        assertEquals(0, schema2Service.getAllNames().size());
    }

    @Test
    public void testCommit() throws Exception {
        combinedService.insert2RowsSchema1And1RowSchema2();
        assertEquals(2, schema1Service.getAllNames().size());
        assertEquals(1, schema2Service.getAllNames().size());
    }
}
