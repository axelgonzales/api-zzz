package pe.financieraoh.apiseguro.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaUtil {

	public static Date parseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return fechaDate;
    }
}
