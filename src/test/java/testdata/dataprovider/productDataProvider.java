package testdata.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

import static testdata.dataprovider.userDataProvider.validLoginCredentials;

public class productDataProvider {

    static Object validEmail = validLoginCredentials()[0][0];
    static Object validPassword = validLoginCredentials()[0][1];

    @DataProvider(name = "userSignUpData")
    public static Object[][] userSignUpData() {
        return new Object[][]{
                {validEmail, validPassword}
        };
    }

    @DataProvider
    public Object[][] dataProvider1() {
        return new Object[][] {
                {"test1", "test2"},
                {"test3", "test4"}
        };
    }

    @DataProvider
    public Object[][] dataProvider2() {
        return new Object[][] {
                {"test5", "test6"},
                {"test7", "test8"}
        };
    }

    @DataProvider
    public Object[][] combinedDataTemplate() {

        //Prerequisites
        Object[][] dataProvider1 = dataProvider1();
        Object[][] dataProvider2 = dataProvider2();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //Combine the data
        for (Object[] dataProvider1Obj : dataProvider1) {
            for (Object[] dataProvider2Obj : dataProvider2) {
                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
                combinedDataProviders.add(combinedItem);
            }
        }
        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
    }

}
