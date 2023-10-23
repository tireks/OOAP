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
       
        public void UseIPlugin()
        
    }
    public interface IFunctional //реализация: определение интерфейса и его реализация в классах SubServer и ConfigCatalog
    {
        public void FuncTurnOn(bool Value)
       
        public void FuncTurnOff(bool Value)
        
        public void FuncChangeBrightness(int Value)
       
        public void FuncOpen(bool Value)
        
        public void FuncClose(bool Value)
        
        public void UseIFunctional()
       
    }
    public class SubServer
    {
        public string Name;

        public SensorReading []sensorreading; //агрегация
        public ControlSwitch []controlswitch;

        public void ExecuteCommand(ControlSwitch switch, string state){

        }

        public string GetState(SensorReading sensor){

        }

        // public void ObserveConfigCatalog(ConfigCatalog c) // зависимость: изменения в ConfigCatalog могут повлечь изменения в SubServer
        // {
        //     c.GetState();
        // }

        // реализации методов из IFunctional
        // public void FuncTurnOn(bool Value)
        // {
        //     Console.WriteLine("бам");
        // }
        // public void FuncTurnOff(bool Value)
        // {
        //     Console.WriteLine("бам");
        // }
        // public void FuncChangeBrightness(int Value)
        // {
        //     Console.WriteLine("бам");
        // }
        // public void FuncOpen(bool Value)
        // {
        //     Console.WriteLine("бам");
        // }
        // public void FuncClose(bool Value)
        // {
        //     Console.WriteLine("бам");
        // }
        // public void UseIFunctional()
        // {
        //     Console.WriteLine("бам");
        // }
    }
    public class ConfigCatalog
    {
        public string []entities;
        public void GetState(string entity)
        {
            
        }

        public void SwitchState(string entity)
        {
            
        }

        // реализации методов из IFunctional
        // public void FuncTurnOn(bool Value) 
        // {
        //     Console.WriteLine("бам");
        // }
        // public void FuncTurnOff(bool Value)
        // {
        //     Console.WriteLine("бам");
        // }
        // public void FuncChangeBrightness(int Value)
        // {
        //     Console.WriteLine("бам");
        // }
        // public void FuncOpen(bool Value)
        // {
        //     Console.WriteLine("бам");
        // }
        // public void FuncClose(bool Value)
        // {
        //     Console.WriteLine("бам");
        // }
        // public void UseIFunctional()
        // {
        //     Console.WriteLine("бам");
        // }
    }
    public class CentralServer : IFunctional
    {
        private ConfigCatalog configcatalog = new ConfigCatalog(); //композиция
        public SubServer []boards; //агрегация
        private Dictionary<string, ControlSwitch> switchDict
        private Dictionary<string, SensorReading> sensorDict

        private Dictionary<string, SubServer> boardsDict
   
        
        // public void UseIFunctional(IFunctional f) //зависимость, аналогично
        // {
        //     f.UseIFunctional();
        // }

        /////////////////////////////////
        // здесь в дальнейшем появится функция-контроллер которая будет определять какую из следующих функций вызвать, 
        // так же будет передавать в них нужные ентити и борды  
        /////////////////////////////////
        

        private SensorReading EntityToSensor(string entity) {
            //не знаю нужно ли тут писать четко реализацию как будет происходить сопоставление и конвертация
            return sensorDict[entity]
        }

        private ControlSwitch EntityToSwitch(string entity) {
            //не знаю нужно ли тут писать четко реализацию как будет происходить сопоставление и конвертация
            return switchDict[entity]
        }

        private SubServer detectBoard(string entity){
            return boardsDict[entity]
        }

        public void UseIPlugin(IPlugin p) // зависимость: изменения в IPlugin могут повлечь изменения в CentralServer
        {
            p.Execute();
        }

        private void FuncSwitchState(string entity, SubServer board, string state)
        {
            configcatalog.SwitchState(entity, state)
            board.ExecuteCommand(EntityToSwitch(entity), state)
        }
        // private void FuncTurnOff(string entity, SubServer board, string state)
        // {
        //     configcatalog.SwitchState(entity)
        //     board.ExecuteCommand(EntityToSwitch(entity), configcatalog.GetState(entity))
        // }
        // private void FuncChangeBrightness(string entity, SubServer board, string state)
        // {
        //     configcatalog.SwitchState(entity)
        //     board.ExecuteCommand(EntityToSwitch(entity), configcatalog.GetState(entity))
        // }
        // private void FuncOpen(string entity, SubServer board, string state)
        // {
        //     configcatalog.SwitchState(entity)
        //     board.ExecuteCommand(EntityToSwitch(entity), configcatalog.GetState(entity))
        // }
        // private void FuncClose(string entity, SubServer board, string state)
        // {
        //     configcatalog.SwitchState(entity)
        //     board.ExecuteCommand(EntityToSwitch(entity), configcatalog.GetState(entity))
        // }

        private string CallForState(string entity, SubServer board){
            configcatalog.SwitchState(entity,board.GetState(EntityToSensor(entity)))
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
