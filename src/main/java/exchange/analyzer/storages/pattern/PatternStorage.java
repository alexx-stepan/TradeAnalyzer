package exchange.analyzer.storages.pattern;

import exchange.analyzer.Util;
import exchange.analyzer.model.autochartist.Pattern;
import exchange.analyzer.model.autochartist.Signal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class PatternStorage<S extends Signal, P extends Pattern<S>> {

	protected Map<Long, S> patterns = new HashMap<>();

	public void addPatterns(P pattern){
		pattern.getSignals().forEach(signal -> {
			if (Util.isSupportedInstrument(signal.getInstrument()))
				patterns.putIfAbsent(signal.getId(), signal);
		});

	}

	public Map<Long, S> getPatterns() {
		return patterns;
	}

	public List<S> getSignals(){
		List<S> signals = new ArrayList<>(patterns.values());
		return signals;
	}

	public List<S> getSignals(String instrument){
		List<S> signals = getSignals().stream().filter(signal ->
				signal.getInstrument().equals(instrument)).collect(Collectors.toCollection(ArrayList::new));
		return signals;
	}
}