package br.com.lummi.sge.utils;

import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.ScriptStyle;
import jxl.format.UnderlineStyle;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WriteException;

public class Formatters {

	public WritableCellFormat TIT_CENTRAL_VERDE_CLARO;
    public WritableCellFormat TIT_DIREITA_VERDE_CLARO;
    public WritableCellFormat TIT_ESQUERDA_VERDE_CLARO;
    public WritableCellFormat DOUBLE_VERDE_CLARO;
    public WritableCellFormat INT_VERDE_MEDIO;
    public WritableCellFormat DOUBLE_AMARELO_CLARO;
    public WritableCellFormat DOUBLE_QUASE_BRANCO;
    public WritableCellFormat INT_AMARELO_CLARO;
    public WritableCellFormat DOUBLE_VERDE_MEDIO;
    public WritableCellFormat INT_VERDE_CLARO;
    public WritableCellFormat TIT_DOUBLE_VERDE_CLARO;
    public WritableCellFormat TIT_INT_VERDE_MEDIO;
    public WritableCellFormat TIT_DOUBLE_AMARELO_CLARO;
    public WritableCellFormat TIT_INT_AMARELO_CLARO;
    public WritableCellFormat TIT_DOUBLE_VERDE_MEDIO;
    public WritableCellFormat TIT_INT_VERDE_CLARO;
    public WritableCellFormat TIT_CENTRAL_VERDE_MEDIO;
    public WritableCellFormat TIT_DIREITA_VERDE_MEDIO;
    public WritableCellFormat TIT_ESQUERDA_VERDE_MEDIO;
    public WritableCellFormat TIT_CENTRAL_AMARELO_CLARO;
    public WritableCellFormat LINHA_DIREITA_AMARELO_CLARO;
    public WritableCellFormat TIT_DIREITA_AMARELO_CLARO;
    public WritableCellFormat TIT_CENTRAL_QUASE_BRANCO;
    public WritableCellFormat TIT_QUASE_BRANCO;
    public WritableCellFormat LINHA_QUASE_BRANCO;
    public WritableCellFormat TIT_DIREITA_QUASE_BRANCO;

