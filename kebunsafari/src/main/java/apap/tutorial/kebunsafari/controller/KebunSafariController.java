package apap.tutorial.kebunsafari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import apap.tutorial.kebunsafari.service.KebunSafariService;

@Controller
public class KebunSafariController {
    private String getKebunSafariPage(String idKebunSafari, Model model){

        if(kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari) == null){
            model.addAttribute("msg", "ID "+idKebunSafari+" tidak ditemukan");
        }
        else if(idKebunSafari == "" ){
            model.addAttribute("msg", "ID "+idKebunSafari+" tidak ditemukan");
            
        }
        else{
            final KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

            model.addAttribute("kebunSafari", kebunSafari);
        }

        return "detail-kebun-safari.html";
    }

    @Autowired
    private KebunSafariService kebunSafariService;

    @RequestMapping("/kebun-safari/add")
    public String addKebunSafari(
        @RequestParam (value = "id", required = true) String idKebunSafari,
        @RequestParam (value = "nama", required = true) String namaKebunSafari,
        @RequestParam (value = "alamat", required = true) String alamat,
        @RequestParam (value = "noTelepon", required = true) String noTelepon,
        Model model
    ){
        KebunSafariModel kebunSafari = new KebunSafariModel(idKebunSafari, namaKebunSafari, alamat, noTelepon);

        kebunSafariService.addKebunSafari(kebunSafari);

        model.addAttribute("kebunSafari", kebunSafari);

        return "add-kebun-safari";
    }

    @RequestMapping("/")
    public String listKebunSafari(Model model){
        List<KebunSafariModel> listKebunSafari = kebunSafariService.getKebunSafariList();

        model.addAttribute("listKebunSafari", listKebunSafari);

        return "get-all-kebun-safari";
    }

    @RequestMapping("/kebun-safari")
    public String getKebunSafariById(@RequestParam(value = "id", required = true) String idKebunSafari, Model model){
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

        model.addAttribute("kebunSafari", kebunSafari);

        return "detail-kebun-safari";
    }

    @GetMapping(value = "/kebun-safari/view/{idKebunSafari}")
    public String kebunSafariWithPathVariable(
        @PathVariable(value = "idKebunSafari") String idKebunSafari, Model model){
              
        return getKebunSafariPage(idKebunSafari, model);
    }

    @GetMapping(value = "/kebun-safari/view")
    public String kebunSafariNoInputWithPathVariable(Model model){
        model.addAttribute("msg", "Masukan ID");     
        return "detail-kebun-safari";
    }

    @GetMapping(value = "/kebun-safari/update/{idKebunSafari}")
    public String kebunSafariUpdateWithPathVariable(
        @PathVariable(value = "idKebunSafari") String idKebunSafari, @RequestParam (value = "noTelepon", required = true) String noTelepon, Model model){
        
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);
        if(idKebunSafari.isEmpty() || kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari) == null){
            model.addAttribute("msg", "ID "+idKebunSafari+" tidak ditemukan");
            return "update-kebun-safari";
        }
        kebunSafari = kebunSafariService.updateKebunSafariByIdKebunSafari(idKebunSafari, noTelepon);
        model.addAttribute("kebunSafari", kebunSafari);
        
        return "update-kebun-safari";
    }

    @GetMapping(value = "/kebun-safari/update")
    public String kebunSafariUpdateNoInputWithPathVariable(Model model){
        
        model.addAttribute("msg", "Masukan ID");
        return "update-kebun-safari";
    }

    @GetMapping(value = "/kebun-safari/delete/{idKebunSafari}")
    public String kebunSafariDeleteWithPathVariable(
        @PathVariable(value = "idKebunSafari") String idKebunSafari, Model model){
        if(idKebunSafari.isEmpty() || kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari) == null){
            model.addAttribute("msg", "ID "+idKebunSafari+" tidak ditemukan");
            return "delete-kebun-safari";
        }
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);
        kebunSafariService.deleteKebunSafariByIdKebunSafari(idKebunSafari);
        model.addAttribute("kebunSafari", kebunSafari);
        return "delete-kebun-safari";
    }

    @GetMapping(value = "/kebun-safari/delete")
    public String kebunSafariDeleteNoInputWithPathVariable(Model model){
        model.addAttribute("msg", "Masukan ID");
        return "delete-kebun-safari";
    }

    @GetMapping(value = "/kebun-safari/deleteall")
    public String kebunSafariDeleteAllNoInputWithPathVariable(Model model){
        kebunSafariService.deleteAllSafari();
        model.addAttribute("msg", "Semua data dihapus");
        return "delete-kebun-safari";
    }


    
}
