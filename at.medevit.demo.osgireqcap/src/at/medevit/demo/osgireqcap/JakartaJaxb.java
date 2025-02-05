package at.medevit.demo.osgireqcap;

import java.io.IOException;
import java.io.StringWriter;
import java.util.UUID;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class JakartaJaxb {

	public JakartaJaxb() throws JAXBException, IOException {

		Entity entity = new Entity();
		entity.setSomeString(UUID.randomUUID().toString());

		try (StringWriter sw = new StringWriter()) {
			JAXBContext jaxbContext = JAXBContext.newInstance(Entity.class);
			Marshaller m = jaxbContext.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(entity, sw);
			System.out.println(sw.toString());
		}
	}

}
