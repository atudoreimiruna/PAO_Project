package Repository;

import Entity.CardEntity;
import Mapper.CardEntityMapper;
import Service.DatabaseQueryExecutorService;

import java.util.*;

public class CardRepository {
    public static List<CardEntity> FindAll() {
        List<Object> objects = DatabaseQueryExecutorService.executeReadQuery("select * from Card", new CardEntityMapper());
        List<CardEntity> result = new ArrayList<>();

        for ( Object object: objects ) {
            if ( object instanceof CardEntity) {
                result.add((CardEntity) object);
            } else {
                throw new RuntimeException("Expected CardEntity instance");
            }
        }
        return result;
    }

    public static List<CardEntity> findAllForOwner(Integer owmerId)
    {
        List<Object> objects = DatabaseQueryExecutorService.executeReadQuery("select * from Card where Card.ownerId = " + owmerId, new CardEntityMapper());
        List<CardEntity> result = new ArrayList<>();

        for ( Object object: objects ) {
            if ( object instanceof CardEntity) {
                result.add((CardEntity) object);
            } else {
                throw new RuntimeException("Expected CardEntity instance");
            }
        }
        return result;
    }
}
