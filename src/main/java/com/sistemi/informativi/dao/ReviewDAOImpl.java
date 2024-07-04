package com.sistemi.informativi.dao;

import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dto.ReviewDTO;
import com.sistemi.informativi.sql.SqlScript;
import com.sistemi.informativi.vo.ReviewVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewDAOImpl implements ReviewDAO {
    @Override
    public void addReview(ReviewDTO reviewDTO) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlReviewInsert);
        ps.setString(1,reviewDTO.getLocation());
        ps.setInt(2,reviewDTO.getCourseId());

        ps.executeUpdate();
    }

    @Override
    public ArrayList<ReviewVO> getReviewLocationByCourse(int courseId) throws SQLException, ClassNotFoundException {

        ArrayList<ReviewVO> reviews = new ArrayList<>();

        ReviewVO reviewVO = null;

        //"select location from review,course where review.course_id=course.id and course.id=?"; questo ci arriva in input su questo metodo
        PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlReviewsLocationByCourse);

        ps.setInt(1,courseId);


        ResultSet rs = ps.executeQuery();

        while (rs.next()){

            reviewVO = new ReviewVO(rs.getString("location"));

            reviews.add(reviewVO);
        }
        return reviews;
    }

}
