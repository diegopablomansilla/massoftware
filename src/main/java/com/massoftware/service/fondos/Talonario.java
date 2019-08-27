package com.massoftware.service.fondos;

import com.massoftware.service.EntityId;
import com.massoftware.service.fondos.TalonarioLetra;
import com.massoftware.service.fondos.TalonarioControladorFizcal;

public class Talonario extends EntityId implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº talonario
	private Integer numero;

	// Nombre
	private String nombre;

	// Letra
	private TalonarioLetra talonarioLetra;

	// Punto de venta
	private Integer puntoVenta;

	// Autonumeración
	private Boolean autonumeracion;

	// Numeración pre-impresa
	private Boolean numeracionPreImpresa;

	// Asociado al RG 100/98
	private Boolean asociadoRG10098;

	// Asociado a controlador fizcal
	private TalonarioControladorFizcal talonarioControladorFizcal;

	// Primer nº
	private Integer primerNumero;

	// Próximo nº
	private Integer proximoNumero;

	// Último nº
	private Integer ultimoNumero;

	// Cant. min. cbtes.
	private Integer cantidadMinimaComprobantes;

	// Fecha
	private java.time.LocalDate fecha;

	// Nº C.A.I
	private Long numeroCAI;

	// Vencimiento C.A.I
	private java.time.LocalDate vencimiento;

	// Días aviso vto.
	private Integer diasAvisoVencimiento;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº talonario
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº talonario
	public void setNumero(Integer numero ){
		this.numero = numero;
	}

	// GET Nombre
	public String getNombre() {
		return this.nombre;
	}

	// SET Nombre
	public void setNombre(String nombre ){
		this.nombre = (nombre == null || nombre.trim().length() == 0) ? null : nombre.trim();
	}

	// GET Letra
	public TalonarioLetra getTalonarioLetra() {
		return this.talonarioLetra;
	}

	// SET Letra
	public void setTalonarioLetra(TalonarioLetra talonarioLetra ){
		this.talonarioLetra = talonarioLetra;
	}

	// GET Punto de venta
	public Integer getPuntoVenta() {
		return this.puntoVenta;
	}

	// SET Punto de venta
	public void setPuntoVenta(Integer puntoVenta ){
		this.puntoVenta = puntoVenta;
	}

	// GET Autonumeración
	public Boolean getAutonumeracion() {
		return this.autonumeracion;
	}

	// SET Autonumeración
	public void setAutonumeracion(Boolean autonumeracion ){
		this.autonumeracion = (autonumeracion == null) ? false : autonumeracion;
	}

	// GET Numeración pre-impresa
	public Boolean getNumeracionPreImpresa() {
		return this.numeracionPreImpresa;
	}

	// SET Numeración pre-impresa
	public void setNumeracionPreImpresa(Boolean numeracionPreImpresa ){
		this.numeracionPreImpresa = (numeracionPreImpresa == null) ? false : numeracionPreImpresa;
	}

	// GET Asociado al RG 100/98
	public Boolean getAsociadoRG10098() {
		return this.asociadoRG10098;
	}

	// SET Asociado al RG 100/98
	public void setAsociadoRG10098(Boolean asociadoRG10098 ){
		this.asociadoRG10098 = (asociadoRG10098 == null) ? false : asociadoRG10098;
	}

	// GET Asociado a controlador fizcal
	public TalonarioControladorFizcal getTalonarioControladorFizcal() {
		return this.talonarioControladorFizcal;
	}

	// SET Asociado a controlador fizcal
	public void setTalonarioControladorFizcal(TalonarioControladorFizcal talonarioControladorFizcal ){
		this.talonarioControladorFizcal = talonarioControladorFizcal;
	}

	// GET Primer nº
	public Integer getPrimerNumero() {
		return this.primerNumero;
	}

	// SET Primer nº
	public void setPrimerNumero(Integer primerNumero ){
		this.primerNumero = primerNumero;
	}

	// GET Próximo nº
	public Integer getProximoNumero() {
		return this.proximoNumero;
	}

	// SET Próximo nº
	public void setProximoNumero(Integer proximoNumero ){
		this.proximoNumero = proximoNumero;
	}

	// GET Último nº
	public Integer getUltimoNumero() {
		return this.ultimoNumero;
	}

	// SET Último nº
	public void setUltimoNumero(Integer ultimoNumero ){
		this.ultimoNumero = ultimoNumero;
	}

	// GET Cant. min. cbtes.
	public Integer getCantidadMinimaComprobantes() {
		return this.cantidadMinimaComprobantes;
	}

	// SET Cant. min. cbtes.
	public void setCantidadMinimaComprobantes(Integer cantidadMinimaComprobantes ){
		this.cantidadMinimaComprobantes = cantidadMinimaComprobantes;
	}

	// GET Fecha
	public java.time.LocalDate getFecha() {
		return this.fecha;
	}

	// SET Fecha
	public void setFecha(java.time.LocalDate fecha ){
		this.fecha = fecha;
	}

	// GET Nº C.A.I
	public Long getNumeroCAI() {
		return this.numeroCAI;
	}

	// SET Nº C.A.I
	public void setNumeroCAI(Long numeroCAI ){
		this.numeroCAI = numeroCAI;
	}

	// GET Vencimiento C.A.I
	public java.time.LocalDate getVencimiento() {
		return this.vencimiento;
	}

	// SET Vencimiento C.A.I
	public void setVencimiento(java.time.LocalDate vencimiento ){
		this.vencimiento = vencimiento;
	}

	// GET Días aviso vto.
	public Integer getDiasAvisoVencimiento() {
		return this.diasAvisoVencimiento;
	}

	// SET Días aviso vto.
	public void setDiasAvisoVencimiento(Integer diasAvisoVencimiento ){
		this.diasAvisoVencimiento = diasAvisoVencimiento;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNumero() != null && this.getNombre() != null){
			return this.getNumero() + " - " +  this.getNombre();
		} else if(this.getNumero() != null && this.getNombre() == null){
			return this.getNumero().toString();
		} else if(this.getNumero() == null && this.getNombre() != null){
			return this.getNombre();
		} else {
			return super.toString();
		}
	}
		
	public Talonario clone() {
		
		Talonario other = (Talonario) super.clone();
		
		other.setId(this.getId());
		other.setNumero(this.getNumero());
		other.setNombre(this.getNombre());
		
		// -------------------------------------------------------------------
		
		if (this.getTalonarioLetra() != null) {
			other.setTalonarioLetra(this.getTalonarioLetra().clone());
		}
		other.setPuntoVenta(this.getPuntoVenta());
		other.setAutonumeracion(this.getAutonumeracion());
		other.setNumeracionPreImpresa(this.getNumeracionPreImpresa());
		other.setAsociadoRG10098(this.getAsociadoRG10098());
		
		// -------------------------------------------------------------------
		
		if (this.getTalonarioControladorFizcal() != null) {
			other.setTalonarioControladorFizcal(this.getTalonarioControladorFizcal().clone());
		}
		other.setPrimerNumero(this.getPrimerNumero());
		other.setProximoNumero(this.getProximoNumero());
		other.setUltimoNumero(this.getUltimoNumero());
		other.setCantidadMinimaComprobantes(this.getCantidadMinimaComprobantes());
		other.setFecha(this.getFecha());
		other.setNumeroCAI(this.getNumeroCAI());
		other.setVencimiento(this.getVencimiento());
		other.setDiasAvisoVencimiento(this.getDiasAvisoVencimiento());
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS ----------------------------------------------------------------------------------------------------------