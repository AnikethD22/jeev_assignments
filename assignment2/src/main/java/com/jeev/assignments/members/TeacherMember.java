package com.jeev.assignments.members;

public class TeacherMember extends Member {

    /**
     * Parameterized constructor to initialize a Teacher member with name.
     *
     * @param name the name of the member
     * 
     */
    public TeacherMember(String name) {
        super(name);
        
    }

    @Override
    public int getMaxBooksIssued() {
        // Teacher gets 5 extra books than normal Member
        return super.getMaxBooksIssued() + 5;
    }
    
}
