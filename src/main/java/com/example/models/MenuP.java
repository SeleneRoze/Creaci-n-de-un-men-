package com.example.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class MenuP {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String nombre;

	    @OneToMany(mappedBy = "menuPadre", cascade = CascadeType.ALL)
	    private List<SubMenu> subMenus = new ArrayList<>();

		public MenuP() {
			super();
		}

		public MenuP(Long id, String nombre, List<SubMenu> subMenus) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.subMenus = subMenus;
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

		public List<SubMenu> getSubMenus() {
			return subMenus;
		}

		public void setSubMenus(List<SubMenu> subMenus) {
			this.subMenus = subMenus;
		}

		@Override
		public String toString() {
			return "MenuP [id=" + id + ", nombre=" + nombre + ", getId()=" + getId() + ", getNombre()=" + getNombre()
					+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
					+ "]";
		}

}
