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

/** Provincia generated by hbm2java */
@Entity
@EntityListeners({AuditingEntityListener.class})
@Table(
        name = "provincia",
        schema = "public",
        uniqueConstraints = @UniqueConstraint(columnNames = "codigo_provincia"))
public class Provincia
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

    private String codigoProvincia;

    private String nombreProvincia;
    @CreatedBy private String usuarioCreacion;
    @CreatedDate private LocalDateTime fechaCreacion;
    @LastModifiedBy private String usuarioModificacion;
    @LastModifiedDate private LocalDateTime fechaModificacion;

    private Set<CodigoPostal> codigoPostals = new HashSet<CodigoPostal>(0);

    public Provincia() {
        // default constructor
    }

    public Provincia(String codigoProvincia, String nombreProvincia) {
        this.codigoProvincia = codigoProvincia;
        this.nombreProvincia = nombreProvincia;
    }

    public Provincia(
            String codigoProvincia,
            String nombreProvincia,
            String usuarioCreacion,
            LocalDateTime fechaCreacion,
            String usuarioModificacion,
            LocalDateTime fechaModificacion,
            Set<CodigoPostal> codigoPostals) {
        this.codigoProvincia = codigoProvincia;
        this.nombreProvincia = nombreProvincia;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.fechaModificacion = fechaModificacion;
        this.codigoPostals = codigoPostals;
    }

    @GenericGenerator(
            name = "provincia_seq_gen",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                @Parameter(name = "sequence_name", value = "provincia_id_seq"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(generator = "provincia_seq_gen")
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

    @Column(name = "codigo_provincia", unique = true, nullable = false, length = 16)
    public String getCodigoProvincia() {
        return this.codigoProvincia;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    @Column(name = "nombre_provincia", nullable = false, length = 64)
    public String getNombreProvincia() {
        return this.nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "provincia")
    public Set<CodigoPostal> getCodigoPostals() {
        return this.codigoPostals;
    }

    public void setCodigoPostals(Set<CodigoPostal> codigoPostals) {
        this.codigoPostals = codigoPostals;
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
        buffer.append("codigoProvincia").append("='").append(getCodigoProvincia()).append("' ");
        buffer.append("nombreProvincia").append("='").append(getNombreProvincia()).append("' ");
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

        if (!(other instanceof Provincia)) return false;

        Provincia castOther = (Provincia) other;

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
    }

    public void fillPOJO() {
        // Initialize all properties with new
    }

    public Provincia createPOJO() {
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
