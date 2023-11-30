package backend.service.search_recipes.application_business_rules.API_Interface;

import backend.service.search_recipes.application_business_rules.DataTypes.SearchInputData;

public interface InputDataURLConverter {
    public String convertToURL(SearchInputData searchInputData);
}
