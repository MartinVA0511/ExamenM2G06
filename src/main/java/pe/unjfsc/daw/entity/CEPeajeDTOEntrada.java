package pe.unjfsc.daw.entity;

public class CEPeajeDTOEntrada {
	private int ID_PEAJE;
	private String EMPRESA_CONCESION;
	private String RUC_CONCESION;
	private String DIRECCION_CONCESION;
	private String UBICACION_CONCESION;
	private String FECHA_PEAJE;
	private String HORA_PEAJE;
	private String TIPO_DE_COMPROBANTE;
	private String Nº_DE_COMPROBANTE;
	private String CATEGORIA;
	private float IMPORTE;
	
	
	public int getID_PEAJE() {
		return ID_PEAJE;
	}


	public void setID_PEAJE(int iD_PEAJE) {
		ID_PEAJE = iD_PEAJE;
	}


	public String getEMPRESA_CONCESION() {
		return EMPRESA_CONCESION;
	}


	public void setEMPRESA_CONCESION(String eMPRESA_CONCESION) {
		EMPRESA_CONCESION = eMPRESA_CONCESION;
	}


	public String getRUC_CONCESION() {
		return RUC_CONCESION;
	}


	public void setRUC_CONCESION(String rUC_CONCESION) {
		RUC_CONCESION = rUC_CONCESION;
	}


	public String getDIRECCION_CONCESION() {
		return DIRECCION_CONCESION;
	}


	public void setDIRECCION_CONCESION(String dIRECCION_CONCESION) {
		DIRECCION_CONCESION = dIRECCION_CONCESION;
	}


	public String getUBICACION_CONCESION() {
		return UBICACION_CONCESION;
	}


	public void setUBICACION_CONCESION(String uBICACION_CONCESION) {
		UBICACION_CONCESION = uBICACION_CONCESION;
	}


	public String getFECHA_PEAJE() {
		return FECHA_PEAJE;
	}


	public void setFECHA_PEAJE(String fECHA_PEAJE) {
		FECHA_PEAJE = fECHA_PEAJE;
	}


	public String getHORA_PEAJE() {
		return HORA_PEAJE;
	}


	public void setHORA_PEAJE(String hORA_PEAJE) {
		HORA_PEAJE = hORA_PEAJE;
	}


	public String getTIPO_DE_COMPROBANTE() {
		return TIPO_DE_COMPROBANTE;
	}


	public void setTIPO_DE_COMPROBANTE(String tIPO_DE_COMPROBANTE) {
		TIPO_DE_COMPROBANTE = tIPO_DE_COMPROBANTE;
	}


	public String getNº_DE_COMPROBANTE() {
		return Nº_DE_COMPROBANTE;
	}


	public void setNº_DE_COMPROBANTE(String nº_DE_COMPROBANTE) {
		Nº_DE_COMPROBANTE = nº_DE_COMPROBANTE;
	}


	public String getCATEGORIA() {
		return CATEGORIA;
	}


	public void setCATEGORIA(String cATEGORIA) {
		CATEGORIA = cATEGORIA;
	}


	public float getIMPORTE() {
		return IMPORTE;
	}


	public void setIMPORTE(float iMPORTE) {
		IMPORTE = iMPORTE;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CEPeajeDTOEntrada [ID_PEAJE=");
		builder.append(ID_PEAJE);
		builder.append(", EMPRESA_CONCESION=");
		builder.append(EMPRESA_CONCESION);
		builder.append(", RUC_CONCESION=");
		builder.append(RUC_CONCESION);
		builder.append(", DIRECCION_CONCESION=");
		builder.append(DIRECCION_CONCESION);
		builder.append(", UBICACION_CONCESION=");
		builder.append(UBICACION_CONCESION);
		builder.append(", FECHA_PEAJE=");
		builder.append(FECHA_PEAJE);
		builder.append(", HORA_PEAJE=");
		builder.append(HORA_PEAJE);
		builder.append(", TIPO_DE_COMPROBANTE=");
		builder.append(TIPO_DE_COMPROBANTE);
		builder.append(", Nº_DE_COMPROBANTE=");
		builder.append(Nº_DE_COMPROBANTE);
		builder.append(", CATEGORIA=");
		builder.append(CATEGORIA);
		builder.append(", IMPORTE=");
		builder.append(IMPORTE);
		builder.append("]");
		return builder.toString();
	}
}
