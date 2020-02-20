import org.testng.Assert;
import org.testng.annotations.Test;
import utils.VarargExample;

public class TestVararg {

    @Test
    public void testSumNumber() {
        VarargExample vararg = new VarargExample();
        Assert.assertEquals(vararg.sumNumber(1, 2), 3);
        Assert.assertEquals(vararg.sumNumber(1, 2, 3), 6);
        Assert.assertEquals(vararg.sumNumber(6), 6);
        Assert.assertEquals(vararg.sumNumber(), 0);
        Assert.assertEquals(vararg.sumNumber(-1, 10), 9);
    }
}
