import java.util.Map;
import java.util.HashMap;
import org.newdawn.slick.Music;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SlickException;

public class AudioPlayer
{
   private Map<String, Sound> soundMap;
   private Map<String, Music> musicMap;

   public AudioPlayer()
   {
      soundMap = new HashMap<String, Sound>();
      musicMap = new HashMap<String, Music>();

      try
      {
	 soundMap.put("select", new Sound("./sound/Tick.ogg"));
	 musicMap.put("game"  , new Music("./sound/GameBackground.ogg"));
	 musicMap.put("menu"  , new Music("./sound/MenuBackground.ogg"));
      }
      catch (SlickException e){ e.printStackTrace(); }
   }
   public Music getMusic(String key){return musicMap.get(key);}
   public Sound getSound(String key){return soundMap.get(key);}

   public void cleanUp(){soundMap.clear();musicMap.clear();}
}
