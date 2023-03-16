package week2.day4.tv;

public class TV {
    private String model;
    private int size;
    private int channel;

    public TV() {
    }

    public TV(String model, int size, int channel) {
        this.model = model;
        this.size = size;
        this.channel = channel;
    }

    public void channelUp(){
        this.channel = this.channel + 1;
        if (channel > 10) this.channel = 10;
    }

    public void channelDown(){
        this.channel = this.channel - 1;
        if (channel < 1) this.channel = 10;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }
}
