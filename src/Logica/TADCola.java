package Logica;

public class TADCola {
	
	private Nodo primero;
	
	public TADCola()
	{
		primero=null;
	}
	
	private Nodo ultimo()
	{
		Nodo pnav=primero;
		while (pnav.getEnlace()!=null)
			pnav = pnav.getEnlace();
		return pnav;
	}
	
	public void acolar(String dato)
	{
		Nodo paux = new Nodo(dato);
		Nodo pult;
		if (primero==null)
			primero=paux;
		else
			{
			 pult = ultimo();
			 pult.setEnlace(paux);
			}
			
	}
	
	public String decolar()
	{	Nodo paux;
		String dato;
		if (primero==null)
			return "*";
		else
		{
			paux = primero;
			primero = primero.getEnlace();
			dato = paux.getDato();
			paux=null;
			System.gc();
			return dato;
			
		}
	}
	
	public String primero()
	{
		if(primero==null)
			return "*";
		else
			return primero.getDato();
	}

}
