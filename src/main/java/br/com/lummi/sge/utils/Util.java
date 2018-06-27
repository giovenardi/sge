package br.com.lummi.sge.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.text.MaskFormatter;

import br.com.lummi.sge.exceptions.SgeValidationException;

public class Util {

	private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");

	public static final String DATA = "dd/MM/yyyy";

	private static final String DATE_FORMAT_MILLESECOND = "yyyyMMdd_hhmmss_S";

	private static final String DATE_FORMAR = "yyyyMM";

	private static final String TOKEN_MD5 = "sit-file-!Q@W1q#E";

	private static final String MASCARA_CEP = "#####-###";

	private static final String MASCARA_CPF = "###.###.###-##";

	private static final String MASCARA_CNPJ = "##.###.###/####-##";

	private static final String MASCARA_MESANO = "##/####";

	private static final String MASCARA_PLACA = "#######";

	private static MaskFormatter MF = new MaskFormatter();

	protected Util() {
	}

	public Date formataData(String data) {
		Date dataRetorno = null;
		try {
			dataRetorno = format.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dataRetorno;
	}

	public static String formataData(Date data) {
		String dataRetorno = null;
		if (data != null) {
			dataRetorno = format.format(data);
		}
		return dataRetorno;
	}

	public static void validarCPF(String cpf) throws SgeValidationException {
		if (cpf.length() != 11 || Integer.parseInt(cpf.substring(9,11)) != calcularDV(cpf.substring(0,9), 11)) {
			throw new SgeValidationException("CPF inválido.");
		}
	}

	public static void validarCNPJ(String cnpj) throws SgeValidationException {
		if (cnpj.length() != 14 || Integer.parseInt(cnpj.substring(12,14)) != calcularDV(cnpj.substring(0,12), 9)) {
			throw new SgeValidationException("CNPJ inválido.");
		}
	}
	
	private static int calcularDV(String sCampo, int iPeso) {
		int iSoma1 = 0;
		int iSoma2 = 0;

		int iTamCampo = sCampo.length();

		for (int iPosicao = 1; iPosicao <= iTamCampo; iPosicao++) {
			int iDigito = Integer.valueOf(sCampo.substring(iPosicao - 1, iPosicao));
			iSoma1 = iSoma1 + (iDigito * calcularPeso(iTamCampo - iPosicao, iPeso));
			iSoma2 = iSoma2 + (iDigito * calcularPeso(iTamCampo - iPosicao + 1, iPeso));
		}

		int iDV1 = 11 - (iSoma1 % 11);
		if (iDV1 > 9)
			iDV1 = 0;

		iSoma2 = iSoma2 + (iDV1 * 2);
		int iDV2 = 11 - (iSoma2 % 11);
		if (iDV2 > 9)
			iDV2 = 0;

		return (iDV1 * 10) + iDV2;

	}

	private static int calcularPeso(int iPosicao, int iPeso) {
		return (iPosicao % (iPeso - 1)) + 2;
	}

	public Date formatoData(String formato, String valor) {
		DateFormat dateFormat = new SimpleDateFormat(formato);
		java.util.Date date;
		try {
			date = dateFormat.parse(valor);
			return new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String retiraMascaraCPF(String cpf) {
		if (cpf != null) {
			cpf = cpf.replaceAll("-", "").replaceAll("\\.", "");
		}
		return cpf;
	}

	private static String geraMascara(String mascara, String valor) {
		if (valor != null && valor.trim().length() > 0) {
			try {
				synchronized (MF) {
					MF.setMask(mascara);
					MF.setValueContainsLiteralCharacters(false);
					valor = MF.valueToString(valor);
				}
			} catch (Exception e) {

			}
		}
		return valor;
	}

	private static String tiraMascara(String mascara, String valor) {
		try {
			synchronized (MF) {
				MF.setMask(mascara);
				MF.setValueContainsLiteralCharacters(false);
				return (String) MF.stringToValue(valor);
			}
		} catch (Exception e) {

		}
		return valor;
	}

	public static String formataCpf(String cpf) {
		return geraMascara(MASCARA_CPF, cpf);
	}

	public static String formataCnpj(String cnpj) {
		return geraMascara(MASCARA_CNPJ, cnpj);
	}

	public static String desformataCpf(String cpf) {
		return tiraMascara(MASCARA_CPF, cpf);
	}

	public static String desformataCnpj(String cnpj) {
		return tiraMascara(MASCARA_CNPJ, cnpj);
	}

	public static String formataCep(String cep) {
		return geraMascara(MASCARA_CEP, cep);
	}

	public static String desformataCep(String cep) {
		return tiraMascara(MASCARA_CEP, cep);
	}

	public static String desformataPlaca(String placa) {
		return tiraMascara(MASCARA_PLACA, placa);
	}

	public static String retiraMascaraCNPJ(String cnpj) {
		return tiraMascara(MASCARA_CNPJ, cnpj);
	}

	public Date dataDeHoje() {
		return new Date();
	}

	public long getStringToTime(Date data, String patten) {
		patten = new SimpleDateFormat(patten).format(data);
		SimpleDateFormat format = new SimpleDateFormat(patten);
		long time = 0;
		try {
			time = format.parse(patten).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}

	public static String convertMilliSecondsToFormattedDate() {
		return new SimpleDateFormat(DATE_FORMAT_MILLESECOND).format(new Date());
	}

	public static String convertToFormattedDate() {
		return new SimpleDateFormat(DATE_FORMAR).format(Calendar.getInstance().getTime());
	}

	public static String getMD5() throws NoSuchAlgorithmException {
		return new BigInteger(1, MessageDigest.getInstance("MD5").digest(TOKEN_MD5.getBytes())).toString(16);
	}

	public static String implode(String separator, String... data) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length - 1; i++) {
			// data.length - 1 => to not add separator at the end
			if (!data[i].matches(" *")) {
				// empty string are ""; " "; " "; and
				// so on
				sb.append(data[i]);
				sb.append(separator);
			}
		}
		sb.append(data[data.length - 1].trim());
		return sb.toString();
	}

	public static long diasEntreDatas(Date dataMenor, Date dataMaior) throws ParseException {
		long diff;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataMaiorSemHoras = sdf.parse(sdf.format(dataMaior));
		Date dataMenorSemHoras = sdf.parse(sdf.format(dataMenor));
		diff = dataMaiorSemHoras.getTime() - dataMenorSemHoras.getTime();
		long dias = diff / (1000 * 60 * 60 * 24);
		// quantidade de milissegundos
		// em um dia
		return dias;
	}

	public static String gerarMesAno(Short mesInicial, Short anoInicial) {
		String valor = null;
		try {
			synchronized (MF) {
				MF.setMask(MASCARA_MESANO);
				MF.setPlaceholder("0");
				valor = MF.valueToString(mesInicial + "" +anoInicial);			}
		} catch (ParseException e) {}
		return valor;
	}

}