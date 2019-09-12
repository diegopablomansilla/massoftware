package com.massoftware.service.empresa;

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
import com.vaadin.flow.component.checkbox.Checkbox;


@PageTitle("Sucursal")
@Route("Sucursal")
public class UISucursalView extends VerticalLayout implements HasUrlParameter<String> {

	private SucursalService service;		

	// Binder
	private Sucursal item;
	private Binder<Sucursal> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private NumberField numero;
	private TextField nombre;
	private TextField abreviatura;
	private ComboBox<TipoSucursal> tipoSucursal;
	private TextField cuentaClientesDesde;
	private TextField cuentaClientesHasta;
	private NumberField cantidadCaracteresClientes;
	private Checkbox identificacionNumericaClientes;
	private Checkbox permiteCambiarClientes;
	private TextField cuentaProveedoresDesde;
	private TextField cuentaProveedoresHasta;
	private NumberField cantidadCaracteresProveedores;
	private Checkbox identificacionNumericaProveedores;
	private Checkbox permiteCambiarProveedores;
	private NumberField clientesOcacionalesDesde;
	private NumberField clientesOcacionalesHasta;
	private NumberField numeroCobranzaDesde;
	private NumberField numeroCobranzaHasta;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UISucursalView() throws Exception {
		service = new SucursalService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new Sucursal();
		binder = new Binder<>(Sucursal.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// -------------------------------------------------------------------
		// Controls 
		// -------------------------------------------------------------------
		
		buildSave();
		
		buildNumero();
		buildNombre();
		buildAbreviatura();
		buildTipoSucursal();
		buildCuentaClientesDesde();
		buildCuentaClientesHasta();
		buildCantidadCaracteresClientes();
		buildIdentificacionNumericaClientes();
		buildPermiteCambiarClientes();
		buildCuentaProveedoresDesde();
		buildCuentaProveedoresHasta();
		buildCantidadCaracteresProveedores();
		buildIdentificacionNumericaProveedores();
		buildPermiteCambiarProveedores();
		buildClientesOcacionalesDesde();
		buildClientesOcacionalesHasta();
		buildNumeroCobranzaDesde();
		buildNumeroCobranzaHasta();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(numero);
		form.add(nombre);
		form.add(abreviatura);
		form.add(tipoSucursal);
		form.add(cuentaClientesDesde);
		form.add(cuentaClientesHasta);
		form.add(cantidadCaracteresClientes);
		form.add(identificacionNumericaClientes);
		form.add(permiteCambiarClientes);
		form.add(cuentaProveedoresDesde);
		form.add(cuentaProveedoresHasta);
		form.add(cantidadCaracteresProveedores);
		form.add(identificacionNumericaProveedores);
		form.add(permiteCambiarProveedores);
		form.add(clientesOcacionalesDesde);
		form.add(clientesOcacionalesHasta);
		form.add(numeroCobranzaDesde);
		form.add(numeroCobranzaHasta);
		
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
		// Nº sucursal
		numero = new NumberField();
		numero.setLabel("Nº sucursal");
		numero.setWidthFull();
		numero.setClearButtonVisible(true);
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		binder.forField(numero)
			.asRequired("Nº sucursal es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Sucursal::getNumero, Sucursal::setNumero);
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
			.bind(Sucursal::getNombre, Sucursal::setNombre);
	}

	private void buildAbreviatura() throws Exception {
		// Abreviatura
		abreviatura = new TextField();
		abreviatura.setLabel("Abreviatura");
		abreviatura.setWidthFull();
		abreviatura.setClearButtonVisible(true);
		abreviatura.setAutoselect(true);
		abreviatura.setRequired(true);
		binder.forField(abreviatura)
			.asRequired("Abreviatura es requerido.")		
			.withValidator(value -> (value != null) ? value.length() <= 5 : true, "El valor tiene que contener menos de 5 caracteres")
			.bind(Sucursal::getAbreviatura, Sucursal::setAbreviatura);
	}

	private void buildTipoSucursal() throws Exception {
		// Tipo sucursal
		tipoSucursal = new ComboBox<>();
		tipoSucursal.setLabel("Tipo sucursal");
		tipoSucursal.setWidthFull();
		tipoSucursal.setRequired(true);
		List<TipoSucursal> items = new TipoSucursalService().find();
		tipoSucursal.setItems(items);
		binder.forField(tipoSucursal)
			.asRequired("Tipo sucursal es requerido.")		
			.bind(Sucursal::getTipoSucursal, Sucursal::setTipoSucursal);
	}

	private void buildCuentaClientesDesde() throws Exception {
		// Cuenta clientes desde
		cuentaClientesDesde = new TextField();
		cuentaClientesDesde.setLabel("Cuenta clientes desde");
		cuentaClientesDesde.setWidthFull();
		cuentaClientesDesde.setClearButtonVisible(true);
		cuentaClientesDesde.setAutoselect(true);
		binder.forField(cuentaClientesDesde)
			.withValidator(value -> (value != null) ? value.length() <= 7 : true, "El valor tiene que contener menos de 7 caracteres")
			.bind(Sucursal::getCuentaClientesDesde, Sucursal::setCuentaClientesDesde);
	}

	private void buildCuentaClientesHasta() throws Exception {
		// Cuenta clientes hasta
		cuentaClientesHasta = new TextField();
		cuentaClientesHasta.setLabel("Cuenta clientes hasta");
		cuentaClientesHasta.setWidthFull();
		cuentaClientesHasta.setClearButtonVisible(true);
		cuentaClientesHasta.setAutoselect(true);
		binder.forField(cuentaClientesHasta)
			.withValidator(value -> (value != null) ? value.length() <= 7 : true, "El valor tiene que contener menos de 7 caracteres")
			.bind(Sucursal::getCuentaClientesHasta, Sucursal::setCuentaClientesHasta);
	}

	private void buildCantidadCaracteresClientes() throws Exception {
		// Cantidad caracteres clientes
		cantidadCaracteresClientes = new NumberField();
		cantidadCaracteresClientes.setLabel("Cantidad caracteres clientes");
		cantidadCaracteresClientes.setWidthFull();
		cantidadCaracteresClientes.setClearButtonVisible(true);
		cantidadCaracteresClientes.setMin(3);
		cantidadCaracteresClientes.setMax(6);
		binder.forField(cantidadCaracteresClientes)
			.asRequired("Cantidad caracteres clientes es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 3 : true, "El valor tiene que ser >= 3")
			.withValidator(value -> (value != null) ? value <= 6 : true,"El valor tiene que ser <= " + 6)
			.bind(Sucursal::getCantidadCaracteresClientes, Sucursal::setCantidadCaracteresClientes);
	}

	private void buildIdentificacionNumericaClientes() throws Exception {
		// Identificacion numérica clientes
		identificacionNumericaClientes = new Checkbox();
		identificacionNumericaClientes.setLabel("Identificacion numérica clientes");
		identificacionNumericaClientes.setWidthFull();
		binder.forField(identificacionNumericaClientes)
			.bind(Sucursal::getIdentificacionNumericaClientes, Sucursal::setIdentificacionNumericaClientes);
	}

	private void buildPermiteCambiarClientes() throws Exception {
		// Permite cambiar clientes
		permiteCambiarClientes = new Checkbox();
		permiteCambiarClientes.setLabel("Permite cambiar clientes");
		permiteCambiarClientes.setWidthFull();
		binder.forField(permiteCambiarClientes)
			.bind(Sucursal::getPermiteCambiarClientes, Sucursal::setPermiteCambiarClientes);
	}

	private void buildCuentaProveedoresDesde() throws Exception {
		// Cuenta proveedores desde
		cuentaProveedoresDesde = new TextField();
		cuentaProveedoresDesde.setLabel("Cuenta proveedores desde");
		cuentaProveedoresDesde.setWidthFull();
		cuentaProveedoresDesde.setClearButtonVisible(true);
		cuentaProveedoresDesde.setAutoselect(true);
		binder.forField(cuentaProveedoresDesde)
			.withValidator(value -> (value != null) ? value.length() <= 6 : true, "El valor tiene que contener menos de 6 caracteres")
			.bind(Sucursal::getCuentaProveedoresDesde, Sucursal::setCuentaProveedoresDesde);
	}

	private void buildCuentaProveedoresHasta() throws Exception {
		// Cuenta proveedores hasta
		cuentaProveedoresHasta = new TextField();
		cuentaProveedoresHasta.setLabel("Cuenta proveedores hasta");
		cuentaProveedoresHasta.setWidthFull();
		cuentaProveedoresHasta.setClearButtonVisible(true);
		cuentaProveedoresHasta.setAutoselect(true);
		binder.forField(cuentaProveedoresHasta)
			.withValidator(value -> (value != null) ? value.length() <= 6 : true, "El valor tiene que contener menos de 6 caracteres")
			.bind(Sucursal::getCuentaProveedoresHasta, Sucursal::setCuentaProveedoresHasta);
	}

	private void buildCantidadCaracteresProveedores() throws Exception {
		// Cantidad caracteres proveedores
		cantidadCaracteresProveedores = new NumberField();
		cantidadCaracteresProveedores.setLabel("Cantidad caracteres proveedores");
		cantidadCaracteresProveedores.setWidthFull();
		cantidadCaracteresProveedores.setClearButtonVisible(true);
		cantidadCaracteresProveedores.setMin(3);
		cantidadCaracteresProveedores.setMax(6);
		binder.forField(cantidadCaracteresProveedores)
			.asRequired("Cantidad caracteres proveedores es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 3 : true, "El valor tiene que ser >= 3")
			.withValidator(value -> (value != null) ? value <= 6 : true,"El valor tiene que ser <= " + 6)
			.bind(Sucursal::getCantidadCaracteresProveedores, Sucursal::setCantidadCaracteresProveedores);
	}

	private void buildIdentificacionNumericaProveedores() throws Exception {
		// Identificacion numérica proveedores
		identificacionNumericaProveedores = new Checkbox();
		identificacionNumericaProveedores.setLabel("Identificacion numérica proveedores");
		identificacionNumericaProveedores.setWidthFull();
		binder.forField(identificacionNumericaProveedores)
			.bind(Sucursal::getIdentificacionNumericaProveedores, Sucursal::setIdentificacionNumericaProveedores);
	}

	private void buildPermiteCambiarProveedores() throws Exception {
		// Permite cambiar proveedores
		permiteCambiarProveedores = new Checkbox();
		permiteCambiarProveedores.setLabel("Permite cambiar proveedores");
		permiteCambiarProveedores.setWidthFull();
		binder.forField(permiteCambiarProveedores)
			.bind(Sucursal::getPermiteCambiarProveedores, Sucursal::setPermiteCambiarProveedores);
	}

	private void buildClientesOcacionalesDesde() throws Exception {
		// Clientes ocacionales desde
		clientesOcacionalesDesde = new NumberField();
		clientesOcacionalesDesde.setLabel("Clientes ocacionales desde");
		clientesOcacionalesDesde.setWidthFull();
		clientesOcacionalesDesde.setClearButtonVisible(true);
		clientesOcacionalesDesde.setMin(1);
		clientesOcacionalesDesde.setMax(Integer.MAX_VALUE);
		binder.forField(clientesOcacionalesDesde)
			.asRequired("Clientes ocacionales desde es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Sucursal::getClientesOcacionalesDesde, Sucursal::setClientesOcacionalesDesde);
	}

	private void buildClientesOcacionalesHasta() throws Exception {
		// Clientes ocacionales hasta
		clientesOcacionalesHasta = new NumberField();
		clientesOcacionalesHasta.setLabel("Clientes ocacionales hasta");
		clientesOcacionalesHasta.setWidthFull();
		clientesOcacionalesHasta.setClearButtonVisible(true);
		clientesOcacionalesHasta.setMin(1);
		clientesOcacionalesHasta.setMax(Integer.MAX_VALUE);
		binder.forField(clientesOcacionalesHasta)
			.asRequired("Clientes ocacionales hasta es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Sucursal::getClientesOcacionalesHasta, Sucursal::setClientesOcacionalesHasta);
	}

	private void buildNumeroCobranzaDesde() throws Exception {
		// Número cobranza desde
		numeroCobranzaDesde = new NumberField();
		numeroCobranzaDesde.setLabel("Número cobranza desde");
		numeroCobranzaDesde.setWidthFull();
		numeroCobranzaDesde.setClearButtonVisible(true);
		numeroCobranzaDesde.setMin(1);
		numeroCobranzaDesde.setMax(Integer.MAX_VALUE);
		binder.forField(numeroCobranzaDesde)
			.asRequired("Número cobranza desde es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Sucursal::getNumeroCobranzaDesde, Sucursal::setNumeroCobranzaDesde);
	}

	private void buildNumeroCobranzaHasta() throws Exception {
		// Número cobranza hasta
		numeroCobranzaHasta = new NumberField();
		numeroCobranzaHasta.setLabel("Número cobranza hasta");
		numeroCobranzaHasta.setWidthFull();
		numeroCobranzaHasta.setClearButtonVisible(true);
		numeroCobranzaHasta.setMin(1);
		numeroCobranzaHasta.setMax(Integer.MAX_VALUE);
		binder.forField(numeroCobranzaHasta)
			.asRequired("Número cobranza hasta es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Sucursal::getNumeroCobranzaHasta, Sucursal::setNumeroCobranzaHasta);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<Sucursal> validate = binder.validate();
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
				BinderValidationStatus<Sucursal> validate = binder.validate();
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