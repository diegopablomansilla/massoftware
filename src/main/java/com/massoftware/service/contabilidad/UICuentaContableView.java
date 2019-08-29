package com.massoftware.service.contabilidad;

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

import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.combobox.ComboBox;
import java.util.List;
import com.massoftware.service.FBoolean;
import com.vaadin.flow.component.textfield.NumberField;
import com.massoftware.service.seguridad.SeguridadPuerta;


@PageTitle("Cuenta contable")
@Route("CuentaContable")
public class UICuentaContableView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private CuentaContable item;
	private Binder<CuentaContable> binder;

	// Filter control
	private FormLayout form;

	
	private TextField codigo;
	private TextField nombre;
	private ComboBox<EjercicioContable> ejercicioContable;
	private TextField integra;
	private TextField cuentaJerarquia;
	private ComboBox<FBoolean> imputable;
	private ComboBox<FBoolean> ajustaPorInflacion;
	private ComboBox<CuentaContableEstado> cuentaContableEstado;
	private ComboBox<FBoolean> cuentaConApropiacion;
	private ComboBox<CentroCostoContable> centroCostoContable;
	private TextField cuentaAgrupadora;
	private NumberField porcentaje;
	private ComboBox<PuntoEquilibrio> puntoEquilibrio;
	private ComboBox<CostoVenta> costoVenta;
	private ComboBox<SeguridadPuerta> seguridadPuerta;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UICuentaContableView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new CuentaContable();
		binder = new Binder<>(CuentaContable.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Cuenta contable
		codigo = new TextField();
		codigo.setRequired(true);
		codigo.setPlaceholder("Cuenta contable");
		codigo.setPrefixComponent(VaadinIcon.SEARCH.create());
		codigo.setWidthFull();
		codigo.setClearButtonVisible(true);
		codigo.setAutoselect(true);
		binder.forField(codigo)
			.asRequired("Cuenta contable es requerido.")		
			.bind(CuentaContable::getCodigo, CuentaContable::setCodigo);

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
			.bind(CuentaContable::getNombre, CuentaContable::setNombre);

		//-------------------------------------------------------------------
		// Ejercicio
		ejercicioContable = new ComboBox<>();
		ejercicioContable.setRequired(true);
		ejercicioContable.setPlaceholder("Ejercicio");
		binder.forField(ejercicioContable)
			.asRequired("Ejercicio es requerido.")		
			.bind(CuentaContable::getEjercicioContable, CuentaContable::setEjercicioContable);

		//-------------------------------------------------------------------
		// Integra
		integra = new TextField();
		integra.setRequired(true);
		integra.setPlaceholder("Integra");
		integra.setPrefixComponent(VaadinIcon.SEARCH.create());
		integra.setWidthFull();
		integra.setClearButtonVisible(true);
		integra.setAutoselect(true);
		binder.forField(integra)
			.asRequired("Integra es requerido.")		
			.bind(CuentaContable::getIntegra, CuentaContable::setIntegra);

		//-------------------------------------------------------------------
		// Cuenta de jerarquia
		cuentaJerarquia = new TextField();
		cuentaJerarquia.setRequired(true);
		cuentaJerarquia.setPlaceholder("Cuenta de jerarquia");
		cuentaJerarquia.setPrefixComponent(VaadinIcon.SEARCH.create());
		cuentaJerarquia.setWidthFull();
		cuentaJerarquia.setClearButtonVisible(true);
		cuentaJerarquia.setAutoselect(true);
		binder.forField(cuentaJerarquia)
			.asRequired("Cuenta de jerarquia es requerido.")		
			.bind(CuentaContable::getCuentaJerarquia, CuentaContable::setCuentaJerarquia);

		//-------------------------------------------------------------------
		// Imputable

		//-------------------------------------------------------------------
		// Ajusta por inflación

		//-------------------------------------------------------------------
		// Estado
		cuentaContableEstado = new ComboBox<>();
		cuentaContableEstado.setRequired(true);
		cuentaContableEstado.setPlaceholder("Estado");
		binder.forField(cuentaContableEstado)
			.asRequired("Estado es requerido.")		
			.bind(CuentaContable::getCuentaContableEstado, CuentaContable::setCuentaContableEstado);

		//-------------------------------------------------------------------
		// Cuenta con apropiación

		//-------------------------------------------------------------------
		// Estado
		centroCostoContable = new ComboBox<>();
		centroCostoContable.setPlaceholder("Estado");
		binder.forField(centroCostoContable)
			.bind(CuentaContable::getCentroCostoContable, CuentaContable::setCentroCostoContable);

		//-------------------------------------------------------------------
		// Cuenta agrupadora
		cuentaAgrupadora = new TextField();
		cuentaAgrupadora.setPlaceholder("Cuenta agrupadora");
		cuentaAgrupadora.setPrefixComponent(VaadinIcon.SEARCH.create());
		cuentaAgrupadora.setWidthFull();
		cuentaAgrupadora.setClearButtonVisible(true);
		cuentaAgrupadora.setAutoselect(true);
		binder.forField(cuentaAgrupadora)
			.bind(CuentaContable::getCuentaAgrupadora, CuentaContable::setCuentaAgrupadora);

		//-------------------------------------------------------------------
		// Porcentaje ()
		porcentaje = new NumberField();
		porcentaje.setMin(0.0);
		porcentaje.setMax(999.99);
		porcentaje.setPlaceholder("Porcentaje ");
		porcentaje.setPrefixComponent(VaadinIcon.SEARCH.create());
		porcentaje.setClearButtonVisible(true);
		binder.forField(porcentaje)
			.withValidator(value -> (value != null) ? value >= 0.0 : true, "El valor tiene que ser >= 0.0")
			.withValidator(value -> (value != null) ? value <= 999.99 : true,"El valor tiene que ser <= " + 999.99)
			.bind(CuentaContable::getPorcentaje, CuentaContable::setPorcentaje);

		//-------------------------------------------------------------------
		// Punto de equilibrio
		puntoEquilibrio = new ComboBox<>();
		puntoEquilibrio.setPlaceholder("Punto de equilibrio");
		binder.forField(puntoEquilibrio)
			.bind(CuentaContable::getPuntoEquilibrio, CuentaContable::setPuntoEquilibrio);

		//-------------------------------------------------------------------
		// Costo de venta
		costoVenta = new ComboBox<>();
		costoVenta.setPlaceholder("Costo de venta");
		binder.forField(costoVenta)
			.bind(CuentaContable::getCostoVenta, CuentaContable::setCostoVenta);

		//-------------------------------------------------------------------
		// Puerta
		seguridadPuerta = new ComboBox<>();
		seguridadPuerta.setPlaceholder("Puerta");
		binder.forField(seguridadPuerta)
			.bind(CuentaContable::getSeguridadPuerta, CuentaContable::setSeguridadPuerta);
	

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
		form.add(codigo, nombre, ejercicioContable, integra, cuentaJerarquia, imputable, ajustaPorInflacion, cuentaContableEstado, cuentaConApropiacion, centroCostoContable, cuentaAgrupadora, porcentaje, puntoEquilibrio, costoVenta, seguridadPuerta);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			CuentaContableService service = new CuentaContableService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}