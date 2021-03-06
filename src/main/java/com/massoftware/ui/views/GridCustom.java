package com.massoftware.ui.views;

import java.util.List;
import java.util.Optional;

import com.massoftware.service.EntityId;
import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.grid.ItemDoubleClickEvent;
import com.vaadin.flow.component.grid.contextmenu.GridContextMenu;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.SortDirection;
import com.vaadin.flow.data.provider.SortOrder;
import com.vaadin.flow.data.selection.SelectionEvent;

import elemental.json.JsonObject;

@JavaScript("frontend://script.js")
public abstract class GridCustom<T> extends Grid<T> {
//	private Integer defaultSelectRow = 0;

	private String idSelected;
	private String firstId;
	private String lastId;

	private String toStringSelected;
	private String firstToStringSelected;
	private String lastToStringSelected;

	private boolean showContextMenuConfigStyle = true;
	private boolean showToolBarColumn = true;
	private boolean showContextMenuDelete = true;
	private boolean showContextMenuOpen = true;
	private boolean border = false;
	private boolean rowStripes = false;
	private boolean rowBorder = false;

	private GridContextMenu<T> contextMenu;
	private Checkbox borderCHK;
	private Checkbox rowStripesCHK;
	private Checkbox rowBorderCHK;

	public GridCustom(Class<T> beanType, boolean showToolBarColumn, boolean showContextMenuConfigStyle,
			boolean showContextMenuDelete, boolean showContextMenuOpen) {
		super(beanType, false);

		this.showToolBarColumn = showToolBarColumn;
		this.showContextMenuConfigStyle = showContextMenuConfigStyle;
		this.showContextMenuDelete = showContextMenuDelete;
		this.showContextMenuOpen = showContextMenuOpen;

		init();
		confProperties();
		addColumns();
		addColumnToolBar();
		addListeners();
		this.focus();
		loadItems();		

	}

	// ----------------------------------------------------------------------

	public void refreshAll() {
		this.getDataProvider().refreshAll();
	}

	public GridCustom<T> setBorder(boolean border) {
		this.border = border;
		if (this.border) {
			this.removeThemeVariants(GridVariant.LUMO_NO_BORDER);
		} else {
			this.addThemeVariants(GridVariant.LUMO_NO_BORDER);
		}

		return this;
	}

	public GridCustom<T> setRowStripes(boolean rowStripes) {
		this.rowStripes = rowStripes;
		if (this.rowStripes) {
			this.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
		} else {
			this.removeThemeVariants(GridVariant.LUMO_ROW_STRIPES);
		}

		return this;
	}

	public GridCustom<T> setRowBorder(boolean rowBorder) {
		this.rowBorder = rowBorder;
		if (this.rowBorder) {
			this.removeThemeVariants(GridVariant.LUMO_NO_ROW_BORDERS);
		} else {
			this.addThemeVariants(GridVariant.LUMO_NO_ROW_BORDERS);
		}

		return this;
	}

	// ----------------------------------------------------------------------

	protected abstract Integer countFromService();

	protected abstract List<T> findFromService(int offset, int limit, Integer orderBy, Boolean orderByDesc);

	protected abstract boolean removeItemFromService(T item);

	// ----------------------------------------------------------------------

