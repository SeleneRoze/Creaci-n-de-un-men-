package com.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SubMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private MenuP menuPadre;

	public SubMenu() {
		super();
	}

	public SubMenu(Long id, String nombre, String descripcion, MenuP menuPadre) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.menuPadre = menuPadre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public MenuP getMenuPadre() {
		return menuPadre;
	}

	public void setMenuPadre(MenuP menuPadre) {
		this.menuPadre = menuPadre;
	}

	@Override
	public String toString() {
		return "SubMenu [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", getId()=" + getId()
				+ ", getNombre()=" + getNombre() + ", getDescripcion()=" + getDescripcion() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
    
    