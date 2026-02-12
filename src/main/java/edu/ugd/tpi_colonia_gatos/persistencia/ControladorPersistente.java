/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.persistencia;

import edu.ugd.tpi_colonia_gatos.modelo.Alimentacion;
import edu.ugd.tpi_colonia_gatos.modelo.CapturaCastracion;
import edu.ugd.tpi_colonia_gatos.modelo.CertificadosAdopcion;
import edu.ugd.tpi_colonia_gatos.modelo.Familia;
import edu.ugd.tpi_colonia_gatos.modelo.Gato;
import edu.ugd.tpi_colonia_gatos.modelo.HistorialMedico;
import edu.ugd.tpi_colonia_gatos.modelo.Hogares;
import edu.ugd.tpi_colonia_gatos.modelo.PostuladoParaAdopcion;
import edu.ugd.tpi_colonia_gatos.modelo.Tarea;
import edu.ugd.tpi_colonia_gatos.modelo.Turno;
import edu.ugd.tpi_colonia_gatos.modelo.Usuario;
import edu.ugd.tpi_colonia_gatos.modelo.Voluntario;
import edu.ugd.tpi_colonia_gatos.modelo.ZonasAvistamientos;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
    
public asd() {
         emf=Persistence.createEntityManagerFactory("colonia_gatos");

}
    
    
    
 * @author wowle
 */
public class ControladorPersistente {
    AdministradorJpaController admJPA = new AdministradorJpaController();
    AlimentacionJpaController aliJPA = new AlimentacionJpaController();
    AsignarGatoFamiliaJpaController asignargatofamiliaJPA = new AsignarGatoFamiliaJpaController();
    CapturaCastracionJpaController capturacastracionJPA = new CapturaCastracionJpaController();
    CertificadosAdopcionJpaController certificadoadopcionJPA =new CertificadosAdopcionJpaController();
    ControlVeterinarioJpaController controlveterinarioJPA = new ControlVeterinarioJpaController();
    DiagnosticosJpaController diagnosticosJPA = new DiagnosticosJpaController();
    EstudiosJpaController estudiosJPA = new EstudiosJpaController();
    FamiliaJpaController familiaJPA =new FamiliaJpaController();
    GatoJpaController gatoJPA = new GatoJpaController();
    
