package com.udea.microserviceclient;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
interface ClientRepository extends JpaRepository<Client, Long> {

    @RestResource(path = "by-name")
    Collection<Client> findByClientName(@Param("rn") String rn);
}
