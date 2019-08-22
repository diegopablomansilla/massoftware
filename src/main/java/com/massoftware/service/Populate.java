package com.massoftware.service;

import java.util.List;
import java.util.List;
import java.util.Random;
import com.massoftware.service.AppCX;

import com.massoftware.service.seguridad.Usuario;
import com.massoftware.service.seguridad.UsuariosFiltro;
import com.massoftware.service.seguridad.Usuarios;
import com.massoftware.service.seguridad.UsuarioService;
import com.massoftware.service.seguridad.SeguridadModulo;
import com.massoftware.service.seguridad.SeguridadModulosFiltro;
import com.massoftware.service.seguridad.SeguridadModulos;
import com.massoftware.service.seguridad.SeguridadModuloService;
import com.massoftware.service.seguridad.SeguridadPuerta;
import com.massoftware.service.seguridad.SeguridadPuertasFiltro;
import com.massoftware.service.seguridad.SeguridadPuertas;
import com.massoftware.service.seguridad.SeguridadPuertaService;
import com.massoftware.service.geo.Zona;
import com.massoftware.service.geo.ZonasFiltro;
import com.massoftware.service.geo.Zonas;
import com.massoftware.service.geo.ZonaService;
import com.massoftware.service.geo.Pais;
import com.massoftware.service.geo.PaisesFiltro;
import com.massoftware.service.geo.Paises;
import com.massoftware.service.geo.PaisService;
import com.massoftware.service.geo.Provincia;
import com.massoftware.service.geo.ProvinciasFiltro;
import com.massoftware.service.geo.Provincias;
import com.massoftware.service.geo.ProvinciaService;
import com.massoftware.service.geo.Ciudad;
import com.massoftware.service.geo.CiudadesFiltro;
import com.massoftware.service.geo.Ciudades;
import com.massoftware.service.geo.CiudadService;
import com.massoftware.service.geo.CodigoPostal;
import com.massoftware.service.geo.CodigosPostalesFiltro;
import com.massoftware.service.geo.CodigosPostales;
import com.massoftware.service.geo.CodigoPostalService;
import com.massoftware.service.logistica.Transporte;
import com.massoftware.service.logistica.TransportesFiltro;
import com.massoftware.service.logistica.Transportes;
import com.massoftware.service.logistica.TransporteService;
import com.massoftware.service.logistica.Carga;
import com.massoftware.service.logistica.CargasFiltro;
import com.massoftware.service.logistica.Cargas;
import com.massoftware.service.logistica.CargaService;
import com.massoftware.service.logistica.TransporteTarifa;
import com.massoftware.service.logistica.TransportesTarifasFiltro;
import com.massoftware.service.logistica.TransportesTarifas;
import com.massoftware.service.logistica.TransporteTarifaService;
import com.massoftware.service.afip.TipoDocumentoAFIP;
import com.massoftware.service.afip.TiposDocumentosAFIPFiltro;
import com.massoftware.service.afip.TiposDocumentosAFIP;
import com.massoftware.service.afip.TipoDocumentoAFIPService;
import com.massoftware.service.afip.MonedaAFIP;
import com.massoftware.service.afip.MonedasAFIPFiltro;
import com.massoftware.service.afip.MonedasAFIP;
import com.massoftware.service.afip.MonedaAFIPService;
import com.massoftware.service.contabilidad.ventas.NotaCreditoMotivo;
import com.massoftware.service.contabilidad.ventas.NotasCreditoMotivoFiltro;
import com.massoftware.service.contabilidad.ventas.NotasCreditoMotivo;
import com.massoftware.service.contabilidad.ventas.NotaCreditoMotivoService;
import com.massoftware.service.clientes.MotivoComentario;
import com.massoftware.service.clientes.MotivosComentarioFiltro;
import com.massoftware.service.clientes.MotivosComentario;
import com.massoftware.service.clientes.MotivoComentarioService;
import com.massoftware.service.clientes.TipoCliente;
import com.massoftware.service.clientes.TiposClientesFiltro;
import com.massoftware.service.clientes.TiposClientes;
import com.massoftware.service.clientes.TipoClienteService;
import com.massoftware.service.clientes.ClasificacionCliente;
import com.massoftware.service.clientes.ClasificacionesClientesFiltro;
import com.massoftware.service.clientes.ClasificacionesClientes;
import com.massoftware.service.clientes.ClasificacionClienteService;
import com.massoftware.service.clientes.MotivoBloqueoCliente;
import com.massoftware.service.clientes.MotivosBloqueosClientesFiltro;
import com.massoftware.service.clientes.MotivosBloqueosClientes;
import com.massoftware.service.clientes.MotivoBloqueoClienteService;
import com.massoftware.service.empresa.TipoSucursal;
import com.massoftware.service.empresa.TiposSucursalesFiltro;
import com.massoftware.service.empresa.TiposSucursales;
import com.massoftware.service.empresa.TipoSucursalService;
import com.massoftware.service.empresa.Sucursal;
import com.massoftware.service.empresa.SucursalesFiltro;
import com.massoftware.service.empresa.Sucursales;
import com.massoftware.service.empresa.SucursalService;
import com.massoftware.service.empresa.DepositoModulo;
import com.massoftware.service.empresa.DepositosModulosFiltro;
import com.massoftware.service.empresa.DepositosModulos;
import com.massoftware.service.empresa.DepositoModuloService;
import com.massoftware.service.empresa.Deposito;
import com.massoftware.service.empresa.DepositosFiltro;
import com.massoftware.service.empresa.Depositos;
import com.massoftware.service.empresa.DepositoService;
import com.massoftware.service.contabilidad.EjercicioContable;
import com.massoftware.service.contabilidad.EjerciciosContablesFiltro;
import com.massoftware.service.contabilidad.EjerciciosContables;
import com.massoftware.service.contabilidad.EjercicioContableService;
import com.massoftware.service.contabilidad.CentroCostoContable;
import com.massoftware.service.contabilidad.CentrosCostosContablesFiltro;
import com.massoftware.service.contabilidad.CentrosCostosContables;
import com.massoftware.service.contabilidad.CentroCostoContableService;
import com.massoftware.service.contabilidad.TipoPuntoEquilibrio;
import com.massoftware.service.contabilidad.TiposPuntosEquilibriosFiltro;
import com.massoftware.service.contabilidad.TiposPuntosEquilibrios;
import com.massoftware.service.contabilidad.TipoPuntoEquilibrioService;
import com.massoftware.service.contabilidad.PuntoEquilibrio;
import com.massoftware.service.contabilidad.PuntosEquilibriosFiltro;
import com.massoftware.service.contabilidad.PuntosEquilibrios;
import com.massoftware.service.contabilidad.PuntoEquilibrioService;
import com.massoftware.service.contabilidad.CostoVenta;
import com.massoftware.service.contabilidad.CostosVentasFiltro;
import com.massoftware.service.contabilidad.CostosVentas;
import com.massoftware.service.contabilidad.CostoVentaService;
import com.massoftware.service.contabilidad.CuentaContableEstado;
import com.massoftware.service.contabilidad.CuentasContablesEstadosFiltro;
import com.massoftware.service.contabilidad.CuentasContablesEstados;
import com.massoftware.service.contabilidad.CuentaContableEstadoService;
import com.massoftware.service.contabilidad.CuentaContable;
import com.massoftware.service.contabilidad.CuentasContablesFiltro;
import com.massoftware.service.contabilidad.CuentasContables;
import com.massoftware.service.contabilidad.CuentaContableService;
import com.massoftware.service.contabilidad.AsientoModelo;
import com.massoftware.service.contabilidad.AsientosModelosFiltro;
import com.massoftware.service.contabilidad.AsientosModelos;
import com.massoftware.service.contabilidad.AsientoModeloService;
import com.massoftware.service.contabilidad.AsientoModeloItem;
import com.massoftware.service.contabilidad.AsientosModelosItemsFiltro;
import com.massoftware.service.contabilidad.AsientosModelosItems;
import com.massoftware.service.contabilidad.AsientoModeloItemService;
import com.massoftware.service.contabilidad.MinutaContable;
import com.massoftware.service.contabilidad.MinutasContablesFiltro;
import com.massoftware.service.contabilidad.MinutasContables;
import com.massoftware.service.contabilidad.MinutaContableService;
import com.massoftware.service.contabilidad.AsientoContableModulo;
import com.massoftware.service.contabilidad.AsientosContablesModulosFiltro;
import com.massoftware.service.contabilidad.AsientosContablesModulos;
import com.massoftware.service.contabilidad.AsientoContableModuloService;
import com.massoftware.service.contabilidad.AsientoContable;
import com.massoftware.service.contabilidad.AsientosContablesFiltro;
import com.massoftware.service.contabilidad.AsientosContables;
import com.massoftware.service.contabilidad.AsientoContableService;
import com.massoftware.service.contabilidad.AsientoContableItem;
import com.massoftware.service.contabilidad.AsientosContablesItemsFiltro;
import com.massoftware.service.contabilidad.AsientosContablesItems;
import com.massoftware.service.contabilidad.AsientoContableItemService;
import com.massoftware.service.empresa.Empresa;
import com.massoftware.service.empresa.EmpresasFiltro;
import com.massoftware.service.empresa.Empresas;
import com.massoftware.service.empresa.EmpresaService;
import com.massoftware.service.monedas.Moneda;
import com.massoftware.service.monedas.MonedasFiltro;
import com.massoftware.service.monedas.Monedas;
import com.massoftware.service.monedas.MonedaService;
import com.massoftware.service.monedas.MonedaCotizacion;
import com.massoftware.service.monedas.MonedasCotizacionesFiltro;
import com.massoftware.service.monedas.MonedasCotizaciones;
import com.massoftware.service.monedas.MonedaCotizacionService;
import com.massoftware.service.fondos.banco.Banco;
import com.massoftware.service.fondos.banco.BancosFiltro;
import com.massoftware.service.fondos.banco.Bancos;
import com.massoftware.service.fondos.banco.BancoService;
import com.massoftware.service.fondos.banco.BancoFirmante;
import com.massoftware.service.fondos.banco.BancosFirmantesFiltro;
import com.massoftware.service.fondos.banco.BancosFirmantes;
import com.massoftware.service.fondos.banco.BancoFirmanteService;
import com.massoftware.service.fondos.Caja;
import com.massoftware.service.fondos.CajasFiltro;
import com.massoftware.service.fondos.Cajas;
import com.massoftware.service.fondos.CajaService;
import com.massoftware.service.fondos.CuentaFondoTipo;
import com.massoftware.service.fondos.CuentasFondosTiposFiltro;
import com.massoftware.service.fondos.CuentasFondosTipos;
import com.massoftware.service.fondos.CuentaFondoTipoService;
import com.massoftware.service.fondos.CuentaFondoRubro;
import com.massoftware.service.fondos.CuentasFondosRubrosFiltro;
import com.massoftware.service.fondos.CuentasFondosRubros;
import com.massoftware.service.fondos.CuentaFondoRubroService;
import com.massoftware.service.fondos.CuentaFondoGrupo;
import com.massoftware.service.fondos.CuentasFondosGruposFiltro;
import com.massoftware.service.fondos.CuentasFondosGrupos;
import com.massoftware.service.fondos.CuentaFondoGrupoService;
import com.massoftware.service.fondos.CuentaFondoTipoBanco;
import com.massoftware.service.fondos.CuentasFondosTiposBancosFiltro;
import com.massoftware.service.fondos.CuentasFondosTiposBancos;
import com.massoftware.service.fondos.CuentaFondoTipoBancoService;
import com.massoftware.service.fondos.CuentaFondoBancoCopia;
import com.massoftware.service.fondos.CuentasFondosBancosCopiasFiltro;
import com.massoftware.service.fondos.CuentasFondosBancosCopias;
import com.massoftware.service.fondos.CuentaFondoBancoCopiaService;
import com.massoftware.service.fondos.CuentaFondo;
import com.massoftware.service.fondos.CuentasFondosFiltro;
import com.massoftware.service.fondos.CuentasFondos;
import com.massoftware.service.fondos.CuentaFondoService;
import com.massoftware.service.fondos.ComprobanteFondoModelo;
import com.massoftware.service.fondos.ComprobantesFondosModelosFiltro;
import com.massoftware.service.fondos.ComprobantesFondosModelos;
import com.massoftware.service.fondos.ComprobanteFondoModeloService;
import com.massoftware.service.fondos.ComprobanteFondoModeloItem;
import com.massoftware.service.fondos.ComprobantesFondosModelosItemsFiltro;
import com.massoftware.service.fondos.ComprobantesFondosModelosItems;
import com.massoftware.service.fondos.ComprobanteFondoModeloItemService;
import com.massoftware.service.fondos.TalonarioLetra;
import com.massoftware.service.fondos.TalonariosLetrasFiltro;
import com.massoftware.service.fondos.TalonariosLetras;
import com.massoftware.service.fondos.TalonarioLetraService;
import com.massoftware.service.fondos.TalonarioControladorFizcal;
import com.massoftware.service.fondos.TalonariosControladoresFizcalesFiltro;
import com.massoftware.service.fondos.TalonariosControladoresFizcales;
import com.massoftware.service.fondos.TalonarioControladorFizcalService;
import com.massoftware.service.fondos.Talonario;
import com.massoftware.service.fondos.TalonariosFiltro;
import com.massoftware.service.fondos.Talonarios;
import com.massoftware.service.fondos.TalonarioService;
import com.massoftware.service.fondos.TicketControlDenunciados;
import com.massoftware.service.fondos.TicketsControlesDenunciadosFiltro;
import com.massoftware.service.fondos.TicketsControlesDenunciados;
import com.massoftware.service.fondos.TicketControlDenunciadosService;
import com.massoftware.service.fondos.Ticket;
import com.massoftware.service.fondos.TicketsFiltro;
import com.massoftware.service.fondos.Tickets;
import com.massoftware.service.fondos.TicketService;
import com.massoftware.service.fondos.TicketModelo;
import com.massoftware.service.fondos.TicketsModelosFiltro;
import com.massoftware.service.fondos.TicketsModelos;
import com.massoftware.service.fondos.TicketModeloService;
import com.massoftware.service.fondos.JuridiccionConvnioMultilateral;
import com.massoftware.service.fondos.JuridiccionesConvniosMultilateralesFiltro;
import com.massoftware.service.fondos.JuridiccionesConvniosMultilaterales;
import com.massoftware.service.fondos.JuridiccionConvnioMultilateralService;
import com.massoftware.service.fondos.Chequera;
import com.massoftware.service.fondos.ChequerasFiltro;
import com.massoftware.service.fondos.Chequeras;
import com.massoftware.service.fondos.ChequeraService;
import com.massoftware.service.fondos.TipoComprobanteConcepto;
import com.massoftware.service.fondos.TiposComprobantesConceptosFiltro;
import com.massoftware.service.fondos.TiposComprobantesConceptos;
import com.massoftware.service.fondos.TipoComprobanteConceptoService;
import com.massoftware.service.fondos.ClaseComprobante;
import com.massoftware.service.fondos.ClasesComprobantesFiltro;
import com.massoftware.service.fondos.ClasesComprobantes;
import com.massoftware.service.fondos.ClaseComprobanteService;
import com.massoftware.service.fondos.ComportamientoComprobante;
import com.massoftware.service.fondos.ComportamientosComprobantesFiltro;
import com.massoftware.service.fondos.ComportamientosComprobantes;
import com.massoftware.service.fondos.ComportamientoComprobanteService;
import com.massoftware.service.fondos.TipoComprobanteCopia;
import com.massoftware.service.fondos.TiposComprobantesCopiasFiltro;
import com.massoftware.service.fondos.TiposComprobantesCopias;
import com.massoftware.service.fondos.TipoComprobanteCopiaService;
import com.massoftware.service.fondos.TipoComprobanteCopiaAlternativo;
import com.massoftware.service.fondos.TiposComprobantesCopiasAlternativosFiltro;
import com.massoftware.service.fondos.TiposComprobantesCopiasAlternativos;
import com.massoftware.service.fondos.TipoComprobanteCopiaAlternativoService;

