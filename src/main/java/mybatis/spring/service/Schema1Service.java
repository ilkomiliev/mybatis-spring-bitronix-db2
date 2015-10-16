package mybatis.spring.service;

import mybatis.spring.persistence.Name;
import mybatis.spring.persistence.Schema1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ILIEVI on 13.10.2015.
 */
@Service
public class Schema1Service {

    @Autowired
    private Schema1Mapper mapper;

    @Transactional
    public List<Name> getAllNames() {
        return mapper.getAllNames();
    }

    @Transactional
    public int insertName(Name name) {
        return mapper.insertName(name);
    }
}
