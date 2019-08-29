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

import com.vaadin.flow.component.textfield.NumberField;
import com.massoftware.ui.util.DoubleToIntegerConverter;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.combobox.ComboBox;
import java.util.List;
import com.massoftware.service.contabilidad.CuentaContable;
import com.massoftware.service.FBoolean;
import com.massoftware.service.monedas.Moneda;
import com.massoftware.service.fondos.banco.Banco;
import com.massoftware.ui.util.DoubleToBigDecimalConverter;
import com.massoftware.service.seguridad.SeguridadPuerta;


@PageTitle("Cuenta fondo")
@Route("CuentaFondo")
public class UICuentaFondoView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private CuentaFondo item;
	private Binder<CuentaFondo> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private TextField nombre;
	private ComboBox<CuentaContable> cuentaContable;
	private ComboBox<CuentaFondoGrupo> cuentaFondoGrupo;
	private ComboBox<CuentaFondoTipo> cuentaFondoTipo;
	private ComboBox<FBoolean> obsoleto;
	private ComboBox<FBoolean> noImprimeCaja;
	private ComboBox<FBoolean> ventas;
	private ComboBox<FBoolean> fondos;
	private ComboBox<FBoolean> compras;
	private ComboBox<Moneda> moneda;
	private ComboBox<Caja> caja;
	private ComboBox<FBoolean> rechazados;
	private ComboBox<FBoolean> conciliacion;
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


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UICuentaFondoView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new CuentaFondo();
		binder = new Binder<>(CuentaFondo.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº cuenta ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº cuenta ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº cuenta es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(CuentaFondo::getNumero, CuentaFondo::setNumero);

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
			.bind(CuentaFondo::getNombre, CuentaFondo::setNombre);

		//-------------------------------------------------------------------
		// Cuenta contable
		cuentaContable = new ComboBox<>();
		cuentaContable.setRequired(true);
		cuentaContable.setPlaceholder("Cuenta contable");
		binder.forField(cuentaContable)
			.asRequired("Cuenta contable es requerido.")		
			.bind(CuentaFondo::getCuentaContable, CuentaFondo::setCuentaContable);

		//-------------------------------------------------------------------
		// Grupo
		cuentaFondoGrupo = new ComboBox<>();
		cuentaFondoGrupo.setRequired(true);
		cuentaFondoGrupo.setPlaceholder("Grupo");
		binder.forField(cuentaFondoGrupo)
			.asRequired("Grupo es requerido.")		
			.bind(CuentaFondo::getCuentaFondoGrupo, CuentaFondo::setCuentaFondoGrupo);

		//-------------------------------------------------------------------
		// Tipo
		cuentaFondoTipo = new ComboBox<>();
		cuentaFondoTipo.setRequired(true);
		cuentaFondoTipo.setPlaceholder("Tipo");
		binder.forField(cuentaFondoTipo)
			.asRequired("Tipo es requerido.")		
			.bind(CuentaFondo::getCuentaFondoTipo, CuentaFondo::setCuentaFondoTipo);

		//-------------------------------------------------------------------
		// Obsoleto

		//-------------------------------------------------------------------
		// No imprime caja

		//-------------------------------------------------------------------
		// Ventas

		//-------------------------------------------------------------------
		// Fondos

		//-------------------------------------------------------------------
		// Compras

		//-------------------------------------------------------------------
		// Moneda
		moneda = new ComboBox<>();
		moneda.setPlaceholder("Moneda");
		binder.forField(moneda)
			.bind(CuentaFondo::getMoneda, CuentaFondo::setMoneda);

		//-------------------------------------------------------------------
		// Caja
		caja = new ComboBox<>();
		caja.setPlaceholder("Caja");
		binder.forField(caja)
			.bind(CuentaFondo::getCaja, CuentaFondo::setCaja);

		//-------------------------------------------------------------------
		// Rechazados

		//-------------------------------------------------------------------
		// Conciliación

		//-------------------------------------------------------------------
		// Tipo de banco
		cuentaFondoTipoBanco = new ComboBox<>();
		cuentaFondoTipoBanco.setPlaceholder("Tipo de banco");
		binder.forField(cuentaFondoTipoBanco)
			.bind(CuentaFondo::getCuentaFondoTipoBanco, CuentaFondo::setCuentaFondoTipoBanco);

		//-------------------------------------------------------------------
		// banco
		banco = new ComboBox<>();
		banco.setPlaceholder("banco");
		binder.forField(banco)
			.bind(CuentaFondo::getBanco, CuentaFondo::setBanco);

		//-------------------------------------------------------------------
		// Cuenta bancaria
		cuentaBancaria = new TextField();
		cuentaBancaria.setPlaceholder("Cuenta bancaria");
		cuentaBancaria.setPrefixComponent(VaadinIcon.SEARCH.create());
		cuentaBancaria.setWidthFull();
		cuentaBancaria.setClearButtonVisible(true);
		cuentaBancaria.setAutoselect(true);
		binder.forField(cuentaBancaria)
			.bind(CuentaFondo::getCuentaBancaria, CuentaFondo::setCuentaBancaria);

		//-------------------------------------------------------------------
		// CBU
		cbu = new TextField();
		cbu.setPlaceholder("CBU");
		cbu.setPrefixComponent(VaadinIcon.SEARCH.create());
		cbu.setWidthFull();
		cbu.setClearButtonVisible(true);
		cbu.setAutoselect(true);
		binder.forField(cbu)
			.bind(CuentaFondo::getCbu, CuentaFondo::setCbu);

		//-------------------------------------------------------------------
		// Límite descubierto ()
		limiteDescubierto = new NumberField();
		limiteDescubierto.setMin(-9999.9999);
		limiteDescubierto.setMax(99999.9999);
		limiteDescubierto.setPlaceholder("Límite descubierto ");
		limiteDescubierto.setPrefixComponent(VaadinIcon.SEARCH.create());
		limiteDescubierto.setClearButtonVisible(true);
		binder.forField(limiteDescubierto)
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(CuentaFondo::getLimiteDescubierto, CuentaFondo::setLimiteDescubierto);

		//-------------------------------------------------------------------
		// Cuenta fondo caución
		cuentaFondoCaucion = new TextField();
		cuentaFondoCaucion.setPlaceholder("Cuenta fondo caución");
		cuentaFondoCaucion.setPrefixComponent(VaadinIcon.SEARCH.create());
		cuentaFondoCaucion.setWidthFull();
		cuentaFondoCaucion.setClearButtonVisible(true);
		cuentaFondoCaucion.setAutoselect(true);
		binder.forField(cuentaFondoCaucion)
			.bind(CuentaFondo::getCuentaFondoCaucion, CuentaFondo::setCuentaFondoCaucion);

		//-------------------------------------------------------------------
		// Cuenta fondo diferidos
		cuentaFondoDiferidos = new TextField();
		cuentaFondoDiferidos.setPlaceholder("Cuenta fondo diferidos");
		cuentaFondoDiferidos.setPrefixComponent(VaadinIcon.SEARCH.create());
		cuentaFondoDiferidos.setWidthFull();
		cuentaFondoDiferidos.setClearButtonVisible(true);
		cuentaFondoDiferidos.setAutoselect(true);
		binder.forField(cuentaFondoDiferidos)
			.bind(CuentaFondo::getCuentaFondoDiferidos, CuentaFondo::setCuentaFondoDiferidos);

		//-------------------------------------------------------------------
		// Formato
		formato = new TextField();
		formato.setPlaceholder("Formato");
		formato.setPrefixComponent(VaadinIcon.SEARCH.create());
		formato.setWidthFull();
		formato.setClearButtonVisible(true);
		formato.setAutoselect(true);
		binder.forField(formato)
			.bind(CuentaFondo::getFormato, CuentaFondo::setFormato);

		//-------------------------------------------------------------------
		// Tipo de copias
		cuentaFondoBancoCopia = new ComboBox<>();
		cuentaFondoBancoCopia.setPlaceholder("Tipo de copias");
		binder.forField(cuentaFondoBancoCopia)
			.bind(CuentaFondo::getCuentaFondoBancoCopia, CuentaFondo::setCuentaFondoBancoCopia);

		//-------------------------------------------------------------------
		// Límite operación individual ()
		limiteOperacionIndividual = new NumberField();
		limiteOperacionIndividual.setMin(-9999.9999);
		limiteOperacionIndividual.setMax(99999.9999);
		limiteOperacionIndividual.setPlaceholder("Límite operación individual ");
		limiteOperacionIndividual.setPrefixComponent(VaadinIcon.SEARCH.create());
		limiteOperacionIndividual.setClearButtonVisible(true);
		binder.forField(limiteOperacionIndividual)
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(CuentaFondo::getLimiteOperacionIndividual, CuentaFondo::setLimiteOperacionIndividual);

		//-------------------------------------------------------------------
		// Puerta p/ uso
		seguridadPuertaUso = new ComboBox<>();
		seguridadPuertaUso.setPlaceholder("Puerta p/ uso");
		binder.forField(seguridadPuertaUso)
			.bind(CuentaFondo::getSeguridadPuertaUso, CuentaFondo::setSeguridadPuertaUso);

		//-------------------------------------------------------------------
		// Puerta p/ consulta
		seguridadPuertaConsulta = new ComboBox<>();
		seguridadPuertaConsulta.setPlaceholder("Puerta p/ consulta");
		binder.forField(seguridadPuertaConsulta)
			.bind(CuentaFondo::getSeguridadPuertaConsulta, CuentaFondo::setSeguridadPuertaConsulta);

		//-------------------------------------------------------------------
		// Puerta p/ superar límite
		seguridadPuertaLimite = new ComboBox<>();
		seguridadPuertaLimite.setPlaceholder("Puerta p/ superar límite");
		binder.forField(seguridadPuertaLimite)
			.bind(CuentaFondo::getSeguridadPuertaLimite, CuentaFondo::setSeguridadPuertaLimite);
	

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
		form.add(numero, nombre, cuentaContable, cuentaFondoGrupo, cuentaFondoTipo, obsoleto, noImprimeCaja, ventas, fondos, compras, moneda, caja, rechazados, conciliacion, cuentaFondoTipoBanco, banco, cuentaBancaria, cbu, limiteDescubierto, cuentaFondoCaucion, cuentaFondoDiferidos, formato, cuentaFondoBancoCopia, limiteOperacionIndividual, seguridadPuertaUso, seguridadPuertaConsulta, seguridadPuertaLimite);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			CuentaFondoService service = new CuentaFondoService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}