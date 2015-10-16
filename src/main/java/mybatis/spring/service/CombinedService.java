package mybatis.spring.service;

import mybatis.spring.persistence.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ILIEVI on 13.10.2015.
 */
@Service
public class CombinedService {

    @Autowired
    private Schema1Service schema1Service;

    @Autowired
    private Schema2Service schema2Service;

    @Transactional
    public void insert2RowsSchema1And1RowSchema2AndRollbackEverything() {
        insert2RowsSchema1And1RowSchema2();
        throw new RuntimeException("for rollback");
    }

    @Transactional
    public void insert2RowsSchema1And1RowSchema2() {
        schema1Service.insertName(new Name(1, "name1"));
        schema1Service.insertName(new Name(2, "name2"));
        schema2Service.insertName(new Name(1, "name1"));
    }
}
