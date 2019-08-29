package com.massoftware.service.contabilidad;

import com.massoftware.service.*;

public class CuentasContablesFiltro extends GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------


	// Ejercicio
	private EjerciciosContables ejercicioContable;

	// Estado
	private CentrosCostosContables centroCostoContable;

	// Punto de equilibrio
	private PuntosEquilibrios puntoEquilibrio;

	// Cuenta contable
	private String codigo;

	// Cuenta agrupadora
	private String cuentaAgrupadora;

	// Nombre
	private String nombre;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET Ejercicio
	public EjerciciosContables getEjercicioContable() {
		return this.ejercicioContable;
	}

	// SET Ejercicio
	public void setEjercicioContable(EjerciciosContables ejercicioContable){
		this.ejercicioContable = ejercicioContable;
	}

	// GET Estado
	public CentrosCostosContables getCentroCostoContable() {
		return this.centroCostoContable;
	}

	// SET Estado
	public void setCentroCostoContable(CentrosCostosContables centroCostoContable){
		this.centroCostoContable = centroCostoContable;
	}

	// GET Punto de equilibrio
	public PuntosEquilibrios getPuntoEquilibrio() {
		return this.puntoEquilibrio;
	}

	// SET Punto de equilibrio
	public void setPuntoEquilibrio(PuntosEquilibrios puntoEquilibrio){
		this.puntoEquilibrio = puntoEquilibrio;
	}

	// GET Cuenta contable
	public String getCodigo() {
		return this.codigo;
	}

	// SET Cuenta contable
	public void setCodigo(String codigo){
		this.codigo = (codigo == null || codigo.trim().length() == 0) ? null : codigo.trim();
	}

	// GET Cuenta agrupadora
	public String getCuentaAgrupadora() {
		return this.cuentaAgrupadora;
	}

	// SET Cuenta agrupadora
	public void setCuentaAgrupadora(String cuentaAgrupadora){
		this.cuentaAgrupadora = (cuentaAgrupadora == null || cuentaAgrupadora.trim().length() == 0) ? null : cuentaAgrupadora.trim();
	}

	// GET Nombre
	public String getNombre() {
		return this.nombre;
	}

	// SET Nombre
	public void setNombre(String nombre){
		this.nombre = (nombre == null || nombre.trim().length() == 0) ? null : nombre.trim();
	}
		
	public boolean equals(Object obj) {
		
		if (super.equals(obj) == false) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		CuentasContablesFiltro other = (CuentasContablesFiltro) obj;
		
		
		// -------------------------------------------------------------------
		
		if (other.getEjercicioContable() == null && this.getEjercicioContable() != null) {
			return false;
		}
		
		if (other.getEjercicioContable() != null && this.getEjercicioContable() == null) {
			return false;
		}
		
		if (other.getEjercicioContable() != null && this.getEjercicioContable() != null) {
		
			if (other.getEjercicioContable().equals(this.getEjercicioContable()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getCentroCostoContable() == null && this.getCentroCostoContable() != null) {
			return false;
		}
		
		if (other.getCentroCostoContable() != null && this.getCentroCostoContable() == null) {
			return false;
		}
		
		if (other.getCentroCostoContable() != null && this.getCentroCostoContable() != null) {
		
			if (other.getCentroCostoContable().equals(this.getCentroCostoContable()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getPuntoEquilibrio() == null && this.getPuntoEquilibrio() != null) {
			return false;
		}
		
		if (other.getPuntoEquilibrio() != null && this.getPuntoEquilibrio() == null) {
			return false;
		}
		
		if (other.getPuntoEquilibrio() != null && this.getPuntoEquilibrio() != null) {
		
			if (other.getPuntoEquilibrio().equals(this.getPuntoEquilibrio()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getCodigo() == null && this.getCodigo() != null) {
			return false;
		}
		
		if (other.getCodigo() != null && this.getCodigo() == null) {
			return false;
		}
		
		if (other.getCodigo() != null && this.getCodigo() != null) {
		
			if (other.getCodigo().equals(this.getCodigo()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getCuentaAgrupadora() == null && this.getCuentaAgrupadora() != null) {
			return false;
		}
		
		if (other.getCuentaAgrupadora() != null && this.getCuentaAgrupadora() == null) {
			return false;
		}
		
		if (other.getCuentaAgrupadora() != null && this.getCuentaAgrupadora() != null) {
		
			if (other.getCuentaAgrupadora().equals(this.getCuentaAgrupadora()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		if (other.getNombre() == null && this.getNombre() != null) {
			return false;
		}
		
		if (other.getNombre() != null && this.getNombre() == null) {
			return false;
		}
		
		if (other.getNombre() != null && this.getNombre() != null) {
		
			if (other.getNombre().equals(this.getNombre()) == false) {
				return false;
			}
		
		}
		
		// -------------------------------------------------------------------
		
		return true;
		
		// -------------------------------------------------------------------
	}
		
	public CuentasContablesFiltro clone() {
		
		CuentasContablesFiltro other = new CuentasContablesFiltro();
		
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		other.setUnlimited(this.getUnlimited());
		
		
		// -------------------------------------------------------------------
		
		if (this.getEjercicioContable() != null) {
			other.setEjercicioContable(this.getEjercicioContable().clone());
		}
		
		// -------------------------------------------------------------------
		
		if (this.getCentroCostoContable() != null) {
			other.setCentroCostoContable(this.getCentroCostoContable().clone());
		}
		
		// -------------------------------------------------------------------
		
		if (this.getPuntoEquilibrio() != null) {
			other.setPuntoEquilibrio(this.getPuntoEquilibrio().clone());
		}
		other.setCodigo(this.getCodigo());
		other.setCuentaAgrupadora(this.getCuentaAgrupadora());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------