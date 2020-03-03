package ru.hh.backend.Resource;

import org.springframework.stereotype.Controller;
import ru.hh.backend.DAO.ResumeDao;
import ru.hh.backend.Entity.Resume;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/resume")
@Controller
public class ResumeResource {

    private final ResumeDao resumeDao;

    public ResumeResource(ResumeDao resumeDao) { this.resumeDao = resumeDao; }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Resume> getAll() {
        return resumeDao.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Resume resume) {
        resumeDao.save(resume);
    }
}
