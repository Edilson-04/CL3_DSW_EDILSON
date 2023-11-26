package com.edu.cibertec.CL3DSWIIGALINDO.controller;

import com.edu.cibertec.CL3DSWIIGALINDO.model.response.ResponseFile;
import com.edu.cibertec.CL3DSWIIGALINDO.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@PreAuthorize("hasRole('ADMINISTRADOR')")
@AllArgsConstructor
@RestController
@RequestMapping("api/cl3/files")
public class FileDoc {

    private FileService fileService;
    @PostMapping("/uploadDOCX")
    public ResponseEntity<ResponseFile> subirArchivosDocx(
            @RequestParam("files") List<MultipartFile> files) throws Exception {

        // Validar que la extensión del archivo sea DOCX
        if (!files.stream().allMatch(file -> file.getOriginalFilename().endsWith(".docx"))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // Validar que el tamaño del archivo sea menor o igual a 2MB

        fileService.guardarArchivos(files);

        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        ResponseFile.builder().message("Los archivos DOCX fueron cargados correctamente")
                                .build()
                );
    }
}
