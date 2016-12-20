package ru.pflb.data;

import org.apache.commons.lang3.RandomStringUtils;

public class Person {

    private String lastName;
    private String firstName;
    private String patronymic;
    private String position;
    private String project;
    private String expire;
    private String future;
    private String nickname;
    private boolean fired;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getFuture() {
        return future;
    }

    public void setFuture(String future) {
        this.future = future;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }

    public static Person getNewRandomPerson(){
        Person person = new Person();
        person.setLastName(RandomStringUtils.randomAlphabetic(10));
        person.setFirstName(RandomStringUtils.randomAlphabetic(10));
        person.setPatronymic(RandomStringUtils.randomAlphabetic(10));
        person.setPosition("");
        person.setProject(RandomStringUtils.randomAlphabetic(10));
        person.setExpire(RandomStringUtils.randomAlphabetic(10));
        person.setFuture(RandomStringUtils.randomAlphabetic(10));
        person.setNickname(RandomStringUtils.randomAlphabetic(10));
        person.setFired(false);
        return person;
    }

    public boolean equals(Person person) {
        if (this.lastName.equals(person.lastName) && this.firstName.equals(person.firstName)) return true;
        else return false;
    }
}
