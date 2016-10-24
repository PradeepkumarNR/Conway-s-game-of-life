package Implementation;

import java.awt.List;
import java.util.*;


public class Board {


	private Set<cell>  cells = new HashSet<>();

	public void addcell(cell cell) {
		cells.add(cell);
	}

	public Set<cell> getNeighbours(cell cell) {
		
		Set<cell> neighborhood=   getneighborHood(cell);
		Set<cell> neighbor= new HashSet<>();
		for (cell c : neighborhood) {
			if(isCellAlive(c)){
				neighbor.add(c);
			}
		}
		
		neighbor.remove(cell);
		return neighbor;
	}

	private Set<cell> getneighborHood(cell cell) {
		Set<cell> neighborhood= new HashSet<>();
		for(int dx=-1;dx <=1;dx++){
			for (int dy=-1; dy<=1;dy++) {
				cell c = new cell(cell.x+dx,cell.y+dy);
				if(isCellAlive(c) && !c.equals(cell)){
					neighborhood.add(c);
				}
			
			}
		}
		return neighborhood;
	}
	

	public boolean isCellAlive(cell c) {
		return cells.contains(c);
	}


}
