
package com.massoftware.service;

import java.util.List;

import org.dsw.jdbc.DataSourceWrapper;
import org.sorm.pg.DataBasePG;


import com.massoftware.service.seguridad.Usuarios;
import com.massoftware.service.seguridad.UsuariosFiltro;
import com.massoftware.service.seguridad.UsuariosDAO;
import com.massoftware.service.seguridad.SeguridadModulos;
import com.massoftware.service.seguridad.SeguridadModulosFiltro;
import com.massoftware.service.seguridad.SeguridadModulosDAO;
import com.massoftware.service.seguridad.SeguridadPuertas;
import com.massoftware.service.seguridad.SeguridadPuertasFiltro;
import com.massoftware.service.seguridad.SeguridadPuertasDAO;
import com.massoftware.service.geo.Zonas;
import com.massoftware.service.geo.ZonasFiltro;
import com.massoftware.service.geo.ZonasDAO;
import com.massoftware.service.geo.Paises;
import com.massoftware.service.geo.PaisesFiltro;
import com.massoftware.service.geo.PaisesDAO;
import com.massoftware.service.geo.Provincias;
import com.massoftware.service.geo.ProvinciasFiltro;
import com.massoftware.service.geo.ProvinciasDAO;
import com.massoftware.service.geo.Ciudades;
import com.massoftware.service.geo.CiudadesFiltro;
import com.massoftware.service.geo.CiudadesDAO;
import com.massoftware.service.geo.CodigosPostales;
import com.massoftware.service.geo.CodigosPostalesFiltro;
import com.massoftware.service.geo.CodigosPostalesDAO;
import com.massoftware.service.logistica.Transportes;
import com.massoftware.service.logistica.TransportesFiltro;
import com.massoftware.service.logistica.TransportesDAO;
import com.massoftware.service.logistica.Cargas;
import com.massoftware.service.logistica.CargasFiltro;
import com.massoftware.service.logistica.CargasDAO;
import com.massoftware.service.logistica.TransportesTarifas;
import com.massoftware.service.logistica.TransportesTarifasFiltro;
import com.massoftware.service.logistica.TransportesTarifasDAO;
import com.massoftware.service.afip.TiposDocumentosAFIP;
import com.massoftware.service.afip.TiposDocumentosAFIPFiltro;
import com.massoftware.service.afip.TiposDocumentosAFIPDAO;
import com.massoftware.service.afip.MonedasAFIP;
import com.massoftware.service.afip.MonedasAFIPFiltro;
import com.massoftware.service.afip.MonedasAFIPDAO;
import com.massoftware.service.contabilidad.ventas.NotasCreditoMotivo;
import com.massoftware.service.contabilidad.ventas.NotasCreditoMotivoFiltro;
import com.massoftware.service.contabilidad.ventas.NotasCreditoMotivoDAO;
import com.massoftware.service.clientes.MotivosComentario;
import com.massoftware.service.clientes.MotivosComentarioFiltro;
import com.massoftware.service.clientes.MotivosComentarioDAO;
import com.massoftware.service.clientes.TiposClientes;
import com.massoftware.service.clientes.TiposClientesFiltro;
import com.massoftware.service.clientes.TiposClientesDAO;
import com.massoftware.service.clientes.ClasificacionesClientes;
import com.massoftware.service.clientes.ClasificacionesClientesFiltro;
import com.massoftware.service.clientes.ClasificacionesClientesDAO;
import com.massoftware.service.clientes.MotivosBloqueosClientes;
import com.massoftware.service.clientes.MotivosBloqueosClientesFiltro;
import com.massoftware.service.clientes.MotivosBloqueosClientesDAO;
import com.massoftware.service.empresa.TiposSucursales;
import com.massoftware.service.empresa.TiposSucursalesFiltro;
import com.massoftware.service.empresa.TiposSucursalesDAO;
import com.massoftware.service.empresa.Sucursales;
import com.massoftware.service.empresa.SucursalesFiltro;
import com.massoftware.service.empresa.SucursalesDAO;
import com.massoftware.service.empresa.DepositosModulos;
import com.massoftware.service.empresa.DepositosModulosFiltro;
import com.massoftware.service.empresa.DepositosModulosDAO;
import com.massoftware.service.empresa.Depositos;
import com.massoftware.service.empresa.DepositosFiltro;
import com.massoftware.service.empresa.DepositosDAO;
import com.massoftware.service.contabilidad.EjerciciosContables;
import com.massoftware.service.contabilidad.EjerciciosContablesFiltro;
import com.massoftware.service.contabilidad.EjerciciosContablesDAO;
import com.massoftware.service.contabilidad.CentrosCostosContables;
import com.massoftware.service.contabilidad.CentrosCostosContablesFiltro;
import com.massoftware.service.contabilidad.CentrosCostosContablesDAO;
import com.massoftware.service.contabilidad.TiposPuntosEquilibrios;
import com.massoftware.service.contabilidad.TiposPuntosEquilibriosFiltro;
import com.massoftware.service.contabilidad.TiposPuntosEquilibriosDAO;
import com.massoftware.service.contabilidad.PuntosEquilibrios;
import com.massoftware.service.contabilidad.PuntosEquilibriosFiltro;
import com.massoftware.service.contabilidad.PuntosEquilibriosDAO;
import com.massoftware.service.contabilidad.CostosVentas;
import com.massoftware.service.contabilidad.CostosVentasFiltro;
import com.massoftware.service.contabilidad.CostosVentasDAO;
import com.massoftware.service.contabilidad.CuentasContablesEstados;
import com.massoftware.service.contabilidad.CuentasContablesEstadosFiltro;
import com.massoftware.service.contabilidad.CuentasContablesEstadosDAO;
import com.massoftware.service.contabilidad.CuentasContables;
import com.massoftware.service.contabilidad.CuentasContablesFiltro;
import com.massoftware.service.contabilidad.CuentasContablesDAO;
import com.massoftware.service.contabilidad.AsientosModelos;
import com.massoftware.service.contabilidad.AsientosModelosFiltro;
import com.massoftware.service.contabilidad.AsientosModelosDAO;
import com.massoftware.service.contabilidad.AsientosModelosItems;
import com.massoftware.service.contabilidad.AsientosModelosItemsFiltro;
import com.massoftware.service.contabilidad.AsientosModelosItemsDAO;
import com.massoftware.service.contabilidad.MinutasContables;
import com.massoftware.service.contabilidad.MinutasContablesFiltro;
import com.massoftware.service.contabilidad.MinutasContablesDAO;
import com.massoftware.service.contabilidad.AsientosContablesModulos;
import com.massoftware.service.contabilidad.AsientosContablesModulosFiltro;
import com.massoftware.service.contabilidad.AsientosContablesModulosDAO;
import com.massoftware.service.contabilidad.AsientosContables;
import com.massoftware.service.contabilidad.AsientosContablesFiltro;
import com.massoftware.service.contabilidad.AsientosContablesDAO;
import com.massoftware.service.contabilidad.AsientosContablesItems;
import com.massoftware.service.contabilidad.AsientosContablesItemsFiltro;
import com.massoftware.service.contabilidad.AsientosContablesItemsDAO;
import com.massoftware.service.empresa.Empresas;
import com.massoftware.service.empresa.EmpresasFiltro;
import com.massoftware.service.empresa.EmpresasDAO;
import com.massoftware.service.monedas.Monedas;
import com.massoftware.service.monedas.MonedasFiltro;
import com.massoftware.service.monedas.MonedasDAO;
import com.massoftware.service.monedas.MonedasCotizaciones;
import com.massoftware.service.monedas.MonedasCotizacionesFiltro;
import com.massoftware.service.monedas.MonedasCotizacionesDAO;
import com.massoftware.service.fondos.banco.Bancos;
import com.massoftware.service.fondos.banco.BancosFiltro;
import com.massoftware.service.fondos.banco.BancosDAO;
import com.massoftware.service.fondos.banco.BancosFirmantes;
import com.massoftware.service.fondos.banco.BancosFirmantesFiltro;
import com.massoftware.service.fondos.banco.BancosFirmantesDAO;
import com.massoftware.service.fondos.Cajas;
import com.massoftware.service.fondos.CajasFiltro;
import com.massoftware.service.fondos.CajasDAO;
import com.massoftware.service.fondos.CuentasFondosTipos;
import com.massoftware.service.fondos.CuentasFondosTiposFiltro;
import com.massoftware.service.fondos.CuentasFondosTiposDAO;
import com.massoftware.service.fondos.CuentasFondosRubros;
import com.massoftware.service.fondos.CuentasFondosRubrosFiltro;
import com.massoftware.service.fondos.CuentasFondosRubrosDAO;
import com.massoftware.service.fondos.CuentasFondosGrupos;
import com.massoftware.service.fondos.CuentasFondosGruposFiltro;
import com.massoftware.service.fondos.CuentasFondosGruposDAO;
import com.massoftware.service.fondos.CuentasFondosTiposBancos;
import com.massoftware.service.fondos.CuentasFondosTiposBancosFiltro;
import com.massoftware.service.fondos.CuentasFondosTiposBancosDAO;
import com.massoftware.service.fondos.CuentasFondosBancosCopias;
import com.massoftware.service.fondos.CuentasFondosBancosCopiasFiltro;
import com.massoftware.service.fondos.CuentasFondosBancosCopiasDAO;
import com.massoftware.service.fondos.CuentasFondos;
import com.massoftware.service.fondos.CuentasFondosFiltro;
import com.massoftware.service.fondos.CuentasFondosDAO;
import com.massoftware.service.fondos.ComprobantesFondosModelos;
import com.massoftware.service.fondos.ComprobantesFondosModelosFiltro;
import com.massoftware.service.fondos.ComprobantesFondosModelosDAO;
import com.massoftware.service.fondos.ComprobantesFondosModelosItems;
import com.massoftware.service.fondos.ComprobantesFondosModelosItemsFiltro;
import com.massoftware.service.fondos.ComprobantesFondosModelosItemsDAO;
import com.massoftware.service.fondos.TalonariosLetras;
import com.massoftware.service.fondos.TalonariosLetrasFiltro;
import com.massoftware.service.fondos.TalonariosLetrasDAO;
import com.massoftware.service.fondos.TalonariosControladoresFizcales;
import com.massoftware.service.fondos.TalonariosControladoresFizcalesFiltro;
import com.massoftware.service.fondos.TalonariosControladoresFizcalesDAO;
import com.massoftware.service.fondos.Talonarios;
import com.massoftware.service.fondos.TalonariosFiltro;
import com.massoftware.service.fondos.TalonariosDAO;
import com.massoftware.service.fondos.TicketsControlesDenunciados;
import com.massoftware.service.fondos.TicketsControlesDenunciadosFiltro;
import com.massoftware.service.fondos.TicketsControlesDenunciadosDAO;
import com.massoftware.service.fondos.Tickets;
import com.massoftware.service.fondos.TicketsFiltro;
import com.massoftware.service.fondos.TicketsDAO;
import com.massoftware.service.fondos.TicketsModelos;
import com.massoftware.service.fondos.TicketsModelosFiltro;
import com.massoftware.service.fondos.TicketsModelosDAO;
import com.massoftware.service.fondos.JuridiccionesConvniosMultilaterales;
import com.massoftware.service.fondos.JuridiccionesConvniosMultilateralesFiltro;
import com.massoftware.service.fondos.JuridiccionesConvniosMultilateralesDAO;
import com.massoftware.service.fondos.Chequeras;
import com.massoftware.service.fondos.ChequerasFiltro;
import com.massoftware.service.fondos.ChequerasDAO;
import com.massoftware.service.fondos.TiposComprobantesConceptos;
import com.massoftware.service.fondos.TiposComprobantesConceptosFiltro;
import com.massoftware.service.fondos.TiposComprobantesConceptosDAO;
import com.massoftware.service.fondos.ClasesComprobantes;
import com.massoftware.service.fondos.ClasesComprobantesFiltro;
import com.massoftware.service.fondos.ClasesComprobantesDAO;
import com.massoftware.service.fondos.ComportamientosComprobantes;
import com.massoftware.service.fondos.ComportamientosComprobantesFiltro;
import com.massoftware.service.fondos.ComportamientosComprobantesDAO;
import com.massoftware.service.fondos.TiposComprobantesCopias;
import com.massoftware.service.fondos.TiposComprobantesCopiasFiltro;
import com.massoftware.service.fondos.TiposComprobantesCopiasDAO;
import com.massoftware.service.fondos.TiposComprobantesCopiasAlternativos;
import com.massoftware.service.fondos.TiposComprobantesCopiasAlternativosFiltro;
import com.massoftware.service.fondos.TiposComprobantesCopiasAlternativosDAO;

