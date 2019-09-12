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
import com.vaadin.flow.component.checkbox.Checkbox;
import java.util.List;
import com.vaadin.flow.component.combobox.ComboBox;


@PageTitle("Modelo de comprobante de fondo")
@Route("ComprobanteFondoModeloItem")
public class UIComprobanteFondoModeloItemView extends VerticalLayout implements HasUrlParameter<String> {

	private ComprobanteFondoModeloItemService service;		

	// Binder
	private ComprobanteFondoModeloItem item;
	private Binder<ComprobanteFondoModeloItem> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private NumberField numero;
	private Checkbox debe;
	private ComboBox<ComprobanteFondoModelo> comprobanteFondoModelo;
	private ComboBox<CuentaFondo> cuentaFondo;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIComprobanteFondoModeloItemView() throws Exception {
		service = new ComprobanteFondoModeloItemService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new ComprobanteFondoModeloItem();
		binder = new Binder<>(ComprobanteFondoModeloItem.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// -------------------------------------------------------------------
		// Controls 
		// -------------------------------------------------------------------
		
		buildSave();
		
		buildNumero();
		buildDebe();
		buildComprobanteFondoModelo();
		buildCuentaFondo();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(numero);
		form.add(debe);
		form.add(comprobanteFondoModelo);
		form.add(cuentaFondo);
		
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
		// Nº modelo
		numero = new NumberField();
		numero.setLabel("Nº modelo");
		numero.setWidthFull();
		numero.setClearButtonVisible(true);
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		binder.forField(numero)
			.asRequired("Nº modelo es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(ComprobanteFondoModeloItem::getNumero, ComprobanteFondoModeloItem::setNumero);
	}

	private void buildDebe() throws Exception {
		// Debe
		debe = new Checkbox();
		debe.setLabel("Debe");
		debe.setWidthFull();
		binder.forField(debe)
			.bind(ComprobanteFondoModeloItem::getDebe, ComprobanteFondoModeloItem::setDebe);
	}

	private void buildComprobanteFondoModelo() throws Exception {
		// Modelo
		comprobanteFondoModelo = new ComboBox<>();
		comprobanteFondoModelo.setLabel("Modelo");
		comprobanteFondoModelo.setWidthFull();
		comprobanteFondoModelo.setRequired(true);
		List<ComprobanteFondoModelo> items = new ComprobanteFondoModeloService().find();
		comprobanteFondoModelo.setItems(items);
		binder.forField(comprobanteFondoModelo)
			.asRequired("Modelo es requerido.")		
			.bind(ComprobanteFondoModeloItem::getComprobanteFondoModelo, ComprobanteFondoModeloItem::setComprobanteFondoModelo);
	}

	private void buildCuentaFondo() throws Exception {
		// Cuenta fondo
		cuentaFondo = new ComboBox<>();
		cuentaFondo.setLabel("Cuenta fondo");
		cuentaFondo.setWidthFull();
		cuentaFondo.setRequired(true);
		List<CuentaFondo> items = new CuentaFondoService().find();
		cuentaFondo.setItems(items);
		binder.forField(cuentaFondo)
			.asRequired("Cuenta fondo es requerido.")		
			.bind(ComprobanteFondoModeloItem::getCuentaFondo, ComprobanteFondoModeloItem::setCuentaFondo);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<ComprobanteFondoModeloItem> validate = binder.validate();
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
				BinderValidationStatus<ComprobanteFondoModeloItem> validate = binder.validate();
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