package com.massoftware.service.contabilidad;

import com.massoftware.service.EntityId;

public class CuentasContables extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Ejercicio
	private Integer nombreEjercicioContable;

	// Cuenta contable
	private String codigo;

	// Nombre
	private String nombre;

	// Ctro. Costo
	private String nombreCentroCostoContable;

	// Cuenta agrupadora
	private String cuentaAgrupadora;

	// Porcentaje
	private Double porcentaje;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Ejercicio
	public Integer getNombreEjercicioContable() {
		return this.nombreEjercicioContable;
	}

	// SET Ejercicio
	public void setNombreEjercicioContable(Integer nombreEjercicioContable ){
		this.nombreEjercicioContable = nombreEjercicioContable;
	}

	// GET Cuenta contable
	public String getCodigo() {
		return this.codigo;
	}

	// SET Cuenta contable
	public void setCodigo(String codigo ){
		this.codigo = (codigo == null || codigo.trim().length() == 0) ? null : codigo.trim();
	}

	// GET Nombre
	public String getNombre() {
		return this.nombre;
	}

	// SET Nombre
	public void setNombre(String nombre ){
		this.nombre = (nombre == null || nombre.trim().length() == 0) ? null : nombre.trim();
	}

	// GET Ctro. Costo
	public String getNombreCentroCostoContable() {
		return this.nombreCentroCostoContable;
	}

	// SET Ctro. Costo
	public void setNombreCentroCostoContable(String nombreCentroCostoContable ){
		this.nombreCentroCostoContable = (nombreCentroCostoContable == null || nombreCentroCostoContable.trim().length() == 0) ? null : nombreCentroCostoContable.trim();
	}

	// GET Cuenta agrupadora
	public String getCuentaAgrupadora() {
		return this.cuentaAgrupadora;
	}

	// SET Cuenta agrupadora
	public void setCuentaAgrupadora(String cuentaAgrupadora ){
		this.cuentaAgrupadora = (cuentaAgrupadora == null || cuentaAgrupadora.trim().length() == 0) ? null : cuentaAgrupadora.trim();
	}

	// GET Porcentaje
	public Double getPorcentaje() {
		return this.porcentaje;
	}

	// SET Porcentaje
	public void setPorcentaje(Double porcentaje ){
		this.porcentaje = porcentaje;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNombreEjercicioContable() != null && this.getCodigo() != null){
			return this.getNombreEjercicioContable() + " - " +  this.getCodigo();
		} else if(this.getNombreEjercicioContable() != null && this.getCodigo() == null){
			return this.getNombreEjercicioContable().toString();
		} else if(this.getNombreEjercicioContable() == null && this.getCodigo() != null){
			return this.getCodigo();
		} else {
			return super.toString();
		}
	}
		
	public CuentasContables clone() {
		
		CuentasContables other = new CuentasContables();
		
		other.setId(this.getId());
		other.setNombreEjercicioContable(this.getNombreEjercicioContable());
		other.setCodigo(this.getCodigo());
		other.setNombre(this.getNombre());
		other.setNombreCentroCostoContable(this.getNombreCentroCostoContable());
		other.setCuentaAgrupadora(this.getCuentaAgrupadora());
		other.setPorcentaje(this.getPorcentaje());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------