public class DataBase extends DataBasePG {

	
	private UsuariosDAO usuariosDAO;
	private SeguridadModulosDAO seguridadModulosDAO;
	private SeguridadPuertasDAO seguridadPuertasDAO;
	private ZonasDAO zonasDAO;
	private PaisesDAO paisesDAO;
	private ProvinciasDAO provinciasDAO;
	private CiudadesDAO ciudadesDAO;
	private CodigosPostalesDAO codigosPostalesDAO;
	private TransportesDAO transportesDAO;
	private CargasDAO cargasDAO;
	private TransportesTarifasDAO transportesTarifasDAO;
	private TiposDocumentosAFIPDAO tiposDocumentosAFIPDAO;
	private MonedasAFIPDAO monedasAFIPDAO;
	private NotasCreditoMotivoDAO notasCreditoMotivoDAO;
	private MotivosComentarioDAO motivosComentarioDAO;
	private TiposClientesDAO tiposClientesDAO;
	private ClasificacionesClientesDAO clasificacionesClientesDAO;
	private MotivosBloqueosClientesDAO motivosBloqueosClientesDAO;
	private TiposSucursalesDAO tiposSucursalesDAO;
	private SucursalesDAO sucursalesDAO;
	private DepositosModulosDAO depositosModulosDAO;
	private DepositosDAO depositosDAO;
	private EjerciciosContablesDAO ejerciciosContablesDAO;
	private CentrosCostosContablesDAO centrosCostosContablesDAO;
	private TiposPuntosEquilibriosDAO tiposPuntosEquilibriosDAO;
	private PuntosEquilibriosDAO puntosEquilibriosDAO;
	private CostosVentasDAO costosVentasDAO;
	private CuentasContablesEstadosDAO cuentasContablesEstadosDAO;
	private CuentasContablesDAO cuentasContablesDAO;
	private AsientosModelosDAO asientosModelosDAO;
	private AsientosModelosItemsDAO asientosModelosItemsDAO;
	private MinutasContablesDAO minutasContablesDAO;
	private AsientosContablesModulosDAO asientosContablesModulosDAO;
	private AsientosContablesDAO asientosContablesDAO;
	private AsientosContablesItemsDAO asientosContablesItemsDAO;
	private EmpresasDAO empresasDAO;
	private MonedasDAO monedasDAO;
	private MonedasCotizacionesDAO monedasCotizacionesDAO;
	private BancosDAO bancosDAO;
	private BancosFirmantesDAO bancosFirmantesDAO;
	private CajasDAO cajasDAO;
	private CuentasFondosTiposDAO cuentasFondosTiposDAO;
	private CuentasFondosRubrosDAO cuentasFondosRubrosDAO;
	private CuentasFondosGruposDAO cuentasFondosGruposDAO;
	private CuentasFondosTiposBancosDAO cuentasFondosTiposBancosDAO;
	private CuentasFondosBancosCopiasDAO cuentasFondosBancosCopiasDAO;
	private CuentasFondosDAO cuentasFondosDAO;
	private ComprobantesFondosModelosDAO comprobantesFondosModelosDAO;
	private ComprobantesFondosModelosItemsDAO comprobantesFondosModelosItemsDAO;
	private TalonariosLetrasDAO talonariosLetrasDAO;
	private TalonariosControladoresFizcalesDAO talonariosControladoresFizcalesDAO;
	private TalonariosDAO talonariosDAO;
	private TicketsControlesDenunciadosDAO ticketsControlesDenunciadosDAO;
	private TicketsDAO ticketsDAO;
	private TicketsModelosDAO ticketsModelosDAO;
	private JuridiccionesConvniosMultilateralesDAO juridiccionesConvniosMultilateralesDAO;
	private ChequerasDAO chequerasDAO;
	private TiposComprobantesConceptosDAO tiposComprobantesConceptosDAO;
	private ClasesComprobantesDAO clasesComprobantesDAO;
	private ComportamientosComprobantesDAO comportamientosComprobantesDAO;
	private TiposComprobantesCopiasDAO tiposComprobantesCopiasDAO;
	private TiposComprobantesCopiasAlternativosDAO tiposComprobantesCopiasAlternativosDAO;

