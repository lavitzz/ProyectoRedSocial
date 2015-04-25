/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NamedQuery(name = "Amigo.findByIdAmigo", query = "SELECT a FROM Amigo a WHERE a.amigoPK.idAmigo = :idAmigo"),
    @NamedQuery(name = "Amigo.findByIdUsuario", query = "SELECT a FROM Amigo a WHERE a.amigoPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "Amigo.findByConfirmado", query = "SELECT a FROM Amigo a WHERE a.confirmado = :confirmado")})
public class Amigo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AmigoPK amigoPK;
    @Column(name = "CONFIRMADO")
    private BigInteger confirmado;
    @JoinColumn(name = "ID_AMIGO", referencedColumnName = "ID_USUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario1;

    public Amigo() {
    }

    public Amigo(AmigoPK amigoPK) {
        this.amigoPK = amigoPK;
    }

    public Amigo(BigInteger idAmigo, BigInteger idUsuario) {
        this.amigoPK = new AmigoPK(idAmigo, idUsuario);
    }

    public AmigoPK getAmigoPK() {
        return amigoPK;
    }

    public void setAmigoPK(AmigoPK amigoPK) {
        this.amigoPK = amigoPK;
    }

    public BigInteger getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(BigInteger confirmado) {
        this.confirmado = confirmado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (amigoPK != null ? amigoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amigo)) {
            return false;
        }
        Amigo other = (Amigo) object;
        if ((this.amigoPK == null && other.amigoPK != null) || (this.amigoPK != null && !this.amigoPK.equals(other.amigoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Amigo[ amigoPK=" + amigoPK + " ]";
    }
    
}
