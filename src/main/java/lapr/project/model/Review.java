/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Objects;

/**
 *
 * @author MariaJoão
 */
public class Review {
    private String text;
    private int staffTopicKnowledge;
    private int eventAdequacy;
    private int inviteAdequacy;
    private int recommendation;
    private Decision decision;
    private StaffMember assignedStaffMember;
    
    public Review(String text, int staffTopicKnowledge, int eventAdequacy, int inviteAdequacy, int recommendation, Decision decision, StaffMember assignedStaffMember) {
        this.text = text;
        this.staffTopicKnowledge = staffTopicKnowledge;
        this.eventAdequacy = eventAdequacy;
        this.inviteAdequacy = inviteAdequacy;
        this.recommendation = recommendation;
        this.decision = decision;
        this.assignedStaffMember = assignedStaffMember;
    }

    public Review() {
        this.assignedStaffMember= new StaffMember();
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the staffTopicKnowledge
     */
    public int getStaffTopicKnowledge() {
        return staffTopicKnowledge;
    }

    /**
     * @param staffTopicKnowledge the staffTopicKnowledge to set
     */
    public void setStaffTopicKnowledge(int staffTopicKnowledge) {
        this.staffTopicKnowledge = staffTopicKnowledge;
    }

    /**
     * @return the eventAdequacy
     */
    public int getEventAdequacy() {
        return eventAdequacy;
    }

    /**
     * @param eventAdequacy the eventAdequacy to set
     */
    public void setEventAdequacy(int eventAdequacy) {
        this.eventAdequacy = eventAdequacy;
    }

    /**
     * @return the inviteAdequacy
     */
    public int getInviteAdequacy() {
        return inviteAdequacy;
    }

    /**
     * @param inviteAdequacy the inviteAdequacy to set
     */
    public void setInviteAdequacy(int inviteAdequacy) {
        this.inviteAdequacy = inviteAdequacy;
    }

    /**
     * @return the recommendation
     */
    public int getRecommendation() {
        return recommendation;
    }

    /**
     * @param recommendation the recommendation to set
     */
    public void setRecommendation(int recommendation) {
        this.recommendation = recommendation;
    }

    /**
     * @return the decision
     */
    public Decision getDecision() {
        return decision;
    }

    /**
     * @param decision the decision to set
     */
    public void setDecision(Decision decision) {
        this.decision = decision;
    }

    /**
     * @return the assignedStaffMember
     */
    public StaffMember getAssignedStaffMember() {
        return assignedStaffMember;
    }

    /**
     * @param assignedStaffMember the assignedStaffMember to set
     */
    public void setAssignedStaffMember(StaffMember assignedStaffMember) {
        this.assignedStaffMember = assignedStaffMember;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (!(o instanceof Review)) {
            return false;
        }

        Review that = (Review) o;
        
        if (!this.assignedStaffMember.equals(that.assignedStaffMember)) {
            return false;
        }
        
        if(this.eventAdequacy!=that.eventAdequacy){
            return false;
        }
        if(this.inviteAdequacy!=that.inviteAdequacy){
            return false;
        }
        if(this.recommendation!=that.recommendation){
            return false;
        }
        if(this.staffTopicKnowledge!=that.staffTopicKnowledge){
            return false;
        } 
        /*
        if(this.text.equals(that.text)){
            return false;
        }
        */
        return this.decision.equals(that.decision);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.text);
        hash = 23 * hash + this.staffTopicKnowledge;
        hash = 23 * hash + this.eventAdequacy;
        hash = 23 * hash + this.inviteAdequacy;
        hash = 23 * hash + this.recommendation;
        hash = 23 * hash + Objects.hashCode(this.decision);
        hash = 23 * hash + Objects.hashCode(this.assignedStaffMember);
        return hash;
    }
}
