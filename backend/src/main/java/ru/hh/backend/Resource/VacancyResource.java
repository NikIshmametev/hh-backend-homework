package ru.hh.backend.Resource;

import org.springframework.stereotype.Controller;
import ru.hh.backend.DAO.VacancyDao;
import ru.hh.backend.Entity.Vacancy;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("api/vacancy")
@Controller
public class VacancyResource {
    private final VacancyDao vacancyDao;

    public VacancyResource(VacancyDao vacancyDao) {
        this.vacancyDao = vacancyDao;
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Optional<Vacancy> get(@QueryParam("id") Integer id) {
//        return vacancyDao.get(id);
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vacancy> getAll() {
        return vacancyDao.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Vacancy vacancy) {
        vacancyDao.save(vacancy);
    }

}
