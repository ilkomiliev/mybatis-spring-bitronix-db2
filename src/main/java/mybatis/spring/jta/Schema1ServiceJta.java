package mybatis.spring.jta;

import mybatis.spring.persistence.Name;
import mybatis.spring.persistence.Schema1MapperJta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ILIEVI on 14.10.2015.
 */
@Service
public class Schema1ServiceJta {

    @Autowired
    private Schema1MapperJta schema1MapperJta;

    @Transactional
    public void updateEzm(Name name) {
        schema1MapperJta.updateDS1(name);
    }
}
