package com.massoftware.service.fondos;

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


@PageTitle("Concepto")
@Route("TipoComprobanteConcepto")
public class UITipoComprobanteConceptoView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private TipoComprobanteConcepto item;
	private Binder<TipoComprobanteConcepto> binder;

	// Filter control
	private FormLayout form;

	
	private TextField codigo;
	private TextField nombre;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UITipoComprobanteConceptoView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new TipoComprobanteConcepto();
		binder = new Binder<>(TipoComprobanteConcepto.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Código
		codigo = new TextField();
		codigo.setRequired(true);
		codigo.setPlaceholder("Código");
		codigo.setPrefixComponent(VaadinIcon.SEARCH.create());
		codigo.setWidthFull();
		codigo.setClearButtonVisible(true);
		codigo.setAutoselect(true);
		binder.forField(codigo)
			.asRequired("Código es requerido.")		
			.bind(TipoComprobanteConcepto::getCodigo, TipoComprobanteConcepto::setCodigo);

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
			.bind(TipoComprobanteConcepto::getNombre, TipoComprobanteConcepto::setNombre);
	

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
		form.add(codigo, nombre);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			TipoComprobanteConceptoService service = new TipoComprobanteConceptoService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}