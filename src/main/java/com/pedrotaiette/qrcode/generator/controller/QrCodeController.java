package com.pedrotaiette.qrcode.generator.controller;

import com.pedrotaiette.qrcode.generator.dto.QrCodeGenerateRequest;
import com.pedrotaiette.qrcode.generator.dto.QrCodeGenerateResponse;
import com.pedrotaiette.qrcode.generator.services.QrCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeGeneratorService qrCodeGeneratorService;

    public QrCodeController(QrCodeGeneratorService qrCodeService){
        this.qrCodeGeneratorService = qrCodeService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generate (@RequestBody QrCodeGenerateRequest request) {
        try {
             QrCodeGenerateResponse response = qrCodeGeneratorService.generateAndUploadQrCode(request.text());
             return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