	protected void init() {

		if (showContextMenuConfigStyle || showContextMenuOpen || showContextMenuDelete) {

			contextMenu = new GridContextMenu<T>(this);

			if (showContextMenuConfigStyle) {

				Hr separatorMenuConfigStyleCHKMenuItem = new Hr();

				contextMenu.add(separatorMenuConfigStyleCHKMenuItem);

				borderCHK = new Checkbox(getCaptionBorder());
				rowStripesCHK = new Checkbox(getCaptionRowStripes());
				rowBorderCHK = new Checkbox(getCaptionRowBorder());

//			contextMenu.addItem(borderCHK, e -> setBorder(borderCHK.getValue()));		
				borderCHK.addValueChangeListener(event -> setBorder(event.getValue()));
				borderCHK.setValue(this.border);
				contextMenu.addItem(borderCHK);

//			contextMenu.addItem(rowStripesCHK, e -> setRowStripes(rowStripesCHK.getValue()));
				rowStripesCHK.addValueChangeListener(event -> setRowStripes(event.getValue()));
				rowStripesCHK.setValue(this.rowStripes);
				contextMenu.addItem(rowStripesCHK);

				// contextMenu.addItem(rowBorderCHK, e ->
				// setRowBorder(rowBorderCHK.getValue()));
				rowBorderCHK.addValueChangeListener(event -> setRowBorder(event.getValue()));
				rowBorderCHK.setValue(this.rowBorder);
				contextMenu.addItem(rowBorderCHK);
			}

			if (showContextMenuOpen) {

				Hr separator1 = new Hr();

				contextMenu.add(separator1);

				Button buttonOpen = new Button("Abrir");
				buttonOpen.setSizeFull();
				buttonOpen.setIcon(new Icon(VaadinIcon.EXTERNAL_LINK));
				buttonOpen.addThemeVariants(ButtonVariant.LUMO_SMALL);
				contextMenu.addItem(buttonOpen, event -> {
					event.getItem().ifPresent(item -> {
//					removeItemListener(item, this.toStringSelected);
					});
				});

			}

			if (showContextMenuDelete) {
				Hr separator2 = new Hr();

				contextMenu.add(separator2);

				Button buttonRemove = new Button("Borrar");
				buttonRemove.setSizeFull();
				buttonRemove.setIcon(new Icon(VaadinIcon.TRASH));
				buttonRemove.addThemeVariants(ButtonVariant.LUMO_ERROR);
				buttonRemove.addThemeVariants(ButtonVariant.LUMO_SMALL);
				contextMenu.addItem(buttonRemove, event -> {
					event.getItem().ifPresent(item -> {
						removeItemListener(item, this.toStringSelected);
					});
				});

//			contextMenu.addItem("Borrar", event -> {
//				event.getItem().ifPresent(item -> {
//					removeItemListener(item);
//				});
//			});
			}

		}

	}

	protected void confProperties() {
		this.setSelectionMode(SelectionMode.SINGLE);
//		GridSingleSelectionModel<T> singleSelect = (GridSingleSelectionModel<T>) getSelectionModel();
//		singleSelect.setDeselectAllowed(false);

		this.setMultiSort(false);
		this.setColumnReorderingAllowed(true);
		this.setBorder(false);
		this.setRowStripes(false);
		this.setRowBorder(false);
//		addThemeNames("no-border", "no-row-borders", "row-stripes");
//		this.setHeightFull();
	}

	protected String getCaptionBorder() {
		return "Borde de tabla";
	}

	protected String getCaptionRowStripes() {
		return "Filas resaltadas";
	}

	protected String getCaptionRowBorder() {
		return "Filas con borde";
	}

	protected abstract void addColumns();

	protected void addColumnToolBar() {
		if (showToolBarColumn) {
			this.addComponentColumn(item -> createActionsColumn(this, item)).setKey("toolBar").setHeader("")
					.setTextAlign(ColumnTextAlign.END);
		}
	}

	protected void addListeners() {
//		SingleSelect<Grid<T>, T> personSelect = asSingleSelect();
//		// personSelect can now be used with Binder or HasValue interface
//		personSelect.addValueChangeListener(e -> {
//			T selectedT = e.getValue();
//			
//			Notification.show(selectedT.toString());
//		});

		getElement().executeJavaScript("addKeyListenersCustom($0)", getElement());

		addSelectionListener(event -> selectItemListener(event));
		addItemDoubleClickListener(event -> doubleClickListener(event));

//		this.getElement().addEventListener("keyup", event -> {
//
//			JsonObject eventData = event.getEventData();
//
//			boolean shiftKey = eventData.getBoolean("event.shiftKey");
//			if ("Enter".equals(eventData.getString("event.key"))) {
//				enterListener();
//			}
//
//		}).addEventData("event.shiftKey").addEventData("element.offsetWidth").addEventData("event.key")
//				.addEventData("element.innerText").addEventData("event.key");

//		Element helloButton = this.getElement();
//		helloButton.addEventListener("keyup", event -> {
//
//			JsonObject eventData = event.getEventData();
//
//			boolean shiftKey = eventData.getBoolean("event.shiftKey");
//			double width = eventData.getNumber("element.offsetWidth");
////			String valueText = eventData.getString("event.item");
//
////			String text = "Shift " + (shiftKey ? "down" : "up");
////			text += " on button whose width is " + width + "px";
//
////			Element response = ElementFactory.createDiv(text);
////			getElement().appendChild(response);
//
////			getElement().executeJavaScript("intro()");
//
//			if ("Enter".equals(eventData.getString("event.key"))) {
//				enterListener();
//			}
//
//		}).addEventData("event.shiftKey").addEventData("element.offsetWidth").addEventData("event.key")
//				.addEventData("element.innerText").addEventData("event.key");
	}