	public DataBase(DataSourceWrapper dataSourceWrapper, String schema) {
		super(dataSourceWrapper, schema);		
		
		usuariosDAO = new UsuariosDAO();
		seguridadModulosDAO = new SeguridadModulosDAO();
		seguridadPuertasDAO = new SeguridadPuertasDAO();
		zonasDAO = new ZonasDAO();
		paisesDAO = new PaisesDAO();
		provinciasDAO = new ProvinciasDAO();
		ciudadesDAO = new CiudadesDAO();
		codigosPostalesDAO = new CodigosPostalesDAO();
		transportesDAO = new TransportesDAO();
		cargasDAO = new CargasDAO();
		transportesTarifasDAO = new TransportesTarifasDAO();
		tiposDocumentosAFIPDAO = new TiposDocumentosAFIPDAO();
		monedasAFIPDAO = new MonedasAFIPDAO();
		notasCreditoMotivoDAO = new NotasCreditoMotivoDAO();
		motivosComentarioDAO = new MotivosComentarioDAO();
		tiposClientesDAO = new TiposClientesDAO();
		clasificacionesClientesDAO = new ClasificacionesClientesDAO();
		motivosBloqueosClientesDAO = new MotivosBloqueosClientesDAO();
		tiposSucursalesDAO = new TiposSucursalesDAO();
		sucursalesDAO = new SucursalesDAO();
		depositosModulosDAO = new DepositosModulosDAO();
		depositosDAO = new DepositosDAO();
		ejerciciosContablesDAO = new EjerciciosContablesDAO();
		centrosCostosContablesDAO = new CentrosCostosContablesDAO();
		tiposPuntosEquilibriosDAO = new TiposPuntosEquilibriosDAO();
		puntosEquilibriosDAO = new PuntosEquilibriosDAO();
		costosVentasDAO = new CostosVentasDAO();
		cuentasContablesEstadosDAO = new CuentasContablesEstadosDAO();
		cuentasContablesDAO = new CuentasContablesDAO();
		asientosModelosDAO = new AsientosModelosDAO();
		asientosModelosItemsDAO = new AsientosModelosItemsDAO();
		minutasContablesDAO = new MinutasContablesDAO();
		asientosContablesModulosDAO = new AsientosContablesModulosDAO();
		asientosContablesDAO = new AsientosContablesDAO();
		asientosContablesItemsDAO = new AsientosContablesItemsDAO();
		empresasDAO = new EmpresasDAO();
		monedasDAO = new MonedasDAO();
		monedasCotizacionesDAO = new MonedasCotizacionesDAO();
		bancosDAO = new BancosDAO();
		bancosFirmantesDAO = new BancosFirmantesDAO();
		cajasDAO = new CajasDAO();
		cuentasFondosTiposDAO = new CuentasFondosTiposDAO();
		cuentasFondosRubrosDAO = new CuentasFondosRubrosDAO();
		cuentasFondosGruposDAO = new CuentasFondosGruposDAO();
		cuentasFondosTiposBancosDAO = new CuentasFondosTiposBancosDAO();
		cuentasFondosBancosCopiasDAO = new CuentasFondosBancosCopiasDAO();
		cuentasFondosDAO = new CuentasFondosDAO();
		comprobantesFondosModelosDAO = new ComprobantesFondosModelosDAO();
		comprobantesFondosModelosItemsDAO = new ComprobantesFondosModelosItemsDAO();
		talonariosLetrasDAO = new TalonariosLetrasDAO();
		talonariosControladoresFizcalesDAO = new TalonariosControladoresFizcalesDAO();
		talonariosDAO = new TalonariosDAO();
		ticketsControlesDenunciadosDAO = new TicketsControlesDenunciadosDAO();
		ticketsDAO = new TicketsDAO();
		ticketsModelosDAO = new TicketsModelosDAO();
		juridiccionesConvniosMultilateralesDAO = new JuridiccionesConvniosMultilateralesDAO();
		chequerasDAO = new ChequerasDAO();
		tiposComprobantesConceptosDAO = new TiposComprobantesConceptosDAO();
		clasesComprobantesDAO = new ClasesComprobantesDAO();
		comportamientosComprobantesDAO = new ComportamientosComprobantesDAO();
		tiposComprobantesCopiasDAO = new TiposComprobantesCopiasDAO();
		tiposComprobantesCopiasAlternativosDAO = new TiposComprobantesCopiasAlternativosDAO();
	}
	
	

