package at.medevit.demo.osgireqcap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Entity {

	@XmlAttribute
	public String someString;

	public void setSomeString(String someString) {
		this.someString = someString;
	}

	public String getSomeString() {
		return someString;
	}
}
