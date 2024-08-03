package com.projectgraphql.projectgraphql.repository;

import com.projectgraphql.projectgraphql.Entity.Ticket;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

}