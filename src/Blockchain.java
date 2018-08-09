import java.util.ArrayList;
import java.util.List;

public class Blockchain {

	private List<Block> chain;
	
	public Blockchain() {
		chain = new ArrayList<Block>();
		chain.add(startup());
	}
	
	private Block startup() {
		Block block0 = new Block("Ethereal0", new java.util.Date(), "<transactions>");
		block0.setPreviousHash(null);
		block0.computeHash();
		return block0;
	}
	
	public void addBlock(Block blk) {
		Block newBlock = blk;
		newBlock.setPreviousHash(chain.get(chain.size()-1).getHash());
		newBlock.computeHash();
		this.chain.add(newBlock);
	}
	
	public void displayChain() {
		
		for(int i=0; i<chain.size(); i++) {
			System.out.println("Block: " + i);
			System.out.println("Time: " + chain.get(i).getTime());
			System.out.println("PreviousHash: " + chain.get(i).getPreviousHash());
			System.out.println("Hash: " + chain.get(i).getHash());
			System.out.println();
		}
		
	}
	
	public Block getLatestBlock() {
		return this.chain.get(chain.size()-1);
	}
	
	public void isValid() {
		
		for(int i=chain.size()-1; i>0; i--) {
			if(   !(chain.get(i).getHash().equals(chain.get(i).computeHash()))   ) {
				System.out.println("WARNING! Chain is invalid!");
				return;
			}
			
			if(  !(chain.get(i).getPreviousHash().equals(chain.get(i-1).computeHash()))  ) {
				System.out.println("WARNING! Chain is invalid!");
				return;
			}
		}
		
		System.out.println("Chain is valid.");
		
	}
	
	
}