public class Test {

	public static void main(String args[]) {
		
		Blockchain etherealCoin = new Blockchain();
		
		Block a = new Block("", new java.util.Date(), "<transactions>");
		Block b = new Block("", new java.util.Date(), "<transactions>");
		Block c = new Block("", new java.util.Date(), "<transactions>");
		
		etherealCoin.addBlock(a);
		etherealCoin.addBlock(b);
		etherealCoin.addBlock(c);
		
		//compromised chain
		//etherealCoin.getLatestBlock().setPreviousHash("GETHACKED");
		
		
		etherealCoin.displayChain();
		
		etherealCoin.isValid();

	}
	
}