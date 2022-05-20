package structural.Adapter.PokemonExample;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class PokedexMapService {

	private Map<String, Map<String, Integer>> pokemons;

	public PokedexMapService(Map<String, Map<String, Integer>> pokemons) {
		this.pokemons = pokemons;
	}

	public void insertOrUpdate(Map<String, Map<String, Integer>> pokemonMap) {
		for(Entry<String, Map<String, Integer>> pokemon : pokemonMap.entrySet()) {
			insertOrUpdate(pokemon.getKey(), pokemon.getValue().entrySet().stream().collect(Collectors.toList()));
		}
	}

	public void insertOrUpdate(String name, List<Entry<String, Integer>> newStats) {
		if (existsByName(name)) {
			Map<String, Integer> currentStats = getPokemons().get(name);

			for (Entry<String, Integer> newStat : newStats) {
				String key = newStat.getKey();
				Integer value = newStat.getValue();

				if (currentStats.containsKey(key)) {
					currentStats.replace(key, value);
				} else {
					currentStats.put(key, value);
				}
			}
		} else {
			Map<String, Integer> stats = newStats.stream()
					.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

			getPokemons().put(name, stats);
		}
	}

	public boolean existsByName(String name) {
		return pokemons.containsKey(name);
	}

	public Map<String, Map<String, Integer>> getPokemons() {
		return pokemons;
	}
}
