package br.edu.ifsp.orderflow.domain;

import java.util.UUID;

public class Cliente {
<<<<<<< HEAD

=======
>>>>>>> 7e8f8feaa9a5f3fda4786210d88d7668041d0e2c
    private final String id;
    private final String nome;
    private final String email;

<<<<<<< HEAD
    public Cliente(String nome, String email) {
=======
    public Cliente(String nome, String email){
>>>>>>> 7e8f8feaa9a5f3fda4786210d88d7668041d0e2c
        this.id = (UUID.randomUUID()).toString();
        this.nome = nome;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return this.nome + " <" + this.email + ">";
    }
}
