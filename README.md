
#  Eclipse OSGI Spifly use to inject dependencies Demo

This demo is bound as demo for issues 

* https://github.com/eclipse-ee4j/jersey/issues/5834
* https://github.com/jakartaee/rest/issues/1304

This is based on an `Eclipse-RCP 2025-03` installation.
Load the `demolocal.target` which contains the local Eclipse installation + jaxb-osgi from maven

This demonstrates the usage and interconnection of JAXB in an Eclipse headless application.

There are 2 launch configurations. Please use the Eclipse `Compare With / Each other` function on them.

# `NoSpifly.launch`

Contains all required bundles to run JAXB. Executing it results in

```
!ENTRY org.eclipse.osgi 4 0 2025-02-05 08:18:15.961
!MESSAGE Application error
!STACK 1
jakarta.xml.bind.JAXBException: Implementation of Jakarta XML Binding-API has not been found on module path or classpath.
 - with linked exception:
[java.lang.ClassNotFoundException: org.glassfish.jaxb.runtime.v2.ContextFactory]
	at jakarta.xml.bind.ContextFinder.newInstance(ContextFinder.java:250)
	at jakarta.xml.bind.ContextFinder.newInstance(ContextFinder.java:238)
	at jakarta.xml.bind.ContextFinder.find(ContextFinder.java:386)
	at jakarta.xml.bind.JAXBContext.newInstance(JAXBContext.java:605)
	at jakarta.xml.bind.JAXBContext.newInstance(JAXBContext.java:546)
	at at.medevit.demo.osgireqcap.JakartaJaxb.<init>(JakartaJaxb.java:19
```

as the `jaxb-osgi` service is not injected into `jaxb-api`.

Now run

## `YesSpifly.launch`

You will see the following output

```
WARNING: Using incubator modules: jdk.incubator.vector
Feb. 05, 2025 8:19:56 AM org.apache.aries.spifly.BaseActivator log
INFORMATION: Registered provider com.sun.tools.rngdatatype.helpers.ProxyDatatypeLibraryFactory of service com.sun.tools.rngdatatype.DatatypeLibraryFactory in bundle com.sun.xml.bind.jaxb-osgi
Feb. 05, 2025 8:19:56 AM org.apache.aries.spifly.BaseActivator log
INFORMATION: Registered provider com.sun.tools.xjc.addon.code_injector.PluginImpl of service com.sun.tools.xjc.Plugin in bundle com.sun.xml.bind.jaxb-osgi
Feb. 05, 2025 8:19:56 AM org.apache.aries.spifly.BaseActivator log
INFORMATION: Registered provider com.sun.tools.xjc.addon.locator.SourceLocationAddOn of service com.sun.tools.xjc.Plugin in bundle com.sun.xml.bind.jaxb-osgi
Feb. 05, 2025 8:19:56 AM org.apache.aries.spifly.BaseActivator log
INFORMATION: Registered provider com.sun.tools.xjc.addon.sync.SynchronizedMethodAddOn of service com.sun.tools.xjc.Plugin in bundle com.sun.xml.bind.jaxb-osgi
Feb. 05, 2025 8:19:56 AM org.apache.aries.spifly.BaseActivator log
INFORMATION: Registered provider com.sun.tools.xjc.addon.at_generated.PluginImpl of service com.sun.tools.xjc.Plugin in bundle com.sun.xml.bind.jaxb-osgi
Feb. 05, 2025 8:19:56 AM org.apache.aries.spifly.BaseActivator log
INFORMATION: Registered provider com.sun.tools.xjc.addon.episode.PluginImpl of service com.sun.tools.xjc.Plugin in bundle com.sun.xml.bind.jaxb-osgi
Feb. 05, 2025 8:19:56 AM org.apache.aries.spifly.BaseActivator log
INFORMATION: Registered provider com.sun.tools.xjc.addon.accessors.PluginImpl of service com.sun.tools.xjc.Plugin in bundle com.sun.xml.bind.jaxb-osgi
Feb. 05, 2025 8:19:56 AM org.apache.aries.spifly.BaseActivator log
INFORMATION: Registered provider org.glassfish.jaxb.runtime.v2.JAXBContextFactory of service jakarta.xml.bind.JAXBContextFactory in bundle com.sun.xml.bind.jaxb-osgi
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<entity someString="9f516947-dfc6-4d13-acfd-f5bfe6eb3bfe"/>
```

where the first entries show how spifly connects the services, and a real JAXB process with output happening.




