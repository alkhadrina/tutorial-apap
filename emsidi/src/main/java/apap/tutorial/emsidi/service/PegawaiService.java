package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.PegawaiModel;

public interface PegawaiService {
    void addPegawai(PegawaiModel pegawai);
    PegawaiModel updatePegawai(PegawaiModel pegawai);
    PegawaiModel deletePegawai(PegawaiModel pegawai);
    PegawaiModel getPegawaiByNoPegawai(Long noPegawai);
}
