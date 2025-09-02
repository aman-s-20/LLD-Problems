package LeaveApprovalSystem;

public interface LeaveApprover {
    void setNext(LeaveApprover nextApprover);
    void approve(LeaveRequest request);
}
