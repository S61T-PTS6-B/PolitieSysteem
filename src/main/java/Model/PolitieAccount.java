/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author casva
 */
@Entity
public class PolitieAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String username;
    
    @Column
    private String passwoord;
    
    @Column
    private String rechten;
    
    @ManyToMany
    @JoinTable(name="usergroup",
    joinColumns = @JoinColumn(name = "username", 
                              referencedColumnName = "username"), 
    inverseJoinColumns = @JoinColumn(name = "groupname", 
                              referencedColumnName = "groupname"))
    private List<PolitieGroup> groups;

    public String getPasswoord() {
        return passwoord;
    }

    public void setPasswoord(String passwoord) {
        this.passwoord = passwoord;
    }

    public String getRechten() {
        return rechten;
    }

    public void setRechten(String rechten) {
        this.rechten = rechten;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PolitieAccount)) {
            return false;
        }
        PolitieAccount other = (PolitieAccount) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.politiesysteem.Beans.PolitieAccount[ id=" + username + " ]";
    }
    
}
