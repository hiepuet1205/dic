package dictionary;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class voice {
	private String name;
	private com.sun.speech.freetts.Voice voice;
	public voice(String name) {
		this.name = name;
		this.voice = VoiceManager.getInstance().getVoice(this.name);
		this.voice.allocate();
	}
	public void say(String something){
		this.voice.speak(something);
	}
}
