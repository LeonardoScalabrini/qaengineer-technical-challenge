package com.exercise;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class CounterStepDefinitions {
    private List<String[]> strings = List.of();
    private List<CountResult> results = List.of();
    private final StringCounter counter = new StringCounter();

    @Given("I add the following strings")
    public void iAddTheStrings(List<Map<Integer, String>> dataTable) {
        this.strings = dataTable.stream()
                .map(m -> m.values().stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList())
                        .toArray(new String[0]))
                .collect(Collectors.toList());

    }

    @When("I count the vowels and consonants in the strings")
    public void iCountInTheStrings() throws Exception {
        var l = new ArrayList<CountResult>();
        for(String[] row : strings) {
            l.addAll(counter.getCountResult(row));
        }
        results = l;
    }

    @Then("I should see the following output")
    public void iShouldSeeTheOutput(List<Map<String, String>> dataTable) {
        assertThat(dataTable).isNotEmpty();
        assertThat(results).isNotEmpty();
        assertThat(dataTable).hasSize(results.size());
        for (int i = 0; i <= dataTable.size() - 1; i++) {
            var row = dataTable.get(i);
            var result = results.get(i);
            String string = row.get("string");
            int vowels = Integer.parseInt(row.get("vowels"));
            int consonants = Integer.parseInt(row.get("consonants"));
            assertThat(result.getWord()).isEqualTo(string);
            assertThat(result.getVowelCount()).isEqualTo(vowels);
            assertThat(result.getConsonantCount()).isEqualTo(consonants);
        }
    }

    @Then("I should see the error message")
    public void iShouldSeeTheErrorMessage() {
        assertThat(strings).isNotEmpty();
        var l = new ArrayList<CountResult>();
        for(String[] row : strings) {
            assertThat(row).hasSizeGreaterThan(4);
            assertThatThrownBy(() -> counter.getCountResult(row)).hasMessage("Extra arguments passed.");
        }
        results = l;
    }
}
