package enitites;

import java.util.Date;

public class EventBaiscDetails {


    private Date startTime;
    private Date endTime;
    private String title;
    private User owner;

    public EventBaiscDetails(Date startTime, Date endTime, String title, User owner) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return  "Title: " + title + "\n" +
                "Event Start Time: " + startTime + "\n" +
                "Event End Time: " + endTime + "\n" +
                "Organizer: " + owner + "\n";
    }


}
