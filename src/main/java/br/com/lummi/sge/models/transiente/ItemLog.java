package br.com.lummi.sge.models.transiente;

import java.util.Date;

import com.ibm.icu.text.SimpleDateFormat;

//import br.com.lummi.sge.enums.StatusEnum;

public class ItemLog {

	public static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
	public static final SimpleDateFormat SDF_COM_HORA = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private String coluna;
    private String classe;
    private String anterior;
    private String atual;

    public ItemLog(String coluna, Integer anterior, Integer atual, String classe) {
    	this(coluna, anterior==null?"-":anterior.toString(), atual==null?"-":atual.toString(), classe);
    }
    
    public ItemLog(String coluna, Short anterior, Short atual, String classe) {
    	this(coluna, anterior==null?"-":anterior.toString(), atual==null?"-":atual.toString(), classe);
    }


    public ItemLog(String coluna, Date anterior, Date atual, String classe, SimpleDateFormat formatador) {
    	this(coluna, 
    			anterior==null?"-":formatador.format(anterior),
    			atual==null?"-":formatador.format(atual),
    			classe);
    }

    public ItemLog(String coluna, String anterior, String atual) {
    	this(coluna, anterior, atual, "");
    }

    public ItemLog() {
    	this("", "-", "-", "");
    }

    public ItemLog(String coluna) {
    	this(coluna, "-", "-", "");
    }

    public ItemLog(String coluna, String anterior, String atual, String classe) {
        this.coluna = coluna;
        this.anterior = anterior == null ? "-" : anterior;
        this.atual = atual == null ? "-" : atual;
        this.classe = classe;
	}

//	public ItemLog(String coluna, StatusEnum anterior, StatusEnum atual, String classe) {
//    	this(coluna, anterior==null?"-":anterior.getDescricao(), atual==null?"-":atual.getDescricao(), classe);
//	}

	public String getColuna() {
        return coluna;
    }

    public void setColuna(String coluna) {
        this.coluna = coluna;
    }

    public String getAnterior() {
        return anterior;
    }

    public void setAnterior(String anterior) {
        this.anterior = anterior;
    }

    public String getAtual() {
        return atual;
    }

    public void setAtual(String atual) {
        this.atual = atual;
    }

    public boolean foiAlterado() {
        return atual != null ? !atual.equals(anterior) : true;
    }

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
}
