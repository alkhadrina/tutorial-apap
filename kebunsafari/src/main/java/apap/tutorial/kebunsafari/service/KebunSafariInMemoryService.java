package apap.tutorial.kebunsafari.service;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class KebunSafariInMemoryService implements KebunSafariService {
    private List<KebunSafariModel> listKebunSafari;

    public KebunSafariInMemoryService(){
        listKebunSafari = new ArrayList<>();
    }

    @Override
    public void addKebunSafari(KebunSafariModel kebunSafari){
        listKebunSafari.add(kebunSafari);
    }

    @Override
    public List<KebunSafariModel> getKebunSafariList(){
        return listKebunSafari;
    }

    @Override
    public KebunSafariModel getKebunSafariByIdKebunSafari(String idKebunSafari){
        KebunSafariModel r = null;
        for(KebunSafariModel i : listKebunSafari){
            if(i.getIdKebunSafari().equals(idKebunSafari)){
                r = i;
                break;
            }
        }

        return r;
    }

    @Override
    public KebunSafariModel updateKebunSafariByIdKebunSafari(String idKebunSafari, String noTelepon){
        KebunSafariModel kebunSafari = getKebunSafariByIdKebunSafari(idKebunSafari);
        kebunSafari.setNoTelepon(noTelepon);

        return kebunSafari;
    }

    @Override
    public void deleteAllSafari(){
        listKebunSafari.removeAll(listKebunSafari);
    }

    @Override
    public void deleteKebunSafariByIdKebunSafari(String idKebunSafari){
        KebunSafariModel kebunSafari = getKebunSafariByIdKebunSafari(idKebunSafari);
        listKebunSafari.remove(kebunSafari);
    }
}
