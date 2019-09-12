package com.massoftware.service.contabilidad;

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

import com.vaadin.flow.component.textfield.TextField;
import java.util.List;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.textfield.NumberField;
import com.massoftware.service.seguridad.SeguridadPuerta;
import com.massoftware.service.seguridad.SeguridadPuertaService;


@PageTitle("Cuenta contable")
@Route("CuentaContable")
public class UICuentaContableView extends VerticalLayout implements HasUrlParameter<String> {

	private CuentaContableService service;		

	// Binder
	private CuentaContable item;
	private Binder<CuentaContable> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private TextField codigo;
	private TextField nombre;
	private ComboBox<EjercicioContable> ejercicioContable;
	private TextField integra;
	private TextField cuentaJerarquia;
	private Checkbox imputable;
	private Checkbox ajustaPorInflacion;
	private ComboBox<CuentaContableEstado> cuentaContableEstado;
	private Checkbox cuentaConApropiacion;
	private ComboBox<CentroCostoContable> centroCostoContable;
	private TextField cuentaAgrupadora;
	private NumberField porcentaje;
	private ComboBox<PuntoEquilibrio> puntoEquilibrio;
	private ComboBox<CostoVenta> costoVenta;
	private ComboBox<SeguridadPuerta> seguridadPuerta;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UICuentaContableView() throws Exception {
		service = new CuentaContableService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new CuentaContable();
		binder = new Binder<>(CuentaContable.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// -------------------------------------------------------------------
		// Controls 
		// -------------------------------------------------------------------
		
		buildSave();
		
		buildCodigo();
		buildNombre();
		buildEjercicioContable();
		buildIntegra();
		buildCuentaJerarquia();
		buildImputable();
		buildAjustaPorInflacion();
		buildCuentaContableEstado();
		buildCuentaConApropiacion();
		buildCentroCostoContable();
		buildCuentaAgrupadora();
		buildPorcentaje();
		buildPuntoEquilibrio();
		buildCostoVenta();
		buildSeguridadPuerta();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(codigo);
		form.add(nombre);
		form.add(ejercicioContable);
		form.add(integra);
		form.add(cuentaJerarquia);
		form.add(imputable);
		form.add(ajustaPorInflacion);
		form.add(cuentaContableEstado);
		form.add(cuentaConApropiacion);
		form.add(centroCostoContable);
		form.add(cuentaAgrupadora);
		form.add(porcentaje);
		form.add(puntoEquilibrio);
		form.add(costoVenta);
		form.add(seguridadPuerta);
		
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
	

	private void buildCodigo() throws Exception {
		// Cuenta contable
		codigo = new TextField();
		codigo.setLabel("Cuenta contable");
		codigo.setWidthFull();
		codigo.setClearButtonVisible(true);
		codigo.setAutoselect(true);
		codigo.setRequired(true);
		binder.forField(codigo)
			.asRequired("Cuenta contable es requerido.")		
			.withValidator(value -> (value != null) ? value.length() <= 11 : true, "El valor tiene que contener menos de 11 caracteres")
			.bind(CuentaContable::getCodigo, CuentaContable::setCodigo);
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
			.bind(CuentaContable::getNombre, CuentaContable::setNombre);
	}

	private void buildEjercicioContable() throws Exception {
		// Ejercicio
		ejercicioContable = new ComboBox<>();
		ejercicioContable.setLabel("Ejercicio");
		ejercicioContable.setWidthFull();
		ejercicioContable.setReadOnly(true);
		ejercicioContable.setRequired(true);
		List<EjercicioContable> items = new EjercicioContableService().find();
		ejercicioContable.setItems(items);
		binder.forField(ejercicioContable)
			.asRequired("Ejercicio es requerido.")		
			.bind(CuentaContable::getEjercicioContable, CuentaContable::setEjercicioContable);
	}

	private void buildIntegra() throws Exception {
		// Integra
		integra = new TextField();
		integra.setLabel("Integra");
		integra.setWidthFull();
		integra.setReadOnly(true);
		integra.setClearButtonVisible(true);
		integra.setAutoselect(true);
		integra.setRequired(true);
		binder.forField(integra)
			.asRequired("Integra es requerido.")		
			.withValidator(value -> (value != null) ? value.length() >= 16 : true, "El valor tiene que contener al menos 16 caracteres")
			.withValidator(value -> (value != null) ? value.length() <= 16 : true, "El valor tiene que contener menos de 16 caracteres")
			.bind(CuentaContable::getIntegra, CuentaContable::setIntegra);
	}

	private void buildCuentaJerarquia() throws Exception {
		// Cuenta de jerarquia
		cuentaJerarquia = new TextField();
		cuentaJerarquia.setLabel("Cuenta de jerarquia");
		cuentaJerarquia.setWidthFull();
		cuentaJerarquia.setReadOnly(true);
		cuentaJerarquia.setClearButtonVisible(true);
		cuentaJerarquia.setAutoselect(true);
		cuentaJerarquia.setRequired(true);
		binder.forField(cuentaJerarquia)
			.asRequired("Cuenta de jerarquia es requerido.")		
			.withValidator(value -> (value != null) ? value.length() >= 16 : true, "El valor tiene que contener al menos 16 caracteres")
			.withValidator(value -> (value != null) ? value.length() <= 16 : true, "El valor tiene que contener menos de 16 caracteres")
			.bind(CuentaContable::getCuentaJerarquia, CuentaContable::setCuentaJerarquia);
	}

	private void buildImputable() throws Exception {
		// Imputable
		imputable = new Checkbox();
		imputable.setLabel("Imputable");
		imputable.setWidthFull();
		binder.forField(imputable)
			.bind(CuentaContable::getImputable, CuentaContable::setImputable);
	}

	private void buildAjustaPorInflacion() throws Exception {
		// Ajusta por inflación
		ajustaPorInflacion = new Checkbox();
		ajustaPorInflacion.setLabel("Ajusta por inflación");
		ajustaPorInflacion.setWidthFull();
		binder.forField(ajustaPorInflacion)
			.bind(CuentaContable::getAjustaPorInflacion, CuentaContable::setAjustaPorInflacion);
	}

	private void buildCuentaContableEstado() throws Exception {
		// Estado
		cuentaContableEstado = new ComboBox<>();
		cuentaContableEstado.setLabel("Estado");
		cuentaContableEstado.setWidthFull();
		cuentaContableEstado.setRequired(true);
		List<CuentaContableEstado> items = new CuentaContableEstadoService().find();
		cuentaContableEstado.setItems(items);
		binder.forField(cuentaContableEstado)
			.asRequired("Estado es requerido.")		
			.bind(CuentaContable::getCuentaContableEstado, CuentaContable::setCuentaContableEstado);
	}

	private void buildCuentaConApropiacion() throws Exception {
		// Cuenta con apropiación
		cuentaConApropiacion = new Checkbox();
		cuentaConApropiacion.setLabel("Cuenta con apropiación");
		cuentaConApropiacion.setWidthFull();
		binder.forField(cuentaConApropiacion)
			.bind(CuentaContable::getCuentaConApropiacion, CuentaContable::setCuentaConApropiacion);
	}

	private void buildCentroCostoContable() throws Exception {
		// Estado
		centroCostoContable = new ComboBox<>();
		centroCostoContable.setLabel("Estado");
		centroCostoContable.setWidthFull();
		List<CentroCostoContable> items = new CentroCostoContableService().find();
		centroCostoContable.setItems(items);
		binder.forField(centroCostoContable)
			.bind(CuentaContable::getCentroCostoContable, CuentaContable::setCentroCostoContable);
	}

	private void buildCuentaAgrupadora() throws Exception {
		// Cuenta agrupadora
		cuentaAgrupadora = new TextField();
		cuentaAgrupadora.setLabel("Cuenta agrupadora");
		cuentaAgrupadora.setWidthFull();
		cuentaAgrupadora.setClearButtonVisible(true);
		cuentaAgrupadora.setAutoselect(true);
		binder.forField(cuentaAgrupadora)
			.withValidator(value -> (value != null) ? value.length() <= 50 : true, "El valor tiene que contener menos de 50 caracteres")
			.bind(CuentaContable::getCuentaAgrupadora, CuentaContable::setCuentaAgrupadora);
	}

	private void buildPorcentaje() throws Exception {
		// Porcentaje
		porcentaje = new NumberField();
		porcentaje.setLabel("Porcentaje");
		porcentaje.setWidthFull();
		porcentaje.setClearButtonVisible(true);
		porcentaje.setMin(0.0);
		porcentaje.setMax(999.99);
		binder.forField(porcentaje)
			.withValidator(value -> (value != null) ? value >= 0.0 : true, "El valor tiene que ser >= 0.0")
			.withValidator(value -> (value != null) ? value <= 999.99 : true,"El valor tiene que ser <= " + 999.99)
			.bind(CuentaContable::getPorcentaje, CuentaContable::setPorcentaje);
	}

	private void buildPuntoEquilibrio() throws Exception {
		// Punto de equilibrio
		puntoEquilibrio = new ComboBox<>();
		puntoEquilibrio.setLabel("Punto de equilibrio");
		puntoEquilibrio.setWidthFull();
		List<PuntoEquilibrio> items = new PuntoEquilibrioService().find();
		puntoEquilibrio.setItems(items);
		binder.forField(puntoEquilibrio)
			.bind(CuentaContable::getPuntoEquilibrio, CuentaContable::setPuntoEquilibrio);
	}

	private void buildCostoVenta() throws Exception {
		// Costo de venta
		costoVenta = new ComboBox<>();
		costoVenta.setLabel("Costo de venta");
		costoVenta.setWidthFull();
		List<CostoVenta> items = new CostoVentaService().find();
		costoVenta.setItems(items);
		binder.forField(costoVenta)
			.bind(CuentaContable::getCostoVenta, CuentaContable::setCostoVenta);
	}

	private void buildSeguridadPuerta() throws Exception {
		// Puerta
		seguridadPuerta = new ComboBox<>();
		seguridadPuerta.setLabel("Puerta");
		seguridadPuerta.setWidthFull();
		List<SeguridadPuerta> items = new SeguridadPuertaService().find();
		seguridadPuerta.setItems(items);
		binder.forField(seguridadPuerta)
			.bind(CuentaContable::getSeguridadPuerta, CuentaContable::setSeguridadPuerta);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<CuentaContable> validate = binder.validate();
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
				BinderValidationStatus<CuentaContable> validate = binder.validate();
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