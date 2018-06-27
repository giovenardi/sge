package br.com.lummi.sge.service;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import br.com.lummi.sge.enums.EstadoCivilEnum;
import br.com.lummi.sge.enums.SexoEnum;
import br.com.lummi.sge.enums.SimNaoEnum;
import br.com.lummi.sge.enums.StatusEventoEnum;
import br.com.lummi.sge.models.Entidade;
import br.com.lummi.sge.models.global.Auditoria;
import br.com.lummi.sge.models.transiente.ItemLog;

public abstract class AbstractLogService<T extends Entidade> extends GenericCRUDService<T> {
	
	@Inject
	protected AuditoriaService auditoriaService;


	protected static String[] classes = new String[]{
			"nivel0",
			"nivel1",
			"nivel2",
			"nivel3",
			"nivel4",
			"nivel5"
	};
	
	
	public static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static final SimpleDateFormat DD_MM_AAAA = new SimpleDateFormat("dd/MM/yyyy");

	public static final NumberFormat MES_FORMATTER = NumberFormat.getNumberInstance();
	{
		MES_FORMATTER.setMinimumIntegerDigits(2);
	}

	public static final NumberFormat ANO_FORMATTER = NumberFormat.getNumberInstance();
	{
		ANO_FORMATTER.setMinimumIntegerDigits(4);
		ANO_FORMATTER.setGroupingUsed(false);
	}

	public static final NumberFormat DOUBLE_FORMATTER = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
	{
		DOUBLE_FORMATTER.setMaximumFractionDigits(5);
		DOUBLE_FORMATTER.setMinimumFractionDigits(5);
	}

	public static final NumberFormat MOEDA_FORMATTER = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
	{
		DOUBLE_FORMATTER.setMaximumFractionDigits(5);
		DOUBLE_FORMATTER.setMinimumFractionDigits(5);
	}

	public static final NumberFormat PERCENT_FORMATTER = NumberFormat.getPercentInstance(new Locale("pt", "BR"));
	{
		DOUBLE_FORMATTER.setMaximumFractionDigits(5);
		DOUBLE_FORMATTER.setMinimumFractionDigits(5);
	}

