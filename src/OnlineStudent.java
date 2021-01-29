//****************************************************************************************
// CLASS: OnlineStudent (OnlineStudent.java)
//
// DESCRIPTION
// A direct subclass of the abstract class Student. It adds a new instance variable that
// is specific to online students, mTechFee.
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Spring 2021
// Project Number: 2
//
// AUTHORS
// Teodoro Salgado, tjsalgad, tsalgado96@gmail.com
// Isaac Pena, ipena5, ippenaisaac@gmail.com
// Stephen Elledge, saelledg, saelledg@asu.edu
// ****************************************************************************************

public class OnlineStudent extends Student {

    private boolean mTechFee;

    /**
     * Creates an OnlineStudent object and initializes the mId, mFirstName, and mLastName instance
     * variables by calling the superclass constructor
     */
    public OnlineStudent(String pId, String pFirstName, String pLastName){
        super(pId, pFirstName, pLastName);
    }

    /**
     * Overrides the abstract method in Student to calculate the tuition for an
     * OnlineStudent
     */
    @Override
    public void calcTuition(){
        // Declare double variable t = getCredits() × TuitionConstants.ONLINE_CREDIT_RATE
        double t = getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;

        if (getTechFee()){
            t += TuitionConstants.ONLINE_TECH_FEE;
        }
        setTuition(t);
    } // End calcTuition

    /**
     * Accessor method for mTechFee.
     */
    public boolean getTechFee(){
        return mTechFee;
    }

    /**
     * Mutator method for mTechFee.
     */
    public void setTechFee(boolean pTechFee){
        mTechFee = pTechFee;
    }
} // End OnlineStudent
