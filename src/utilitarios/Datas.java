package utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Datas {

	private String mes, dia, ano, diaSemana,hora;
	SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");

	public void lerHora() {
		Date horaAtual = new Date();
		hora = horaFormat.format(horaAtual);
	}

	public void lerData() {
		Date data = new Date();
		mes = "" + data.getMonth();
		dia = "" + data.getDate();
		ano = "" + (1900 + data.getYear());
		diaSemana = "" + data.getDay();
	}
	
	public String getHora(){
		return hora;
	}

}
