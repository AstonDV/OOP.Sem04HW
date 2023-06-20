package Entities.Teacher;

import Abstracts.UsersGroupIterator;

import java.util.List;

public class TeachersGroupIterator extends UsersGroupIterator<TeachersGroup, Teacher> {

    public TeachersGroupIterator(TeachersGroup group) {
        super(group);
    }

    @Override
    protected List<Teacher> getGroup() {
        return super.group.getGroup();
    }

    @Override
    public boolean hasNext() {
        return index < getGroup().size();
    }

    @Override
    public Teacher next() {
        return getGroup().get(index++);
    }

    @Override
    public void remove() {
        getGroup().remove(--index);
    }
}