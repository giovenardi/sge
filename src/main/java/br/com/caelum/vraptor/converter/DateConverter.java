package br.com.caelum.vraptor.converter;

import static com.google.common.base.Strings.isNullOrEmpty;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

import br.com.caelum.vraptor.Convert;

/**
 * Locale based date converter.
 *
 * @author Guilherme Silveira
 */
@Convert(Date.class)
@Alternative
@Priority(Interceptor.Priority.LIBRARY_BEFORE)
public class DateConverter implements Converter<Date> {

	public static final String INVALID_MESSAGE_KEY = "is_not_a_valid_date";

	private final Locale locale;

	/**
	 * @deprecated CDI eyes only
	 */
	protected DateConverter() {
		this(null);
	}

	@Inject
	public DateConverter(Locale locale) {
		this.locale = locale;
	}

	@Override
	public Date convert(String value, Class<? extends Date> type) {
		if (isNullOrEmpty(value)) {
			return null;
		}

		DateFormat formatDateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm", locale);
		try {
			return formatDateTime.parse(value);
		} catch (ParseException pe) {
			DateFormat formatDate = DateFormat.getDateInstance(DateFormat.SHORT, locale);
			try {
				return formatDate.parse(value);
			} catch (ParseException pe1) {
				throw new ConversionException(new ConversionMessage(INVALID_MESSAGE_KEY, value));
			}
		}
		// try {
		// return getDateFormat().parse(value);
		//
		// } catch (ParseException pe) {
		// throw new ConversionException(new ConversionMessage(INVALID_MESSAGE_KEY,
		// value));
		// }
	}

	protected DateFormat getDateFormat() {
		return DateFormat.getDateInstance(DateFormat.SHORT, locale);
	}
}