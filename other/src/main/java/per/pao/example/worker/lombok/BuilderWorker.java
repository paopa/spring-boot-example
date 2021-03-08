package per.pao.example.worker.lombok;

import per.pao.example.worker.lombok.dto.BuilderDto;

public class BuilderWorker {

    private static void demo() {
        BuilderDto test = BuilderDto.builder().build();
        System.out.println(test);
    }

}