package mybatis.spring.persistence;

import org.apache.ibatis.annotations.Update;

/**
 * Created by ILIEVI on 14.10.2015.
 */
public interface Schema1MapperJta {

    @Update({
            "Your update here"
    })
    void updateDS1(Name name);
}
