package control;

import ejb.inventario.ConfiguracionFacade;
import ejb.inventario.MedicionFacade;
import ejb.inventario.PuntoLuzFacade;
import ejb.inventario.TerceroFacade;
import ejb.inventario.UsuarioFacade;
import ejb.mantenimiento.EstadoReporteFacade;
import ejb.mantenimiento.MantenimientoPuntoLuzFacade;
import ejb.mantenimiento.ReportePuntoLuzFacade;
import ejb.mantenimiento.TipoEstadoReporteFacade;
import ejb.mantenimiento.TipoIncidenteFacade;
import entidades.inventario.Barrio;
import entidades.inventario.Configuracion;
import entidades.inventario.Departamento;
import entidades.inventario.Medicion;
import entidades.inventario.Municipio;
import entidades.inventario.PuntoLuz;
import entidades.inventario.Tercero;
import entidades.inventario.Usuario;
import entidades.mantenimiento.EstadoReporte;
import entidades.mantenimiento.MantenimientoPuntoLuz;
import entidades.mantenimiento.ReportePuntoLuz;
import entidades.mantenimiento.TipoEstadoReporte;
import entidades.mantenimiento.TipoIncidente;
import entidades.mantenimiento.Zona;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.model.timeline.TimelineModel;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import sun.management.ManagementFactoryHelper;

/**
 *
 * @author Yeison Osorio
 */
@ManagedBean
@SessionScoped
@Named("administracionControl")
public class AdministracionControl implements Serializable {

    private int opcion;
    private String mensajeValidacion = "";
    private MapModel modeloMapaCiudadano;
    private MapModel modeloMapaAdministracion;
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
    private List<ReportePuntoLuz> incidentesReportados;
    private List<MantenimientoPuntoLuz> mantenimientosPuntosLuz;
    private ReportePuntoLuz incidenteSeleccionado;
    private MantenimientoPuntoLuz mantenimientoPuntoLuz;
    private List<Departamento> departamentos;
    private List<Municipio> municipios;
    private List<Barrio> barrios;
    private List<Zona> zonas;
    private List<Medicion> mediciones;
    private LineChartModel modeloLineChart = new LineChartModel();
    private TimelineModel modeloTimeline;

    @ManagedProperty(name = "inventarioControl", value = "#{inventarioControl}")
    private InventarioControl inventarioControl;

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
    private MantenimientoPuntoLuzFacade mantenimientoPuntoLuzFacade;

    @EJB
    @Inject
    ConfiguracionFacade configuracionFacade;

    @EJB
    @Inject
    private TipoEstadoReporteFacade tipoEstadoReporteFacade;

    @EJB
    @Inject
    private EstadoReporteFacade estadoReporteFacade;

    @EJB
    @Inject
    private TerceroFacade terceroFacade;

    @EJB
    @Inject
    private UsuarioFacade usuarioFacade;
    
    @EJB
    @Inject
    private MedicionFacade medicionFacade;

    public AdministracionControl() {

    }

