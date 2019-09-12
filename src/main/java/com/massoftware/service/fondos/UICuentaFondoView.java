package com.massoftware.service.fondos;

//import com.vaadin.flow.component.Key;
//import com.vaadin.flow.component.KeyModifier;
//import com.vaadin.flow.component.icon.VaadinIcon;
import java.util.Optional;
import java.util.stream.Collectors;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
//import com.vaadin.flow.data.validator.StringLengthValidator;
//import com.vaadin.flow.data.validator.IntegerRangeValidator;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.component.textfield.NumberField;
import com.massoftware.ui.util.DoubleToIntegerConverter;
import com.vaadin.flow.component.textfield.TextField;
import java.util.List;
import com.vaadin.flow.component.combobox.ComboBox;
import com.massoftware.service.contabilidad.CuentaContable;
import com.massoftware.service.contabilidad.CuentaContableService;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.massoftware.service.monedas.Moneda;
import com.massoftware.service.monedas.MonedaService;
import com.massoftware.service.fondos.banco.Banco;
import com.massoftware.service.fondos.banco.BancoService;
import com.massoftware.ui.util.DoubleToBigDecimalConverter;
import com.massoftware.service.seguridad.SeguridadPuerta;
import com.massoftware.service.seguridad.SeguridadPuertaService;


@PageTitle("Cuenta fondo")
@Route("CuentaFondo")
public class UICuentaFondoView extends VerticalLayout implements HasUrlParameter<String> {

	private CuentaFondoService service;		

