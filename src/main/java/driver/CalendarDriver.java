package driver;

import enitites.EventBaiscDetails;
import enitites.User;
import enitites.UserDirectory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CalendarDriver {


    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while(line!=null){


            if(line.startsWith("create user")){
                String[] strs = line.split(" ");
                line = null;
                UserDirectory.addUser(new User(Integer.valueOf(strs[2]), strs[3]));
            }
            else if(line.startsWith("create event")){
                String[] strs = line.split(" ");
                line = null;
                // 04-05-2018 00:00:00
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                try {
                    if(UserDirectory.getUser(Integer.valueOf(strs[2]))!=null) {

                        User eventCreator = UserDirectory.getUser(Integer.valueOf(strs[2]));

                        EventBaiscDetails eventBaiscDetails = createBasicDetails(strs, sdf);
                        line = in.nextLine();

                        if(line!=null && line.startsWith("location")){
                            strs = line.split(" ");
                            line = null;
                            String location = strs[1];
                            line = in.nextLine();
                            if(line!=null && line.startsWith("users")){
                                strs = line.split(" ");
                                line = null;
                                createMeetingEvent(strs, eventCreator, eventBaiscDetails, location);
                            }
                        }
                        else {
                            eventCreator.createEvent(eventBaiscDetails);
                        }
                    }
                    else{
                        System.out.println("User does not exists");
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            else if(line.startsWith("review event")){
                String[] strs = line.split(" ");
                line = null;
                User eventCreator = UserDirectory.getUser(Integer.valueOf(strs[2]));
                eventCreator.reviewEvent();
            }
            else if(line.startsWith("show calendar")){
                String[] strs = line.split(" ");
                line = null;
                User eventCreator = UserDirectory.getUser(Integer.valueOf(strs[2]));
                eventCreator.getEvents();
            }


            if(line == null || line.equals("")) {
                line = in.nextLine();
            }


        }




    }

    private static void createMeetingEvent(String[] strs, User eventCreator, EventBaiscDetails eventBaiscDetails, String location) {
        List<Integer> userIds = new ArrayList<>();

        for(int i =1; i<strs.length; i++){
            userIds.add(Integer.valueOf(strs[i]));
        }
        eventCreator.createEvent(eventBaiscDetails, location, userIds);
    }

    private static EventBaiscDetails createBasicDetails(String[] strs, SimpleDateFormat sdf) throws ParseException {
        String title = strs[3];
        Date startDate = sdf.parse(strs[4] + " " + strs[5]);
        Date endDate = sdf.parse(strs[6] + " " + strs[7]);
        System.out.println(startDate);
        return new EventBaiscDetails(startDate, endDate, title, UserDirectory.getUser(Integer.valueOf(strs[2])));
    }


}
