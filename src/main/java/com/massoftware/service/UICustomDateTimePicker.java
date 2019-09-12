package com.massoftware.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;

import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datepicker.DatePicker.DatePickerI18n;
import com.vaadin.flow.component.timepicker.TimePicker;

public class UICustomDateTimePicker extends CustomField<LocalDateTime> {

	private final DatePicker datePicker = new DatePicker();
	private final TimePicker timePicker = new TimePicker();

	public UICustomDateTimePicker() {
//		setLabel(label);
		add(datePicker, timePicker);
	}

	public void setRequired(boolean required) {
//		datePicker.setRequired(required);
//		timePicker.setRequired(required);
	}

	public void setLocale(Locale locale) {
//		datePicker.setLocale(locale);
//		timePicker.setLocale(locale);		
	}
	
	public void setI18n(DatePickerI18n i18n) {
//		datePicker.setI18n(i18n);
//		timePicker.setLocale(locale);	
	}

	@Override
	protected LocalDateTime generateModelValue() {
		final LocalDate date = datePicker.getValue();
		final LocalTime time = timePicker.getValue();
		return date != null && time != null ? LocalDateTime.of(date, time) : null;
	}

	@Override
	protected void setPresentationValue(LocalDateTime newPresentationValue) {
		datePicker.setValue(newPresentationValue != null ? newPresentationValue.toLocalDate() : null);
		timePicker.setValue(newPresentationValue != null ? newPresentationValue.toLocalTime() : null);

	}

	private static final long serialVersionUID = -3690799923271459825L;
}
