package Repository;

import Entity.AdresaEntity;
import Mapper.AdresaEntityMapper;
import Service.DatabaseQueryExecutorService;

import java.util.ArrayList;
import java.util.List;

public class AdresaRepository extends Repository{

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

    public static void updateCodPostal(Integer id_adresa, Integer cod_postal) {
        if(cod_postal == null){
            executeQuery("update Adresa set cod_postal = null where id_adresa=" + id_adresa);
        } else {
            executeQuery("update Adresa set cod_postal =" + cod_postal + " where id_adresa=" + id_adresa);
        }
    }

    public static AdresaEntity find(int id_adresa){
        try {
            return readQuery("select * from adresa where id_adresa=" + id_adresa, new AdresaEntityMapper()).get(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
}
