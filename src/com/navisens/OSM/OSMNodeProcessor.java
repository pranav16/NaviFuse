package com.navisens.OSM;

import java.util.ArrayList;
import java.util.HashMap;

public class OSMNodeProcessor {

	private HashMap<Long, Ways> waysMap;
	private HashMap<Long, Node> nodesMap;
	private HashMap<Long, Relation> relationMap;

	public OSMNodeProcessor() {
		super();
		waysMap = new HashMap<Long, Ways>();
		nodesMap = new HashMap<Long, Node>();
		relationMap = new HashMap<Long, Relation>();
	}

	public OSMCustomResponse ProcessData(final OSMBBResponse i_osm) {
		populateMap(i_osm);
		OSMCustomResponse response = null;
		ArrayList<Buildings> buildings = new ArrayList<Buildings>();
		ArrayList<Streets> streets = new ArrayList<Streets>();
		for (Relation relation : i_osm.getOsm().getRelation()) {
			boolean isBuilding = false;
			ArrayList<CompositeNode> compNodesList = new ArrayList<CompositeNode>();
			for (Tags tag : relation.getTag()) {

				if (tag.getK().equalsIgnoreCase("building")) {
					isBuilding = true;
				}
				for (Memebers member : relation.getMember()) {

					Ways way = waysMap.get(member.getRef());
					if (way != null) {
						ArrayList<Node> nodeList = new ArrayList<Node>();
						for (ND nd : way.getNd()) {
							Node node = nodesMap.get(nd.getRef());
							nodeList.add(node);
						}
						CompositeNode compNode = new CompositeNode();
						compNode.setVisible(way.isVisible());
						compNode.setNodeTags(way.getTag());
						compNode.setNodes(nodeList);
						compNode.setRole(member.getRole());
						compNode.setType(member.getType());
						compNodesList.add(compNode);
					}
					Relation rel = relationMap.get(member.getRef());
					if (rel != null) {
						ArrayList<Node> nodeList = new ArrayList<Node>();
						Node node = new Node();
						node.setId(rel.getId());
						nodeList.add(node);
						CompositeNode compNode = new CompositeNode();
						compNode.setVisible(false);
						compNode.setNodeTags(rel.getTag());
						compNode.setNodes(nodeList);
						compNode.setRole(member.getRole());
						compNode.setType(member.getType());
						compNodesList.add(compNode);
					}
				}
			}

			if (isBuilding) {
				Buildings building = new Buildings();
				building.setNodes(compNodesList);
				building.setVisibile(relation.isVisible());
				building.setTags(relation.getTag());
				building.setId(relation.getId());
				buildings.add(building);
			} else {
				Streets street = new Streets();
				street.setNodes(compNodesList);
				street.setVisibile(relation.isVisible());
				street.setTags(relation.getTag());
				street.setId(relation.getId());
				streets.add(street);

			}
		}
		for (Ways way : i_osm.getOsm().getWay()) {
			if(way.getTag() == null)
				continue;
			for (Tags tag : way.getTag()) {
				if (tag.getK().equalsIgnoreCase("building")) {
					ArrayList<Node> nodeList = new ArrayList<Node>();
					for (ND nd : way.getNd()) {
						Node node = nodesMap.get(nd.getRef());
						nodeList.add(node);
					}
					ArrayList<CompositeNode> compNodesList = new ArrayList<CompositeNode>();
					CompositeNode compNode = new CompositeNode();
					compNode.setVisible(way.isVisible());
					compNode.setNodeTags(way.getTag());
					compNode.setNodes(nodeList);
					compNodesList.add(compNode);
					Buildings building = new Buildings();
					building.setNodes(compNodesList);
					building.setVisibile(way.isVisible());
					building.setId(way.getId());
					buildings.add(building);
				}
			}
		}
		response = new OSMCustomResponse();
		response.setBuildings(buildings);
		response.setStreets(streets);
		return response;
	}

	public void populateMap(final OSMBBResponse i_osm) {
		for (Ways way : i_osm.getOsm().getWay()) {
			waysMap.put(way.getId(), way);
		}
		for (Node node : i_osm.getOsm().getNodes()) {
			nodesMap.put(node.getId(), node);
		}

		for (Relation rel : i_osm.getOsm().getRelation()) {
			relationMap.put(rel.getId(), rel);
		}

	}

}
