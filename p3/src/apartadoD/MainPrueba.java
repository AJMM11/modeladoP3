package apartadoD;
import java.util.Date;

import Roles.Socio;

public class MainPrueba {
	public static void main(String[] args) {
		Socio socio = new Socio(new Date(), null);

		Socio.showAsignableRoles();
		socio.addRol(socio);
	}
}
