package mybatis.spring.service;

import mybatis.spring.jta.CombinedServiceJta;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.fail;

/**
 * Created by ILIEVI on 14.10.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/app-config-jta.xml")
public class JtaXATxManagerTest {

    @Autowired
    private CombinedServiceJta combinedService;

    @Test
    public void testRollback() throws Exception {
        try {
            combinedService.updateAndRollback();
            fail("exception must be thrown");
        }
        catch (Exception e) {
            // ignore it as it is expected
        }

    }

    @Test
    public void testCommit() throws Exception {
        combinedService.update();
    }
}
