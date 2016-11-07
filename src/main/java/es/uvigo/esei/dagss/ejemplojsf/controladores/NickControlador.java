package es.uvigo.esei.dagss.ejemplojsf.controladores;

import es.uvigo.esei.dagss.ejemplojsf.daos.NickDAO;
import es.uvigo.esei.dagss.ejemplojsf.entidades.Nick;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

@Named(value = "nickControlador")
@SessionScoped
public class NickControlador implements Serializable {

    @Inject
    private NickDAO nickDAO;

    private List<Nick> nicks;
    private Nick nickActual;
    private String nombreNickBuscar;

    public NickControlador() {
    }

    public List<Nick> getNicks() {
        return nicks;
    }

    public void setNicks(List<Nick> nicks) {
        this.nicks = nicks;
    }

    public Nick getNickActual() {
        return nickActual;
    }

    public void setNickActual(Nick nickActual) {
        this.nickActual = nickActual;
    }

    public String getNombreNickBuscar() {
        return nombreNickBuscar;
    }

    public void setNombreNickBuscar(String nombreNickBuscar) {
        this.nombreNickBuscar = nombreNickBuscar;
    }

    @PostConstruct
    public void inicializarDatosControlador() {
        nicks = nickDAO.buscarTodos();
        nickActual = inicializarNickActual();
    }

    private Nick inicializarNickActual() {
        Nick visitante = nickDAO.buscarPorNick("visitante");
        if (visitante == null) {  // No existe
            visitante = nickDAO.crear(new Nick("visitante", "Usuario Visitante"));
        }
        return visitante;
    }

    public String doCrearNuevoNick() {
        this.nickActual = new Nick();
        return "nuevo_nick";
    }

    public String doCancelarNuevoNick() {
        inicializarNickActual();
        
        return "listado_nicks";
    }

    public String doGuardarNuevoNick() {
        nickDAO.crear(nickActual);
        nicks = nickDAO.buscarTodos(); // Refrescar listado

        return "listado_nicks";
    }
    
    public String doBuscarNombreNick() {
        nicks = nickDAO.buscarPorNombre(nombreNickBuscar);

        return "listado_nick";
    }
    
    public String doSeleccionarNick(Nick nick) {
        nickActual = nick;
        
        return "listado_nicks";
    }
    
    public String doVerAnuncios(Nick nick) {
        nickActual = nick;
        
        return "listado_anuncios";
    }

}
