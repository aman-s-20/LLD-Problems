package LeaveApprovalSystem;

public class Main {

    public static void main(String[] args){
        LeaveApprover manager = new Manager();
        LeaveApprover HR = new HR();
        LeaveApprover Director = new Director();

        manager.setNext(HR);
        HR.setNext(Director);
        // Example leave requests
        LeaveRequest req1 = new LeaveRequest("Alice", 3);
        LeaveRequest req2 = new LeaveRequest("Bob", 8);
        LeaveRequest req3 = new LeaveRequest("Charlie", 15);
        LeaveRequest req4 = new LeaveRequest("David", 46);

        manager.approve(req1);
        manager.approve(req2);
        manager.approve(req3);
        manager.approve(req4);
    }

}
