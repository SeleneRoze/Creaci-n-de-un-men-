package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.SubMenu;
import com.example.services.SubMenuService;

@RestController
@RequestMapping("/api/submenu")
public class SubMenuController {
    @Autowired
    private SubMenuService subMenuService;

    @PostMapping("/crear/{menuId}")
    public ResponseEntity<SubMenu> crearSubMenu(@PathVariable Long menuId, @RequestBody SubMenu subMenu) {
        SubMenu nuevoSubMenu = subMenuService.crearSubMenu(menuId, subMenu);
        return ResponseEntity.ok(nuevoSubMenu);
    }

    @GetMapping("/listar/{menuId}")
    public ResponseEntity<List<SubMenu>> listarSubMenus(@PathVariable Long menuId) {
        List<SubMenu> subMenus = subMenuService.listarSubMenus(menuId);
        return ResponseEntity.ok(subMenus);
    }
    
    @PostMapping
  	public SubMenu createBook(@RequestBody SubMenu SubMenu) {
  		return SubMenuService.savesubmenu(SubMenu);
  	}
  	
      @DeleteMapping("{id}")
  	public ResponseEntity<Void> deleteMenu(@PathVariable("id") Long id) {
  	    return SubMenuService.findSubMenuById(id)
  	            .map(submenu -> {
  	                menuService.deletemenuById(id);
  	                return ResponseEntity.ok().<Void>build();
  	            })
  	            .orElse(ResponseEntity.notFound().build());
  	}
      

}
