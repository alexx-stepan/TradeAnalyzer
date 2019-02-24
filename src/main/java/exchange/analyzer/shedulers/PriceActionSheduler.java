package exchange.analyzer.shedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PriceActionSheduler extends CandlestickComponentSheduler {
    @Override
    @Scheduled(fixedDelay = 3600000)
    protected void process() {
        getCandles(10L);
    }
}
