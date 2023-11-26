package users.service.search_recipes.application_business_rules.API_Interface;

import users.service.search_recipes.application_business_rules.DataTypes.SearchInputData;

public interface InputDataURLConverter {
    public String convertToURL(SearchInputData searchInputData);
}
