package per.pao.example.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@DgsComponent
public class ShowDataFetcher {
    private final List<Show> shows = List.of(
            new Show("Stranger Things", 2016),
            new Show("Ozark", 2017),
            new Show("The Crown", 2016),
            new Show("Dead to Me", 2019),
            new Show("Orange is the New Black", 2013)
    );

    @DgsData(parentType = "Query", field = "shows")
    public List<Show> shows(@InputArgument("titleFilter") final String titleFilter) {
        if (isNull(titleFilter)) {
            return shows;
        }
        return shows.stream()
                .filter(show -> show.getTitle().contains(titleFilter))
                .collect(Collectors.toList());
    }

    @Getter
    @AllArgsConstructor
    public static class Show {
        private final String title;
        private final Integer releaseYear;
    }
}
