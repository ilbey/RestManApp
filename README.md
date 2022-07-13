# RestManApp

**RestManApp_1**

This assignment is about creating a small Java application for a restaurant to manage  the staff, customer, bookings and order of a customer. In particular, it aims to maintain information about the customers, staff working at the restaurant, customers' bookings, and their orders.

**RestManApp_2**

This assignment is about creating a small Java application for a restaurant to manage 
the staff, customer, bookings and order of a customer. In particular, it aims to maintain 
information about the customers, staff working at the restaurant, customers' bookings, 
and their orders. In overall, the idea is similar to the previous assignment but the class 
diagram has been significantly changed.

**RestManApp_3**

In this assignment, you need to create a graphical user interface to this application. In this interface you will need to make sure that all the methods given in the RestManApp class has a graphical user interface interaction. You need to choose appropriate Swing components to implement the user interface. Make sure that you used at least the following Swing components: JFrame, JButton, JLabel, JMenu, JMenuItem, JFileChooser, JPanel, JTextArea, JTextField, JCombobox, JScrollPane, JTable. The overall requirements can be summarised as follows:
  • When the application starts, you will need to ensure that you show the relevant options to the user – all the tasks they can complete with this application. 
  • You need to make sure that you have used all the relevant components for entry.
  
In this assignment now, you will need to use I/O classes you learnt in the class to store your data in binary files. In this assignment, you do not need this test class but whenever the user enters data via your user interface, you will need to store them in a binary file. When the user starts the application again, then your application will need to read the data from these external files.

**RestManApp_4**

In this assignment, you need to use the DataStorage class to connect to an external database and store your customer details. You need to store at least three customer with a booking. For this part of the assignment, you need to use Mysql database. Attached to this assignment, you can find an SQL file which can be used to initialize the database.

When the user wants to close the application, besides storing the data to a backend database, you need to also serialize your customer objects into an external file. This will be used to check if somebody is trying to attack your Customer data while the application is not running. You will do this as follows: when user closes the application, you will make your Customer objects persistent to a file, generate an MD5 for that file and write it into another external file. When the application is loaded again, you will read regenerate the MD5 for the serialized objects in your external file and check if it is the same with the MD5 that you stored when the application was closed. If they are the same, that means the serialized objects are not modified, if they are not then you will need to warn the user that the data has been updated. 
