package com.projectgraphql.projectgraphql.converter;

import com.projectgraphql.projectgraphql.Entity.Ticket;
import com.projectgraphql.projectgraphql.dto.TicketDto;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TicketConverter  {

    public @NonNull Ticket convertTicket(TicketDto source, long id, Ticket ticket) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ticket.setUser(source.getUser());
        ticket.setStatus(source.getStatus());
        if (id == 0) {
            ticket.setCreatedAt(now.format(formatter));
        }
        ticket.setUpdatedAt(now.format(formatter));
        return ticket;
    }

}