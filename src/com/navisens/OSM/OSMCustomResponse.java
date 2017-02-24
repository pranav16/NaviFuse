package com.navisens.OSM;

import java.util.ArrayList;

public class OSMCustomResponse {

	private ArrayList<Buildings> buildings;
	private ArrayList<Streets> streets;

	public ArrayList<Buildings> getBuildings() {
		return buildings;
	}

	public void setBuildings(ArrayList<Buildings> building) {
		this.buildings = building;
	}

	public ArrayList<Streets> getStreets() {
		return streets;
	}

	public void setStreets(ArrayList<Streets> streets) {
		this.streets = streets;
	}

}

class CompositeNode {
	private ArrayList<Node> nodes;
	private String role;
	private String type;
	private ArrayList<Tags> nodetags;
	private boolean visible;

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Tags> getNodeTags() {
		return nodetags;
	}

	public void setNodeTags(ArrayList<Tags> nodeTags) {
		this.nodetags = nodeTags;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}

class Buildings {

	private ArrayList<CompositeNode> nodes;
	private ArrayList<Tags> tags;
	private long id;
	private boolean visibile;

	public ArrayList<CompositeNode> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<CompositeNode> nodes) {
		this.nodes = nodes;
	}

	public ArrayList<Tags> getTags() {
		return tags;
	}

	public void setTags(ArrayList<Tags> tags) {
		this.tags = tags;
	}

	public boolean isVisibile() {
		return visibile;
	}

	public void setVisibile(boolean visibile) {
		this.visibile = visibile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}

class Streets {

	private ArrayList<Tags> tags;
	private long id;
	private ArrayList<CompositeNode> nodes;
	private boolean visibile;

	public ArrayList<Tags> getTags() {
		return tags;
	}

	public void setTags(ArrayList<Tags> tags) {
		this.tags = tags;
	}

	public ArrayList<CompositeNode> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<CompositeNode> nodes) {
		this.nodes = nodes;
	}

	public boolean isVisibile() {
		return visibile;
	}

	public void setVisibile(boolean visibile) {
		this.visibile = visibile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
