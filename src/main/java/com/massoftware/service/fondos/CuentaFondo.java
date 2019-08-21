package com.massoftware.service.fondos;

import com.massoftware.model.EntityId;
import com.massoftware.service.contabilidad.CuentaContable;
import com.massoftware.service.fondos.CuentaFondoGrupo;
import com.massoftware.service.fondos.CuentaFondoTipo;
import com.massoftware.service.monedas.Moneda;
import com.massoftware.service.fondos.Caja;
import com.massoftware.service.fondos.CuentaFondoTipoBanco;
import com.massoftware.service.fondos.banco.Banco;
import com.massoftware.service.fondos.CuentaFondoBancoCopia;
import com.massoftware.service.seguridad.SeguridadPuerta;
import com.massoftware.service.seguridad.SeguridadPuerta;
import com.massoftware.service.seguridad.SeguridadPuerta;

public class CuentaFondo extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;

	// Nº cuenta
	private Integer numero;

	// Nombre
	private String nombre;

	// Cuenta contable
	private CuentaContable cuentaContable;

	// Grupo
	private CuentaFondoGrupo cuentaFondoGrupo;

	// Tipo
	private CuentaFondoTipo cuentaFondoTipo;

	// Obsoleto
	private Boolean obsoleto;

	// No imprime caja
	private Boolean noImprimeCaja;

	// Ventas
	private Boolean ventas;

	// Fondos
	private Boolean fondos;

	// Compras
	private Boolean compras;

	// Moneda
	private Moneda moneda;

	// Caja
	private Caja caja;

	// Rechazados
	private Boolean rechazados;

	// Conciliación
	private Boolean conciliacion;

	// Tipo de banco
	private CuentaFondoTipoBanco cuentaFondoTipoBanco;

	// banco
	private Banco banco;

	// Cuenta bancaria
	private String cuentaBancaria;

	// CBU
	private String cbu;

	// Límite descubierto
	private java.math.BigDecimal limiteDescubierto;

	// Cuenta fondo caución
	private String cuentaFondoCaucion;

	// Cuenta fondo diferidos
	private String cuentaFondoDiferidos;

	// Formato
	private String formato;

	// Tipo de copias
	private CuentaFondoBancoCopia cuentaFondoBancoCopia;

	// Límite operación individual
	private java.math.BigDecimal limiteOperacionIndividual;

	// Puerta p/ uso
	private SeguridadPuerta seguridadPuertaUso;

	// Puerta p/ consulta
	private SeguridadPuerta seguridadPuertaConsulta;

	// Puerta p/ superar límite
	private SeguridadPuerta seguridadPuertaLimite;

	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}

	// GET Nº cuenta
	public Integer getNumero() {
		return this.numero;
	}

	// SET Nº cuenta
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

	// GET Cuenta contable
	public CuentaContable getCuentaContable() {
		return this.cuentaContable;
	}

	// SET Cuenta contable
	public void setCuentaContable(CuentaContable cuentaContable ){
		this.cuentaContable = cuentaContable;
	}

	// GET Grupo
	public CuentaFondoGrupo getCuentaFondoGrupo() {
		return this.cuentaFondoGrupo;
	}

	// SET Grupo
	public void setCuentaFondoGrupo(CuentaFondoGrupo cuentaFondoGrupo ){
		this.cuentaFondoGrupo = cuentaFondoGrupo;
	}

	// GET Tipo
	public CuentaFondoTipo getCuentaFondoTipo() {
		return this.cuentaFondoTipo;
	}

	// SET Tipo
	public void setCuentaFondoTipo(CuentaFondoTipo cuentaFondoTipo ){
		this.cuentaFondoTipo = cuentaFondoTipo;
	}

	// GET Obsoleto
	public Boolean getObsoleto() {
		return this.obsoleto;
	}

	// SET Obsoleto
	public void setObsoleto(Boolean obsoleto ){
		this.obsoleto = (obsoleto == null) ? false : obsoleto;
	}

	// GET No imprime caja
	public Boolean getNoImprimeCaja() {
		return this.noImprimeCaja;
	}

	// SET No imprime caja
	public void setNoImprimeCaja(Boolean noImprimeCaja ){
		this.noImprimeCaja = (noImprimeCaja == null) ? false : noImprimeCaja;
	}

	// GET Ventas
	public Boolean getVentas() {
		return this.ventas;
	}

	// SET Ventas
	public void setVentas(Boolean ventas ){
		this.ventas = (ventas == null) ? false : ventas;
	}

	// GET Fondos
	public Boolean getFondos() {
		return this.fondos;
	}

	// SET Fondos
	public void setFondos(Boolean fondos ){
		this.fondos = (fondos == null) ? false : fondos;
	}

	// GET Compras
	public Boolean getCompras() {
		return this.compras;
	}

	// SET Compras
	public void setCompras(Boolean compras ){
		this.compras = (compras == null) ? false : compras;
	}

	// GET Moneda
	public Moneda getMoneda() {
		return this.moneda;
	}

	// SET Moneda
	public void setMoneda(Moneda moneda ){
		this.moneda = moneda;
	}

	// GET Caja
	public Caja getCaja() {
		return this.caja;
	}

	// SET Caja
	public void setCaja(Caja caja ){
		this.caja = caja;
	}

	// GET Rechazados
	public Boolean getRechazados() {
		return this.rechazados;
	}

	// SET Rechazados
	public void setRechazados(Boolean rechazados ){
		this.rechazados = (rechazados == null) ? false : rechazados;
	}

	// GET Conciliación
	public Boolean getConciliacion() {
		return this.conciliacion;
	}

	// SET Conciliación
	public void setConciliacion(Boolean conciliacion ){
		this.conciliacion = (conciliacion == null) ? false : conciliacion;
	}

	// GET Tipo de banco
	public CuentaFondoTipoBanco getCuentaFondoTipoBanco() {
		return this.cuentaFondoTipoBanco;
	}

	// SET Tipo de banco
	public void setCuentaFondoTipoBanco(CuentaFondoTipoBanco cuentaFondoTipoBanco ){
		this.cuentaFondoTipoBanco = cuentaFondoTipoBanco;
	}

	// GET banco
	public Banco getBanco() {
		return this.banco;
	}

	// SET banco
	public void setBanco(Banco banco ){
		this.banco = banco;
	}

	// GET Cuenta bancaria
	public String getCuentaBancaria() {
		return this.cuentaBancaria;
	}

	// SET Cuenta bancaria
	public void setCuentaBancaria(String cuentaBancaria ){
		this.cuentaBancaria = (cuentaBancaria == null || cuentaBancaria.trim().length() == 0) ? null : cuentaBancaria.trim();
	}

	// GET CBU
	public String getCbu() {
		return this.cbu;
	}

	// SET CBU
	public void setCbu(String cbu ){
		this.cbu = (cbu == null || cbu.trim().length() == 0) ? null : cbu.trim();
	}

	// GET Límite descubierto
	public java.math.BigDecimal getLimiteDescubierto() {
		return this.limiteDescubierto;
	}

	// SET Límite descubierto
	public void setLimiteDescubierto(java.math.BigDecimal limiteDescubierto ){
		this.limiteDescubierto = limiteDescubierto;
	}

	// GET Cuenta fondo caución
	public String getCuentaFondoCaucion() {
		return this.cuentaFondoCaucion;
	}

	// SET Cuenta fondo caución
	public void setCuentaFondoCaucion(String cuentaFondoCaucion ){
		this.cuentaFondoCaucion = (cuentaFondoCaucion == null || cuentaFondoCaucion.trim().length() == 0) ? null : cuentaFondoCaucion.trim();
	}

	// GET Cuenta fondo diferidos
	public String getCuentaFondoDiferidos() {
		return this.cuentaFondoDiferidos;
	}

	// SET Cuenta fondo diferidos
	public void setCuentaFondoDiferidos(String cuentaFondoDiferidos ){
		this.cuentaFondoDiferidos = (cuentaFondoDiferidos == null || cuentaFondoDiferidos.trim().length() == 0) ? null : cuentaFondoDiferidos.trim();
	}

	// GET Formato
	public String getFormato() {
		return this.formato;
	}

	// SET Formato
	public void setFormato(String formato ){
		this.formato = (formato == null || formato.trim().length() == 0) ? null : formato.trim();
	}

	// GET Tipo de copias
	public CuentaFondoBancoCopia getCuentaFondoBancoCopia() {
		return this.cuentaFondoBancoCopia;
	}

	// SET Tipo de copias
	public void setCuentaFondoBancoCopia(CuentaFondoBancoCopia cuentaFondoBancoCopia ){
		this.cuentaFondoBancoCopia = cuentaFondoBancoCopia;
	}

	// GET Límite operación individual
	public java.math.BigDecimal getLimiteOperacionIndividual() {
		return this.limiteOperacionIndividual;
	}

	// SET Límite operación individual
	public void setLimiteOperacionIndividual(java.math.BigDecimal limiteOperacionIndividual ){
		this.limiteOperacionIndividual = limiteOperacionIndividual;
	}

	// GET Puerta p/ uso
	public SeguridadPuerta getSeguridadPuertaUso() {
		return this.seguridadPuertaUso;
	}

	// SET Puerta p/ uso
	public void setSeguridadPuertaUso(SeguridadPuerta seguridadPuertaUso ){
		this.seguridadPuertaUso = seguridadPuertaUso;
	}

	// GET Puerta p/ consulta
	public SeguridadPuerta getSeguridadPuertaConsulta() {
		return this.seguridadPuertaConsulta;
	}

	// SET Puerta p/ consulta
	public void setSeguridadPuertaConsulta(SeguridadPuerta seguridadPuertaConsulta ){
		this.seguridadPuertaConsulta = seguridadPuertaConsulta;
	}

	// GET Puerta p/ superar límite
	public SeguridadPuerta getSeguridadPuertaLimite() {
		return this.seguridadPuertaLimite;
	}

	// SET Puerta p/ superar límite
	public void setSeguridadPuertaLimite(SeguridadPuerta seguridadPuertaLimite ){
		this.seguridadPuertaLimite = seguridadPuertaLimite;
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

} // END CLASS ----------------------------------------------------------------------------------------------------------