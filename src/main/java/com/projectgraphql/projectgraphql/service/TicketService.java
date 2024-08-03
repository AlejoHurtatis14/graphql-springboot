package com.projectgraphql.projectgraphql.service;

import com.projectgraphql.projectgraphql.Entity.Ticket;
import com.projectgraphql.projectgraphql.converter.TicketConverter;
import com.projectgraphql.projectgraphql.dto.TicketDto;
import com.projectgraphql.projectgraphql.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final TicketConverter ticketConverter;

    public Ticket addTicket(TicketDto todoDto) {
        Ticket ticket = ticketConverter.convertTicket(todoDto, 0, new Ticket());
        ticketRepository.save(ticket);
        return ticket;
    }

    public List<Ticket> getAllTodos() {
        return ticketRepository.findAll();
    }

    public Ticket updateTicket(long id, TicketDto todoDto) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        if (optionalTicket.isPresent()) {
            Ticket ticket = ticketConverter.convertTicket(todoDto, id, optionalTicket.get());
            ticketRepository.save(ticket);
            return ticket;
        }
        return null;
    }

    public boolean deleteTicket(long id) {
        ticketRepository.deleteById(id);
        return true;
    }

    public List<Ticket> getTicketsPagination(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Ticket> ticketPage = ticketRepository.findAll(pageRequest);
        return ticketPage.getContent();
    }

    public Ticket getTicket(long id) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        return optionalTicket.orElse(null);
    }

}
