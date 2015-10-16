package mybatis.spring.persistence;

import org.apache.ibatis.annotations.Update;

/**
 * Created by ILIEVI on 14.10.2015.
 */
public interface Schema2MapperJta {

    @Update({
            "your update here"
    })
    void updateDS2(Name name);
}
