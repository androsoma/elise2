/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import ejb.inventario.AlturaPosteFacade;
import ejb.inventario.ArrancadorFacade;
import ejb.inventario.BarrioFacade;
import ejb.inventario.BombilloFacade;
import ejb.inventario.BrazoLuminariaFacade;
import ejb.inventario.ClasePrecisionFacade;
import ejb.inventario.DepartamentoFacade;
import ejb.inventario.FabricanteFacade;
import ejb.inventario.FaseFacade;
import ejb.inventario.FrecuenciaFacade;
import ejb.inventario.LuminariaFacade;
import ejb.inventario.MaterialPosteFacade;
import ejb.inventario.MedidorEnergiaFacade;
import ejb.inventario.MunicipioFacade;
import ejb.inventario.PosteFacade;
import ejb.inventario.PotenciaFacade;
import ejb.inventario.PuntoLuzFacade;
import ejb.inventario.TipoArrancadorFacade;
import ejb.inventario.TipoBalastoFacade;
import ejb.inventario.TipoBombilloFacade;
import ejb.inventario.TipoConexionMedidorFacade;
import ejb.inventario.TipoConexionTransformadorFacade;
import ejb.inventario.TipoHerrajeFacade;
import ejb.inventario.TipoMedidorFacade;
import ejb.inventario.TipoProteccionFacade;
import ejb.inventario.TipoTransformadorFacade;
import ejb.inventario.TransformadorFacade;
import ejb.inventario.UbicacionPuntoFacade;
import ejb.inventario.VoltajeFacade;
import ejb.mantenimiento.ZonaFacade;
import entidades.inventario.AlturaPoste;
import entidades.inventario.Arrancador;
import entidades.inventario.Balasto;
import entidades.inventario.Barrio;
import entidades.inventario.Bombillo;
import entidades.inventario.BrazoLuminaria;
import entidades.inventario.ClasePrecision;
import entidades.inventario.Departamento;
import entidades.inventario.Fabricante;
import entidades.inventario.Fase;
import entidades.inventario.Frecuencia;
import entidades.inventario.Luminaria;
import entidades.inventario.MaterialPoste;
import entidades.inventario.MedidorEnergia;
import entidades.inventario.Municipio;
import entidades.inventario.Poste;
import entidades.inventario.Potencia;
import entidades.inventario.PuntoLuz;
import entidades.inventario.TipoArrancador;
import entidades.inventario.TipoBalasto;
import entidades.inventario.TipoBombillo;
import entidades.inventario.TipoConexionMedidor;
import entidades.inventario.TipoConexionTransformador;
import entidades.inventario.TipoHerraje;
import entidades.inventario.TipoMedidor;
import entidades.inventario.TipoProteccion;
import entidades.inventario.TipoTransformador;
import entidades.inventario.Transformador;
import entidades.inventario.UbicacionPunto;
import entidades.inventario.Usuario;
import entidades.inventario.Voltaje;
import entidades.mantenimiento.Zona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Yeison Osorio
 */
@ManagedBean
@SessionScoped
@Named("inventarioControl")
public class InventarioControl implements Serializable {

    @EJB
    @Inject
    TipoTransformadorFacade tipoTransformadorFacade;

    @EJB
    @Inject
    FabricanteFacade fabricanteFacade;

    @EJB
    @Inject
    TipoConexionTransformadorFacade tipoConexionTransformadorFacade;

    @EJB
    @Inject
    TipoHerrajeFacade tipoHerrajeFacade;

    @EJB
    @Inject
    TipoBalastoFacade tipoBalastoFacade;

    @EJB
    @Inject
    TipoProteccionFacade tipoProteccionFacade;

    @EJB
    @Inject
    TipoArrancadorFacade tipoArrancadorFacade;

    @EJB
    @Inject
    TipoBombilloFacade tipoBombilloFacade;

    @EJB
    @Inject
    MaterialPosteFacade materialPosteFacade;

    @EJB
    @Inject
    AlturaPosteFacade alturaPosteFacade;

    @EJB
    @Inject
    TipoMedidorFacade tipoMedidorFacade;

    @EJB
    @Inject
    ClasePrecisionFacade clasePrecisionFacade;

    @EJB
    @Inject
    TipoConexionMedidorFacade tipoConexionMedidorFacade;

    @EJB
    @Inject
    TransformadorFacade transformadorFacade;

    @EJB
    @Inject
    BrazoLuminariaFacade brazoLuminariaFacade;

    @EJB
    @Inject
    ArrancadorFacade arrancadorFacade;

    @EJB
    @Inject
    FrecuenciaFacade frecuenciaFacade;

    @EJB
    @Inject
    VoltajeFacade voltajeFacade;

    @EJB
    @Inject
    PotenciaFacade potenciaFacade;

    @EJB
    @Inject
    FaseFacade faseFacade;

    @EJB
    @Inject
    LuminariaFacade luminariaFacade;

    @EJB
    @Inject
    PuntoLuzFacade puntoLuzFacade;

    @EJB
    @Inject
    DepartamentoFacade departamentoFacade;

    @EJB
    @Inject
    MunicipioFacade municipioFacade;

    @EJB
    @Inject
    ZonaFacade zonaFacade;

    @EJB
    @Inject
    BarrioFacade barrioFacade;

    @EJB
    @Inject
    UbicacionPuntoFacade ubicacionPuntoFacade;

    @EJB
    @Inject
    BombilloFacade bombilloFacade;

    @EJB
    @Inject
    PosteFacade posteFacade;

    @EJB
    @Inject
    MedidorEnergiaFacade medidorEnergiaFacade;

    List<Departamento> departamentos = new ArrayList<>();
    List<Municipio> municipios = new ArrayList<>();
    List<Zona> zonas = new ArrayList<>();
    List<Barrio> barrios = new ArrayList<>();
    List<TipoTransformador> tiposTransformador = null;
    List<Fabricante> fabricantes = null;
    List<TipoConexionTransformador> tiposConexionTransformador = null;
    List<TipoHerraje> tiposHerraje = null;
    List<TipoBalasto> tiposBalasto = null;
    List<TipoProteccion> tiposProteccion = null;
    List<TipoArrancador> tiposArrancador = null;
    List<TipoBombillo> tiposBombillo = null;
    List<MaterialPoste> materialesPoste = null;
    List<AlturaPoste> alturasPoste = null;
    List<TipoMedidor> tiposMedidor = null;
    List<ClasePrecision> clasesPrecision = null;
    List<TipoConexionMedidor> tiposConexionMedidor = null;
    List<Frecuencia> frecuencias = null;
    List<Voltaje> voltajes = null;
    List<Potencia> potencias = null;
    List<Fase> fases = null;
    boolean asociartransformador = false;

    private PuntoLuz puntoLuz;
    private Usuario usuario = new Usuario();
    private Departamento departamento = new Departamento();
    private Municipio municipio = new Municipio();
    private Zona zona = new Zona();
    private Barrio barrio = new Barrio();

    /**
     * Creates a new instance of InventarioControl
     */
    public InventarioControl() {
    }

    public TipoTransformadorFacade getTipoTransformadorFacade() {
        return tipoTransformadorFacade;
    }

    public void setTipoTransformadorFacade(TipoTransformadorFacade tipoTransformadorFacade) {
        this.tipoTransformadorFacade = tipoTransformadorFacade;
    }

    public FabricanteFacade getFabricanteFacade() {
        return fabricanteFacade;
    }

    public void setFabricanteFacade(FabricanteFacade fabricanteFacade) {
        this.fabricanteFacade = fabricanteFacade;
    }

