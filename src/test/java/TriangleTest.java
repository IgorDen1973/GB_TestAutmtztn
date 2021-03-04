import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geek_lessons.geekbrains.MyTriangle;


public class TriangleTest {

    static final Logger log1 = LoggerFactory.getLogger(TriangleTest.class);

    // метод выполняется прежде ВСЕХ тестов
    @BeforeAll
    static void setUp(){
        log1.info("\tSTARTING OUR TESTS ........");
    }

    // метод выполняется после ВСЕХ тестов
    @AfterAll
    static void tearDown(){
        log1.info("\tFINISHING OUR TESTS......GOODBYE!");
    }

    @DisplayName("Тест по проверке вычисления площади треугольника")
    @RepeatedTest(6) // поставил 6  так, как часто отсекается Assumptions
    void testTriangle(){

        int a = (int)(Math.random() * 10);
        int b = (int)(Math.random() * 10);
        double doubleValue = Math.sqrt(a*a+b*b);
        int c = (int) doubleValue; // сделал третью сторону по формуле, чтобы было похоже на правду

        //  поставил ограничения на минимальное значение сторон, иначе 0,1,2 генерит часто
        Assumptions.assumeTrue(a > 2, () -> "Тест пропускается потому, что a <= 2: a =" + a);
        Assumptions.assumeTrue(b > 2, () -> "Тест пропускается потому, что b <= 2: b =" + b);
        Assumptions.assumeTrue(c > 2, () -> "Тест пропускается потому, что c <= 2: c =" + c);

        log1.info("\t\t\tSTART TEST FOR TRIANGLE SQUARE CALCULATING");

        double actual_result = MyTriangle.triangleSquare(a,b,c);
        int p = (a+b+c);
        int s = p*(p-a)*(p-b)*(p-c);
        double expected_result = Math.sqrt(s);

        double expected_result2 = expected_result;

        expected_result2 = Math.round(expected_result2 * 100);
        expected_result2 = expected_result2/100;


        Assertions.assertEquals(expected_result, actual_result);

        log1.info("\t\t\t "+"a = "+a+" b = "+b+" c = "+c+"   square = "+expected_result2);
        log1.info("\t\t\tEND TEST FOR TRIANGLE SQUARE CALCULATING");
    }

    // параметры получаем из CsvFileSource - в нем указан путь к отдельному файлу,
    // который находится в папке test\resources
    @ParameterizedTest(name="Test №{index}- Test with following triangle sides = {arguments}")
    @DisplayName("Тест по проверке вычисления c данными из файла")
    @CsvFileSource(resources = "nums-data2.csv", numLinesToSkip = 1) // источник - файл, первую строку не читаем
    void testTriangleFromFile(int a, int b, int c){

        log1.info("\t\tSTART SQUARE CALCULATING FROM FILE");

        double actual_result = MyTriangle.triangleSquare(a,b,c);

        int p = (a+b+c);
        int s = p*(p-a)*(p-b)*(p-c);
        double expected_result = Math.sqrt(s);

        Assertions.assertEquals(expected_result, actual_result);

        log1.info("\t\tSQUARE = "+expected_result);

        log1.info("\t\tFINISHING CALCULATING FROM FILE");
    }

}