	public List<Usuarios> findUsuarios(UsuariosFiltro f) throws Exception {
		return usuariosDAO.find(connectionWrapper, f);
	}

	public Integer countUsuarios(UsuariosFiltro f) throws Exception {
		return usuariosDAO.count(connectionWrapper, f);
	}

	public List<SeguridadModulos> findSeguridadModulos(SeguridadModulosFiltro f) throws Exception {
		return seguridadModulosDAO.find(connectionWrapper, f);
	}

	public Integer countSeguridadModulos(SeguridadModulosFiltro f) throws Exception {
		return seguridadModulosDAO.count(connectionWrapper, f);
	}

	public List<SeguridadPuertas> findSeguridadPuertas(SeguridadPuertasFiltro f) throws Exception {
		return seguridadPuertasDAO.find(connectionWrapper, f);
	}

	public Integer countSeguridadPuertas(SeguridadPuertasFiltro f) throws Exception {
		return seguridadPuertasDAO.count(connectionWrapper, f);
	}

	public List<Zonas> findZonas(ZonasFiltro f) throws Exception {
		return zonasDAO.find(connectionWrapper, f);
	}

	public Integer countZonas(ZonasFiltro f) throws Exception {
		return zonasDAO.count(connectionWrapper, f);
	}

	public List<Paises> findPaises(PaisesFiltro f) throws Exception {
		return paisesDAO.find(connectionWrapper, f);
	}

