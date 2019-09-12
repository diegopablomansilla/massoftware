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

import com.vaadin.flow.component.textfield.NumberField;
import com.massoftware.ui.util.DoubleToIntegerConverter;
import java.util.List;
import com.vaadin.flow.component.combobox.ComboBox;


@PageTitle("Item de asiento modelo")
@Route("AsientoModeloItem")
public class UIAsientoModeloItemView extends VerticalLayout implements HasUrlParameter<String> {

	private AsientoModeloItemService service;		

	// Binder
	private AsientoModeloItem item;
	private Binder<AsientoModeloItem> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private NumberField numero;
	private ComboBox<AsientoModelo> asientoModelo;
	private ComboBox<CuentaContable> cuentaContable;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIAsientoModeloItemView() throws Exception {
		service = new AsientoModeloItemService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new AsientoModeloItem();
		binder = new Binder<>(AsientoModeloItem.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// -------------------------------------------------------------------
		// Controls 
		// -------------------------------------------------------------------
		
		buildSave();
		
		buildNumero();
		buildAsientoModelo();
		buildCuentaContable();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(numero);
		form.add(asientoModelo);
		form.add(cuentaContable);
		
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
		// Nº item
		numero = new NumberField();
		numero.setLabel("Nº item");
		numero.setWidthFull();
		numero.setClearButtonVisible(true);
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		binder.forField(numero)
			.asRequired("Nº item es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(AsientoModeloItem::getNumero, AsientoModeloItem::setNumero);
	}

	private void buildAsientoModelo() throws Exception {
		// Asiento modelo
		asientoModelo = new ComboBox<>();
		asientoModelo.setLabel("Asiento modelo");
		asientoModelo.setWidthFull();
		asientoModelo.setReadOnly(true);
		asientoModelo.setRequired(true);
		List<AsientoModelo> items = new AsientoModeloService().find();
		asientoModelo.setItems(items);
		binder.forField(asientoModelo)
			.asRequired("Asiento modelo es requerido.")		
			.bind(AsientoModeloItem::getAsientoModelo, AsientoModeloItem::setAsientoModelo);
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
			.bind(AsientoModeloItem::getCuentaContable, AsientoModeloItem::setCuentaContable);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<AsientoModeloItem> validate = binder.validate();
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
				BinderValidationStatus<AsientoModeloItem> validate = binder.validate();
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