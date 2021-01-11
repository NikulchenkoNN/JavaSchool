package HomeWork05.Terminal;

import HomeWork05.Exceptions.IncorrectPinException;

public class PinValidator {
    public PinValidator() {
    }

    public void chekPin(Integer pin) throws IncorrectPinException {
        if (!(pin instanceof Integer)) {
            throw new IncorrectPinException("Введено некорректное значение PIN-кода");
        }
    }
}
