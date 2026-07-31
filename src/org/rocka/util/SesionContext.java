
package org.rocka.util;
import org.rocka.model.Usuario;

public class SesionContext {
    private static SesionContext instancia;
    private Usuario usuarioActual;

    public SesionContext() {
    }
    
    public static synchronized SesionContext getInstancia(){
        if (instancia == null) {
            instancia = new SesionContext();
        }
        return instancia;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
    
    public void cerrarSesion(){
        this.usuarioActual = null;
    }
    
}