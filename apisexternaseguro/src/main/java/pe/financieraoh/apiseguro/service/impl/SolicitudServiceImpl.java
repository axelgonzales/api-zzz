package pe.financieraoh.apiseguro.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.financieraoh.apiseguro.constant.Constant;
import pe.financieraoh.apiseguro.controller.request.SolicitudRequest;
import pe.financieraoh.apiseguro.domain.Persona;
import pe.financieraoh.apiseguro.domain.Solicitud;
import pe.financieraoh.apiseguro.domain.SolicitudOncologico;
import pe.financieraoh.apiseguro.domain.SolicitudPT;
import pe.financieraoh.apiseguro.domain.TipoCancelacion;
import pe.financieraoh.apiseguro.domain.TipoProducto;
import pe.financieraoh.apiseguro.exception.PersonaNotFoundException;
import pe.financieraoh.apiseguro.exception.PolizaCancelException;
import pe.financieraoh.apiseguro.exception.PolizaDateNotFoundException;
import pe.financieraoh.apiseguro.exception.PolizaNotFoundException;
import pe.financieraoh.apiseguro.exception.ProductoNotFoundException;
import pe.financieraoh.apiseguro.exception.TipCancelacionNotFoundException;
import pe.financieraoh.apiseguro.repository.PersonaRepository;
import pe.financieraoh.apiseguro.repository.SolicitudOncologicoRespository;
import pe.financieraoh.apiseguro.repository.SolicitudPtRepository;
import pe.financieraoh.apiseguro.repository.TipoCancelacionRepository;
import pe.financieraoh.apiseguro.repository.TipoProductoRepository;
import pe.financieraoh.apiseguro.service.SolicitudService;
import pe.financieraoh.apiseguro.util.FechaUtil;

@Service
public class SolicitudServiceImpl  implements SolicitudService{

	@Autowired
	private TipoProductoRepository tipProductoRepository;
	
	@Autowired
	private TipoCancelacionRepository tipoCancelacionRepository;

	@Autowired
	private SolicitudPtRepository solicitudPTRepository;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private SolicitudOncologicoRespository solicitudOncologicoRespository;
	
	@Override
	public void cancel(SolicitudRequest solicitudRequest) {
		
		if (solicitudRequest.getCodTipProducto().intValue() == 1) {
			Optional<SolicitudPT> resultSolicitud = solicitudPTRepository.findById(solicitudRequest.getNroSolicitud());
			SolicitudPT solicitud = resultSolicitud.get();
			solicitud.setCodTipCancelacion(solicitudRequest.getCodTipCancelacion());
			solicitud.setFecCancelacion(FechaUtil.parseFecha(solicitudRequest.getFecCancelacion()));
			solicitud.setEstSolicitud(Constant.EST_SOLICITUD_PT_CANCEL);
			solicitud.setUsuActualizacion(solicitudRequest.getUsrCancelacion());
			solicitudPTRepository.save(solicitud);
		}else if(solicitudRequest.getCodTipProducto().intValue() == 2) {
			Optional<SolicitudOncologico> resultSolicitud = solicitudOncologicoRespository.findById(solicitudRequest.getNroSolicitud());
			SolicitudOncologico solicitud = resultSolicitud.get();
			solicitud.setCodTipCancelacion(solicitudRequest.getCodTipCancelacion());
			solicitud.setFecCancelacion(FechaUtil.parseFecha(solicitudRequest.getFecCancelacion()));
			solicitud.setEstSolicitud(Constant.EST_SOLICITUD_ONCOLOGICO_CANCEL);
			solicitud.setUsuActualizacion(solicitudRequest.getUsrCancelacion());
			solicitudOncologicoRespository.save(solicitud);
		}
		
	}

	@Override
	public void validate(SolicitudRequest solicitudRequest) {
		
		Optional<TipoProducto> resultTipProducto = tipProductoRepository.findById(solicitudRequest.getCodTipProducto());
						
		if (!resultTipProducto.isPresent()) {
			throw new ProductoNotFoundException(solicitudRequest.getCodTipCancelacion() +"");
		}
		Optional<TipoCancelacion> resultTipCancelaciuon =  tipoCancelacionRepository.findById(solicitudRequest.getCodTipCancelacion());
		if (!resultTipCancelaciuon.isPresent()) {
			throw new TipCancelacionNotFoundException(solicitudRequest.getCodTipCancelacion() +"");
		}
		if(resultTipCancelaciuon.get().getCodTipProducto().intValue() != solicitudRequest.getCodTipProducto().intValue()) {
			throw new TipCancelacionNotFoundException(solicitudRequest.getCodTipCancelacion() +"");
		}
		
		Solicitud solicitud = null;
		if (solicitudRequest.getCodTipProducto().intValue() == 1) {
			Optional<SolicitudPT>  resultSolicitudPt =  solicitudPTRepository.findById(solicitudRequest.getNroSolicitud());
			if (!resultSolicitudPt.isPresent()) {
				throw new PolizaNotFoundException(solicitudRequest.getCodTipCancelacion() +"");
			}
			SolicitudPT solicitudPt = resultSolicitudPt.get();
			solicitud = new Solicitud();
			solicitud.setFecSolicitud(solicitudPt.getFecSolicitud());
			solicitud.setCodInterno(solicitudPt.getCodInterno());

			if (solicitudPt.getEstSolicitud().intValue() == Constant.EST_SOLICITUD_PT_CANCEL.intValue()) {
				throw new PolizaCancelException(solicitudRequest.getCodTipCancelacion() +"");
			}
		}
		
		else if(solicitudRequest.getCodTipProducto().intValue() == 2) {
			Optional<SolicitudOncologico>  resultSolicitudOnco = solicitudOncologicoRespository.findById(solicitudRequest.getNroSolicitud());
			if (!resultSolicitudOnco.isPresent()) {
				throw new PolizaNotFoundException(solicitudRequest.getCodTipCancelacion() +"");
			}
			SolicitudOncologico solicitudOnco = resultSolicitudOnco.get();
			solicitud = new Solicitud();
			solicitud.setFecSolicitud(solicitudOnco.getFecSolicitud());
			solicitud.setCodInterno(solicitudOnco.getCodInterno());

			if (solicitudOnco.getEstSolicitud().intValue() == Constant.EST_SOLICITUD_ONCOLOGICO_CANCEL.intValue()) {
				throw new PolizaCancelException(solicitudRequest.getCodTipCancelacion() +"");
			}
		}

		DateFormat fechaHora = new SimpleDateFormat("dd/MM/yyyy");
		String fechaFormat = fechaHora.format(solicitud.getFecSolicitud());

		if (!fechaFormat.equals(solicitudRequest.getFecIniVigencia())) { 
			throw new PolizaDateNotFoundException(solicitudRequest.getCodTipCancelacion() +"");
		}
		
		Optional<Persona> resultPersona =  personaRepository.findById(solicitud.getCodInterno());
		if (!resultPersona.isPresent()) {
			throw new PersonaNotFoundException(solicitudRequest.getCodTipCancelacion() +"");
		}
		Persona persona = resultPersona.get();
		if (!persona.getNumDocumIde().equals(solicitudRequest.getNroDocumento()) ||
			!persona.getTipDocumIde().equals(solicitudRequest.getTipoDocumento())){
			throw new PersonaNotFoundException(solicitudRequest.getCodTipCancelacion() +"");
		}
		
	}

}
