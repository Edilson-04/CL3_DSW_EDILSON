package com.edu.cibertec.CL3DSWIIGALINDO.repository;

import com.edu.cibertec.CL3DSWIIGALINDO.model.bd.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Usuario findByNomusuario(String nomusuario);

}
