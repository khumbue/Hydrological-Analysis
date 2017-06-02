package za.co.jobcreation.api.producer;

import javax.ejb.EJB;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@Startup
@ApplicationScoped
public class ResourceProducer {

    @EJB(lookup = "java:global/job-creation/JobCreationService!za.co.jobcreation.api.IJobCreationService")
    @Produces
    private za.co.jobcreation.api.IJobCreationService jobCreationService;
}
