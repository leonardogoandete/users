package br.com.ifrs.poa.users;

import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.Claims;

import java.util.Arrays;
import java.util.HashSet;

@Path("/users")
public class Users {

    @GET
    @Path("/jwt")
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String generate() {
        return Jwt.issuer("http://localhost:8080")
                .upn("leonardogoandete")
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .claim(Claims.full_name, "Leonardo Goandete")
                .innerSign()
                .encrypt();
    }
}