    public Formatters() {
    	TIT_CENTRAL_VERDE_CLARO = new WritableCellFormat(new WritableFont(WritableFont.ARIAL,
        		WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT));
    	TIT_DIREITA_VERDE_CLARO = new WritableCellFormat(new WritableFont(WritableFont.ARIAL,
    			WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT));
    	TIT_ESQUERDA_VERDE_CLARO = new WritableCellFormat(new WritableFont(WritableFont.ARIAL,
    			WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT));
    	DOUBLE_VERDE_CLARO = new WritableCellFormat(NumberFormats.THOUSANDS_FLOAT);
    	DOUBLE_QUASE_BRANCO = new WritableCellFormat(NumberFormats.THOUSANDS_FLOAT);
    	INT_VERDE_MEDIO = new WritableCellFormat(NumberFormats.THOUSANDS_INTEGER);
    	DOUBLE_AMARELO_CLARO = new WritableCellFormat(NumberFormats.THOUSANDS_FLOAT);
    	INT_AMARELO_CLARO = new WritableCellFormat(NumberFormats.THOUSANDS_INTEGER);
    	LINHA_DIREITA_AMARELO_CLARO = new WritableCellFormat();
    	DOUBLE_VERDE_MEDIO = new WritableCellFormat(NumberFormats.THOUSANDS_FLOAT);
    	INT_VERDE_CLARO = new WritableCellFormat(NumberFormats.THOUSANDS_INTEGER);
    	TIT_DOUBLE_VERDE_CLARO = new WritableCellFormat(new WritableFont(WritableFont.ARIAL,
    			WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT), 
    			NumberFormats.THOUSANDS_FLOAT);
    	TIT_INT_VERDE_MEDIO = new WritableCellFormat(new WritableFont(WritableFont.ARIAL,
    			WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT), 
    			NumberFormats.THOUSANDS_INTEGER);
        TIT_DOUBLE_AMARELO_CLARO = new WritableCellFormat(new WritableFont(WritableFont.ARIAL,
        		WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT), 
        		NumberFormats.THOUSANDS_FLOAT);
        TIT_INT_AMARELO_CLARO = new WritableCellFormat(new WritableFont(WritableFont.ARIAL,
        		WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT), 
        		NumberFormats.THOUSANDS_INTEGER);
        TIT_DOUBLE_VERDE_MEDIO = new WritableCellFormat(new WritableFont(WritableFont.ARIAL,
        		WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT), 
        		NumberFormats.THOUSANDS_FLOAT);
        TIT_INT_VERDE_CLARO = new WritableCellFormat(new WritableFont(WritableFont.ARIAL,
        		WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT), 
        		NumberFormats.THOUSANDS_INTEGER);
        TIT_CENTRAL_VERDE_MEDIO = new WritableCellFormat(new WritableFont(WritableFont.ARIAL,
        		WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT));
        TIT_DIREITA_VERDE_MEDIO = new WritableCellFormat(new WritableFont(WritableFont.ARIAL,
        		WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT));
        TIT_ESQUERDA_VERDE_MEDIO = new WritableCellFormat(new WritableFont(WritableFont.ARIAL,
        		WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT));
        TIT_CENTRAL_AMARELO_CLARO = new WritableCellFormat(new WritableFont(WritableFont.ARIAL,
        		WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT));
        TIT_DIREITA_AMARELO_CLARO = new WritableCellFormat(new WritableFont(WritableFont.ARIAL,
        		WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT));
        TIT_CENTRAL_QUASE_BRANCO = new WritableCellFormat(new WritableFont(WritableFont.ARIAL,
        		WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT));
        TIT_QUASE_BRANCO = new WritableCellFormat(new WritableFont(WritableFont.ARIAL,
        		WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT));
        LINHA_QUASE_BRANCO = new WritableCellFormat();
        TIT_DIREITA_QUASE_BRANCO = new WritableCellFormat(new WritableFont(WritableFont.ARIAL,
        		WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT));
    	try {
			TIT_CENTRAL_VERDE_CLARO.setAlignment(Alignment.CENTRE);
			TIT_CENTRAL_VERDE_CLARO.setBackground(Colour.LIME);
    		TIT_DIREITA_VERDE_CLARO.setAlignment(Alignment.RIGHT);
    		TIT_DIREITA_VERDE_CLARO.setBackground(Colour.LIME);
    		TIT_ESQUERDA_VERDE_MEDIO.setAlignment(Alignment.LEFT);
    		TIT_ESQUERDA_VERDE_MEDIO.setBackground(Colour.LIGHT_GREEN);
    		TIT_ESQUERDA_VERDE_CLARO.setAlignment(Alignment.LEFT);
    		TIT_ESQUERDA_VERDE_CLARO.setBackground(Colour.LIME);
    		DOUBLE_QUASE_BRANCO.setAlignment(Alignment.RIGHT);
    		DOUBLE_QUASE_BRANCO.setBackground(Colour.ICE_BLUE);
    		DOUBLE_VERDE_CLARO.setAlignment(Alignment.RIGHT);
    		DOUBLE_VERDE_CLARO.setBackground(Colour.LIME);
    		INT_VERDE_MEDIO.setAlignment(Alignment.RIGHT);
    		INT_VERDE_MEDIO.setBackground(Colour.LIGHT_GREEN);
    		DOUBLE_AMARELO_CLARO.setAlignment(Alignment.RIGHT);
    		DOUBLE_AMARELO_CLARO.setBackground(Colour.VERY_LIGHT_YELLOW);
    		INT_AMARELO_CLARO.setAlignment(Alignment.RIGHT);
    		INT_AMARELO_CLARO.setBackground(Colour.VERY_LIGHT_YELLOW);
    		DOUBLE_VERDE_MEDIO.setAlignment(Alignment.RIGHT);
    		DOUBLE_VERDE_MEDIO.setBackground(Colour.LIGHT_GREEN);
    		INT_VERDE_CLARO.setAlignment(Alignment.RIGHT);
    		INT_VERDE_CLARO.setBackground(Colour.LIME);
    		TIT_DOUBLE_VERDE_CLARO.setAlignment(Alignment.RIGHT);
    		TIT_DOUBLE_VERDE_CLARO.setBackground(Colour.LIME);
    		TIT_INT_VERDE_MEDIO.setAlignment(Alignment.RIGHT);
    		TIT_INT_VERDE_MEDIO.setBackground(Colour.LIGHT_GREEN);
    		TIT_DOUBLE_AMARELO_CLARO.setAlignment(Alignment.RIGHT);
    		TIT_DOUBLE_AMARELO_CLARO.setBackground(Colour.VERY_LIGHT_YELLOW);
    		TIT_INT_AMARELO_CLARO.setAlignment(Alignment.RIGHT);
    		TIT_INT_AMARELO_CLARO.setBackground(Colour.VERY_LIGHT_YELLOW);
    		TIT_DOUBLE_VERDE_MEDIO.setAlignment(Alignment.RIGHT);
    		TIT_DOUBLE_VERDE_MEDIO.setBackground(Colour.LIGHT_GREEN);
    		TIT_INT_VERDE_CLARO.setAlignment(Alignment.RIGHT);
    		TIT_INT_VERDE_CLARO.setBackground(Colour.LIME);
    		TIT_CENTRAL_VERDE_MEDIO.setAlignment(Alignment.CENTRE);
    		TIT_CENTRAL_VERDE_MEDIO.setBackground(Colour.LIGHT_GREEN);
    		TIT_DIREITA_VERDE_MEDIO.setAlignment(Alignment.RIGHT);
    		TIT_DIREITA_VERDE_MEDIO.setBackground(Colour.LIGHT_GREEN);
    		TIT_CENTRAL_AMARELO_CLARO.setAlignment(Alignment.CENTRE);
    		TIT_CENTRAL_AMARELO_CLARO.setBackground(Colour.VERY_LIGHT_YELLOW);
    		TIT_DIREITA_AMARELO_CLARO.setAlignment(Alignment.RIGHT);
    		TIT_DIREITA_AMARELO_CLARO.setBackground(Colour.VERY_LIGHT_YELLOW);
    		TIT_CENTRAL_QUASE_BRANCO.setAlignment(Alignment.CENTRE);
    		TIT_CENTRAL_QUASE_BRANCO.setBackground(Colour.ICE_BLUE);
    		TIT_QUASE_BRANCO.setAlignment(Alignment.LEFT);
    		TIT_QUASE_BRANCO.setBackground(Colour.ICE_BLUE);
    		LINHA_DIREITA_AMARELO_CLARO.setAlignment(Alignment.RIGHT);
    		LINHA_DIREITA_AMARELO_CLARO.setBackground(Colour.VERY_LIGHT_YELLOW);
    		LINHA_QUASE_BRANCO.setAlignment(Alignment.LEFT);
    		LINHA_QUASE_BRANCO.setBackground(Colour.ICE_BLUE);
    		TIT_DIREITA_QUASE_BRANCO.setAlignment(Alignment.RIGHT);
    		TIT_DIREITA_QUASE_BRANCO.setBackground(Colour.ICE_BLUE);
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
}
