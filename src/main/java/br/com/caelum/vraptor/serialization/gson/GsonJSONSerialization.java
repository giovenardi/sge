/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.caelum.vraptor.serialization.gson;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.proxy.HibernateProxy;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import br.com.caelum.vraptor.environment.Environment;
import br.com.caelum.vraptor.interceptor.TypeNameExtractor;
import br.com.caelum.vraptor.serialization.JSONSerialization;
import br.com.caelum.vraptor.serialization.NoRootSerialization;
import br.com.caelum.vraptor.serialization.Serializer;
import br.com.caelum.vraptor.serialization.SerializerBuilder;
import br.com.caelum.vraptor.view.ResultException;

/**
 * Gson implementation for JSONSerialization
 *
 * @author Renan Reis
 * @author Guilherme Mangabeira
 */
@RequestScoped
public class GsonJSONSerialization implements JSONSerialization {

	private final HttpServletResponse response;
	private final TypeNameExtractor extractor;
	private final GsonSerializerBuilder builder;
	private Environment environment;

	/** 
	 * @deprecated CDI eyes only
	 */
	protected GsonJSONSerialization() {
		this(null, null, null, null);
	}

	@Inject
	public GsonJSONSerialization(HttpServletResponse response, TypeNameExtractor extractor,
			GsonSerializerBuilder builder, Environment environment) {
		this.response = response;
		this.extractor = extractor;
		if (builder != null) {
			((GsonBuilderWrapper)builder).getGsonBuilder().registerTypeAdapterFactory(FACTORY);
		}
		this.builder = builder;
		this.environment = environment;
	}

	public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        @Override
        @SuppressWarnings("unchecked")
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            return (HibernateProxy.class.isAssignableFrom(type.getRawType()) ? (TypeAdapter<T>) new HibernateProxyTypeAdapter(gson) : null);
        }
    };
    
	@PostConstruct
	protected void init() {
		if (environment.supports(ENVIRONMENT_INDENTED_KEY)) {
			builder.indented();
		}
	}

	@Override
	public boolean accepts(String format) {
		return "json".equals(format);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Serializer from(T object) {
		if (HibernateProxy.class.isAssignableFrom(object.getClass())) {
	        Object unproxiedValue = ((HibernateProxy) object).getHibernateLazyInitializer()
	                .getImplementation();
	        object = (T) unproxiedValue;
		}
		return from(object, null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Serializer from(T object, String alias) {
		if (HibernateProxy.class.isAssignableFrom(object.getClass())) {
	        Object unproxiedValue = ((HibernateProxy) object).getHibernateLazyInitializer()
	                .getImplementation();
	        object = (T) unproxiedValue;
		}
		response.setContentType("application/json");
		return getSerializer().from(object, alias);
	}

	protected SerializerBuilder getSerializer() {
		try {
			return new GsonSerializer(builder, response.getWriter(), extractor);
		} catch (IOException e) {
			throw new ResultException("Unable to serialize data", e);
		}
	}

	/**
	 * You can override this method for configuring Driver before serialization
	 */
	@Override
	public <T> NoRootSerialization withoutRoot() {
		builder.setWithoutRoot(true);
		return this;
	}

	@Override
	public JSONSerialization indented() {
		builder.indented();
		return this;
	}
}