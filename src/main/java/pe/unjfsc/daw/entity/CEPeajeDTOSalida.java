package pe.unjfsc.daw.entity;

public class CEPeajeDTOSalida {
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
	private float P_DESCUENTO;
	private float TOTAL_CON_DESCUENTO;
	
	public int getID_PEAJE() {
		return ID_PEAJE;
	}
	public String getEMPRESA_CONCESION() {
		return EMPRESA_CONCESION;
	}
	public String getRUC_CONCESION() {
		return RUC_CONCESION;
	}
	public String getDIRECCION_CONCESION() {
		return DIRECCION_CONCESION;
	}
	public String getUBICACION_CONCESION() {
		return UBICACION_CONCESION;
	}
	public String getFECHA_PEAJE() {
		return FECHA_PEAJE;
	}
	public String getHORA_PEAJE() {
		return HORA_PEAJE;
	}
	public String getTIPO_DE_COMPROBANTE() {
		return TIPO_DE_COMPROBANTE;
	}
	public String getNº_DE_COMPROBANTE() {
		return Nº_DE_COMPROBANTE;
	}
	public String getCATEGORIA() {
		return CATEGORIA;
	}
	public float getIMPORTE() {
		return IMPORTE;
	}
	public float getP_DESCUENTO() {
		return P_DESCUENTO;
	}
	public float getTOTAL_CON_DESCUENTO() {
		return TOTAL_CON_DESCUENTO;
	}
	public void setID_PEAJE(int iD_PEAJE) {
		ID_PEAJE = iD_PEAJE;
	}
	public void setEMPRESA_CONCESION(String eMPRESA_CONCESION) {
		EMPRESA_CONCESION = eMPRESA_CONCESION;
	}
	public void setRUC_CONCESION(String rUC_CONCESION) {
		RUC_CONCESION = rUC_CONCESION;
	}
	public void setDIRECCION_CONCESION(String dIRECCION_CONCESION) {
		DIRECCION_CONCESION = dIRECCION_CONCESION;
	}
	public void setUBICACION_CONCESION(String uBICACION_CONCESION) {
		UBICACION_CONCESION = uBICACION_CONCESION;
	}
	public void setFECHA_PEAJE(String fECHA_PEAJE) {
		FECHA_PEAJE = fECHA_PEAJE;
	}
	public void setHORA_PEAJE(String hORA_PEAJE) {
		HORA_PEAJE = hORA_PEAJE;
	}
	public void setTIPO_DE_COMPROBANTE(String tIPO_DE_COMPROBANTE) {
		TIPO_DE_COMPROBANTE = tIPO_DE_COMPROBANTE;
	}
	public void setNº_DE_COMPROBANTE(String nº_DE_COMPROBANTE) {
		Nº_DE_COMPROBANTE = nº_DE_COMPROBANTE;
	}
	public void setCATEGORIA(String cATEGORIA) {
		CATEGORIA = cATEGORIA;
	}
	public void setIMPORTE(float iMPORTE) {
		IMPORTE = iMPORTE;
	}
	public void setP_DESCUENTO(float p_DESCUENTO) {
		P_DESCUENTO = p_DESCUENTO;
	}
	public void setTOTAL_CON_DESCUENTO(float tOTAL_CON_DESCUENTO) {
		TOTAL_CON_DESCUENTO = tOTAL_CON_DESCUENTO;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CEPeajeDTOSalida [ID_PEAJE=");
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
		builder.append(", P_DESCUENTO=");
		builder.append(P_DESCUENTO);
		builder.append(", TOTAL_CON_DESCUENTO=");
		builder.append(TOTAL_CON_DESCUENTO);
		builder.append("]");
		return builder.toString();
	}
	
}
