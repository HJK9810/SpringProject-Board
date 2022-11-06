package com.spring.board.domain;

import lombok.Getter;

@Getter
public enum Role {
	ROLE_USER("user"), ROLE_GUEST("guest");

    private String description;

    Role(String description) {
        this.description = description;
    }
    
    public String value() {
        return description;
    }
}
