public class Node {
		public String data;
		Node left, right;
		boolean nextStep;

		Node(String data) {
			this.data = data;
			this.left = null;
			this.right = null;
			this.nextStep = false;
		}
		
		/**
		 * Method to return the left node from one that is given
		 * @return a Node directly to the left
		 */
		public Node getNodeLeft() {
			if (this.left != null) {
				return this.left;
			} else {
				if(this.nextStep) {
					return null;
					
				} else 
					return null;
			}
		}	
		
		/**
		 * Method to return the right node from one that is given
		 * @return a Node directly to the right
		 */
		public Node getNodeRight() {
			if (this.right != null) {
				return this.right;
			} else {
				if(this.nextStep) {
					return null;
					
				} else 
					return null;
			}
		}	
		
		/**
		 * A method to return the data of a node
		 * @return a String containing the data of the Node
		 */
		public String getNodeData() {
			return this.data;
		}	
		
		/**
		 * A method that returns a true or false depending on whether the Node has another Node connecting
		 * @return true or false depending on whether it has a next Step
		 */
		public boolean getNodeNextStep() {
			return this.nextStep;
		}

	}