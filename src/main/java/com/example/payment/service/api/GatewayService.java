package com.example.payment.service.api;

import com.example.payment.model.Draft;
import com.example.payment.model.DraftRequest;
import com.example.payment.model.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "SPRING-GATEWAY")
public interface GatewayService {
    @GetMapping("/person/findByNationalCode")
    Person findByNationalCode(@RequestParam String nationalCode);

    @GetMapping("/draft/findDraftListByPersonId")
    List<Draft> findDraftListByPersonId(@RequestParam Integer personId);

    @PutMapping("/draft/updateDraftStatus")
    void updateDraftStatus(@RequestBody DraftRequest draftRequest);
}
