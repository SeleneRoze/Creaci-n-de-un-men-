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

import com.example.services.MenuService;

@RestController
@RequestMapping("/api/menu")

public class MenuP {
	@Autowired
    private MenuService menuService;
	

	@PostMapping("/crear")
	public ResponseEntity<MenuP> crearMenu(@RequestBody MenuP menup) {
	    MenuP nuevoMenu = menuService.crearMenu(menup);
	    return ResponseEntity.ok(nuevoMenu);
	}

	@GetMapping("/listar")
	public ResponseEntity<List<MenuP>> listarMenus() {
	    List<MenuP> menus = menuService.listarMenus();
	    return ResponseEntity.ok(menus);
	}

    
	@PostMapping
	public MenuP createMenu(@RequestBody MenuP menup) {
	    return menuService.savemenup(menup);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMenu(@PathVariable("id") Long id) {
	    return menuService.findMenuById(id)
	            .map(menu -> {
	                menuService.deleteMenuById(id);
	                return ResponseEntity.ok().<Void>build();
	            })
	            .orElse(ResponseEntity.notFound().build());
	}

}

