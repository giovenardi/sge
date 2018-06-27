package br.com.caelum.vraptor.serialization.gson;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.enterprise.context.Dependent;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

/**
 * Deserialize {@link Date} using ISO8601 format. This class must be in
 * {@link Dependent} to allow us to discover generic type.
 * 
 * @author Rodrigo Turini
 * @since 4.0.0
 */
@Dependent
public class DateGsonConverter implements JsonDeserializer<Date>, JsonSerializer<Date> {

	private static final SimpleDateFormat LATIN_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	private static final DateFormat DATA_HORA_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm", new Locale("pt", "BR"));

	@Override
	public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
		String dateString = DATA_HORA_FORMAT.format(date);
		return new JsonPrimitive(dateString);
	}

	@Override
	public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		try {
			return DATA_HORA_FORMAT.parse(json.getAsString());
		} catch (ParseException e) {
		}
		try {
			return LATIN_FORMAT.parse(json.getAsString());
		} catch (ParseException e) {
			throw new JsonSyntaxException(json.getAsString(), e);
		}
	}

}