package com.wiirux.sdjpaintro.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiirux.sdjpaintro.domain.BookUuid;

public interface BookUuidRepository extends JpaRepository<BookUuid, UUID> {

}
