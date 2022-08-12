package com.wiirux.sdjpaintro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiirux.sdjpaintro.domain.composite.AuthorComposite;
import com.wiirux.sdjpaintro.domain.composite.NameId;

public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NameId>{

}
