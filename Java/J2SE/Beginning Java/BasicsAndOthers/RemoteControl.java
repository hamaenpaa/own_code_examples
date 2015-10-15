public interface RemoteControl
{
	boolean powerOnOff();  		   // Returns new state, on = true
	int volumeUp(int increment);   // Returns new volume level
	int volumeDown(int decrement); // Returns new volume level
	void mute();                   // Mutes sound output
	int setChannel(int channel);   // Set the channel number and return it
	int channelUp();               // Returns new channel number
	int channelDown();             // Returns new channel number
}