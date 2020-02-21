package pe.financieraoh.apiseguro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.financieraoh.apiseguro.domain.Persona;

public interface PersonaRepository  extends JpaRepository<Persona, String>{

}
