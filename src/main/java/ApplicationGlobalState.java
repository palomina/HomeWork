public class ApplicationGlobalState {

    private static ApplicationGlobalState INSTANCE;
    private String selectedCity = null;
    private final String API_KEY = "eVrMSSWUZNkvJQG02PcVyCvmSem4GJFc";

    private ApplicationGlobalState() {

    }

    public static ApplicationGlobalState getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApplicationGlobalState();
        }

        return INSTANCE;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String city) {
        this.selectedCity = city;
    }

    public String getApiKey() {
        return this.API_KEY;
    }
}
