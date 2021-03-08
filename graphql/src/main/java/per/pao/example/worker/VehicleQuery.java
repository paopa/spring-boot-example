package per.pao.example.worker;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import per.pao.example.entity.Vehicle;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleQuery implements GraphQLQueryResolver {

    private final VehicleWorker vehicleWorker;

    public List<Vehicle> getVehicles(final int count) {
        return this.vehicleWorker.getAllVehicles(count);
    }

    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleWorker.getVehicle(id);
    }
}
