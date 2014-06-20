package mattparks.mods.space.io;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import mattparks.mods.space.io.client.ClientProxyIo;
import net.minecraft.client.audio.SoundPool;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.client.audio.SoundPoolProtocolHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCIoEvents
{
	@SideOnly(Side.CLIENT)
	@ForgeSubscribe
	public void onSoundLoad(SoundLoadEvent event)
	{  
		ClientProxyIo.newMusic.add(this.func_110654_c(event.manager.soundPoolMusic, GCIo.TEXTURE_PREFIX + "music/Io_Magma.ogg"));
	}

	@SideOnly(Side.CLIENT)
	private SoundPoolEntry func_110654_c(SoundPool pool, String par1Str)
	{
		try
		{
			ResourceLocation resourcelocation = new ResourceLocation(par1Str);
			String s1 = String.format("%s:%s:%s/%s", new Object[] { "mcsounddomain", resourcelocation.getResourceDomain(), "sound", resourcelocation.getResourcePath() });
			SoundPoolProtocolHandler soundpoolprotocolhandler = new SoundPoolProtocolHandler(pool);
			return new SoundPoolEntry(par1Str, new URL((URL) null, s1, soundpoolprotocolhandler));
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	private List<SoundPlayEntry> soundPlayList = new ArrayList<SoundPlayEntry>();

	private static class SoundPlayEntry
	{
		private final String name;
		private final float x;
		private final float y;
		private final float z;
		private final float volume;

		private SoundPlayEntry(String name, float x, float y, float z, float volume)
		{
			this.name = name;
			this.volume = volume;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
