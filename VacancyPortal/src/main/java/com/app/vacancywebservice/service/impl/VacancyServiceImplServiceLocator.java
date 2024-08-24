/**
 * VacancyServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4.1-SNAPSHOT Nov 07, 2023 (07:57:58 UTC) WSDL2Java emitter.
 */

package com.app.vacancywebservice.service.impl;

public class VacancyServiceImplServiceLocator extends org.apache.axis.client.Service implements com.app.vacancywebservice.service.impl.VacancyServiceImplService {

    public VacancyServiceImplServiceLocator() {
    }


    public VacancyServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public VacancyServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for VacancyServiceImpl
    private java.lang.String VacancyServiceImpl_address = "http://localhost:8080/VacWebSer/services/VacancyServiceImpl";

    public java.lang.String getVacancyServiceImplAddress() {
        return VacancyServiceImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String VacancyServiceImplWSDDServiceName = "VacancyServiceImpl";

    public java.lang.String getVacancyServiceImplWSDDServiceName() {
        return VacancyServiceImplWSDDServiceName;
    }

    public void setVacancyServiceImplWSDDServiceName(java.lang.String name) {
        VacancyServiceImplWSDDServiceName = name;
    }

    public com.app.vacancywebservice.service.impl.VacancyServiceImpl getVacancyServiceImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(VacancyServiceImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getVacancyServiceImpl(endpoint);
    }

    public com.app.vacancywebservice.service.impl.VacancyServiceImpl getVacancyServiceImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.app.vacancywebservice.service.impl.VacancyServiceImplSoapBindingStub _stub = new com.app.vacancywebservice.service.impl.VacancyServiceImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getVacancyServiceImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setVacancyServiceImplEndpointAddress(java.lang.String address) {
        VacancyServiceImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.app.vacancywebservice.service.impl.VacancyServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.app.vacancywebservice.service.impl.VacancyServiceImplSoapBindingStub _stub = new com.app.vacancywebservice.service.impl.VacancyServiceImplSoapBindingStub(new java.net.URL(VacancyServiceImpl_address), this);
                _stub.setPortName(getVacancyServiceImplWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("VacancyServiceImpl".equals(inputPortName)) {
            return getVacancyServiceImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.service.vacancywebservice.app.com", "VacancyServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.service.vacancywebservice.app.com", "VacancyServiceImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("VacancyServiceImpl".equals(portName)) {
            setVacancyServiceImplEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
