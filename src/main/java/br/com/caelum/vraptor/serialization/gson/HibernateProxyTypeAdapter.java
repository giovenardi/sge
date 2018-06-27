package br.com.caelum.vraptor.serialization.gson;

import java.io.IOException;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class HibernateProxyTypeAdapter extends TypeAdapter<HibernateProxy> {

    private final Gson context;

    protected HibernateProxyTypeAdapter(Gson context) {
        this.context = context;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void write(JsonWriter out, HibernateProxy value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        Class<?> baseType = Hibernate.getClass(value);
        TypeAdapter delegate = context.getAdapter(TypeToken.get(baseType));
        Object unproxiedValue = ((HibernateProxy) value).getHibernateLazyInitializer()
                .getImplementation();
        delegate.write(out, unproxiedValue);	
    }
    
	@Override
	public HibernateProxy read(JsonReader in) throws IOException {
		return null;
	}
	
}