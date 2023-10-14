namespace ooapLAB
{
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

        //реализация метода из IPlugin
        public void Execute(string Command) //реализация метода из IPlugin
        {
            Console.WriteLine("бам");
        }
    }
    public interface IPlugin //реализация: определение интерфейса и его реализация в классе VendorDevice
    {
        public void Execute(string Command)
        {
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

        public SensorReading []sensorreading; //агрегация
        public ControlSwitch []controlswitch;

        public void ObserveConfigCatalog(ConfigCatalog c) // зависимость: изменения в ConfigCatalog могут повлечь изменения в SubServer
        {
            c.GetState();
        }

        // реализации методов из IFunctional
        public void FuncTurnOn(bool Value)
        {
            Console.WriteLine("бам");
        }
        public void FuncTurnOff(bool Value)
        {
            Console.WriteLine("бам");
        }
        public void FuncChangeBrightness(int Value)
        {
            Console.WriteLine("бам");
        }
        public void FuncOpen(bool Value)
        {
            Console.WriteLine("бам");
        }
        public void FuncClose(bool Value)
        {
            Console.WriteLine("бам");
        }
        public void UseIFunctional()
        {
            Console.WriteLine("бам");
        }
    }
    public class ConfigCatalog : IFunctional
    {
        public string []entities;
        public void GetState()
        {
            
        }

        // реализации методов из IFunctional
        public void FuncTurnOn(bool Value) 
        {
            Console.WriteLine("бам");
        }
        public void FuncTurnOff(bool Value)
        {
            Console.WriteLine("бам");
        }
        public void FuncChangeBrightness(int Value)
        {
            Console.WriteLine("бам");
        }
        public void FuncOpen(bool Value)
        {
            Console.WriteLine("бам");
        }
        public void FuncClose(bool Value)
        {
            Console.WriteLine("бам");
        }
        public void UseIFunctional()
        {
            Console.WriteLine("бам");
        }
    }
    public class CentralServer
    {
        public ConfigCatalog configcatalog = new ConfigCatalog(); //композиция
        public SubServer []boards; //агрегация
   
        public void UseIPlugin(IPlugin p) // зависимость: изменения в IPlugin могут повлечь изменения в CentralServer
        {
            p.UseIPlugin();
        }
        public void UseIFunctional(IFunctional f) //зависимость, аналогично
        {
            f.UseIFunctional();
        }
    }

    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
        }
    }
}