public class Populate {

	static int maxRows = 300;

	public static void main(String[] args) throws Exception {
			//insertUsuario();
			//insertSeguridadModulo();
			//insertSeguridadPuerta();
			//insertZona();
			//insertPais();
			//insertProvincia();
			//insertCiudad();
			//insertCodigoPostal();
			//insertTransporte();
			//insertCarga();
			//insertTransporteTarifa();
			//insertTipoDocumentoAFIP();
			//insertMonedaAFIP();
			//insertNotaCreditoMotivo();
			//insertMotivoComentario();
			//insertTipoCliente();
			//insertClasificacionCliente();
			//insertMotivoBloqueoCliente();
			//insertTipoSucursal();
			//insertSucursal();
			//insertDepositoModulo();
			//insertDeposito();
			//insertEjercicioContable();
			//insertCentroCostoContable();
			//insertTipoPuntoEquilibrio();
			//insertPuntoEquilibrio();
			//insertCostoVenta();
			//insertCuentaContableEstado();
			//insertCuentaContable();
			//insertAsientoModelo();
			//insertAsientoModeloItem();
			//insertMinutaContable();
			//insertAsientoContableModulo();
			//insertAsientoContable();
			//insertAsientoContableItem();
			//insertEmpresa();
			//insertMoneda();
			//insertMonedaCotizacion();
			//insertBanco();
			//insertBancoFirmante();
			//insertCaja();
			//insertCuentaFondoTipo();
			//insertCuentaFondoRubro();
			//insertCuentaFondoGrupo();
			//insertCuentaFondoTipoBanco();
			//insertCuentaFondoBancoCopia();
			//insertCuentaFondo();
			//insertComprobanteFondoModelo();
			//insertComprobanteFondoModeloItem();
			//insertTalonarioLetra();
			//insertTalonarioControladorFizcal();
			//insertTalonario();
			//insertTicketControlDenunciados();
			//insertTicket();
			//insertTicketModelo();
			//insertJuridiccionConvnioMultilateral();
			//insertChequera();
			//insertTipoComprobanteConcepto();
			//insertClaseComprobante();
			//insertComportamientoComprobante();
			//insertTipoComprobanteCopia();
			//insertTipoComprobanteCopiaAlternativo();
	}


