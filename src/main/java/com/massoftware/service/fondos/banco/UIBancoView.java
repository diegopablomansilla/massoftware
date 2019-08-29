package com.massoftware.service.fondos.banco;

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
import com.massoftware.ui.util.DoubleToLongConverter;
import com.vaadin.flow.component.combobox.ComboBox;
import com.massoftware.service.FBoolean;


@PageTitle("Banco")
@Route("Banco")
public class UIBancoView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private Banco item;
	private Binder<Banco> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private TextField nombre;
	private NumberField cuit;
	private ComboBox<FBoolean> vigente;
	private NumberField hoja;
	private NumberField primeraFila;
	private NumberField ultimaFila;
	private TextField fecha;
	private TextField descripcion;
	private TextField referencia1;
	private TextField importe;
	private TextField referencia2;
	private TextField saldo;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIBancoView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new Banco();
		binder = new Binder<>(Banco.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº banco ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº banco ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº banco es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Banco::getNumero, Banco::setNumero);

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
			.bind(Banco::getNombre, Banco::setNombre);

		//-------------------------------------------------------------------
		// CUIT ()
		cuit = new NumberField();
		cuit.setMin(1L);
		cuit.setMax(99999999999L);
		cuit.setPlaceholder("CUIT ");
		cuit.setPrefixComponent(VaadinIcon.SEARCH.create());
		cuit.setClearButtonVisible(true);
		binder.forField(cuit)
			.asRequired("CUIT es requerido.")		
			.withConverter(new DoubleToLongConverter())
			.withValidator(value -> (value != null) ? value >= 1L : true, "El valor tiene que ser >= 1L")
			.withValidator(value -> (value != null) ? value <= 99999999999L : true,"El valor tiene que ser <= " + 99999999999L)
			.bind(Banco::getCuit, Banco::setCuit);

		//-------------------------------------------------------------------
		// Vigente

		//-------------------------------------------------------------------
		// Hoja ()
		hoja = new NumberField();
		hoja.setMin(1);
		hoja.setMax(100);
		hoja.setPlaceholder("Hoja ");
		hoja.setPrefixComponent(VaadinIcon.SEARCH.create());
		hoja.setClearButtonVisible(true);
		binder.forField(hoja)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= 100 : true,"El valor tiene que ser <= " + 100)
			.bind(Banco::getHoja, Banco::setHoja);

		//-------------------------------------------------------------------
		// Primera fila ()
		primeraFila = new NumberField();
		primeraFila.setMin(1);
		primeraFila.setMax(1000);
		primeraFila.setPlaceholder("Primera fila ");
		primeraFila.setPrefixComponent(VaadinIcon.SEARCH.create());
		primeraFila.setClearButtonVisible(true);
		binder.forField(primeraFila)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= 1000 : true,"El valor tiene que ser <= " + 1000)
			.bind(Banco::getPrimeraFila, Banco::setPrimeraFila);

		//-------------------------------------------------------------------
		// Última fila ()
		ultimaFila = new NumberField();
		ultimaFila.setMin(1);
		ultimaFila.setMax(1000);
		ultimaFila.setPlaceholder("Última fila ");
		ultimaFila.setPrefixComponent(VaadinIcon.SEARCH.create());
		ultimaFila.setClearButtonVisible(true);
		binder.forField(ultimaFila)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= 1000 : true,"El valor tiene que ser <= " + 1000)
			.bind(Banco::getUltimaFila, Banco::setUltimaFila);

		//-------------------------------------------------------------------
		// Fecha
		fecha = new TextField();
		fecha.setPlaceholder("Fecha");
		fecha.setPrefixComponent(VaadinIcon.SEARCH.create());
		fecha.setWidthFull();
		fecha.setClearButtonVisible(true);
		fecha.setAutoselect(true);
		binder.forField(fecha)
			.bind(Banco::getFecha, Banco::setFecha);

		//-------------------------------------------------------------------
		// Descripción
		descripcion = new TextField();
		descripcion.setPlaceholder("Descripción");
		descripcion.setPrefixComponent(VaadinIcon.SEARCH.create());
		descripcion.setWidthFull();
		descripcion.setClearButtonVisible(true);
		descripcion.setAutoselect(true);
		binder.forField(descripcion)
			.bind(Banco::getDescripcion, Banco::setDescripcion);

		//-------------------------------------------------------------------
		// Referencia 1
		referencia1 = new TextField();
		referencia1.setPlaceholder("Referencia 1");
		referencia1.setPrefixComponent(VaadinIcon.SEARCH.create());
		referencia1.setWidthFull();
		referencia1.setClearButtonVisible(true);
		referencia1.setAutoselect(true);
		binder.forField(referencia1)
			.bind(Banco::getReferencia1, Banco::setReferencia1);

		//-------------------------------------------------------------------
		// Importe
		importe = new TextField();
		importe.setPlaceholder("Importe");
		importe.setPrefixComponent(VaadinIcon.SEARCH.create());
		importe.setWidthFull();
		importe.setClearButtonVisible(true);
		importe.setAutoselect(true);
		binder.forField(importe)
			.bind(Banco::getImporte, Banco::setImporte);

		//-------------------------------------------------------------------
		// Referencia 2
		referencia2 = new TextField();
		referencia2.setPlaceholder("Referencia 2");
		referencia2.setPrefixComponent(VaadinIcon.SEARCH.create());
		referencia2.setWidthFull();
		referencia2.setClearButtonVisible(true);
		referencia2.setAutoselect(true);
		binder.forField(referencia2)
			.bind(Banco::getReferencia2, Banco::setReferencia2);

		//-------------------------------------------------------------------
		// Saldo
		saldo = new TextField();
		saldo.setPlaceholder("Saldo");
		saldo.setPrefixComponent(VaadinIcon.SEARCH.create());
		saldo.setWidthFull();
		saldo.setClearButtonVisible(true);
		saldo.setAutoselect(true);
		binder.forField(saldo)
			.bind(Banco::getSaldo, Banco::setSaldo);
	

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
		form.add(numero, nombre, cuit, vigente, hoja, primeraFila, ultimaFila, fecha, descripcion, referencia1, importe, referencia2, saldo);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			BancoService service = new BancoService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}