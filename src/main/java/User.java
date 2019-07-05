import java.sql.*;
import java.util.Scanner;
import com.DBConnection;
public class User
{

        int id;
        String name;
        String age;
    Scanner sc=new Scanner(System.in);

        public void add() {

            System.out.println("enter id");
            id = sc.nextInt();
            System.out.println("enter name");
            name = sc.next();
            System.out.println("enter age");
            age = sc.next();
            try {

                    Class.forName("com.mysql.jdbc.Driver");
                    try (Connection conn =
                                 DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata",
                                         "root", "new-password")) {


                       Statement st = conn.createStatement();
                        int a=st.executeUpdate("insert into userinfo values("+id+",'"+name+"','"+age+"')");

                        System.out.println("ajsjbdkjasnda");

                    }
                } catch (Exception e) {
                    System.err.println("Something went wrong!");
                    e.printStackTrace();
                }
                System.out.println("ajsjbdkjasnda");




        }

        public void update() {
            try {
                System.out.println("enter id which record you want to update");
                int id1=sc.nextInt();
                System.out.println("enter name  to update");
                String name1=sc.next();
                System.out.println("enter age to update");
                String age1=sc.next();
                Class.forName("com.mysql.jdbc.Driver");
                try (Connection conn =
                             DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata",
                                     "root", "new-password")) {



                    Statement st = conn.createStatement();

                    int i=st.executeUpdate("UPDATE userinfo SET  name='"+name1+"', age='"+age1+"' WHERE id="+id1+"");

                    System.out.println("ajsjbdkjasnda");

                }
            } catch (Exception e) {
                System.err.println("Something went wrong!");
                e.printStackTrace();
            }

        }



        public void delete() {
            System.out.println("enter id which record you want to delete");
            int id1=sc.nextInt();
            try {

                Class.forName("com.mysql.jdbc.Driver");
                try (Connection conn =
                             DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata",
                                     "root", "new-password")) {


                    Statement st = conn.createStatement();

                    int a=st.executeUpdate("DELETE FROM userinfo WHERE id="+id1+"");

                    System.out.println("ajsjbdkjasnda");

                }
            } catch (Exception e) {
                System.err.println("Something went wrong!");
                e.printStackTrace();
            }
        }

        public void read() {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                try (Connection conn =
                             DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata",
                                     "root", "new-password")) {


                    Statement st = conn.createStatement();
                   ResultSet rs=st.executeQuery("select * from userinfo");

                    while(rs.next())
                        System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                }
            } catch (Exception e) {
                System.err.println("Something went wrong!");
                e.printStackTrace();
            }

        }


        public static void main(String s[])
        {

           // DBConnection db=new DBConnection();
            System.out.println("Hello,Enter your choice");
            Scanner sc = new Scanner(System.in);
            User m = new User();
            int ch=0;
            int i=0;
            do{
                System.out.println("1.Add \n2.read\n3.update \n4.delete \n5.exit ");
                ch=sc.nextInt();


                switch (ch)
                {


                    case 1:
                        m.add();
                        break;
                    case 2:
                        m.read();
                        break;

                    case 3:
                        m.update();
                        break;

                    case 4:
                        m.delete();
                        break;
                    case 5:
                        i++;
                        break;


                }
            } while(i==0);
        }
    }


