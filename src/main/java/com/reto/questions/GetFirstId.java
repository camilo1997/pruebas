package com.reto.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetFirstId implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        String response = SerenityRest.lastResponse().body().asString();
        JSONObject jsonObj = new JSONObject(response);
        JSONArray dataArr = jsonObj.getJSONArray("data");
        JSONObject firstObj = dataArr.getJSONObject(0);
        return firstObj.getString("id");
    }

    public static GetFirstId toAllUsers(){
        return new GetFirstId();
    }
}