	public static void insertUsuario() throws Exception {

		UsuarioService service = AppCX.services().buildUsuarioService();

		for(int i = 0; i < maxRows; i++){

			try {

				Usuario obj = new Usuario();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertSeguridadModulo() throws Exception {

		SeguridadModuloService service = AppCX.services().buildSeguridadModuloService();

		for(int i = 0; i < maxRows; i++){

			try {

				SeguridadModulo obj = new SeguridadModulo();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertSeguridadPuerta() throws Exception {

		SeguridadPuertaService service = AppCX.services().buildSeguridadPuertaService();
		SeguridadModuloService serviceseguridadModulo = AppCX.services().buildSeguridadModuloService();
		Long seguridadModuloCount = serviceseguridadModulo.count();

		for(int i = 0; i < maxRows; i++){

			try {

				SeguridadPuerta obj = new SeguridadPuerta();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				obj.setEquate(UtilPopulate.getStringRandom(null, 30, true));

				SeguridadModulosFiltro seguridadModuloFiltro = new SeguridadModulosFiltro();
				int seguridadModuloIndex = UtilPopulate.getIntegerRandom(0, seguridadModuloCount.intValue()-1);
				seguridadModuloFiltro.setOffset(seguridadModuloIndex);
				seguridadModuloFiltro.setLimit(1);
				List<SeguridadModulos> seguridadModuloListado = serviceseguridadModulo.find(seguridadModuloFiltro);
				SeguridadModulo objFkSeguridadModulo  = new SeguridadModulo();
				objFkSeguridadModulo.setId(seguridadModuloListado.get(0).getId());
				obj.setSeguridadModulo(objFkSeguridadModulo);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertZona() throws Exception {

		ZonaService service = AppCX.services().buildZonaService();

		for(int i = 0; i < maxRows; i++){

			try {

				Zona obj = new Zona();

				obj.setCodigo(UtilPopulate.getStringRandom(null, 3, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				obj.setBonificacion(UtilPopulate.getBigDecimalRandom(new java.math.BigDecimal("0"), new java.math.BigDecimal("99999.9999"), false, 13, 5));

				obj.setRecargo(UtilPopulate.getBigDecimalRandom(new java.math.BigDecimal("0"), new java.math.BigDecimal("99999.9999"), false, 13, 5));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertPais() throws Exception {

		PaisService service = AppCX.services().buildPaisService();

		for(int i = 0; i < maxRows; i++){

			try {

				Pais obj = new Pais();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				obj.setAbreviatura(UtilPopulate.getStringRandom(null, 5, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertProvincia() throws Exception {

		ProvinciaService service = AppCX.services().buildProvinciaService();
		PaisService servicepais = AppCX.services().buildPaisService();
		Long paisCount = servicepais.count();

		for(int i = 0; i < maxRows; i++){

			try {

				Provincia obj = new Provincia();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				obj.setAbreviatura(UtilPopulate.getStringRandom(null, 5, true));

				obj.setNumeroAFIP(UtilPopulate.getIntegerRandom(1, null, false));

				obj.setNumeroIngresosBrutos(UtilPopulate.getIntegerRandom(1, null, false));

				obj.setNumeroRENATEA(UtilPopulate.getIntegerRandom(1, null, false));

				PaisesFiltro paisFiltro = new PaisesFiltro();
				int paisIndex = UtilPopulate.getIntegerRandom(0, paisCount.intValue()-1);
				paisFiltro.setOffset(paisIndex);
				paisFiltro.setLimit(1);
				List<Paises> paisListado = servicepais.find(paisFiltro);
				Pais objFkPais  = new Pais();
				objFkPais.setId(paisListado.get(0).getId());
				obj.setPais(objFkPais);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertCiudad() throws Exception {

		CiudadService service = AppCX.services().buildCiudadService();
		ProvinciaService serviceprovincia = AppCX.services().buildProvinciaService();
		Long provinciaCount = serviceprovincia.count();

		for(int i = 0; i < maxRows; i++){

			try {

				Ciudad obj = new Ciudad();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				obj.setDepartamento(UtilPopulate.getStringRandom(null, 50, false));

				obj.setNumeroAFIP(UtilPopulate.getIntegerRandom(1, null, false));

				ProvinciasFiltro provinciaFiltro = new ProvinciasFiltro();
				int provinciaIndex = UtilPopulate.getIntegerRandom(0, provinciaCount.intValue()-1);
				provinciaFiltro.setOffset(provinciaIndex);
				provinciaFiltro.setLimit(1);
				List<Provincias> provinciaListado = serviceprovincia.find(provinciaFiltro);
				Provincia objFkProvincia  = new Provincia();
				objFkProvincia.setId(provinciaListado.get(0).getId());
				obj.setProvincia(objFkProvincia);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertCodigoPostal() throws Exception {

		CodigoPostalService service = AppCX.services().buildCodigoPostalService();
		CiudadService serviceciudad = AppCX.services().buildCiudadService();
		Long ciudadCount = serviceciudad.count();

		for(int i = 0; i < maxRows; i++){

			try {

				CodigoPostal obj = new CodigoPostal();

				obj.setCodigo(UtilPopulate.getStringRandom(null, 12, true));

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombreCalle(UtilPopulate.getStringRandom(null, 200, true));

				obj.setNumeroCalle(UtilPopulate.getStringRandom(null, 20, true));

				CiudadesFiltro ciudadFiltro = new CiudadesFiltro();
				int ciudadIndex = UtilPopulate.getIntegerRandom(0, ciudadCount.intValue()-1);
				ciudadFiltro.setOffset(ciudadIndex);
				ciudadFiltro.setLimit(1);
				List<Ciudades> ciudadListado = serviceciudad.find(ciudadFiltro);
				Ciudad objFkCiudad  = new Ciudad();
				objFkCiudad.setId(ciudadListado.get(0).getId());
				obj.setCiudad(objFkCiudad);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertTransporte() throws Exception {

		TransporteService service = AppCX.services().buildTransporteService();
		CodigoPostalService servicecodigoPostal = AppCX.services().buildCodigoPostalService();
		Long codigoPostalCount = servicecodigoPostal.count();

		for(int i = 0; i < maxRows; i++){

			try {

				Transporte obj = new Transporte();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				obj.setCuit(UtilPopulate.getLongRandom(1L, 99999999999L, true));

				obj.setIngresosBrutos(UtilPopulate.getStringRandom(null, 13, false));

				obj.setTelefono(UtilPopulate.getStringRandom(null, 50, false));

				obj.setFax(UtilPopulate.getStringRandom(null, 50, false));

				CodigosPostalesFiltro codigoPostalFiltro = new CodigosPostalesFiltro();
				int codigoPostalIndex = UtilPopulate.getIntegerRandom(0, codigoPostalCount.intValue()-1);
				codigoPostalFiltro.setOffset(codigoPostalIndex);
				codigoPostalFiltro.setLimit(1);
				List<CodigosPostales> codigoPostalListado = servicecodigoPostal.find(codigoPostalFiltro);
				CodigoPostal objFkCodigoPostal  = new CodigoPostal();
				objFkCodigoPostal.setId(codigoPostalListado.get(0).getId());
				obj.setCodigoPostal(objFkCodigoPostal);

				obj.setDomicilio(UtilPopulate.getStringRandom(null, 150, false));

				obj.setComentario(UtilPopulate.getStringRandom(null, 300, false));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertCarga() throws Exception {

		CargaService service = AppCX.services().buildCargaService();
		TransporteService servicetransporte = AppCX.services().buildTransporteService();
		Long transporteCount = servicetransporte.count();

		for(int i = 0; i < maxRows; i++){

			try {

				Carga obj = new Carga();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				TransportesFiltro transporteFiltro = new TransportesFiltro();
				int transporteIndex = UtilPopulate.getIntegerRandom(0, transporteCount.intValue()-1);
				transporteFiltro.setOffset(transporteIndex);
				transporteFiltro.setLimit(1);
				List<Transportes> transporteListado = servicetransporte.find(transporteFiltro);
				Transporte objFkTransporte  = new Transporte();
				objFkTransporte.setId(transporteListado.get(0).getId());
				obj.setTransporte(objFkTransporte);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertTransporteTarifa() throws Exception {

		TransporteTarifaService service = AppCX.services().buildTransporteTarifaService();
		CargaService servicecarga = AppCX.services().buildCargaService();
		Long cargaCount = servicecarga.count();
		CiudadService serviceciudad = AppCX.services().buildCiudadService();
		Long ciudadCount = serviceciudad.count();

		for(int i = 0; i < maxRows; i++){

			try {

				TransporteTarifa obj = new TransporteTarifa();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				CargasFiltro cargaFiltro = new CargasFiltro();
				int cargaIndex = UtilPopulate.getIntegerRandom(0, cargaCount.intValue()-1);
				cargaFiltro.setOffset(cargaIndex);
				cargaFiltro.setLimit(1);
				List<Cargas> cargaListado = servicecarga.find(cargaFiltro);
				Carga objFkCarga  = new Carga();
				objFkCarga.setId(cargaListado.get(0).getId());
				obj.setCarga(objFkCarga);

				CiudadesFiltro ciudadFiltro = new CiudadesFiltro();
				int ciudadIndex = UtilPopulate.getIntegerRandom(0, ciudadCount.intValue()-1);
				ciudadFiltro.setOffset(ciudadIndex);
				ciudadFiltro.setLimit(1);
				List<Ciudades> ciudadListado = serviceciudad.find(ciudadFiltro);
				Ciudad objFkCiudad  = new Ciudad();
				objFkCiudad.setId(ciudadListado.get(0).getId());
				obj.setCiudad(objFkCiudad);

				obj.setPrecioFlete(UtilPopulate.getBigDecimalRandom(new java.math.BigDecimal("-9999.9999"), new java.math.BigDecimal("99999.9999"), true, 13, 5));

				obj.setPrecioUnidadFacturacion(UtilPopulate.getBigDecimalRandom(new java.math.BigDecimal("-9999.9999"), new java.math.BigDecimal("99999.9999"), false, 13, 5));

				obj.setPrecioUnidadStock(UtilPopulate.getBigDecimalRandom(new java.math.BigDecimal("-9999.9999"), new java.math.BigDecimal("99999.9999"), false, 13, 5));

				obj.setPrecioBultos(UtilPopulate.getBigDecimalRandom(new java.math.BigDecimal("-9999.9999"), new java.math.BigDecimal("99999.9999"), false, 13, 5));

				obj.setImporteMinimoEntrega(UtilPopulate.getBigDecimalRandom(new java.math.BigDecimal("-9999.9999"), new java.math.BigDecimal("99999.9999"), false, 13, 5));

				obj.setImporteMinimoCarga(UtilPopulate.getBigDecimalRandom(new java.math.BigDecimal("-9999.9999"), new java.math.BigDecimal("99999.9999"), false, 13, 5));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertTipoDocumentoAFIP() throws Exception {

		TipoDocumentoAFIPService service = AppCX.services().buildTipoDocumentoAFIPService();

		for(int i = 0; i < maxRows; i++){

			try {

				TipoDocumentoAFIP obj = new TipoDocumentoAFIP();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertMonedaAFIP() throws Exception {

		MonedaAFIPService service = AppCX.services().buildMonedaAFIPService();

		for(int i = 0; i < maxRows; i++){

			try {

				MonedaAFIP obj = new MonedaAFIP();

				obj.setCodigo(UtilPopulate.getStringRandom(null, 3, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertNotaCreditoMotivo() throws Exception {

		NotaCreditoMotivoService service = AppCX.services().buildNotaCreditoMotivoService();

		for(int i = 0; i < maxRows; i++){

			try {

				NotaCreditoMotivo obj = new NotaCreditoMotivo();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertMotivoComentario() throws Exception {

		MotivoComentarioService service = AppCX.services().buildMotivoComentarioService();

		for(int i = 0; i < maxRows; i++){

			try {

				MotivoComentario obj = new MotivoComentario();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertTipoCliente() throws Exception {

		TipoClienteService service = AppCX.services().buildTipoClienteService();

		for(int i = 0; i < maxRows; i++){

			try {

				TipoCliente obj = new TipoCliente();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertClasificacionCliente() throws Exception {

		ClasificacionClienteService service = AppCX.services().buildClasificacionClienteService();

		for(int i = 0; i < maxRows; i++){

			try {

				ClasificacionCliente obj = new ClasificacionCliente();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				obj.setColor(UtilPopulate.getIntegerRandom(1, null, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertMotivoBloqueoCliente() throws Exception {

		MotivoBloqueoClienteService service = AppCX.services().buildMotivoBloqueoClienteService();
		ClasificacionClienteService serviceclasificacionCliente = AppCX.services().buildClasificacionClienteService();
		Long clasificacionClienteCount = serviceclasificacionCliente.count();

		for(int i = 0; i < maxRows; i++){

			try {

				MotivoBloqueoCliente obj = new MotivoBloqueoCliente();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				ClasificacionesClientesFiltro clasificacionClienteFiltro = new ClasificacionesClientesFiltro();
				int clasificacionClienteIndex = UtilPopulate.getIntegerRandom(0, clasificacionClienteCount.intValue()-1);
				clasificacionClienteFiltro.setOffset(clasificacionClienteIndex);
				clasificacionClienteFiltro.setLimit(1);
				List<ClasificacionesClientes> clasificacionClienteListado = serviceclasificacionCliente.find(clasificacionClienteFiltro);
				ClasificacionCliente objFkClasificacionCliente  = new ClasificacionCliente();
				objFkClasificacionCliente.setId(clasificacionClienteListado.get(0).getId());
				obj.setClasificacionCliente(objFkClasificacionCliente);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertTipoSucursal() throws Exception {

		TipoSucursalService service = AppCX.services().buildTipoSucursalService();

		for(int i = 0; i < maxRows; i++){

			try {

				TipoSucursal obj = new TipoSucursal();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertSucursal() throws Exception {

		SucursalService service = AppCX.services().buildSucursalService();
		TipoSucursalService servicetipoSucursal = AppCX.services().buildTipoSucursalService();
		Long tipoSucursalCount = servicetipoSucursal.count();

		for(int i = 0; i < maxRows; i++){

			try {

				Sucursal obj = new Sucursal();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				obj.setAbreviatura(UtilPopulate.getStringRandom(null, 5, true));

				TiposSucursalesFiltro tipoSucursalFiltro = new TiposSucursalesFiltro();
				int tipoSucursalIndex = UtilPopulate.getIntegerRandom(0, tipoSucursalCount.intValue()-1);
				tipoSucursalFiltro.setOffset(tipoSucursalIndex);
				tipoSucursalFiltro.setLimit(1);
				List<TiposSucursales> tipoSucursalListado = servicetipoSucursal.find(tipoSucursalFiltro);
				TipoSucursal objFkTipoSucursal  = new TipoSucursal();
				objFkTipoSucursal.setId(tipoSucursalListado.get(0).getId());
				obj.setTipoSucursal(objFkTipoSucursal);

				obj.setCuentaClientesDesde(UtilPopulate.getStringRandom(null, 7, false));

				obj.setCuentaClientesHasta(UtilPopulate.getStringRandom(null, 7, false));

				obj.setCantidadCaracteresClientes(UtilPopulate.getIntegerRandom(3, 6, true));

				obj.setIdentificacionNumericaClientes(new Random().nextBoolean());

				obj.setPermiteCambiarClientes(new Random().nextBoolean());

				obj.setCuentaProveedoresDesde(UtilPopulate.getStringRandom(null, 6, false));

				obj.setCuentaProveedoresHasta(UtilPopulate.getStringRandom(null, 6, false));

				obj.setCantidadCaracteresProveedores(UtilPopulate.getIntegerRandom(3, 6, true));

				obj.setIdentificacionNumericaProveedores(new Random().nextBoolean());

				obj.setPermiteCambiarProveedores(new Random().nextBoolean());

				obj.setClientesOcacionalesDesde(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setClientesOcacionalesHasta(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNumeroCobranzaDesde(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNumeroCobranzaHasta(UtilPopulate.getIntegerRandom(1, null, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertDepositoModulo() throws Exception {

		DepositoModuloService service = AppCX.services().buildDepositoModuloService();

		for(int i = 0; i < maxRows; i++){

			try {

				DepositoModulo obj = new DepositoModulo();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertDeposito() throws Exception {

		DepositoService service = AppCX.services().buildDepositoService();
		SucursalService servicesucursal = AppCX.services().buildSucursalService();
		Long sucursalCount = servicesucursal.count();
		DepositoModuloService servicedepositoModulo = AppCX.services().buildDepositoModuloService();
		Long depositoModuloCount = servicedepositoModulo.count();
		SeguridadPuertaService servicepuertaOperativo = AppCX.services().buildSeguridadPuertaService();
		Long puertaOperativoCount = servicepuertaOperativo.count();
		SeguridadPuertaService servicepuertaConsulta = AppCX.services().buildSeguridadPuertaService();
		Long puertaConsultaCount = servicepuertaConsulta.count();

		for(int i = 0; i < maxRows; i++){

			try {

				Deposito obj = new Deposito();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				obj.setAbreviatura(UtilPopulate.getStringRandom(null, 5, true));

				SucursalesFiltro sucursalFiltro = new SucursalesFiltro();
				int sucursalIndex = UtilPopulate.getIntegerRandom(0, sucursalCount.intValue()-1);
				sucursalFiltro.setOffset(sucursalIndex);
				sucursalFiltro.setLimit(1);
				List<Sucursales> sucursalListado = servicesucursal.find(sucursalFiltro);
				Sucursal objFkSucursal  = new Sucursal();
				objFkSucursal.setId(sucursalListado.get(0).getId());
				obj.setSucursal(objFkSucursal);

				DepositosModulosFiltro depositoModuloFiltro = new DepositosModulosFiltro();
				int depositoModuloIndex = UtilPopulate.getIntegerRandom(0, depositoModuloCount.intValue()-1);
				depositoModuloFiltro.setOffset(depositoModuloIndex);
				depositoModuloFiltro.setLimit(1);
				List<DepositosModulos> depositoModuloListado = servicedepositoModulo.find(depositoModuloFiltro);
				DepositoModulo objFkDepositoModulo  = new DepositoModulo();
				objFkDepositoModulo.setId(depositoModuloListado.get(0).getId());
				obj.setDepositoModulo(objFkDepositoModulo);

				SeguridadPuertasFiltro puertaOperativoFiltro = new SeguridadPuertasFiltro();
				int puertaOperativoIndex = UtilPopulate.getIntegerRandom(0, puertaOperativoCount.intValue()-1);
				puertaOperativoFiltro.setOffset(puertaOperativoIndex);
				puertaOperativoFiltro.setLimit(1);
				List<SeguridadPuertas> puertaOperativoListado = servicepuertaOperativo.find(puertaOperativoFiltro);
				SeguridadPuerta objFkPuertaOperativo  = new SeguridadPuerta();
				objFkPuertaOperativo.setId(puertaOperativoListado.get(0).getId());
				obj.setPuertaOperativo(objFkPuertaOperativo);

				SeguridadPuertasFiltro puertaConsultaFiltro = new SeguridadPuertasFiltro();
				int puertaConsultaIndex = UtilPopulate.getIntegerRandom(0, puertaConsultaCount.intValue()-1);
				puertaConsultaFiltro.setOffset(puertaConsultaIndex);
				puertaConsultaFiltro.setLimit(1);
				List<SeguridadPuertas> puertaConsultaListado = servicepuertaConsulta.find(puertaConsultaFiltro);
				SeguridadPuerta objFkPuertaConsulta  = new SeguridadPuerta();
				objFkPuertaConsulta.setId(puertaConsultaListado.get(0).getId());
				obj.setPuertaConsulta(objFkPuertaConsulta);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertEjercicioContable() throws Exception {

		EjercicioContableService service = AppCX.services().buildEjercicioContableService();

		for(int i = 0; i < maxRows; i++){

			try {

				EjercicioContable obj = new EjercicioContable();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setApertura(new java.util.Date(UtilPopulate.getDateRandom(2000, 2019, true)));

				obj.setCierre(new java.util.Date(UtilPopulate.getDateRandom(2000, 2019, true)));

				obj.setCerrado(new Random().nextBoolean());

				obj.setCerradoModulos(new Random().nextBoolean());

				obj.setComentario(UtilPopulate.getStringRandom(null, 250, false));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertCentroCostoContable() throws Exception {

		CentroCostoContableService service = AppCX.services().buildCentroCostoContableService();
		EjercicioContableService serviceejercicioContable = AppCX.services().buildEjercicioContableService();
		Long ejercicioContableCount = serviceejercicioContable.count();

		for(int i = 0; i < maxRows; i++){

			try {

				CentroCostoContable obj = new CentroCostoContable();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				obj.setAbreviatura(UtilPopulate.getStringRandom(null, 5, true));

				EjerciciosContablesFiltro ejercicioContableFiltro = new EjerciciosContablesFiltro();
				int ejercicioContableIndex = UtilPopulate.getIntegerRandom(0, ejercicioContableCount.intValue()-1);
				ejercicioContableFiltro.setOffset(ejercicioContableIndex);
				ejercicioContableFiltro.setLimit(1);
				List<EjerciciosContables> ejercicioContableListado = serviceejercicioContable.find(ejercicioContableFiltro);
				EjercicioContable objFkEjercicioContable  = new EjercicioContable();
				objFkEjercicioContable.setId(ejercicioContableListado.get(0).getId());
				obj.setEjercicioContable(objFkEjercicioContable);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertTipoPuntoEquilibrio() throws Exception {

		TipoPuntoEquilibrioService service = AppCX.services().buildTipoPuntoEquilibrioService();

		for(int i = 0; i < maxRows; i++){

			try {

				TipoPuntoEquilibrio obj = new TipoPuntoEquilibrio();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertPuntoEquilibrio() throws Exception {

		PuntoEquilibrioService service = AppCX.services().buildPuntoEquilibrioService();
		TipoPuntoEquilibrioService servicetipoPuntoEquilibrio = AppCX.services().buildTipoPuntoEquilibrioService();
		Long tipoPuntoEquilibrioCount = servicetipoPuntoEquilibrio.count();
		EjercicioContableService serviceejercicioContable = AppCX.services().buildEjercicioContableService();
		Long ejercicioContableCount = serviceejercicioContable.count();

		for(int i = 0; i < maxRows; i++){

			try {

				PuntoEquilibrio obj = new PuntoEquilibrio();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				TiposPuntosEquilibriosFiltro tipoPuntoEquilibrioFiltro = new TiposPuntosEquilibriosFiltro();
				int tipoPuntoEquilibrioIndex = UtilPopulate.getIntegerRandom(0, tipoPuntoEquilibrioCount.intValue()-1);
				tipoPuntoEquilibrioFiltro.setOffset(tipoPuntoEquilibrioIndex);
				tipoPuntoEquilibrioFiltro.setLimit(1);
				List<TiposPuntosEquilibrios> tipoPuntoEquilibrioListado = servicetipoPuntoEquilibrio.find(tipoPuntoEquilibrioFiltro);
				TipoPuntoEquilibrio objFkTipoPuntoEquilibrio  = new TipoPuntoEquilibrio();
				objFkTipoPuntoEquilibrio.setId(tipoPuntoEquilibrioListado.get(0).getId());
				obj.setTipoPuntoEquilibrio(objFkTipoPuntoEquilibrio);

				EjerciciosContablesFiltro ejercicioContableFiltro = new EjerciciosContablesFiltro();
				int ejercicioContableIndex = UtilPopulate.getIntegerRandom(0, ejercicioContableCount.intValue()-1);
				ejercicioContableFiltro.setOffset(ejercicioContableIndex);
				ejercicioContableFiltro.setLimit(1);
				List<EjerciciosContables> ejercicioContableListado = serviceejercicioContable.find(ejercicioContableFiltro);
				EjercicioContable objFkEjercicioContable  = new EjercicioContable();
				objFkEjercicioContable.setId(ejercicioContableListado.get(0).getId());
				obj.setEjercicioContable(objFkEjercicioContable);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertCostoVenta() throws Exception {

		CostoVentaService service = AppCX.services().buildCostoVentaService();

		for(int i = 0; i < maxRows; i++){

			try {

				CostoVenta obj = new CostoVenta();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertCuentaContableEstado() throws Exception {

		CuentaContableEstadoService service = AppCX.services().buildCuentaContableEstadoService();

		for(int i = 0; i < maxRows; i++){

			try {

				CuentaContableEstado obj = new CuentaContableEstado();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertCuentaContable() throws Exception {

		CuentaContableService service = AppCX.services().buildCuentaContableService();
		EjercicioContableService serviceejercicioContable = AppCX.services().buildEjercicioContableService();
		Long ejercicioContableCount = serviceejercicioContable.count();
		CuentaContableEstadoService servicecuentaContableEstado = AppCX.services().buildCuentaContableEstadoService();
		Long cuentaContableEstadoCount = servicecuentaContableEstado.count();
		CentroCostoContableService servicecentroCostoContable = AppCX.services().buildCentroCostoContableService();
		Long centroCostoContableCount = servicecentroCostoContable.count();
		PuntoEquilibrioService servicepuntoEquilibrio = AppCX.services().buildPuntoEquilibrioService();
		Long puntoEquilibrioCount = servicepuntoEquilibrio.count();
		CostoVentaService servicecostoVenta = AppCX.services().buildCostoVentaService();
		Long costoVentaCount = servicecostoVenta.count();
		SeguridadPuertaService serviceseguridadPuerta = AppCX.services().buildSeguridadPuertaService();
		Long seguridadPuertaCount = serviceseguridadPuerta.count();

		for(int i = 0; i < maxRows; i++){

			try {

				CuentaContable obj = new CuentaContable();

				obj.setCodigo(UtilPopulate.getStringRandom(null, 11, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				EjerciciosContablesFiltro ejercicioContableFiltro = new EjerciciosContablesFiltro();
				int ejercicioContableIndex = UtilPopulate.getIntegerRandom(0, ejercicioContableCount.intValue()-1);
				ejercicioContableFiltro.setOffset(ejercicioContableIndex);
				ejercicioContableFiltro.setLimit(1);
				List<EjerciciosContables> ejercicioContableListado = serviceejercicioContable.find(ejercicioContableFiltro);
				EjercicioContable objFkEjercicioContable  = new EjercicioContable();
				objFkEjercicioContable.setId(ejercicioContableListado.get(0).getId());
				obj.setEjercicioContable(objFkEjercicioContable);

				obj.setIntegra(UtilPopulate.getStringRandom(16, 16, true));

				obj.setCuentaJerarquia(UtilPopulate.getStringRandom(16, 16, true));

				obj.setImputable(new Random().nextBoolean());

				obj.setAjustaPorInflacion(new Random().nextBoolean());

				CuentasContablesEstadosFiltro cuentaContableEstadoFiltro = new CuentasContablesEstadosFiltro();
				int cuentaContableEstadoIndex = UtilPopulate.getIntegerRandom(0, cuentaContableEstadoCount.intValue()-1);
				cuentaContableEstadoFiltro.setOffset(cuentaContableEstadoIndex);
				cuentaContableEstadoFiltro.setLimit(1);
				List<CuentasContablesEstados> cuentaContableEstadoListado = servicecuentaContableEstado.find(cuentaContableEstadoFiltro);
				CuentaContableEstado objFkCuentaContableEstado  = new CuentaContableEstado();
				objFkCuentaContableEstado.setId(cuentaContableEstadoListado.get(0).getId());
				obj.setCuentaContableEstado(objFkCuentaContableEstado);

				obj.setCuentaConApropiacion(new Random().nextBoolean());

				CentrosCostosContablesFiltro centroCostoContableFiltro = new CentrosCostosContablesFiltro();
				int centroCostoContableIndex = UtilPopulate.getIntegerRandom(0, centroCostoContableCount.intValue()-1);
				centroCostoContableFiltro.setOffset(centroCostoContableIndex);
				centroCostoContableFiltro.setLimit(1);
				List<CentrosCostosContables> centroCostoContableListado = servicecentroCostoContable.find(centroCostoContableFiltro);
				CentroCostoContable objFkCentroCostoContable  = new CentroCostoContable();
				objFkCentroCostoContable.setId(centroCostoContableListado.get(0).getId());
				obj.setCentroCostoContable(objFkCentroCostoContable);

				obj.setCuentaAgrupadora(UtilPopulate.getStringRandom(null, 50, false));

				obj.setPorcentaje(UtilPopulate.getBigDecimalRandom(new java.math.BigDecimal("0"), new java.math.BigDecimal("999.99"), false, 6, 3));

				PuntosEquilibriosFiltro puntoEquilibrioFiltro = new PuntosEquilibriosFiltro();
				int puntoEquilibrioIndex = UtilPopulate.getIntegerRandom(0, puntoEquilibrioCount.intValue()-1);
				puntoEquilibrioFiltro.setOffset(puntoEquilibrioIndex);
				puntoEquilibrioFiltro.setLimit(1);
				List<PuntosEquilibrios> puntoEquilibrioListado = servicepuntoEquilibrio.find(puntoEquilibrioFiltro);
				PuntoEquilibrio objFkPuntoEquilibrio  = new PuntoEquilibrio();
				objFkPuntoEquilibrio.setId(puntoEquilibrioListado.get(0).getId());
				obj.setPuntoEquilibrio(objFkPuntoEquilibrio);

				CostosVentasFiltro costoVentaFiltro = new CostosVentasFiltro();
				int costoVentaIndex = UtilPopulate.getIntegerRandom(0, costoVentaCount.intValue()-1);
				costoVentaFiltro.setOffset(costoVentaIndex);
				costoVentaFiltro.setLimit(1);
				List<CostosVentas> costoVentaListado = servicecostoVenta.find(costoVentaFiltro);
				CostoVenta objFkCostoVenta  = new CostoVenta();
				objFkCostoVenta.setId(costoVentaListado.get(0).getId());
				obj.setCostoVenta(objFkCostoVenta);

				SeguridadPuertasFiltro seguridadPuertaFiltro = new SeguridadPuertasFiltro();
				int seguridadPuertaIndex = UtilPopulate.getIntegerRandom(0, seguridadPuertaCount.intValue()-1);
				seguridadPuertaFiltro.setOffset(seguridadPuertaIndex);
				seguridadPuertaFiltro.setLimit(1);
				List<SeguridadPuertas> seguridadPuertaListado = serviceseguridadPuerta.find(seguridadPuertaFiltro);
				SeguridadPuerta objFkSeguridadPuerta  = new SeguridadPuerta();
				objFkSeguridadPuerta.setId(seguridadPuertaListado.get(0).getId());
				obj.setSeguridadPuerta(objFkSeguridadPuerta);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertAsientoModelo() throws Exception {

		AsientoModeloService service = AppCX.services().buildAsientoModeloService();
		EjercicioContableService serviceejercicioContable = AppCX.services().buildEjercicioContableService();
		Long ejercicioContableCount = serviceejercicioContable.count();

		for(int i = 0; i < maxRows; i++){

			try {

				AsientoModelo obj = new AsientoModelo();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				EjerciciosContablesFiltro ejercicioContableFiltro = new EjerciciosContablesFiltro();
				int ejercicioContableIndex = UtilPopulate.getIntegerRandom(0, ejercicioContableCount.intValue()-1);
				ejercicioContableFiltro.setOffset(ejercicioContableIndex);
				ejercicioContableFiltro.setLimit(1);
				List<EjerciciosContables> ejercicioContableListado = serviceejercicioContable.find(ejercicioContableFiltro);
				EjercicioContable objFkEjercicioContable  = new EjercicioContable();
				objFkEjercicioContable.setId(ejercicioContableListado.get(0).getId());
				obj.setEjercicioContable(objFkEjercicioContable);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertAsientoModeloItem() throws Exception {

		AsientoModeloItemService service = AppCX.services().buildAsientoModeloItemService();
		AsientoModeloService serviceasientoModelo = AppCX.services().buildAsientoModeloService();
		Long asientoModeloCount = serviceasientoModelo.count();
		CuentaContableService servicecuentaContable = AppCX.services().buildCuentaContableService();
		Long cuentaContableCount = servicecuentaContable.count();

		for(int i = 0; i < maxRows; i++){

			try {

				AsientoModeloItem obj = new AsientoModeloItem();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				AsientosModelosFiltro asientoModeloFiltro = new AsientosModelosFiltro();
				int asientoModeloIndex = UtilPopulate.getIntegerRandom(0, asientoModeloCount.intValue()-1);
				asientoModeloFiltro.setOffset(asientoModeloIndex);
				asientoModeloFiltro.setLimit(1);
				List<AsientosModelos> asientoModeloListado = serviceasientoModelo.find(asientoModeloFiltro);
				AsientoModelo objFkAsientoModelo  = new AsientoModelo();
				objFkAsientoModelo.setId(asientoModeloListado.get(0).getId());
				obj.setAsientoModelo(objFkAsientoModelo);

				CuentasContablesFiltro cuentaContableFiltro = new CuentasContablesFiltro();
				int cuentaContableIndex = UtilPopulate.getIntegerRandom(0, cuentaContableCount.intValue()-1);
				cuentaContableFiltro.setOffset(cuentaContableIndex);
				cuentaContableFiltro.setLimit(1);
				List<CuentasContables> cuentaContableListado = servicecuentaContable.find(cuentaContableFiltro);
				CuentaContable objFkCuentaContable  = new CuentaContable();
				objFkCuentaContable.setId(cuentaContableListado.get(0).getId());
				obj.setCuentaContable(objFkCuentaContable);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertMinutaContable() throws Exception {

		MinutaContableService service = AppCX.services().buildMinutaContableService();

		for(int i = 0; i < maxRows; i++){

			try {

				MinutaContable obj = new MinutaContable();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertAsientoContableModulo() throws Exception {

		AsientoContableModuloService service = AppCX.services().buildAsientoContableModuloService();

		for(int i = 0; i < maxRows; i++){

			try {

				AsientoContableModulo obj = new AsientoContableModulo();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertAsientoContable() throws Exception {

		AsientoContableService service = AppCX.services().buildAsientoContableService();
		EjercicioContableService serviceejercicioContable = AppCX.services().buildEjercicioContableService();
		Long ejercicioContableCount = serviceejercicioContable.count();
		MinutaContableService serviceminutaContable = AppCX.services().buildMinutaContableService();
		Long minutaContableCount = serviceminutaContable.count();
		SucursalService servicesucursal = AppCX.services().buildSucursalService();
		Long sucursalCount = servicesucursal.count();
		AsientoContableModuloService serviceasientoContableModulo = AppCX.services().buildAsientoContableModuloService();
		Long asientoContableModuloCount = serviceasientoContableModulo.count();

		for(int i = 0; i < maxRows; i++){

			try {

				AsientoContable obj = new AsientoContable();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setFecha(new java.util.Date(UtilPopulate.getDateRandom(2000, 2019, true)));

				obj.setDetalle(UtilPopulate.getStringRandom(null, 100, false));

				EjerciciosContablesFiltro ejercicioContableFiltro = new EjerciciosContablesFiltro();
				int ejercicioContableIndex = UtilPopulate.getIntegerRandom(0, ejercicioContableCount.intValue()-1);
				ejercicioContableFiltro.setOffset(ejercicioContableIndex);
				ejercicioContableFiltro.setLimit(1);
				List<EjerciciosContables> ejercicioContableListado = serviceejercicioContable.find(ejercicioContableFiltro);
				EjercicioContable objFkEjercicioContable  = new EjercicioContable();
				objFkEjercicioContable.setId(ejercicioContableListado.get(0).getId());
				obj.setEjercicioContable(objFkEjercicioContable);

				MinutasContablesFiltro minutaContableFiltro = new MinutasContablesFiltro();
				int minutaContableIndex = UtilPopulate.getIntegerRandom(0, minutaContableCount.intValue()-1);
				minutaContableFiltro.setOffset(minutaContableIndex);
				minutaContableFiltro.setLimit(1);
				List<MinutasContables> minutaContableListado = serviceminutaContable.find(minutaContableFiltro);
				MinutaContable objFkMinutaContable  = new MinutaContable();
				objFkMinutaContable.setId(minutaContableListado.get(0).getId());
				obj.setMinutaContable(objFkMinutaContable);

				SucursalesFiltro sucursalFiltro = new SucursalesFiltro();
				int sucursalIndex = UtilPopulate.getIntegerRandom(0, sucursalCount.intValue()-1);
				sucursalFiltro.setOffset(sucursalIndex);
				sucursalFiltro.setLimit(1);
				List<Sucursales> sucursalListado = servicesucursal.find(sucursalFiltro);
				Sucursal objFkSucursal  = new Sucursal();
				objFkSucursal.setId(sucursalListado.get(0).getId());
				obj.setSucursal(objFkSucursal);

				AsientosContablesModulosFiltro asientoContableModuloFiltro = new AsientosContablesModulosFiltro();
				int asientoContableModuloIndex = UtilPopulate.getIntegerRandom(0, asientoContableModuloCount.intValue()-1);
				asientoContableModuloFiltro.setOffset(asientoContableModuloIndex);
				asientoContableModuloFiltro.setLimit(1);
				List<AsientosContablesModulos> asientoContableModuloListado = serviceasientoContableModulo.find(asientoContableModuloFiltro);
				AsientoContableModulo objFkAsientoContableModulo  = new AsientoContableModulo();
				objFkAsientoContableModulo.setId(asientoContableModuloListado.get(0).getId());
				obj.setAsientoContableModulo(objFkAsientoContableModulo);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertAsientoContableItem() throws Exception {

		AsientoContableItemService service = AppCX.services().buildAsientoContableItemService();
		AsientoContableService serviceasientoContable = AppCX.services().buildAsientoContableService();
		Long asientoContableCount = serviceasientoContable.count();
		CuentaContableService servicecuentaContable = AppCX.services().buildCuentaContableService();
		Long cuentaContableCount = servicecuentaContable.count();

		for(int i = 0; i < maxRows; i++){

			try {

				AsientoContableItem obj = new AsientoContableItem();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setFecha(new java.util.Date(UtilPopulate.getDateRandom(2000, 2019, true)));

				obj.setDetalle(UtilPopulate.getStringRandom(null, 100, false));

				AsientosContablesFiltro asientoContableFiltro = new AsientosContablesFiltro();
				int asientoContableIndex = UtilPopulate.getIntegerRandom(0, asientoContableCount.intValue()-1);
				asientoContableFiltro.setOffset(asientoContableIndex);
				asientoContableFiltro.setLimit(1);
				List<AsientosContables> asientoContableListado = serviceasientoContable.find(asientoContableFiltro);
				AsientoContable objFkAsientoContable  = new AsientoContable();
				objFkAsientoContable.setId(asientoContableListado.get(0).getId());
				obj.setAsientoContable(objFkAsientoContable);

				CuentasContablesFiltro cuentaContableFiltro = new CuentasContablesFiltro();
				int cuentaContableIndex = UtilPopulate.getIntegerRandom(0, cuentaContableCount.intValue()-1);
				cuentaContableFiltro.setOffset(cuentaContableIndex);
				cuentaContableFiltro.setLimit(1);
				List<CuentasContables> cuentaContableListado = servicecuentaContable.find(cuentaContableFiltro);
				CuentaContable objFkCuentaContable  = new CuentaContable();
				objFkCuentaContable.setId(cuentaContableListado.get(0).getId());
				obj.setCuentaContable(objFkCuentaContable);

				obj.setDebe(UtilPopulate.getBigDecimalRandom(null, null, true, 13, 5));

				obj.setHaber(UtilPopulate.getBigDecimalRandom(null, null, true, 13, 5));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertEmpresa() throws Exception {

		EmpresaService service = AppCX.services().buildEmpresaService();
		EjercicioContableService serviceejercicioContable = AppCX.services().buildEjercicioContableService();
		Long ejercicioContableCount = serviceejercicioContable.count();

		for(int i = 0; i < maxRows; i++){

			try {

				Empresa obj = new Empresa();

				EjerciciosContablesFiltro ejercicioContableFiltro = new EjerciciosContablesFiltro();
				int ejercicioContableIndex = UtilPopulate.getIntegerRandom(0, ejercicioContableCount.intValue()-1);
				ejercicioContableFiltro.setOffset(ejercicioContableIndex);
				ejercicioContableFiltro.setLimit(1);
				List<EjerciciosContables> ejercicioContableListado = serviceejercicioContable.find(ejercicioContableFiltro);
				EjercicioContable objFkEjercicioContable  = new EjercicioContable();
				objFkEjercicioContable.setId(ejercicioContableListado.get(0).getId());
				obj.setEjercicioContable(objFkEjercicioContable);

				obj.setFechaCierreVentas(new java.util.Date(UtilPopulate.getDateRandom(2000, 2019, false)));

				obj.setFechaCierreStock(new java.util.Date(UtilPopulate.getDateRandom(2000, 2019, false)));

				obj.setFechaCierreFondo(new java.util.Date(UtilPopulate.getDateRandom(2000, 2019, false)));

				obj.setFechaCierreCompras(new java.util.Date(UtilPopulate.getDateRandom(2000, 2019, false)));

				obj.setFechaCierreContabilidad(new java.util.Date(UtilPopulate.getDateRandom(2000, 2019, false)));

				obj.setFechaCierreGarantiaDevoluciones(new java.util.Date(UtilPopulate.getDateRandom(2000, 2019, false)));

				obj.setFechaCierreTambos(new java.util.Date(UtilPopulate.getDateRandom(2000, 2019, false)));

				obj.setFechaCierreRRHH(new java.util.Date(UtilPopulate.getDateRandom(2000, 2019, false)));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertMoneda() throws Exception {

		MonedaService service = AppCX.services().buildMonedaService();
		MonedaAFIPService servicemonedaAFIP = AppCX.services().buildMonedaAFIPService();
		Long monedaAFIPCount = servicemonedaAFIP.count();

		for(int i = 0; i < maxRows; i++){

			try {

				Moneda obj = new Moneda();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				obj.setAbreviatura(UtilPopulate.getStringRandom(null, 5, true));

				obj.setCotizacion(UtilPopulate.getBigDecimalRandom(new java.math.BigDecimal("-9999.9999"), new java.math.BigDecimal("99999.9999"), true, 13, 5));

				obj.setCotizacionFecha(new java.sql.Timestamp(UtilPopulate.getDateRandom(2000, 2019, true)));

				obj.setControlActualizacion(new Random().nextBoolean());

				MonedasAFIPFiltro monedaAFIPFiltro = new MonedasAFIPFiltro();
				int monedaAFIPIndex = UtilPopulate.getIntegerRandom(0, monedaAFIPCount.intValue()-1);
				monedaAFIPFiltro.setOffset(monedaAFIPIndex);
				monedaAFIPFiltro.setLimit(1);
				List<MonedasAFIP> monedaAFIPListado = servicemonedaAFIP.find(monedaAFIPFiltro);
				MonedaAFIP objFkMonedaAFIP  = new MonedaAFIP();
				objFkMonedaAFIP.setId(monedaAFIPListado.get(0).getId());
				obj.setMonedaAFIP(objFkMonedaAFIP);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertMonedaCotizacion() throws Exception {

		MonedaCotizacionService service = AppCX.services().buildMonedaCotizacionService();
		MonedaService servicemoneda = AppCX.services().buildMonedaService();
		Long monedaCount = servicemoneda.count();
		UsuarioService serviceusuario = AppCX.services().buildUsuarioService();
		Long usuarioCount = serviceusuario.count();

		for(int i = 0; i < maxRows; i++){

			try {

				MonedaCotizacion obj = new MonedaCotizacion();

				obj.setCotizacionFecha(new java.sql.Timestamp(UtilPopulate.getDateRandom(2000, 2019, true)));

				obj.setCompra(UtilPopulate.getBigDecimalRandom(new java.math.BigDecimal("-9999.9999"), new java.math.BigDecimal("99999.9999"), true, 13, 5));

				obj.setVenta(UtilPopulate.getBigDecimalRandom(new java.math.BigDecimal("-9999.9999"), new java.math.BigDecimal("99999.9999"), true, 13, 5));

				obj.setCotizacionFechaAuditoria(new java.sql.Timestamp(UtilPopulate.getDateRandom(2000, 2019, true)));

				MonedasFiltro monedaFiltro = new MonedasFiltro();
				int monedaIndex = UtilPopulate.getIntegerRandom(0, monedaCount.intValue()-1);
				monedaFiltro.setOffset(monedaIndex);
				monedaFiltro.setLimit(1);
				List<Monedas> monedaListado = servicemoneda.find(monedaFiltro);
				Moneda objFkMoneda  = new Moneda();
				objFkMoneda.setId(monedaListado.get(0).getId());
				obj.setMoneda(objFkMoneda);

				UsuariosFiltro usuarioFiltro = new UsuariosFiltro();
				int usuarioIndex = UtilPopulate.getIntegerRandom(0, usuarioCount.intValue()-1);
				usuarioFiltro.setOffset(usuarioIndex);
				usuarioFiltro.setLimit(1);
				List<Usuarios> usuarioListado = serviceusuario.find(usuarioFiltro);
				Usuario objFkUsuario  = new Usuario();
				objFkUsuario.setId(usuarioListado.get(0).getId());
				obj.setUsuario(objFkUsuario);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertBanco() throws Exception {

		BancoService service = AppCX.services().buildBancoService();

		for(int i = 0; i < maxRows; i++){

			try {

				Banco obj = new Banco();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				obj.setCuit(UtilPopulate.getLongRandom(1L, 99999999999L, true));

				obj.setVigente(new Random().nextBoolean());

				obj.setHoja(UtilPopulate.getIntegerRandom(1, 100, false));

				obj.setPrimeraFila(UtilPopulate.getIntegerRandom(1, 1000, false));

				obj.setUltimaFila(UtilPopulate.getIntegerRandom(1, 1000, false));

				obj.setFecha(UtilPopulate.getStringRandom(null, 3, false));

				obj.setDescripcion(UtilPopulate.getStringRandom(null, 3, false));

				obj.setReferencia1(UtilPopulate.getStringRandom(null, 3, false));

				obj.setImporte(UtilPopulate.getStringRandom(null, 3, false));

				obj.setReferencia2(UtilPopulate.getStringRandom(null, 3, false));

				obj.setSaldo(UtilPopulate.getStringRandom(null, 3, false));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertBancoFirmante() throws Exception {

		BancoFirmanteService service = AppCX.services().buildBancoFirmanteService();

		for(int i = 0; i < maxRows; i++){

			try {

				BancoFirmante obj = new BancoFirmante();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				obj.setCargo(UtilPopulate.getStringRandom(null, 50, false));

				obj.setBloqueado(new Random().nextBoolean());

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertCaja() throws Exception {

		CajaService service = AppCX.services().buildCajaService();
		SeguridadPuertaService serviceseguridadPuerta = AppCX.services().buildSeguridadPuertaService();
		Long seguridadPuertaCount = serviceseguridadPuerta.count();

		for(int i = 0; i < maxRows; i++){

			try {

				Caja obj = new Caja();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				SeguridadPuertasFiltro seguridadPuertaFiltro = new SeguridadPuertasFiltro();
				int seguridadPuertaIndex = UtilPopulate.getIntegerRandom(0, seguridadPuertaCount.intValue()-1);
				seguridadPuertaFiltro.setOffset(seguridadPuertaIndex);
				seguridadPuertaFiltro.setLimit(1);
				List<SeguridadPuertas> seguridadPuertaListado = serviceseguridadPuerta.find(seguridadPuertaFiltro);
				SeguridadPuerta objFkSeguridadPuerta  = new SeguridadPuerta();
				objFkSeguridadPuerta.setId(seguridadPuertaListado.get(0).getId());
				obj.setSeguridadPuerta(objFkSeguridadPuerta);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertCuentaFondoTipo() throws Exception {

		CuentaFondoTipoService service = AppCX.services().buildCuentaFondoTipoService();

		for(int i = 0; i < maxRows; i++){

			try {

				CuentaFondoTipo obj = new CuentaFondoTipo();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertCuentaFondoRubro() throws Exception {

		CuentaFondoRubroService service = AppCX.services().buildCuentaFondoRubroService();

		for(int i = 0; i < maxRows; i++){

			try {

				CuentaFondoRubro obj = new CuentaFondoRubro();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertCuentaFondoGrupo() throws Exception {

		CuentaFondoGrupoService service = AppCX.services().buildCuentaFondoGrupoService();
		CuentaFondoRubroService servicecuentaFondoRubro = AppCX.services().buildCuentaFondoRubroService();
		Long cuentaFondoRubroCount = servicecuentaFondoRubro.count();

		for(int i = 0; i < maxRows; i++){

			try {

				CuentaFondoGrupo obj = new CuentaFondoGrupo();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				CuentasFondosRubrosFiltro cuentaFondoRubroFiltro = new CuentasFondosRubrosFiltro();
				int cuentaFondoRubroIndex = UtilPopulate.getIntegerRandom(0, cuentaFondoRubroCount.intValue()-1);
				cuentaFondoRubroFiltro.setOffset(cuentaFondoRubroIndex);
				cuentaFondoRubroFiltro.setLimit(1);
				List<CuentasFondosRubros> cuentaFondoRubroListado = servicecuentaFondoRubro.find(cuentaFondoRubroFiltro);
				CuentaFondoRubro objFkCuentaFondoRubro  = new CuentaFondoRubro();
				objFkCuentaFondoRubro.setId(cuentaFondoRubroListado.get(0).getId());
				obj.setCuentaFondoRubro(objFkCuentaFondoRubro);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertCuentaFondoTipoBanco() throws Exception {

		CuentaFondoTipoBancoService service = AppCX.services().buildCuentaFondoTipoBancoService();

		for(int i = 0; i < maxRows; i++){

			try {

				CuentaFondoTipoBanco obj = new CuentaFondoTipoBanco();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertCuentaFondoBancoCopia() throws Exception {

		CuentaFondoBancoCopiaService service = AppCX.services().buildCuentaFondoBancoCopiaService();

		for(int i = 0; i < maxRows; i++){

			try {

				CuentaFondoBancoCopia obj = new CuentaFondoBancoCopia();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertCuentaFondo() throws Exception {

		CuentaFondoService service = AppCX.services().buildCuentaFondoService();
		CuentaContableService servicecuentaContable = AppCX.services().buildCuentaContableService();
		Long cuentaContableCount = servicecuentaContable.count();
		CuentaFondoGrupoService servicecuentaFondoGrupo = AppCX.services().buildCuentaFondoGrupoService();
		Long cuentaFondoGrupoCount = servicecuentaFondoGrupo.count();
		CuentaFondoTipoService servicecuentaFondoTipo = AppCX.services().buildCuentaFondoTipoService();
		Long cuentaFondoTipoCount = servicecuentaFondoTipo.count();
		MonedaService servicemoneda = AppCX.services().buildMonedaService();
		Long monedaCount = servicemoneda.count();
		CajaService servicecaja = AppCX.services().buildCajaService();
		Long cajaCount = servicecaja.count();
		CuentaFondoTipoBancoService servicecuentaFondoTipoBanco = AppCX.services().buildCuentaFondoTipoBancoService();
		Long cuentaFondoTipoBancoCount = servicecuentaFondoTipoBanco.count();
		BancoService servicebanco = AppCX.services().buildBancoService();
		Long bancoCount = servicebanco.count();
		CuentaFondoBancoCopiaService servicecuentaFondoBancoCopia = AppCX.services().buildCuentaFondoBancoCopiaService();
		Long cuentaFondoBancoCopiaCount = servicecuentaFondoBancoCopia.count();
		SeguridadPuertaService serviceseguridadPuertaUso = AppCX.services().buildSeguridadPuertaService();
		Long seguridadPuertaUsoCount = serviceseguridadPuertaUso.count();
		SeguridadPuertaService serviceseguridadPuertaConsulta = AppCX.services().buildSeguridadPuertaService();
		Long seguridadPuertaConsultaCount = serviceseguridadPuertaConsulta.count();
		SeguridadPuertaService serviceseguridadPuertaLimite = AppCX.services().buildSeguridadPuertaService();
		Long seguridadPuertaLimiteCount = serviceseguridadPuertaLimite.count();

		for(int i = 0; i < maxRows; i++){

			try {

				CuentaFondo obj = new CuentaFondo();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				CuentasContablesFiltro cuentaContableFiltro = new CuentasContablesFiltro();
				int cuentaContableIndex = UtilPopulate.getIntegerRandom(0, cuentaContableCount.intValue()-1);
				cuentaContableFiltro.setOffset(cuentaContableIndex);
				cuentaContableFiltro.setLimit(1);
				List<CuentasContables> cuentaContableListado = servicecuentaContable.find(cuentaContableFiltro);
				CuentaContable objFkCuentaContable  = new CuentaContable();
				objFkCuentaContable.setId(cuentaContableListado.get(0).getId());
				obj.setCuentaContable(objFkCuentaContable);

				CuentasFondosGruposFiltro cuentaFondoGrupoFiltro = new CuentasFondosGruposFiltro();
				int cuentaFondoGrupoIndex = UtilPopulate.getIntegerRandom(0, cuentaFondoGrupoCount.intValue()-1);
				cuentaFondoGrupoFiltro.setOffset(cuentaFondoGrupoIndex);
				cuentaFondoGrupoFiltro.setLimit(1);
				List<CuentasFondosGrupos> cuentaFondoGrupoListado = servicecuentaFondoGrupo.find(cuentaFondoGrupoFiltro);
				CuentaFondoGrupo objFkCuentaFondoGrupo  = new CuentaFondoGrupo();
				objFkCuentaFondoGrupo.setId(cuentaFondoGrupoListado.get(0).getId());
				obj.setCuentaFondoGrupo(objFkCuentaFondoGrupo);

				CuentasFondosTiposFiltro cuentaFondoTipoFiltro = new CuentasFondosTiposFiltro();
				int cuentaFondoTipoIndex = UtilPopulate.getIntegerRandom(0, cuentaFondoTipoCount.intValue()-1);
				cuentaFondoTipoFiltro.setOffset(cuentaFondoTipoIndex);
				cuentaFondoTipoFiltro.setLimit(1);
				List<CuentasFondosTipos> cuentaFondoTipoListado = servicecuentaFondoTipo.find(cuentaFondoTipoFiltro);
				CuentaFondoTipo objFkCuentaFondoTipo  = new CuentaFondoTipo();
				objFkCuentaFondoTipo.setId(cuentaFondoTipoListado.get(0).getId());
				obj.setCuentaFondoTipo(objFkCuentaFondoTipo);

				obj.setObsoleto(new Random().nextBoolean());

				obj.setNoImprimeCaja(new Random().nextBoolean());

				obj.setVentas(new Random().nextBoolean());

				obj.setFondos(new Random().nextBoolean());

				obj.setCompras(new Random().nextBoolean());

				MonedasFiltro monedaFiltro = new MonedasFiltro();
				int monedaIndex = UtilPopulate.getIntegerRandom(0, monedaCount.intValue()-1);
				monedaFiltro.setOffset(monedaIndex);
				monedaFiltro.setLimit(1);
				List<Monedas> monedaListado = servicemoneda.find(monedaFiltro);
				Moneda objFkMoneda  = new Moneda();
				objFkMoneda.setId(monedaListado.get(0).getId());
				obj.setMoneda(objFkMoneda);

				CajasFiltro cajaFiltro = new CajasFiltro();
				int cajaIndex = UtilPopulate.getIntegerRandom(0, cajaCount.intValue()-1);
				cajaFiltro.setOffset(cajaIndex);
				cajaFiltro.setLimit(1);
				List<Cajas> cajaListado = servicecaja.find(cajaFiltro);
				Caja objFkCaja  = new Caja();
				objFkCaja.setId(cajaListado.get(0).getId());
				obj.setCaja(objFkCaja);

				obj.setRechazados(new Random().nextBoolean());

				obj.setConciliacion(new Random().nextBoolean());

				CuentasFondosTiposBancosFiltro cuentaFondoTipoBancoFiltro = new CuentasFondosTiposBancosFiltro();
				int cuentaFondoTipoBancoIndex = UtilPopulate.getIntegerRandom(0, cuentaFondoTipoBancoCount.intValue()-1);
				cuentaFondoTipoBancoFiltro.setOffset(cuentaFondoTipoBancoIndex);
				cuentaFondoTipoBancoFiltro.setLimit(1);
				List<CuentasFondosTiposBancos> cuentaFondoTipoBancoListado = servicecuentaFondoTipoBanco.find(cuentaFondoTipoBancoFiltro);
				CuentaFondoTipoBanco objFkCuentaFondoTipoBanco  = new CuentaFondoTipoBanco();
				objFkCuentaFondoTipoBanco.setId(cuentaFondoTipoBancoListado.get(0).getId());
				obj.setCuentaFondoTipoBanco(objFkCuentaFondoTipoBanco);

				BancosFiltro bancoFiltro = new BancosFiltro();
				int bancoIndex = UtilPopulate.getIntegerRandom(0, bancoCount.intValue()-1);
				bancoFiltro.setOffset(bancoIndex);
				bancoFiltro.setLimit(1);
				List<Bancos> bancoListado = servicebanco.find(bancoFiltro);
				Banco objFkBanco  = new Banco();
				objFkBanco.setId(bancoListado.get(0).getId());
				obj.setBanco(objFkBanco);

				obj.setCuentaBancaria(UtilPopulate.getStringRandom(null, 22, false));

				obj.setCbu(UtilPopulate.getStringRandom(null, 22, false));

				obj.setLimiteDescubierto(UtilPopulate.getBigDecimalRandom(new java.math.BigDecimal("-9999.9999"), new java.math.BigDecimal("99999.9999"), false, 13, 5));

				obj.setCuentaFondoCaucion(UtilPopulate.getStringRandom(null, 50, false));

				obj.setCuentaFondoDiferidos(UtilPopulate.getStringRandom(null, 50, false));

				obj.setFormato(UtilPopulate.getStringRandom(null, 50, false));

				CuentasFondosBancosCopiasFiltro cuentaFondoBancoCopiaFiltro = new CuentasFondosBancosCopiasFiltro();
				int cuentaFondoBancoCopiaIndex = UtilPopulate.getIntegerRandom(0, cuentaFondoBancoCopiaCount.intValue()-1);
				cuentaFondoBancoCopiaFiltro.setOffset(cuentaFondoBancoCopiaIndex);
				cuentaFondoBancoCopiaFiltro.setLimit(1);
				List<CuentasFondosBancosCopias> cuentaFondoBancoCopiaListado = servicecuentaFondoBancoCopia.find(cuentaFondoBancoCopiaFiltro);
				CuentaFondoBancoCopia objFkCuentaFondoBancoCopia  = new CuentaFondoBancoCopia();
				objFkCuentaFondoBancoCopia.setId(cuentaFondoBancoCopiaListado.get(0).getId());
				obj.setCuentaFondoBancoCopia(objFkCuentaFondoBancoCopia);

				obj.setLimiteOperacionIndividual(UtilPopulate.getBigDecimalRandom(new java.math.BigDecimal("-9999.9999"), new java.math.BigDecimal("99999.9999"), false, 13, 5));

				SeguridadPuertasFiltro seguridadPuertaUsoFiltro = new SeguridadPuertasFiltro();
				int seguridadPuertaUsoIndex = UtilPopulate.getIntegerRandom(0, seguridadPuertaUsoCount.intValue()-1);
				seguridadPuertaUsoFiltro.setOffset(seguridadPuertaUsoIndex);
				seguridadPuertaUsoFiltro.setLimit(1);
				List<SeguridadPuertas> seguridadPuertaUsoListado = serviceseguridadPuertaUso.find(seguridadPuertaUsoFiltro);
				SeguridadPuerta objFkSeguridadPuertaUso  = new SeguridadPuerta();
				objFkSeguridadPuertaUso.setId(seguridadPuertaUsoListado.get(0).getId());
				obj.setSeguridadPuertaUso(objFkSeguridadPuertaUso);

				SeguridadPuertasFiltro seguridadPuertaConsultaFiltro = new SeguridadPuertasFiltro();
				int seguridadPuertaConsultaIndex = UtilPopulate.getIntegerRandom(0, seguridadPuertaConsultaCount.intValue()-1);
				seguridadPuertaConsultaFiltro.setOffset(seguridadPuertaConsultaIndex);
				seguridadPuertaConsultaFiltro.setLimit(1);
				List<SeguridadPuertas> seguridadPuertaConsultaListado = serviceseguridadPuertaConsulta.find(seguridadPuertaConsultaFiltro);
				SeguridadPuerta objFkSeguridadPuertaConsulta  = new SeguridadPuerta();
				objFkSeguridadPuertaConsulta.setId(seguridadPuertaConsultaListado.get(0).getId());
				obj.setSeguridadPuertaConsulta(objFkSeguridadPuertaConsulta);

				SeguridadPuertasFiltro seguridadPuertaLimiteFiltro = new SeguridadPuertasFiltro();
				int seguridadPuertaLimiteIndex = UtilPopulate.getIntegerRandom(0, seguridadPuertaLimiteCount.intValue()-1);
				seguridadPuertaLimiteFiltro.setOffset(seguridadPuertaLimiteIndex);
				seguridadPuertaLimiteFiltro.setLimit(1);
				List<SeguridadPuertas> seguridadPuertaLimiteListado = serviceseguridadPuertaLimite.find(seguridadPuertaLimiteFiltro);
				SeguridadPuerta objFkSeguridadPuertaLimite  = new SeguridadPuerta();
				objFkSeguridadPuertaLimite.setId(seguridadPuertaLimiteListado.get(0).getId());
				obj.setSeguridadPuertaLimite(objFkSeguridadPuertaLimite);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertComprobanteFondoModelo() throws Exception {

		ComprobanteFondoModeloService service = AppCX.services().buildComprobanteFondoModeloService();

		for(int i = 0; i < maxRows; i++){

			try {

				ComprobanteFondoModelo obj = new ComprobanteFondoModelo();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertComprobanteFondoModeloItem() throws Exception {

		ComprobanteFondoModeloItemService service = AppCX.services().buildComprobanteFondoModeloItemService();
		ComprobanteFondoModeloService servicecomprobanteFondoModelo = AppCX.services().buildComprobanteFondoModeloService();
		Long comprobanteFondoModeloCount = servicecomprobanteFondoModelo.count();
		CuentaFondoService servicecuentaFondo = AppCX.services().buildCuentaFondoService();
		Long cuentaFondoCount = servicecuentaFondo.count();

		for(int i = 0; i < maxRows; i++){

			try {

				ComprobanteFondoModeloItem obj = new ComprobanteFondoModeloItem();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setDebe(new Random().nextBoolean());

				ComprobantesFondosModelosFiltro comprobanteFondoModeloFiltro = new ComprobantesFondosModelosFiltro();
				int comprobanteFondoModeloIndex = UtilPopulate.getIntegerRandom(0, comprobanteFondoModeloCount.intValue()-1);
				comprobanteFondoModeloFiltro.setOffset(comprobanteFondoModeloIndex);
				comprobanteFondoModeloFiltro.setLimit(1);
				List<ComprobantesFondosModelos> comprobanteFondoModeloListado = servicecomprobanteFondoModelo.find(comprobanteFondoModeloFiltro);
				ComprobanteFondoModelo objFkComprobanteFondoModelo  = new ComprobanteFondoModelo();
				objFkComprobanteFondoModelo.setId(comprobanteFondoModeloListado.get(0).getId());
				obj.setComprobanteFondoModelo(objFkComprobanteFondoModelo);

				CuentasFondosFiltro cuentaFondoFiltro = new CuentasFondosFiltro();
				int cuentaFondoIndex = UtilPopulate.getIntegerRandom(0, cuentaFondoCount.intValue()-1);
				cuentaFondoFiltro.setOffset(cuentaFondoIndex);
				cuentaFondoFiltro.setLimit(1);
				List<CuentasFondos> cuentaFondoListado = servicecuentaFondo.find(cuentaFondoFiltro);
				CuentaFondo objFkCuentaFondo  = new CuentaFondo();
				objFkCuentaFondo.setId(cuentaFondoListado.get(0).getId());
				obj.setCuentaFondo(objFkCuentaFondo);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertTalonarioLetra() throws Exception {

		TalonarioLetraService service = AppCX.services().buildTalonarioLetraService();

		for(int i = 0; i < maxRows; i++){

			try {

				TalonarioLetra obj = new TalonarioLetra();

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertTalonarioControladorFizcal() throws Exception {

		TalonarioControladorFizcalService service = AppCX.services().buildTalonarioControladorFizcalService();

		for(int i = 0; i < maxRows; i++){

			try {

				TalonarioControladorFizcal obj = new TalonarioControladorFizcal();

				obj.setCodigo(UtilPopulate.getStringRandom(null, 10, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertTalonario() throws Exception {

		TalonarioService service = AppCX.services().buildTalonarioService();
		TalonarioLetraService servicetalonarioLetra = AppCX.services().buildTalonarioLetraService();
		Long talonarioLetraCount = servicetalonarioLetra.count();
		TalonarioControladorFizcalService servicetalonarioControladorFizcal = AppCX.services().buildTalonarioControladorFizcalService();
		Long talonarioControladorFizcalCount = servicetalonarioControladorFizcal.count();

		for(int i = 0; i < maxRows; i++){

			try {

				Talonario obj = new Talonario();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				TalonariosLetrasFiltro talonarioLetraFiltro = new TalonariosLetrasFiltro();
				int talonarioLetraIndex = UtilPopulate.getIntegerRandom(0, talonarioLetraCount.intValue()-1);
				talonarioLetraFiltro.setOffset(talonarioLetraIndex);
				talonarioLetraFiltro.setLimit(1);
				List<TalonariosLetras> talonarioLetraListado = servicetalonarioLetra.find(talonarioLetraFiltro);
				TalonarioLetra objFkTalonarioLetra  = new TalonarioLetra();
				objFkTalonarioLetra.setId(talonarioLetraListado.get(0).getId());
				obj.setTalonarioLetra(objFkTalonarioLetra);

				obj.setPuntoVenta(UtilPopulate.getIntegerRandom(1, 9999, true));

				obj.setAutonumeracion(new Random().nextBoolean());

				obj.setNumeracionPreImpresa(new Random().nextBoolean());

				obj.setAsociadoRG10098(new Random().nextBoolean());

				TalonariosControladoresFizcalesFiltro talonarioControladorFizcalFiltro = new TalonariosControladoresFizcalesFiltro();
				int talonarioControladorFizcalIndex = UtilPopulate.getIntegerRandom(0, talonarioControladorFizcalCount.intValue()-1);
				talonarioControladorFizcalFiltro.setOffset(talonarioControladorFizcalIndex);
				talonarioControladorFizcalFiltro.setLimit(1);
				List<TalonariosControladoresFizcales> talonarioControladorFizcalListado = servicetalonarioControladorFizcal.find(talonarioControladorFizcalFiltro);
				TalonarioControladorFizcal objFkTalonarioControladorFizcal  = new TalonarioControladorFizcal();
				objFkTalonarioControladorFizcal.setId(talonarioControladorFizcalListado.get(0).getId());
				obj.setTalonarioControladorFizcal(objFkTalonarioControladorFizcal);

				obj.setPrimerNumero(UtilPopulate.getIntegerRandom(1, null, false));

				obj.setProximoNumero(UtilPopulate.getIntegerRandom(1, null, false));

				obj.setUltimoNumero(UtilPopulate.getIntegerRandom(1, null, false));

				obj.setCantidadMinimaComprobantes(UtilPopulate.getIntegerRandom(1, null, false));

				obj.setFecha(new java.util.Date(UtilPopulate.getDateRandom(2000, 2019, false)));

				obj.setNumeroCAI(UtilPopulate.getLongRandom(1L, 99999999999999L, false));

				obj.setVencimiento(new java.util.Date(UtilPopulate.getDateRandom(2000, 2019, false)));

				obj.setDiasAvisoVencimiento(UtilPopulate.getIntegerRandom(1, null, false));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertTicketControlDenunciados() throws Exception {

		TicketControlDenunciadosService service = AppCX.services().buildTicketControlDenunciadosService();

		for(int i = 0; i < maxRows; i++){

			try {

				TicketControlDenunciados obj = new TicketControlDenunciados();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertTicket() throws Exception {

		TicketService service = AppCX.services().buildTicketService();
		TicketControlDenunciadosService serviceticketControlDenunciados = AppCX.services().buildTicketControlDenunciadosService();
		Long ticketControlDenunciadosCount = serviceticketControlDenunciados.count();

		for(int i = 0; i < maxRows; i++){

			try {

				Ticket obj = new Ticket();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				obj.setFechaActualizacion(new java.util.Date(UtilPopulate.getDateRandom(2000, 2019, false)));

				obj.setCantidadPorLotes(UtilPopulate.getIntegerRandom(1, null, false));

				TicketsControlesDenunciadosFiltro ticketControlDenunciadosFiltro = new TicketsControlesDenunciadosFiltro();
				int ticketControlDenunciadosIndex = UtilPopulate.getIntegerRandom(0, ticketControlDenunciadosCount.intValue()-1);
				ticketControlDenunciadosFiltro.setOffset(ticketControlDenunciadosIndex);
				ticketControlDenunciadosFiltro.setLimit(1);
				List<TicketsControlesDenunciados> ticketControlDenunciadosListado = serviceticketControlDenunciados.find(ticketControlDenunciadosFiltro);
				TicketControlDenunciados objFkTicketControlDenunciados  = new TicketControlDenunciados();
				objFkTicketControlDenunciados.setId(ticketControlDenunciadosListado.get(0).getId());
				obj.setTicketControlDenunciados(objFkTicketControlDenunciados);

				obj.setValorMaximo(UtilPopulate.getBigDecimalRandom(new java.math.BigDecimal("0"), new java.math.BigDecimal("99999.9999"), false, 13, 5));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertTicketModelo() throws Exception {

		TicketModeloService service = AppCX.services().buildTicketModeloService();
		TicketService serviceticket = AppCX.services().buildTicketService();
		Long ticketCount = serviceticket.count();

		for(int i = 0; i < maxRows; i++){

			try {

				TicketModelo obj = new TicketModelo();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				TicketsFiltro ticketFiltro = new TicketsFiltro();
				int ticketIndex = UtilPopulate.getIntegerRandom(0, ticketCount.intValue()-1);
				ticketFiltro.setOffset(ticketIndex);
				ticketFiltro.setLimit(1);
				List<Tickets> ticketListado = serviceticket.find(ticketFiltro);
				Ticket objFkTicket  = new Ticket();
				objFkTicket.setId(ticketListado.get(0).getId());
				obj.setTicket(objFkTicket);

				obj.setPruebaLectura(UtilPopulate.getStringRandom(null, 50, false));

				obj.setActivo(new Random().nextBoolean());

				obj.setLongitudLectura(UtilPopulate.getIntegerRandom(0, null, false));

				obj.setIdentificacionPosicion(UtilPopulate.getIntegerRandom(0, null, false));

				obj.setIdentificacion(UtilPopulate.getIntegerRandom(0, null, false));

				obj.setImportePosicion(UtilPopulate.getIntegerRandom(0, null, false));

				obj.setLongitud(UtilPopulate.getIntegerRandom(0, null, false));

				obj.setCantidadDecimales(UtilPopulate.getIntegerRandom(0, null, false));

				obj.setNumeroPosicion(UtilPopulate.getIntegerRandom(0, null, false));

				obj.setNumeroLongitud(UtilPopulate.getIntegerRandom(0, null, false));

				obj.setPrefijoIdentificacion(UtilPopulate.getStringRandom(null, 10, false));

				obj.setPosicionPrefijo(UtilPopulate.getIntegerRandom(0, null, false));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertJuridiccionConvnioMultilateral() throws Exception {

		JuridiccionConvnioMultilateralService service = AppCX.services().buildJuridiccionConvnioMultilateralService();
		CuentaFondoService servicecuentaFondo = AppCX.services().buildCuentaFondoService();
		Long cuentaFondoCount = servicecuentaFondo.count();

		for(int i = 0; i < maxRows; i++){

			try {

				JuridiccionConvnioMultilateral obj = new JuridiccionConvnioMultilateral();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				CuentasFondosFiltro cuentaFondoFiltro = new CuentasFondosFiltro();
				int cuentaFondoIndex = UtilPopulate.getIntegerRandom(0, cuentaFondoCount.intValue()-1);
				cuentaFondoFiltro.setOffset(cuentaFondoIndex);
				cuentaFondoFiltro.setLimit(1);
				List<CuentasFondos> cuentaFondoListado = servicecuentaFondo.find(cuentaFondoFiltro);
				CuentaFondo objFkCuentaFondo  = new CuentaFondo();
				objFkCuentaFondo.setId(cuentaFondoListado.get(0).getId());
				obj.setCuentaFondo(objFkCuentaFondo);

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertChequera() throws Exception {

		ChequeraService service = AppCX.services().buildChequeraService();
		CuentaFondoService servicecuentaFondo = AppCX.services().buildCuentaFondoService();
		Long cuentaFondoCount = servicecuentaFondo.count();

		for(int i = 0; i < maxRows; i++){

			try {

				Chequera obj = new Chequera();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				CuentasFondosFiltro cuentaFondoFiltro = new CuentasFondosFiltro();
				int cuentaFondoIndex = UtilPopulate.getIntegerRandom(0, cuentaFondoCount.intValue()-1);
				cuentaFondoFiltro.setOffset(cuentaFondoIndex);
				cuentaFondoFiltro.setLimit(1);
				List<CuentasFondos> cuentaFondoListado = servicecuentaFondo.find(cuentaFondoFiltro);
				CuentaFondo objFkCuentaFondo  = new CuentaFondo();
				objFkCuentaFondo.setId(cuentaFondoListado.get(0).getId());
				obj.setCuentaFondo(objFkCuentaFondo);

				obj.setPrimerNumero(UtilPopulate.getIntegerRandom(0, null, false));

				obj.setUltimoNumero(UtilPopulate.getIntegerRandom(0, null, false));

				obj.setProximoNumero(UtilPopulate.getIntegerRandom(0, null, false));

				obj.setBloqueado(new Random().nextBoolean());

				obj.setImpresionDiferida(new Random().nextBoolean());

				obj.setFormato(UtilPopulate.getStringRandom(null, 50, false));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertTipoComprobanteConcepto() throws Exception {

		TipoComprobanteConceptoService service = AppCX.services().buildTipoComprobanteConceptoService();

		for(int i = 0; i < maxRows; i++){

			try {

				TipoComprobanteConcepto obj = new TipoComprobanteConcepto();

				obj.setCodigo(UtilPopulate.getStringRandom(null, 3, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertClaseComprobante() throws Exception {

		ClaseComprobanteService service = AppCX.services().buildClaseComprobanteService();

		for(int i = 0; i < maxRows; i++){

			try {

				ClaseComprobante obj = new ClaseComprobante();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertComportamientoComprobante() throws Exception {

		ComportamientoComprobanteService service = AppCX.services().buildComportamientoComprobanteService();

		for(int i = 0; i < maxRows; i++){

			try {

				ComportamientoComprobante obj = new ComportamientoComprobante();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertTipoComprobanteCopia() throws Exception {

		TipoComprobanteCopiaService service = AppCX.services().buildTipoComprobanteCopiaService();

		for(int i = 0; i < maxRows; i++){

			try {

				TipoComprobanteCopia obj = new TipoComprobanteCopia();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}



	public static void insertTipoComprobanteCopiaAlternativo() throws Exception {

		TipoComprobanteCopiaAlternativoService service = AppCX.services().buildTipoComprobanteCopiaAlternativoService();

		for(int i = 0; i < maxRows; i++){

			try {

				TipoComprobanteCopiaAlternativo obj = new TipoComprobanteCopiaAlternativo();

				obj.setNumero(UtilPopulate.getIntegerRandom(1, null, true));

				obj.setNombre(UtilPopulate.getStringRandom(null, 50, true));

				service.insert(obj);

			} catch (org.dsw.jdbc.SQLExceptionWrapper e) {

				if(("23505".equals(e.getSQLState()) || "23502".equals(e.getSQLState()) || "23514".equals(e.getSQLState()) ) == false ) {	

					throw e;

				}

			}

		}

	}


}