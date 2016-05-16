/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author casva
 */
@Entity
public class PolitieGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String groupname;

    @ManyToMany
    private List<PolitieAccount> users;
    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String id) {
        this.groupname = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupname != null ? groupname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PolitieGroup)) {
            return false;
        }
        PolitieGroup other = (PolitieGroup) object;
        if ((this.groupname == null && other.groupname != null) || (this.groupname != null && !this.groupname.equals(other.groupname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.PolitieGroup[ id=" + groupname + " ]";
    }
    
}
