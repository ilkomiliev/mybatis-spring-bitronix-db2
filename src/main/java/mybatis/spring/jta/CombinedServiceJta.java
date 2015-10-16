package mybatis.spring.jta;

import mybatis.spring.persistence.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ILIEVI on 14.10.2015.
 */
@Service
public class CombinedServiceJta {

    @Autowired
    private Schema1ServiceJta schema1ServiceJta;

    @Autowired
    private Schema2ServiceJta schema2ServiceJta;

    @Transactional
    public void update() {
        schema1ServiceJta.updateEzm(new Name(1, "xxx"));
        schema2ServiceJta.updateAdresse(new Name(2, "zzz"));
    }

    @Transactional
    public void updateAndRollback() {
        update();
        throw new RuntimeException("for rollback");
    }
}
