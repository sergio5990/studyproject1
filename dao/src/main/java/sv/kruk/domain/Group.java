package sv.kruk.domain;


import java.util.List;


public class Group {
    private Long id;
    private String title;
    private String description;
    private User userCreateGroup;
    private List<Task> tasks;
    private List<User> users;
}
