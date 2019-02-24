package exchange.analyzer.shedulers;

import org.springframework.stereotype.Component;

@Component
public class SupportResistLinesSheduler extends CandlestickComponentSheduler {
    @Override
    protected void process() {
        getCandles(300L);
    }
}
