package mybatis.spring.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by ILIEVI on 13.10.2015.
 */
public interface Schema2Mapper {

    @Select({
            "select id, name from schema2.name order by id"
    })
    List<Name> getAllNames();

    @Insert({
            "insert into schema2.name (id, name) values (#{id}, #{name})"
    })
    int insertName(Name name);
}