    public TipoConexionTransformadorFacade getTipoConexionTransformadorFacade() {
        return tipoConexionTransformadorFacade;
    }

    public void setTipoConexionTransformadorFacade(TipoConexionTransformadorFacade tipoConexionTransformadorFacade) {
        this.tipoConexionTransformadorFacade = tipoConexionTransformadorFacade;
    }

    public TipoHerrajeFacade getTipoHerrajeFacade() {
        return tipoHerrajeFacade;
    }

    public void setTipoHerrajeFacade(TipoHerrajeFacade tipoHerrajeFacade) {
        this.tipoHerrajeFacade = tipoHerrajeFacade;
    }

    public TipoBalastoFacade getTipoBalastoFacade() {
        return tipoBalastoFacade;
    }

    public void setTipoBalastoFacade(TipoBalastoFacade tipoBalastoFacade) {
        this.tipoBalastoFacade = tipoBalastoFacade;
    }

    public TipoProteccionFacade getTipoProteccionFacade() {
        return tipoProteccionFacade;
    }

    public void setTipoProteccionFacade(TipoProteccionFacade tipoProteccionFacade) {
        this.tipoProteccionFacade = tipoProteccionFacade;
    }

    public TipoArrancadorFacade getTipoArrancadorFacade() {
        return tipoArrancadorFacade;
    }

    public void setTipoArrancadorFacade(TipoArrancadorFacade tipoArrancadorFacade) {
        this.tipoArrancadorFacade = tipoArrancadorFacade;
    }

    public TipoBombilloFacade getTipoBombilloFacade() {
        return tipoBombilloFacade;
    }

    public void setTipoBombilloFacade(TipoBombilloFacade tipoBombilloFacade) {
        this.tipoBombilloFacade = tipoBombilloFacade;
    }

    public MaterialPosteFacade getMaterialPosteFacade() {
        return materialPosteFacade;
    }

    public void setMaterialPosteFacade(MaterialPosteFacade materialPosteFacade) {
        this.materialPosteFacade = materialPosteFacade;
    }

    public AlturaPosteFacade getAlturaPosteFacade() {
        return alturaPosteFacade;
    }

    public void setAlturaPosteFacade(AlturaPosteFacade alturaPosteFacade) {
        this.alturaPosteFacade = alturaPosteFacade;
    }

    public TipoMedidorFacade getTipoMedidorFacade() {
        return tipoMedidorFacade;
    }

    public void setTipoMedidorFacade(TipoMedidorFacade tipoMedidorFacade) {
        this.tipoMedidorFacade = tipoMedidorFacade;
    }

    public TipoConexionMedidorFacade getTipoConexionMedidorFacade() {
        return tipoConexionMedidorFacade;
    }

    public void setTipoConexionMedidorFacade(TipoConexionMedidorFacade tipoConexionMedidorFacade) {
        this.tipoConexionMedidorFacade = tipoConexionMedidorFacade;
    }

    public ClasePrecisionFacade getClasePrecisionFacade() {
        return clasePrecisionFacade;
    }

    public void setClasePrecisionFacade(ClasePrecisionFacade clasePrecisionFacade) {
        this.clasePrecisionFacade = clasePrecisionFacade;
    }

    public TransformadorFacade getTransformadorFacade() {
        return transformadorFacade;
    }

    public void setTransformadorFacade(TransformadorFacade transformadorFacade) {
        this.transformadorFacade = transformadorFacade;
    }

    public BrazoLuminariaFacade getBrazoLuminariaFacade() {
        return brazoLuminariaFacade;
    }

    public void setBrazoLuminariaFacade(BrazoLuminariaFacade brazoLuminariaFacade) {
        this.brazoLuminariaFacade = brazoLuminariaFacade;
    }

    public List<TipoTransformador> getTiposTransformador() {
        return tiposTransformador;
    }

    public ArrancadorFacade getArrancadorFacade() {
        return arrancadorFacade;
    }

    public void setArrancadorFacade(ArrancadorFacade arrancadorFacade) {
        this.arrancadorFacade = arrancadorFacade;
    }

    public FrecuenciaFacade getFrecuenciaFacade() {
        return frecuenciaFacade;
    }

    public void setFrecuenciaFacade(FrecuenciaFacade frecuenciaFacade) {
        this.frecuenciaFacade = frecuenciaFacade;
    }

    public VoltajeFacade getVoltajeFacade() {
        return voltajeFacade;
    }

    public void setVoltajeFacade(VoltajeFacade voltajeFacade) {
        this.voltajeFacade = voltajeFacade;
    }

    public PotenciaFacade getPotenciaFacade() {
        return potenciaFacade;
    }

    public void setPotenciaFacade(PotenciaFacade potenciaFacade) {
        this.potenciaFacade = potenciaFacade;
    }

    public FaseFacade getFaseFacade() {
        return faseFacade;
    }

    public void setFaseFacade(FaseFacade faseFacade) {
        this.faseFacade = faseFacade;
    }

    public LuminariaFacade getLuminariaFacade() {
        return luminariaFacade;
    }

    public void setLuminariaFacade(LuminariaFacade luminariaFacade) {
        this.luminariaFacade = luminariaFacade;
    }

    public PuntoLuzFacade getPuntoLuzFacade() {
        return puntoLuzFacade;
    }

    public void setPuntoLuzFacade(PuntoLuzFacade puntoLuzFacade) {
        this.puntoLuzFacade = puntoLuzFacade;
    }

    public DepartamentoFacade getDepartamentoFacade() {
        return departamentoFacade;
    }

    public void setDepartamentoFacade(DepartamentoFacade departamentoFacade) {
        this.departamentoFacade = departamentoFacade;
    }

    public MunicipioFacade getMunicipioFacade() {
        return municipioFacade;
    }

    public void setMunicipioFacade(MunicipioFacade municipioFacade) {
        this.municipioFacade = municipioFacade;
    }

    public ZonaFacade getZonaFacade() {
        return zonaFacade;
    }

    public void setZonaFacade(ZonaFacade zonaFacade) {
        this.zonaFacade = zonaFacade;
    }

    public BarrioFacade getBarrioFacade() {
        return barrioFacade;
    }

    public void setBarrioFacade(BarrioFacade barrioFacade) {
        this.barrioFacade = barrioFacade;
    }

    public UbicacionPuntoFacade getUbicacionPuntoFacade() {
        return ubicacionPuntoFacade;
    }

    public void setUbicacionPuntoFacade(UbicacionPuntoFacade ubicacionPuntoFacade) {
        this.ubicacionPuntoFacade = ubicacionPuntoFacade;
    }

    public BombilloFacade getBombilloFacade() {
        return bombilloFacade;
    }

    public void setBombilloFacade(BombilloFacade bombilloFacade) {
        this.bombilloFacade = bombilloFacade;
    }

    public PosteFacade getPosteFacade() {
        return posteFacade;
    }

    public void setPosteFacade(PosteFacade posteFacade) {
        this.posteFacade = posteFacade;
    }

    public MedidorEnergiaFacade getMedidorEnergiaFacade() {
        return medidorEnergiaFacade;
    }

