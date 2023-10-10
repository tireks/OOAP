public abstract class Plugin
    {
        private string name;

        public void GetName()
        {

        }

        void Execute();
    }
    public class FactoryDevice : Plugin // реализация (но плагин должен быть интерфейсом по сути,)
    {
        private string name;
        private int condition;
        private string brand;
        private string ecosystem;

        public void Execute(string command)
        {

        }

    }
    public class Detector
    {
        private string name;
        private int value;

        public void GetValue()
        {

        }
    }
    public class ControlElem
    {
        private string name;
        private int condition;

        public void Execute(string command)
        {

        }
    }
    public class ConfCatalog
    { 
        public void Configure()
        {

        }
    }
    public abstract class SubServer
    {
        Detector detector;
        ControlElem controlElem;

        public SubServer(Detector det, ControlElem contElem)
        {
            detector = det; //агрегация — объекты равноправны, передается лишь ссылка на абстрактный класс Detector
            controlElem = contElem; //агрегация — объекты равноправны, передается лишь ссылка на абстрактный класс ControlElem
        }

        public void useConfCatalog()
        {
            ConfCatalog() c = new ConfCatalog();
            c.Configure();  //зависимость — просто возвращается ConfCatalog

            //return new ConfCatalog(); //зависимость — просто возвращается Plugin
        }
    }
    public class CentralServer
    {
        ConfCatalog catalog;
        SubServer subserver;

        public CentralServer(Subserver subServ)
        {
            catalog = new ConfCatalog();    //композиция — при уничтожении объекта CentralServer будет уничтожен и объект ConfCatalog
            subserver = subServ;   //агрегация — объекты равноправны, передается лишь ссылка на абстрактный класс SubServer
        }

        public void usePlugin()
        {
            Plugin p = new Plugin();
            p.GetName();    //зависимость — возвращается Plugin

            //return new Plugin(); //зависимость — возвращается Plugin
        }

        public void TurnOn(bool amount)
        {

        }
        public void TurnOff(bool amount)
        {

        }
        public void ChangeBrightness(int amount)
        {

        }
        public void Open(bool amount)
        {

        }
        public void Close(bool amount)
        {

        }
    }