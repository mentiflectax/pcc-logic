/**
 * This file is part of Project Control Center (PCC).
 * 
 * PCC (Project Control Center) project is intellectual property of 
 * Dmitri Anatol'evich Pisarenko.
 * 
 * Copyright 2010, 2011 Dmitri Anatol'evich Pisarenko
 * All rights reserved
 *
 **/

package at.silverstrike.pcc.impl.persistence;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import at.silverstrike.pcc.api.model.SchedulingObject;
import at.silverstrike.pcc.api.model.Task;
import at.silverstrike.pcc.api.model.ResourceAllocation;

/**
 * @author Dmitri Pisarenko
 * 
 */
class DefaultTask extends DefaultSchedulingObject implements
        Task {
    private Double bestCaseEffort;
    private Double worstCaseEffort;
    private List<ResourceAllocation> resourceAllocations;
    private Date averageEstimatedEndDateTime;
    private Date bestEstimatedEndDateTime;
    private Date worstEstimatedEndDateTime;
    private List<SchedulingObject> children;

    public DefaultTask() {
        super();
        this.children = new LinkedList<SchedulingObject>();
    }

    public Double getBestCaseEffort() {
        return bestCaseEffort;
    }

    public void setBestCaseEffort(final Double aBestCaseEffort) {
        this.bestCaseEffort = aBestCaseEffort;
    }

    public Double getWorstCaseEffort() {
        return worstCaseEffort;
    }

    public void setWorstCaseEffort(final Double aWorstCaseEffort) {
        this.worstCaseEffort = aWorstCaseEffort;
    }

    @Override
    public double getAverageCaseEffort() {
        if ((this.bestCaseEffort != null) && (this.worstCaseEffort == null)) {
            return this.bestCaseEffort;
        } else if ((this.bestCaseEffort == null)
                && (this.worstCaseEffort != null)) {
            return this.worstCaseEffort;
        } else if ((this.bestCaseEffort == null)
                && (this.worstCaseEffort == null)) {
            return 0.;
        } else {
            return (this.bestCaseEffort + this.worstCaseEffort) / 2;
        }
    }

    public List<ResourceAllocation> getResourceAllocations() {
        return resourceAllocations;
    }

    public void setResourceAllocations(
            final List<ResourceAllocation> aResourceAllocations) {
        this.resourceAllocations = aResourceAllocations;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public Date getAverageEstimatedEndDateTime() {
        return averageEstimatedEndDateTime;
    }

    public void setAverageEstimatedEndDateTime(
            final Date aAverageEstimatedEndDateTime) {
        this.averageEstimatedEndDateTime = aAverageEstimatedEndDateTime;
    }

    public Date getBestEstimatedEndDateTime() {
        return bestEstimatedEndDateTime;
    }

    public void
            setBestEstimatedEndDateTime(final Date aBestEstimatedEndDateTime) {
        this.bestEstimatedEndDateTime = aBestEstimatedEndDateTime;
    }

    public Date getWorstEstimatedEndDateTime() {
        return worstEstimatedEndDateTime;
    }

    public void setWorstEstimatedEndDateTime(
            final Date aWorstEstimatedEndDateTime) {
        this.worstEstimatedEndDateTime = aWorstEstimatedEndDateTime;
    }

    public List<SchedulingObject> getChildren() {
        return children;
    }

    public void setChildren(final List<SchedulingObject> aChildren) {
        this.children = aChildren;
    }
}
