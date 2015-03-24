/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lavitz
 */
@Entity
@Table(name = "GRUPOUSUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupousuarios.findAll", query = "SELECT g FROM Grupousuarios g"),
    @NamedQuery(name = "Grupousuarios.findByIdGrupo", query = "SELECT g FROM Grupousuarios g WHERE g.idGrupo = :idGrupo")})
public class Grupousuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_GRUPO")
    private BigDecimal idGrupo;
    @JoinColumn(name = "ID_GRUPO", referencedColumnName = "ID_GRUPO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Grupo grupo;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;

    public Grupousuarios() {
    }

    public Grupousuarios(BigDecimal idGrupo) {
        this.idGrupo = idGrupo;
    }

    public BigDecimal getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(BigDecimal idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupousuarios)) {
            return false;
        }
        Grupousuarios other = (Grupousuarios) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Grupousuarios[ idGrupo=" + idGrupo + " ]";
    }
    
}
