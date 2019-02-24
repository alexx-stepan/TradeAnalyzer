package exchange.analyzer.service.impl;

import exchange.analyzer.model.Candle;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@Service
public class SupportResistLinesServiceImpl {
    private Candle maxOpenPrice,
            minOpenPrice,
            maxClosePrice,
            minClosePrice,
            maxPrice,
            minPrice;

  //  private Map<Double, Double> intervals = new HashMap<>();

    public void calculate(TreeSet<Candle> candles){
        maxOpenPrice = minOpenPrice = maxClosePrice = minClosePrice = maxPrice = minPrice = candles.last();
         candles.forEach( c1 -> fillMaxMinPrices(c1));
         int size = (int) ((maxPrice.getHigh() - minPrice.getLow()) / 0.02 + 1);
        Stream<Double> intervals = Stream.iterate(minPrice.getLow(), d -> d += 0.02).limit(size);

/*        final Map<Map<Double, Double>, Long> collect = candles.stream().
                map(c -> c.getOpen()).collect(groupingBy(d -> test(d), Collectors.counting()));*/
    }

    private void fillMaxMinPrices(Candle c1){
        maxOpenPrice = maxOpenPrice.getOpen() > c1.getOpen() ? maxOpenPrice : c1;
        minOpenPrice = minOpenPrice.getOpen() < c1.getOpen() ? minOpenPrice : c1;
        maxClosePrice = maxClosePrice.getClose() > c1.getClose() ? maxClosePrice : c1;
        minClosePrice = minClosePrice.getClose() < c1.getClose() ? minClosePrice : c1;
        maxPrice = maxPrice.getHigh() < c1.getHigh() ? maxPrice : c1;
        minPrice = minPrice.getLow() > c1.getLow() ? minPrice : c1;
    }

}
