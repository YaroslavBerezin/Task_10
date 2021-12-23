import org.junit.Assert;
import org.junit.Test;
import ru.sc.vsu.berezin_y_a.Tablet;
import ru.sc.vsu.berezin_y_a.TabletSelection;
import ru.sc.vsu.berezin_y_a.Utils.ListUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TabletSelectionTest {

    TabletSelection tablet = new TabletSelection();
    String correctResult;
    String actualResult;
    List<Tablet> list = new ArrayList<>();
    int n = 50000;

    @Test
    public void returnChosenTablet1() throws FileNotFoundException {
        List<List<String>> listStr = ListUtils.loadStringList2FromFile("testSrc/testFiles/input01.txt");
        assert listStr != null;
        tablet.fillListFromStrList(listStr, list);
        correctResult = "Asus 12 5 30000";
        actualResult = tablet.returnChosenTablet(list, tablet.returnIndex(list, n));
        Assert.assertEquals(correctResult, actualResult);
    }

    @Test
    public void returnChosenTablet2() throws FileNotFoundException {
        List<List<String>> listStr = ListUtils.loadStringList2FromFile("testSrc/testFiles/input02.txt");
        assert listStr != null;
        tablet.fillListFromStrList(listStr, list);
        correctResult = "Samsung 8 5 30000";
        actualResult = tablet.returnChosenTablet(list, tablet.returnIndex(list, n));
        Assert.assertEquals(correctResult, actualResult);
    }

    @Test
    public void returnChosenTablet3() throws FileNotFoundException {
        List<List<String>> listStr = ListUtils.loadStringList2FromFile("testSrc/testFiles/input03.txt");
        assert listStr != null;
        tablet.fillListFromStrList(listStr, list);
        correctResult = "there are no such tablets";
        actualResult = tablet.returnChosenTablet(list, tablet.returnIndex(list, n));
        Assert.assertEquals(correctResult, actualResult);
    }

    @Test
    public void returnChosenTablet4() throws FileNotFoundException {
        List<List<String>> listStr = ListUtils.loadStringList2FromFile("testSrc/testFiles/input04.txt");
        assert listStr != null;
        tablet.fillListFromStrList(listStr, list);
        correctResult = "Apple 256 5 40000";
        actualResult = tablet.returnChosenTablet(list, tablet.returnIndex(list, n));
        Assert.assertEquals(correctResult, actualResult);
    }

    @Test
    public void returnChosenTablet5() throws FileNotFoundException {
        List<List<String>> listStr = ListUtils.loadStringList2FromFile("testSrc/testFiles/input05.txt");
        assert listStr != null;
        tablet.fillListFromStrList(listStr, list);
        correctResult = "Apple 512 3 20000";
        actualResult = tablet.returnChosenTablet(list, tablet.returnIndex(list, n));
        Assert.assertEquals(correctResult, actualResult);
    }

}
