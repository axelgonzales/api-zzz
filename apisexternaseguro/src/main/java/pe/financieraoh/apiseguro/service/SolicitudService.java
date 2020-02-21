package pe.financieraoh.apiseguro.service;

import pe.financieraoh.apiseguro.controller.request.SolicitudRequest;

public interface SolicitudService {

	void cancel(SolicitudRequest solicitudRequest);
	void validate(SolicitudRequest solicitudRequest);
}
