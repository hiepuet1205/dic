package dictionary;

import com.sun.speech.freetts.VoiceManager;

public class Speak {
	private final com.sun.speech.freetts.Voice voice;
	public Speak(String name) {
		this.voice = VoiceManager.getInstance().getVoice(name);
		this.voice.allocate();
	}
	public void say(String something){
		this.voice.speak(something);
	}
}
