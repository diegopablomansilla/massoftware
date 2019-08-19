package com.massoftware.ui.util;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

public class DoubleToIntegerConverter implements Converter<Double, Integer> {

	@Override
	public Result<Integer> convertToModel(Double fieldValue, ValueContext context) {
		// Produces a converted value or an error
		try {
			// ok is a static helper method that creates a Result
			if (fieldValue != null) {
				return Result.ok(fieldValue.intValue());
			}
			return Result.ok(null);
		} catch (NumberFormatException e) {
			// error is a static helper method that creates a Result
			return Result.error("Por favor ingrese un número entero");
		}
	}

	@Override
	public Double convertToPresentation(Integer integer, ValueContext context) {
		// Converting to the field type should always succeed,
		// so there is no support for returning an error Result.
		if (integer != null) {
			return Double.valueOf(integer);
		}

		return null;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7776688232880997417L;
}
