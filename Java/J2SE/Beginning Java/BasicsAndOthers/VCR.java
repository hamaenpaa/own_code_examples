public class VCR implements RemoteControl
{
	public VCR(String make)
	{
		this.make = make;
	}
	
	public boolean powerOnOff()
	{
		power = !power;
		System.out.println(make + " VCR power "
			+ (power ? "on." : "off."));
		return power;
	}
	
	public int volumeUp(int increment)
	{
		if (!power)	
		{
			return 0; // If the power is off, nothing works
		}
		
		// Set volume - must not be greater than the maximum
		volume = volume + increment > MAX_VOLUME ? MAX_VOLUME : 
			volume + increment;
		System.out.println(make + " VCR volume level: "
			+ volume);
		return volume;			
	}

	public int volumeDown(int decrement)
	{
		if (!power)	
		{
			return 0; // If the power is off, nothing works
		}
		
		// Set volume - must not be less than the minimum
		volume = volume - decrement < MIN_VOLUME ? MIN_VOLUME : 
			volume - decrement;
		System.out.println(make + " VCR volume level: "
			+ volume);
		return volume;			
	}
	
	public void mute()
	{
		if (!power)	
		{
			return; // If the power is off, nothing works
		}
		
		volume = MIN_VOLUME;
		System.out.println(make + " VCR volume level: "
			+ volume);
	}	
	
	public int setChannel(int newChannel)
	{
		if (!power)	
		{
			return 0; // If the power is off, nothing works
		}
		
		// Channel must be from MIN_CHANNEL to MAX_CHANNEL
		if (newChannel >= MIN_CHANNEL && newChannel <= MAX_CHANNEL)
		{
			channel = newChannel;
		}
		System.out.println(make + " VCR tuned to channel: "
			+ channel);
		return channel;
	}
	
	public int channelUp()
	{
		if (!power)	
		{
			return 0; // If the power is off, nothing works
		}
		
		// Wrap channel up to MIN_CHANNEL when MAX_CHANNEL is reached
		channel = channel < MAX_CHANNEL ? ++channel : MIN_CHANNEL;
		System.out.println(make + " VCR tuned to channel: "
			+ channel);
		return channel;
	}
	
	public int channelDown()
	{
		if (!power)	
		{
			return 0; // If the power is off, nothing works
		}
		
		// Wrap channel down to MAX_CHANNEL when MIN_CHANNEL is reached
		channel = channel > MIN_CHANNEL ? --channel : MAX_CHANNEL;
		System.out.println(make + " VCR tuned to channel: "
			+ channel);
		return channel;
	}
	
	private String make = null; 
	private boolean power = false;
	
	private int MIN_VOLUME = 0;
	private int MAX_VOLUME = 100;
	private int volume = MIN_VOLUME;
	
	private int MIN_CHANNEL = 0;
	private int MAX_CHANNEL = 99;
	private int channel = MIN_CHANNEL;
}