package streamingUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Song {
	//Metodo para retornar todas as m�sicas no diret�rio
		public static List<String> getListSong()
		{
			List<String> lista = new ArrayList<String>();    
			String dir = "/media/eduardo/e224e050-3480-44c8-9e3d-1aa15dc39354/eduardo/Música/";
			File diretorio = new File(dir);
			File fList[] = diretorio.listFiles();
			for (int i = 0; i < fList.length; i++) {
				lista.add(fList[i].getName());
			}
			return lista;
		}
}
