package exchange.analyzer.priceaction.classifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import exchange.analyzer.model.Candle;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.TreeSet;

//5 to 1: EURCHF, AUDUSD, AUDCAD, GBPAUD, GBPJPY
//4 to 1: GBPCHF, GBPNZD, CHFJPY, EURAUD, CADJPY
//3 to 1: AUDNZD, CADCHF, EURNZD, EURCAD
//start: 22.00

@Component
public class HighlyVolatileClassifier implements Classifier {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void is(TreeSet<Candle> candles) {
        Candle candle = candles.last();
        if(candle.getTf().equals("D") && !candle.getInstrument().equals("XAU_USD")){
            Map<String,String> result = restTemplate.getForObject("http://localhost:8090/parsercomponent/volattable", Map.class);
            if (candle.getBodySize() > 1.5 * Double.parseDouble(result.get(candle.getInstrument().replace("_","")))){
                System.out.println(candle.getInstrument() + " -  Good Night");
            }
        }
    }
}
