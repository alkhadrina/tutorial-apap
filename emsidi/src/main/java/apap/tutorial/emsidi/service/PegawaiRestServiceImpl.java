package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public PegawaiModel predictAge(Long noPegawai) {
        LocalTime now = LocalTime.now();
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        CabangModel cabang = pegawai.getCabang();

        if ((now.isBefore(cabang.getWaktuBuka()) || now.isAfter(cabang.getWaktuTutup()))) {
            String namaPegawai = pegawai.getNamaPegawai();
            String response = this.webClient.get().uri("/?name=" + namaPegawai).retrieve().bodyToMono(String.class)
                    .block();

            response = response.substring(1, response.length() - 1); // remove curly brackets
            String[] keyValuePairs = response.split(","); // split the string to create key-value pairs
            Map<String, String> map = new HashMap<>();

            // iterate over the pairs
            for (String pair : keyValuePairs) {
                // split the pairs to get key and value
                String[] entry = pair.split(":");

                // add them to the hashmap and trim whitespaces
                map.put(entry[0].trim().replace("\"", ""), entry[1].trim().replace("\"", ""));
            }

            pegawai.setUmur(map.get("age"));
            return pegawaiDb.save(pegawai);

        } else {
            throw new UnsupportedOperationException();
        }
    }

}