	public Integer countPaises(PaisesFiltro f) throws Exception {
		return paisesDAO.count(connectionWrapper, f);
	}

	public List<Provincias> findProvincias(ProvinciasFiltro f) throws Exception {
		return provinciasDAO.find(connectionWrapper, f);
	}

	public Integer countProvincias(ProvinciasFiltro f) throws Exception {
		return provinciasDAO.count(connectionWrapper, f);
	}

	public List<Ciudades> findCiudades(CiudadesFiltro f) throws Exception {
		return ciudadesDAO.find(connectionWrapper, f);
	}

	public Integer countCiudades(CiudadesFiltro f) throws Exception {
		return ciudadesDAO.count(connectionWrapper, f);
	}

	public List<CodigosPostales> findCodigosPostales(CodigosPostalesFiltro f) throws Exception {
		return codigosPostalesDAO.find(connectionWrapper, f);
	}

	public Integer countCodigosPostales(CodigosPostalesFiltro f) throws Exception {
		return codigosPostalesDAO.count(connectionWrapper, f);
	}

	public List<Transportes> findTransportes(TransportesFiltro f) throws Exception {
		return transportesDAO.find(connectionWrapper, f);
	}

	public Integer countTransportes(TransportesFiltro f) throws Exception {
		return transportesDAO.count(connectionWrapper, f);
	}

	public List<Cargas> findCargas(CargasFiltro f) throws Exception {
		return cargasDAO.find(connectionWrapper, f);
	}

	public Integer countCargas(CargasFiltro f) throws Exception {
		return cargasDAO.count(connectionWrapper, f);
	}

	public List<TransportesTarifas> findTransportesTarifas(TransportesTarifasFiltro f) throws Exception {
		return transportesTarifasDAO.find(connectionWrapper, f);
	}

	public Integer countTransportesTarifas(TransportesTarifasFiltro f) throws Exception {
		return transportesTarifasDAO.count(connectionWrapper, f);
	}

	public List<TiposDocumentosAFIP> findTiposDocumentosAFIP(TiposDocumentosAFIPFiltro f) throws Exception {
		return tiposDocumentosAFIPDAO.find(connectionWrapper, f);
	}

	public Integer countTiposDocumentosAFIP(TiposDocumentosAFIPFiltro f) throws Exception {
		return tiposDocumentosAFIPDAO.count(connectionWrapper, f);
	}

	public List<MonedasAFIP> findMonedasAFIP(MonedasAFIPFiltro f) throws Exception {
		return monedasAFIPDAO.find(connectionWrapper, f);
	}

	public Integer countMonedasAFIP(MonedasAFIPFiltro f) throws Exception {
		return monedasAFIPDAO.count(connectionWrapper, f);
	}

	public List<NotasCreditoMotivo> findNotasCreditoMotivo(NotasCreditoMotivoFiltro f) throws Exception {
		return notasCreditoMotivoDAO.find(connectionWrapper, f);
	}

	public Integer countNotasCreditoMotivo(NotasCreditoMotivoFiltro f) throws Exception {
		return notasCreditoMotivoDAO.count(connectionWrapper, f);
	}

	public List<MotivosComentario> findMotivosComentario(MotivosComentarioFiltro f) throws Exception {
		return motivosComentarioDAO.find(connectionWrapper, f);
	}

	public Integer countMotivosComentario(MotivosComentarioFiltro f) throws Exception {
		return motivosComentarioDAO.count(connectionWrapper, f);
	}

	public List<TiposClientes> findTiposClientes(TiposClientesFiltro f) throws Exception {
		return tiposClientesDAO.find(connectionWrapper, f);
	}

	public Integer countTiposClientes(TiposClientesFiltro f) throws Exception {
		return tiposClientesDAO.count(connectionWrapper, f);
	}

	public List<ClasificacionesClientes> findClasificacionesClientes(ClasificacionesClientesFiltro f) throws Exception {
		return clasificacionesClientesDAO.find(connectionWrapper, f);
	}

	public Integer countClasificacionesClientes(ClasificacionesClientesFiltro f) throws Exception {
		return clasificacionesClientesDAO.count(connectionWrapper, f);
	}

	public List<MotivosBloqueosClientes> findMotivosBloqueosClientes(MotivosBloqueosClientesFiltro f) throws Exception {
		return motivosBloqueosClientesDAO.find(connectionWrapper, f);
	}