	@SuppressWarnings("unchecked")
	public void loadItems() {

		DataProvider<T, Void> dataProvider = DataProvider.fromCallbacks(

				query -> {

					int offset = query.getOffset();
					int limit = query.getLimit();
					Integer orderBy = null;
					Boolean orderByDesc = null;
					for (SortOrder<String> queryOrder : query.getSortOrders()) {
						orderBy = Integer.valueOf(queryOrder.getSorted());
						orderByDesc = queryOrder.getDirection() == SortDirection.DESCENDING;
					}

					List<T> items = findFromService(offset, limit, orderBy, orderByDesc);

					firstId = ((EntityId) items.get(0)).getId();
					lastId = ((EntityId) items.get(items.size() - 1)).getId();

					firstToStringSelected = ((EntityId) items.get(0)).toString();
					lastToStringSelected = ((EntityId) items.get(items.size() - 1)).toString();

					return items.stream();
					// return findFromService(offset, limit, orderBy, orderByDesc).stream();
				},

				query -> countFromService()

		);

		setDataProvider(dataProvider);

		this.idSelected = this.firstId;
		this.toStringSelected = this.firstToStringSelected;

		EntityId b = new EntityId();
		b.setId(idSelected);

		this.getSelectionModel().selectFromClient((T) b);		
		
	}

//	protected void removeItemListener(String item) {
//		EntityId b = new EntityId();
//		b.setId(idSelected);
//	}

	protected void removeItemListener(T item) {
		removeItemListener(item, this.toStringSelected);
	}

	protected void removeItemListener(T item, String msg) {
//		ListDataProvider<T> dataProvider = (ListDataProvider<T>) this.getDataProvider();
//		dataProvider.getItems().remove(item);
//		dataProvider.refreshAll();

//		Dialog dialog = new Dialog();
//
//		dialog.setCloseOnEsc(false);
//		dialog.setCloseOnOutsideClick(false);
//
//		Label messageLabel = new Label();
//
//		Button confirmButton = new Button("Borrar", event -> {
//			messageLabel.setText("Confirmed!");
//			removeItemFromService(item);
//			this.getDataProvider().refreshAll();
//			dialog.close();
//		});
//
//		Button cancelButton = new Button("Cancelar", event -> {
//			messageLabel.setText("Cancelled...");
//			dialog.close();
//		});
//
//		dialog.add(confirmButton, cancelButton);

//		dialog.open();

		if (this.showContextMenuDelete || this.showToolBarColumn) {

			ConfirmationDialog confirmationDialog = new ConfirmationDialog();
			confirmationDialog.setTitle("¿ Estás seguro, quieres borrar el ítem ?");
//		confirmationDialog.setQuestion(item != null ? item.toString() : "");
			confirmationDialog.setQuestion(item != null ? msg : "");
			confirmationDialog.addConfirmationListener(buttonClickEvent -> {
				if (removeItemFromService(item)) {
					this.getDataProvider().refreshAll();
				}
			});
			confirmationDialog.open();

		}

//		EntityId b = new EntityId();
//		b.setId(idSelected);
//
//		this.getSelectionModel().selectFromClient((T) b);

	}

	protected void selectItemListener(SelectionEvent<Grid<T>, T> event) {
		Optional<T> selected = event.getFirstSelectedItem();
		if(selected.isPresent()) {
			selectItemListener(selected.get());	
		}		
	}

	protected void selectItemListener(T item) {
//		Notification.show(item.toString());
	}

	protected void doubleClickListener(ItemDoubleClickEvent<T> event) {
		if (this.showContextMenuOpen || this.showToolBarColumn) {
			open(event.getItem());		
		}
	}
	
	protected void open(T item) {
		EntityId e = (EntityId) item;
		open(e.getId());
	}
	
	protected void open(String id) {
		Notification.show("Open: " + id);	
	}

//	protected void enterListener() {
//		Notification.show("Enter: " + this.idSelected + " ::: " + this.firstId + " ::: " + this.lastId);
//	}

	@SuppressWarnings("unchecked")
	@ClientCallable
	protected void enterListenerForClient(JsonObject eventData) {

		idSelected = eventData.getString("col0");

		if (idSelected == null || idSelected.isEmpty() || idSelected.equalsIgnoreCase("null")) {
			idSelected = this.firstId;
		}

		EntityId b = new EntityId();
		b.setId(idSelected);

		this.getSelectionModel().selectFromClient((T) b);

//		Notification.show("Enter: " + this.idSelected + " ::: " + this.firstId + " ::: " + this.lastId);
//		Notification.show("Enter: " + this.idSelected);
		if (this.showContextMenuOpen || this.showToolBarColumn) {
			open(idSelected);		
		}
		
	}

