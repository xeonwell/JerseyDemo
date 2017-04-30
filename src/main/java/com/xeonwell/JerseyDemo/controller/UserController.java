package com.xeonwell.JerseyDemo.controller;

/**
 * Created by xeonwell on 2017-04-24.
 */

import com.xeonwell.JerseyDemo.common.BaseApiController;
import com.xeonwell.JerseyDemo.common.exception.DataAccessException;
import com.xeonwell.JerseyDemo.model.BlResult;
import com.xeonwell.JerseyDemo.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.sql.PreparedStatement;

@Path("/users")
public class UserController extends BaseApiController {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error(ex);
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BlResult getUsersList() {
        User[] userList = {
                new User(111, "xeon", "well"),
                new User(222, "来个", "中文"),
        };
        return ok(userList);
    }

    @GET
    @Produces(MediaTypeUtf8Json)
    @Path("/{id}")
    public BlResult getUserById(@PathParam("id") int id) throws DataAccessException, SQLException {

        BlResult result = null;

        Connection conn;
        ResultSet rs;
        PreparedStatement pstmt;


        conn = DriverManager.getConnection("jdbc:mysql://localhost:13306/xw_test?user=replication&password=123456&serverTimezone=UTC&characterEncoding=utf8");

        pstmt = conn.prepareStatement("SELECT * FROM `name_test` WHERE Id=?");
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            User u = new User();
            u.id = rs.getInt("Id");
            u.firstName = rs.getString("FirstName");
            u.lastName = rs.getString("last_name");
            result = ok(u);

            logger.debug("get user successfully.");
        }

        rs.close();
        pstmt.close();
        conn.close();


        if (result != null) return result;
        throw new DataAccessException("user not found");
//        return result != null ? result : fail("can not get");
    }
}
