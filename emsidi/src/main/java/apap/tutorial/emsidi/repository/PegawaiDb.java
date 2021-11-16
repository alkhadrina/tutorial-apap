package apap.tutorial.emsidi.repository;

import apap.tutorial.emsidi.model.PegawaiModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import antlr.collections.List;

@Repository
public interface PegawaiDb extends JpaRepository<PegawaiModel, Long> {
    Optional<PegawaiModel> findByNoPegawai(Long noPegawai);

    List<PegawaiModel> findAllByJenisKelamin(int jenisKelamin);

    List<PegawaiModel> findAll();
}
