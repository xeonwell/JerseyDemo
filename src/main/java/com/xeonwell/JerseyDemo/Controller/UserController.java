package com.xeonwell.JerseyDemo.Controller;

/**
 * Created by xeonwell on 2017-04-24.
 */

import com.xeonwell.JerseyDemo.Common.BaseApiController;
import com.xeonwell.JerseyDemo.Model.BlResult;
import com.xeonwell.JerseyDemo.Model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.sql.PreparedStatement;

@Path("/users")
public class UserController extends BaseApiController {
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
    public BlResult getUserById(@PathParam("id") int id) {

        BlResult result = null;


        try {
            Connection conn = null;
            ResultSet rs = null;
            PreparedStatement pstmt = null;

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.6.110:3308/xw_test?user=replication&password=123456&serverTimezone=UTC&characterEncoding=utf8");

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

        } catch (Exception ex) {
            return fail(ex.getMessage());
        }

        return result != null ? result : fail("can not get");
    }
}
