package com.mygdx.theafrica;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class Level {



    public ArrayList<Layer>Layers;

    public ArrayList<GameObject> toRemove;
    public ArrayList<GameObject> toAdd;

    public float currentTime;

    public Level(GameObject bg)
    {
        Layers = new ArrayList<Layer>();
        Layers.add(new Layer(Layer.LayerNames.BACKGROUND)); //0 BG
        Layers.add(new Layer(Layer.LayerNames.PLAYER));     //1 PLAYER
        Layers.add(new Layer(Layer.LayerNames.ICONS));      //2 ICONS
        Layers.add(new Layer(Layer.LayerNames.DEFAULT));    //3 DEFAULT

        Layers.get(0).list.add(bg);
        spawnPlayers();

        toRemove = new ArrayList<GameObject>();
        toAdd = new ArrayList<GameObject>();
        currentTime = 0f;




    }

    void spawnPlayers()
    {
        Layers.get(1).list.add(new Player(0,0, 1));//REPLACE THESE POSITION LATER WITH EACH PLAYER'S BOX FOR PLAYERS IN THE BASE CARDS
        Layers.get(1).list.add(new Player(0,0, 1));
        Layers.get(1).list.add(new Player(0,0, 1));

        Layers.get(1).list.add(new Player(0,0, 2));
        Layers.get(1).list.add(new Player(0f,0, 2));
        Layers.get(1).list.add(new Player(0,0, 2));

    }

    public void update(float delta)
    {
        currentTime += delta;

        updateLists(delta);
        removeGos();
        addGos();
    }

    void updateLists(float delta)
    {

        for(int i = 0; i<Layers.size(); i++)
        {
            for(int j = 0; j<Layers.get(i).list.size(); j++)
            {
                Layers.get(i).list.get(j).update(delta);
            }
        }
    }

    void addGos()
    {
        for(int i = 0; i<toAdd.size(); i++)
        {
            for(Layer L:Layers)
            {
                if(L.name == toAdd.get(i).layerTag)
                {
                    L.list.add((toAdd.get(i)));
                }
            }
        }

        toAdd.clear();
    }

    void removeGos()
    {
        for(int i = toRemove.size()-1; i>=0; i--)
        {
            for(Layer L:Layers)
            {
                if(L.name == toRemove.get(i).layerTag)
                {
                    L.list.remove((toRemove.get(i)));
                }
            }
        }
        toRemove.clear();
    }


    ArrayList<GameObject> getLayerList(Layer.LayerNames _name)
    {
        ArrayList<GameObject> goList = null;
        for(Layer L:Layers)
        {
            if(L.name == _name)
            {
                goList = L.list;
            }
        }
        if(goList == null) System.out.println("Oh no the list you want is null! Check your tags or if that list exists.");
        return goList;
    }


    public void Instantiate(GameObject gameObject)//Use this to add a gameObject to the scene
    {
        toAdd.add(gameObject);
        //Center new object:
        toAdd.get(toAdd.size()-1).position = new Vector2(toAdd.get(toAdd.size()-1).position.x-toAdd.get(toAdd.size()-1).width/2,
                                                         toAdd.get(toAdd.size()-1).position.y-toAdd.get(toAdd.size()-1).width/2);
    }

    public void Despawn(GameObject gameObject)//Use this to remove a gameObject from the scene
    {
        toRemove.add(gameObject);
    }

    void centerObject(ArrayList<GameObject> arr, int index)
    {

        if(index < arr.size())
        {
            arr.get(index).position = new Vector2(arr.get(index).position.x-arr.get(index).width/2,arr.get(index).position.y-arr.get(index).width/2);
        }
        else
            System.out.println("The index is out of bounds");
    }

    public GameObject getPlayer()
    {
        GameObject go = null;
        for (Layer L: Layers)
        {
            if(L.name == Layer.LayerNames.PLAYER)
            {
                go = L.list.get(0);
            }
        }
        if(go==null) System.out.println("There is no player object");
        return go;
    }
    public GameObject getBg()
    {
        GameObject go = null;
        for (Layer L: Layers)
        {
            if(L.name == Layer.LayerNames.BACKGROUND)
            {
                go = L.list.get(0);
            }
        }
        if(go==null) System.out.println("There is no background object");
        return go;
    }

}
