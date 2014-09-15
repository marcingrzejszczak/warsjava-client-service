package pl.warsjawa.client.domain

import org.springframework.data.annotation.Id

class Client {
    @Id String id
    String name, lastName
}