    @PostConstruct
    public void init() {
        inicializarVistaCiudadano();

    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public String getMensajeValidacion() {
        return mensajeValidacion;
    }

    public void setMensajeValidacion(String mensajeValidacion) {
        this.mensajeValidacion = mensajeValidacion;
    }

    public MapModel getModeloMapaCiudadano() {
        return modeloMapaCiudadano;
    }

    public void setModeloMapaCiudadano(MapModel modeloMapaCiudadano) {
        this.modeloMapaCiudadano = modeloMapaCiudadano;
    }

    public MapModel getModeloMapaAdministracion() {
        return modeloMapaAdministracion;
    }

    public void setModeloMapaAdministracion(MapModel modeloMapaAdministracion) {
        this.modeloMapaAdministracion = modeloMapaAdministracion;
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
        return tiposIndicentes;
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

    public List<ReportePuntoLuz> getIncidentesReportados() {
        return incidentesReportados;
    }

    public void setIncidentesReportados(List<ReportePuntoLuz> incidentesReportados) {
        this.incidentesReportados = incidentesReportados;
    }

    public List<MantenimientoPuntoLuz> getMantenimientosPuntosLuz() {
        return mantenimientosPuntosLuz;
    }

    public void setMantenimientosPuntosLuz(List<MantenimientoPuntoLuz> mantenimientosPuntosLuz) {
        this.mantenimientosPuntosLuz = mantenimientosPuntosLuz;
    }

    public ReportePuntoLuz getIncidenteSeleccionado() {
        return incidenteSeleccionado;
    }

    public void setIncidenteSeleccionado(ReportePuntoLuz incidenteSeleccionado) {
        this.incidenteSeleccionado = incidenteSeleccionado;
    }

    public MantenimientoPuntoLuz getMantenimientoPuntoLuz() {
        return mantenimientoPuntoLuz;
    }

    public void setMantenimientoPuntoLuz(MantenimientoPuntoLuz mantenimientoPuntoLuz) {
        this.mantenimientoPuntoLuz = mantenimientoPuntoLuz;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public List<Barrio> getBarrios() {
        return barrios;
    }

    public void setBarrios(List<Barrio> barrios) {
        this.barrios = barrios;
    }

    public List<Zona> getZonas() {
        return zonas;
    }

    public void setZonas(List<Zona> zonas) {
        this.zonas = zonas;
    }

    public List<Medicion> getMediciones() {
        return mediciones;
    }

    public void setMediciones(List<Medicion> mediciones) {
        this.mediciones = mediciones;
    }

    public LineChartModel getModeloLineChart() {
        return modeloLineChart;
    }

    public void setModeloLineChart(LineChartModel modeloLineChart) {
        this.modeloLineChart = modeloLineChart;
    }

    public TimelineModel getModeloTimeline() {
        return modeloTimeline;
    }

    public void setModeloTimeline(TimelineModel modeloTimeline) {
        this.modeloTimeline = modeloTimeline;
    }

    public InventarioControl getInventarioControl() {
        return inventarioControl;
    }

    public void setInventarioControl(InventarioControl inventarioControl) {
        this.inventarioControl = inventarioControl;
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

    public MantenimientoPuntoLuzFacade getMantenimientoPuntoLuzFacade() {
        return mantenimientoPuntoLuzFacade;
    }

    public void setMantenimientoPuntoLuzFacade(MantenimientoPuntoLuzFacade mantenimientoPuntoLuzFacade) {
        this.mantenimientoPuntoLuzFacade = mantenimientoPuntoLuzFacade;
    }

    public ConfiguracionFacade getConfiguracionFacade() {
        return configuracionFacade;
    }

    public void setConfiguracionFacade(ConfiguracionFacade configuracionFacade) {
        this.configuracionFacade = configuracionFacade;
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

    public TerceroFacade getTerceroFacade() {
        return terceroFacade;
    }

    public void setTerceroFacade(TerceroFacade terceroFacade) {
        this.terceroFacade = terceroFacade;
    }

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public MedicionFacade getMedicionFacade() {
        return medicionFacade;
    }

    public void setMedicionFacade(MedicionFacade medicionFacade) {
        this.medicionFacade = medicionFacade;
    }

    public void generarMapaCiudadano() {
        puntosLuz = new ArrayList<>();
        modeloMapaCiudadano = new DefaultMapModel();
        puntosLuz = puntoLuzFacade.findAll();

        for (PuntoLuz puntoLuz : puntosLuz) {
            LatLng coordenadas = new LatLng(puntoLuz.getUbicacionPunto().getLatittud(), puntoLuz.getUbicacionPunto().getLongitud());
            marcadorPuntoLuz = new Marker(coordenadas, puntoLuz.getUbicacionPunto().getDireccion(), puntoLuz);
            modeloMapaCiudadano.addOverlay(marcadorPuntoLuz);
        }
    }

    public void inicializarReporteIncidente() {
        tiposIndicentes = new ArrayList<>();
        tiposIndicentes = tipoIncidenteFacade.findAll();

        incidente = new ReportePuntoLuz();
        incidente.setTercero(new Tercero());
        incidente.setPuntoLuz(new PuntoLuz());
        incidente.setTipoIncidente(new TipoIncidente());
    }

    public void inicializarVistaCiudadano() {
        puntoLuzSeleccionado = new PuntoLuz();
        tituloPuntoLuzSeleccionado = null;
        usuarioAutenticado = new Usuario();
        archivosCargados = new ArrayList<>();
        imagenesIncidente = new ArrayList<>();

        imagenesIncidente.add("uno.jpg");
        imagenesIncidente.add("dos.jpg");

        generarMapaCiudadano();
        inicializarReporteIncidente();
    }

    public void marcadorSeleccionadoCiudadano(OverlaySelectEvent event) {
        Marker marcador = (Marker) event.getOverlay();

        puntoLuzSeleccionado = (PuntoLuz) marcador.getData();

        if (puntoLuzSeleccionado != null) {
            tituloPuntoLuzSeleccionado = puntoLuzSeleccionado.getUbicacionPunto().getDireccion();
        }
    }

    public void marcadorSeleccionadoAdministracion(OverlaySelectEvent event) {
        Marker marcador = (Marker) event.getOverlay();

        puntoLuzSeleccionado = (PuntoLuz) marcador.getData();

        if (puntoLuzSeleccionado != null) {
            tituloPuntoLuzSeleccionado = puntoLuzSeleccionado.getUbicacionPunto().getDireccion();
        }
    }

    public void guardarIncidenteCiudadano() {
        Tercero tercero = terceroFacade.buscarTerceroPorNombreYCorreo(incidente.getTercero());
        TipoEstadoReporte tipoEstadoReporte = tipoEstadoReporteFacade.find(Long.valueOf(getValorParametroConfiguracion("identificadorEstadoReportado")));

        if (tercero == null) {
            terceroFacade.create(incidente.getTercero());
        } else {
            incidente.setTercero(tercero);
        }

        incidente.setPuntoLuz(puntoLuzSeleccionado);
        incidente.setTipoEstadoReporte(tipoEstadoReporte);
        incidente.setFechaIncidencia(new Date());

        reportePuntoLuzFacade.create(incidente);

        EstadoReporte estadoReporte = new EstadoReporte();

        estadoReporte.setReportePuntoLuz(incidente);
        estadoReporte.setTipoEstadoReporte(tipoEstadoReporte);
        estadoReporte.setTercero(incidente.getTercero());
        estadoReporte.setFechaCambioEstado(new Date());

        estadoReporteFacade.create(estadoReporte);

        inicializarReporteIncidente();
        inicializarVistaCiudadano();
    }

    public void guardarIncidenteAdministracion() {
        TipoEstadoReporte tipoEstadoReporte = tipoEstadoReporteFacade.find(Long.valueOf(getValorParametroConfiguracion("identificadorEstadoConfirmado")));

        incidente.setPuntoLuz(puntoLuzSeleccionado);
        incidente.setTipoEstadoReporte(tipoEstadoReporte);
        incidente.setFechaIncidencia(new Date());
        incidente.setTercero(usuarioAutenticado.getTercero());

        reportePuntoLuzFacade.create(incidente);

        EstadoReporte estadoReporte = new EstadoReporte();

        estadoReporte.setReportePuntoLuz(incidente);
        estadoReporte.setTipoEstadoReporte(tipoEstadoReporte);
        estadoReporte.setTercero(incidente.getTercero());
        estadoReporte.setFechaCambioEstado(new Date());

        estadoReporteFacade.create(estadoReporte);

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

    public String autenticarUsuario() {
        mensajeValidacion = "";
        Usuario usuario = usuarioFacade.autenticarUsuario(usuarioAutenticado);
        //Agregar validación de cuenta inactiva y mensaje.

        if (usuario != null) {
            usuarioAutenticado = usuario;
            inicializarPuntosLuz();
            inventarioControl.inicializarPunto();

            return "administracion";
        } else {
            mensajeValidacion = "Usuario inválido.";
        }

        return null;
    }

    public void inicializarPuntosLuz() {
        opcion = 1;

        modeloMapaAdministracion = new DefaultMapModel();
        puntosLuz = puntoLuzFacade.findAll();

        for (PuntoLuz puntoLuz : puntosLuz) {
            LatLng coordenadas = new LatLng(puntoLuz.getUbicacionPunto().getLatittud(), puntoLuz.getUbicacionPunto().getLongitud());
            marcadorPuntoLuz = new Marker(coordenadas, puntoLuz.getUbicacionPunto().getDireccion(), puntoLuz);
            modeloMapaAdministracion.addOverlay(marcadorPuntoLuz);
        }
    }

    public void inicializarIncidentesReportados() {
        opcion = 2;

        incidentesReportados = reportePuntoLuzFacade.consultarPorTipoEstadoReporte(Long.valueOf(getValorParametroConfiguracion("identificadorEstadoReportado")));
    }

    public void inicializarAdministracionUsuarios() {
        opcion = 3;

    }

    public void inicializarEstadisticas() {
        opcion = 4;

    }

    public void inicializarParametricas() {
        opcion = 5;
    }

    public void confirmarIncidente() {
        System.out.println("Confimar incidente.");

        EstadoReporte estadoReporte = new EstadoReporte();
        TipoEstadoReporte tipoEstadoReporte = tipoEstadoReporteFacade.find(Long.valueOf(getValorParametroConfiguracion("identificadorEstadoConfirmado")));

        estadoReporte.setFechaCambioEstado(new Date());
        estadoReporte.setReportePuntoLuz(incidenteSeleccionado);
        estadoReporte.setTipoEstadoReporte(tipoEstadoReporte);
        estadoReporte.setTercero(usuarioAutenticado.getTercero());

        estadoReporteFacade.create(estadoReporte);

        incidenteSeleccionado.setTipoEstadoReporte(tipoEstadoReporte);
        reportePuntoLuzFacade.edit(incidenteSeleccionado);

        incidentesReportados = reportePuntoLuzFacade.consultarPorTipoEstadoReporte(Long.valueOf(getValorParametroConfiguracion("identificadorEstadoReportado")));

        inicializarReporteIncidente();
    }

    public void editarPuntoLuz() {
        inventarioControl.setPuntoLuz(puntoLuzSeleccionado);
        inventarioControl.procesarOpcionesUbicacionPunto();
        inventarioControl.inicializarTransformador();
        inventarioControl.inicializarLuminaria();
        inventarioControl.inicializarBombillo();
        inventarioControl.inicializarPoste();
        inventarioControl.inicializarMedidor();
        
        inicializarMantenimientoPuntoLuz();
        generarTimelinePuntoLuz();
        consultarMedicionesLuminaria();
    }

    public void generarTimelinePuntoLuz() {
        modeloTimeline = new TimelineModel();

        incidentesReportados = reportePuntoLuzFacade.consultarPorTipoEstadoReporteYPuntoLuz(Long.valueOf(getValorParametroConfiguracion("identificadorEstadoCerrado")), puntoLuzSeleccionado.getId());
        mantenimientosPuntosLuz = mantenimientoPuntoLuzFacade.buscarMantenimientosPorPuntoLuz(puntoLuzSeleccionado.getId());

        for (ReportePuntoLuz incidenteCerrado : incidentesReportados) {
            modeloTimeline.add(new TimelineEvent(incidenteCerrado.getTipoIncidente().getDescripcion(), incidenteCerrado.getFechaIncidencia()));
        }

        for (MantenimientoPuntoLuz mantenimiento : mantenimientosPuntosLuz) {
            if (!mantenimiento.isRealizado()) {
                modeloTimeline.add(new TimelineEvent("Mantenimiento programado", mantenimiento.getFechaProgramacion()));
            } else {
                modeloTimeline.add(new TimelineEvent("Mantenimiento", mantenimiento.getFechaRealizacion()));
            }
        }
    }

    public String getValorParametroConfiguracion(String parametro) {
        Configuracion parametroConfiguracion = configuracionFacade.getConfiguracionByNombre(parametro);

        return parametroConfiguracion.getValor();
    }

    public void inicializarMantenimientoPuntoLuz() {
        mantenimientoPuntoLuz = new MantenimientoPuntoLuz();
        mantenimientoPuntoLuz.setPuntoLuz(new PuntoLuz());
        mantenimientoPuntoLuz.setRealizado(false);
    }

    public void agregarMantenimientoPuntoLuz() {
        mantenimientoPuntoLuz.setPuntoLuz(puntoLuzSeleccionado);
        mantenimientoPuntoLuzFacade.create(mantenimientoPuntoLuz);
        mantenimientosPuntosLuz = mantenimientoPuntoLuzFacade.buscarMantenimientosPorPuntoLuz(puntoLuzSeleccionado.getId());

        modeloTimeline.add(new TimelineEvent("Mantenimiento programado", mantenimientoPuntoLuz.getFechaProgramacion()));
        inicializarMantenimientoPuntoLuz();

    }
    
    public void consultarMedicionesLuminaria(){
        mediciones = medicionFacade.buscarPorLuminaria(puntoLuzSeleccionado.getLuminaria().getId());
        modeloLineChart.clear();
        modeloLineChart = inicializarCategoryModel();
        
    }
    
    private LineChartModel inicializarCategoryModel() {
        LineChartModel modelo = new LineChartModel();
        
        ChartSeries serie1 = new LineChartSeries();
        serie1.setLabel("Voltaje");
        
        for (Medicion medicion : mediciones) {            
            serie1.set(medicion.getId(), medicion.getVoltaje());
        }
        
        modelo.addSeries(serie1);
        
        return modelo;
    }
    

}
