package com.example.ecommerce.Repository;

import com.example.ecommerce.Dto.ListCategorie;
import com.example.ecommerce.Model.SCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SCategorieRepository extends JpaRepository<SCategorie, Long> {
    Optional<SCategorie> findByCode(String code);

    List<SCategorie> findAllByLibelleContaining(String libelle);

    List<SCategorie> findAllByCcateg(String code);

    @Query(value = "SELECT count(*)  FROM SCategorie   WHERE ccateg  = :code")
    public int nbre (@Param("code") String  code);

    @Query(value = "SELECT max(code) FROM SCategorie  where ccateg = :code")
    public int max(@Param("code") String  code);



    @Query(value = "SELECT new com.example.ecommerce.Dto.ListCategorie (a.code,a.libelle,b.libelle,b.code)  from SCategorie a join Categorie b "
            + "on a.ccateg = b.code")
    public   List<ListCategorie> listScateg();

}
