package per.pao.example.worker;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import per.pao.example.entity.Vehicle;

@Component
@RequiredArgsConstructor
public class VehicleMutation implements GraphQLMutationResolver {

    private final VehicleWorker vehicleWorker;

    public Vehicle createVehicle(final String type, final String modelCode, final String brandName,
                                 final String launchDate) {
        return this.vehicleWorker.creteVehicle(type, modelCode, brandName, launchDate);
    }

}
