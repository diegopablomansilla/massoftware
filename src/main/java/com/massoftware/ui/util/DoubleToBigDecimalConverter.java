package com.massoftware.ui.util;

import java.math.BigDecimal;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

public class DoubleToBigDecimalConverter implements Converter<Double, BigDecimal> {

	@Override
	public Result<BigDecimal> convertToModel(Double fieldValue, ValueContext context) {
		// Produces a converted value or an error
		try {
			// ok is a static helper method that creates a Result
			if (fieldValue != null) {
				return Result.ok(new BigDecimal(fieldValue));
			}
			return Result.ok(null);
		} catch (NumberFormatException e) {
			// error is a static helper method that creates a Result
			return Result.error("Por favor ingrese un número entero");
		}
	}

	@Override
	public Double convertToPresentation(BigDecimal bigDecimal, ValueContext context) {
		// Converting to the field type should always succeed,
		// so there is no support for returning an error Result.
		if (bigDecimal != null) {
			return bigDecimal.doubleValue();
		}

		return null;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7776688232880997417L;
}
