package com.wiirux.sdjpaintro.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiirux.sdjpaintro.domain.AuthorUuid;

public interface AuthorUuidRepository extends JpaRepository<AuthorUuid, UUID> {

}
