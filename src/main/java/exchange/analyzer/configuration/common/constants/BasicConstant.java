package exchange.analyzer.configuration.common.constants;

import java.util.*;

final public class BasicConstant {
    public static final List<String> SUPPORTED_INSTRUMENT = new ArrayList<>(Arrays.asList(
            "EUR_USD", "AUD_USD", "EUR_AUD",
            "EUR_JPY", "GBP_JPY", "GBP_USD",
            "NZD_USD", "USD_CAD", "USD_CHF",
            "USD_JPY", "XAU_USD","EUR_CHF",
            "AUD_CAD", "GBP_AUD",
            "GBP_CHF", "GBP_NZD","CHF_JPY",
             "CAD_JPY", "AUD_NZD",
            "CAD_CHF", "EUR_NZD","EUR_CAD"));

    public static final int BULLISH =   1;
    public static final int BEARISH =  -1;

    public static final Map<String, Double> TABLEONEPOINT = new HashMap() {{
        put("EUR_CAD",0.0001);
        put("EUR_NZD",0.0001);
        put("CAD_CHF",0.0001);
        put("AUD_NZD",0.0001);
        put("CAD_JPY",0.01);
        put("CHF_JPY",0.01);
        put("GBP_NZD",0.0001);
        put("GBP_CHF",0.0001);
        put("GBP_AUD",0.0001);
        put("GBP_JPY",0.01);
        put("AUD_CAD",0.0001);
        put("EUR_CHF",0.0001);
        put("EUR_USD",0.0001);
        put("AUD_USD",0.0001);
        put("EUR_AUD",0.0001);
        put("EUR_JPY",0.01);
        put("GBP_JPY",0.01);
        put("GBP_USD",0.0001);
        put("NZD_USD",0.0001);
        put("USD_CAD",0.0001);
        put("USD_CHF",0.0001);
        put("USD_JPY",0.01);
        put("XAU_USD",0.01);
    }};

    public static final Map<String, Integer> TABLEONEPOINTINT = new HashMap() {{
        put("EUR_CAD",10000);
        put("EUR_NZD",10000);
        put("CAD_CHF",10000);
        put("AUD_NZD",10000);
        put("CAD_JPY",100);
        put("CHF_JPY",100);
        put("GBP_NZD",10000);
        put("GBP_CHF",10000);
        put("GBP_AUD",10000);
        put("GBP_JPY",100);
        put("AUD_CAD",10000);
        put("EUR_CHF",10000);
        put("EUR_USD",10000);
        put("AUD_USD",10000);
        put("EUR_AUD",10000);
        put("EUR_JPY",100);
        put("GBP_JPY",100);
        put("GBP_USD",10000);
        put("NZD_USD",10000);
        put("USD_CAD",10000);
        put("USD_CHF",10000);
        put("USD_JPY",100);
        put("XAU_USD",100);
    }};
}
