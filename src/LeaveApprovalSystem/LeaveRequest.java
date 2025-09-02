package LeaveApprovalSystem;

public class LeaveRequest {
    private final String employeeName;
    private final int leaveDays;


    public LeaveRequest(String employeeName, int leaveDays) {
        this.employeeName = employeeName;
        this.leaveDays = leaveDays;
    }

    String getEmployeeName(){
        return employeeName;
    }
    int getLeaveDays(){
        return leaveDays;
    }
}
