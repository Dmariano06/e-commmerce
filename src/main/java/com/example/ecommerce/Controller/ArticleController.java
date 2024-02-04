package com.example.ecommerce.Controller;

import com.example.ecommerce.Dto.ListArticle;
import com.example.ecommerce.Model.Article;
import com.example.ecommerce.Service.ArticleService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ArticleController {
   @Autowired
    private ArticleService artService;
    @Autowired  ServletContext context;


    @GetMapping("/articles/7/{code}")
    public  int getCode(@PathVariable String code) {
        System.out.println("Get Numbers...");
        int  x = artService.nbre(code);
        System.out.println(x);
        if (x == 0)
        {
            return 0;
        }
        else
        {
            return artService.max(code);
        }
    }


    @GetMapping("/articles")
    public List<ListArticle> list() {
        System.out.println("Get all Articles...");
        return artService.getAll();
    }



    @GetMapping("/articles/f/{code}")
    public List<ListArticle> listArtf(@PathVariable int code) {
        System.out.println("Get all Articles...");
        return artService.listArtf(code);
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> post(@PathVariable String id) {
        Optional<Article> cat = artService.findByCode(id);
        return cat.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound()
                        .build());
    }


    @PostMapping("/articles")
    public long createArticle (@RequestParam("file") MultipartFile file,
                               @RequestParam("article") String article) throws JsonParseException , JsonMappingException , Exception
    {
        System.out.println("Save Article.............");
        Article arti = new ObjectMapper().readValue(article, Article.class);
        boolean isExit = new File(context.getRealPath("/Imagess/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/Imagess/")).mkdir();
            System.out.println("mk dir Imagess.............");
        }
        System.out.println("Save Article  22222.............");
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+ FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Imagess/"+File.separator+newFileName));
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Save Article 333333.............");
        arti.setFileName(newFileName);
        return artService.save(arti);
    }




    @PutMapping("/articles/{code}")
    public void update(@PathVariable String code, @RequestBody Article Article) {
        Optional<Article> cat = artService.findByCode(code);
        if (cat.isPresent()) {
            artService.update(code, Article);

        }
    }

    @DeleteMapping("/articles/{code}")
    public void delete(@PathVariable String code) {
        artService.delete(code);
    }

    @GetMapping(path="/Imgarticles/{id}")
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Article Article   =artService.findById(id).get();
        return Files.readAllBytes(Paths.get(context.getRealPath("/Imagess/")+Article.getFileName()));
    }

    @GetMapping(path="/ImgDelete/{id}")
    private void deleteProductImage(@PathVariable("id") Long id) throws Exception
    {
        Article Article   =artService.findById(id).get();
        File file = new File (context.getRealPath("/Imagess/"+File.separator+Article.getFileName()));

        try {
            if(file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Delete operation is failed.");
            }
        }
        catch(Exception e)
        {
            System.out.println("Failed to Delete image !!");
        }
    }
   /* @GetMapping("/articles/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        System.out.println("Export to Excel ...");
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=articles_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        List<ListArticle> listArticles = artService.getAll();
        ArticleExcel excel = new ArticleExcel(listArticles);
        excel.export(response);
    }*/

   /* @GetMapping("/articles/report")
    public String generateReport() throws  FileNotFoundException, JRException
    {
        System.out.println("cont pdf");
        return artService.generateReport();

    }*/

}