package com.sistemi.informativi.sql;

public interface SqlScript {

    String sqlCourseInsert = "insert into course(title)values(?)";

    String sqlReviewInsert ="insert into review(location,course_id)values(?,?)";

    String sqlReviewsLocationByCourse ="select location from review,course where review.course_id=course.id and course.id=?";

    String sqlDeleteCourse = "delete from course where id=?";


}
