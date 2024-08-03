package com.projectgraphql.projectgraphql.controller;

import com.projectgraphql.projectgraphql.Entity.Ticket;
import com.projectgraphql.projectgraphql.dto.TicketDto;
import com.projectgraphql.projectgraphql.service.TicketService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @QueryMapping
    public List<Ticket> getTickets() {
        return ticketService.getAllTodos();
    }

    @QueryMapping
    public List<Ticket> getTicketsPagination(@Argument(name = "page") int page,@Argument(name = "size") int size) {
        return ticketService.getTicketsPagination(page, size);
    }

    @QueryMapping
    public Ticket getTicket(@Argument(name = "id") long id) {
        return ticketService.getTicket(id);
    }

    @MutationMapping
    public Ticket createTicket(@Argument(name = "ticket") TicketDto ticketDto) {
        return ticketService.addTicket(ticketDto);
    }

    @MutationMapping
    public Ticket updateTicket(@Argument(name = "id") long id, @Argument(name = "ticket") TicketDto ticketDto) {
        return ticketService.updateTicket(id, ticketDto);
    }

    @MutationMapping
    public boolean deleteTicket(@Argument(name = "id") long id) {
        return ticketService.deleteTicket(id);
    }



}
