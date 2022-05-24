package Service;

import Entity.AdresaEntity;
import Model.Adresa;
import Repository.AdresaRepository;

import java.util.ArrayList;
import java.util.List;

// card = adresa
public class AdresaService {
    public static List<Adresa> getAllAddresses() {
        List<AdresaEntity> adresaEntity = AdresaRepository.FindAll();
        List<Adresa> result = new ArrayList<>();

        for( AdresaEntity adresaEntity1: adresaEntity) {
            result.add(new Adresa(adresaEntity1.getId_adresa(), adresaEntity1.getStrada(), adresaEntity1.getOras(), adresaEntity1.getTara(), adresaEntity1.getCod_postal()));
        }
        return result;
    }
    public static List<Adresa> getAllAddressesForOwner(int ownerId_adresa)
    {
        List<AdresaEntity> adresaEntity = AdresaRepository.findAllForOwner(ownerId_adresa);
        List<Adresa> result = new ArrayList<>();

        for( AdresaEntity adresaEntity1: adresaEntity) {
            result.add(new Adresa(adresaEntity1.getId_adresa(), adresaEntity1.getStrada(), adresaEntity1.getOras(), adresaEntity1.getTara(), adresaEntity1.getCod_postal()));
        }
        return result;
    }
}
