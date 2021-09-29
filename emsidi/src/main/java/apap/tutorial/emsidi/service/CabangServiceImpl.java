package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.repository.CabangDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CabangServiceImpl implements CabangService{

    @Autowired
    CabangDb cabangDb;

    @Override
    public void addCabang(CabangModel cabang){
        cabangDb.save(cabang);
    }
    
    @Override
    public void updateCabang(CabangModel cabang){
        cabangDb.save(cabang);
    }

    @Override
    public List<CabangModel> getCabangList(){
        return cabangDb.findAll();
    }

    @Override
    public CabangModel getCabangByNoCabang(Long noCabang){
        Optional<CabangModel> cabang = cabangDb.findByNoCabang(noCabang);
        if (cabang.isPresent()){
            return cabang.get();
        }

        return null;
    }

    @Override
    public List<CabangModel> getCabangListOrdered(){
        List<CabangModel> listCabang = cabangDb.findByOrderByNamaCabangAsc();
        return listCabang;
    }

    @Override
    public CabangModel deleteCabang(CabangModel cabang){
        LocalTime now = LocalTime.now();
        if(now.isBefore(cabang.getWaktuBuka()) || now.isAfter(cabang.getWaktuTutup())){
            if(cabang.getListPegawai().isEmpty()){
                cabangDb.delete(cabang);
                return null;
            }
        }

        return cabang;
    }
}
