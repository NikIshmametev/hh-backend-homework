package ru.hh.backend.Resource;

import ru.hh.backend.DAO.UserDao;
import org.springframework.stereotype.Controller;
import ru.hh.backend.Entity.User;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/user")
@Controller
public class UserResource {
    private final UserDao userDao;

    public UserResource(UserDao userDao) {
        this.userDao = userDao;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> get(@QueryParam("type") String type) {
        return userDao.getByType(type);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(User user) {
        userDao.save(user);
    }
}

