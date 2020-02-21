import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVararg {

    @Test
    public void testSumNumber() {
        VarargExample vararg = new VarargExample();
        Assert.assertEquals(vararg.sumNumber(1, 2, 3), 6, "Sum of 1, 2, 3 is not 6");
        Assert.assertEquals(vararg.sumNumber(6), 6, "Sum of only 6 is not 6");
        Assert.assertEquals(vararg.sumNumber(), 0, "Sum of 0 numbers is not 0");
        Assert.assertEquals(vararg.sumNumber(-1, 10), 9, "Sum of -1 and 10 is not 9");
    }
}
