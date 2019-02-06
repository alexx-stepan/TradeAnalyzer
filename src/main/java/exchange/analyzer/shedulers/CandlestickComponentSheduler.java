package exchange.analyzer.shedulers;

import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.instrument.InstrumentCandlesRequest;
import com.oanda.v20.instrument.InstrumentCandlesResponse;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.configuration.common.constants.BasicConstant;
import exchange.analyzer.configuration.common.constants.ScheduleConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CandlestickComponentSheduler extends OandaComponentSheduler {

    private static final Logger logger = LoggerFactory.getLogger(CandlestickComponentSheduler.class);



//    @Scheduled(fixedRate = 15 * ScheduleConstants.MINUTE_FACTOR)
    public void process(){
        BasicConstant.SUPPORTED_INSTRUMENT.forEach(currency ->
        {
            InstrumentName instrumentName = new InstrumentName(currency);

            InstrumentCandlesRequest request = new InstrumentCandlesRequest(instrumentName);
            request.setPrice(ScheduleConstants.price);

            ScheduleConstants.GRANULARITIES.forEach(requestedGranularity ->
            {
                CandlestickGranularity granularity = CandlestickGranularity.valueOf(requestedGranularity);
                request.setGranularity(granularity);

                try {
                    InstrumentCandlesResponse candlesResponse = oandaContext.getContext().instrument.candles(request);
                } catch (Exception e) {
                    logger.error("Error during candlestick task", e);
                }
            });
        });
    }
}
