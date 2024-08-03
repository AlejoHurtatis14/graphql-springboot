# Getting Started

* Create database in MYSQL with name `ticket-app`
* Run in project `.\mvnw clean install`
* After Run in project `.\mvnw spring-boot:run`
* Open to navigator with url `http://localhost:9095/graphiql`

### Guides run api

* Mutations

Define mutation `mutation MyMutation {}` 

1- Delete ticket example
`deleteTicket(id: "1")`

2- Update ticket example
`updateTicket(id: "1", ticket: {status: "Open", user: "Username"}) {
    createdAt
    id
    updatedAt
    status
    user
}`

3- Create ticket example
`createTicket(ticket: {status: "Closed", user: "Username"}) {
    createdAt
    id
    status
    updatedAt
    user
}`


* Queries

Define mutation `query MyQuery { {}`

1- Get one ticket example
`getTicket(id: 1) {
    createdAt
    id
    status
    updatedAt
    user
}`

2- get tickets pagination example
`getTicketsPagination(page: 0, size: 5) {
    createdAt
    id
    status
    updatedAt
    user
}`

3- get all tickets example
`getTickets {
    createdAt
    id
    status
    updatedAt
    user
}`
