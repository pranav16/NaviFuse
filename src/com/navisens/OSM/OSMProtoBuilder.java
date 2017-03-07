package com.navisens.OSM;

import com.navisens.LocationServicesProtos;

public class OSMProtoBuilder {

	public static LocationServicesProtos.FusionResponse.OSMBody buildOSMBody(final OSMCustomResponse resp) {

		LocationServicesProtos.FusionResponse.OSMBody.Builder builder = LocationServicesProtos.FusionResponse.OSMBody
				.newBuilder();
		for (Buildings building : resp.getBuildings()) {
			LocationServicesProtos.FusionResponse.OSMBody.Buildings.Builder buildingBuilder = LocationServicesProtos.FusionResponse.OSMBody.Buildings
					.newBuilder();
			buildingBuilder.setId(building.getId());
			buildingBuilder.setVisibile(building.isVisibile());
			if(building.getTags() != null)
			for (Tags tag : building.getTags()) {
				LocationServicesProtos.FusionResponse.Tags.Builder tagBuilder = LocationServicesProtos.FusionResponse.Tags
						.newBuilder();
				tagBuilder.setK(tag.getK());
				tagBuilder.setV(tag.getV());
				buildingBuilder.addTags(tagBuilder.build());
			}
			for (CompositeNode cNode : building.getNodes()) {
				LocationServicesProtos.FusionResponse.CompositeNode.Builder cBuilder = LocationServicesProtos.FusionResponse.CompositeNode
						.newBuilder();
				if(cNode.getRole() != null)
					cBuilder.setRole(cNode.getRole());
				if(cNode.getType() != null)
					cBuilder.setType(cNode.getType());
				if(cNode.getType() != null)
				for (Tags tag : building.getTags()) {
					LocationServicesProtos.FusionResponse.Tags.Builder tagBuilder = LocationServicesProtos.FusionResponse.Tags
							.newBuilder();
					tagBuilder.setK(tag.getK());
					tagBuilder.setV(tag.getV());
					cBuilder.addTag(tagBuilder.build());
				}
				for (Node node : cNode.getNodes()) {
					LocationServicesProtos.FusionResponse.Node.Builder nBuilder = LocationServicesProtos.FusionResponse.Node
							.newBuilder();
					nBuilder.setId(node.getId());
					nBuilder.setLat(node.getLat());
					nBuilder.setLon(node.getLon());
					nBuilder.setTimestamp(node.getTimestamp());
					nBuilder.setUid(node.getUid());
					nBuilder.setChangeset(node.getChangeset());
					nBuilder.setUser(node.getUser());
					nBuilder.setVersion(node.getVersion());
					nBuilder.setVisible(node.isVisibile());
					cBuilder.addNodes(nBuilder.build());
				}

				buildingBuilder.addNodes(cBuilder.build());
				builder.addBuilding(buildingBuilder.build());
				
			}

		}
		
		for (Streets street : resp.getStreets()) {
			LocationServicesProtos.FusionResponse.OSMBody.Streets.Builder streetBuilder = LocationServicesProtos.FusionResponse.OSMBody.Streets
					.newBuilder();
			streetBuilder.setId(street.getId());
			streetBuilder.setVisibile(street.isVisibile());
			
			for (Tags tag : street.getTags()) {
				LocationServicesProtos.FusionResponse.Tags.Builder tagBuilder = LocationServicesProtos.FusionResponse.Tags
						.newBuilder();
				tagBuilder.setK(tag.getK());
				tagBuilder.setV(tag.getV());
				streetBuilder.addTags(tagBuilder.build());
				
			}
			for (CompositeNode cNode : street.getNodes()) {
				LocationServicesProtos.FusionResponse.CompositeNode.Builder cBuilder = LocationServicesProtos.FusionResponse.CompositeNode
						.newBuilder();
				cBuilder.setRole(cNode.getRole());
				cBuilder.setType(cNode.getType());
				for (Tags tag : street.getTags()) {
					LocationServicesProtos.FusionResponse.Tags.Builder tagBuilder = LocationServicesProtos.FusionResponse.Tags
							.newBuilder();
					tagBuilder.setK(tag.getK());
					tagBuilder.setV(tag.getV());
					cBuilder.addTag(tagBuilder.build());
				}
				for (Node node : cNode.getNodes()) {
					LocationServicesProtos.FusionResponse.Node.Builder nBuilder = LocationServicesProtos.FusionResponse.Node
							.newBuilder();
					nBuilder.setId(node.getId());
					nBuilder.setLat(node.getLat());
					nBuilder.setLon(node.getLon());
					if(node.getTimestamp() != null)
					nBuilder.setTimestamp(node.getTimestamp());
					nBuilder.setUid(node.getUid());
					nBuilder.setChangeset(node.getChangeset());
					if(node.getTimestamp() != null)
					nBuilder.setUser(node.getUser());
					nBuilder.setVersion(node.getVersion());
					nBuilder.setVisible(node.isVisibile());
					cBuilder.addNodes(nBuilder.build());
				}

				streetBuilder.addNodes(cBuilder.build());
				builder.addStreet(streetBuilder.build());
			}
		}

		return builder.build();
	}

}
