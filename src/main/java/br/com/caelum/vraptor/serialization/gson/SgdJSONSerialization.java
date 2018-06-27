package br.com.caelum.vraptor.serialization.gson;
import java.io.StringWriter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.proxy.HibernateProxy;

import br.com.caelum.vraptor.environment.Environment;
import br.com.caelum.vraptor.interceptor.TypeNameExtractor;
import br.com.caelum.vraptor.serialization.NoRootSerialization;
import br.com.caelum.vraptor.serialization.Serialization;
import br.com.caelum.vraptor.serialization.Serializer;
import br.com.caelum.vraptor.serialization.SerializerBuilder;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

@RequestScoped

public class SgdJSONSerialization implements Serialization {

	String ENVIRONMENT_INDENTED_KEY = "br.com.caelum.vraptor.serialization.json.indented";
	private final TypeNameExtractor extractor;
	private final GsonSerializerBuilder builder;
	private Environment environment;
	private StringWriter writer = new StringWriter();

	/** 
	 * @deprecated CDI eyes only
	 */
	protected SgdJSONSerialization() {
		this(null, null, null);
	}

	public String retorno() {
		String buffer = writer.getBuffer().toString();
		writer.getBuffer().setLength(0);
		return buffer;
	}

	public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        @Override
        @SuppressWarnings("unchecked")
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            return (HibernateProxy.class.isAssignableFrom(type.getRawType()) ? (TypeAdapter<T>) new HibernateProxyTypeAdapter(gson) : null);
        }
    };
    
	@Inject
	public SgdJSONSerialization(TypeNameExtractor extractor,
			GsonSerializerBuilder builder, Environment environment) {
		this.extractor = extractor;
		if (builder != null) {
			((GsonBuilderWrapper)builder).getGsonBuilder().registerTypeAdapterFactory(FACTORY);
			builder.setWithoutRoot(true);
		}
		this.builder =  builder;
		this.environment = environment;
	}

	@PostConstruct
	protected void init() {
		if (environment.supports(ENVIRONMENT_INDENTED_KEY)) {
			builder.indented();
		}
	}

	public boolean accepts(String format) {
		return "json".equals(format);
	}

	public <T> Serializer from(T object) {
		return from(object, null);
	}

	@SuppressWarnings("unchecked")
	public <T> Serializer from(T object, String alias) {
		if (HibernateProxy.class.isAssignableFrom(object.getClass())) {
	        Object unproxiedValue = ((HibernateProxy) object).getHibernateLazyInitializer()
	                .getImplementation();
	        object = (T) unproxiedValue;
		}
		return getSerializer().from(object, alias);
	}

	protected SerializerBuilder getSerializer() {
		return new GsonSerializer(builder, writer, extractor);
	}

	/**
	 * You can override this method for configuring Driver before serialization
	 */
	public <T> NoRootSerialization withoutRoot() {
		builder.setWithoutRoot(true);
		return this;
	}

	public SgdJSONSerialization indented() {
		builder.indented();
		return this;
	}
}