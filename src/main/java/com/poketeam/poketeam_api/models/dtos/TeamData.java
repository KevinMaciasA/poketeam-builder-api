package com.poketeam.poketeam_api.models.dtos;

import java.time.LocalDateTime;

public record TeamData(Integer id, String name, LocalDateTime createdAt) {

}
