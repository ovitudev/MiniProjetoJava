package View;

public class MainMenu {

    public void menuLogin() {

        System.out.print("""
                1 - Sign up
                2 - Login
                0 - Exit
                """);
    }

    public void menuAdmin() {
        System.out.print("""
                1 - Registration Employee
                2 - Show Employees
                3 - Registration Visitors
                4 - Show Visitors
                0 - Exit
                """);
    }

    public void menuEmployee() {

        System.out.println("""
                1 - Registration Visitor
                2 - Registration Visitors
                3 - Show Visitors
                0 - Exit
                """);
    }

    public void menuVisitor() {
        System.out.print("""
                --------------- Welcome to Eagle Museum ---------------
                
                1 - About the museum
                2 - Rooms
                0 - Exit
                """);
    }
}
