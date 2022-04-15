/*************************************************************************************************
 * CLASS: OnlineStudent (OnlineStudent.java)
 *
 * DESCRIPTION
 * This is the OnlineStudent class. This derives from the Student class.
 *
 * COURSE AND PROJECT INFORMATION
 * CSE205 Object Oriented Programming and Data Structures, Spring 2022
 * Project Number: Project #2
 *
 * AUTHOR: Xander Arnspiger, xarnspig, xarnspig@asu.edu, ASU ID: 1220789908 **
 ******************************************************************************************************/

public class OnlineStudent extends Student {
    private boolean mTechFee;

    public OnlineStudent(String pId, String pFirstName, String pLastName) {
        super(pId, pFirstName, pLastName);
    }

    @Override
    public void calcTuition() {
        double t = getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;
        if (getTechFee() == true) {
            t += TuitionConstants.ONLINE_TECH_FEE;
        }

        setTuition(t);
    }

    public boolean getTechFee() {
        return this.mTechFee;
    }

    public void setTechFee(boolean fee) {
        this.mTechFee = fee;
    }
}