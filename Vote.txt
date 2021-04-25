package voting;

public class Vote {
private String name;
private String Egn;
private int vote;
Vote(String name,String Egn,int vote)
{
	this.name=name;
	this.Egn=Egn;
	this.vote=vote;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEgn() {
	return Egn;
}
public void setEgn(String egn) {
	Egn = egn;
}
public int getVote() {
	return vote;
}
public void setVote(int vote) {
	this.vote = vote;
}

}
