package per.pao.example.controller.simple;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import per.pao.example.controller.simple.dto.TestDto;
import per.pao.example.controller.simple.vo.TestVo;
import per.pao.example.dao.jpa.SimpleRepository;
import per.pao.example.entity.SimpleDo;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "Simple")
@RequiredArgsConstructor
@RequestMapping(value = "/api")
@RestController
public class SimpleController {

    @GetMapping()
    public Map hello() {
        Map map = new HashMap<>();
        map.put("say", "hello");
        map.put("Accept-Language", LocaleContextHolder.getLocale().toLanguageTag());
        return map;
    }

    private final SimpleRepository simpleRepository;

    @ApiOperation(value = "find all simple data", notes = "none")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/v1/simple")
    public List<SimpleDo> getAll(@RequestParam(value = "a") String a) {
        return simpleRepository.findAll();
    }

    @ApiOperation(value = "test valid annotation")
    @PostMapping("/validation-annotation/test")
    public ResponseEntity<TestVo> validationTest(@Valid @RequestBody TestDto testDto) {
        return new ResponseEntity<>(
                new TestVo(testDto.getName(), testDto.getAge(), testDto.getSub().getSex()),
                HttpStatus.OK
        );
    }
}

