/* AssentSoftware (C)2021 */
package com.greek.main.hibernate.model;
// Generated 14 dic. 2021 22:42:55 by Hibernate Tools 3.2.2.GA and Assent Architecture

import com.gvt.core.domain.types.Auditable;
import com.gvt.core.domain.types.Cleanable;
import com.gvt.core.domain.types.Fillable;
import com.gvt.core.domain.types.Identificable;
import com.gvt.core.domain.types.Seleccionable;
import com.gvt.core.domain.types.Versionable;
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

/** Usuario generated by hbm2java */
@Entity
@EntityListeners({AuditingEntityListener.class})
@Table(
        name = "usuario",
        schema = "public",
        uniqueConstraints = @UniqueConstraint(columnNames = "codigo_usuario"))
public class Usuario
        implements Versionable,
                Seleccionable,
                Identificable,
                Fillable,
                Cleanable,
                Auditable,
                java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private long version;

    private OpcionSino opcionSinoByEsCuentaExpirada;

    private OpcionSino opcionSinoByEsConfiguradoPerfil;

    private OpcionSino opcionSinoByEsCredencialesExpiradas;

    private OpcionSino opcionSinoByEsActiva;

    private OpcionSino opcionSinoByEsCuentaBloqueada;

    private String codigoUsuario;

    private String passwordUsuario;

    private String passwordHintUsuario;

    private String textoArribaDerecha;

    private String textoPieDePagina;

    private String formatoFirma;

    private LocalDateTime fechaUltimoLogin;
    @CreatedBy private String usuarioCreacion;
    @CreatedDate private LocalDateTime fechaCreacion;
    @LastModifiedBy private String usuarioModificacion;
    @LastModifiedDate private LocalDateTime fechaModificacion;

    private Set<RolUsuario> rolUsuarios = new HashSet<RolUsuario>(0);

    private Set<UsuarioOrganizacion> usuarioOrganizacions = new HashSet<UsuarioOrganizacion>(0);

    public Usuario() {
        // default constructor
    }

    public Usuario(OpcionSino opcionSinoByEsActiva, String codigoUsuario, String passwordUsuario) {
        this.opcionSinoByEsActiva = opcionSinoByEsActiva;
        this.codigoUsuario = codigoUsuario;
        this.passwordUsuario = passwordUsuario;
    }

    public Usuario(
            OpcionSino opcionSinoByEsCuentaExpirada,
            OpcionSino opcionSinoByEsConfiguradoPerfil,
            OpcionSino opcionSinoByEsCredencialesExpiradas,
            OpcionSino opcionSinoByEsActiva,
            OpcionSino opcionSinoByEsCuentaBloqueada,
            String codigoUsuario,
            String passwordUsuario,
            String passwordHintUsuario,
            String textoArribaDerecha,
            String textoPieDePagina,
            String formatoFirma,
            LocalDateTime fechaUltimoLogin,
            String usuarioCreacion,
            LocalDateTime fechaCreacion,
            String usuarioModificacion,
            LocalDateTime fechaModificacion,
            Set<RolUsuario> rolUsuarios,
            Set<UsuarioOrganizacion> usuarioOrganizacions) {
        this.opcionSinoByEsCuentaExpirada = opcionSinoByEsCuentaExpirada;
        this.opcionSinoByEsConfiguradoPerfil = opcionSinoByEsConfiguradoPerfil;
        this.opcionSinoByEsCredencialesExpiradas = opcionSinoByEsCredencialesExpiradas;
        this.opcionSinoByEsActiva = opcionSinoByEsActiva;
        this.opcionSinoByEsCuentaBloqueada = opcionSinoByEsCuentaBloqueada;
        this.codigoUsuario = codigoUsuario;
        this.passwordUsuario = passwordUsuario;
        this.passwordHintUsuario = passwordHintUsuario;
        this.textoArribaDerecha = textoArribaDerecha;
        this.textoPieDePagina = textoPieDePagina;
        this.formatoFirma = formatoFirma;
        this.fechaUltimoLogin = fechaUltimoLogin;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.fechaModificacion = fechaModificacion;
        this.rolUsuarios = rolUsuarios;
        this.usuarioOrganizacions = usuarioOrganizacions;
    }

    @GenericGenerator(
            name = "usuario_seq_gen",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                @Parameter(name = "sequence_name", value = "usuario_id_seq"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(generator = "usuario_seq_gen")
    @Id
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "version", nullable = false)
    public long getVersion() {
        return this.version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "es_cuenta_expirada")
    public OpcionSino getOpcionSinoByEsCuentaExpirada() {
        return this.opcionSinoByEsCuentaExpirada;
    }

    public void setOpcionSinoByEsCuentaExpirada(OpcionSino opcionSinoByEsCuentaExpirada) {
        this.opcionSinoByEsCuentaExpirada = opcionSinoByEsCuentaExpirada;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "es_configurado_perfil")
    public OpcionSino getOpcionSinoByEsConfiguradoPerfil() {
        return this.opcionSinoByEsConfiguradoPerfil;
    }

    public void setOpcionSinoByEsConfiguradoPerfil(OpcionSino opcionSinoByEsConfiguradoPerfil) {
        this.opcionSinoByEsConfiguradoPerfil = opcionSinoByEsConfiguradoPerfil;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "es_credenciales_expiradas")
    public OpcionSino getOpcionSinoByEsCredencialesExpiradas() {
        return this.opcionSinoByEsCredencialesExpiradas;
    }

    public void setOpcionSinoByEsCredencialesExpiradas(
            OpcionSino opcionSinoByEsCredencialesExpiradas) {
        this.opcionSinoByEsCredencialesExpiradas = opcionSinoByEsCredencialesExpiradas;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "es_activa", nullable = false)
    public OpcionSino getOpcionSinoByEsActiva() {
        return this.opcionSinoByEsActiva;
    }

    public void setOpcionSinoByEsActiva(OpcionSino opcionSinoByEsActiva) {
        this.opcionSinoByEsActiva = opcionSinoByEsActiva;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "es_cuenta_bloqueada")
    public OpcionSino getOpcionSinoByEsCuentaBloqueada() {
        return this.opcionSinoByEsCuentaBloqueada;
    }

    public void setOpcionSinoByEsCuentaBloqueada(OpcionSino opcionSinoByEsCuentaBloqueada) {
        this.opcionSinoByEsCuentaBloqueada = opcionSinoByEsCuentaBloqueada;
    }

    @Column(name = "codigo_usuario", unique = true, nullable = false, length = 64)
    public String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @Column(name = "password_usuario", nullable = false, length = 128)
    public String getPasswordUsuario() {
        return this.passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    @Column(name = "password_hint_usuario", length = 64)
    public String getPasswordHintUsuario() {
        return this.passwordHintUsuario;
    }

    public void setPasswordHintUsuario(String passwordHintUsuario) {
        this.passwordHintUsuario = passwordHintUsuario;
    }

    @Column(name = "texto_arriba_derecha")
    public String getTextoArribaDerecha() {
        return this.textoArribaDerecha;
    }

    public void setTextoArribaDerecha(String textoArribaDerecha) {
        this.textoArribaDerecha = textoArribaDerecha;
    }

    @Column(name = "texto_pie_de_pagina")
    public String getTextoPieDePagina() {
        return this.textoPieDePagina;
    }

    public void setTextoPieDePagina(String textoPieDePagina) {
        this.textoPieDePagina = textoPieDePagina;
    }

    @Column(name = "formato_firma")
    public String getFormatoFirma() {
        return this.formatoFirma;
    }

    public void setFormatoFirma(String formatoFirma) {
        this.formatoFirma = formatoFirma;
    }

    @Column(name = "fecha_ultimo_login", length = 29)
    public LocalDateTime getFechaUltimoLogin() {
        return this.fechaUltimoLogin;
    }

    public void setFechaUltimoLogin(LocalDateTime fechaUltimoLogin) {
        this.fechaUltimoLogin = fechaUltimoLogin;
    }

    @Column(name = "usuario_creacion", length = 64)
    public String getUsuarioCreacion() {
        return this.usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    @Column(name = "fecha_creacion", length = 29)
    public LocalDateTime getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Column(name = "usuario_modificacion", length = 64)
    public String getUsuarioModificacion() {
        return this.usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    @Column(name = "fecha_modificacion", length = 29)
    public LocalDateTime getFechaModificacion() {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    // @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set<RolUsuario> getRolUsuarios() {
        return this.rolUsuarios;
    }

    public void setRolUsuarios(Set<RolUsuario> rolUsuarios) {
        this.rolUsuarios = rolUsuarios;
    }
    // @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set<UsuarioOrganizacion> getUsuarioOrganizacions() {
        return this.usuarioOrganizacions;
    }

    public void setUsuarioOrganizacions(Set<UsuarioOrganizacion> usuarioOrganizacions) {
        this.usuarioOrganizacions = usuarioOrganizacions;
    }

    /**
     * toString
     *
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        buffer.append(getClass().getName())
                .append("@")
                .append(Integer.toHexString(hashCode()))
                .append(" [");
        buffer.append("id").append("='").append(getId()).append("' ");
        buffer.append("version").append("='").append(getVersion()).append("' ");
        buffer.append("opcionSinoByEsCuentaExpirada")
                .append("='")
                .append(getOpcionSinoByEsCuentaExpirada())
                .append("' ");
        buffer.append("opcionSinoByEsConfiguradoPerfil")
                .append("='")
                .append(getOpcionSinoByEsConfiguradoPerfil())
                .append("' ");
        buffer.append("opcionSinoByEsCredencialesExpiradas")
                .append("='")
                .append(getOpcionSinoByEsCredencialesExpiradas())
                .append("' ");
        buffer.append("opcionSinoByEsActiva")
                .append("='")
                .append(getOpcionSinoByEsActiva())
                .append("' ");
        buffer.append("opcionSinoByEsCuentaBloqueada")
                .append("='")
                .append(getOpcionSinoByEsCuentaBloqueada())
                .append("' ");
        buffer.append("codigoUsuario").append("='").append(getCodigoUsuario()).append("' ");
        buffer.append("passwordUsuario").append("='").append(getPasswordUsuario()).append("' ");
        buffer.append("passwordHintUsuario")
                .append("='")
                .append(getPasswordHintUsuario())
                .append("' ");
        buffer.append("textoArribaDerecha")
                .append("='")
                .append(getTextoArribaDerecha())
                .append("' ");
        buffer.append("textoPieDePagina").append("='").append(getTextoPieDePagina()).append("' ");
        buffer.append("formatoFirma").append("='").append(getFormatoFirma()).append("' ");
        buffer.append("fechaUltimoLogin").append("='").append(getFechaUltimoLogin()).append("' ");
        buffer.append("usuarioCreacion").append("='").append(getUsuarioCreacion()).append("' ");
        buffer.append("fechaCreacion").append("='").append(getFechaCreacion()).append("' ");
        buffer.append("usuarioModificacion")
                .append("='")
                .append(getUsuarioModificacion())
                .append("' ");
        buffer.append("fechaModificacion").append("='").append(getFechaModificacion()).append("' ");
        buffer.append("]");

        return buffer.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;

        if (other == null) return false;

        if (!(other instanceof Usuario)) return false;

        Usuario castOther = (Usuario) other;

        return ((this.getId() == castOther.getId())
                        || (this.getId() != null
                                && castOther.getId() != null
                                && this.getId().equals(castOther.getId())))
                && (this.getVersion() == castOther.getVersion());
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
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
        if (this.opcionSinoByEsCuentaExpirada != null
                && (opcionSinoByEsCuentaExpirada.getId() == null
                        || this.opcionSinoByEsCuentaExpirada.getId().longValue() == 0)) {
            opcionSinoByEsCuentaExpirada = null;
        }
        if (this.opcionSinoByEsConfiguradoPerfil != null
                && (opcionSinoByEsConfiguradoPerfil.getId() == null
                        || this.opcionSinoByEsConfiguradoPerfil.getId().longValue() == 0)) {
            opcionSinoByEsConfiguradoPerfil = null;
        }
        if (this.opcionSinoByEsCredencialesExpiradas != null
                && (opcionSinoByEsCredencialesExpiradas.getId() == null
                        || this.opcionSinoByEsCredencialesExpiradas.getId().longValue() == 0)) {
            opcionSinoByEsCredencialesExpiradas = null;
        }
        if (this.opcionSinoByEsActiva != null
                && (opcionSinoByEsActiva.getId() == null
                        || this.opcionSinoByEsActiva.getId().longValue() == 0)) {
            opcionSinoByEsActiva = null;
        }
        if (this.opcionSinoByEsCuentaBloqueada != null
                && (opcionSinoByEsCuentaBloqueada.getId() == null
                        || this.opcionSinoByEsCuentaBloqueada.getId().longValue() == 0)) {
            opcionSinoByEsCuentaBloqueada = null;
        }
    }

    public void fillPOJO() {
        // Initialize all properties with new
        if (this.opcionSinoByEsCuentaExpirada == null) {
            opcionSinoByEsCuentaExpirada = new OpcionSino();
        }
        if (this.opcionSinoByEsConfiguradoPerfil == null) {
            opcionSinoByEsConfiguradoPerfil = new OpcionSino();
        }
        if (this.opcionSinoByEsCredencialesExpiradas == null) {
            opcionSinoByEsCredencialesExpiradas = new OpcionSino();
        }
        if (this.opcionSinoByEsActiva == null) {
            opcionSinoByEsActiva = new OpcionSino();
        }
        if (this.opcionSinoByEsCuentaBloqueada == null) {
            opcionSinoByEsCuentaBloqueada = new OpcionSino();
        }
    }

    public Usuario createPOJO() {
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
