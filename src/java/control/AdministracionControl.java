package control;

import ejb.inventario.ConfiguracionFacade;
import ejb.inventario.PuntoLuzFacade;
import ejb.mantenimiento.ReportePuntoLuzFacade;
import ejb.mantenimiento.TipoIncidenteFacade;
import entidades.inventario.PuntoLuz;
import entidades.inventario.Tercero;
import entidades.inventario.Usuario;
import entidades.mantenimiento.Ciudadano;
import entidades.mantenimiento.ReportePuntoLuz;
import entidades.mantenimiento.TipoIncidente;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Yeison Osorio
 */
@ManagedBean
@SessionScoped
@Named("administracionControl")
public class AdministracionControl implements Serializable {

    private int opcion;
    private MapModel modeloMapa;
    private List<PuntoLuz> puntosLuz;
    private Marker marcadorPuntoLuz;
    private PuntoLuz puntoLuzSeleccionado;
    private String tituloPuntoLuzSeleccionado;
    private List<TipoIncidente> tiposIndicentes;
    private ReportePuntoLuz incidente;
    private UploadedFile uploadedFile;
    private List<UploadedFile> archivosCargados;
    private List<String> imagenesIncidente;
    private Usuario usuarioAutenticado;

    @EJB
    @Inject
    TipoIncidenteFacade tipoIncidenteFacade;

    @EJB
    @Inject
    PuntoLuzFacade puntoLuzFacade;

    @EJB
    @Inject
    ReportePuntoLuzFacade reportePuntoLuzFacade;

    @EJB
    @Inject
    ConfiguracionFacade configuracionFacade;

    public AdministracionControl() {
        inicializarReporteIncidente();
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public MapModel getModeloMapa() {
        puntosLuz = puntoLuzFacade.findAll();

        for (PuntoLuz puntoLuz : puntosLuz) {
            LatLng coordenadas = new LatLng(puntoLuz.getUbicacionPunto().getLatittud(), puntoLuz.getUbicacionPunto().getLongitud());
            marcadorPuntoLuz = new Marker(coordenadas, puntoLuz.getUbicacionPunto().getDireccion(), puntoLuz);
            modeloMapa.addOverlay(marcadorPuntoLuz);
        }

        return modeloMapa;
    }

    public void setModeloMapa(MapModel modeloMapa) {
        this.modeloMapa = modeloMapa;
    }

    public List<PuntoLuz> getPuntosLuz() {
        return puntosLuz;
    }

    public void setPuntosLuz(List<PuntoLuz> puntosLuz) {
        this.puntosLuz = puntosLuz;
    }

    public Marker getMarcadorPuntoLuz() {
        return marcadorPuntoLuz;
    }

    public void setMarcadorPuntoLuz(Marker marcadorPuntoLuz) {
        this.marcadorPuntoLuz = marcadorPuntoLuz;
    }

    public PuntoLuz getPuntoLuzSeleccionado() {
        return puntoLuzSeleccionado;
    }

    public void setPuntoLuzSeleccionado(PuntoLuz puntoLuzSeleccionado) {
        this.puntoLuzSeleccionado = puntoLuzSeleccionado;
    }

    public String getTituloPuntoLuzSeleccionado() {
        return tituloPuntoLuzSeleccionado;
    }

    public void setTituloPuntoLuzSeleccionado(String tituloPuntoLuzSeleccionado) {
        this.tituloPuntoLuzSeleccionado = tituloPuntoLuzSeleccionado;
    }

    public List<TipoIncidente> getTiposIndicentes() {
        //return tiposIndicentes;
        return tipoIncidenteFacade.findAll();
    }

    public void setTiposIndicentes(List<TipoIncidente> tiposIndicentes) {
        this.tiposIndicentes = tiposIndicentes;
    }

    public ReportePuntoLuz getIncidente() {
        return incidente;
    }

    public void setIncidente(ReportePuntoLuz incidente) {
        this.incidente = incidente;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public List<UploadedFile> getArchivosCargados() {
        return archivosCargados;
    }

    public void setArchivosCargados(List<UploadedFile> archivosCargados) {
        this.archivosCargados = archivosCargados;
    }

    public List<String> getImagenesIncidente() {
        return imagenesIncidente;
    }

    public void setImagenesIncidente(List<String> imagenesIncidente) {
        this.imagenesIncidente = imagenesIncidente;
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    public TipoIncidenteFacade getTipoIncidenteFacade() {
        return tipoIncidenteFacade;
    }

    public void setTipoIncidenteFacade(TipoIncidenteFacade tipoIncidenteFacade) {
        this.tipoIncidenteFacade = tipoIncidenteFacade;
    }

    public PuntoLuzFacade getPuntoLuzFacade() {
        return puntoLuzFacade;
    }

    public void setPuntoLuzFacade(PuntoLuzFacade puntoLuzFacade) {
        this.puntoLuzFacade = puntoLuzFacade;
    }

    public ReportePuntoLuzFacade getReportePuntoLuzFacade() {
        return reportePuntoLuzFacade;
    }

    public void setReportePuntoLuzFacade(ReportePuntoLuzFacade reportePuntoLuzFacade) {
        this.reportePuntoLuzFacade = reportePuntoLuzFacade;
    }

    public ConfiguracionFacade getConfiguracionFacade() {
        return configuracionFacade;
    }

    public void setConfiguracionFacade(ConfiguracionFacade configuracionFacade) {
        this.configuracionFacade = configuracionFacade;
    }

    public void inicializarReporteIncidente() {
        modeloMapa = new DefaultMapModel();
        tiposIndicentes = new ArrayList<>();
        puntosLuz = new ArrayList<>();
        puntoLuzSeleccionado = new PuntoLuz();
        tituloPuntoLuzSeleccionado = null;
        incidente = new ReportePuntoLuz();
        incidente.setCiudadano(new Ciudadano());
        incidente.getCiudadano().setTercero(new Tercero());
        incidente.setPuntoLuz(new PuntoLuz());
        incidente.setTipoIncidente(new TipoIncidente());
        archivosCargados = new ArrayList<>();
        imagenesIncidente = new ArrayList<>();
        usuarioAutenticado = new Usuario();
        
        imagenesIncidente.add("uno.jpg");
        imagenesIncidente.add("dos.jpg");
        
    }

    public void marcadorSeleccionado(OverlaySelectEvent event) {
        Marker marcador = (Marker) event.getOverlay();

        puntoLuzSeleccionado = (PuntoLuz) marcador.getData();

        if (puntoLuzSeleccionado != null) {
            tituloPuntoLuzSeleccionado = puntoLuzSeleccionado.getUbicacionPunto().getDireccion();
        }
    }

    public void guardarIncidente() {

        inicializarReporteIncidente();
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Hecho.", event.getFile().getFileName() + " ha sido cargada.");

        FacesContext.getCurrentInstance().addMessage(null, message);
        
        archivosCargados.add(event.getFile());
        System.out.println("Cantidad de archivos = " + archivosCargados.size());
        
        
        try {
            copiarArchivo(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copiarArchivo(String fileName, InputStream in) {
        try {

            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream("/resources/" + new File(fileName));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();

            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void autenticarUsuario() {
        System.out.println("Usuario: " + usuarioAutenticado.getNombreUsuario());
        System.out.println("Contraseña: " + usuarioAutenticado.getContrasena());
    }
}