	public Integer countMotivosBloqueosClientes(MotivosBloqueosClientesFiltro f) throws Exception {
		return motivosBloqueosClientesDAO.count(connectionWrapper, f);
	}

	public List<TiposSucursales> findTiposSucursales(TiposSucursalesFiltro f) throws Exception {
		return tiposSucursalesDAO.find(connectionWrapper, f);
	}

	public Integer countTiposSucursales(TiposSucursalesFiltro f) throws Exception {
		return tiposSucursalesDAO.count(connectionWrapper, f);
	}

	public List<Sucursales> findSucursales(SucursalesFiltro f) throws Exception {
		return sucursalesDAO.find(connectionWrapper, f);
	}

	public Integer countSucursales(SucursalesFiltro f) throws Exception {
		return sucursalesDAO.count(connectionWrapper, f);
	}

	public List<DepositosModulos> findDepositosModulos(DepositosModulosFiltro f) throws Exception {
		return depositosModulosDAO.find(connectionWrapper, f);
	}

	public Integer countDepositosModulos(DepositosModulosFiltro f) throws Exception {
		return depositosModulosDAO.count(connectionWrapper, f);
	}

	public List<Depositos> findDepositos(DepositosFiltro f) throws Exception {
		return depositosDAO.find(connectionWrapper, f);
	}

	public Integer countDepositos(DepositosFiltro f) throws Exception {
		return depositosDAO.count(connectionWrapper, f);
	}

	public List<EjerciciosContables> findEjerciciosContables(EjerciciosContablesFiltro f) throws Exception {
		return ejerciciosContablesDAO.find(connectionWrapper, f);
	}

	public Integer countEjerciciosContables(EjerciciosContablesFiltro f) throws Exception {
		return ejerciciosContablesDAO.count(connectionWrapper, f);
	}

	public List<CentrosCostosContables> findCentrosCostosContables(CentrosCostosContablesFiltro f) throws Exception {
		return centrosCostosContablesDAO.find(connectionWrapper, f);
	}

	public Integer countCentrosCostosContables(CentrosCostosContablesFiltro f) throws Exception {
		return centrosCostosContablesDAO.count(connectionWrapper, f);
	}

	public List<TiposPuntosEquilibrios> findTiposPuntosEquilibrios(TiposPuntosEquilibriosFiltro f) throws Exception {
		return tiposPuntosEquilibriosDAO.find(connectionWrapper, f);
	}

	public Integer countTiposPuntosEquilibrios(TiposPuntosEquilibriosFiltro f) throws Exception {
		return tiposPuntosEquilibriosDAO.count(connectionWrapper, f);
	}

	public List<PuntosEquilibrios> findPuntosEquilibrios(PuntosEquilibriosFiltro f) throws Exception {
		return puntosEquilibriosDAO.find(connectionWrapper, f);
	}

	public Integer countPuntosEquilibrios(PuntosEquilibriosFiltro f) throws Exception {
		return puntosEquilibriosDAO.count(connectionWrapper, f);
	}

	public List<CostosVentas> findCostosVentas(CostosVentasFiltro f) throws Exception {
		return costosVentasDAO.find(connectionWrapper, f);
	}

	public Integer countCostosVentas(CostosVentasFiltro f) throws Exception {
		return costosVentasDAO.count(connectionWrapper, f);
	}

	public List<CuentasContablesEstados> findCuentasContablesEstados(CuentasContablesEstadosFiltro f) throws Exception {
		return cuentasContablesEstadosDAO.find(connectionWrapper, f);
	}

	public Integer countCuentasContablesEstados(CuentasContablesEstadosFiltro f) throws Exception {
		return cuentasContablesEstadosDAO.count(connectionWrapper, f);
	}

	public List<CuentasContables> findCuentasContables(CuentasContablesFiltro f) throws Exception {
		return cuentasContablesDAO.find(connectionWrapper, f);
	}

	public Integer countCuentasContables(CuentasContablesFiltro f) throws Exception {
		return cuentasContablesDAO.count(connectionWrapper, f);
	}

	public List<AsientosModelos> findAsientosModelos(AsientosModelosFiltro f) throws Exception {
		return asientosModelosDAO.find(connectionWrapper, f);
	}

	public Integer countAsientosModelos(AsientosModelosFiltro f) throws Exception {
		return asientosModelosDAO.count(connectionWrapper, f);
	}

	public List<AsientosModelosItems> findAsientosModelosItems(AsientosModelosItemsFiltro f) throws Exception {
		return asientosModelosItemsDAO.find(connectionWrapper, f);
	}

	public Integer countAsientosModelosItems(AsientosModelosItemsFiltro f) throws Exception {
		return asientosModelosItemsDAO.count(connectionWrapper, f);
	}

	public List<MinutasContables> findMinutasContables(MinutasContablesFiltro f) throws Exception {
		return minutasContablesDAO.find(connectionWrapper, f);
	}

	public Integer countMinutasContables(MinutasContablesFiltro f) throws Exception {
		return minutasContablesDAO.count(connectionWrapper, f);
	}

	public List<AsientosContablesModulos> findAsientosContablesModulos(AsientosContablesModulosFiltro f) throws Exception {
		return asientosContablesModulosDAO.find(connectionWrapper, f);
	}

	public Integer countAsientosContablesModulos(AsientosContablesModulosFiltro f) throws Exception {
		return asientosContablesModulosDAO.count(connectionWrapper, f);
	}

