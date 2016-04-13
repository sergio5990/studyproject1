package sv.kruk.domain;


import java.util.List;

/**
 * group where user have collective tasks
 */
public class Group {
    private Long id;
    private String title;
    private String description;
    private User userCreateGroup;
    private List<Task> tasks;
    private List<User> users;
}
