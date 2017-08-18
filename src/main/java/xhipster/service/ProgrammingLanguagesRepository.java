package xhipster.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import xhipster.model.ProgrammingLanguage;


@Repository
public interface ProgrammingLanguagesRepository extends JpaRepository<ProgrammingLanguage, Long> {

    @Query("SELECT COUNT(u.id) FROM ProgrammingLanguage u WHERE u.name=:name")
    Long countLanguagesByName(@Param("name") String name);



    Page<ProgrammingLanguage> findAllByOrderByNameAsc(Pageable pageable);


}