	public List<AsientosContables> findAsientosContables(AsientosContablesFiltro f) throws Exception {
		return asientosContablesDAO.find(connectionWrapper, f);
	}

	public Integer countAsientosContables(AsientosContablesFiltro f) throws Exception {
		return asientosContablesDAO.count(connectionWrapper, f);
	}

	public List<AsientosContablesItems> findAsientosContablesItems(AsientosContablesItemsFiltro f) throws Exception {
		return asientosContablesItemsDAO.find(connectionWrapper, f);
	}

	public Integer countAsientosContablesItems(AsientosContablesItemsFiltro f) throws Exception {
		return asientosContablesItemsDAO.count(connectionWrapper, f);
	}

	public List<Empresas> findEmpresas(EmpresasFiltro f) throws Exception {
		return empresasDAO.find(connectionWrapper, f);
	}

	public Integer countEmpresas(EmpresasFiltro f) throws Exception {
		return empresasDAO.count(connectionWrapper, f);
	}

	public List<Monedas> findMonedas(MonedasFiltro f) throws Exception {
		return monedasDAO.find(connectionWrapper, f);
	}

	public Integer countMonedas(MonedasFiltro f) throws Exception {
		return monedasDAO.count(connectionWrapper, f);
	}

	public List<MonedasCotizaciones> findMonedasCotizaciones(MonedasCotizacionesFiltro f) throws Exception {
		return monedasCotizacionesDAO.find(connectionWrapper, f);
	}

	public Integer countMonedasCotizaciones(MonedasCotizacionesFiltro f) throws Exception {
		return monedasCotizacionesDAO.count(connectionWrapper, f);
	}

	public List<Bancos> findBancos(BancosFiltro f) throws Exception {
		return bancosDAO.find(connectionWrapper, f);
	}

	public Integer countBancos(BancosFiltro f) throws Exception {
		return bancosDAO.count(connectionWrapper, f);
	}

	public List<BancosFirmantes> findBancosFirmantes(BancosFirmantesFiltro f) throws Exception {
		return bancosFirmantesDAO.find(connectionWrapper, f);
	}

	public Integer countBancosFirmantes(BancosFirmantesFiltro f) throws Exception {
		return bancosFirmantesDAO.count(connectionWrapper, f);
	}

	public List<Cajas> findCajas(CajasFiltro f) throws Exception {
		return cajasDAO.find(connectionWrapper, f);
	}

	public Integer countCajas(CajasFiltro f) throws Exception {
		return cajasDAO.count(connectionWrapper, f);
	}

	public List<CuentasFondosTipos> findCuentasFondosTipos(CuentasFondosTiposFiltro f) throws Exception {
		return cuentasFondosTiposDAO.find(connectionWrapper, f);
	}

	public Integer countCuentasFondosTipos(CuentasFondosTiposFiltro f) throws Exception {
		return cuentasFondosTiposDAO.count(connectionWrapper, f);
	}

	public List<CuentasFondosRubros> findCuentasFondosRubros(CuentasFondosRubrosFiltro f) throws Exception {
		return cuentasFondosRubrosDAO.find(connectionWrapper, f);
	}

	public Integer countCuentasFondosRubros(CuentasFondosRubrosFiltro f) throws Exception {
		return cuentasFondosRubrosDAO.count(connectionWrapper, f);
	}

	public List<CuentasFondosGrupos> findCuentasFondosGrupos(CuentasFondosGruposFiltro f) throws Exception {
		return cuentasFondosGruposDAO.find(connectionWrapper, f);
	}

	public Integer countCuentasFondosGrupos(CuentasFondosGruposFiltro f) throws Exception {
		return cuentasFondosGruposDAO.count(connectionWrapper, f);
	}

	public List<CuentasFondosTiposBancos> findCuentasFondosTiposBancos(CuentasFondosTiposBancosFiltro f) throws Exception {
		return cuentasFondosTiposBancosDAO.find(connectionWrapper, f);
	}

	public Integer countCuentasFondosTiposBancos(CuentasFondosTiposBancosFiltro f) throws Exception {
		return cuentasFondosTiposBancosDAO.count(connectionWrapper, f);
	}

	public List<CuentasFondosBancosCopias> findCuentasFondosBancosCopias(CuentasFondosBancosCopiasFiltro f) throws Exception {
		return cuentasFondosBancosCopiasDAO.find(connectionWrapper, f);
	}

	public Integer countCuentasFondosBancosCopias(CuentasFondosBancosCopiasFiltro f) throws Exception {
		return cuentasFondosBancosCopiasDAO.count(connectionWrapper, f);
	}

	public List<CuentasFondos> findCuentasFondos(CuentasFondosFiltro f) throws Exception {
		return cuentasFondosDAO.find(connectionWrapper, f);
	}

	public Integer countCuentasFondos(CuentasFondosFiltro f) throws Exception {
		return cuentasFondosDAO.count(connectionWrapper, f);
	}

	public List<ComprobantesFondosModelos> findComprobantesFondosModelos(ComprobantesFondosModelosFiltro f) throws Exception {
		return comprobantesFondosModelosDAO.find(connectionWrapper, f);
	}

	public Integer countComprobantesFondosModelos(ComprobantesFondosModelosFiltro f) throws Exception {
		return comprobantesFondosModelosDAO.count(connectionWrapper, f);
	}