    public void setMedidorEnergiaFacade(MedidorEnergiaFacade medidorEnergiaFacade) {
        this.medidorEnergiaFacade = medidorEnergiaFacade;
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

    public List<Zona> getZonas() {
        return zonas;
    }

    public void setZonas(List<Zona> zonas) {
        this.zonas = zonas;
    }

    public List<Barrio> getBarrios() {
        return barrios;
    }

    public void setBarrios(List<Barrio> barrios) {
        this.barrios = barrios;
    }

    public void setTiposTransformador(List<TipoTransformador> tiposTransformador) {
        this.tiposTransformador = tiposTransformador;
    }

    public PuntoLuz getPuntoLuz() {
        return puntoLuz;
    }

    public void setPuntoLuz(PuntoLuz puntoLuz) {
        this.puntoLuz = puntoLuz;
    }

    public List<Fabricante> getFabricantes() {
        return fabricantes;
    }

    public void setFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }

    public List<TipoConexionTransformador> getTiposConexionTransformador() {
        return tiposConexionTransformador;
    }

    public void setTiposConexionTransformador(List<TipoConexionTransformador> tiposConexionTransformador) {
        this.tiposConexionTransformador = tiposConexionTransformador;
    }

    public List<TipoHerraje> getTiposHerraje() {
        return tiposHerraje;
    }

    public void setTiposHerraje(List<TipoHerraje> tiposHerraje) {
        this.tiposHerraje = tiposHerraje;
    }

    public List<TipoBalasto> getTiposBalasto() {
        return tiposBalasto;
    }

    public void setTiposBalasto(List<TipoBalasto> tiposBalasto) {
        this.tiposBalasto = tiposBalasto;
    }

    public List<TipoProteccion> getTiposProteccion() {
        return tiposProteccion;
    }

    public void setTiposProteccion(List<TipoProteccion> tiposProteccion) {
        this.tiposProteccion = tiposProteccion;
    }

    public List<TipoArrancador> getTiposArrancador() {
        return tiposArrancador;
    }

    public void setTiposArrancador(List<TipoArrancador> tiposArrancador) {
        this.tiposArrancador = tiposArrancador;
    }

    public List<TipoBombillo> getTiposBombillo() {
        return tiposBombillo;
    }

    public void setTiposBombillo(List<TipoBombillo> tiposBombillo) {
        this.tiposBombillo = tiposBombillo;
    }

    public List<MaterialPoste> getMaterialesPoste() {
        return materialesPoste;
    }

    public void setMaterialesPoste(List<MaterialPoste> materialesPoste) {
        this.materialesPoste = materialesPoste;
    }

    public List<AlturaPoste> getAlturasPoste() {
        return alturasPoste;
    }

    public void setAlturasPoste(List<AlturaPoste> alturasPoste) {
        this.alturasPoste = alturasPoste;
    }

    public List<TipoMedidor> getTiposMedidor() {
        return tiposMedidor;
    }

    public void setTiposMedidor(List<TipoMedidor> tiposMedidor) {
        this.tiposMedidor = tiposMedidor;
    }

    public List<TipoConexionMedidor> getTiposConexionMedidor() {
        return tiposConexionMedidor;
    }

    public void setTiposConexionMedidor(List<TipoConexionMedidor> tiposConexionMedidor) {
        this.tiposConexionMedidor = tiposConexionMedidor;
    }

    public List<ClasePrecision> getClasesPrecision() {
        return clasesPrecision;
    }

    public void setClasesPrecision(List<ClasePrecision> clasesPrecision) {
        this.clasesPrecision = clasesPrecision;
    }

    public List<Frecuencia> getFrecuencias() {
        return frecuencias;
    }

    public void setFrecuencias(List<Frecuencia> frecuencias) {
        this.frecuencias = frecuencias;
    }

    public List<Voltaje> getVoltajes() {
        return voltajes;
    }

    public void setVoltajes(List<Voltaje> voltajes) {
        this.voltajes = voltajes;
    }

    public List<Potencia> getPotencias() {
        return potencias;
    }

    public void setPotencias(List<Potencia> potencias) {
        this.potencias = potencias;
    }

    public List<Fase> getFases() {
        return fases;
    }

    public void setFases(List<Fase> fases) {
        this.fases = fases;
    }

    public boolean isAsociartransformador() {
        return asociartransformador;
    }

