package za.co.jobcreation.ejb.impl.util;

import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.hibernate.envers.RevisionListener;
import za.co.jobcreation.ejb.model.RevisionEntity;

/**
 *
 * @author khumbu
 */
public class AuditListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {

        RevisionEntity revEntity = (RevisionEntity) revisionEntity;

        try {
            InitialContext ic = new InitialContext();
            SessionContext sessionContext = (SessionContext) ic.lookup("java:comp/EJBContext");
            revEntity.setUsername(sessionContext.getCallerPrincipal().getName());
        } catch (NamingException ne) {
        }

    }

}
