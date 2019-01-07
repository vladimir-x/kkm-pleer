package ru.dude.kkmpleer.kkm;

import ru.atol.drivers10.fptr.Fptr;
import ru.atol.drivers10.fptr.IFptr;
import ru.dude.kkmpleer.KkmConfig;

public class Atol10Kkm extends APlayable {



    IFptr fptr = null;

    public Atol10Kkm(KkmConfig config) {

        try {

            //Utils.setLibraryPath(Utils.selectNativeLibraryPath());


            fptr = new Fptr();

            System.out.println("init driver: " + fptr.version());

            // Каталог с файлами драйверов
            fptr.setSingleSetting(IFptr.LIBFPTR_SETTING_LIBRARY_PATH, System.getProperty("java.library.path"));
            callAndCheckError(fptr.applySingleSettings());

            //, номер модели
            fptr.setSingleSetting(IFptr.LIBFPTR_SETTING_MODEL, String.valueOf(IFptr.LIBFPTR_MODEL_ATOL_AUTO));

            // IP-адрес, порт, TCP/IP
            if (config.isIpConnection()) {
                fptr.setSingleSetting(IFptr.LIBFPTR_SETTING_PORT, String.valueOf(IFptr.LIBFPTR_PORT_TCPIP));
                fptr.setSingleSetting(IFptr.LIBFPTR_SETTING_IPADDRESS, config.getIp());
                fptr.setSingleSetting(IFptr.LIBFPTR_SETTING_IPPORT, config.getPort());
            }

            //com-port
            if (config.isComPortConnection()) {
                fptr.setSingleSetting(IFptr.LIBFPTR_SETTING_PORT, String.valueOf(IFptr.LIBFPTR_PORT_COM));
                fptr.setSingleSetting(IFptr.LIBFPTR_SETTING_COM_FILE, config.getComPort());
                fptr.setSingleSetting(IFptr.LIBFPTR_SETTING_BAUDRATE, config.getComSpeed());
            }

            callAndCheckError(fptr.applySingleSettings());


            // Подключение к устройству
            callAndCheckError(fptr.open());

            // Проверка связи
            if (!fptr.isOpened()) {
                throw new Exception("Atol10Kkm: Can't open connect");
            }


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void init() throws Exception {

        fptr.setParam(IFptr.LIBFPTR_PARAM_DATA_TYPE, IFptr.LIBFPTR_DT_UNIT_VERSION);
        fptr.setParam(IFptr.LIBFPTR_PARAM_UNIT_TYPE, IFptr.LIBFPTR_UT_FIRMWARE);
        fptr.queryData();

        String firmwareVersion = fptr.getParamString(IFptr.LIBFPTR_PARAM_UNIT_VERSION);
        System.out.println("Atol10Kkm firmwareVersion = " + firmwareVersion);
    }

    @Override
    public void setVolume(float value) throws Exception {

        System.out.println("Atol10Kkm volume config not supported");
    }

    @Override
    public void play(double frequency, int durationMs) throws Exception {
        fptr.setParam(IFptr.LIBFPTR_PARAM_FREQUENCY, frequency);
        fptr.setParam(IFptr.LIBFPTR_PARAM_DURATION, durationMs);

        fptr.beep();
    }

    @Override
    public void close() throws Exception {

        fptr.close();
        fptr.destroy();
    }


    /**
     * Выполняет команду и проверяет код ошибки.
     *
     * @param res результат выполнения комманды
     * @throws Exception при выплнении команды
     */
    private void callAndCheckError(int res) throws Exception {
        if (res < 0) {
            checkResult();
        }
    }

    private void checkResult() throws Exception {
        int rc = fptr.errorCode();

        String rd = fptr.errorDescription();

        Exception exception;
        if (rc == fptr.LIBFPTR_ERROR_CONNECTION_DISABLED) {
            exception = new Exception("Device not connected");
        } else {
            exception = new Exception(String.format("[%d] %s", rc, rd));
        }
        throw exception;
    }

}
