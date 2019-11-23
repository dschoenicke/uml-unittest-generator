package converter.temporary;

import mdxml.MemberEnd;
import mdxml.OwnedEnd;
import uml.UmlRelationship;
import uml.UmlRelationshipType;

public class TemporaryRelationship extends UmlRelationship {

	private String clientId;
	private String supplierId;
	private MemberEnd firstMember;
	private MemberEnd secondMember;
	private OwnedEnd ownedEnd;
	
	public TemporaryRelationship() {
		super();
	}

	public TemporaryRelationship(String clientId, String supplierId, UmlRelationshipType relationshipType) {
		super();
		this.clientId = clientId;
		this.supplierId = supplierId;
		this.setType(relationshipType);
	}
	
	public TemporaryRelationship(MemberEnd firstMember, MemberEnd secondMember) {
		super();
		this.firstMember = firstMember;
		this.secondMember = secondMember;
	}
	
	public TemporaryRelationship(MemberEnd firstMember, MemberEnd secondMember, OwnedEnd ownedEnd) {
		super();
		this.firstMember = firstMember;
		this.secondMember = secondMember;
		this.ownedEnd = ownedEnd;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	
	public MemberEnd getFirstMember() {
		return firstMember;
	}

	public void setFirstMember(MemberEnd firstMember) {
		this.firstMember = firstMember;
	}

	public MemberEnd getSecondMember() {
		return secondMember;
	}

	public void setSecondMember(MemberEnd secondMember) {
		this.secondMember = secondMember;
	}

	public OwnedEnd getOwnedEnd() {
		return ownedEnd;
	}

	public void setOwnedEnd(OwnedEnd ownedEnd) {
		this.ownedEnd = ownedEnd;
	}
}
