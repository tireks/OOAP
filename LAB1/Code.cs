using System.Diagnostics;

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
        public void Execute() //реализация метода из IPlugin
        {
            Console.WriteLine("бам");
        }
    }
    public interface IPlugin //реализация: определение интерфейса и его реализация в классе VendorDevice
    {
        public void Execute();
    }
    public interface IFunctional //реализация: определение интерфейса и его реализация в классах SubServer и ConfigCatalog
    {
        public void FuncTurnOn(bool Value);


        public void FuncTurnOff(bool Value);


        public void FuncChangeBrightness(int Value);


        public void FuncOpen(bool Value);


        public void FuncClose(bool Value);


        public void UseIFunctional();


    }
    public class SubServer
    {
        public string Name;

        public SensorReading[] sensorreading; //агрегация
        public ControlSwitch[] controlswitch;

        public void ExecuteCommand(ControlSwitch Cswitch, string state)
        {
            string NewState = state;
        }

        public string GetState(string entity)
        {
            return ExecuteCommand.NewState; ;
        }
    }
    public class ConfigCatalog
    {
        public string[] entities;
        public void GetState(string entity)
        {

        }

        public void ChangeState(string entity, string board)
        {

        }
    }
    public class CentralServer
    {
        private ConfigCatalog configcatalog = new ConfigCatalog(); //композиция
        public SubServer[] boards; //агрегация
        /// public ControlSwitch[] switches;
        private Dictionary<string, ControlSwitch> switchDict;
        private Dictionary<string, SensorReading> sensorDict;

        private Dictionary<string, SubServer> boardsDict;

        /////////////////////////////////
        // здесь в дальнейшем появится функция-контроллер которая будет определять какую из следующих функций вызвать, 
        // так же будет передавать в них нужные ентити и борды  
        /////////////////////////////////

        public void handleInputCommand(string entity, string state)
        {
            SubServer board = detectBoard(entity);
            FuncChangeState(entity, board, state);

        }

        private SensorReading EntityToSensor(string entity)
        {
            //не знаю нужно ли тут писать четко реализацию как будет происходить сопоставление и конвертация
            return sensorDict[entity];
        }

        private ControlSwitch EntityToSwitch(string entity)
        {
            //не знаю нужно ли тут писать четко реализацию как будет происходить сопоставление и конвертация
            return switchDict[entity];
        }

        private SubServer detectBoard(string entity)
        {
            return boardsDict[entity];
        }

        private void FuncChangeState(string entity, SubServer board, string state)
        {
            configcatalog.ChangeState(entity, state);
            ControlSwitch Cswitch = EntityToSwitch(entity);
            string NewState;

            do
            {
                try
                {
                    board.ExecuteCommand(Cswitch, state);
                    board.GetState(Cswitch);

                }
                catch (Exception e)
                {

                }
            }
            while ();
        }

        private string CallForState(string entity, SubServer board)
        {
            configcatalog.ChangeState(entity, board.GetState(EntityToSensor(entity)));
        }
        public void UseIPlugin(IPlugin p) // зависимость: изменения в IPlugin могут повлечь изменения в CentralServer
        {
            p.Execute();
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
