package per.pao.example.controller.simple;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import per.pao.example.dao.jpa.SimpleRepository;
import per.pao.example.entity.SimpleDo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "Simple")
@RequiredArgsConstructor
@RequestMapping(value = "/api")
@RestController
public class SimpleController {

    @GetMapping
    public Map hello() {
        Map map = new HashMap<>();
        map.put("say", "hello");
        return map;
    }

    private final SimpleRepository simpleRepository;

    @ApiOperation(value = "find all simple data", notes = "none")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/v1/simple")
    public List<SimpleDo> getAll() {
        return simpleRepository.findAll();
    }
}

