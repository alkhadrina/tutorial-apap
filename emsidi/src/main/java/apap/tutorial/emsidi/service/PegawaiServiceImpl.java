package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.PegawaiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService{
    
    @Autowired
    PegawaiDb pegawaiDb;

    @Override
    public void addPegawai(PegawaiModel pegawai){
        pegawaiDb.save(pegawai);
    }

    @Override
    public PegawaiModel updatePegawai(PegawaiModel pegawai){
        LocalTime now = LocalTime.now();
        if(now.isBefore(pegawai.getCabang().getWaktuBuka()) || now.isAfter(pegawai.getCabang().getWaktuTutup())){
            pegawaiDb.save(pegawai);
            return pegawai;
        }
        return null;
    }

    @Override
    public PegawaiModel getPegawaiByNoPegawai(Long noPegawai){
        Optional<PegawaiModel> pegawai = pegawaiDb.findByNoPegawai(noPegawai);
        if (pegawai.isPresent()){
            return pegawai.get();
        }
        return null;
    }

    @Override
    public PegawaiModel deletePegawai(PegawaiModel pegawai){
        LocalTime now = LocalTime.now();
        if(now.isBefore(pegawai.getCabang().getWaktuBuka()) || now.isAfter(pegawai.getCabang().getWaktuTutup())){
            pegawaiDb.delete(pegawai);
            return null;
        }

        return pegawai;
    }
}