	public List<ComprobantesFondosModelosItems> findComprobantesFondosModelosItems(ComprobantesFondosModelosItemsFiltro f) throws Exception {
		return comprobantesFondosModelosItemsDAO.find(connectionWrapper, f);
	}

	public Integer countComprobantesFondosModelosItems(ComprobantesFondosModelosItemsFiltro f) throws Exception {
		return comprobantesFondosModelosItemsDAO.count(connectionWrapper, f);
	}

	public List<TalonariosLetras> findTalonariosLetras(TalonariosLetrasFiltro f) throws Exception {
		return talonariosLetrasDAO.find(connectionWrapper, f);
	}

	public Integer countTalonariosLetras(TalonariosLetrasFiltro f) throws Exception {
		return talonariosLetrasDAO.count(connectionWrapper, f);
	}

	public List<TalonariosControladoresFizcales> findTalonariosControladoresFizcales(TalonariosControladoresFizcalesFiltro f) throws Exception {
		return talonariosControladoresFizcalesDAO.find(connectionWrapper, f);
	}

	public Integer countTalonariosControladoresFizcales(TalonariosControladoresFizcalesFiltro f) throws Exception {
		return talonariosControladoresFizcalesDAO.count(connectionWrapper, f);
	}

	public List<Talonarios> findTalonarios(TalonariosFiltro f) throws Exception {
		return talonariosDAO.find(connectionWrapper, f);
	}

	public Integer countTalonarios(TalonariosFiltro f) throws Exception {
		return talonariosDAO.count(connectionWrapper, f);
	}

	public List<TicketsControlesDenunciados> findTicketsControlesDenunciados(TicketsControlesDenunciadosFiltro f) throws Exception {
		return ticketsControlesDenunciadosDAO.find(connectionWrapper, f);
	}

	public Integer countTicketsControlesDenunciados(TicketsControlesDenunciadosFiltro f) throws Exception {
		return ticketsControlesDenunciadosDAO.count(connectionWrapper, f);
	}

	public List<Tickets> findTickets(TicketsFiltro f) throws Exception {
		return ticketsDAO.find(connectionWrapper, f);
	}

	public Integer countTickets(TicketsFiltro f) throws Exception {
		return ticketsDAO.count(connectionWrapper, f);
	}

	public List<TicketsModelos> findTicketsModelos(TicketsModelosFiltro f) throws Exception {
		return ticketsModelosDAO.find(connectionWrapper, f);
	}

	public Integer countTicketsModelos(TicketsModelosFiltro f) throws Exception {
		return ticketsModelosDAO.count(connectionWrapper, f);
	}

	public List<JuridiccionesConvniosMultilaterales> findJuridiccionesConvniosMultilaterales(JuridiccionesConvniosMultilateralesFiltro f) throws Exception {
		return juridiccionesConvniosMultilateralesDAO.find(connectionWrapper, f);
	}

	public Integer countJuridiccionesConvniosMultilaterales(JuridiccionesConvniosMultilateralesFiltro f) throws Exception {
		return juridiccionesConvniosMultilateralesDAO.count(connectionWrapper, f);
	}

	public List<Chequeras> findChequeras(ChequerasFiltro f) throws Exception {
		return chequerasDAO.find(connectionWrapper, f);
	}

	public Integer countChequeras(ChequerasFiltro f) throws Exception {
		return chequerasDAO.count(connectionWrapper, f);
	}

	public List<TiposComprobantesConceptos> findTiposComprobantesConceptos(TiposComprobantesConceptosFiltro f) throws Exception {
		return tiposComprobantesConceptosDAO.find(connectionWrapper, f);
	}

	public Integer countTiposComprobantesConceptos(TiposComprobantesConceptosFiltro f) throws Exception {
		return tiposComprobantesConceptosDAO.count(connectionWrapper, f);
	}

	public List<ClasesComprobantes> findClasesComprobantes(ClasesComprobantesFiltro f) throws Exception {
		return clasesComprobantesDAO.find(connectionWrapper, f);
	}

	public Integer countClasesComprobantes(ClasesComprobantesFiltro f) throws Exception {
		return clasesComprobantesDAO.count(connectionWrapper, f);
	}

	public List<ComportamientosComprobantes> findComportamientosComprobantes(ComportamientosComprobantesFiltro f) throws Exception {
		return comportamientosComprobantesDAO.find(connectionWrapper, f);
	}

	public Integer countComportamientosComprobantes(ComportamientosComprobantesFiltro f) throws Exception {
		return comportamientosComprobantesDAO.count(connectionWrapper, f);
	}

	public List<TiposComprobantesCopias> findTiposComprobantesCopias(TiposComprobantesCopiasFiltro f) throws Exception {
		return tiposComprobantesCopiasDAO.find(connectionWrapper, f);
	}

	public Integer countTiposComprobantesCopias(TiposComprobantesCopiasFiltro f) throws Exception {
		return tiposComprobantesCopiasDAO.count(connectionWrapper, f);
	}

	public List<TiposComprobantesCopiasAlternativos> findTiposComprobantesCopiasAlternativos(TiposComprobantesCopiasAlternativosFiltro f) throws Exception {
		return tiposComprobantesCopiasAlternativosDAO.find(connectionWrapper, f);
	}

	public Integer countTiposComprobantesCopiasAlternativos(TiposComprobantesCopiasAlternativosFiltro f) throws Exception {
		return tiposComprobantesCopiasAlternativosDAO.count(connectionWrapper, f);
	}

}