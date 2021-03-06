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
import javax.persistence.Version;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/** CodigoPostal generated by hbm2java */
@Entity
@EntityListeners({AuditingEntityListener.class})
@Table(name = "codigo_postal", schema = "public")
public class CodigoPostal
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

    private Provincia provincia;

    private Poblacion poblacion;

    private UbicacionGeografica ubicacionGeografica;

    private String codigoPostal;
    @CreatedBy private String usuarioCreacion;
    @CreatedDate private LocalDateTime fechaCreacion;
    @LastModifiedBy private String usuarioModificacion;
    @LastModifiedDate private LocalDateTime fechaModificacion;

    private Set<Organizacion> organizacions = new HashSet<Organizacion>(0);

    private Set<Persona> personas = new HashSet<Persona>(0);

    public CodigoPostal() {
        // default constructor
    }

    public CodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public CodigoPostal(
            Provincia provincia,
            Poblacion poblacion,
            UbicacionGeografica ubicacionGeografica,
            String codigoPostal,
            String usuarioCreacion,
            LocalDateTime fechaCreacion,
            String usuarioModificacion,
            LocalDateTime fechaModificacion,
            Set<Organizacion> organizacions,
            Set<Persona> personas) {
        this.provincia = provincia;
        this.poblacion = poblacion;
        this.ubicacionGeografica = ubicacionGeografica;
        this.codigoPostal = codigoPostal;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.fechaModificacion = fechaModificacion;
        this.organizacions = organizacions;
        this.personas = personas;
    }

    @GenericGenerator(
            name = "codigo_postal_seq_gen",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                @Parameter(name = "sequence_name", value = "codigo_postal_id_seq"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(generator = "codigo_postal_seq_gen")
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
    @JoinColumn(name = "id_provincia")
    public Provincia getProvincia() {
        return this.provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_poblacion")
    public Poblacion getPoblacion() {
        return this.poblacion;
    }

    public void setPoblacion(Poblacion poblacion) {
        this.poblacion = poblacion;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion_geografica")
    public UbicacionGeografica getUbicacionGeografica() {
        return this.ubicacionGeografica;
    }

    public void setUbicacionGeografica(UbicacionGeografica ubicacionGeografica) {
        this.ubicacionGeografica = ubicacionGeografica;
    }

    @Column(name = "codigo_postal", nullable = false, length = 16)
    public String getCodigoPostal() {
        return this.codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "codigoPostal")
    public Set<Organizacion> getOrganizacions() {
        return this.organizacions;
    }

    public void setOrganizacions(Set<Organizacion> organizacions) {
        this.organizacions = organizacions;
    }
    // @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "codigoPostal")
    public Set<Persona> getPersonas() {
        return this.personas;
    }

    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
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
        buffer.append("provincia").append("='").append(getProvincia()).append("' ");
        buffer.append("poblacion").append("='").append(getPoblacion()).append("' ");
        buffer.append("ubicacionGeografica")
                .append("='")
                .append(getUbicacionGeografica())
                .append("' ");
        buffer.append("codigoPostal").append("='").append(getCodigoPostal()).append("' ");
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

        if (!(other instanceof CodigoPostal)) return false;

        CodigoPostal castOther = (CodigoPostal) other;

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
        if (this.provincia != null
                && (provincia.getId() == null || this.provincia.getId().longValue() == 0)) {
            provincia = null;
        }
        if (this.poblacion != null
                && (poblacion.getId() == null || this.poblacion.getId().longValue() == 0)) {
            poblacion = null;
        }
        if (this.ubicacionGeografica != null
                && (ubicacionGeografica.getId() == null
                        || this.ubicacionGeografica.getId().longValue() == 0)) {
            ubicacionGeografica = null;
        }
    }

    public void fillPOJO() {
        // Initialize all properties with new
        if (this.provincia == null) {
            provincia = new Provincia();
        }
        if (this.poblacion == null) {
            poblacion = new Poblacion();
        }
        if (this.ubicacionGeografica == null) {
            ubicacionGeografica = new UbicacionGeografica();
        }
    }

    public CodigoPostal createPOJO() {
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