	// Binder
	private CuentaFondo item;
	private Binder<CuentaFondo> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private NumberField numero;
	private TextField nombre;
	private ComboBox<CuentaContable> cuentaContable;
	private ComboBox<CuentaFondoGrupo> cuentaFondoGrupo;
	private ComboBox<CuentaFondoTipo> cuentaFondoTipo;
	private Checkbox obsoleto;
	private Checkbox noImprimeCaja;
	private Checkbox ventas;
	private Checkbox fondos;
	private Checkbox compras;
	private ComboBox<Moneda> moneda;
	private ComboBox<Caja> caja;
	private Checkbox rechazados;
	private Checkbox conciliacion;
	private ComboBox<CuentaFondoTipoBanco> cuentaFondoTipoBanco;
	private ComboBox<Banco> banco;
	private TextField cuentaBancaria;
	private TextField cbu;
	private NumberField limiteDescubierto;
	private TextField cuentaFondoCaucion;
	private TextField cuentaFondoDiferidos;
	private TextField formato;
	private ComboBox<CuentaFondoBancoCopia> cuentaFondoBancoCopia;
	private NumberField limiteOperacionIndividual;
	private ComboBox<SeguridadPuerta> seguridadPuertaUso;
	private ComboBox<SeguridadPuerta> seguridadPuertaConsulta;
	private ComboBox<SeguridadPuerta> seguridadPuertaLimite;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UICuentaFondoView() throws Exception {
		service = new CuentaFondoService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new CuentaFondo();
		binder = new Binder<>(CuentaFondo.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// -------------------------------------------------------------------
		// Controls 
		// -------------------------------------------------------------------
		
		buildSave();
		
		buildNumero();
		buildNombre();
		buildCuentaContable();
		buildCuentaFondoGrupo();
		buildCuentaFondoTipo();
		buildObsoleto();
		buildNoImprimeCaja();
		buildVentas();
		buildFondos();
		buildCompras();
		buildMoneda();
		buildCaja();
		buildRechazados();
		buildConciliacion();
		buildCuentaFondoTipoBanco();
		buildBanco();
		buildCuentaBancaria();
		buildCbu();
		buildLimiteDescubierto();
		buildCuentaFondoCaucion();
		buildCuentaFondoDiferidos();
		buildFormato();
		buildCuentaFondoBancoCopia();
		buildLimiteOperacionIndividual();
		buildSeguridadPuertaUso();
		buildSeguridadPuertaConsulta();
		buildSeguridadPuertaLimite();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(numero);
		form.add(nombre);
		form.add(cuentaContable);
		form.add(cuentaFondoGrupo);
		form.add(cuentaFondoTipo);
		form.add(obsoleto);
		form.add(noImprimeCaja);
		form.add(ventas);
		form.add(fondos);
		form.add(compras);
		form.add(moneda);
		form.add(caja);
		form.add(rechazados);
		form.add(conciliacion);
		form.add(cuentaFondoTipoBanco);
		form.add(banco);
		form.add(cuentaBancaria);
		form.add(cbu);
		form.add(limiteDescubierto);
		form.add(cuentaFondoCaucion);
		form.add(cuentaFondoDiferidos);
		form.add(formato);
		form.add(cuentaFondoBancoCopia);
		form.add(limiteOperacionIndividual);
		form.add(seguridadPuertaUso);
		form.add(seguridadPuertaConsulta);
		form.add(seguridadPuertaLimite);
		
		actions = new HorizontalLayout();
		actions.add(save);
		add(actions);
				
		// -------------------------------------------------------------------
	}
	
	private void buildSave() throws Exception {		
		save = new Button("Guardar");
		save.addClickListener(event -> {
			save();
		});		
	}	
	

	private void buildNumero() throws Exception {
		// Nº cuenta
		numero = new NumberField();
		numero.setLabel("Nº cuenta");
		numero.setWidthFull();
		numero.setClearButtonVisible(true);
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		binder.forField(numero)
			.asRequired("Nº cuenta es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(CuentaFondo::getNumero, CuentaFondo::setNumero);
	}

	private void buildNombre() throws Exception {
		// Nombre
		nombre = new TextField();
		nombre.setLabel("Nombre");
		nombre.setWidthFull();
		nombre.setClearButtonVisible(true);
		nombre.setAutoselect(true);
		nombre.setRequired(true);
		binder.forField(nombre)
			.asRequired("Nombre es requerido.")		
			.withValidator(value -> (value != null) ? value.length() <= 50 : true, "El valor tiene que contener menos de 50 caracteres")
			.bind(CuentaFondo::getNombre, CuentaFondo::setNombre);
	}

	private void buildCuentaContable() throws Exception {
		// Cuenta contable
		cuentaContable = new ComboBox<>();
		cuentaContable.setLabel("Cuenta contable");
		cuentaContable.setWidthFull();
		cuentaContable.setRequired(true);
		List<CuentaContable> items = new CuentaContableService().find();
		cuentaContable.setItems(items);
		binder.forField(cuentaContable)
			.asRequired("Cuenta contable es requerido.")		
			.bind(CuentaFondo::getCuentaContable, CuentaFondo::setCuentaContable);
	}

	private void buildCuentaFondoGrupo() throws Exception {
		// Grupo
		cuentaFondoGrupo = new ComboBox<>();
		cuentaFondoGrupo.setLabel("Grupo");
		cuentaFondoGrupo.setWidthFull();
		cuentaFondoGrupo.setRequired(true);
		List<CuentaFondoGrupo> items = new CuentaFondoGrupoService().find();
		cuentaFondoGrupo.setItems(items);
		binder.forField(cuentaFondoGrupo)
			.asRequired("Grupo es requerido.")		
			.bind(CuentaFondo::getCuentaFondoGrupo, CuentaFondo::setCuentaFondoGrupo);
	}

	private void buildCuentaFondoTipo() throws Exception {
		// Tipo
		cuentaFondoTipo = new ComboBox<>();
		cuentaFondoTipo.setLabel("Tipo");
		cuentaFondoTipo.setWidthFull();
		cuentaFondoTipo.setRequired(true);
		List<CuentaFondoTipo> items = new CuentaFondoTipoService().find();
		cuentaFondoTipo.setItems(items);
		binder.forField(cuentaFondoTipo)
			.asRequired("Tipo es requerido.")		
			.bind(CuentaFondo::getCuentaFondoTipo, CuentaFondo::setCuentaFondoTipo);
	}

	private void buildObsoleto() throws Exception {
		// Obsoleto
		obsoleto = new Checkbox();
		obsoleto.setLabel("Obsoleto");
		obsoleto.setWidthFull();
		binder.forField(obsoleto)
			.bind(CuentaFondo::getObsoleto, CuentaFondo::setObsoleto);
	}

	private void buildNoImprimeCaja() throws Exception {
		// No imprime caja
		noImprimeCaja = new Checkbox();
		noImprimeCaja.setLabel("No imprime caja");
		noImprimeCaja.setWidthFull();
		binder.forField(noImprimeCaja)
			.bind(CuentaFondo::getNoImprimeCaja, CuentaFondo::setNoImprimeCaja);
	}

	private void buildVentas() throws Exception {
		// Ventas
		ventas = new Checkbox();
		ventas.setLabel("Ventas");
		ventas.setWidthFull();
		binder.forField(ventas)
			.bind(CuentaFondo::getVentas, CuentaFondo::setVentas);
	}

	private void buildFondos() throws Exception {
		// Fondos
		fondos = new Checkbox();
		fondos.setLabel("Fondos");
		fondos.setWidthFull();
		binder.forField(fondos)
			.bind(CuentaFondo::getFondos, CuentaFondo::setFondos);
	}

	private void buildCompras() throws Exception {
		// Compras
		compras = new Checkbox();
		compras.setLabel("Compras");
		compras.setWidthFull();
		binder.forField(compras)
			.bind(CuentaFondo::getCompras, CuentaFondo::setCompras);
	}

	private void buildMoneda() throws Exception {
		// Moneda
		moneda = new ComboBox<>();
		moneda.setLabel("Moneda");
		moneda.setWidthFull();
		List<Moneda> items = new MonedaService().find();
		moneda.setItems(items);
		binder.forField(moneda)
			.bind(CuentaFondo::getMoneda, CuentaFondo::setMoneda);
	}

	private void buildCaja() throws Exception {
		// Caja
		caja = new ComboBox<>();
		caja.setLabel("Caja");
		caja.setWidthFull();
		List<Caja> items = new CajaService().find();
		caja.setItems(items);
		binder.forField(caja)
			.bind(CuentaFondo::getCaja, CuentaFondo::setCaja);
	}

	private void buildRechazados() throws Exception {
		// Rechazados
		rechazados = new Checkbox();
		rechazados.setLabel("Rechazados");
		rechazados.setWidthFull();
		binder.forField(rechazados)
			.bind(CuentaFondo::getRechazados, CuentaFondo::setRechazados);
	}

	private void buildConciliacion() throws Exception {
		// Conciliación
		conciliacion = new Checkbox();
		conciliacion.setLabel("Conciliación");
		conciliacion.setWidthFull();
		binder.forField(conciliacion)
			.bind(CuentaFondo::getConciliacion, CuentaFondo::setConciliacion);
	}

	private void buildCuentaFondoTipoBanco() throws Exception {
		// Tipo de banco
		cuentaFondoTipoBanco = new ComboBox<>();
		cuentaFondoTipoBanco.setLabel("Tipo de banco");
		cuentaFondoTipoBanco.setWidthFull();
		List<CuentaFondoTipoBanco> items = new CuentaFondoTipoBancoService().find();
		cuentaFondoTipoBanco.setItems(items);
		binder.forField(cuentaFondoTipoBanco)
			.bind(CuentaFondo::getCuentaFondoTipoBanco, CuentaFondo::setCuentaFondoTipoBanco);
	}

	private void buildBanco() throws Exception {
		// banco
		banco = new ComboBox<>();
		banco.setLabel("banco");
		banco.setWidthFull();
		List<Banco> items = new BancoService().find();
		banco.setItems(items);
		binder.forField(banco)
			.bind(CuentaFondo::getBanco, CuentaFondo::setBanco);
	}

	private void buildCuentaBancaria() throws Exception {
		// Cuenta bancaria
		cuentaBancaria = new TextField();
		cuentaBancaria.setLabel("Cuenta bancaria");
		cuentaBancaria.setWidthFull();
		cuentaBancaria.setClearButtonVisible(true);
		cuentaBancaria.setAutoselect(true);
		binder.forField(cuentaBancaria)
			.withValidator(value -> (value != null) ? value.length() <= 22 : true, "El valor tiene que contener menos de 22 caracteres")
			.bind(CuentaFondo::getCuentaBancaria, CuentaFondo::setCuentaBancaria);
	}

	private void buildCbu() throws Exception {
		// CBU
		cbu = new TextField();
		cbu.setLabel("CBU");
		cbu.setWidthFull();
		cbu.setClearButtonVisible(true);
		cbu.setAutoselect(true);
		binder.forField(cbu)
			.withValidator(value -> (value != null) ? value.length() <= 22 : true, "El valor tiene que contener menos de 22 caracteres")
			.bind(CuentaFondo::getCbu, CuentaFondo::setCbu);
	}

	private void buildLimiteDescubierto() throws Exception {
		// Límite descubierto
		limiteDescubierto = new NumberField();
		limiteDescubierto.setLabel("Límite descubierto");
		limiteDescubierto.setWidthFull();
		limiteDescubierto.setClearButtonVisible(true);
		limiteDescubierto.setMin(-9999.9999);
		limiteDescubierto.setMax(99999.9999);
		binder.forField(limiteDescubierto)
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(CuentaFondo::getLimiteDescubierto, CuentaFondo::setLimiteDescubierto);
	}

	private void buildCuentaFondoCaucion() throws Exception {
		// Cuenta fondo caución
		cuentaFondoCaucion = new TextField();
		cuentaFondoCaucion.setLabel("Cuenta fondo caución");
		cuentaFondoCaucion.setWidthFull();
		cuentaFondoCaucion.setClearButtonVisible(true);
		cuentaFondoCaucion.setAutoselect(true);
		binder.forField(cuentaFondoCaucion)
			.withValidator(value -> (value != null) ? value.length() <= 50 : true, "El valor tiene que contener menos de 50 caracteres")
			.bind(CuentaFondo::getCuentaFondoCaucion, CuentaFondo::setCuentaFondoCaucion);
	}

	private void buildCuentaFondoDiferidos() throws Exception {
		// Cuenta fondo diferidos
		cuentaFondoDiferidos = new TextField();
		cuentaFondoDiferidos.setLabel("Cuenta fondo diferidos");
		cuentaFondoDiferidos.setWidthFull();
		cuentaFondoDiferidos.setClearButtonVisible(true);
		cuentaFondoDiferidos.setAutoselect(true);
		binder.forField(cuentaFondoDiferidos)
			.withValidator(value -> (value != null) ? value.length() <= 50 : true, "El valor tiene que contener menos de 50 caracteres")
			.bind(CuentaFondo::getCuentaFondoDiferidos, CuentaFondo::setCuentaFondoDiferidos);
	}

	private void buildFormato() throws Exception {
		// Formato
		formato = new TextField();
		formato.setLabel("Formato");
		formato.setWidthFull();
		formato.setClearButtonVisible(true);
		formato.setAutoselect(true);
		binder.forField(formato)
			.withValidator(value -> (value != null) ? value.length() <= 50 : true, "El valor tiene que contener menos de 50 caracteres")
			.bind(CuentaFondo::getFormato, CuentaFondo::setFormato);
	}

	private void buildCuentaFondoBancoCopia() throws Exception {
		// Tipo de copias
		cuentaFondoBancoCopia = new ComboBox<>();
		cuentaFondoBancoCopia.setLabel("Tipo de copias");
		cuentaFondoBancoCopia.setWidthFull();
		List<CuentaFondoBancoCopia> items = new CuentaFondoBancoCopiaService().find();
		cuentaFondoBancoCopia.setItems(items);
		binder.forField(cuentaFondoBancoCopia)
			.bind(CuentaFondo::getCuentaFondoBancoCopia, CuentaFondo::setCuentaFondoBancoCopia);
	}

	private void buildLimiteOperacionIndividual() throws Exception {
		// Límite operación individual
		limiteOperacionIndividual = new NumberField();
		limiteOperacionIndividual.setLabel("Límite operación individual");
		limiteOperacionIndividual.setWidthFull();
		limiteOperacionIndividual.setClearButtonVisible(true);
		limiteOperacionIndividual.setMin(-9999.9999);
		limiteOperacionIndividual.setMax(99999.9999);
		binder.forField(limiteOperacionIndividual)
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(CuentaFondo::getLimiteOperacionIndividual, CuentaFondo::setLimiteOperacionIndividual);
	}

	private void buildSeguridadPuertaUso() throws Exception {
		// Puerta p/ uso
		seguridadPuertaUso = new ComboBox<>();
		seguridadPuertaUso.setLabel("Puerta p/ uso");
		seguridadPuertaUso.setWidthFull();
		List<SeguridadPuerta> items = new SeguridadPuertaService().find();
		seguridadPuertaUso.setItems(items);
		binder.forField(seguridadPuertaUso)
			.bind(CuentaFondo::getSeguridadPuertaUso, CuentaFondo::setSeguridadPuertaUso);
	}

	private void buildSeguridadPuertaConsulta() throws Exception {
		// Puerta p/ consulta
		seguridadPuertaConsulta = new ComboBox<>();
		seguridadPuertaConsulta.setLabel("Puerta p/ consulta");
		seguridadPuertaConsulta.setWidthFull();
		List<SeguridadPuerta> items = new SeguridadPuertaService().find();
		seguridadPuertaConsulta.setItems(items);
		binder.forField(seguridadPuertaConsulta)
			.bind(CuentaFondo::getSeguridadPuertaConsulta, CuentaFondo::setSeguridadPuertaConsulta);
	}

	private void buildSeguridadPuertaLimite() throws Exception {
		// Puerta p/ superar límite
		seguridadPuertaLimite = new ComboBox<>();
		seguridadPuertaLimite.setLabel("Puerta p/ superar límite");
		seguridadPuertaLimite.setWidthFull();
		List<SeguridadPuerta> items = new SeguridadPuertaService().find();
		seguridadPuertaLimite.setItems(items);
		binder.forField(seguridadPuertaLimite)
			.bind(CuentaFondo::getSeguridadPuertaLimite, CuentaFondo::setSeguridadPuertaLimite);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<CuentaFondo> validate = binder.validate();
		        String errorText = validate.getFieldValidationStatuses()
		                .stream().filter(BindingValidationStatus::isError)
		                .map(BindingValidationStatus::getMessage)
		                .map(Optional::get).distinct()
		                .collect(Collectors.joining(", "));
		        
		        Notification.show("Uno o mas valores del ítem son incorrectos." + errorText);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}
	
	public void save() {

		try {

			binder.validate();

			if (binder.isValid()) {								
				item = service.update(item);
				Notification.show("El ítem '" + item + "' se guardo con éxito !");
				search(item.getId());
			} else {								
				BinderValidationStatus<CuentaFondo> validate = binder.validate();
		        String errorText = validate.getFieldValidationStatuses()
		                .stream().filter(BindingValidationStatus::isError)
		                .map(BindingValidationStatus::getMessage)
		                .map(Optional::get).distinct()
		                .collect(Collectors.joining(", "));
		        
		        Notification.show("Uno o mas valores del ítem son incorrectos." + errorText);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo guardar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}