package com.greek.main.hibernate.model;
// Generated 7 dic. 2021 10:22:07 by Hibernate Tools 3.2.2.GA and Assent Architecture


import com.gvt.core.domain.types.Auditable;
import com.gvt.core.domain.types.Cleanable;
import com.gvt.core.domain.types.Fillable;
import com.gvt.core.domain.types.Identificable;
import com.gvt.core.domain.types.Seleccionable;
import com.gvt.core.domain.types.Versionable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Persona generated by hbm2java
 */
@Entity
@EntityListeners({ AuditingEntityListener.class })
@Table(name="persona"
    ,schema="public"
    , uniqueConstraints = @UniqueConstraint(columnNames={"id_tipo_documento_identificacion", "cedula_persona", "id_pais"}) 
)
public class Persona  implements Versionable,Seleccionable,Identificable,Fillable,Cleanable,Auditable,java.io.Serializable {


	private static final long serialVersionUID = 1L;
 	
 	private Long id;
 	
 	private long version;
 	
 	private DistintivoPersona distintivoPersona;
 	
 	private EstadoCivil estadoCivil;
 	
 	private Sexo sexo;
 	
 	private TipoSangre tipoSangre;
 	
 	private UbicacionGeografica ubicacionGeograficaByIdUbicacionGeograficaNacimiento;
 	
 	private OpcionSino opcionSinoByEsActiva;
 	
 	private UbicacionGeografica ubicacionGeograficaByIdPais;
 	
 	private TipoDocumentoIdentificacion tipoDocumentoIdentificacion;
 	
 	private CodigoPostal codigoPostal;
 	
 	private OpcionSino opcionSinoByEsPublica;
 	
 	private String codigoPersona;
 	
 	private String cedulaPersona;
 	
 	private String nombrePersona;
 	
 	private String apellidoPersona;
 	
 	private String rifPersona;
 	
 	private String numeroMsas;
 	
 	private LocalDate fechaNacimientoPersona;
 	
 	private LocalDate fechaDefuncionPersona;
 	
 	private LocalDate fechaVencimientoRif;
 	
 	private String telefonoMovilPersona;
 	
 	private String telefonoFijoPersona;
 	
 	private String EMailPersona;
 	
 	private String direccionPersona;
 	
 	private String nombreContactoUno;
 	
 	private String telefonoContactoUno;
 	
 	private String telefonoMovilContactoUno;
 	
 	private String emailContactoUno;
 	
 	private String parentescoContactoUno;
 	
 	private String nombreContactoDos;
 	
 	private String telefonoContactoDos;
 	
 	private String telefonoMovilContactoDos;
 	
 	private String emailContactoDos;
 	
 	private String parentescoContactoDos;
 	
 	private Float edad;
 	
 	private String url1;
 	
 	private String url1FileName;
 	
 	private Double url1FileSize;
 	
 	private String comentariosAdicionales;
 	
 	private String nombreDoctorReferencia;
 	
 	private String telefonoContactoDoctorReferencia;
 	
 	private String telefonoMovilDoctorReferencia;
 	
 	private String emailDoctorReferencia;
 	
 	private String lugarNacimientoOtro;
 	
 	private String direccionPersonaCalleAvenida;
 	
 	private String direccionPersonaEdificio;
 	
 	private String direccionPersonaConsultorio;
 	@CreatedBy
 	private String usuarioCreacion;
 	@CreatedDate
 	private LocalDateTime fechaCreacion;
 	@LastModifiedBy
 	private String usuarioModificacion;
 	@LastModifiedDate
 	private LocalDateTime fechaModificacion;
 	
 	private Set<PersonaOrganizacion> personaOrganizacions = new HashSet<PersonaOrganizacion>(0);
 	
 	private Set<UsuarioOrganizacion> usuarioOrganizacions = new HashSet<UsuarioOrganizacion>(0);

