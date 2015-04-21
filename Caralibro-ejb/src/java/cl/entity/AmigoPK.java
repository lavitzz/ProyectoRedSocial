/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lavitz
 */
@Embeddable
public class AmigoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AMIGO")
    private BigInteger idAmigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private BigInteger idUsuario;

    public AmigoPK() {
    }

    public AmigoPK(BigInteger idAmigo, BigInteger idUsuario) {
        this.idAmigo = idAmigo;
        this.idUsuario = idUsuario;
    }

    public BigInteger getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(BigInteger idAmigo) {
        this.idAmigo = idAmigo;
    }

    public BigInteger getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigInteger idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAmigo != null ? idAmigo.hashCode() : 0);
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmigoPK)) {
            return false;
        }
        AmigoPK other = (AmigoPK) object;
        if ((this.idAmigo == null && other.idAmigo != null) || (this.idAmigo != null && !this.idAmigo.equals(other.idAmigo))) {
            return false;
        }
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.AmigoPK[ idAmigo=" + idAmigo + ", idUsuario=" + idUsuario + " ]";
    }
    
}
