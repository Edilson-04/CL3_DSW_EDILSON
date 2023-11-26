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


@PreAuthorize("hasRole('SUPERVISOR')")
@AllArgsConstructor
@RestController
@RequestMapping("api/cl3/filepdf")
public class FileController {


    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseFile> subirArchivos(
            @RequestParam("files") List<MultipartFile> files) throws  Exception{
        fileService.guardarArchivos(files);
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        ResponseFile.builder().message("Los archivos fueron cargados correctamente")
                                .build()
                );
    }





}
