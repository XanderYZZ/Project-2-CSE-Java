/*************************************************************************************************
 * CLASS: OnCampusStudent (OnCampusStudent.java)
 *
 * DESCRIPTION
 * This is the OnCampusStudent class. This derives from the Student class.
 *
 * COURSE AND PROJECT INFORMATION
 * CSE205 Object Oriented Programming and Data Structures, Spring 2022
 * Project Number: Project #2
 *
 * AUTHOR: Xander Arnspiger, xarnspig, xarnspig@asu.edu, ASU ID: 1220789908 **
 ******************************************************************************************************/

public class OnCampusStudent extends Student {
    final public static int RESIDENT = 1;
    final public static int NON_RESIDENT = 2;
    
    private int mResident;
    private double mProgramFee;

    public OnCampusStudent(String pId, String pFirstName, String pLastName) {
        super(pId, pFirstName, pLastName);
    }

    @Override 
    public void calcTuition() {
        double t;

        if (getResidency() == RESIDENT) {
            t = TuitionConstants.ONCAMP_RES_BASE;
        } else {
            t = TuitionConstants.ONCAMP_NONRES_BASE;
        }

        t = t + getProgramFee();

        if (getCredits() > TuitionConstants.ONCAMP_MAX_CREDITS) {
            t += (getCredits() - TuitionConstants.ONCAMP_MAX_CREDITS) * TuitionConstants.ONCAMP_ADD_CREDITS;
        }

        setTuition(t);
    }

    // Get Methods (Accessor Methods)
    public int getResidency() {
        return this.mResident;
    }

    public double getProgramFee() {
        return this.mProgramFee;
    }

    // Setter Methods (Mutator Methods)
    public void setProgramFee(double fee) {
        this.mProgramFee = fee;
    }

    public void setResidency(int resident) {
        this.mResident = resident;
    }
}