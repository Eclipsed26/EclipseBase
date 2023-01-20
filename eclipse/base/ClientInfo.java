package eclipse.base;

public class ClientInfo {

    public String name;
    public String dev;
    public double version;

    public ClientInfo(String name, String dev, double version) { // TODO: Constructor
        this.name = name;
        this.dev = dev;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public String getDev() {
        return dev;
    }

    public double getVersion() {
        return version;
    }
}