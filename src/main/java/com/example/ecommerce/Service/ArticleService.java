package com.example.ecommerce.Service;

import com.example.ecommerce.Dto.ListArticle;
import com.example.ecommerce.Model.Article;
import com.example.ecommerce.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class ArticleService {
    @Autowired
    ArticleRepository repository;

    public List<ListArticle> getAll() {
        System.out.println("Get all Articles 11111...");
        return repository.listArticle();
    }



    public Optional<Article> findByCode(String code) {
        return repository.findByCode(code);
    }

    public long save(Article article) {

        return repository.save(article)
                .getId();
    }
    public void update(String code, Article article) {
        Optional<Article> artic = repository.findByCode(code);
        if (artic.isPresent()) {
            Article art = artic.get();
            art.setLibelle(article.getLibelle());
            art.setCcateg(article.getCcateg());
            repository.save(art);
        }
    }


    public List<Article> findByLibelle(String libelle) {
        return repository.findAllByLibelleContaining(libelle);
    }

    public void delete(String code) {
        Optional<Article> art = repository.findByCode(code);
        art.ifPresent(repository::delete);
    }

    public List<Article> findByCcateg(String code) {
        return repository.findAllByCcateg(code);
    }

    public List<Article> findByCscateg(String code) {
        return repository.findAllByCscateg(code);
    }

    public int nbre(String code) {
        return repository.nbre(code);
    }



    public int max(String code) {
        return repository.max(code);
    }



    public Optional<Article> findById(Long id) {
        return repository.findById(id);
    }



    public List<ListArticle> listArtf(int code) {
        // TODO Auto-generated method stub
        return repository.listArticleFour(code);
    }



 /*   public String generateReport() throws FileNotFoundException, JRException{
        String path = "e:\\report";
        List<Article> articles = repository.findAll();
        File file = ResourceUtils.getFile("classpath:article.jrxml");
        JasperReport jasperReport  = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(articles);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "My self");
        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters ,datasource);
        JasperExportManager.exportReportToPdfFile(print, path+"\\article.pdf");
        return "Edition Faite avec success";
    }*/
}

