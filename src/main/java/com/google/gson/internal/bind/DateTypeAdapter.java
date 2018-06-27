/*
 * Copyright (C) 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gson.internal.bind;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/**
 * Adapter for Date. Although this class appears stateless, it is not.
 * DateFormat captures its time zone and locale when it is created, which gives
 * this class state. DateFormat isn't thread safe either, so this class has to
 * synchronize its read and write methods.
 */
public final class DateTypeAdapter extends TypeAdapter<Date> {
	public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
		@SuppressWarnings("unchecked") // we use a runtime check to make sure the 'T's equal
		public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
			return typeToken.getRawType() == Date.class ? (TypeAdapter<T>) new DateTypeAdapter() : null;
		}
	};

	private static final SimpleDateFormat SIMPLE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	private static final DateFormat EN_US_FORMAT = DateFormat.getDateTimeInstance(DateFormat.DEFAULT,
			DateFormat.DEFAULT,
			Locale.US);
	private static final DateFormat LOCAL_FORMAT = DateFormat.getDateTimeInstance(DateFormat.DEFAULT,
			DateFormat.DEFAULT);
	private static final DateFormat ISO_8601_FORMAT = buildIso8601Format();
	private static final DateFormat DATA_HORA_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm", new Locale("pt", "BR"));

	private static DateFormat buildIso8601Format() {
		DateFormat iso8601Format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
		iso8601Format.setTimeZone(TimeZone.getTimeZone("UTC"));
		return iso8601Format;
	}

	@Override
	public Date read(JsonReader in) throws IOException {
		if (in.peek() == JsonToken.NULL) {
			in.nextNull();
			return null;
		}
		return deserializeToDate(in.nextString());
	}

	private synchronized Date deserializeToDate(String json) {
		try {
			return DATA_HORA_FORMAT.parse(json);
		} catch (ParseException ignored) {
		}
		try {
			return SIMPLE_FORMAT.parse(json);
		} catch (ParseException ignored) {
		}
		try {
			return LOCAL_FORMAT.parse(json);
		} catch (ParseException ignored) {
		}
		try {
			return EN_US_FORMAT.parse(json);
		} catch (ParseException ignored) {
		}
		try {
			return ISO_8601_FORMAT.parse(json);
		} catch (ParseException e) {
			throw new JsonSyntaxException(json, e);
		}
	}

	@Override
	public synchronized void write(JsonWriter out, Date value) throws IOException {
		if (value == null) {
			out.nullValue();
			return;
		}
		String dateFormatAsString = SIMPLE_FORMAT.format(value);
		out.value(dateFormatAsString);
	}
}
