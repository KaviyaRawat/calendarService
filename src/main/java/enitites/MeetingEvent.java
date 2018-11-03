package enitites;

import java.util.Date;
import java.util.List;

public class MeetingEvent extends Event{

    private String location;

    public MeetingEvent(String location, List<User> userList, EventBaiscDetails eventDetails, User owner){
        super(eventDetails, owner);
        this.location = location;
        this.userList = userList;

    }

    private List<User> userList;

    private List<User> acceptedUsers;
    private List<User> declinedUsers;


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getEventDetails(){
        String eventDetails =
                super.toString() +
                "location: " + location + "\n" +
                "Attendees (All):" + userList;

        return eventDetails;
    }

}
