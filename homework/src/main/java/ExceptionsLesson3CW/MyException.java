package ExceptionsLesson3CW;

public class MyException {
    public class DivisionByZeroException extends Exception {
        public DivisionByZeroException () {
            super("Р”РµР»РёС‚СЊ РЅР° РЅРѕР»СЊ РЅРµР»СЊР·СЏ!");
        }
    }
    public class NullArrayElementException extends Exception {
        public NullArrayElementException () {
            super("РћР±СЂР°С‰РµРЅРёРµ Рє РїСѓСЃС‚РѕРјСѓ СЌР»РµРјРµРЅС‚Сѓ РјР°СЃСЃРёРІР°!");
        }
    }
    public class FileNotFoundException extends Exception {
        public FileNotFoundException () {
            super("Р¤Р°Р№Р» РЅРµ РЅР°Р№РґРµРЅ!");
        }
    }
    
}
