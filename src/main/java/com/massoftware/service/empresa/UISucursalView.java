package com.massoftware.service.empresa;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.component.textfield.NumberField;
import com.massoftware.ui.util.DoubleToIntegerConverter;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.combobox.ComboBox;
import java.util.List;
import com.massoftware.service.FBoolean;


@PageTitle("Sucursal")
@Route("Sucursal")
public class UISucursalView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private Sucursal item;
	private Binder<Sucursal> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private TextField nombre;
	private TextField abreviatura;
	private ComboBox<TipoSucursal> tipoSucursal;
	private TextField cuentaClientesDesde;
	private TextField cuentaClientesHasta;
	private NumberField cantidadCaracteresClientes;
	private ComboBox<FBoolean> identificacionNumericaClientes;
	private ComboBox<FBoolean> permiteCambiarClientes;
	private TextField cuentaProveedoresDesde;
	private TextField cuentaProveedoresHasta;
	private NumberField cantidadCaracteresProveedores;
	private ComboBox<FBoolean> identificacionNumericaProveedores;
	private ComboBox<FBoolean> permiteCambiarProveedores;
	private NumberField clientesOcacionalesDesde;
	private NumberField clientesOcacionalesHasta;
	private NumberField numeroCobranzaDesde;
	private NumberField numeroCobranzaHasta;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UISucursalView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new Sucursal();
		binder = new Binder<>(Sucursal.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº sucursal ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº sucursal ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº sucursal es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Sucursal::getNumero, Sucursal::setNumero);

		//-------------------------------------------------------------------
		// Nombre
		nombre = new TextField();
		nombre.setRequired(true);
		nombre.setPlaceholder("Nombre");
		nombre.setPrefixComponent(VaadinIcon.SEARCH.create());
		nombre.setWidthFull();
		nombre.setClearButtonVisible(true);
		nombre.setAutoselect(true);
		binder.forField(nombre)
			.asRequired("Nombre es requerido.")		
			.bind(Sucursal::getNombre, Sucursal::setNombre);

		//-------------------------------------------------------------------
		// Abreviatura
		abreviatura = new TextField();
		abreviatura.setRequired(true);
		abreviatura.setPlaceholder("Abreviatura");
		abreviatura.setPrefixComponent(VaadinIcon.SEARCH.create());
		abreviatura.setWidthFull();
		abreviatura.setClearButtonVisible(true);
		abreviatura.setAutoselect(true);
		binder.forField(abreviatura)
			.asRequired("Abreviatura es requerido.")		
			.bind(Sucursal::getAbreviatura, Sucursal::setAbreviatura);

		//-------------------------------------------------------------------
		// Tipo sucursal
		tipoSucursal = new ComboBox<>();
		tipoSucursal.setRequired(true);
		tipoSucursal.setPlaceholder("Tipo sucursal");
		binder.forField(tipoSucursal)
			.asRequired("Tipo sucursal es requerido.")		
			.bind(Sucursal::getTipoSucursal, Sucursal::setTipoSucursal);

		//-------------------------------------------------------------------
		// Cuenta clientes desde
		cuentaClientesDesde = new TextField();
		cuentaClientesDesde.setPlaceholder("Cuenta clientes desde");
		cuentaClientesDesde.setPrefixComponent(VaadinIcon.SEARCH.create());
		cuentaClientesDesde.setWidthFull();
		cuentaClientesDesde.setClearButtonVisible(true);
		cuentaClientesDesde.setAutoselect(true);
		binder.forField(cuentaClientesDesde)
			.bind(Sucursal::getCuentaClientesDesde, Sucursal::setCuentaClientesDesde);

		//-------------------------------------------------------------------
		// Cuenta clientes hasta
		cuentaClientesHasta = new TextField();
		cuentaClientesHasta.setPlaceholder("Cuenta clientes hasta");
		cuentaClientesHasta.setPrefixComponent(VaadinIcon.SEARCH.create());
		cuentaClientesHasta.setWidthFull();
		cuentaClientesHasta.setClearButtonVisible(true);
		cuentaClientesHasta.setAutoselect(true);
		binder.forField(cuentaClientesHasta)
			.bind(Sucursal::getCuentaClientesHasta, Sucursal::setCuentaClientesHasta);

		//-------------------------------------------------------------------
		// Cantidad caracteres clientes ()
		cantidadCaracteresClientes = new NumberField();
		cantidadCaracteresClientes.setMin(3);
		cantidadCaracteresClientes.setMax(6);
		cantidadCaracteresClientes.setPlaceholder("Cantidad caracteres clientes ");
		cantidadCaracteresClientes.setPrefixComponent(VaadinIcon.SEARCH.create());
		cantidadCaracteresClientes.setClearButtonVisible(true);
		binder.forField(cantidadCaracteresClientes)
			.asRequired("Cantidad caracteres clientes es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 3 : true, "El valor tiene que ser >= 3")
			.withValidator(value -> (value != null) ? value <= 6 : true,"El valor tiene que ser <= " + 6)
			.bind(Sucursal::getCantidadCaracteresClientes, Sucursal::setCantidadCaracteresClientes);

		//-------------------------------------------------------------------
		// Identificacion numérica clientes

		//-------------------------------------------------------------------
		// Permite cambiar clientes

		//-------------------------------------------------------------------
		// Cuenta proveedores desde
		cuentaProveedoresDesde = new TextField();
		cuentaProveedoresDesde.setPlaceholder("Cuenta proveedores desde");
		cuentaProveedoresDesde.setPrefixComponent(VaadinIcon.SEARCH.create());
		cuentaProveedoresDesde.setWidthFull();
		cuentaProveedoresDesde.setClearButtonVisible(true);
		cuentaProveedoresDesde.setAutoselect(true);
		binder.forField(cuentaProveedoresDesde)
			.bind(Sucursal::getCuentaProveedoresDesde, Sucursal::setCuentaProveedoresDesde);

		//-------------------------------------------------------------------
		// Cuenta proveedores hasta
		cuentaProveedoresHasta = new TextField();
		cuentaProveedoresHasta.setPlaceholder("Cuenta proveedores hasta");
		cuentaProveedoresHasta.setPrefixComponent(VaadinIcon.SEARCH.create());
		cuentaProveedoresHasta.setWidthFull();
		cuentaProveedoresHasta.setClearButtonVisible(true);
		cuentaProveedoresHasta.setAutoselect(true);
		binder.forField(cuentaProveedoresHasta)
			.bind(Sucursal::getCuentaProveedoresHasta, Sucursal::setCuentaProveedoresHasta);

		//-------------------------------------------------------------------
		// Cantidad caracteres proveedores ()
		cantidadCaracteresProveedores = new NumberField();
		cantidadCaracteresProveedores.setMin(3);
		cantidadCaracteresProveedores.setMax(6);
		cantidadCaracteresProveedores.setPlaceholder("Cantidad caracteres proveedores ");
		cantidadCaracteresProveedores.setPrefixComponent(VaadinIcon.SEARCH.create());
		cantidadCaracteresProveedores.setClearButtonVisible(true);
		binder.forField(cantidadCaracteresProveedores)
			.asRequired("Cantidad caracteres proveedores es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 3 : true, "El valor tiene que ser >= 3")
			.withValidator(value -> (value != null) ? value <= 6 : true,"El valor tiene que ser <= " + 6)
			.bind(Sucursal::getCantidadCaracteresProveedores, Sucursal::setCantidadCaracteresProveedores);

		//-------------------------------------------------------------------
		// Identificacion numérica proveedores

		//-------------------------------------------------------------------
		// Permite cambiar proveedores

		//-------------------------------------------------------------------
		// Clientes ocacionales desde ()
		clientesOcacionalesDesde = new NumberField();
		clientesOcacionalesDesde.setMin(1);
		clientesOcacionalesDesde.setMax(Integer.MAX_VALUE);
		clientesOcacionalesDesde.setPlaceholder("Clientes ocacionales desde ");
		clientesOcacionalesDesde.setPrefixComponent(VaadinIcon.SEARCH.create());
		clientesOcacionalesDesde.setClearButtonVisible(true);
		binder.forField(clientesOcacionalesDesde)
			.asRequired("Clientes ocacionales desde es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Sucursal::getClientesOcacionalesDesde, Sucursal::setClientesOcacionalesDesde);

		//-------------------------------------------------------------------
		// Clientes ocacionales hasta ()
		clientesOcacionalesHasta = new NumberField();
		clientesOcacionalesHasta.setMin(1);
		clientesOcacionalesHasta.setMax(Integer.MAX_VALUE);
		clientesOcacionalesHasta.setPlaceholder("Clientes ocacionales hasta ");
		clientesOcacionalesHasta.setPrefixComponent(VaadinIcon.SEARCH.create());
		clientesOcacionalesHasta.setClearButtonVisible(true);
		binder.forField(clientesOcacionalesHasta)
			.asRequired("Clientes ocacionales hasta es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Sucursal::getClientesOcacionalesHasta, Sucursal::setClientesOcacionalesHasta);

		//-------------------------------------------------------------------
		// Número cobranza desde ()
		numeroCobranzaDesde = new NumberField();
		numeroCobranzaDesde.setMin(1);
		numeroCobranzaDesde.setMax(Integer.MAX_VALUE);
		numeroCobranzaDesde.setPlaceholder("Número cobranza desde ");
		numeroCobranzaDesde.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroCobranzaDesde.setClearButtonVisible(true);
		binder.forField(numeroCobranzaDesde)
			.asRequired("Número cobranza desde es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Sucursal::getNumeroCobranzaDesde, Sucursal::setNumeroCobranzaDesde);

		//-------------------------------------------------------------------
		// Número cobranza hasta ()
		numeroCobranzaHasta = new NumberField();
		numeroCobranzaHasta.setMin(1);
		numeroCobranzaHasta.setMax(Integer.MAX_VALUE);
		numeroCobranzaHasta.setPlaceholder("Número cobranza hasta ");
		numeroCobranzaHasta.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroCobranzaHasta.setClearButtonVisible(true);
		binder.forField(numeroCobranzaHasta)
			.asRequired("Número cobranza hasta es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Sucursal::getNumeroCobranzaHasta, Sucursal::setNumeroCobranzaHasta);
	

		// -------------------------------------------------------------------

		// Button New ítem
//		newBTN = new Button();
//		UIUtils.setTooltip("Nuevo", newBTN);
//		newBTN.setIcon(VaadinIcon.PLUS.create());

		// Button Search ítem's
//		findBTN = new Button();
//		UIUtils.setTooltip("Buscar", findBTN);
//		findBTN.setIcon(VaadinIcon.SEARCH.create());
//		findBTN.addClickListener(event -> {
//			search();
//		});

		// Layout ------------------------

		form = new FormLayout();
		form.setWidthFull();

		add(form);

//		form.add(newBTN, numeroFrom, numeroTo, nombre, findBTN);
		form.add(numero, nombre, abreviatura, tipoSucursal, cuentaClientesDesde, cuentaClientesHasta, cantidadCaracteresClientes, identificacionNumericaClientes, permiteCambiarClientes, cuentaProveedoresDesde, cuentaProveedoresHasta, cantidadCaracteresProveedores, identificacionNumericaProveedores, permiteCambiarProveedores, clientesOcacionalesDesde, clientesOcacionalesHasta, numeroCobranzaDesde, numeroCobranzaHasta);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			SucursalService service = new SucursalService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}