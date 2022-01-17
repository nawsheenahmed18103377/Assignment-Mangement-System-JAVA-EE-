package edu.mgmt;

import edu.mgmt.dao.AssignmentDao;
import edu.mgmt.dao.SubmitedAssignmentDao;
import edu.mgmt.dao.UserDao;
import edu.mgmt.entities.Assignment;
import edu.mgmt.entities.SubmitedAssignment;
import edu.mgmt.helper.ConnectionProvider;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
//        AssignmentDao assignmentDao = new AssignmentDao(ConnectionProvider.getConnection());
//        ArrayList<Assignment> assignments = assignmentDao.showAllAssignment();
//        for (Assignment a: assignments){
//            System.out.println(a);
//        }




//    SubmitedAssignmentDao subm = new SubmitedAssignmentDao(ConnectionProvider.getConnection());
//    ArrayList<SubmitedAssignment> submitedAssignmentByUserId = subm.getSubmitedAssignmentByUserId(4);
//
//
//        for (SubmitedAssignment s: submitedAssignmentByUserId){
//            System.out.println(s);
//        }

//        SubmitedAssignment sbuAsById = subm.getSbuAsById(23);
//        System.out.println(sbuAsById);


        UserDao u= new UserDao(ConnectionProvider.getConnection());

        System.out.println(u.getNumberOfStudents());

    }

}
