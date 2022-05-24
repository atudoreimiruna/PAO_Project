package Repository;

import Entity.AdresaEntity;
import Mapper.AdresaEntityMapper;
import Service.DatabaseQueryExecutorService;

import java.util.ArrayList;
import java.util.List;

public class AdresaRepository {

    public static List<AdresaEntity> FindAll() {
        List<Object> objects = DatabaseQueryExecutorService.executeReadQuery("select * from Adresa", new AdresaEntityMapper());
        List<AdresaEntity> result = new ArrayList<>();

        for ( Object object: objects ) {
            if ( object instanceof AdresaEntity) {
                result.add((AdresaEntity) object);
            } else {
                throw new RuntimeException("Expected ContEntity instance");
            }
        }
        return result;
    }

    public static List<AdresaEntity> findAllForOwner(Integer owmerId_adresa)
    {
        List<Object> objects = DatabaseQueryExecutorService.executeReadQuery("select * from Adresa where Adresa.ownerId_adresa = " + owmerId_adresa, new AdresaEntityMapper());
        List<AdresaEntity> result = new ArrayList<>();

        for ( Object object: objects ) {
            if ( object instanceof AdresaEntity) {
                result.add((AdresaEntity) object);
            } else {
                throw new RuntimeException("Expected ContEntity instance");
            }
        }
        return result;
    }
}
