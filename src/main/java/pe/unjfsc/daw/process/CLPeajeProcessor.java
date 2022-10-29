package pe.unjfsc.daw.process;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import pe.unjfsc.daw.entity.CEPeajeDTOEntrada;
import pe.unjfsc.daw.entity.CEPeajeDTOSalida;

public class CLPeajeProcessor implements ItemProcessor<CEPeajeDTOEntrada, CEPeajeDTOSalida> {

	private static final Logger MOLOG = LoggerFactory.getLogger(CLPeajeProcessor.class);

	
	public CEPeajeDTOSalida process(CEPeajeDTOEntrada poItemPeaje) throws Exception {

		MOLOG.info("[DAW] =====[ Start process ]=====");

		MOLOG.info("[DAW] Data received input : {} ", poItemPeaje.toString());

		CEPeajeDTOSalida oPeajeSalida = new CEPeajeDTOSalida();
		
		oPeajeSalida.setID_PEAJE(poItemPeaje.getID_PEAJE());
		oPeajeSalida.setEMPRESA_CONCESION(poItemPeaje.getEMPRESA_CONCESION());
		oPeajeSalida.setRUC_CONCESION(poItemPeaje.getRUC_CONCESION());
		oPeajeSalida.setDIRECCION_CONCESION(poItemPeaje.getDIRECCION_CONCESION());
		oPeajeSalida.setUBICACION_CONCESION(poItemPeaje.getUBICACION_CONCESION());
		oPeajeSalida.setFECHA_PEAJE(poItemPeaje.getFECHA_PEAJE());
		oPeajeSalida.setHORA_PEAJE(poItemPeaje.getHORA_PEAJE());
		oPeajeSalida.setTIPO_DE_COMPROBANTE(poItemPeaje.getTIPO_DE_COMPROBANTE());
		oPeajeSalida.setNº_DE_COMPROBANTE(poItemPeaje.getNº_DE_COMPROBANTE());
		oPeajeSalida.setCATEGORIA(poItemPeaje.getCATEGORIA());
		oPeajeSalida.setIMPORTE(poItemPeaje.getIMPORTE());
		oPeajeSalida.setP_DESCUENTO(getDescuento(poItemPeaje));
		oPeajeSalida.setTOTAL_CON_DESCUENTO(getTotalDesc(poItemPeaje));

		MOLOG.info("[DAW] New CEPeajeDTOSalida : {} ", oPeajeSalida.toString());

		return oPeajeSalida;
	}

	public float getDescuento(CEPeajeDTOEntrada poItemPeaje) {
		ArrayList<String> UB_CONCESION_LIST = new ArrayList<String>();

		UB_CONCESION_LIST.add(0,"VILLA");
		UB_CONCESION_LIST.add(1,"PUNTA NEGRA");
		UB_CONCESION_LIST.add(2,"ACCESO SAN PEDRO");
		UB_CONCESION_LIST.add(3,"CHILLON");
		UB_CONCESION_LIST.add(4,"ACCESO ARICA");
		UB_CONCESION_LIST.add(5,"PARAISO");
		UB_CONCESION_LIST.add(6,"VARIANTE");
		UB_CONCESION_LIST.add(7,"CONCHAN");
		UB_CONCESION_LIST.add(8,"CHILCA");

		ArrayList<String> DESC_LIST = new ArrayList<String>();

		DESC_LIST.add(0,"0.05");
		DESC_LIST.add(1,"0.06");
		DESC_LIST.add(2,"0.07");
		DESC_LIST.add(3,"0.15");
		DESC_LIST.add(4,"0.25");
		DESC_LIST.add(5,"0.35");
		DESC_LIST.add(6,"0.15");
		DESC_LIST.add(7,"0.17");
		DESC_LIST.add(8,"0.20");

		float desc = Float.parseFloat(DESC_LIST.get(UB_CONCESION_LIST.indexOf(poItemPeaje.getUBICACION_CONCESION())));

		return desc;
	}

	public float getTotalDesc(CEPeajeDTOEntrada poItemPeaje) {
		float t_desc = poItemPeaje.getIMPORTE() - (poItemPeaje.getIMPORTE() * getDescuento(poItemPeaje));
		return t_desc;
	}
}
