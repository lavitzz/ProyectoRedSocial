/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lavitz
 */
@Entity
@Table(name = "AMIGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amigo.findAll", query = "SELECT a FROM Amigo a"),
    @NamedQuery(name = "Amigo.findByIdAmigo", query = "SELECT a FROM Amigo a WHERE a.idAmigo = :idAmigo"),
    @NamedQuery(name = "Amigo.findByConfirmado", query = "SELECT a FROM Amigo a WHERE a.confirmado = :confirmado")})
public class Amigo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AMIGO")
    private BigDecimal idAmigo;
    @Column(name = "CONFIRMADO")
    private BigInteger confirmado;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Amigo() {
    }

    public Amigo(BigDecimal idAmigo) {
        this.idAmigo = idAmigo;
    }

    public BigDecimal getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(BigDecimal idAmigo) {
        this.idAmigo = idAmigo;
    }

    public BigInteger getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(BigInteger confirmado) {
        this.confirmado = confirmado;
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
        hash += (idAmigo != null ? idAmigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amigo)) {
            return false;
        }
        Amigo other = (Amigo) object;
        if ((this.idAmigo == null && other.idAmigo != null) || (this.idAmigo != null && !this.idAmigo.equals(other.idAmigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Amigo[ idAmigo=" + idAmigo + " ]";
    }
    
}
