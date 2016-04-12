package sv.kruk.domain;

import java.util.Date;


public class Commit {
    private Long id;
    private String description;
    private Date commitdate;
    private User userCommited;
    private Task task;
}
