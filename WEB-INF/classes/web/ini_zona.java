package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_zona extends GXProcedure
{
   public ini_zona( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_zona.class ), "" );
   }

   public ini_zona( int remoteHandle ,
                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Almirante Brown", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Avellaneda", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Berazategui", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Berisso", ""), "03") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Cañuelas", ""), "03") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Carmen de Patagones", ""), "04") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Ensenada", ""), "03") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Escobar", ""), "03") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Estevan Echeverria", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Florencio Varela", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Gral. Rodriguez", ""), "03") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Gral. San Martín", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Gral. Sarmiento", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Gran Buenos Aires", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - La Matanza", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - La Plata", ""), "03") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Lanús", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Lomas de Zamora", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Marcos Paz", ""), "03") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Merlo", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Moreno", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Morón", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Patagones", ""), "05") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Pilar", ""), "03") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Quilmes", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Resto de la Provincia", ""), "07") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - San Fernando", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - San Isidro", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - San Vicente", ""), "03") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Tigre", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Tres de Febrero", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Vicente Lopez", ""), "02") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Buenos Aires - Villarino", ""), "06") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Ciudad autónoma de Buenos Aires", ""), "01") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Catamarca", ""), "09") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Catamarca - Gran Catamarca", ""), "08") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Chaco", ""), "27") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Chaco - Gran Resistencia", ""), "26") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Chubut", ""), "29") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Chubut - Rawson", ""), "28") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Chubut - Trelew", ""), "28") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Córdoba - Cruz del Eje", ""), "13") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Córdoba - Gran Córdoba", ""), "18") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Córdoba - Minas", ""), "14") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Córdoba - Pocho", ""), "15") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Córdoba - Resto de la Provincia", ""), "19") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Córdoba - Río Seco", ""), "11") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Córdoba - San Alberto", ""), "16") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Córdoba - San Javier", ""), "17") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Córdoba - Sobremonte", ""), "10") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Córdoba - Tulumba", ""), "12") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Corrientes - Ciudad de Corriente", ""), "24") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Corrientes - Curuzú-Cuatia", ""), "22") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Corrientes - Esquina", ""), "20") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Corrientes - Monte Caseros", ""), "23") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Corrientes - Resto de la Provincia", ""), "25") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Corrientes - Sauce", ""), "21") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Entre Ríos - Federación", ""), "30") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Entre Ríos - Feliciano", ""), "31") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Entre Ríos - Paraná", ""), "32") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Entre Ríos - Resto de la Provincia", ""), "33") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Formosa", ""), "35") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Formosa - Ciudad de Formosa", ""), "34") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Jujuy", ""), "37") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Jujuy - Ciudad de Jujuy", ""), "36") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "La Pampa - Chalileo", ""), "39") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "La Pampa - Chical-Co", ""), "38") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "La Pampa - Limay-Mahuilda", ""), "41") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "La Pampa - Puelén", ""), "40") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "La Pampa - Curaco", ""), "42") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "La Pampa - Lihuel - Calel", ""), "43") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "La Pampa - Resto de la Provincia", ""), "45") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "La Pampa - Santa Rosa", ""), "44") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "La Pampa - Toay", ""), "44") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "La Rioja", ""), "47") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "La Rioja - Ciudad de La Rioja", ""), "46") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza", ""), "49") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Gran Mendoza", ""), "48") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Misiones", ""), "51") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Misiones - Posadas", ""), "50") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Neuquén", ""), "56") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Neuquén - Centenario", ""), "53") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Neuquén - Ciudad de Neuquén", ""), "52") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Neuquén - Cutral-Co", ""), "54") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Neuquén - Plaza Huincul", ""), "55") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Neuquén - Plottier", ""), "52") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Río Negro - Alejando Stefenelli", ""), "59") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Río Negro - Alto Valle", ""), "59") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Río Negro - Allen", ""), "59") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Río Negro - Cervantes", ""), "59") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Río Negro - Chichinales", ""), "59") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Río Negro - Cinco Saltos", ""), "59") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Río Negro - Cipoletti", ""), "59") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Río Negro - Contralmirante Cordero", ""), "59") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Río Negro - Coronel Juan J. Gómez", ""), "59") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Río Negro - Fernández Oro", ""), "59") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Río Negro - Gral. Enrique Godoy", ""), "59") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Río Negro - Gral. Roca", ""), "59") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Río Negro - Ing. L. A. Huergo", ""), "59") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Río Negro - Mainque", ""), "59") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Río Negro - Viedma", ""), "58") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Río Negro - Villa Regina", ""), "59") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Río Negro - Zona N1", ""), "60") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Río Negro - Zona N2", ""), "57") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Salta", ""), "62") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Salta - Gran Salta", ""), "61") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "San Juan", ""), "64") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "San Juan - Gran San Juan", ""), "63") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "San Luis", ""), "66") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "San Luis - Ciudad de San Luis", ""), "65") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Santa Cruz", ""), "69") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Santa Cruz - Caleta Olivia", ""), "67") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Santa Cruz - Río Gallegos", ""), "68") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Santa Fe - 9 de Julio", ""), "73") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Santa Fe - Gral. Obligado", ""), "70") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Santa Fe - Resto de la Provincia", ""), "75") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Santa Fe - San Javier", ""), "71") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Santa Fe - Santo Tome", ""), "72") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Santa Fe - Vera", ""), "74") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Santiago del Estero - Cdad. de Santiago del Estero", ""), "76") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Santiago del Estero - La Banda", ""), "76") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Santiago del Estero - Ojo de Agua", ""), "77") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Santiago del Estero - Quebrachos", ""), "78") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Santiago del Estero - Resto de la Provincia", ""), "80") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Santiago del Estero - Rivadavia", ""), "79") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Tierra del Fuego", ""), "83") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Tierra del Fuego - Río Grande", ""), "81") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Tierra del Fuego - Ushuaia", ""), "82") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Tucumán", ""), "85") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Tucumán - Gran Tucumán", ""), "84") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Identifica trabajador siniestrado hasta V 9.3", ""), "86") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Formosa - Bermejo", ""), "87") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Formosa - Ramón Lista", ""), "88") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Formosa - Mataco", ""), "89") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Las Heras - Las Cuevas", ""), "90") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Resto Las Heras", ""), "91") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Luján de Cuyo - Potrerillos", ""), "92") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Luján de Cuyo - Carrizal", ""), "93") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Luján de Cuyo - Agrelo", ""), "94") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Luján de Cuyo - Ugarteche", ""), "95") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Luján de Cuyo - Perdriel", ""), "96") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Luján de Cuyo - Las Compuertas", ""), "97") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Resto Distritos Luján de Cuyo", ""), "98") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Tupungato - Santa Clara", ""), "99") ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Tupungato - Zapata", ""), httpContext.getMessage( "A0", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Tupungato - San José", ""), httpContext.getMessage( "A1", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Tupungato - Anchoris", ""), httpContext.getMessage( "A2", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Resto Distritos Tupungato", ""), httpContext.getMessage( "A3", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Tunuyán - Los Arboles", ""), httpContext.getMessage( "A4", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Tunuyán - Los Chacayes", ""), httpContext.getMessage( "A5", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Tunuyán - Campos de los Andes", ""), httpContext.getMessage( "A6", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Resto Distritos Tunuyán", ""), httpContext.getMessage( "A7", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - San Carlos - Pareditas", ""), httpContext.getMessage( "A8", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Resto Distritos San Carlos", ""), httpContext.getMessage( "A9", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - San Rafael - Cuadro Venegas", ""), httpContext.getMessage( "B0", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Resto Distritos San Rafael", ""), httpContext.getMessage( "B1", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Malargue - Malargue", ""), httpContext.getMessage( "B2", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Malargue - Río Grande", ""), httpContext.getMessage( "B3", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Malargue - Río Barrancas", ""), httpContext.getMessage( "B4", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Malargue - Agua Escondida", ""), httpContext.getMessage( "B5", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Resto Distritos Malargue", ""), httpContext.getMessage( "B6", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Maipu - Russell", ""), httpContext.getMessage( "B7", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Maipu - Cruz de Piedra", ""), httpContext.getMessage( "B8", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Maipu - Lumlunta", ""), httpContext.getMessage( "B9", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Maipú - Las Barrancas", ""), httpContext.getMessage( "C0", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza. Resto Distritos Maipú", ""), httpContext.getMessage( "C1", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza. Rivadavia - El Mirador", ""), httpContext.getMessage( "C2", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza. Rivadavia - Los Campamentos", ""), httpContext.getMessage( "C3", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza. Rivadavia - Los Arboles", ""), httpContext.getMessage( "C4", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza. Rivadavia - Reducción", ""), httpContext.getMessage( "C5", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza. Rivadavia - Medrano", ""), httpContext.getMessage( "C6", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Mendoza - Resto Distritos Rivadavia", ""), httpContext.getMessage( "C7", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Salta - Oran - San Ramón de la Nueva Oran y su ejidourbano", ""), httpContext.getMessage( "C8", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Salta - Resto Distritos Oran", ""), httpContext.getMessage( "C9", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Salta - Los Andes", ""), httpContext.getMessage( "D0", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Salta - Santa Victoria", ""), httpContext.getMessage( "D1", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Salta - Rivadavia", ""), httpContext.getMessage( "D2", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Salta - Gral San Martín - Tartagal y su ejido urbano", ""), httpContext.getMessage( "D3", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Salta - Resto Distritos Gral. San Martín", ""), httpContext.getMessage( "D4", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Catamarca - Antofagasta de la Sierra Actividad Minera", ""), httpContext.getMessage( "D5", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Catamarca - Antofagasta de la Sierra Resto Actividades", ""), httpContext.getMessage( "D6", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Jujuy - Cochinoca", ""), httpContext.getMessage( "D7", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Jujuy - Humahuaca", ""), httpContext.getMessage( "D8", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Jujuy - Rinconada", ""), httpContext.getMessage( "D9", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Jujuy - Santa Catalina", ""), httpContext.getMessage( "E0", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Jujuy - Susques", ""), httpContext.getMessage( "E1", "")) ;
      new web.new_zona(remoteHandle, context).execute( httpContext.getMessage( "Jujuy - Yavi", ""), httpContext.getMessage( "E2", "")) ;
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
}

