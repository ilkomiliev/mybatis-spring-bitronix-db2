package mybatis.spring.jta;

import mybatis.spring.persistence.Name;
import mybatis.spring.persistence.Schema2MapperJta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ILIEVI on 14.10.2015.
 */
@Service
public class Schema2ServiceJta {

    @Autowired
    private Schema2MapperJta schema2MapperJta;

    @Transactional
    public void updateAdresse(Name name) {
        schema2MapperJta.updateDS2(name);
    }
}
