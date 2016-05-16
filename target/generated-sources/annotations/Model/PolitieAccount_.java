package Model;

import Model.PolitieGroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-16T10:36:35")
@StaticMetamodel(PolitieAccount.class)
public class PolitieAccount_ { 

    public static volatile SingularAttribute<PolitieAccount, String> passwoord;
    public static volatile SingularAttribute<PolitieAccount, String> rechten;
    public static volatile ListAttribute<PolitieAccount, PolitieGroup> groups;
    public static volatile SingularAttribute<PolitieAccount, String> username;

}