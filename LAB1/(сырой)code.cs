//на обсуждение:
//    1)    В ConfigCatalog - field:type  пропустил в коде
//    2)    В VendorDevice.Execute/ControlSwitch.Execute/IPlugin.Execute сейчас плейсхолдер бам
//    3)    зависимости изображены ф-иями UseXXXXX, мб изменить на что-то более близкое к предмет области

public class ControlSwitch
{
    public string ControlSwitchName;
    public int ControlSwitchCondition;

    public void Execute(string Command)
    {
        Console.WriteLine("бам");
    }
}
public class SensorReading
{
    public string SensorName;
    public int SensorValue;

    public float GetValue()
    {
        return SensorValue;
    }
}
public class VendorDevice : IPlugin 
{
    public string VendorDeviceName;
    public string VendorDeviceManufacturer;
    public string VendorDeviceEcosystem;
    public int VendorDeviceCondition;

    public void Execute(string Command)
    {
        Console.WriteLine("бам");
    }
}
public interface IPlugin //реализация: определение интерфейса и его реализация в классе VendorDevice
{
    public void Execute(string Command)
    {
        Console.WriteLine("бам");
    }
    public void UseIPlugin()
    {

    }
}
public interface IFunctional //реализация: определение интерфейса и его реализация в классах SubServer и ConfigCatalog
{
    public void FuncTurnOn(bool Value)
    {

    }
    public void FuncTurnOff(bool Value)
    {

    }
    public void FuncChangeBrightness(int Value)
    {

    }
    public void FuncOpen(bool Value)
    {

    }
    public void FuncClose(bool Value)
    {

    }
    public void UseIFunctional()
    {

    }
}
public abstract class SubServer : IFunctional
{
    public string Name;

    public SensorReading sensorreading;
    public ControlSwitch controlswitch;

    public SubServer(SensorReading sensorRe, ControlSwitch controlSw)
    {
        sensorreading = sensorRe;   // агрегация: класс SubServer содержит объекты классов SensorReading и ControlSwitch,
        controlswitch = controlSw;  // при уничтожении объекта SubServer объекты SensorReading и ControlSwitch не будет уничтожены.
    }
    public void UseConfigCatalog(ConfigCatalog c) // зависимость: изменения в ConfigCatalog могут повлечь изменения в SubServer
    {
        c.UseConfigCatalog();
    }
}
public class ConfigCatalog : IFunctional
{
    public void UseConfigCatalog()
    {

    }
}
public class CentralServer
{
    public ConfigCatalog configcatalog;
    public SubServer subserver;

    public CentralServer(SubServer subS)
    {
        configcatalog = new ConfigCatalog(); // композиция: класс CentralServer содержит объект класса ConfigCatalog,
                                             // при уничтожении объекта CentralServer уничтожится и объект ConfigCatalog.

        subserver = subS; // агрегация: класс CentralServer содержит объект класса SubServer,
                          // при уничтожении объекта CentralServer объект SubServer не будет уничтожен.
    }
    public void UseIPlugin(IPlugin p) // зависимость: изменения в IPlugin могут повлечь изменения в CentralServer
    {
        p.UseIPlugin();
    }
    public void UseIFunctional(IFunctional f) //зависимость, аналогично
    {
        f.UseIFunctional();
    }
}
