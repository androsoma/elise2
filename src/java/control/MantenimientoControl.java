/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import ejb.inventario.UsuarioFacade;
import ejb.mantenimiento.AccionCierreFacade;
import ejb.mantenimiento.AccionCierreReporteFacade;
import ejb.mantenimiento.EstadoReporteFacade;
import ejb.mantenimiento.ReportePuntoLuzFacade;
import ejb.mantenimiento.TipoEstadoReporteFacade;
import entidades.inventario.Usuario;
import entidades.mantenimiento.AccionCierre;
import entidades.mantenimiento.AccionCierreReporte;
import entidades.mantenimiento.EstadoReporte;
import entidades.mantenimiento.ReportePuntoLuz;
import entidades.mantenimiento.TipoEstadoReporte;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author LENOVO
 */
@ManagedBean
@SessionScoped
@Named("mantenimientoControl")
public class MantenimientoControl {

    private List<String> reportes = null;
    private List<ReportePuntoLuz> incidentes = null;
    private ReportePuntoLuz reportePuntoLuzSeleccionado = new ReportePuntoLuz();
    private List<AccionCierre> accionesCierreDisponibles = null;
    private List<String> accionesSeleccionadas = new ArrayList<>();
    private String[] accionesCierreSeleccionadas = new String[]{};
    private List<AccionCierreReporte> accionesCierreReporte = null;

    @EJB
    @Inject
    private ReportePuntoLuzFacade reportePuntoLuzFacade;

    @EJB
    @Inject
    private AccionCierreFacade accionCierreFacade;

    @EJB
    @Inject
    private AccionCierreReporteFacade accionCierreReporteFacade;

    @EJB
    @Inject
    private UsuarioFacade usuarioFacade;

    @EJB
    @Inject
    private TipoEstadoReporteFacade tipoEstadoReporteFacade;
    
    @EJB
    @Inject
    private EstadoReporteFacade estadoReporteFacade;

    /**
     * Creates a new instance of MantenimientoControl
     */
    public MantenimientoControl() {
    }

    public List<String> getReportes() {
        return reportes;
    }

    public void setReportes(List<String> reportes) {
        this.reportes = reportes;
    }

    public List<ReportePuntoLuz> getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(List<ReportePuntoLuz> incidentes) {
        this.incidentes = incidentes;
    }

    public ReportePuntoLuz getReportePuntoLuzSeleccionado() {
        return reportePuntoLuzSeleccionado;
    }

    public void setReportePuntoLuzSeleccionado(ReportePuntoLuz reportePuntoLuzSeleccionado) {
        this.reportePuntoLuzSeleccionado = reportePuntoLuzSeleccionado;
    }

    public ReportePuntoLuzFacade getReportePuntoLuzFacade() {
        return reportePuntoLuzFacade;
    }

    public void setReportePuntoLuzFacade(ReportePuntoLuzFacade reportePuntoLuzFacade) {
        this.reportePuntoLuzFacade = reportePuntoLuzFacade;
    }

    public List<AccionCierre> getAccionesCierreDisponibles() {
        return accionesCierreDisponibles;
    }

    public void setAccionesCierreDisponibles(List<AccionCierre> accionesCierreDisponibles) {
        this.accionesCierreDisponibles = accionesCierreDisponibles;
    }

    public List<String> getAccionesSeleccionadas() {
        return accionesSeleccionadas;
    }

    public void setAccionesSeleccionadas(List<String> accionesSeleccionadas) {
        this.accionesSeleccionadas = accionesSeleccionadas;
    }

    public String[] getAccionesCierreSeleccionadas() {
        return accionesCierreSeleccionadas;
    }

    public void setAccionesCierreSeleccionadas(String[] accionesCierreSeleccionadas) {
        this.accionesCierreSeleccionadas = accionesCierreSeleccionadas;
    }

    public List<AccionCierreReporte> getAccionesCierreReporte() {
        return accionesCierreReporte;
    }

    public void setAccionesCierreReporte(List<AccionCierreReporte> accionesCierreReporte) {
        this.accionesCierreReporte = accionesCierreReporte;
    }

    public AccionCierreFacade getAccionCierreFacade() {
        return accionCierreFacade;
    }

    public void setAccionCierreFacade(AccionCierreFacade accionCierreFacade) {
        this.accionCierreFacade = accionCierreFacade;
    }

    public AccionCierreReporteFacade getAccionCierreReporteFacade() {
        return accionCierreReporteFacade;
    }

    public void setAccionCierreReporteFacade(AccionCierreReporteFacade accionCierreReporteFacade) {
        this.accionCierreReporteFacade = accionCierreReporteFacade;
    }

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public TipoEstadoReporteFacade getTipoEstadoReporteFacade() {
        return tipoEstadoReporteFacade;
    }

    public void setTipoEstadoReporteFacade(TipoEstadoReporteFacade tipoEstadoReporteFacade) {
        this.tipoEstadoReporteFacade = tipoEstadoReporteFacade;
    }

    public EstadoReporteFacade getEstadoReporteFacade() {
        return estadoReporteFacade;
    }

    public void setEstadoReporteFacade(EstadoReporteFacade estadoReporteFacade) {
        this.estadoReporteFacade = estadoReporteFacade;
    }

    public void cargarIncidentesConfirmados() {
        incidentes = new ArrayList<>();

        //Consultar incidentes en TipoEstadoReporte confirmados.
        incidentes = reportePuntoLuzFacade.consultarPorTipoEstadoReporte(2L); 
    }

    public void seleccionarIncidente(ReportePuntoLuz incidenteSelccionado) {
        reportePuntoLuzSeleccionado = incidenteSelccionado;
    }

    public void cargarAccionesCierre() {
        accionesCierreDisponibles = new ArrayList<>();
        accionesCierreDisponibles = accionCierreFacade.findAll();
    }

    public void cerrarReporte() {
        for (String accionCierre : accionesSeleccionadas) {
            AccionCierreReporte accionCierreReporte = new AccionCierreReporte();

            accionCierreReporte.setReportePuntoLuz(reportePuntoLuzSeleccionado);
            accionCierreReporte.setAccionCierre(accionCierreFacade.find(Long.valueOf(accionCierre)));
            accionCierreReporte.setFechaRegistro(new Date());

            accionCierreReporteFacade.create(accionCierreReporte);
        }

        TipoEstadoReporte tipoEstadoReporte = tipoEstadoReporteFacade.find(3L);
        Usuario usuario = usuarioFacade.find(1L); //Cambiar

        EstadoReporte estadoReporte = new EstadoReporte();
        estadoReporte.setReportePuntoLuz(reportePuntoLuzSeleccionado);
        estadoReporte.setTipoEstadoReporte(tipoEstadoReporte);
        estadoReporte.setUsuario(usuario);
        estadoReporte.setFechaCambioEstado(new Date());
        
        estadoReporteFacade.create(estadoReporte);
        
        cargarIncidentesConfirmados();
    }

    public void imprimirSeleccionadas() {
        for (String accion : accionesCierreSeleccionadas) {
            System.out.println("Acción seleccionada: " + accion);
        }
    }

}
