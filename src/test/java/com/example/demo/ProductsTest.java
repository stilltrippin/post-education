package com.example.demo;

public final class ProductsTest  {

    private static final String FILE_PATH = "products.json";

    @AfterMethod(alwaysRun = true)
    public void captureScreenshotOnFailure(ITestResult result) {
        ITestNGMethod method = result.getMethod();

        if (ITestResult.FAILURE == result.getStatus()) {
            loginPage.captureScreenshot(
                    String.format(
                            "%s_%s_%s",
                            method.getRealClass().getSimpleName(),
                            method.getMethodName(),
                            method.getParameterInvocationCount()));
        }
    }

    @Test()
    public void testSuccessfulLogout() {
        loginPage.loginAs(data.getUsername(), data.getPassword()).clickOnLogout();
        assertThat(loginPage.getUrl()).isEqualTo(data.getUrl());
    }
}