package za.co.jobcreation.ejb.impl.util;

import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Node;

/**
 * @author khumbu
 * 
 */
public class JaxbHelper {

	private static final Map<String, JAXBContext> JAXB_CONTEXT_CACHE = new HashMap<String, JAXBContext>();
	private static Object lock = new Object();

	public <T> String marshal(T object, String packageName, Boolean FormaXml) {

		String result = null;
		try {
			JAXBContext jc = getContext(packageName);

			Marshaller marshaller = jc.createMarshaller();
			StringWriter stringWriter = new StringWriter();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, FormaXml);
			marshaller.marshal(object, stringWriter);
			result = stringWriter.toString();

		} catch (JAXBException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return result;
	}

	public <T> String marshal(T object, String packageName) {

		return marshal(object, packageName, false);
	}

	public <T> T unmarsharl(Class<T> clazz, String xmlFileName, String packageName) {

		try {
			JAXBContext jc = getContext(packageName);
			Unmarshaller u = jc.createUnmarshaller();
			JAXBElement<T> element = u.unmarshal(new StreamSource(new File(xmlFileName)), clazz);
			return element.getValue();
		} catch (JAXBException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public <T> T unmarsharl(Node node, Class<T> clazz, String packageName) {

		try {

			JAXBContext jc = getContext(packageName);
			Unmarshaller u = jc.createUnmarshaller();
			JAXBElement<T> element = u.unmarshal(node, clazz);
			return element.getValue();

		} catch (JAXBException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	private static JAXBContext getContext(String packageName) throws JAXBException {
		if (!JAXB_CONTEXT_CACHE.containsKey(packageName)) {
			synchronized (lock) {
				if (!JAXB_CONTEXT_CACHE.containsKey(packageName)) {
					JAXB_CONTEXT_CACHE.put(packageName, JAXBContext.newInstance(packageName));
				}
			}
		}
		return JAXB_CONTEXT_CACHE.get(packageName);
	}

	// public static void main(String[] args) {
	//
	// JaxbHelper jaxbHelper = new JaxbHelper();
	//
	// PRODUCTCONFIGLIST productconfiglist =
	// jaxbHelper.unmarsharl(PRODUCTCONFIGLIST.class,
	// "./FNB-product-catalog_15April.xml", "za.co.jobcreation.ejb.mvno");
	// System.out.println(productconfiglist);
	// System.out.println(productconfiglist.getPRODUCTCONFIG().get(0).getDESCRIPTION());
	//
	// }
}