    HistorialMedicoJpaController historialJPA = new HistorialMedicoJpaController();
    HogaresJpaController hogarJPA = new HogaresJpaController();
    HogarAdopcionJpaController hogaradopcionJPA = new HogarAdopcionJpaController();
    HogarTransitoJpaController hogartransitoJPA = new HogarTransitoJpaController();
    PostuladoParaAdopcionJpaController postuladoJPA = new PostuladoParaAdopcionJpaController();
    TareaJpaController tareaJPA =new TareaJpaController();
    TratamientoJpaController tratamientoJPA = new TratamientoJpaController();
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();
   VeterinarioJpaController veterinarioJPA = new VeterinarioJpaController();
   VisitaSeguimientoJpaController visitasJPA = new VisitaSeguimientoJpaController();
   VoluntarioJpaController voluntarioJPA = new VoluntarioJpaController();
   ZonasAvistamientosJpaController zonasavistamientosJPA = new ZonasAvistamientosJpaController();
    TurnoJpaController turnoJPA = new TurnoJpaController();
   
   
   
public List<Turno> traerTurnos(){
    
    List<Turno> turnos = new ArrayList<>();
    turnos = turnoJPA.findTurnoEntities();
    return turnos;
}   
   
public void CrearHistorialMedico(HistorialMedico history){
  
    historialJPA.create(history);
    
}   
   
   
   
   
   
   
public PostuladoParaAdopcion obtenerPostulacionPorId(int id){
      
       return postuladoJPA.findPostuladoParaAdopcion(id);
       
}
   
  
   
          
 public void editarPostulacion( PostuladoParaAdopcion u){
      try {
            postuladoJPA.edit(u);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
}
          
          
          
 public List<PostuladoParaAdopcion> obtenerPostulaciones(){
  return postuladoJPA.findPostulacionesNoAceptadas();
 }
   
   
   public List<PostuladoParaAdopcion> obtenerAdoptados(){
   
    return postuladoJPA.obtenerGatosAdoptados();
   
}
   
   
   
   
    public Usuario autenticarUsuario(int dni, String pass) {
    Usuario usuario = usuarioJPA.findUsuarioByDniAndPass(dni, pass);
    if (usuario != null) {
        System.out.println("Usuario autenticado: " + usuario.getNombre());
    } else {
        System.out.println("Credenciales incorrectas");
    }
    return usuario;
}
   
    
    
     public void crearZona( ZonasAvistamientos u){
      try {
            zonasavistamientosJPA.create(u);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
 
    public ZonasAvistamientos traerZona(int id) {
        try {
          
            return zonasavistamientosJPA.findZonasAvistamientos(id); 
        } catch (Exception e) {
            return null;
        }
}
    
 public ZonasAvistamientos traerZonaPorNombre(String nombre) {
    List<ZonasAvistamientos> todas = zonasavistamientosJPA.findZonasAvistamientosEntities();
    for (ZonasAvistamientos z : todas) {
        if (z.getNombreZona().equals(nombre)) {
            return z;
        }
    }
    return null; // Si no lo encuentra
}
    
    
    
    
      public void modificarZona( ZonasAvistamientos u){
      try {
            zonasavistamientosJPA.edit(u);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
      public void eliminarZona(int dni){
        
       
          try {
             zonasavistamientosJPA.destroy(dni);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<ZonasAvistamientos> obtenerZonas(){
        return zonasavistamientosJPA.findZonasAvistamientosEntities();
    }
 
    public List<Usuario> obtenerUsuarios(){
        
        return usuarioJPA.findUsuarioEntities();
    }
   
    public void eliminarUsuario(int dni){
        
       
          try {
             usuarioJPA.destroy(dni);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
            
 public List<Hogares> traerHogares(){
       
        List<Hogares> g = new ArrayList<>();
        
            g = hogarJPA.findHogaresEntities();
                  
          return g;
}
           
            
            
            
            
public Hogares traerHogar(int id){
    
        Hogares g = new Hogares();
        
        try {
             g = hogarJPA.findHogares(id);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return g;
}
    
    
      
    public void crearCertificadoAptitud(CertificadosAdopcion u){
      try {
            certificadoadopcionJPA.create(u);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void modificarUsuario(Usuario u){
      try {
            usuarioJPA.edit(u);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Usuario obtenerUsuarioConDNI(int dni){
       
        return  usuarioJPA.findUsuario(dni);
    }
    
    
    
   
    
    public List<Usuario> obtenerTodosUsuarios() {
    List<Usuario> todos = new ArrayList<>();
    todos.addAll(familiaJPA.findFamiliaEntities());
    todos.addAll(voluntarioJPA.findVoluntarioEntities());
    todos.addAll(veterinarioJPA.findVeterinarioEntities());
    todos.addAll(admJPA.findAdministradorEntities());
    return todos;
}
    
    public Gato buscarPorId(int id){
        Gato g = new Gato();
        try {
             g = gatoJPA.findGato(id);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return g;
    }
  
    
    public void editarHistorial(HistorialMedico hist) throws Exception{
       try{  
       historialJPA.edit(hist);
       } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    
    
    
    public HistorialMedico findHistorialMedico(int id){
         HistorialMedico g = new HistorialMedico();
        try {
             g = historialJPA.findHistorialMedico(id);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return g;
    }
    
     
    
    
        public List<HistorialMedico> findHistorialMedico(){
        
        return historialJPA.findHistorialMedicoEntities();
    }
    
      public List<Gato> obtenerGatos(){
        
        return gatoJPA.findGatoEntities();
    }
    
    
    public List<Gato>  listaGatosAptos(){
    
   return gatoJPA.findGatosAptos();
    } 
    
    
    public void editarGato(Gato gato){
         try {
             gatoJPA.edit(gato);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         
    }
    
    
    
    
            
     public void crearHogar(Hogares h){
        try {
             hogarJPA.create(h);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         
    }
      
            
            
            
            
     public Hogares obtenerHogarPorId(int id){
        Hogares g = new Hogares();
        try {
             g = hogarJPA.findHogares(id);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return g;
    }
  
    
    
        public void nuevoCertificadoAdopcion(CertificadosAdopcion c){
        try {
             certificadoadopcionJPA.create(c);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         
    }    
            
            
            
     public void crearTarea(Tarea tarea){
        try {
             tareaJPA.create(tarea);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         
    }
  
    
    public void crearTareaCastracion(CapturaCastracion tarea){
        try {
             capturacastracionJPA.create(tarea);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
          
   
    }
    
    
    
     
    public Usuario buscarUsuarioCONDNI(int dni){
       
           return usuarioJPA.findUsuario(dni);
       
         
    }
        
    
      public void editarUsuario(Usuario usuario){
        try {
             usuarioJPA.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         
    }
    
    public void crearUsuario(Usuario usuario){
        try {
             usuarioJPA.create(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         
    }
    

        
  
    
     public void crearFamilia(Familia usuario){
        try {
             familiaJPA.create(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         
    }
   
     
     public void crearPostulacion(PostuladoParaAdopcion pos){
           try {
             postuladoJPA.create(pos);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     
        public Gato obtenerGatoPorId(int id){
       
           return gatoJPA.findGato(id);
       
         
    }
     
     
    
     
    public void crearGato(Gato gato){
        try {
             gatoJPA.create(gato);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         
        }
        
        public void crearTareaAlimentacion(Alimentacion alimentacion){
            
        try {
            aliJPA.create(alimentacion);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        public void crearVoluntario(Voluntario voluntario){
            
        try {
            voluntarioJPA.create(voluntario);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    public List<Gato> obtenerTodosLosGatos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Gato> findGatoEntities() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

 public void crearTurno(Turno t){
        try {
             turnoJPA.create(t);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistente.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         
 }
 
public void borrarTurnosMesActual() {
    try {
        List<Turno> lista = turnoJPA.findTurnoEntities();
        Calendar hoy = Calendar.getInstance();
        
        for (Turno t : lista) {
            Calendar fechaTurno = Calendar.getInstance();
            fechaTurno.setTime(t.getFechaHora());
            
            // Comparamos mes y año
            if (fechaTurno.get(Calendar.MONTH) == hoy.get(Calendar.MONTH) &&
                fechaTurno.get(Calendar.YEAR) == hoy.get(Calendar.YEAR)) {
                
                turnoJPA.destroy(t.getId());
            }
        }
    } catch (Exception e) {
        System.out.println("Error al limpiar turnos: " + e.getMessage());
    }
}   


    
  public void generarTurnosAutomaticos() {
    // 1. Traemos TODOS los usuarios
    this.borrarTurnosMesActual();
    List<Usuario> listaUsuarios = this.obtenerTodosUsuarios();
    
    // 2. Filtramos solo los que son de tipo "Voluntario"
    List<Usuario> listaVoluntariosFiltrados = new ArrayList<>();
    for (Usuario usu : listaUsuarios) {
        // Verificamos si el objeto 'usu' es una instancia de la clase hija Voluntario
        if (usu instanceof Voluntario) {
            listaVoluntariosFiltrados.add(usu);
        }
    }

    // Si no hay nadie con el rol de voluntario, salimos para evitar errores
    if (listaVoluntariosFiltrados.isEmpty()) {
        System.out.println("No se encontraron usuarios de la especialización Voluntario");
        return;
    }

    // 3. Lógica de reparto de días (Enero 2026)
    Calendar cal = Calendar.getInstance();
    int ultimoDia = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    int volIndice = 0;

    for (int dia = cal.get(Calendar.DAY_OF_MONTH); dia <= ultimoDia; dia++) {
        cal.set(Calendar.DAY_OF_MONTH, dia);
        cal.set(Calendar.HOUR_OF_DAY, 14); 
        
        Usuario v = listaVoluntariosFiltrados.get(volIndice);
        
        Turno t = new Turno();
        t.setTitulo(v.getNombre() + " - Alimentación"); 
        t.setFechaHora(cal.getTime());
        t.setNombreVoluntario(v.getNombre());
        
        this.crearTurno(t);
        
        // Rotación circular: vuelve al inicio de la lista cuando llega al final
        volIndice = (volIndice + 1) % listaVoluntariosFiltrados.size();
    }
}

    public Object traerGatos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
