package LeaveApprovalSystem;

public class Manager implements LeaveApprover{
    LeaveApprover nextApprover;

    @Override
    public void setNext(LeaveApprover nextApprover) {
         this.nextApprover = nextApprover;
    }

    @Override
    public void approve(LeaveRequest request) {
        if(request.getLeaveDays()<=14){
            System.out.println("Leave granted by Manager");
        }
        else{
            nextApprover.approve(request);
        }
    }
}
