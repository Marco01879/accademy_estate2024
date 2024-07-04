package com.sistemi.informativi.main;


import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dao.FacadeDAO;
import com.sistemi.informativi.dao.FacadeDAOImpl;
import com.sistemi.informativi.dto.CourseDTO;
import com.sistemi.informativi.dto.ReviewDTO;

import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        FacadeDAO facadeDAO = new FacadeDAOImpl();

        Connection con = facadeDAO.getConnection();

        /*
         * id rappresenta il valore della pk relativa al corso iserito sel db
         * tale valore dovrà...
         */

        int id = facadeDAO.addCourse(new CourseDTO("React"));

        facadeDAO.addReview(new ReviewDTO("Florence",id));
        facadeDAO.addReview(new ReviewDTO("Naples",id));

        facadeDAO.getReviewLocationByCourse(id).forEach(review-> System.out.println(review.getLocation()));

        facadeDAO.closeConnection();




    }
}