    public Persona() {
    	// default constructor
    }

	
    public Persona(String codigoPersona, String cedulaPersona, String nombrePersona, String telefonoFijoPersona, String direccionPersona) {
        this.codigoPersona = codigoPersona;
        this.cedulaPersona = cedulaPersona;
        this.nombrePersona = nombrePersona;
        this.telefonoFijoPersona = telefonoFijoPersona;
        this.direccionPersona = direccionPersona;
    }
    public Persona(DistintivoPersona distintivoPersona, EstadoCivil estadoCivil, Sexo sexo, TipoSangre tipoSangre, UbicacionGeografica ubicacionGeograficaByIdUbicacionGeograficaNacimiento, OpcionSino opcionSinoByEsActiva, UbicacionGeografica ubicacionGeograficaByIdPais, TipoDocumentoIdentificacion tipoDocumentoIdentificacion, CodigoPostal codigoPostal, OpcionSino opcionSinoByEsPublica, String codigoPersona, String cedulaPersona, String nombrePersona, String apellidoPersona, String rifPersona, String numeroMsas, LocalDate fechaNacimientoPersona, LocalDate fechaDefuncionPersona, LocalDate fechaVencimientoRif, String telefonoMovilPersona, String telefonoFijoPersona, String EMailPersona, String direccionPersona, String nombreContactoUno, String telefonoContactoUno, String telefonoMovilContactoUno, String emailContactoUno, String parentescoContactoUno, String nombreContactoDos, String telefonoContactoDos, String telefonoMovilContactoDos, String emailContactoDos, String parentescoContactoDos, Float edad, String url1, String url1FileName, Double url1FileSize, String comentariosAdicionales, String nombreDoctorReferencia, String telefonoContactoDoctorReferencia, String telefonoMovilDoctorReferencia, String emailDoctorReferencia, String lugarNacimientoOtro, String direccionPersonaCalleAvenida, String direccionPersonaEdificio, String direccionPersonaConsultorio, String usuarioCreacion, LocalDateTime fechaCreacion, String usuarioModificacion, LocalDateTime fechaModificacion, Set<PersonaOrganizacion> personaOrganizacions, Set<UsuarioOrganizacion> usuarioOrganizacions) {
       this.distintivoPersona = distintivoPersona;
       this.estadoCivil = estadoCivil;
       this.sexo = sexo;
       this.tipoSangre = tipoSangre;
       this.ubicacionGeograficaByIdUbicacionGeograficaNacimiento = ubicacionGeograficaByIdUbicacionGeograficaNacimiento;
       this.opcionSinoByEsActiva = opcionSinoByEsActiva;
       this.ubicacionGeograficaByIdPais = ubicacionGeograficaByIdPais;
       this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
       this.codigoPostal = codigoPostal;
       this.opcionSinoByEsPublica = opcionSinoByEsPublica;
       this.codigoPersona = codigoPersona;
       this.cedulaPersona = cedulaPersona;
       this.nombrePersona = nombrePersona;
       this.apellidoPersona = apellidoPersona;
       this.rifPersona = rifPersona;
       this.numeroMsas = numeroMsas;
       this.fechaNacimientoPersona = fechaNacimientoPersona;
       this.fechaDefuncionPersona = fechaDefuncionPersona;
       this.fechaVencimientoRif = fechaVencimientoRif;
       this.telefonoMovilPersona = telefonoMovilPersona;
       this.telefonoFijoPersona = telefonoFijoPersona;
       this.EMailPersona = EMailPersona;
       this.direccionPersona = direccionPersona;
       this.nombreContactoUno = nombreContactoUno;
       this.telefonoContactoUno = telefonoContactoUno;
       this.telefonoMovilContactoUno = telefonoMovilContactoUno;
       this.emailContactoUno = emailContactoUno;
       this.parentescoContactoUno = parentescoContactoUno;
       this.nombreContactoDos = nombreContactoDos;
       this.telefonoContactoDos = telefonoContactoDos;
       this.telefonoMovilContactoDos = telefonoMovilContactoDos;
       this.emailContactoDos = emailContactoDos;
       this.parentescoContactoDos = parentescoContactoDos;
       this.edad = edad;
       this.url1 = url1;
       this.url1FileName = url1FileName;
       this.url1FileSize = url1FileSize;
       this.comentariosAdicionales = comentariosAdicionales;
       this.nombreDoctorReferencia = nombreDoctorReferencia;
       this.telefonoContactoDoctorReferencia = telefonoContactoDoctorReferencia;
       this.telefonoMovilDoctorReferencia = telefonoMovilDoctorReferencia;
       this.emailDoctorReferencia = emailDoctorReferencia;
       this.lugarNacimientoOtro = lugarNacimientoOtro;
       this.direccionPersonaCalleAvenida = direccionPersonaCalleAvenida;
       this.direccionPersonaEdificio = direccionPersonaEdificio;
       this.direccionPersonaConsultorio = direccionPersonaConsultorio;
       this.usuarioCreacion = usuarioCreacion;
       this.fechaCreacion = fechaCreacion;
       this.usuarioModificacion = usuarioModificacion;
       this.fechaModificacion = fechaModificacion;
       this.personaOrganizacions = personaOrganizacions;
       this.usuarioOrganizacions = usuarioOrganizacions;
    }
   
