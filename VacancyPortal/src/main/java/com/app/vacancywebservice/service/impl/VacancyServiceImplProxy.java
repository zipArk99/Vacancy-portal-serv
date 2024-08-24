package com.app.vacancywebservice.service.impl;

public class VacancyServiceImplProxy implements com.app.vacancywebservice.service.impl.VacancyServiceImpl {
  private String _endpoint = null;
  private com.app.vacancywebservice.service.impl.VacancyServiceImpl vacancyServiceImpl = null;
  
  public VacancyServiceImplProxy() {
    _initVacancyServiceImplProxy();
  }
  
  public VacancyServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initVacancyServiceImplProxy();
  }
  
  private void _initVacancyServiceImplProxy() {
    try {
      vacancyServiceImpl = (new com.app.vacancywebservice.service.impl.VacancyServiceImplServiceLocator()).getVacancyServiceImpl();
      if (vacancyServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)vacancyServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)vacancyServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (vacancyServiceImpl != null)
      ((javax.xml.rpc.Stub)vacancyServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.app.vacancywebservice.service.impl.VacancyServiceImpl getVacancyServiceImpl() {
    if (vacancyServiceImpl == null)
      _initVacancyServiceImplProxy();
    return vacancyServiceImpl;
  }
  
  public com.app.vacancywebservice.entity.Vacancy[] fetchVacancies() throws java.rmi.RemoteException{
    if (vacancyServiceImpl == null)
      _initVacancyServiceImplProxy();
    return vacancyServiceImpl.fetchVacancies();
  }
  
  
}