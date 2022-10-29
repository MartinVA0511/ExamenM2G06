package pe.unjfsc.daw.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import pe.unjfsc.daw.entity.CEPeajeDTOEntrada;

public class CLPeajeMapper implements FieldSetMapper<CEPeajeDTOEntrada> {

	private static final Logger MOLOG = LoggerFactory.getLogger(CLPeajeMapper.class);

	
	public CEPeajeDTOEntrada mapFieldSet(FieldSet fieldSet) throws BindException {

		MOLOG.info("[DAW] =====[ Start mapFieldSet ]=====");
		MOLOG.info("[DAW] read record : {} ", fieldSet.toString());

		CEPeajeDTOEntrada oPeajeEntrada = new CEPeajeDTOEntrada();
		
		oPeajeEntrada.setID_PEAJE(fieldSet.readInt("ID"));
		oPeajeEntrada.setEMPRESA_CONCESION(fieldSet.readString("EMPRESA_CONCESION"));
		oPeajeEntrada.setRUC_CONCESION(fieldSet.readString("RUC_CONCESION"));
		oPeajeEntrada.setDIRECCION_CONCESION(fieldSet.readString("DIRECCION_CONCESION"));
		oPeajeEntrada.setUBICACION_CONCESION(fieldSet.readString("UBICACION_CONCESION"));
		oPeajeEntrada.setFECHA_PEAJE(fieldSet.readString("FECHA_PEAJE"));
		oPeajeEntrada.setHORA_PEAJE(fieldSet.readString("HORA_PEAJE"));
		oPeajeEntrada.setTIPO_DE_COMPROBANTE(fieldSet.readString("TIPO_DE_COMPROBANTE"));
		oPeajeEntrada.setNº_DE_COMPROBANTE(fieldSet.readString("N°_DE_COMPROBANTE"));
		oPeajeEntrada.setCATEGORIA(fieldSet.readString("CATEGORIA"));
		oPeajeEntrada.setIMPORTE(fieldSet.readFloat("IMPORTE"));

		MOLOG.info("[DAW] Mapper to CEPeajeDTOEntrada : {}", oPeajeEntrada.toString());

		return oPeajeEntrada;
	}

}
