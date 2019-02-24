package exchange.analyzer.priceaction;

import exchange.analyzer.model.Candle;
import exchange.analyzer.priceaction.classifier.Classifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.TreeSet;

@Component
public class StartPriceAction {

    @Autowired
    List<Classifier> classifiers;
    public void process(TreeSet<Candle> candles){
        candles.size();
        classifiers.get(1).is(candles);
    }
}
