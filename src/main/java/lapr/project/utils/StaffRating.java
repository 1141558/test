/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import lapr.project.model.Application;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Review;
import lapr.project.model.User;

/**
 *
 * @author JM
 */
public class StaffRating {

    private ExhibitionCentre centre;

    public StaffRating(ExhibitionCentre centre) {
        this.centre = centre;
    }

    /**
     * Method to calculate the mean rating of an User (StaffMember)
     * @param user User to select the ratings
     * @return Mean of the ratings for the user (StaffMember)
     */
    public double meanRating(User user) {
        double rsum = 0.0;
        int rcount = 0;

        for (Event ev : centre.getEventRegister().getEventList()) {
            for (Application app : ev.getApplicationRegister().getApplicationList()) {
                for (Review rev : app.getListReview()) {
                    if (rev.getAssignedStaffMember().getStaff().equals(user)) {
                        double rmean = (rev.getStaffTopicKnowledge() + rev.getEventAdequacy() + rev.getInviteAdequacy() + rev.getAreaAdequacy() + rev.getRecommendation());
                        rmean = rmean / 5.0;
                        rsum = rsum + rmean;
                        rcount++;
                    }
                }
            }
        }
        return rsum / rcount;
    }

    /**
     * Method to calculate the mean deviation of an user ratings and an event
     * @param user User to consider the mean ratings
     * @param event Event to use the mean rating
     * @return Mean deviation
     */
    public double meanDeviation(User user, Event event) {
        double devSum = 0;
        int devCount = 0;

        double eventMean = eventMean(event);

        for (Event ev : centre.getEventRegister().getEventList()) {
            for (Application app : ev.getApplicationRegister().getApplicationList()) {
                for (Review rev : app.getListReview()) {
                    if (rev.getAssignedStaffMember().getStaff().equals(user)) {
                        double rmean = rev.getStaffTopicKnowledge() + rev.getEventAdequacy() + rev.getInviteAdequacy() + rev.getAreaAdequacy() + rev.getRecommendation();
                        rmean = rmean / 5;
                        devSum += Math.abs(rmean - eventMean);
                        devCount++;
                    }
                }

            }

        }
        return devSum / devCount;
    }

    /**
     * Method to return the mean rating of an event
     * @param event Event to calculate the mean
     * @return mean rating
     */
    public double eventMean(Event event) {
        double rsum = 0;
        int rcount = 0;

        for (Application app : event.getApplicationRegister().getApplicationList()) {
            for (Review rev : app.getListReview()) {
                double rmean = rev.getStaffTopicKnowledge() + rev.getEventAdequacy() + rev.getInviteAdequacy() + rev.getAreaAdequacy() + rev.getRecommendation();
                rmean = rmean / 5;
                rsum += rmean;
                rcount++;
            }
        }
        return rsum / rcount;
    }

}
