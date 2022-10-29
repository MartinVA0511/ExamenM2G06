package pe.unjfsc.daw.writer;

import java.io.File;

import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import pe.unjfsc.daw.entity.CEPeajeDTOSalida;

public class CDPeajeWriter implements ItemWriter<CEPeajeDTOSalida> {

	private static final Logger LOG = LoggerFactory.getLogger(CDPeajeWriter.class);

	public void write(List<? extends CEPeajeDTOSalida> poPeajeSalida) throws Exception {

		LOG.info("[DAW] =====[ Start write ]=====");

		LOG.info("[DAW] Object output : {} ", poPeajeSalida.toString());
		for (CEPeajeDTOSalida peaje : poPeajeSalida) {

			LOG.info("[DAW] Data Peaje read  : {}", peaje.toString());

		}

		writeFileInSystem(poPeajeSalida);
	}

	public void writeFileInSystem(List<? extends CEPeajeDTOSalida> poPeajeDTOSalida) throws Exception {
		LOG.info("[DAW] =====[ Empezando a generar el archivo XML ]=====");
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// Elemento raíz
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("root");
		doc.appendChild(rootElement);

		for (CEPeajeDTOSalida data : poPeajeDTOSalida) {
			Element tag = doc.createElement("DATA_PEAJE");
			rootElement.appendChild(tag);

			Element id = doc.createElement("ID_PEAJE");
			id.setTextContent(String.valueOf(data.getID_PEAJE()));
			tag.appendChild(id);

			Element ec = doc.createElement("EMPRESA_CONCESION");
			ec.setTextContent(data.getEMPRESA_CONCESION());
			tag.appendChild(ec);

			Element rc = doc.createElement("RUC_CONCESION");
			rc.setTextContent(data.getRUC_CONCESION());
			tag.appendChild(rc);

			Element dc = doc.createElement("DIRECCION_CONCESION");
			dc.setTextContent(data.getDIRECCION_CONCESION());
			tag.appendChild(dc);

			Element uc = doc.createElement("UBICACION_CONCESION");
			uc.setTextContent(data.getUBICACION_CONCESION());
			tag.appendChild(uc);

			Element fp = doc.createElement("FECHA_PEAJE");
			fp.setTextContent(data.getFECHA_PEAJE());
			tag.appendChild(fp);

			Element hp = doc.createElement("HORA_PEAJE");
			hp.setTextContent(data.getHORA_PEAJE());
			tag.appendChild(hp);

			Element tc = doc.createElement("TIPO_DE_COMPROBANTE");
			tc.setTextContent(data.getTIPO_DE_COMPROBANTE());
			tag.appendChild(tc);

			Element nc = doc.createElement("N_DE_COMPROBANTE");
			nc.setTextContent(data.getNº_DE_COMPROBANTE());
			tag.appendChild(nc);

			Element cat = doc.createElement("CATEGORIA");
			cat.setTextContent(data.getCATEGORIA());
			tag.appendChild(cat);

			Element imp = doc.createElement("IMPORTE");
			imp.setTextContent(String.valueOf(data.getIMPORTE()));
			tag.appendChild(imp);

			Element pd = doc.createElement("P_DESCUENTO");
			pd.setTextContent(String.valueOf(data.getP_DESCUENTO()));
			tag.appendChild(pd);

			Element td = doc.createElement("TOTAL_CON_DESCUENTO");
			td.setTextContent(String.valueOf(data.getTOTAL_CON_DESCUENTO()));
			tag.appendChild(td);
		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("src/main/resources/fuente/output/peaje.xml"));
		transformer.transform(source, result);
		LOG.info("[EVL] Se ha cargado los datos.");
	}

}
