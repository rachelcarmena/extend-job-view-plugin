package org.jenkinsci.plugins.extend.job.view;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.Job;
import hudson.model.JobProperty;
import hudson.model.JobPropertyDescriptor;
import java.io.IOException;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

/**
 * Job property in order to show extended information on job view.
 *
 * @author Rachel
 */
public class ExtendJobViewProperty extends JobProperty<Job<?, ?>> 
{
    private boolean extendedInformation;

    @DataBoundConstructor
    public ExtendJobViewProperty(boolean extendedInformation) {
        this.extendedInformation = extendedInformation;
    }

    public boolean getExtendedInformation() {
        return extendedInformation;
    }
    
    //public void setExtendedInformation(boolean info) throws IOException {
    //    this.extendedInformation = info;
    //    owner.save();
    //}
    
    @Extension
    public static class DescriptorImpl extends JobPropertyDescriptor {

        public DescriptorImpl() {
            super(ExtendJobViewProperty.class);
            load();
        }

        @Override
        public String getDisplayName() {
            return "Ask for more information in job view";
        }

        @Override
        public boolean isApplicable(Class<? extends Job> jobType) {
            return AbstractProject.class.isAssignableFrom(jobType);
        }          
    }
} 
