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

import com.vaadin.flow.component.combobox.ComboBox;
import java.util.List;
import com.massoftware.service.contabilidad.EjercicioContable;
import com.vaadin.flow.component.datepicker.DatePicker;


@PageTitle("Empresa")
@Route("Empresa")
public class UIEmpresaView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private Empresa item;
	private Binder<Empresa> binder;

	// Filter control
	private FormLayout form;

	
	private ComboBox<EjercicioContable> ejercicioContable;
	private DatePicker fechaCierreVentas;
	private DatePicker fechaCierreStock;
	private DatePicker fechaCierreFondo;
	private DatePicker fechaCierreCompras;
	private DatePicker fechaCierreContabilidad;
	private DatePicker fechaCierreGarantiaDevoluciones;
	private DatePicker fechaCierreTambos;
	private DatePicker fechaCierreRRHH;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIEmpresaView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new Empresa();
		binder = new Binder<>(Empresa.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Ejercicio
		ejercicioContable = new ComboBox<>();
		ejercicioContable.setRequired(true);
		ejercicioContable.setPlaceholder("Ejercicio");
		binder.forField(ejercicioContable)
			.asRequired("Ejercicio es requerido.")		
			.bind(Empresa::getEjercicioContable, Empresa::setEjercicioContable);
	

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
		form.add(ejercicioContable, fechaCierreVentas, fechaCierreStock, fechaCierreFondo, fechaCierreCompras, fechaCierreContabilidad, fechaCierreGarantiaDevoluciones, fechaCierreTambos, fechaCierreRRHH);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			EmpresaService service = new EmpresaService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}