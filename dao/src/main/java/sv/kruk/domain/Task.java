package sv.kruk.domain;

import java.util.Date;


public class Task {
    private Long id;
    private String title;
    private String description;
    private Commit commit;
    private Date createDate;
    private Date closedAfterDate;
    private Task parentTack;
    private Status status;
    private User createTaskUser;
    private User workUser;
    private Group group;
    private boolean haveChildren;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Task() {

    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getClosedAfterDate() {
        return closedAfterDate;
    }

    public void setClosedAfterDate(Date closedAfterDate) {
        this.closedAfterDate = closedAfterDate;
    }

    public Task getParentTack() {
        return parentTack;
    }

    public void setParentTack(Task parentTack) {
        this.parentTack = parentTack;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getCreateTaskUser() {
        return createTaskUser;
    }

    public void setCreateTaskUser(User createTaskUser) {
        this.createTaskUser = createTaskUser;
    }

    public User getWorkUser() {
        return workUser;
    }

    public void setWorkUser(User workUser) {
        this.workUser = workUser;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isHaveChildren() {
        return haveChildren;
    }

    public void setHaveChildren(boolean haveChildren) {
        this.haveChildren = haveChildren;
    }
}
