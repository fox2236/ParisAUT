package ParisAUT;

public class sesionTest extends Base{

    //@Test
    public void inicioLogoBorde() throws InterruptedException {
        super.aperturaPagina();

    }

    //@Test
    public void setUsuarioValidacionOK() throws InterruptedException {
        String usuario = "dummytestmail1000@gmail.com";
        String contraseña = "Fantasma2236";

        aperturaPagina();

        click(inicioSesion);
        Thread.sleep(1000);
        click(btnInicioSesion);
        Thread.sleep(2000);
        setUsuarioPasswd(usuario,contraseña);

    }
    //@Test
    public void setUsuarioValidacionNok() throws InterruptedException {
        String usuario = "dummytestmail1000@gmail.com";
        String contraseña = "Fakepasswd";

        aperturaPagina();

        click(inicioSesion);
        Thread.sleep(1000);
        click(btnInicioSesion);
        Thread.sleep(2000);
        setUsuarioPasswd(usuario,contraseña);

    }

}

