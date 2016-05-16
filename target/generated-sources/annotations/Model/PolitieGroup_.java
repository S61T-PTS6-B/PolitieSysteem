package Model;

import Model.PolitieAccount;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-16T10:36:35")
@StaticMetamodel(PolitieGroup.class)
public class PolitieGroup_ { 

    public static volatile SingularAttribute<PolitieGroup, String> groupname;
    public static volatile ListAttribute<PolitieGroup, PolitieAccount> users;

}