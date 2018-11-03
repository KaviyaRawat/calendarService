package enitites;

import java.util.Date;

public class Event {
    private Date startTime;
    private Date endTime;
    private String title;

    private User owner;

    public Event(EventBaiscDetails basicDetails, User owner){
        this.startTime = basicDetails.getStartTime();
        this.endTime = basicDetails.getEndTime();
        this.title = basicDetails.getTitle();
        this.owner = owner;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString(){
        return  "Title: " + title + "\n" +
                "Event Start Time: " + startTime + "\n" +
                "Event End Time: " + endTime + "\n" +
                "Organizer: " + owner + "\n";
    }

}
