package com.jeev.assignments.members;


public class StudentMember extends Member{
  
    /**
     * Parameterized constructor to initialize a Student member with name.
     *
     * @param name the name of the member
     * 
     */
    public StudentMember(String name) {
        super(name);
        
    }

    @Override
    public int getMaxBooksIssued() {
        // Student gets 3 extra books than normal Member
        return super.getMaxBooksIssued() + 3;
    }
    
}
