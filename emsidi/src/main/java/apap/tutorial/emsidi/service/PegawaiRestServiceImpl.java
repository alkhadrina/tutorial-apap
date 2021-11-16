package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.PegawaiDb;
import apap.tutorial.emsidi.repository.CabangDb;
import apap.tutorial.emsidi.rest.Setting;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class PegawaiRestServiceImpl implements PegawaiRestService {
    private final WebClient webClient;

    @Autowired
    private PegawaiDb pegawaiDb;

    @Autowired
    private CabangDb cabangDb;

    public PegawaiRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.agify.io?name=").build();
    }

    // @Override
    // public Mono<String> getStatus(Long noPegawai) {
    // return this.webClient.get().uri("/rest/pegawai/" + noPegawai +
    // "/status").retrieve().bodyToMono(String.class);

    // }

    @Override
    public PegawaiModel createPegawai(PegawaiModel pegawai) {
        return pegawaiDb.save(pegawai);
    }

    @Override
    public List<PegawaiModel> retrieveListPegawai() {
        return pegawaiDb.findAll();
    }

    @Override
    public List<PegawaiModel> retrieveListPegawaiByJenisKelamin(int jenisKelamin) {

    }

    @Override
    public PegawaiModel getPegawaiByNoPegawai(Long noPegawai) {
        Optional<PegawaiModel> pegawai = pegawaiDb.findByNoPegawai(noPegawai);

        if (pegawai.isPresent()) {
            return pegawai.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public PegawaiModel updatePegawai(Long noPegawai, PegawaiModel pegawaiUpdate) {
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);

        pegawai.setNamaPegawai(pegawaiUpdate.getNamaPegawai());
        pegawai.setJenisKelamin(pegawaiUpdate.getJenisKelamin());
        pegawai.setCabang(cabangDb.getById(pegawaiUpdate.getCabang().getNoCabang()));

        return pegawaiDb.save(pegawai);
    }

    @Override
    public void deletePegawai(Long noPegawai) {
        LocalTime now = LocalTime.now();

        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);

        if ((now.isBefore(pegawai.getCabang().getWaktuBuka()) || now.isAfter(pegawai.getCabang().getWaktuTutup()))) {
            pegawaiDb.delete(pegawai);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public PegawaiModel getUmurPegawaiByNoPegawai(Long noPegawai) {
        LocalTime now = LocalTime.now();

        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);

        if ((now.isBefore(pegawai.getCabang().getWaktuBuka()) || now.isAfter(pegawai.getCabang().getWaktuTutup()))) {

            String nama = pegawai.getNamaPegawai();
            String[] arr = nama.split(" ");
            // this.webClient.get().uri(arr[0]).retrieve()

            return pegawai;
        } else {
            throw new UnsupportedOperationException();
        }
    }

}