	@SuppressWarnings("unchecked")
	@ClientCallable
	protected void arrowDownListenerForClient(JsonObject eventData) {

		idSelected = eventData.getString("col0");
		toStringSelected = eventData.getString("col1");

		EntityId b = new EntityId();
		b.setId(idSelected);

		this.getSelectionModel().selectFromClient((T) b);
	}

	@SuppressWarnings("unchecked")
	@ClientCallable
	protected void arrowUpListenerForClient(JsonObject eventData) {

		idSelected = eventData.getString("col0");
		toStringSelected = eventData.getString("col1");

		EntityId b = new EntityId();
		b.setId(idSelected);

		this.getSelectionModel().selectFromClient((T) b);
	}

	@SuppressWarnings("unchecked")
	@ClientCallable
	protected void pageDownListenerForClient(JsonObject eventData) {

		idSelected = eventData.getString("col0");
		toStringSelected = eventData.getString("col1");

		EntityId b = new EntityId();
		b.setId(idSelected);

		this.getSelectionModel().selectFromClient((T) b);
	}

	@SuppressWarnings("unchecked")
	@ClientCallable
	protected void pageUpListenerForClient(JsonObject eventData) {

		idSelected = eventData.getString("col0");
		toStringSelected = eventData.getString("col1");

		EntityId b = new EntityId();
		b.setId(idSelected);

		this.getSelectionModel().selectFromClient((T) b);
	}

	@SuppressWarnings("unchecked")
	@ClientCallable
	protected void ctrlKeyEndListenerForClient(JsonObject eventData) {

//		idSelected = eventData.getString("col0");

		this.idSelected = this.lastId;
		this.toStringSelected = this.lastToStringSelected;

		EntityId b = new EntityId();
		b.setId(idSelected);

		this.getSelectionModel().selectFromClient((T) b);
	}

	@SuppressWarnings("unchecked")
	@ClientCallable
	protected void ctrlKeyHomeListenerForClient(JsonObject eventData) {

//		idSelected = eventData.getString("col0");

		idSelected = this.firstId;
		this.toStringSelected = firstToStringSelected;

		EntityId b = new EntityId();
		b.setId(idSelected);

		this.getSelectionModel().selectFromClient((T) b);

//		
//		JsonObject eventData
//		
//		Serializable[] itemSend = b;

//		getElement().executeJavaScript("selectItemFromServer($0)", eventData);
	}

	@SuppressWarnings("unchecked")
	@ClientCallable
	protected void deleteListenerForClient(JsonObject eventData) {

		idSelected = eventData.getString("col0");
		toStringSelected = eventData.getString("col1");

		EntityId b = new EntityId();
		b.setId(idSelected);

		this.getSelectionModel().selectFromClient((T) b);

		if (this.getSelectionModel().getFirstSelectedItem() != null && idSelected != null
				&& ((EntityId) this.getSelectionModel().getFirstSelectedItem().get()).getId().equals(idSelected)) {
			removeItemListener((T) ((EntityId) this.getSelectionModel().getFirstSelectedItem().get()));
		} else {
			String msg = "Delete: Ocurrión un error en la sincronización de los eventos de navegación de la grilla. idSelected: "
					+ this.idSelected + ", firstSelectedItem:  " + this.getSelectionModel().getFirstSelectedItem();
			Notification.show(msg);
			throw new RuntimeException(msg);
		}

	}

//	protected Button createRemoveButton(Grid<T> grid, T item) {
//		Button button = new Button("", clickEvent -> {
//			removeItemListener(item, item.toString());
//
//		});
//		button.setIcon(new Icon(VaadinIcon.TRASH));
//		return button;
//	}

