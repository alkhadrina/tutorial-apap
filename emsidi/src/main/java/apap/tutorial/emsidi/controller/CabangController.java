package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.MenuModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class CabangController {
    
    @Qualifier("cabangServiceImpl")
    @Autowired
    private CabangService cabangService;

    @Qualifier("menuServiceImpl")
    @Autowired
    MenuService menuService;

    @GetMapping("/cabang/add")
    public String addCabangForm(
        @RequestParam(value = "jmlMenu",required = false, defaultValue = "1")int jmlMenu,
        Model model){
        model.addAttribute("cabang", new CabangModel());
        if(jmlMenu < 1){
            jmlMenu = 1;
        }
        model.addAttribute("jmlMenu", jmlMenu);
        model.addAttribute("listMenu", menuService.getListMenu());
        return "form-add-cabang";
    }

    @PostMapping("/cabang/add")
    public String addCabangSubmit(
        @ModelAttribute CabangModel cabang,
        Model model
    ){
        cabangService.addCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "add-cabang";
    }

    @PostMapping(value = "/cabang/add", params = {"add"})
    public String addRow(
        @ModelAttribute CabangModel cabang,
        Model model
    ){
        int jmlMenu = cabang.getListMenu().size() + 1;
        String re = "redirect:/cabang/add?";
        re += "jmlMenu=" +jmlMenu;
        return re; 
    }

    @PostMapping(value = "/cabang/add", params = {"delete"})
    public String deleteRow(
        @ModelAttribute CabangModel cabang,
        Model model
    ){
        int jmlMenu = cabang.getListMenu().size() - 1;
        if(jmlMenu < 0){
            jmlMenu = 0;
        }
        String re = "redirect:/cabang/add?";
        re += "jmlMenu=" +jmlMenu;
        return re; 
    }

    @GetMapping("/cabang/viewall")
    public String listCabang(Model model){
        List<CabangModel> listCabang = cabangService.getCabangList();
        model.addAttribute("listCabang", listCabang);
        return "viewall-cabang";
    }

    @GetMapping("/cabang/view")
    public String viewDetailCabang(
        @RequestParam(value = "noCabang")Long noCabang,
        Model model
    ){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        List<PegawaiModel> listPegawai = cabang.getListPegawai();
        List<MenuModel> listMenu = cabang.getListMenu();
        model.addAttribute("cabang", cabang);
        model.addAttribute("listPegawai", listPegawai);
        model.addAttribute("listMenu", listMenu);

        return "view-cabang";
    }

    @GetMapping("/cabang/viewall-detail")
    public String listCabangOrdered(Model model){
        List<CabangModel> listCabang = cabangService.getCabangListOrdered();
        model.addAttribute("listCabang", listCabang);
        return "viewall-cabang-detail";
    }

    @GetMapping("/cabang/update/{noCabang}")
    public String updateCabangForm(
        @PathVariable Long noCabang,
        Model model
    ){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        model.addAttribute("cabang", cabang);
        return "form-update-cabang";
    }

    @PostMapping("/cabang/update")
    public String updateCabangSubmit(
        @ModelAttribute CabangModel cabang,
        Model model
    ){
        cabangService.updateCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "update-cabang";
    }

    @GetMapping("/cabang/delete/{noCabang}")
    public String deleteCabang(
        @PathVariable Long noCabang, 
        Model model
    ){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        
        model.addAttribute("noCabang", cabang.getNoCabang());
        cabang = cabangService.deleteCabang(cabang);

        if(cabang != null){
            model.addAttribute("noCabang", cabang);
            return "delete-cabang";
        }
        model.addAttribute("noCabang", cabang);
        return "delete-cabang";
    }
}
