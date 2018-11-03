package enitites;

import java.util.*;

public class User {
    private int id;
    private String name;
    private TreeSet<Event> acceptedEvents = new TreeSet<>(new EventComparator());
    private TreeSet<Event> declinedEvents = new TreeSet<>(new EventComparator());
    private TreeSet<Event> neutralEvents = new TreeSet<>(new EventComparator());
    private HashMap<String, TreeSet<Event>> map = new HashMap<>();

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        map.put("AcceptedEvents", acceptedEvents);
        map.put("DeclinedEvents", declinedEvents);
        map.put("NeutralEvents", neutralEvents);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  TreeSet<Event> getAcceptedEvents() {
        return acceptedEvents;
    }

    public void addAcceptedEvents(Event acceptedEvent) {
        this.acceptedEvents.add(acceptedEvent);
    }

    public TreeSet<Event> getDeclinedEvents() {
        return declinedEvents;
    }

    public void addDeclinedEvents(Event declinedEvent) {
        this.declinedEvents.add(declinedEvent);
    }

    public TreeSet<Event> getNeutralEvents() {
        return neutralEvents;
    }

    public void addNeutralEvents(Event neutralEvent) {
        neutralEvents.add(neutralEvent);
    }

    public void createEvent(EventBaiscDetails details){
        Event event = new Event(details, this);

        addAcceptedEvents(event);

    }

    public void createEvent(EventBaiscDetails details, String location, List<Integer> userIds){
        List<User> users = new ArrayList<>();

        if(userIds!=null){
            for(int i=0; i<userIds.size(); i++){
                User user = UserDirectory.getUser(userIds.get(i));
                users.add(user);
            }
        }
        Event event = new MeetingEvent(location, users, details, this);
        addAcceptedEvents(event);
        for(int i=0; i<users.size(); i++){
            users.get(i).addNeutralEvents(event);
        }

    }

    public void reviewEvent(){
        Iterator<Event> iterator = neutralEvents.iterator();
        List<Event> toBeRemoved = new ArrayList<>();
        while(iterator.hasNext()){
            Event event = iterator.next();
            System.out.println(event);
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            if(input.equals("A")){
                acceptedEvents.add(event);
                iterator.remove();
            }
            else if(input.equals("D")){
                declinedEvents.add(event);
                iterator.remove();
            }
        }
        toBeRemoved.forEach( event -> {
            neutralEvents.remove(event);
        });
    }

    public void acceptEvent(Event event){
        acceptedEvents.add(event);
    }

    public void declineEvent(Event event){
        declinedEvents.add(event);
    }

    public HashMap<String, TreeSet<Event>> getEvents(){
        map.forEach((key, value) -> {
            System.out.println(key + " ");
            value.forEach(event->{
                System.out.println(event);
            });
        });

        return map;
    }

    @Override
    public String toString(){
        return "id: " + this.id + " name: " + this.name;
    }

}
