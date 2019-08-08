import java.io.Serializable;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.util.LinkedList;

public class Handler
{
   LinkedList<GameObject> list = new LinkedList<GameObject>();

   public void tick()
   {
      for(int i = 0; i < list.size(); i++)
      {
	 GameObject object = list.get(i);
	 object.tick();
      }
   }

   public void render(Graphics g)
   {
      for(int i = 0; i < list.size(); i++)
      {
	 GameObject object = list.get(i);
	 object.render(g);
      }
   }

   public void addObject(GameObject object)
   {
      list.add(object);
   }

   public void removeObject(GameObject object)
   {
      list.remove(object);
   }

   public void clearEnemies()
   {
      for(int i = 0; i < list.size(); i++)
      {
	 GameObject object = list.get(i);

	 switch(object.getID())
	 {
	    case BasicEnemy:
	    case FastEnemy:
	    case SmartEnemy:
	    case SmartBossEnemy:
	    case BossEnemy:
	       list.remove(object);
	       i--;
	       break;
	    default:
	       break;
	 }
      }
   }
   public void removePlayer()
   {
      for(int i = 0; i < list.size(); i++)
      {
	 GameObject object = list.get(i);

	 if(object.getID() == ID.Player)
	 {
	       list.remove(object);
	       i--;
	 }
      }
   }

//	public GameObject getObject(int index)
//	{
//		return list.get(index);
//	}
}
