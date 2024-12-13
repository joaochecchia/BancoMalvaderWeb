package com.example.BancoMalvaderWeb.DTO;

public enum UserRole {
    CLIENTE("cliente"),
    FUNCIONARIO("funcionario"),
    GERENTE("gerente");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
