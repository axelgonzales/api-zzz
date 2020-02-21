package pe.financieraoh.apiseguro.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FechaUtil {

	public FechaUtil() {
	}
	
	public static Date parseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (java.text.ParseException e) {
			log.error(e.getLocalizedMessage());
		}
        return fechaDate;
    }
}
