package LeaveApprovalSystem;

public class HR implements LeaveApprover{

    LeaveApprover nextApprover;
    @Override
    public void setNext(LeaveApprover nextApprover) {
        this.nextApprover = nextApprover;
    }

    @Override
    public void approve(LeaveRequest request) {
         if(request.getLeaveDays()<=28){
             System.out.println("Leave granted by HR");
         }
         else{
             nextApprover.approve(request);
         }
    }
}
