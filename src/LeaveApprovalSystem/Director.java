package LeaveApprovalSystem;

public class Director implements LeaveApprover{
    LeaveApprover nextApprover;

    @Override
    public void setNext(LeaveApprover nextApprover) {
        this.nextApprover = nextApprover;
    }

    @Override
    public void approve(LeaveRequest request) {
        if(request.getLeaveDays()<=45){
            System.out.println("Leave granted by Director");
        }
        else{
            System.out.println("Leave request denied for " + request.getEmployeeName());
        }
    }
}
