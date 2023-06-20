package Abstracts;

import Interfaces.UserInterface;

import java.util.Objects;

public abstract class User implements UserInterface, Comparable<User> {

    protected static long nextUUID;

    protected long UUID;
    protected String firstName;
    protected String lastName;

    public User(String firstName, String lastName) {
        setUUID(nextUUID++);
        setFirstName(firstName);
        setLastName(lastName);
    }

    protected abstract void setUUID(long UUID);

    protected abstract void setFirstName(String firstName);

    protected abstract void setLastName(String lastName);

    @Override
    public int compareTo(User thatUser) {
        int compareResult = this.getLastName().compareTo(thatUser.getLastName());
        if (compareResult == 0) {
            compareResult = this.getFirstName().compareTo(thatUser.getFirstName());
            if (compareResult == 0)
                compareResult = this.getUUID().compareTo(thatUser.getUUID());
        }
        return compareResult;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof User thatUser)) return false;
        return this.getUUID().equals(thatUser.getUUID())
                && Objects.equals(this.getFirstName(), thatUser.getFirstName())
                && Objects.equals(this.getLastName(), thatUser.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUUID(), getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return "User{" +
                "UUID=" + this.getUUID() +
                ", lastName='" + this.getLastName() + '\'' +
                ", firstName='" + this.getFirstName() + '\'' +
                '}';
    }
}