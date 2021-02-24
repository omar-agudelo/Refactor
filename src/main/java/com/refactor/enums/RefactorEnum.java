package com.refactor.enums;

public enum RefactorEnum {
	

	M("M",1000),
	RR("RR",50),
	CC("CC",4),
	ORDMAX("ORDMAX",30),
	PAGENUMBER("PAGENUMBER",1);
	

	private String codigo;

	private Integer valor;

	private RefactorEnum(String codigo, Integer valor) {
		this.codigo = codigo;
		this.valor = valor;
	}

	

	public String getCodigo() {
		return codigo;
	}

	public Integer getValor() {
		return valor;
	}

	public static Integer getCodeByValor(String code) {
		for (RefactorEnum eec : RefactorEnum.values()) {
			if (eec.getCodigo().equals(code)) {
				return eec.getValor();
			}
		}
		return null;
	}

}
