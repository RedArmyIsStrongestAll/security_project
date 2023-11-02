package ru.ygtu.student.security.project.controllers.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ygtu.student.security.project.dto.ResponseFromQueryDto;
import ru.ygtu.student.security.project.dto.SendQueryDto;
import ru.ygtu.student.security.project.services.QueryService;

import java.util.concurrent.Callable;

@RestController
@RequestMapping("/query")
public class QueryController {
    private final QueryService queryService;

    @Autowired
    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @PostMapping()
    public Callable<ResponseEntity<ResponseFromQueryDto>> sendQuery(@RequestBody SendQueryDto sendQueryDto) {
        return () -> ResponseEntity.ok().body(queryService.sendQuery(sendQueryDto.getQuery(), sendQueryDto.getRoleId()));
    }
}