    public void setAsociartransformador(boolean asociartransformador) {
        this.asociartransformador = asociartransformador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public String inicializarPunto() {
        System.out.println("Entré a inicializar punto.");
        barrios = new ArrayList<>();
        barrios = getBarrioFacade().buscarTodos();

        puntoLuz = new PuntoLuz();

        puntoLuz.setUbicacionPunto(new UbicacionPunto());
        puntoLuz.getUbicacionPunto().setMunicipio(municipioFacade.find(1L));
        puntoLuz.getUbicacionPunto().setBarrio(new Barrio());

        puntoLuz.setTransformador(new Transformador());
        puntoLuz.getTransformador().setFabricante(new Fabricante());
        puntoLuz.getTransformador().setTipoTransformador(new TipoTransformador());
        puntoLuz.getTransformador().setTipoConexionTransformador(new TipoConexionTransformador());
        puntoLuz.getTransformador().setFase(new Fase());
        puntoLuz.getTransformador().setFrecuencia(new Frecuencia());
        puntoLuz.getTransformador().setPotencia(new Potencia());
        puntoLuz.getTransformador().setVoltajeAlta(new Voltaje());
        puntoLuz.getTransformador().setVoltajeBaja(new Voltaje());

        puntoLuz.setLuminaria(new Luminaria());
        puntoLuz.getLuminaria().setTipoHerraje(new TipoHerraje());
        puntoLuz.getLuminaria().setFabricante(new Fabricante());
        puntoLuz.getLuminaria().setBrazoLuminaria(new BrazoLuminaria());
        puntoLuz.getLuminaria().setBalasto(new Balasto());
        puntoLuz.getLuminaria().getBalasto().setFabricante(new Fabricante());
        puntoLuz.getLuminaria().getBalasto().setTipoBalasto(new TipoBalasto());
        puntoLuz.getLuminaria().getBalasto().setTipoProteccion(new TipoProteccion());
        puntoLuz.getLuminaria().setArrancador(new Arrancador());
        puntoLuz.getLuminaria().getArrancador().setFabricante(new Fabricante());
        puntoLuz.getLuminaria().getArrancador().setTipoArrancador(new TipoArrancador());
        puntoLuz.getLuminaria().setPotencia(new Potencia());

        puntoLuz.setBombillo(new Bombillo());
        puntoLuz.getBombillo().setFabricante(new Fabricante());
        puntoLuz.getBombillo().setTipoBombillo(new TipoBombillo());
        puntoLuz.getBombillo().setPotencia(new Potencia());
        puntoLuz.setPoste(new Poste());
        puntoLuz.getPoste().setFabricante(new Fabricante());
        puntoLuz.getPoste().setAlturaPoste(new AlturaPoste());
        puntoLuz.getPoste().setMaterial(new MaterialPoste());

        puntoLuz.setMedidorEnergia(new MedidorEnergia());
        puntoLuz.getMedidorEnergia().setFabricante(new Fabricante());
        puntoLuz.getMedidorEnergia().setClasePrecision(new ClasePrecision());
        puntoLuz.getMedidorEnergia().setTipoMedidor(new TipoMedidor());
        puntoLuz.getMedidorEnergia().setTipoConexionMedidor(new TipoConexionMedidor());
        puntoLuz.getMedidorEnergia().setTipoProteccion(new TipoProteccion());
        puntoLuz.getMedidorEnergia().setVoltajeAlta(new Voltaje());
        puntoLuz.getMedidorEnergia().setVoltajeBaja(new Voltaje());
        puntoLuz.getMedidorEnergia().setFrecuencia(new Frecuencia());
        puntoLuz.getMedidorEnergia().setPotenciaMaxima(new Potencia());

        return "pm:menuprincipal";
    }

    public String inicializarTiposTransformador() {
        System.out.println("Inicializar listas transforamdor.");
        tiposTransformador = new ArrayList<>();
        tiposConexionTransformador = new ArrayList<>();
        fabricantes = new ArrayList<>();
        frecuencias = new ArrayList<>();
        voltajes = new ArrayList<>();
        potencias = new ArrayList<>();
        fases = new ArrayList<>();

        tiposTransformador = getTipoTransformadorFacade().findAll();
        tiposConexionTransformador = getTipoConexionTransformadorFacade().findAll();
        fabricantes = getFabricanteFacade().findAll();
        frecuencias = getFrecuenciaFacade().findAll();
        voltajes = getVoltajeFacade().findAll();
        potencias = getPotenciaFacade().findAll();
        fases = getFaseFacade().findAll();

        return "pm:transformador";
    }

    public String inicializarTiposLuminaria() {
        System.out.println("Inicializar listas luminaria.");
        tiposHerraje = new ArrayList<>();
        fabricantes = new ArrayList<>();
        tiposBalasto = new ArrayList<>();
        tiposProteccion = new ArrayList<>();
        tiposArrancador = new ArrayList<>();
        potencias = new ArrayList<>();

        tiposHerraje = getTipoHerrajeFacade().findAll();
        fabricantes = getFabricanteFacade().findAll();
        tiposBalasto = getTipoBalastoFacade().findAll();
        tiposProteccion = getTipoProteccionFacade().findAll();
        tiposArrancador = getTipoArrancadorFacade().findAll();
        potencias = getPotenciaFacade().findAll();

        return "pm:luminaria";
    }

    public String imprimirValoresLuminaria() {
        System.out.println("Diametro brazo = " + puntoLuz.getLuminaria().getBrazoLuminaria().getDiametro());
        System.out.println("Largo brazo = " + puntoLuz.getLuminaria().getBrazoLuminaria().getLargo());
        System.out.println("Tipo balasto = " + puntoLuz.getLuminaria().getBalasto().getTipoBalasto().getId());
        System.out.println("Fabricante balasto = " + puntoLuz.getLuminaria().getBalasto().getFabricante().getId());
        System.out.println("Tipo arrancador = " + puntoLuz.getLuminaria().getArrancador().getTipoArrancador().getId());
        System.out.println("Referencia  arrancador = " + puntoLuz.getLuminaria().getArrancador().getReferencia());

        return null;
    }

    public String imprimirValoresTransformador() {
        System.out.println("Tipo transformador: " + puntoLuz.getTransformador().getTipoTransformador().getId());
        System.out.println("Exclusivo: " + puntoLuz.getTransformador().isExclusivo());
        System.out.println("Fase: " + puntoLuz.getTransformador().getFase().getId());
        System.out.println("Serial: " + puntoLuz.getTransformador().getSerial());

        return null;
    }

    public String inicializarTiposBombillo() {
        System.out.println("Inicializar listas bombillo.");
        tiposBombillo = new ArrayList<>();
        fabricantes = new ArrayList<>();
        potencias = new ArrayList<>();

        tiposBombillo = getTipoBombilloFacade().findAll();
        fabricantes = getFabricanteFacade().findAll();
        potencias = getPotenciaFacade().findAll();

        return "pm:bombillo";
    }

    public String inicializarTiposPoste() {
        System.out.println("Inicializar listas poste.");

        materialesPoste = new ArrayList<>();
        alturasPoste = new ArrayList<>();
        fabricantes = new ArrayList<>();

        materialesPoste = getMaterialPosteFacade().findAll();
        alturasPoste = getAlturaPosteFacade().findAll();
        fabricantes = getFabricanteFacade().findAll();

        return "pm:poste";
    }

    public String inicializarTiposMedidor() {
        System.out.println("Inicializar listas medidor.");

        fabricantes = new ArrayList<>();
        tiposMedidor = new ArrayList<>();
        clasesPrecision = new ArrayList<>();
        tiposConexionMedidor = new ArrayList<>();
        tiposProteccion = new ArrayList<>();
        voltajes = new ArrayList<>();
        frecuencias = new ArrayList<>();
        potencias = new ArrayList<>();

        fabricantes = getFabricanteFacade().findAll();
        tiposMedidor = getTipoMedidorFacade().findAll();
        clasesPrecision = getClasePrecisionFacade().findAll();
        tiposConexionMedidor = getTipoConexionMedidorFacade().findAll();
        tiposProteccion = getTipoProteccionFacade().findAll();
        voltajes = getVoltajeFacade().findAll();
        frecuencias = getFrecuenciaFacade().findAll();
        potencias = getPotenciaFacade().findAll();

        return "pm:medidor";
    }

    public void guardarBrazoLuminaria() {
        System.out.println("Voy a guardar brazo luminaria.");

        getBrazoLuminariaFacade().create(puntoLuz.getLuminaria().getBrazoLuminaria());
    }

    public void editarBrazoLuminaria() {
        System.out.println("Voy a editar brazo luminaria.");

        getBrazoLuminariaFacade().edit(puntoLuz.getLuminaria().getBrazoLuminaria());
    }

    public void guardarArrancador() {
        System.out.println("Voy a guardar el arrancador.");

        if (puntoLuz.getLuminaria().getArrancador().getId() == null) {
            getArrancadorFacade().create(puntoLuz.getLuminaria().getArrancador());

            System.out.println("Id del arrancador creado: " + puntoLuz.getLuminaria().getArrancador().getId());
        } else {
            getArrancadorFacade().edit(puntoLuz.getLuminaria().getArrancador());

            System.out.println("Id del arrancador editado: " + puntoLuz.getLuminaria().getArrancador().getId());
        }
    }

    public String ingresarMapaCiudadano() {
        return "Administrador";
    }

    public String asociarTransformador() {
        System.out.println("ingreso al metodo");
        asociartransformador = true;
        return "pm:map";
    }

    public String accionSeleccionada() {

        return "pm:nuevaaccion";
    }

    public void guardarPuntoLuz() {
        verificarSeleccionParametricas();

        if (puntoLuz.getUbicacionPunto().getMunicipio() != null) {
            puntoLuz.getUbicacionPunto().setMunicipio(municipioFacade.find(puntoLuz.getUbicacionPunto().getMunicipio().getId()));
        }

        if (puntoLuz.getUbicacionPunto().getBarrio() != null) {
            puntoLuz.getUbicacionPunto().setBarrio(barrioFacade.find(puntoLuz.getUbicacionPunto().getBarrio().getId()));
        }

        getPuntoLuzFacade().create(puntoLuz);
        
        barrios.clear();
        
        barrios = barrioFacade.buscarTodos();
    }

    public void inicializarLocalidades() {
        departamento = new Departamento();
        municipio = municipioFacade.find(1L);
        zona = new Zona();
        barrio = new Barrio();

        buscarZonasPorMunicipio();
        barrios = new ArrayList<>();
    }

    private void verificarSeleccionParametricasUbicacion() {
        if (puntoLuz.getUbicacionPunto().getBarrio().getId() == null) {
            puntoLuz.getUbicacionPunto().setBarrio(null);
        }

        if (puntoLuz.getUbicacionPunto().getMunicipio().getId() == null) {
            puntoLuz.getUbicacionPunto().setMunicipio(null);
        }
    }

    private void verificarSeleccionParametricasTransformador() {
        if (puntoLuz.getTransformador().getTipoTransformador().getId() == null) {
            puntoLuz.getTransformador().setTipoTransformador(null);
        }

        if (puntoLuz.getTransformador().getFabricante().getId() == 0) {
            puntoLuz.getTransformador().setFabricante(null);
        }

        if (puntoLuz.getTransformador().getFrecuencia().getId() == null) {
            puntoLuz.getTransformador().setFrecuencia(null);
        }

        if (puntoLuz.getTransformador().getFase().getId() == null) {
            puntoLuz.getTransformador().setFase(null);
        }

        if (puntoLuz.getTransformador().getTipoConexionTransformador().getId() == null) {
            puntoLuz.getTransformador().setTipoConexionTransformador(null);
        }

        if (puntoLuz.getTransformador().getVoltajeAlta().getId() == null) {
            puntoLuz.getTransformador().setVoltajeAlta(null);
        }

        if (puntoLuz.getTransformador().getVoltajeBaja().getId() == null) {
            puntoLuz.getTransformador().setVoltajeBaja(null);
        }

        if (puntoLuz.getTransformador().getPotencia().getId() == null) {
            puntoLuz.getTransformador().setPotencia(null);
        }
    }

    private void verificarSeleccionParametricasLuminaria() {
        if (puntoLuz.getLuminaria().getArrancador().getFabricante().getId() == 0) {
            puntoLuz.getLuminaria().getArrancador().setFabricante(null);
        }

        if (puntoLuz.getLuminaria().getArrancador().getTipoArrancador().getId() == 0) {
            puntoLuz.getLuminaria().getArrancador().setTipoArrancador(null);
        }

        if (puntoLuz.getLuminaria().getBalasto().getFabricante().getId() == 0) {
            puntoLuz.getLuminaria().getBalasto().setFabricante(null);
        }

        if (puntoLuz.getLuminaria().getBalasto().getTipoBalasto().getId() == null) {
            puntoLuz.getLuminaria().getBalasto().setTipoBalasto(null);
        }

        if (puntoLuz.getLuminaria().getBalasto().getTipoProteccion().getId() == null) {
            puntoLuz.getLuminaria().getBalasto().setTipoProteccion(null);
        }

        if (puntoLuz.getLuminaria().getFabricante().getId() == 0) {
            puntoLuz.getLuminaria().setFabricante(null);
        }

        if (puntoLuz.getLuminaria().getTipoHerraje().getId() == null) {
            puntoLuz.getLuminaria().setTipoHerraje(null);
        }

        if (puntoLuz.getLuminaria().getPotencia().getId() == null) {
            puntoLuz.getLuminaria().setPotencia(null);
        }
    }

    private void verificarSeleccionParametricasBombillo() {
        if (puntoLuz.getBombillo().getFabricante().getId() == 0) {
            puntoLuz.getBombillo().setFabricante(null);
        }

        if (puntoLuz.getBombillo().getTipoBombillo().getId() == null) {
            puntoLuz.getBombillo().setTipoBombillo(null);
        }

        if (puntoLuz.getBombillo().getPotencia().getId() == null) {
            puntoLuz.getBombillo().setPotencia(null);
        }
    }

    private void verificarSeleccionParametricasPoste() {
        if (puntoLuz.getPoste().getFabricante().getId() == 0) {
            puntoLuz.getPoste().setFabricante(null);
        }

        if (puntoLuz.getPoste().getMaterial().getId() == null) {
            puntoLuz.getPoste().setMaterial(null);
        }

        if (puntoLuz.getPoste().getAlturaPoste().getId() == null) {
            puntoLuz.getPoste().setAlturaPoste(null);
        }
    }

    private void verificarSeleccionParametricasMedidor() {
        if (puntoLuz.getMedidorEnergia().getFabricante().getId() == 0) {
            puntoLuz.getMedidorEnergia().setFabricante(null);
        }

        if (puntoLuz.getMedidorEnergia().getTipoMedidor().getId() == null) {
            puntoLuz.getMedidorEnergia().setTipoMedidor(null);
        }

        if (puntoLuz.getMedidorEnergia().getFrecuencia().getId() == null) {
            puntoLuz.getMedidorEnergia().setFrecuencia(null);
        }

        if (puntoLuz.getMedidorEnergia().getClasePrecision().getId() == null) {
            puntoLuz.getMedidorEnergia().setClasePrecision(null);
        }

        if (puntoLuz.getMedidorEnergia().getTipoConexionMedidor().getId() == null) {
            puntoLuz.getMedidorEnergia().setTipoConexionMedidor(null);
        }

        if (puntoLuz.getMedidorEnergia().getVoltajeAlta().getId() == null) {
            puntoLuz.getMedidorEnergia().setVoltajeAlta(null);
        }

        if (puntoLuz.getMedidorEnergia().getVoltajeBaja().getId() == null) {
            puntoLuz.getMedidorEnergia().setVoltajeBaja(null);
        }

        if (puntoLuz.getMedidorEnergia().getPotenciaMaxima().getId() == null) {
            puntoLuz.getMedidorEnergia().setPotenciaMaxima(null);
        }

        if (puntoLuz.getMedidorEnergia().getTipoProteccion().getId() == null) {
            puntoLuz.getMedidorEnergia().setTipoProteccion(null);
        }
    }

    private void verificarSeleccionParametricas() {
        verificarSeleccionParametricasUbicacion();
        verificarSeleccionParametricasTransformador();
        verificarSeleccionParametricasLuminaria();
        verificarSeleccionParametricasBombillo();
        verificarSeleccionParametricasPoste();
        verificarSeleccionParametricasMedidor();
    }

    public void inicializarArrancador() {
        if (puntoLuz.getLuminaria().getArrancador().getTipoArrancador() == null) {
            System.out.println("Asigno un nuevo tipo arrancador.");

            puntoLuz.getLuminaria().getArrancador().setTipoArrancador(new TipoArrancador());
        }

        if (puntoLuz.getLuminaria().getArrancador().getFabricante() == null) {
            System.out.println("Asigno un nuevo fabricante.");

            puntoLuz.getLuminaria().getArrancador().setFabricante(new Fabricante());
        }
    }

    public void imprimirUbicacion() {
        System.out.println("Latiud = " + puntoLuz.getUbicacionPunto().getLatittud());
        System.out.println("Longitud = " + puntoLuz.getUbicacionPunto().getLongitud());

        System.out.println("Barrio = " + puntoLuz.getUbicacionPunto().getBarrio().getId());
        System.out.println("Barrio = " + puntoLuz.getUbicacionPunto().getMunicipio().getId());
        System.out.println("Barrio = " + puntoLuz.getUbicacionPunto().getDireccion());
    }

    public void buscarDepartamentos() {
        departamentos.clear();
        departamentos = departamentoFacade.findAll();
    }

    public void buscarMunicipiosPorDepartamento() {
        municipios.clear();
        municipios = municipioFacade.getMunicipiosByDepartamento(departamento.getId());
    }

    public void buscarZonasPorMunicipio() {
        zonas.clear();
        zonas = zonaFacade.getZonasByMunicipio(municipio.getId());
    }

    public void buscarBarriosPorZona() {
        barrios.clear();
        barrios = barrioFacade.getBarriosByZona(zona.getId());
    }

    public void cambioDepartamento() {
        buscarMunicipiosPorDepartamento();

        zonas.clear();
        barrios.clear();

        municipio = new Municipio();
        zona = new Zona();
        barrio = new Barrio();
    }

    public void cambioMunicipio() {
        buscarZonasPorMunicipio();

        barrios.clear();

        zona = new Zona();
        barrio = new Barrio();
    }

    public void cambioZona() {
        buscarBarriosPorZona();

        barrio = new Barrio();
    }

    public void procesarOpcionesUbicacionPunto() {
        buscarDepartamentos();

        if (puntoLuz.getUbicacionPunto().getMunicipio() != null) {
            departamento = puntoLuz.getUbicacionPunto().getMunicipio().getDepartamento();
            municipio = puntoLuz.getUbicacionPunto().getMunicipio();

            buscarMunicipiosPorDepartamento();
            buscarZonasPorMunicipio();

            if (puntoLuz.getUbicacionPunto().getBarrio() != null) {
                zona = puntoLuz.getUbicacionPunto().getBarrio().getZona();
                barrio = puntoLuz.getUbicacionPunto().getBarrio();

                buscarBarriosPorZona();
            }
        }
    }

    public void guardarUbicacion() {
        if (municipio.getId() == null) {
            puntoLuz.getUbicacionPunto().setMunicipio(null);
        } else {
            municipio = municipioFacade.find(municipio.getId());
            puntoLuz.getUbicacionPunto().setMunicipio(municipio);
        }

        if (barrio.getId() == null) {
            puntoLuz.getUbicacionPunto().setBarrio(null);
        } else {
            barrio = barrioFacade.find(barrio.getId());
            puntoLuz.getUbicacionPunto().setBarrio(barrio);
        }

        if (puntoLuz.getUbicacionPunto().getId() == null) {
            ubicacionPuntoFacade.create(puntoLuz.getUbicacionPunto());
        } else {
            ubicacionPuntoFacade.edit(puntoLuz.getUbicacionPunto());
        }

        FacesMessage message = new FacesMessage("Hecho.", "Lo datos de la ubicación han sido guardados.");
        FacesContext.getCurrentInstance().addMessage(null, message);

        procesarOpcionesUbicacionPunto();
    }

    public void inicializarTransformador() {
        String inicializar = inicializarTiposTransformador();

        if (puntoLuz.getTransformador() == null) {
            puntoLuz.setTransformador(new Transformador());
            puntoLuz.getTransformador().setFabricante(new Fabricante());
            puntoLuz.getTransformador().setTipoTransformador(new TipoTransformador());
            puntoLuz.getTransformador().setTipoConexionTransformador(new TipoConexionTransformador());
            puntoLuz.getTransformador().setFase(new Fase());
            puntoLuz.getTransformador().setFrecuencia(new Frecuencia());
            puntoLuz.getTransformador().setPotencia(new Potencia());
            puntoLuz.getTransformador().setVoltajeAlta(new Voltaje());
            puntoLuz.getTransformador().setVoltajeBaja(new Voltaje());
        } else {
            if (puntoLuz.getTransformador().getTipoTransformador() == null) {
                puntoLuz.getTransformador().setTipoTransformador(new TipoTransformador());
            }
            if (puntoLuz.getTransformador().getFabricante() == null) {
                puntoLuz.getTransformador().setFabricante(new Fabricante());
            }

            if (puntoLuz.getTransformador().getFrecuencia() == null) {
                puntoLuz.getTransformador().setFrecuencia(new Frecuencia());
            }

            if (puntoLuz.getTransformador().getFase() == null) {
                puntoLuz.getTransformador().setFase(new Fase());
            }
            if (puntoLuz.getTransformador().getTipoConexionTransformador() == null) {
                puntoLuz.getTransformador().setTipoConexionTransformador(new TipoConexionTransformador());
            }
            if (puntoLuz.getTransformador().getVoltajeAlta() == null) {
                puntoLuz.getTransformador().setVoltajeAlta(new Voltaje());
            }

            if (puntoLuz.getTransformador().getVoltajeBaja() == null) {
                puntoLuz.getTransformador().setVoltajeBaja(new Voltaje());
            }

            if (puntoLuz.getTransformador().getPotencia() == null) {
                puntoLuz.getTransformador().setPotencia(new Potencia());
            }
        }
    }

    public void guardarTransformador() {
        if (puntoLuz.getTransformador().getId() == null) {
            verificarSeleccionParametricasTransformador();
            transformadorFacade.create(puntoLuz.getTransformador());
        } else {
            if (puntoLuz.getTransformador().getTipoTransformador().getId() != null) {
                puntoLuz.getTransformador().setTipoTransformador(tipoTransformadorFacade.find(puntoLuz.getTransformador().getTipoTransformador().getId()));
            } else {
                puntoLuz.getTransformador().setTipoConexionTransformador(null);
            }

            if (puntoLuz.getTransformador().getFabricante().getId() != 0) {
                puntoLuz.getTransformador().setFabricante(fabricanteFacade.find(puntoLuz.getTransformador().getFabricante().getId()));
            } else {
                puntoLuz.getTransformador().setFabricante(null);
            }

            if (puntoLuz.getTransformador().getFrecuencia().getId() != null) {
                puntoLuz.getTransformador().setFrecuencia(frecuenciaFacade.find(puntoLuz.getTransformador().getFrecuencia().getId()));
            } else {
                puntoLuz.getTransformador().setFrecuencia(null);
            }

            if (puntoLuz.getTransformador().getFase().getId() != null) {
                puntoLuz.getTransformador().setFase(faseFacade.find(puntoLuz.getTransformador().getFase().getId()));
            } else {
                puntoLuz.getTransformador().setFase(null);
            }

            if (puntoLuz.getTransformador().getTipoConexionTransformador().getId() != null) {
                puntoLuz.getTransformador().setTipoConexionTransformador(tipoConexionTransformadorFacade.find(puntoLuz.getTransformador().getTipoConexionTransformador().getId()));
            } else {
                puntoLuz.getTransformador().setTipoConexionTransformador(null);
            }

            if (puntoLuz.getTransformador().getVoltajeAlta().getId() != null) {
                puntoLuz.getTransformador().setVoltajeAlta(voltajeFacade.find(puntoLuz.getTransformador().getVoltajeAlta().getId()));
            } else {
                puntoLuz.getTransformador().setVoltajeAlta(null);
            }

            if (puntoLuz.getTransformador().getVoltajeBaja().getId() != null) {
                puntoLuz.getTransformador().setVoltajeBaja(voltajeFacade.find(puntoLuz.getTransformador().getVoltajeBaja().getId()));
            } else {
                puntoLuz.getTransformador().setVoltajeBaja(null);
            }

            if (puntoLuz.getTransformador().getPotencia().getId() != null) {
                puntoLuz.getTransformador().setPotencia(potenciaFacade.find(puntoLuz.getTransformador().getPotencia().getId()));
            } else {
                puntoLuz.getTransformador().setPotencia(null);
            }

            transformadorFacade.edit(puntoLuz.getTransformador());
        }

        FacesMessage message = new FacesMessage("Hecho.", "Lo datos del transformador han sido guardados.");
        FacesContext.getCurrentInstance().addMessage(null, message);

        inicializarTransformador();
    }

    public void inicializarLuminaria() {
        String inicializar = inicializarTiposLuminaria();

        if (puntoLuz.getLuminaria() == null) {
            puntoLuz.setLuminaria(new Luminaria());
            puntoLuz.getLuminaria().setTipoHerraje(new TipoHerraje());
            puntoLuz.getLuminaria().setFabricante(new Fabricante());
            puntoLuz.getLuminaria().setBrazoLuminaria(new BrazoLuminaria());
            puntoLuz.getLuminaria().setBalasto(new Balasto());
            puntoLuz.getLuminaria().getBalasto().setFabricante(new Fabricante());
            puntoLuz.getLuminaria().getBalasto().setTipoBalasto(new TipoBalasto());
            puntoLuz.getLuminaria().getBalasto().setTipoProteccion(new TipoProteccion());
            puntoLuz.getLuminaria().setArrancador(new Arrancador());
            puntoLuz.getLuminaria().getArrancador().setFabricante(new Fabricante());
            puntoLuz.getLuminaria().getArrancador().setTipoArrancador(new TipoArrancador());
            puntoLuz.getLuminaria().setPotencia(new Potencia());
        } else {
            if (puntoLuz.getLuminaria().getBrazoLuminaria() == null) {
                puntoLuz.getLuminaria().setBrazoLuminaria(new BrazoLuminaria());
            }

            if (puntoLuz.getLuminaria().getBalasto() == null) {
                puntoLuz.getLuminaria().setBalasto(new Balasto());
                puntoLuz.getLuminaria().getBalasto().setFabricante(new Fabricante());
                puntoLuz.getLuminaria().getBalasto().setTipoBalasto(new TipoBalasto());
                puntoLuz.getLuminaria().getBalasto().setTipoProteccion(new TipoProteccion());
            } else {
                if (puntoLuz.getLuminaria().getBalasto().getFabricante() == null) {
                    puntoLuz.getLuminaria().getBalasto().setFabricante(new Fabricante());
                }

                if (puntoLuz.getLuminaria().getBalasto().getTipoBalasto() == null) {
                    puntoLuz.getLuminaria().getBalasto().setTipoBalasto(new TipoBalasto());
                }

                if (puntoLuz.getLuminaria().getBalasto().getTipoProteccion() == null) {
                    puntoLuz.getLuminaria().getBalasto().setTipoProteccion(new TipoProteccion());
                }
            }

            if (puntoLuz.getLuminaria().getArrancador() == null) {
                puntoLuz.getLuminaria().setArrancador(new Arrancador());
                puntoLuz.getLuminaria().getArrancador().setFabricante(new Fabricante());
                puntoLuz.getLuminaria().getArrancador().setTipoArrancador(new TipoArrancador());
            } else {
                if (puntoLuz.getLuminaria().getArrancador().getFabricante() == null) {
                    puntoLuz.getLuminaria().getArrancador().setFabricante(new Fabricante());
                }

                if (puntoLuz.getLuminaria().getArrancador().getTipoArrancador() == null) {
                    puntoLuz.getLuminaria().getArrancador().setTipoArrancador(new TipoArrancador());
                }
            }

            if (puntoLuz.getLuminaria().getFabricante() == null) {
                puntoLuz.getLuminaria().setFabricante(new Fabricante());
            }

            if (puntoLuz.getLuminaria().getPotencia() == null) {
                puntoLuz.getLuminaria().setPotencia(new Potencia());
            }

            if (puntoLuz.getLuminaria().getTipoHerraje() == null) {
                puntoLuz.getLuminaria().setTipoHerraje(new TipoHerraje());
            }
        }
    }

    public void guardarLuminaria() {
        verificarSeleccionParametricasLuminaria();

        if (puntoLuz.getLuminaria().getId() == null) {
            luminariaFacade.create(puntoLuz.getLuminaria());
        } else {

            if (puntoLuz.getLuminaria().getBalasto().getFabricante() != null) {
                puntoLuz.getLuminaria().getBalasto().setFabricante(fabricanteFacade.find(puntoLuz.getLuminaria().getBalasto().getFabricante().getId()));
            }

            if (puntoLuz.getLuminaria().getBalasto().getTipoBalasto() != null) {
                puntoLuz.getLuminaria().getBalasto().setTipoBalasto(tipoBalastoFacade.find(puntoLuz.getLuminaria().getBalasto().getTipoBalasto().getId()));
            }

            if (puntoLuz.getLuminaria().getBalasto().getTipoProteccion() != null) {
                puntoLuz.getLuminaria().getBalasto().setTipoProteccion(tipoProteccionFacade.find(puntoLuz.getLuminaria().getBalasto().getTipoProteccion().getId()));
            }

            if (puntoLuz.getLuminaria().getArrancador().getFabricante() != null) {
                puntoLuz.getLuminaria().getArrancador().setFabricante(fabricanteFacade.find(puntoLuz.getLuminaria().getArrancador().getFabricante().getId()));
            }

            if (puntoLuz.getLuminaria().getArrancador().getTipoArrancador() != null) {
                puntoLuz.getLuminaria().getArrancador().setTipoArrancador(tipoArrancadorFacade.find(puntoLuz.getLuminaria().getArrancador().getTipoArrancador().getId()));
            }

            if (puntoLuz.getLuminaria().getFabricante() != null) {
                puntoLuz.getLuminaria().setFabricante(fabricanteFacade.find(puntoLuz.getLuminaria().getFabricante().getId()));
            }

            if (puntoLuz.getLuminaria().getPotencia() != null) {
                puntoLuz.getLuminaria().setPotencia(potenciaFacade.find(puntoLuz.getLuminaria().getPotencia().getId()));
            }

            if (puntoLuz.getLuminaria().getTipoHerraje() != null) {
                puntoLuz.getLuminaria().setTipoHerraje(tipoHerrajeFacade.find(puntoLuz.getLuminaria().getTipoHerraje().getId()));
            }

            luminariaFacade.edit(puntoLuz.getLuminaria());
        }

        FacesMessage message = new FacesMessage("Hecho.", "Lo datos de la luminaria han sido guardados.");
        FacesContext.getCurrentInstance().addMessage(null, message);

        inicializarLuminaria();
    }

    public void inicializarBombillo() {
        String inicializar = inicializarTiposBombillo();

        if (puntoLuz.getBombillo() == null) {
            puntoLuz.setBombillo(new Bombillo());
            puntoLuz.getBombillo().setFabricante(new Fabricante());
            puntoLuz.getBombillo().setTipoBombillo(new TipoBombillo());
            puntoLuz.getBombillo().setPotencia(new Potencia());
        } else {
            if (puntoLuz.getBombillo().getFabricante() == null) {
                puntoLuz.getBombillo().setFabricante(new Fabricante());
            }

            if (puntoLuz.getBombillo().getTipoBombillo() == null) {
                puntoLuz.getBombillo().setTipoBombillo(new TipoBombillo());
            }

            if (puntoLuz.getBombillo().getPotencia() == null) {
                puntoLuz.getBombillo().setPotencia(new Potencia());
            }
        }
    }

    public void guardarBombillo() {
        verificarSeleccionParametricasBombillo();

        if (puntoLuz.getBombillo().getId() == null) {
            bombilloFacade.create(puntoLuz.getBombillo());
        } else {
            if (puntoLuz.getBombillo().getFabricante() != null) {
                puntoLuz.getBombillo().setFabricante(fabricanteFacade.find(puntoLuz.getBombillo().getFabricante().getId()));
            }

            if (puntoLuz.getBombillo().getTipoBombillo() != null) {
                puntoLuz.getBombillo().setTipoBombillo(tipoBombilloFacade.find(puntoLuz.getBombillo().getTipoBombillo().getId()));
            }

            if (puntoLuz.getBombillo().getPotencia() != null) {
                puntoLuz.getBombillo().setPotencia(potenciaFacade.find(puntoLuz.getBombillo().getPotencia().getId()));
            }

            bombilloFacade.edit(puntoLuz.getBombillo());
        }

        FacesMessage message = new FacesMessage("Hecho.", "Lo datos del bombillo han sido guardados.");
        FacesContext.getCurrentInstance().addMessage(null, message);

        inicializarBombillo();
    }

    public void inicializarPoste() {
        String inicializar = inicializarTiposPoste();

        if (puntoLuz.getPoste() == null) {
            puntoLuz.setPoste(new Poste());
            puntoLuz.getPoste().setFabricante(new Fabricante());
            puntoLuz.getPoste().setAlturaPoste(new AlturaPoste());
            puntoLuz.getPoste().setMaterial(new MaterialPoste());
        } else {
            if (puntoLuz.getPoste().getFabricante() == null) {
                puntoLuz.getPoste().setFabricante(new Fabricante());
            }

            if (puntoLuz.getPoste().getAlturaPoste() == null) {
                puntoLuz.getPoste().setAlturaPoste(new AlturaPoste());
            }

            if (puntoLuz.getPoste().getMaterial() == null) {
                puntoLuz.getPoste().setMaterial(new MaterialPoste());
            }
        }
    }

    public void guardarPoste() {
        verificarSeleccionParametricasPoste();

        if (puntoLuz.getPoste().getId() == null) {
            posteFacade.create(puntoLuz.getPoste());
        } else {
            if (puntoLuz.getPoste().getFabricante() != null) {
                puntoLuz.getPoste().setFabricante(fabricanteFacade.find(puntoLuz.getPoste().getFabricante().getId()));
            }

            if (puntoLuz.getPoste().getAlturaPoste() != null) {
                puntoLuz.getPoste().setAlturaPoste(alturaPosteFacade.find(puntoLuz.getPoste().getAlturaPoste().getId()));
            }

            if (puntoLuz.getPoste().getMaterial() != null) {
                puntoLuz.getPoste().setMaterial(materialPosteFacade.find(puntoLuz.getPoste().getMaterial().getId()));
            }

            posteFacade.edit(puntoLuz.getPoste());
        }

        FacesMessage message = new FacesMessage("Hecho.", "Lo datos del poste han sido guardados.");
        FacesContext.getCurrentInstance().addMessage(null, message);

        inicializarPoste();
    }

    public void inicializarMedidor() {
        String incializar = inicializarTiposMedidor();

        if (puntoLuz.getMedidorEnergia() == null) {
            puntoLuz.setMedidorEnergia(new MedidorEnergia());
            puntoLuz.getMedidorEnergia().setFabricante(new Fabricante());
            puntoLuz.getMedidorEnergia().setClasePrecision(new ClasePrecision());
            puntoLuz.getMedidorEnergia().setTipoMedidor(new TipoMedidor());
            puntoLuz.getMedidorEnergia().setTipoConexionMedidor(new TipoConexionMedidor());
            puntoLuz.getMedidorEnergia().setTipoProteccion(new TipoProteccion());
            puntoLuz.getMedidorEnergia().setVoltajeAlta(new Voltaje());
            puntoLuz.getMedidorEnergia().setVoltajeBaja(new Voltaje());
            puntoLuz.getMedidorEnergia().setFrecuencia(new Frecuencia());
            puntoLuz.getMedidorEnergia().setPotenciaMaxima(new Potencia());
        } else {
            if (puntoLuz.getMedidorEnergia().getFabricante() == null) {
                puntoLuz.getMedidorEnergia().setFabricante(new Fabricante());
            }

            if (puntoLuz.getMedidorEnergia().getClasePrecision() == null) {
                puntoLuz.getMedidorEnergia().setClasePrecision(new ClasePrecision());
            }

            if (puntoLuz.getMedidorEnergia().getTipoMedidor() == null) {
                puntoLuz.getMedidorEnergia().setTipoMedidor(new TipoMedidor());
            }
            if (puntoLuz.getMedidorEnergia().getTipoConexionMedidor() == null) {
                puntoLuz.getMedidorEnergia().setTipoConexionMedidor(new TipoConexionMedidor());
            }
            if (puntoLuz.getMedidorEnergia().getTipoProteccion() == null) {
                puntoLuz.getMedidorEnergia().setTipoProteccion(new TipoProteccion());
            }
            if (puntoLuz.getMedidorEnergia().getVoltajeAlta() == null) {
                puntoLuz.getMedidorEnergia().setVoltajeAlta(new Voltaje());
            }
            if (puntoLuz.getMedidorEnergia().getVoltajeBaja() == null) {
                puntoLuz.getMedidorEnergia().setVoltajeBaja(new Voltaje());
            }
            if (puntoLuz.getMedidorEnergia().getFrecuencia() == null) {
                puntoLuz.getMedidorEnergia().setFrecuencia(new Frecuencia());
            }
            if (puntoLuz.getMedidorEnergia().getPotenciaMaxima() == null) {
                puntoLuz.getMedidorEnergia().setPotenciaMaxima(new Potencia());
            }
        }
    }

    public void guardarMedidor() {
        verificarSeleccionParametricasMedidor();

        if (puntoLuz.getMedidorEnergia().getId() == null) {
            medidorEnergiaFacade.create(puntoLuz.getMedidorEnergia());
        } else {
            if (puntoLuz.getMedidorEnergia().getFabricante() != null) {
                puntoLuz.getMedidorEnergia().setFabricante(fabricanteFacade.find(puntoLuz.getMedidorEnergia().getFabricante().getId()));
            }

            if (puntoLuz.getMedidorEnergia().getClasePrecision() != null) {
                puntoLuz.getMedidorEnergia().setClasePrecision(clasePrecisionFacade.find(puntoLuz.getMedidorEnergia().getClasePrecision().getId()));
            }

            if (puntoLuz.getMedidorEnergia().getTipoMedidor() != null) {
                puntoLuz.getMedidorEnergia().setTipoMedidor(tipoMedidorFacade.find(puntoLuz.getMedidorEnergia().getTipoMedidor().getId()));
            }
            if (puntoLuz.getMedidorEnergia().getTipoConexionMedidor() != null) {
                puntoLuz.getMedidorEnergia().setTipoConexionMedidor(tipoConexionMedidorFacade.find(puntoLuz.getMedidorEnergia().getTipoConexionMedidor().getId()));
            }
            if (puntoLuz.getMedidorEnergia().getTipoProteccion() != null) {
                puntoLuz.getMedidorEnergia().setTipoProteccion(tipoProteccionFacade.find(puntoLuz.getMedidorEnergia().getTipoProteccion().getId()));
            }
            if (puntoLuz.getMedidorEnergia().getVoltajeAlta() != null) {
                puntoLuz.getMedidorEnergia().setVoltajeAlta(voltajeFacade.find(puntoLuz.getMedidorEnergia().getVoltajeAlta().getId()));
            }
            if (puntoLuz.getMedidorEnergia().getVoltajeBaja() != null) {
                puntoLuz.getMedidorEnergia().setVoltajeBaja(voltajeFacade.find(puntoLuz.getMedidorEnergia().getVoltajeBaja().getId()));
            }
            if (puntoLuz.getMedidorEnergia().getFrecuencia() != null) {
                puntoLuz.getMedidorEnergia().setFrecuencia(frecuenciaFacade.find(puntoLuz.getMedidorEnergia().getFrecuencia().getId()));
            }
            if (puntoLuz.getMedidorEnergia().getPotenciaMaxima() != null) {
                puntoLuz.getMedidorEnergia().setPotenciaMaxima(potenciaFacade.find(puntoLuz.getMedidorEnergia().getPotenciaMaxima().getId()));
            }

            medidorEnergiaFacade.edit(puntoLuz.getMedidorEnergia());
        }

        FacesMessage message = new FacesMessage("Hecho.", "Lo datos del medidor de energía han sido guardados.");
        FacesContext.getCurrentInstance().addMessage(null, message);

        inicializarMedidor();
    }
}