  @GenericGenerator(name = "persona_seq_gen", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "persona_id_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            })
  @GeneratedValue(generator = "persona_seq_gen")
  @Id
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    @Version
    @Column(name="version", nullable=false)
    public long getVersion() {
        return this.version;
    }
    
    public void setVersion(long version) {
        this.version = version;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_distintivo_persona")
    public DistintivoPersona getDistintivoPersona() {
        return this.distintivoPersona;
    }
    
    public void setDistintivoPersona(DistintivoPersona distintivoPersona) {
        this.distintivoPersona = distintivoPersona;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_estado_civil")
    public EstadoCivil getEstadoCivil() {
        return this.estadoCivil;
    }
    
    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_sexo")
    public Sexo getSexo() {
        return this.sexo;
    }
    
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_tipo_sangre")
    public TipoSangre getTipoSangre() {
        return this.tipoSangre;
    }
    
    public void setTipoSangre(TipoSangre tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_ubicacion_geografica_nacimiento")
    public UbicacionGeografica getUbicacionGeograficaByIdUbicacionGeograficaNacimiento() {
        return this.ubicacionGeograficaByIdUbicacionGeograficaNacimiento;
    }
    
    public void setUbicacionGeograficaByIdUbicacionGeograficaNacimiento(UbicacionGeografica ubicacionGeograficaByIdUbicacionGeograficaNacimiento) {
        this.ubicacionGeograficaByIdUbicacionGeograficaNacimiento = ubicacionGeograficaByIdUbicacionGeograficaNacimiento;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="es_activa")
    public OpcionSino getOpcionSinoByEsActiva() {
        return this.opcionSinoByEsActiva;
    }
    
    public void setOpcionSinoByEsActiva(OpcionSino opcionSinoByEsActiva) {
        this.opcionSinoByEsActiva = opcionSinoByEsActiva;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_pais")
    public UbicacionGeografica getUbicacionGeograficaByIdPais() {
        return this.ubicacionGeograficaByIdPais;
    }
    
    public void setUbicacionGeograficaByIdPais(UbicacionGeografica ubicacionGeograficaByIdPais) {
        this.ubicacionGeograficaByIdPais = ubicacionGeograficaByIdPais;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_tipo_documento_identificacion")
    public TipoDocumentoIdentificacion getTipoDocumentoIdentificacion() {
        return this.tipoDocumentoIdentificacion;
    }
    
    public void setTipoDocumentoIdentificacion(TipoDocumentoIdentificacion tipoDocumentoIdentificacion) {
        this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_codigo_postal")
    public CodigoPostal getCodigoPostal() {
        return this.codigoPostal;
    }
    
    public void setCodigoPostal(CodigoPostal codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="es_publica")
    public OpcionSino getOpcionSinoByEsPublica() {
        return this.opcionSinoByEsPublica;
    }
    
    public void setOpcionSinoByEsPublica(OpcionSino opcionSinoByEsPublica) {
        this.opcionSinoByEsPublica = opcionSinoByEsPublica;
    }
    
    @Column(name="codigo_persona", nullable=false, length=16)
    public String getCodigoPersona() {
        return this.codigoPersona;
    }
    
    public void setCodigoPersona(String codigoPersona) {
        this.codigoPersona = codigoPersona;
    }
    
    @Column(name="cedula_persona", nullable=false, length=64)
    public String getCedulaPersona() {
        return this.cedulaPersona;
    }
    
    public void setCedulaPersona(String cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }
    
    @Column(name="nombre_persona", nullable=false, length=64)
    public String getNombrePersona() {
        return this.nombrePersona;
    }
    
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
    
    @Column(name="apellido_persona", length=64)
    public String getApellidoPersona() {
        return this.apellidoPersona;
    }
    
    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }
    
    @Column(name="rif_persona", length=64)
    public String getRifPersona() {
        return this.rifPersona;
    }
    
    public void setRifPersona(String rifPersona) {
        this.rifPersona = rifPersona;
    }
    
    @Column(name="numero_msas")
    public String getNumeroMsas() {
        return this.numeroMsas;
    }
    
    public void setNumeroMsas(String numeroMsas) {
        this.numeroMsas = numeroMsas;
    }
    
    @Column(name="fecha_nacimiento_persona", length=13)
    public LocalDate getFechaNacimientoPersona() {
        return this.fechaNacimientoPersona;
    }
    
    public void setFechaNacimientoPersona(LocalDate fechaNacimientoPersona) {
        this.fechaNacimientoPersona = fechaNacimientoPersona;
    }
    
    @Column(name="fecha_defuncion_persona", length=13)
    public LocalDate getFechaDefuncionPersona() {
        return this.fechaDefuncionPersona;
    }
    
    public void setFechaDefuncionPersona(LocalDate fechaDefuncionPersona) {
        this.fechaDefuncionPersona = fechaDefuncionPersona;
    }
    
    @Column(name="fecha_vencimiento_rif", length=13)
    public LocalDate getFechaVencimientoRif() {
        return this.fechaVencimientoRif;
    }
    
    public void setFechaVencimientoRif(LocalDate fechaVencimientoRif) {
        this.fechaVencimientoRif = fechaVencimientoRif;
    }
    
    @Column(name="telefono_movil_persona", length=32)
    public String getTelefonoMovilPersona() {
        return this.telefonoMovilPersona;
    }
    
    public void setTelefonoMovilPersona(String telefonoMovilPersona) {
        this.telefonoMovilPersona = telefonoMovilPersona;
    }
    
    @Column(name="telefono_fijo_persona", nullable=false, length=32)
    public String getTelefonoFijoPersona() {
        return this.telefonoFijoPersona;
    }
    
    public void setTelefonoFijoPersona(String telefonoFijoPersona) {
        this.telefonoFijoPersona = telefonoFijoPersona;
    }
    
    @Column(name="e_mail_persona", length=64)
    public String getEMailPersona() {
        return this.EMailPersona;
    }
    
    public void setEMailPersona(String EMailPersona) {
        this.EMailPersona = EMailPersona;
    }
    
    @Column(name="direccion_persona", nullable=false)
    public String getDireccionPersona() {
        return this.direccionPersona;
    }
    
    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }
    
    @Column(name="nombre_contacto_uno", length=64)
    public String getNombreContactoUno() {
        return this.nombreContactoUno;
    }
    
    public void setNombreContactoUno(String nombreContactoUno) {
        this.nombreContactoUno = nombreContactoUno;
    }
    
    @Column(name="telefono_contacto_uno", length=32)
    public String getTelefonoContactoUno() {
        return this.telefonoContactoUno;
    }
    
    public void setTelefonoContactoUno(String telefonoContactoUno) {
        this.telefonoContactoUno = telefonoContactoUno;
    }
    
    @Column(name="telefono_movil_contacto_uno", length=32)
    public String getTelefonoMovilContactoUno() {
        return this.telefonoMovilContactoUno;
    }
    
    public void setTelefonoMovilContactoUno(String telefonoMovilContactoUno) {
        this.telefonoMovilContactoUno = telefonoMovilContactoUno;
    }
    
    @Column(name="email_contacto_uno", length=64)
    public String getEmailContactoUno() {
        return this.emailContactoUno;
    }
    
    public void setEmailContactoUno(String emailContactoUno) {
        this.emailContactoUno = emailContactoUno;
    }
    
    @Column(name="parentesco_contacto_uno")
    public String getParentescoContactoUno() {
        return this.parentescoContactoUno;
    }
    
    public void setParentescoContactoUno(String parentescoContactoUno) {
        this.parentescoContactoUno = parentescoContactoUno;
    }
    
    @Column(name="nombre_contacto_dos", length=64)
    public String getNombreContactoDos() {
        return this.nombreContactoDos;
    }
    
    public void setNombreContactoDos(String nombreContactoDos) {
        this.nombreContactoDos = nombreContactoDos;
    }
    
    @Column(name="telefono_contacto_dos", length=32)
    public String getTelefonoContactoDos() {
        return this.telefonoContactoDos;
    }
    
    public void setTelefonoContactoDos(String telefonoContactoDos) {
        this.telefonoContactoDos = telefonoContactoDos;
    }
    
    @Column(name="telefono_movil_contacto_dos", length=32)
    public String getTelefonoMovilContactoDos() {
        return this.telefonoMovilContactoDos;
    }
    
    public void setTelefonoMovilContactoDos(String telefonoMovilContactoDos) {
        this.telefonoMovilContactoDos = telefonoMovilContactoDos;
    }
    
    @Column(name="email_contacto_dos", length=64)
    public String getEmailContactoDos() {
        return this.emailContactoDos;
    }
    
    public void setEmailContactoDos(String emailContactoDos) {
        this.emailContactoDos = emailContactoDos;
    }
    
    @Column(name="parentesco_contacto_dos")
    public String getParentescoContactoDos() {
        return this.parentescoContactoDos;
    }
    
    public void setParentescoContactoDos(String parentescoContactoDos) {
        this.parentescoContactoDos = parentescoContactoDos;
    }
    
    @Column(name="edad", precision=8, scale=8)
    public Float getEdad() {
        return this.edad;
    }
    
    public void setEdad(Float edad) {
        this.edad = edad;
    }
    
    @Column(name="url1")
    public String getUrl1() {
        return this.url1;
    }
    
    public void setUrl1(String url1) {
        this.url1 = url1;
    }
    
    @Column(name="url1_file_name")
    public String getUrl1FileName() {
        return this.url1FileName;
    }
    
    public void setUrl1FileName(String url1FileName) {
        this.url1FileName = url1FileName;
    }
    
    @Column(name="url1_file_size", precision=17, scale=17)
    public Double getUrl1FileSize() {
        return this.url1FileSize;
    }
    
    public void setUrl1FileSize(Double url1FileSize) {
        this.url1FileSize = url1FileSize;
    }
    
    @Column(name="comentarios_adicionales")
    public String getComentariosAdicionales() {
        return this.comentariosAdicionales;
    }
    
    public void setComentariosAdicionales(String comentariosAdicionales) {
        this.comentariosAdicionales = comentariosAdicionales;
    }
    
    @Column(name="nombre_doctor_referencia")
    public String getNombreDoctorReferencia() {
        return this.nombreDoctorReferencia;
    }
    
    public void setNombreDoctorReferencia(String nombreDoctorReferencia) {
        this.nombreDoctorReferencia = nombreDoctorReferencia;
    }
    
    @Column(name="telefono_contacto_doctor_referencia", length=32)
    public String getTelefonoContactoDoctorReferencia() {
        return this.telefonoContactoDoctorReferencia;
    }
    
    public void setTelefonoContactoDoctorReferencia(String telefonoContactoDoctorReferencia) {
        this.telefonoContactoDoctorReferencia = telefonoContactoDoctorReferencia;
    }
    
    @Column(name="telefono_movil_doctor_referencia", length=32)
    public String getTelefonoMovilDoctorReferencia() {
        return this.telefonoMovilDoctorReferencia;
    }
    
    public void setTelefonoMovilDoctorReferencia(String telefonoMovilDoctorReferencia) {
        this.telefonoMovilDoctorReferencia = telefonoMovilDoctorReferencia;
    }
    
    @Column(name="email_doctor_referencia", length=64)
    public String getEmailDoctorReferencia() {
        return this.emailDoctorReferencia;
    }
    
    public void setEmailDoctorReferencia(String emailDoctorReferencia) {
        this.emailDoctorReferencia = emailDoctorReferencia;
    }
    
    @Column(name="lugar_nacimiento_otro", length=128)
    public String getLugarNacimientoOtro() {
        return this.lugarNacimientoOtro;
    }
    
    public void setLugarNacimientoOtro(String lugarNacimientoOtro) {
        this.lugarNacimientoOtro = lugarNacimientoOtro;
    }
    
    @Column(name="direccion_persona_calle_avenida")
    public String getDireccionPersonaCalleAvenida() {
        return this.direccionPersonaCalleAvenida;
    }
    
    public void setDireccionPersonaCalleAvenida(String direccionPersonaCalleAvenida) {
        this.direccionPersonaCalleAvenida = direccionPersonaCalleAvenida;
    }
    
    @Column(name="direccion_persona_edificio")
    public String getDireccionPersonaEdificio() {
        return this.direccionPersonaEdificio;
    }
    
    public void setDireccionPersonaEdificio(String direccionPersonaEdificio) {
        this.direccionPersonaEdificio = direccionPersonaEdificio;
    }
    
    @Column(name="direccion_persona_consultorio")
    public String getDireccionPersonaConsultorio() {
        return this.direccionPersonaConsultorio;
    }
    
    public void setDireccionPersonaConsultorio(String direccionPersonaConsultorio) {
        this.direccionPersonaConsultorio = direccionPersonaConsultorio;
    }
    
    @Column(name="usuario_creacion", length=64)
    public String getUsuarioCreacion() {
        return this.usuarioCreacion;
    }
    
    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
    
    @Column(name="fecha_creacion", length=29)
    public LocalDateTime getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    @Column(name="usuario_modificacion", length=64)
    public String getUsuarioModificacion() {
        return this.usuarioModificacion;
    }
    
    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
    
    @Column(name="fecha_modificacion", length=29)
    public LocalDateTime getFechaModificacion() {
        return this.fechaModificacion;
    }
    
    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
	//@JsonIgnore
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="persona")
    public Set<PersonaOrganizacion> getPersonaOrganizacions() {
        return this.personaOrganizacions;
    }
    
    public void setPersonaOrganizacions(Set<PersonaOrganizacion> personaOrganizacions) {
        this.personaOrganizacions = personaOrganizacions;
    }
	//@JsonIgnore
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="persona")
    public Set<UsuarioOrganizacion> getUsuarioOrganizacions() {
        return this.usuarioOrganizacions;
    }
    
    public void setUsuarioOrganizacions(Set<UsuarioOrganizacion> usuarioOrganizacions) {
        this.usuarioOrganizacions = usuarioOrganizacions;
    }

    /**
     * toString
     * @return String
     */
     @Override
     public String toString() {
	  StringBuilder buffer = new StringBuilder();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
      buffer.append("id").append("='").append(getId()).append("' ");			
      buffer.append("version").append("='").append(getVersion()).append("' ");			
      buffer.append("distintivoPersona").append("='").append(getDistintivoPersona()).append("' ");			
      buffer.append("estadoCivil").append("='").append(getEstadoCivil()).append("' ");			
      buffer.append("sexo").append("='").append(getSexo()).append("' ");			
      buffer.append("tipoSangre").append("='").append(getTipoSangre()).append("' ");			
      buffer.append("ubicacionGeograficaByIdUbicacionGeograficaNacimiento").append("='").append(getUbicacionGeograficaByIdUbicacionGeograficaNacimiento()).append("' ");			
      buffer.append("opcionSinoByEsActiva").append("='").append(getOpcionSinoByEsActiva()).append("' ");			
      buffer.append("ubicacionGeograficaByIdPais").append("='").append(getUbicacionGeograficaByIdPais()).append("' ");			
      buffer.append("tipoDocumentoIdentificacion").append("='").append(getTipoDocumentoIdentificacion()).append("' ");			
      buffer.append("codigoPostal").append("='").append(getCodigoPostal()).append("' ");			
      buffer.append("opcionSinoByEsPublica").append("='").append(getOpcionSinoByEsPublica()).append("' ");			
      buffer.append("codigoPersona").append("='").append(getCodigoPersona()).append("' ");			
      buffer.append("cedulaPersona").append("='").append(getCedulaPersona()).append("' ");			
      buffer.append("nombrePersona").append("='").append(getNombrePersona()).append("' ");			
      buffer.append("apellidoPersona").append("='").append(getApellidoPersona()).append("' ");			
      buffer.append("rifPersona").append("='").append(getRifPersona()).append("' ");			
      buffer.append("numeroMsas").append("='").append(getNumeroMsas()).append("' ");			
      buffer.append("fechaNacimientoPersona").append("='").append(getFechaNacimientoPersona()).append("' ");			
      buffer.append("fechaDefuncionPersona").append("='").append(getFechaDefuncionPersona()).append("' ");			
      buffer.append("fechaVencimientoRif").append("='").append(getFechaVencimientoRif()).append("' ");			
      buffer.append("telefonoMovilPersona").append("='").append(getTelefonoMovilPersona()).append("' ");			
      buffer.append("telefonoFijoPersona").append("='").append(getTelefonoFijoPersona()).append("' ");			
      buffer.append("EMailPersona").append("='").append(getEMailPersona()).append("' ");			
      buffer.append("direccionPersona").append("='").append(getDireccionPersona()).append("' ");			
      buffer.append("nombreContactoUno").append("='").append(getNombreContactoUno()).append("' ");			
      buffer.append("telefonoContactoUno").append("='").append(getTelefonoContactoUno()).append("' ");			
      buffer.append("telefonoMovilContactoUno").append("='").append(getTelefonoMovilContactoUno()).append("' ");			
      buffer.append("emailContactoUno").append("='").append(getEmailContactoUno()).append("' ");			
      buffer.append("parentescoContactoUno").append("='").append(getParentescoContactoUno()).append("' ");			
      buffer.append("nombreContactoDos").append("='").append(getNombreContactoDos()).append("' ");			
      buffer.append("telefonoContactoDos").append("='").append(getTelefonoContactoDos()).append("' ");			
      buffer.append("telefonoMovilContactoDos").append("='").append(getTelefonoMovilContactoDos()).append("' ");			
      buffer.append("emailContactoDos").append("='").append(getEmailContactoDos()).append("' ");			
      buffer.append("parentescoContactoDos").append("='").append(getParentescoContactoDos()).append("' ");			
      buffer.append("edad").append("='").append(getEdad()).append("' ");			
      buffer.append("url1").append("='").append(getUrl1()).append("' ");			
      buffer.append("url1FileName").append("='").append(getUrl1FileName()).append("' ");			
      buffer.append("url1FileSize").append("='").append(getUrl1FileSize()).append("' ");			
      buffer.append("comentariosAdicionales").append("='").append(getComentariosAdicionales()).append("' ");			
      buffer.append("nombreDoctorReferencia").append("='").append(getNombreDoctorReferencia()).append("' ");			
      buffer.append("telefonoContactoDoctorReferencia").append("='").append(getTelefonoContactoDoctorReferencia()).append("' ");			
      buffer.append("telefonoMovilDoctorReferencia").append("='").append(getTelefonoMovilDoctorReferencia()).append("' ");			
      buffer.append("emailDoctorReferencia").append("='").append(getEmailDoctorReferencia()).append("' ");			
      buffer.append("lugarNacimientoOtro").append("='").append(getLugarNacimientoOtro()).append("' ");			
      buffer.append("direccionPersonaCalleAvenida").append("='").append(getDireccionPersonaCalleAvenida()).append("' ");			
      buffer.append("direccionPersonaEdificio").append("='").append(getDireccionPersonaEdificio()).append("' ");			
      buffer.append("direccionPersonaConsultorio").append("='").append(getDireccionPersonaConsultorio()).append("' ");			
      buffer.append("usuarioCreacion").append("='").append(getUsuarioCreacion()).append("' ");			
      buffer.append("fechaCreacion").append("='").append(getFechaCreacion()).append("' ");			
      buffer.append("usuarioModificacion").append("='").append(getUsuarioModificacion()).append("' ");			
      buffer.append("fechaModificacion").append("='").append(getFechaModificacion()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }

	@Override
	public boolean equals(Object other) {
         if (this == other) 
         	return true;
         	
		 if (other == null) 
		 	return false;
		 	
		 if (!(other instanceof Persona)) 
		 	return false;
		 	
		 Persona castOther = ( Persona ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && (this.getVersion()==castOther.getVersion());
   }
   
   @Override
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + (int) this.getVersion();
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         return result;
   }   

  // The following is extra code specified in src/main/config/templates
// Adding extra-code
	private boolean comesFromExternalDataSource = false;
	private boolean selected;
	
	@javax.persistence.Transient
    public boolean isExternalDataSource() {
		return this.comesFromExternalDataSource;
    }

    public void setExternalDataSource(boolean value) {
        this.comesFromExternalDataSource = value;
    }

	@javax.persistence.Transient
	public boolean getSelected() {
		return selected;
	}

    public void setSelected(boolean selected) {
		this.selected = selected;
    }
    
    public void cleanPOJO() {
    	// Clean entities objects with id
		if(this.distintivoPersona != null &&
			(distintivoPersona.getId() == null || this.distintivoPersona.getId().longValue() == 0)) {
			distintivoPersona = null;
		}
		if(this.estadoCivil != null &&
			(estadoCivil.getId() == null || this.estadoCivil.getId().longValue() == 0)) {
			estadoCivil = null;
		}
		if(this.sexo != null &&
			(sexo.getId() == null || this.sexo.getId().longValue() == 0)) {
			sexo = null;
		}
		if(this.tipoSangre != null &&
			(tipoSangre.getId() == null || this.tipoSangre.getId().longValue() == 0)) {
			tipoSangre = null;
		}
		if(this.ubicacionGeograficaByIdUbicacionGeograficaNacimiento != null &&
			(ubicacionGeograficaByIdUbicacionGeograficaNacimiento.getId() == null || this.ubicacionGeograficaByIdUbicacionGeograficaNacimiento.getId().longValue() == 0)) {
			ubicacionGeograficaByIdUbicacionGeograficaNacimiento = null;
		}
		if(this.opcionSinoByEsActiva != null &&
			(opcionSinoByEsActiva.getId() == null || this.opcionSinoByEsActiva.getId().longValue() == 0)) {
			opcionSinoByEsActiva = null;
		}
		if(this.ubicacionGeograficaByIdPais != null &&
			(ubicacionGeograficaByIdPais.getId() == null || this.ubicacionGeograficaByIdPais.getId().longValue() == 0)) {
			ubicacionGeograficaByIdPais = null;
		}
		if(this.tipoDocumentoIdentificacion != null &&
			(tipoDocumentoIdentificacion.getId() == null || this.tipoDocumentoIdentificacion.getId().longValue() == 0)) {
			tipoDocumentoIdentificacion = null;
		}
		if(this.codigoPostal != null &&
			(codigoPostal.getId() == null || this.codigoPostal.getId().longValue() == 0)) {
			codigoPostal = null;
		}
		if(this.opcionSinoByEsPublica != null &&
			(opcionSinoByEsPublica.getId() == null || this.opcionSinoByEsPublica.getId().longValue() == 0)) {
			opcionSinoByEsPublica = null;
		}
    }
    
    public void fillPOJO() {
    	// Initialize all properties with new
		if(this.distintivoPersona == null) {
			distintivoPersona = new DistintivoPersona();
		}
		if(this.estadoCivil == null) {
			estadoCivil = new EstadoCivil();
		}
		if(this.sexo == null) {
			sexo = new Sexo();
		}
		if(this.tipoSangre == null) {
			tipoSangre = new TipoSangre();
		}
		if(this.ubicacionGeograficaByIdUbicacionGeograficaNacimiento == null) {
			ubicacionGeograficaByIdUbicacionGeograficaNacimiento = new UbicacionGeografica();
		}
		if(this.opcionSinoByEsActiva == null) {
			opcionSinoByEsActiva = new OpcionSino();
		}
		if(this.ubicacionGeograficaByIdPais == null) {
			ubicacionGeograficaByIdPais = new UbicacionGeografica();
		}
		if(this.tipoDocumentoIdentificacion == null) {
			tipoDocumentoIdentificacion = new TipoDocumentoIdentificacion();
		}
		if(this.codigoPostal == null) {
			codigoPostal = new CodigoPostal();
		}
		if(this.opcionSinoByEsPublica == null) {
			opcionSinoByEsPublica = new OpcionSino();
		}
    }
    
    public Persona createPOJO() {
		fillPOJO();
		
		return this;
	}
	
//	@PrePersist
//	public void onPrePersist() {
//		this.fechaCreacion = new Date();
//		this.usuarioCreacion = getSecurityContextPrincipal();
//	}
//
//	@PreUpdate
//	public void onPreUpdate() {
//		this.fechaModificacion = new Date();
//		this.usuarioModificacion = getSecurityContextPrincipal();
//	}
//
//	@javax.persistence.Transient
//	private String getSecurityContextPrincipal() {
//		String principal;
//		String UNKNOWN_USER = "unknownUser";
//
//		if (SecurityContextHolder.getContext().getAuthentication() == null) {
//			principal = UNKNOWN_USER;
//		} else {
//			try {
//				principal = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
//						.getUsername();
//			} catch (ClassCastException e) {
//				principal = UNKNOWN_USER;
//			}
//		}
//
//		return principal;
//	}
	
  // end of extra code specified in the hbm.xml files

}

