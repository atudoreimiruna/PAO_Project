package Repository;

import Entity.ContEntity;
import Mapper.ContEntityMapper;
import Service.DatabaseQueryExecutorService;

import java.util.ArrayList;
import java.util.List;

public class ContRepository {
    public static List<ContEntity> FindAll() {
        List<Object> objects = DatabaseQueryExecutorService.executeReadQuery("select * from Cont", new ContEntityMapper());
        List<ContEntity> result = new ArrayList<>();

        for ( Object object: objects ) {
            if ( object instanceof ContEntity) {
                result.add((ContEntity) object);
            } else {
                throw new RuntimeException("Expected ContEntity instance");
            }
        }
        return result;
    }

    public static List<ContEntity> findAllForOwner(Integer owmerId_cont)
    {
        List<Object> objects = DatabaseQueryExecutorService.executeReadQuery("select * from Cont where Cont.ownerId_cont = " + owmerId_cont, new ContEntityMapper());
        List<ContEntity> result = new ArrayList<>();

        for ( Object object: objects ) {
            if ( object instanceof ContEntity) {
                result.add((ContEntity) object);
            } else {
                throw new RuntimeException("Expected ContEntity instance");
            }
        }
        return result;
    }

}
