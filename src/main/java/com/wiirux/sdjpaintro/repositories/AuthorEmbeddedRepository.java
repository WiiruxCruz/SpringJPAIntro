package com.wiirux.sdjpaintro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiirux.sdjpaintro.domain.composite.AuthorEmbedded;
import com.wiirux.sdjpaintro.domain.composite.NameId;

public interface AuthorEmbeddedRepository extends JpaRepository<AuthorEmbedded, NameId> {

}