	protected HorizontalLayout createActionsColumn(Grid<T> grid, T item) {
		HorizontalLayout hl = new HorizontalLayout();
		hl.setMargin(false);
		hl.setPadding(false);
		hl.setSpacing(true);

		Button buttonRemove = new Button("", clickEvent -> {
			removeItemListener(item, item.toString());

		});
		buttonRemove.setIcon(new Icon(VaadinIcon.TRASH));
		buttonRemove.addThemeVariants(ButtonVariant.LUMO_ERROR);

		Button buttonOpen = new Button("", clickEvent -> {
//			removeItemListener(item, item.toString());

		});
		buttonOpen.setIcon(new Icon(VaadinIcon.EXTERNAL_LINK));

		hl.add(buttonRemove, buttonOpen);

		return hl;
	}

//	public Integer getDefaultSelectRow() {
//	return defaultSelectRow;
//}
//
//public void setDefaultSelectRow(Integer defaultSelectRow) {
//	if (defaultSelectRow != null && defaultSelectRow < 0) {
//		throw new IllegalArgumentException("Se esperaba un defaultSelectRow >= 0.");
//	}
//	this.defaultSelectRow = defaultSelectRow;
//}

//@Override
//public void setItems(Collection<T> items) {
//	super.setItems(items);
//
//	if (getDefaultSelectRow() != null) {
//		setSelectRow(getDefaultSelectRow());
//	}
//}

//@SuppressWarnings("unchecked")
//public void setSelectRow(Integer index) {
//
//	ListDataProvider<T> dataProvider = (ListDataProvider<T>) this.getDataProvider();
//
//	if (index == null) {
//		return;
//	}
//
//	if (dataProvider.getItems() == null) {
//		return;
//	}
//
//	if (dataProvider.getItems().size() == 0) {
//		return;
//	}
//
//	select((T) dataProvider.getItems().toArray()[index]);
//}

//public Long countItemsDataPrvider() {
////	@SuppressWarnings("unchecked")
////	ListDataProvider<T> dataProvider = (ListDataProvider<T>) this.getDataProvider();
////	return (long) dataProvider.getItems().size();
//	return 10L;
//}

//	public void ccc(JsonObject eventData) {
//
//		try {
//
//			String id = eventData.getString("col0");
//			Integer numero = Integer.valueOf(eventData.getString("col1"));
//			String nombre = eventData.getString("col2");
//
//			Banco b = new Banco();
//			b.setId(id);
//
//						
//			
//			this.getSelectionModel().selectFromClient(b);
////			this.select(b);
//			
////			Banco b2 = this.getSelectionModel().getFirstSelectedItem().get(); 
//			Notification.show(nombre);
//			
////			
//
////			b.setNombre(nombre);
////			b.setNumero(numero);
//
////			this.getDataProvider().refreshItem(b);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Notification.show(e.toString());
//		}
//
//	}

//	private void confShowContextMenuConfigStyle() {
//
//		contextMenu.add(separatorMenuConfigStyleCHKMenuItem);
//
////			contextMenu.addItem(borderCHK, e -> setBorder(borderCHK.getValue()));
//		borderCHK.addValueChangeListener(event -> setBorder(event.getValue()));
//		borderCHK.setValue(this.border);
//		borderCHKMenuItem = contextMenu.addItem(borderCHK);
//
////			contextMenu.addItem(rowStripesCHK, e -> setRowStripes(rowStripesCHK.getValue()));
//		rowStripesCHK.addValueChangeListener(event -> setRowStripes(event.getValue()));
//		rowStripesCHK.setValue(this.rowStripes);
//		rowStripesCHKMenuItem = contextMenu.addItem(rowStripesCHK);
//
//		// contextMenu.addItem(rowBorderCHK, e ->
//		// setRowBorder(rowBorderCHK.getValue()));
//		rowBorderCHK.addValueChangeListener(event -> setRowBorder(event.getValue()));
//		rowBorderCHK.setValue(this.rowBorder);
//		rowBorderCHKMenuItem = contextMenu.addItem(rowBorderCHK);
//
////			RadioButtonGroup<String> groupBorder = new RadioButtonGroup<>();
//////			groupBorder.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
////			groupBorder.setItems(getCaptionNoBorder(), getCaptionBorder());				
////			groupBorder.addValueChangeListener(event -> {			
////				setBorder(event.getValue().equals(getCaptionBorder()));			
////			});
////			groupBorder.setValue(this.border ? getCaptionBorder() : getCaptionNoBorder());
////			contextMenu.addItem(groupBorder);
//		//
////			RadioButtonGroup<String> groupRowStripes = new RadioButtonGroup<>();
//////			groupRowStripes.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
////			groupRowStripes.setItems(getCaptionNoRowStripes(), getCaptionRowStripes());				
////			groupRowStripes.addValueChangeListener(event -> {
////				setRowStripes(event.getValue().equals(getCaptionRowStripes()));			
////			});
////			groupRowStripes.setValue(this.rowStripes ? getCaptionRowStripes() : getCaptionNoRowStripes());
////			contextMenu.addItem(groupRowStripes);
//		//
////			RadioButtonGroup<String> groupRowBorder = new RadioButtonGroup<>();
//////			groupRowBorder.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
////			groupRowBorder.setItems(getCaptionNoRowBorder(), getCaptionRowBorder());			
////			groupRowBorder.addValueChangeListener(event -> {
////				setRowBorder(event.getValue().equals(getCaptionRowBorder()));			
////			});		
////			groupRowBorder.setValue(this.rowBorder ? getCaptionRowBorder() : getCaptionNoRowBorder());
////			contextMenu.addItem(groupRowBorder);
//
//	}

	private static final long serialVersionUID = 573650195687234594L;

}
