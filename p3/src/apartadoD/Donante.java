import java.util.Enumeration;

public interface Donante {

    public Enumeration<Donacion> getDonaciones();

    //Operacion donar
    public void donar(Double c);

}
