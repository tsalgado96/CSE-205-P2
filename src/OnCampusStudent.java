//****************************************************************************************
// CLASS: OnCampusStudent (OnCampusStudent.java)
//
// DESCRIPTION
// A direct subclass of the abstract class Student. It declares two public int constants
// RESIDENT which is 1 and NON_RESIDENT which is 2. It adds new instance variables that are
// specific to on-campus students, mResident and mProgramFee.
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

public class OnCampusStudent extends Student {

    public static int RESIDENT = 1;
    public static int NON_RESIDENT = 2;
    private int mResident;
    private double mProgramFee;

    /**
     * Creates an OnCampusStudent object and initializes the mId, mFirstName, and mLastName instance
     * variables by calling the superclass constructor
     */
    public OnCampusStudent(String pId, String pFirstName, String pLastName){
        super(pId, pFirstName, pLastName);
    }

    /**
     * Overrides the abstract method in Student to calculate the tuition for an
     * OnCampusStudent
     */
    @Override
    public void calcTuition(){
        double t;
        if (getResidency() == 1){
            t = TuitionConstants.ONCAMP_RES_BASE;
        }
        else {
            t = TuitionConstants.ONCAMP_NONRES_BASE;
        }

        t += getProgramFee();

        if (getCredits() > TuitionConstants.ONCAMP_MAX_CREDITS){
            t += (getCredits() - TuitionConstants.ONCAMP_MAX_CREDITS) * TuitionConstants.ONCAMP_ADD_CREDITS;
        }
        setTuition(t);
    } // End calcTuition()

    /**
     * Accessor method for mProgramFee.
     */
    public double getProgramFee(){
        return mProgramFee;
    }

    /**
     * Accessor method for mResident.
     */
    public int getResidency(){
        return mResident;
    }

    /**
     * Mutator method for mProgramFee.
     */
    public void setProgramFee(double pProgramFee){
        mProgramFee = pProgramFee;
    }

    /**
     * Mutator method for mResident.
     */
    public void setResidency(int pResident){
        mResident = pResident;
    }

} // End OnCampusStudent
