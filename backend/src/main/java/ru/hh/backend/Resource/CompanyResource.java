package ru.hh.backend.Resource;

import org.springframework.stereotype.Controller;
import ru.hh.backend.DAO.CompanyDao;
import ru.hh.backend.Entity.Company;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/company")
@Controller
public class CompanyResource {
    private final CompanyDao companyDao;

    public CompanyResource(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Optional<Company> get(@QueryParam("id") Integer id) {
//        return companyDao.get(id);
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Company> getAll() {
        return companyDao.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Company company) {
        companyDao.save(company);
    }
}