	@SuppressWarnings("unchecked")
	public Auditoria obterLogAuditoria(Integer id, boolean impressao) {
		Auditoria auditoria = null;
		try {
			auditoria = auditoriaService.consultarLog(id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		T atual = (T) auditoria.getEntidadeAtual();
		T anterior = (T) auditoria.getEntidadeAnterior();
		List<ItemLog> itensLog = new ArrayList<ItemLog>();
		preencherItensLog(itensLog, anterior, atual);
		auditoria.setItensLog(itensLog);
		return auditoria;
	}
	
	protected abstract void preencherItensLog(List<ItemLog> itensLog, T anterior, T atual);

	protected void adicionarSeModificado(List<ItemLog> itensLog, String label, StatusEventoEnum anterior, StatusEventoEnum atual, String classe) {
		String valorAnterior = anterior == null ? "-" : anterior.getDescricao();
		String valorAtual = atual == null ? "-" : atual.getDescricao();
		if (!valorAnterior.equals(valorAtual)) {
			itensLog.add(new ItemLog(label, valorAnterior, valorAtual, classe));
		}
	}

	protected void adicionarSeModificado(List<ItemLog> itensLog, String label, EstadoCivilEnum anterior, EstadoCivilEnum atual, String classe) {
		String valorAnterior = anterior == null ? "-" : anterior.getDescricao();
		String valorAtual = atual == null ? "-" : atual.getDescricao();
		if (!valorAnterior.equals(valorAtual)) {
			itensLog.add(new ItemLog(label, valorAnterior, valorAtual, classe));
		}
	}

	protected void adicionarSeModificado(List<ItemLog> itensLog, String label, SimNaoEnum anterior, SimNaoEnum atual, String classe) {
		String valorAnterior = anterior == null ? "-" : anterior.getDescricao();
		String valorAtual = atual == null ? "-" : atual.getDescricao();
		if (!valorAnterior.equals(valorAtual)) {
			itensLog.add(new ItemLog(label, valorAnterior, valorAtual, classe));
		}
	}

	protected void adicionarSeModificado(List<ItemLog> itensLog, String label, SexoEnum anterior, SexoEnum atual,	String classe) {
		String valorAnterior = anterior == null ? "-" : anterior.getDescricao();
		String valorAtual = atual == null ? "-" : atual.getDescricao();
		if (!valorAnterior.equals(valorAtual)) {
			itensLog.add(new ItemLog(label, valorAnterior, valorAtual, classe));
		}
	}

	protected void adicionarSeModificado(List<ItemLog> itensLog, String label, String anterior, String atual, String classe) {
		String valorAnterior = anterior == null ? "-" : anterior.toString();
		String valorAtual = atual == null ? "-" : atual.toString();
		if (!valorAnterior.equals(valorAtual)) {
			itensLog.add(new ItemLog(label, valorAnterior, valorAtual, classe));
		}
	}
	
	protected void adicionarSeModificado(List<ItemLog> itensLog, String label, Date anterior, Date atual, String classe, boolean hora) {
		String valorAnterior;
		String valorAtual;
		if (hora) {
			valorAnterior = anterior == null ? "-" : SDF.format(anterior);
			valorAtual = atual == null ? "-" : SDF.format(atual);
		} else {
			valorAnterior = anterior == null ? "-" : DD_MM_AAAA.format(anterior);
			valorAtual = atual == null ? "-" : DD_MM_AAAA.format(atual);
		}
		if (!valorAnterior.equals(valorAtual)) {
			itensLog.add(new ItemLog(label, valorAnterior, valorAtual, classe));
		}
	}

	protected void adicionarSeModificado(List<ItemLog> itensLog, String label, Long anterior, Long atual, String classe) {
		String valorAnterior = anterior == null ? "-" : anterior.toString();
		String valorAtual = atual == null ? "-" : atual.toString();
		if (!valorAnterior.equals(valorAtual)) {
			itensLog.add(new ItemLog(label, valorAnterior, valorAtual, classe));
		}
	}

	protected void adicionarSeModificado(List<ItemLog> itensLog, String label, Integer anterior, Integer atual, String classe) {
		String valorAnterior = anterior == null ? "-" : anterior.toString();
		String valorAtual = atual == null ? "-" : atual.toString();
		if (!valorAnterior.equals(valorAtual)) {
			itensLog.add(new ItemLog(label, valorAnterior, valorAtual, classe));
		}
	}

	protected void adicionarMesAnoSeModificado(List<ItemLog> itensLog, String label, Integer mesAnterior, Integer anoAnterior, Integer mesAtual, Integer anoAtual, String classe) {
		String valorAnterior = anoAnterior == null ? "-" : MES_FORMATTER.format(mesAnterior) + "/" + ANO_FORMATTER.format(anoAnterior);
		String valorAtual = anoAtual == null ? "-" : MES_FORMATTER.format(mesAtual) + "/" + ANO_FORMATTER.format(anoAtual);
		if (!valorAnterior.equals(valorAtual)) {
			itensLog.add(new ItemLog(label, valorAnterior, valorAtual, classe));
		}
	}

	protected void adicionarSeModificado(List<ItemLog> itensLog, String label, Double anterior, Double atual, NumberFormat formatter, String classe) {
		String valorAnterior = anterior == null ? "-" : formatter.format(anterior);
		String valorAtual = atual == null ? "-" : formatter.format(atual);
		if (!valorAnterior.equals(valorAtual)) {
			itensLog.add(new ItemLog(label, valorAnterior, valorAtual, classe));
		}
	}

	protected void adicionarSeModificado(List<ItemLog> itensLog, String label, Boolean anterior, Boolean atual,	String classe) {
		String valorAnterior = anterior == null || !anterior.booleanValue() ? "Não" : "Sim";
		String valorAtual = atual == null || !atual.booleanValue() ? "Não" : "Sim";
		if (!valorAnterior.equals(valorAtual)) {
			itensLog.add(new ItemLog(label, valorAnterior, valorAtual, classe));
		}
	}

	protected Date getValorDate(HashMap<String, String> mapa, String chave) {
		Date valor = null;
		try {
			valor = new SimpleDateFormat("yyyyMMdd").parse(getValorString(mapa, chave));
		} catch (Exception e) {
			System.out.println("campo vazio");
		}
		return valor;
	}

	protected Date getValorDateBR(HashMap<String, String> mapa, String chave) {
		Date valor = null;
		try {
			valor = new SimpleDateFormat("dd/MM/yyyy").parse(getValorString(mapa, chave));
		} catch (Exception e) {
			System.out.println("campo vazio");
		}
		return valor;
	}

	protected Integer getValorInt(HashMap<String, String> mapa, String chave) {
		Integer valor = null;
		try {
			valor = Integer.parseInt(getValorString(mapa, chave));
		} catch (Exception e) {
			System.out.println("campo vazio");
		}
		return valor;
	}

	protected String getValorString(HashMap<String, String> mapa, String chave) {
		String valor = null;
		if (mapa != null && chave != null && (valor = mapa.get(chave)) != null) {
			valor = valor.trim();
		}
		return valor;
	}

	protected Object getPeriodoCadastro(Date dataInicio, Date dataFim) {
		return "Período de Cadastro: " + (dataInicio != null ? new SimpleDateFormat("dd/MM/yyyy").format(dataInicio): " - ") + " até " +
				(dataFim != null ? new SimpleDateFormat("dd/MM/yyyy").format(dataFim) : " - ");
	}

	protected Object getDividaAtiva(Integer sitDividaAtiva) {
		return sitDividaAtiva == 0 ? "Sem restrição" : sitDividaAtiva == 0 ? "Restrição" : "Observação"; 
	}

	public String obterMes(Integer mes) {
		return MES_FORMATTER.format(mes);
	}

}
