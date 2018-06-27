package br.com.lummi.sge.autenticacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Permissao {
	
	public PermissoesEnum value() default PermissoesEnum.NULO;
	
}
