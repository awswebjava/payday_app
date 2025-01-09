package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_os extends GXProcedure
{
   public ini_os( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_os.class ), "" );
   }

   public ini_os( int remoteHandle ,
                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtos_sdt_os_sdtItem> executeUdp( int aP0 )
   {
      ini_os.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtos_sdt_os_sdtItem>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<web.Sdtos_sdt_os_sdtItem>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<web.Sdtos_sdt_os_sdtItem>[] aP1 )
   {
      ini_os.this.AV9CliCod = aP0;
      ini_os.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0020-8", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA GRAFICA DE LA PROVINCIA DE CORDOBA", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0030-7", httpContext.getMessage( "OBRA SOCIAL PORTUARIOS ARGENTINOS DE MAR DEL PLATA", ""), httpContext.getMessage( "OSPA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0040-6", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DEL ORGANISMO DE CONTROL EXTERNO", ""), httpContext.getMessage( "OSPOCE", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0050-5", httpContext.getMessage( "OBRA SOCIAL DE CAPITANES, PILOTOS Y PATRONES DE PESCA", ""), httpContext.getMessage( "OSPESCA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0060-4", httpContext.getMessage( "OBRA SOCIAL DE AGENTES DE LOTERIAS Y AFINES DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSALARA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0070-3", httpContext.getMessage( "MUTUAL DEL PERSONAL DEL AGUA Y LA ENERGIA DE MENDOZA", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0090-1", httpContext.getMessage( "OBRA SOCIAL DE LA ACTIVIDAD DE SEGUROS, REASEGUROS, CAPITALIZACION Y AHORRO Y PRESTAMO PARA LA VIVIENDA", ""), httpContext.getMessage( "OSSEG", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0110-2", httpContext.getMessage( "OBRA SOCIAL PARA LA ACTIVIDAD DOCENTE", ""), httpContext.getMessage( "OSPLAD", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0120-1", httpContext.getMessage( "OBRA SOCIAL PARA EL PERSONAL DEL MINISTERIO DE ECONOMIA Y DE OBRAS Y SERVICIOS PUBLICOS", ""), httpContext.getMessage( "OSME", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0130-0", httpContext.getMessage( "OBRA SOCIAL FERROVIARIA", ""), httpContext.getMessage( "OSFE", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0150-8", httpContext.getMessage( "OBRA SOCIAL DE LA ASOCIACION CIVIL PROSINDICATO DE AMAS DE CASA DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSSACRA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0160-7", httpContext.getMessage( "OBRA SOCIAL DEL SINDICATO UNIDO DE TRABAJADORES DE LA INDUSTRIA DE AGUAS GASEOSAS DE LA PROVINCIA DE SANTA FE", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0170-6", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL JERARQUICO DE LA REPUBLICA ARGENTINA PARA EL PERSONAL JERARQUICO DE LA INDUSTRIA GRAFICA Y EL PERSONAL JERARQUICO DEL AGUA Y LA ENERGIA", ""), httpContext.getMessage( "OSJERA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0180-5", httpContext.getMessage( "OBRA SOCIAL DE LOS LEGISLADORES DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSLERA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0190-4", httpContext.getMessage( "OBRA SOCIAL DE LA FEDERACION DE CAMARAS Y CENTROS COMERCIALES ZONALES DE LA REPUBLICA ARGENTINA (FEDECAMARAS)", ""), httpContext.getMessage( "FEDECAMARAS", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0210-5", httpContext.getMessage( "OBRA SOCIAL PROFESIONALES DEL TURF DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSPROTURA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0220-4", httpContext.getMessage( "OBRA SOCIAL DE EMPLEADOS Y PERSONAL JERARQUICO DE LA ACTIVIDAD DEL NEUMATICO ARGENTINO DE NEUMATICOS GOOD YEAR SRL", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0230-3", httpContext.getMessage( "OBRA SOCIAL PARA EL PERSONAL DE EMPRESAS DE LIMPIEZA, SERVICIOS Y MAESTRANZA DE MENDOZA", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0240-2", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL JERARQUICO DEL TRANSPORTE AUTOMOTOR DE PASAJEROS DE CORDOBA Y AFINES", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0250-1", httpContext.getMessage( "OBRA SOCIAL DE MINISTROS, SECRETARIOS Y SUBSECRETARIOS", ""), httpContext.getMessage( "OSMISS", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0260-0", httpContext.getMessage( "OBRA SOCIAL DE LOS TRABAJADORES DE LA CARNE Y AFINES DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "O.S.T.C.A.R.A.", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0270-9", httpContext.getMessage( "OBRA SOCIAL DE LOS TRABAJADORES ASOCIADOS A LA ASOCIACION MUTUAL MERCANTIL ARGENTINA", ""), httpContext.getMessage( "OSTAMMA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0280-8", httpContext.getMessage( "OBRA SOCIAL DE LA CAMARA DE EMPRESARIOS DE AGENCIAS DE REMISES DE ARGENTINA", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0290-7", httpContext.getMessage( "OBRA SOCIAL ASOCIACION MUTUAL METALURGICA VILLA CONSTITUCION", ""), httpContext.getMessage( "OSAMMVC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0300-9", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL ASOCIADO A ASOCIACION MUTUAL SANCOR", ""), httpContext.getMessage( "O.S.PERS.A.A.M.S.", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0310-8", httpContext.getMessage( "OBRA SOCIAL DE LOS INMIGRANTES ESPAÑOLES Y SUS DESCENDIENTES RESIDENTES EN LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSPAÑA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0320-7", httpContext.getMessage( "OBRA SOCIAL DE TRABAJADORES SOCIOS DE LA ASOCIACION MUTUAL DEL PERSONAL JERARQUICO DE BANCOS OFICIALES NACIONALES-JERARQUICOS SALUD-", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0330-6", httpContext.getMessage( "OBRA SOCIAL DE TRABAJADORES VENDEDORES DE DIARIOS REVISTAS Y AFINES", ""), httpContext.getMessage( "OSTVENDRA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0340-5", httpContext.getMessage( "OBRA SOCIAL ASOCIACION MUTUAL DE LOS OBREROS CATOLICOS PADRE FEDERICO GROTE", ""), httpContext.getMessage( "O.S.A.M.O.C", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0350-4", httpContext.getMessage( "OBRA SOCIAL DE CONDUCTORES TITULARES DE TAXIS DE LA CIUDAD AUTONOMA DE BUENOS AIRES", ""), httpContext.getMessage( "O.S.TAX.B.A", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0360-3", httpContext.getMessage( "OBRA SOCIAL PROGRAMAS MEDICOS SOCIEDAD ARGENTINA DE CONSULTORIA MUTUAL", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0370-2", httpContext.getMessage( "OBRA SOCIAL YACIMIENTOS CARBONIFEROS", ""), httpContext.getMessage( "OSYC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0380-1", httpContext.getMessage( "OBRA SOCIAL WITCEL", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "0-0400-2", httpContext.getMessage( "OBRA SOCIAL DE AGENTES DE PROPAGANDA MEDICA DE ROSARIO", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0010-6", httpContext.getMessage( "OBRA SOCIAL PARA EL PERSONAL DE LA INDUSTRIA ACEITERA, DESMOTADORA Y AFINES", ""), httpContext.getMessage( "OSIAD", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0020-5", httpContext.getMessage( "OBRA SOCIAL DE ACTORES", ""), httpContext.getMessage( "OSA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0030-4", httpContext.getMessage( "OBRA SOCIAL DE TECNICOS DE VUELO DE LINEAS AEREAS", ""), httpContext.getMessage( "OSTVLA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0040-3", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL SUPERIOR Y PROFESIONAL DE EMPRESAS AEROCOMERCIALES", ""), httpContext.getMessage( "OSPEA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0050-2", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL AERONAUTICO", ""), httpContext.getMessage( "OSPA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0060-1", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE AERONAVEGACION DE ENTES PRIVADOS", ""), httpContext.getMessage( "OSPADEP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0070-0", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL TECNICO AERONAUTICO", ""), httpContext.getMessage( "OSPTA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0080-9", httpContext.getMessage( "OBRA SOCIAL DE AERONAVEGANTES", ""), httpContext.getMessage( "OSA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0090-8", httpContext.getMessage( "OBRA SOCIAL EMPLEADOS DE AGENCIAS DE INFORMES", ""), httpContext.getMessage( "OSEADI", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0100-0", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE AGUAS GASEOSAS Y AFINES", ""), httpContext.getMessage( "OSPAGA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0110-9", httpContext.getMessage( "OBRA SOCIAL DE ALFAJOREROS, REPOSTEROS, PIZZEROS Y HELADEROS", ""), httpContext.getMessage( "OSARPYH", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0120-8", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA DE LA ALIMENTACION", ""), httpContext.getMessage( "OSPIA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0160-4", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DEL AUTOMOVIL CLUB ARGENTINO", ""), httpContext.getMessage( "OSPACA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0180-2", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DEL AZUCAR DEL INGENIO LA ESPERANZA", ""), httpContext.getMessage( "OSPA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0190-1", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DEL AZUCAR DEL INGENIO LEDESMA", ""), httpContext.getMessage( "OSPAIL", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0230-0", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DEL AZUCAR DEL INGENIO SAN MARTIN", ""), httpContext.getMessage( "OSPA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0270-6", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA AZUCARERA", ""), httpContext.getMessage( "OSPIA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0290-4", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE BARRACAS DE LANAS, CUEROS Y ANEXOS", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0300-6", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA BOTONERA", ""), httpContext.getMessage( "OSPIB", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0310-5", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA DEL CALZADO", ""), httpContext.getMessage( "OSPICAL", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0320-4", httpContext.getMessage( "OBRA SOCIAL DE CONDUCTORES CAMIONEROS Y PERSONAL DEL TRANSPORTE AUTOMOTOR DE CARGAS", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0340-2", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE CARGA Y DESCARGA", ""), httpContext.getMessage( "OSPCYD", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0360-0", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL AUXILIAR DE CASAS PARTICULARES", ""), httpContext.getMessage( "OSPACP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0370-9", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA DEL CAUCHO", ""), httpContext.getMessage( "OSPIC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0380-8", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DEL CAUCHO", ""), httpContext.getMessage( "OSPECA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0390-7", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA DEL CAUCHO DE SANTA FE", ""), httpContext.getMessage( "OSPIC SANTA FE", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0400-9", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE CEMENTERIOS DE LA REPUBLICA ARGENTINA.", ""), httpContext.getMessage( "OSPCRA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0410-8", httpContext.getMessage( "OBRA SOCIAL DE CERAMISTAS", ""), httpContext.getMessage( "OSCE", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0420-7", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA CERAMICA, SANITARIOS, PORCELANA DE MESA Y AFINES", ""), httpContext.getMessage( "OSPCSPMYA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0430-6", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA ACTIVIDAD CERVECERA Y AFINES", ""), httpContext.getMessage( "OSPACA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0440-5", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL CINEMATOGRAFICO DE MAR DEL PLATA", ""), httpContext.getMessage( "OSPERCIN", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0450-4", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA CINEMATOGRAFICA", ""), httpContext.getMessage( "OSPIC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0460-3", httpContext.getMessage( "OBRA SOCIAL DE OPERADORES CINEMATOGRAFICOS", ""), httpContext.getMessage( "OSOC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0480-1", httpContext.getMessage( "OBRA SOCIAL DE COLOCADORES DE AZULEJOS, MOSAICOS, GRANITEROS, LUSTRADORES Y PORCELANEROS", ""), httpContext.getMessage( "OSCAMGLYP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0500-2", httpContext.getMessage( "OBRA SOCIAL DE CONDUCTORES NAVALES", ""), httpContext.getMessage( "OSCONARA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0530-9", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL ADMINISTRATIVO Y TECNICO DE LA CONSTRUCCION Y AFINES", ""), httpContext.getMessage( "OSPATCA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0540-8", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA CONSTRUCCION", ""), httpContext.getMessage( "OSPECON", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0550-7", httpContext.getMessage( "OBRA SOCIAL DE LOS CORTADORES DE LA INDUMENTARIA", ""), httpContext.getMessage( "OSUCI", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0560-6", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA DEL CUERO Y AFINES", ""), httpContext.getMessage( "OSPICA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0570-5", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA DEL CHACINADO Y AFINES", ""), httpContext.getMessage( "OSPICHA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0580-4", httpContext.getMessage( "OBRA SOCIAL DE CHOFERES DE CAMIONES", ""), httpContext.getMessage( "OSCHOCA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0600-5", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE ENTIDADES DEPORTIVAS Y CIVILES", ""), httpContext.getMessage( "OSPEDYC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0610-4", httpContext.getMessage( "OBRA SOCIAL DE EMPLEADOS DE DESPACHANTES DE ADUANA", ""), httpContext.getMessage( "OSEDA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0620-3", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE DISTRIBUIDORAS CINEMATOGRAFICAS DE LA R.A.", ""), httpContext.getMessage( "OSPEDICI", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0630-2", httpContext.getMessage( "OBRA SOCIAL DE DOCENTES PARTICULARES", ""), httpContext.getMessage( "OSDOP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0640-1", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE EDIFICIOS DE RENTA Y HORIZONTAL DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSPERYHRA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0650-0", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE EDIFICIOS DE RENTA Y HORIZONTAL DE LA CIUDAD AUTONOMA DE BUENOS AIRES Y GRAN BUENOS AIRES", ""), httpContext.getMessage( "OSPERYH", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0660-9", httpContext.getMessage( "OBRA SOCIAL ELECTRICISTAS NAVALES", ""), httpContext.getMessage( "OSEN", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0670-8", httpContext.getMessage( "OBRA SOCIAL DE OBREROS EMPACADORES DE FRUTA DE RIO NEGRO Y NEUQUEN", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0680-7", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA ENSEÑANZA PRIVADA", ""), httpContext.getMessage( "OSPEP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0690-6", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE ESCRIBANIAS DE LA PROVINCIA DE BUENOS AIRES", ""), httpContext.getMessage( "OSPEPBA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0700-8", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE ESCRIBANOS", ""), httpContext.getMessage( "OSPE", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0710-7", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DEL ESPECTACULO PUBLICO", ""), httpContext.getMessage( "OSPEP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0720-6", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE ESTACIONES DE SERVICIO, GARAGES, PLAYAS DE ESTACIONAMIENTO Y LAVADEROS AUTOMATICOS", ""), httpContext.getMessage( "OSPESGYPE", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0740-4", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE FARMACIA", ""), httpContext.getMessage( "OSPF", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0780-0", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA DEL FIBROCEMENTO", ""), httpContext.getMessage( "OSPIF", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0790-9", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA FIDEERA", ""), httpContext.getMessage( "OSPIF", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0800-1", httpContext.getMessage( "OBRA SOCIAL PARA EL PERSONAL DE LA INDUSTRIA FORESTAL DE SANTIAGO DEL ESTERO", ""), httpContext.getMessage( "OSPIFSE", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0810-0", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA DEL FOSFORO, ENCENDIDO Y AFINES", ""), httpContext.getMessage( "OSPIF", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0820-9", httpContext.getMessage( "OBRA SOCIAL DE FOTOGRAFOS", ""), httpContext.getMessage( "OSFOT", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0840-7", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA ACTIVIDAD FRUTICOLA", ""), httpContext.getMessage( "OSPAF", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0850-6", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE MANIPULEO, EMPAQUE Y EXPEDICION DE FRUTA FRESCA Y HORTALIZAS DE CUYO", ""), httpContext.getMessage( "OSFYHC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0860-5", httpContext.getMessage( "OBRA SOCIAL DE FUTBOLISTAS", ""), httpContext.getMessage( "FAA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0870-4", httpContext.getMessage( "OBRA SOCIAL DE TECNICOS DE FUTBOL", ""), httpContext.getMessage( "OSTECF", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0880-3", httpContext.getMessage( "OBRA SOCIAL DE LA UNION DE TRABAJADORES DEL TURISMO, HOTELEROS Y GASTRONOMICOS DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSUTHGRA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0900-4", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL GRAFICO", ""), httpContext.getMessage( "OSPG", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0920-2", httpContext.getMessage( "OBRA SOCIAL DE GUINCHEROS Y MAQUINISTAS DE GRUAS MOVILES", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0930-1", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE CONSIGNATARIOS DEL MERCADO NACIONAL DE HACIENDA DE LINIERS", ""), httpContext.getMessage( "OSPEMER", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0940-0", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA DEL HIELO Y MERCADOS PARTICULARES", ""), httpContext.getMessage( "OSPIHMP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0950-9", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LOS HIPODROMOS DE BUENOS AIRES Y SAN ISIDRO", ""), httpContext.getMessage( "OSPHGBAYSI", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0960-8", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL MENSUALIZADO DEL JOCKEY CLUB DE BUENOS AIRES Y LOS HIPODROMOS DE PALERMO Y SAN ISIDRO", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-0970-7", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE IMPRENTA, DIARIOS Y AFINES", ""), httpContext.getMessage( "OSPIDA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1000-8", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE JABONEROS", ""), httpContext.getMessage( "OSPEJ", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1010-7", httpContext.getMessage( "OBRA SOCIAL DE JARDINEROS, PARQUISTAS, VIVERISTAS Y FLORICULTORES DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSJPVYF", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1020-6", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DEL JOCKEY CLUB DE ROSARIO", ""), httpContext.getMessage( "OSPJCR", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1030-5", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL LADRILLERO", ""), httpContext.getMessage( "OSPL", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1040-4", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA LADRILLERA A MAQUINA", ""), httpContext.getMessage( "OSPILM", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1050-3", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA LECHERA", ""), httpContext.getMessage( "OSPIL", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1060-2", httpContext.getMessage( "OBRA SOCIAL DE LOCUTORES", ""), httpContext.getMessage( "OSDEL", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1070-1", httpContext.getMessage( "OBRA SOCIAL DE LA FEDERACION ARGENTINA DE TRABAJADORES DE LUZ Y FUERZA", ""), httpContext.getMessage( "OSFATLYF", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1080-0", httpContext.getMessage( "OBRA SOCIAL DE LOS TRABAJADORES DE LAS EMPRESAS DE ELECTRICIDAD", ""), httpContext.getMessage( "OSTEE", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1090-9", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LUZ Y FUERZA DE CORDOBA", ""), httpContext.getMessage( "OSLYF", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1100-1", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA MADERERA", ""), httpContext.getMessage( "OSPIM", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1120-9", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE MAESTRANZA", ""), httpContext.getMessage( "OSPM", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1130-8", httpContext.getMessage( "OBRA SOCIAL DE MAQUINISTAS DE TEATRO Y TELEVISION", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1140-7", httpContext.getMessage( "OBRA SOCIAL DE CAPITANES DE ULTRAMAR Y OFICIALES DE LA MARINA MERCANTE", ""), httpContext.getMessage( "OSCOMM", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1150-6", httpContext.getMessage( "OBRA SOCIAL DE CAPITANES BAQUEANOS FLUVIALES DE LA MARINA MERCANTE", ""), httpContext.getMessage( "OSCAPBAQFLU", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1160-5", httpContext.getMessage( "OBRA SOCIAL DE EMPLEADOS DE LA MARINA MERCANTE", ""), httpContext.getMessage( "OSEMM", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1170-4", httpContext.getMessage( "OBRA SOCIAL DE ENCARGADOS APUNTADORES MARITIMOS", ""), httpContext.getMessage( "OSEAM", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1180-3", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL MARITIMO", ""), httpContext.getMessage( "OSPM", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1190-2", httpContext.getMessage( "OBRA SOCIAL DEL SINDICATO DE MECANICOS Y AFINES DEL TRANSPORTE AUTOMOTOR", ""), httpContext.getMessage( "OSMATA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1200-4", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL SUPERIOR MERCEDES BENZ ARGENTINA", ""), httpContext.getMessage( "OSPS MERCEDES", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1210-3", httpContext.getMessage( "OBRA SOCIAL DE LA UNION OBRERA METALURGICA DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSUOMRA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1220-2", httpContext.getMessage( "OBRA SOCIAL DE LOS SUPERVISORES DE LA INDUSTRIA METALMECANICA DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSSIMRA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1230-1", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE MICROS Y OMNIBUS DE MENDOZA", ""), httpContext.getMessage( "OSPEMOM", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1240-0", httpContext.getMessage( "OBRA SOCIAL DE LA ACTIVIDAD MINERA", ""), httpContext.getMessage( "O.S.A.M.", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1250-9", httpContext.getMessage( "OBRA SOCIAL MODELOS ARGENTINOS", ""), httpContext.getMessage( "OSMA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1260-8", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA MOLINERA", ""), httpContext.getMessage( "OSPIM", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1270-7", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL MOSAISTA", ""), httpContext.getMessage( "OSPM", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1280-6", httpContext.getMessage( "OBRA SOCIAL DE MUSICOS", ""), httpContext.getMessage( "OSDEM", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1320-5", httpContext.getMessage( "OBRA SOCIAL DE JEFES Y OFICIALES NAVALES DE RADIOCOMUNICACIONES", ""), httpContext.getMessage( "OSJONR", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1330-4", httpContext.getMessage( "OBRA SOCIAL DE JEFES Y OFICIALES MAQUINISTAS NAVALES", ""), httpContext.getMessage( "OSJOMN", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1340-3", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL NAVAL", ""), httpContext.getMessage( "OSPENA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1360-1", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA DEL NEUMATICO", ""), httpContext.getMessage( "OSPIN", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1370-0", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA NAVAL", ""), httpContext.getMessage( "OSPIN", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1380-9", httpContext.getMessage( "OBRA SOCIAL DE COMISARIOS NAVALES", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1390-8", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE PANADERIAS", ""), httpContext.getMessage( "OSPEP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1400-0", httpContext.getMessage( "OBRA SOCIAL DE PANADEROS, PASTELEROS Y FACTUREROS DE ENTRE RIOS", ""), httpContext.getMessage( "OSSPYFER", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1410-9", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DEL PAPEL, CARTON Y QUIMICOS", ""), httpContext.getMessage( "OSPPCYQ", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1420-8", httpContext.getMessage( "OBRA SOCIAL DE LA INDUSTRIA DE PASTAS ALIMENTICIAS", ""), httpContext.getMessage( "OSIPA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1430-7", httpContext.getMessage( "OBRA SOCIAL TRABAJADORES PASTELEROS, CONFITEROS, PIZZEROS , HELADEROS Y ALFAJOREROS DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSTPCHPYARA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1450-5", httpContext.getMessage( "OBRA SOCIAL DE PATRONES DE CABOTAJE DE RIOS Y PUERTOS", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1470-3", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE PELUQUERIAS, ESTETICAS Y AFINES", ""), httpContext.getMessage( "OSPPEA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1490-1", httpContext.getMessage( "OBRA SOCIAL DE OFICIALES PELUQUEROS Y PEINADORES DE ROSARIO", ""), httpContext.getMessage( "OSOFPP DE ROSARIO", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1500-3", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA ACTIVIDAD PERFUMISTA", ""), httpContext.getMessage( "OSPAP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1510-2", httpContext.getMessage( "OBRA SOCIAL DE TRABAJADORES DE PRENSA DE BUENOS AIRES", ""), httpContext.getMessage( "OSTPBA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1520-1", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA DEL PESCADO DE MAR DEL PLATA", ""), httpContext.getMessage( "OSPIP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1530-0", httpContext.getMessage( "OBRA SOCIAL DE PETROLEROS", ""), httpContext.getMessage( "OSPE", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1540-9", httpContext.getMessage( "OBRA SOCIAL DEL PETROLEO Y GAS PRIVADO", ""), httpContext.getMessage( "OSPEGAP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1550-8", httpContext.getMessage( "OBRA SOCIAL DE PETROLEROS DE CORDOBA", ""), httpContext.getMessage( "O.S.PE.COR", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1560-7", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA PETROQUIMICA", ""), httpContext.getMessage( "OSPIP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1570-6", httpContext.getMessage( "OBRA SOCIAL PARA PILOTOS DE LINEAS AEREAS COMERCIALES Y REGULARES", ""), httpContext.getMessage( "OSPLA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1580-5", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE FABRICAS DE PINTURA", ""), httpContext.getMessage( "UPFPARA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1600-6", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA DEL PLASTICO", ""), httpContext.getMessage( "OSPIP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1610-5", httpContext.getMessage( "OBRA SOCIAL DE CAPATACES ESTIBADORES PORTUARIOS", ""), httpContext.getMessage( "OSCEP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1620-4", httpContext.getMessage( "OBRA SOCIAL DE PORTUARIOS ARGENTINOS", ""), httpContext.getMessage( "OSPA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1670-9", httpContext.getMessage( "OBRA SOCIAL PORTUARIOS PUERTO SAN MARTIN Y BELLA VISTA", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1720-7", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE PRENSA DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSPPRA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1740-5", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE PRENSA DE BAHIA BLANCA", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1770-2", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE PRENSA DE MAR DEL PLATA", ""), httpContext.getMessage( "OSPREN", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1780-1", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE PRENSA DE MENDOZA", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1800-2", httpContext.getMessage( "OBRA SOCIAL DE EMPLEADOS DE PRENSA DE CORDOBA", ""), httpContext.getMessage( "OSEPC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1820-0", httpContext.getMessage( "OBRA SOCIAL DE AGENTES DE PROPAGANDA MEDICA DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSAPM", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1830-9", httpContext.getMessage( "OBRA SOCIAL DE AGENTES DE PROPAGANDA MEDICA DE CORDOBA", ""), httpContext.getMessage( "OSAPMCBA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1840-8", httpContext.getMessage( "OBRA SOCIAL DE AGENTES DE PROPAGANDA MEDICA DE ENTRE RIOS", ""), httpContext.getMessage( "OSAPMER", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1860-6", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA PUBLICIDAD", ""), httpContext.getMessage( "OSPP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1870-5", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE INDUSTRIAS QUIMICAS Y PETROQUIMICAS", ""), httpContext.getMessage( "OSPIQYP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1880-4", httpContext.getMessage( "OBRA SOCIAL DE RECIBIDORES DE GRANOS Y ANEXOS", ""), httpContext.getMessage( "OSRGA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1890-3", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE RECOLECCION Y BARRIDO DE ROSARIO", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1900-5", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE REFINERIAS DE MAIZ", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1920-3", httpContext.getMessage( "OBRA SOCIAL DE RELOJEROS Y JOYEROS", ""), httpContext.getMessage( "OSRJA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1930-2", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL RURAL Y ESTIBADORES DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSPRERA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1950-0", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA SANIDAD ARGENTINA", ""), httpContext.getMessage( "OSPSA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1960-9", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE INSTALACIONES SANITARIAS", ""), httpContext.getMessage( "OSPIS", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1970-8", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE SEGURIDAD COMERCIAL, INDUSTRIAL E INVESTIGACIONES PRIVADAS", ""), httpContext.getMessage( "OSPSIP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-1990-6", httpContext.getMessage( "OBRA SOCIAL DE SERENOS DE BUQUES", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2030-6", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE SUPERVISION DE LA EMPRESA SUBTERRANEOS DE BUENOS AIRES", ""), httpContext.getMessage( "OSPSESBA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2040-5", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE DIRECCION DE LA EMPRESA SUBTERRANEOS DE BUENOS AIRES", ""), httpContext.getMessage( "OSPDESBA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2050-4", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA DEL TABACO", ""), httpContext.getMessage( "OSPIT", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2060-3", httpContext.getMessage( "OBRA SOCIAL DE EMPLEADOS DEL TABACO DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSETRA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2070-2", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LAS TELECOMUNICACIONES DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSTEL", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2080-1", httpContext.getMessage( "OBRA SOCIAL DE TRABAJADORES DE LAS COMUNICACIONES", ""), httpContext.getMessage( "OSTRAC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2090-0", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE TELEVISION", ""), httpContext.getMessage( "OSPTV", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2100-2", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA TEXTIL", ""), httpContext.getMessage( "OSPIT", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2110-1", httpContext.getMessage( "OBRA SOCIAL DE EMPLEADOS TEXTILES Y AFINES", ""), httpContext.getMessage( "OSETYA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2130-9", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA DEL TRACTOR", ""), httpContext.getMessage( "OSPIT", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2150-7", httpContext.getMessage( "OBRA SOCIAL DE LA INDUSTRIA DEL TRANSPORTE AUTOMOTOR DE CORDOBA", ""), httpContext.getMessage( "OSITAC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2160-6", httpContext.getMessage( "OBRA SOCIAL CONDUCTORES DE TRANSPORTE COLECTIVO DE PASAJEROS", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2170-5", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA ACTIVIDAD DEL TURF", ""), httpContext.getMessage( "OSPAT", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2180-4", httpContext.getMessage( "OBRA SOCIAL CONDUCTORES DE TAXIS DE CORDOBA", ""), httpContext.getMessage( "OSTC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2190-3", httpContext.getMessage( "OBRA SOCIAL DE VAREADORES", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2200-5", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA DEL VESTIDO", ""), httpContext.getMessage( "OSPIV", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2210-4", httpContext.getMessage( "OBRA SOCIAL DE VIAJANTES VENDEDORES DE LA REPUBLICA ARGENTINA. (ANDAR)", ""), httpContext.getMessage( "OSVVRA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2230-2", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA ACTIVIDAD VIAL", ""), httpContext.getMessage( "OSPA-VIAL", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2240-1", httpContext.getMessage( "OBRA SOCIAL DE EMPLEADOS DE LA INDUSTRIA DEL VIDRIO", ""), httpContext.getMessage( "OSEIV", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2250-0", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA INDUSTRIA DEL VIDRIO", ""), httpContext.getMessage( "OSPIV", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2260-9", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA ACTIVIDAD VITIVINICOLA", ""), httpContext.getMessage( "OSPAV", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2280-7", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE VIGILANCIA Y SEGURIDAD COMERCIAL, INDUSTRIAL E INVESTIGACIONES PRIVADAS DE CORDOBA", ""), httpContext.getMessage( "OSPEVIC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2290-6", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE ESTACIONES DE SERVICIO, GARAGES, PLAYAS Y LAVADEROS AUTOMATICOS DE LA PROVINCIA DE SANTA FE", ""), httpContext.getMessage( "OSPESGA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2300-8", httpContext.getMessage( "OBRA SOCIAL PARA EL PERSONAL DE ESTACIONES DE SERVICIO, GARAGES, PLAYAS DE ESTACIONAMIENTO, LAVADEROS AUTOMATICOS Y GOMERIAS DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSPES", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2310-7", httpContext.getMessage( "OBRA SOCIAL TALLERISTAS A DOMICILIO", ""), httpContext.getMessage( "OSTAD", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2330-5", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE SOCIEDADES DE AUTORES Y AFINES", ""), httpContext.getMessage( "OSPESA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2340-4", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE PRENSA DE ROSARIO", ""), httpContext.getMessage( "OSPRO", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2350-3", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE PRENSA DE TUCUMAN", ""), httpContext.getMessage( "OSPRENTUC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2360-2", httpContext.getMessage( "OBRA SOCIAL DE TRABAJADORES DE PERKINS ARGENTINA S.A.I.C", ""), httpContext.getMessage( "OSTP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2370-1", httpContext.getMessage( "OBRA SOCIAL DE PEONES DE TAXIS DE LA CAPITAL FEDERAL", ""), httpContext.getMessage( "OSPETAX", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2390-9", httpContext.getMessage( "OBRA SOCIAL DE VENDEDORES AMBULANTES DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSVARA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2400-1", httpContext.getMessage( "OBRA SOCIAL DE BOXEADORES AGREMIADOS DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSBARA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2450-6", httpContext.getMessage( "OBRA SOCIAL DE TRABAJADORES DE LA INDUSTRIA DEL GAS", ""), httpContext.getMessage( "OSTIG", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2510-3", httpContext.getMessage( "OBRA SOCIAL DE LOS PROFESIONALES UNIVERSITARIOS DEL AGUA Y LA ENERGIA ELECTRICA", ""), httpContext.getMessage( "OSPUAYE", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2530-1", httpContext.getMessage( "OBRA SOCIAL FEDERAL DE LA FEDERACION NACIONAL DE TRABAJADORES DE OBRAS SANITARIAS", ""), httpContext.getMessage( "OSFFENTOS", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2550-9", httpContext.getMessage( "OBRA SOCIAL DE LA FEDERACION ARGENTINA DEL TRABAJADOR DE LAS UNIVERSIDADES NACIONALES", ""), httpContext.getMessage( "OSFATUN", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2570-7", httpContext.getMessage( "OBRA SOCIAL UNION PERSONAL DE LA UNION DEL PERSONAL CIVIL DE LA NACION", ""), httpContext.getMessage( "OSPCN", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2590-5", httpContext.getMessage( "OBRA SOCIAL DE ARBITROS DEPORTIVOS DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSADRA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2600-7", httpContext.getMessage( "OBRA SOCIAL DE LA FEDERACION GREMIAL DEL PERSONAL DE LA INDUSTRIA DE LA CARNE Y SUS DERIVADOS", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2610-6", httpContext.getMessage( "OBRA SOCIAL PARA LOS TRABAJADORES DE LA EDUCACION PRIVADA", ""), httpContext.getMessage( "OSTEP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2620-5", httpContext.getMessage( "OBRA SOCIAL DE LOS EMPLEADOS DE COMERCIO Y ACTIVIDADES CIVILES", ""), httpContext.getMessage( "OSECAC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2630-4", httpContext.getMessage( "OBRA SOCIAL SERVICIOS SOCIALES BANCARIOS", ""), httpContext.getMessage( "OSBA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2650-2", httpContext.getMessage( "OBRA SOCIAL DE LA CONFEDERACION DE OBREROS Y EMPLEADOS MUNICIPALES ARGENTINA ( OSCOEMA )", ""), httpContext.getMessage( "OSCOEMA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2660-1", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE INDUSTRIAS QUIMICAS Y PETROQUIMICAS DE ZARATE CAMPANA", ""), httpContext.getMessage( "OPZC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2670-0", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA ACTIVIDAD AZUCARERA TUCUMANA", ""), httpContext.getMessage( "OSPAAT", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2680-9", httpContext.getMessage( "OBRA SOCIAL DE CONDUCTORES DE REMISES Y AUTOS AL INSTANTE Y AFINES", ""), httpContext.getMessage( "OSCRAIA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2690-8", httpContext.getMessage( "OBRA SOCIAL DE LOS MEDICOS DE LA CIUDAD DE BUENOS AIRES", ""), httpContext.getMessage( "OSMEDICA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2700-0", httpContext.getMessage( "OBRA SOCIAL DE TRABAJADORES DE ESTACIONES DE SERVICIO", ""), httpContext.getMessage( "OSTES", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2710-9", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE TELECOMUNICACIONES SINDICATO BUENOS AIRES", ""), httpContext.getMessage( "OSPETELCO", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2720-8", httpContext.getMessage( "OBRA SOCIAL DE MANDOS MEDIOS DE TELECOMUNICACIONES EN LA REPUBLICA ARGENTINA Y MERCOSUR", ""), httpContext.getMessage( "OSMMEDT", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2730-7", httpContext.getMessage( "OBRA SOCIAL DE TRABAJADORES VIALES Y AFINES DE LA REPUBLICA ARGENTINA", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2740-6", httpContext.getMessage( "OBRA SOCIAL DE OBREROS Y EMPLEADOS TINTOREROS SOMBREREROS Y LAVADEROS DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSOETSYLARA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2750-5", httpContext.getMessage( "OBRA SOCIAL DE LAS ASOCIACIONES DE EMPLEADOS DE FARMACIA", ""), httpContext.getMessage( "OSADEF", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2760-4", httpContext.getMessage( "OBRA SOCIAL PARA EL PERSONAL DE OBRAS Y SERVICIOS SANITARIOS", ""), httpContext.getMessage( "OSOSS", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2770-3", httpContext.getMessage( "OBRA SOCIAL PERSONAL ESTACIONES DE SERVICIO,GARAGES,PLAYAS Y LAVADEROS DE LA PROVINCIA DEL CHACO", ""), httpContext.getMessage( "OSPESCHA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2780-2", httpContext.getMessage( "OBRA SOCIAL DE LUZ Y FUERZA DE LA PATAGONIA", ""), httpContext.getMessage( "OSLYF PATAGONIA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2790-1", httpContext.getMessage( "OBRA SOCIAL DE PETROLEROS PRIVADOS", ""), httpContext.getMessage( "OS.PE.PRI", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2800-3", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA FEDERACION DE SINDICATOS DE LA INDUSTRIA QUIMICA Y PETROQUIMICA", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2810-2", httpContext.getMessage( "OBRA SOCIAL DE LA UNION DE TRABAJADORES DEL INSTITUTO NACIONAL DE SERVICIOS SOCIALES PARA JUBILADOS Y PENSIONADOS DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSUTI", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2820-1", httpContext.getMessage( "OBRA SOCIAL DEL SINDICATO UNICO DE RECOLECTORES DE RESIDUOS Y BARRIDO DE CORDOBA", ""), httpContext.getMessage( "O.S.S.U.R.R.B.A.C", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2830-0", httpContext.getMessage( "OBRA SOCIAL PEONES DE TAXIS DE ROSARIO", ""), httpContext.getMessage( "O.S.PE.TAX.R", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2840-9", httpContext.getMessage( "OBRA SOCIAL DEL SINDICATO OBREROS Y EMPLEADOS DE EMPRESAS DE LIMPIEZA,SERVICIOS Y AFINES DE CORDOBA", ""), httpContext.getMessage( "OSSOELSAC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2850-8", httpContext.getMessage( "OBRA SOCIAL DE FARMACEUTICOS Y BIOQUIMICOS", ""), httpContext.getMessage( "OSFYB", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2860-7", httpContext.getMessage( "OBRA SOCIAL DE TRABAJADORES DEL PETROLEO Y GAS PRIVADO DEL CHUBUT", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2870-6", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE DRAGADO Y BALIZAMIENTO", ""), httpContext.getMessage( "OSPEDYB", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2880-5", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL ADUANERO DE LA REPUBLICA ARGENTINA", ""), httpContext.getMessage( "OSPAD", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2890-4", httpContext.getMessage( "OBRA SOCIAL DE LOS TRABAJADORES ARGENTINOS DE CENTROS DE CONTACTOS", ""), httpContext.getMessage( "O.S.T.A.C.C,", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "1-2900-6", httpContext.getMessage( "OBRA SOCIAL DE LA ASOCIACION DEL PERSONAL SUPERIOR DE LA EMPRESA PROVINCIAL DE ENERGIA DE CORDOBA", ""), httpContext.getMessage( "O.S.A.P.S.E", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "2-0040-0", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE LA EMPRESA NACIONAL DE CORREOS Y TELEGRAFOS S.A. Y DE LAS COMUNICACIONES DE LA REPULICA ARGENTINA", ""), httpContext.getMessage( "OSPEC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "3-0070-4", httpContext.getMessage( "OBRA SOCIAL CERAS JOHNSON", ""), httpContext.getMessage( "JOHNSON", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "3-0210-6", httpContext.getMessage( "OBRA SOCIAL PARA DIRECTIVOS, TECNICOS Y EMPLEADOS DE JOHN DEERE ARGENTINA", ""), httpContext.getMessage( "DITEM", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "3-0230-4", httpContext.getMessage( "OBRA SOCIAL COMPANIA MINERA AGUILAR S.A", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "3-0280-9", httpContext.getMessage( "OBRA SOCIAL REFINERIAS DE MAIZ S.A.I.C.F.", ""), httpContext.getMessage( "OSRM", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "3-0310-9", httpContext.getMessage( "OBRA SOCIAL SUPERCO", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "3-0330-7", httpContext.getMessage( "OBRA SOCIAL CABOT ARGENTINA", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "3-0340-6", httpContext.getMessage( "OBRA SOCIAL DE SHELL ARGENTINA", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "3-0370-3", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE PBBPOLISUR SA DE BAHIA BLANCA", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "3-0390-1", httpContext.getMessage( "OBRA SOCIAL DE FORD AGENTINA S.C.A", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "3-0400-3", httpContext.getMessage( "OBRA SOCIAL DE VOLKSWAGEN ARGENTINA S.A.", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0010-7", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE DIRECCION DE LAS EMPRESAS DE LA ALIMENTACION Y DEMAS ACTIVIDADES EMPRESARIAS", ""), httpContext.getMessage( "OPDEA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0020-6", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE DIRECCION DE LA INDUSTRIA AUTOMOTRIZ ARGENTINA", ""), httpContext.getMessage( "OSPREME", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0030-5", httpContext.getMessage( "OBRA SOCIAL COOPERATIVA LTDA. DE ASISTENCIA MEDICA Y FARMACEUTICA, SERVICIOS ASISTENCIALES Y TURISMO DEL PERSONAL SUPERIOR DE LA INDUSTRIA DEL CAUCHO Y OTRAS ACTIVIDADES INDUSTRIALES", ""), httpContext.getMessage( "CAMPSIC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0040-4", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE DIRECCION DE LA INDUSTRIA CERVECERA Y MALTERA", ""), httpContext.getMessage( "SERVESALUD", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0050-3", httpContext.getMessage( "OBRA SOCIAL DE LA ASOCIACION DEL PERSONAL DE DIRECCION Y JERARQUICO DE LA INDUSTRIA DEL CIGARRILLO", ""), httpContext.getMessage( "APDJIC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0060-2", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DIRECTIVO DE LA INDUSTRIA DE LA CONSTRUCCION", ""), httpContext.getMessage( "OSDIC", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0070-1", httpContext.getMessage( "OBRA SOCIAL CAMARA DE LA INDUSTRIA CURTIDORA ARGENTINA", ""), httpContext.getMessage( "OSCICA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0080-0", httpContext.getMessage( "ORGANIZACION DE SERVICIOS DIRECTOS EMPRESARIOS", ""), httpContext.getMessage( "OSDE", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0090-9", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE DIRECCION ACCION SOCIAL DE EMPRESARIOS (A:S:E.)", ""), httpContext.getMessage( "ASE", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0100-1", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE DIRECCION DE LAS EMPRESAS QUE ACTUAN EN FRUTOS DEL PAIS", ""), httpContext.getMessage( "FRUTOS", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0110-0", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE DIRECCION ALFREDO FORTABAT", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0120-9", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE DIRECCION DE LA INDUSTRIA METALURGICA Y DEMAS ACTIVIDADES EMPRESARIAS", ""), httpContext.getMessage( "OSIM", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0130-8", httpContext.getMessage( "OBRA SOCIAL PARA EL PERSONAL DE DIRECCION DE LA INDUSTRIA MADERERA", ""), httpContext.getMessage( "OSMAD", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0160-5", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE DIRECCION DE LA INDUSTRIA PRIVADA DEL PETROLEO", ""), httpContext.getMessage( "OSDIPP", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0170-4", httpContext.getMessage( "OBRA SOCIAL DE EMPRESARIOS, PROFESIONALES Y MONOTRIBUTISTAS", ""), httpContext.getMessage( "OSDEPYM", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0180-3", httpContext.getMessage( "OBRA SOCIAL ASOCIACION MUTUAL DEL PERSONAL DE PHILIPS ARGENTINA (AMPAR)", ""), httpContext.getMessage( "AMPAR", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0190-2", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE DIRECCION DE PERFUMERIA E.W. HOPE", ""), httpContext.getMessage( "WHOPE", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0200-4", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE DIRECCION DE SANIDAD LUIS PASTEUR", ""), httpContext.getMessage( "OSLPASTEUR", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0210-3", httpContext.getMessage( "OBRA SOCIAL ASOCIACION DEL PERSONAL DE DIRECCION DE LA INDUSTRIA SIDERURGICA", ""), httpContext.getMessage( "APDIS", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0220-2", httpContext.getMessage( "OBRA SOCIAL MUTUALIDAD INDUSTRIAL TEXTIL ARGENTINA", ""), httpContext.getMessage( "OSMITA", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0230-1", httpContext.getMessage( "OBRA SOCIAL ASOCIACION DEL PERSONAL SUPERIOR DE LA ORGANIZACION TECHINT", ""), httpContext.getMessage( "APSOT", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0240-0", httpContext.getMessage( "OBRA SOCIAL PARA EL PERSONAL DE DIRECCION DE LA INDUSTRIA VITIVINICOLA Y AFINES", ""), httpContext.getMessage( "OSEDEIV", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0250-9", httpContext.getMessage( "OBRA SOCIAL YPF", ""), httpContext.getMessage( "OSYPF", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0260-8", httpContext.getMessage( "OBRA SOCIAL ASOCIACION DE SERVICIOS SOCIALES PARA EMPRESARIOS Y PERSONAL DE DIRECCION DE EMPRESAS DEL COMERCIO, SERVICIOS, PRODUCCION, INDUSTRIA Y CIVIL (ASSPE )", ""), httpContext.getMessage( "ASSPE", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0270-7", httpContext.getMessage( "OBRA SOCIAL DE DIRECCION OSDO", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "4-0280-6", httpContext.getMessage( "OBRA SOCIAL DE DIRECCION DE LA ACTIVIDAD AEROCOMERCIAL PRIVADA", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "6-0040-8", httpContext.getMessage( "ASOCIACION DE OBRAS SOCIALES DE COMODORO RIVADAVIA", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "6-0110-4", httpContext.getMessage( "ASOCIACION GUALEGUAYCHU DE OBRAS SOCIALES", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "6-0120-3", httpContext.getMessage( "ASOCIACION DE OBRAS SOCIALES DE GUALEGUAY", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "6-0230-5", httpContext.getMessage( "ASOCIACION DE OBRAS SOCIALES DE ROSARIO", ""), httpContext.getMessage( "ADOS ROSARIO", "")) ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "6-0310-0", httpContext.getMessage( "ASOCIACION DE OBRAS SOCIALES DE TRELEW", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "7-0010-8", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL MUNICIPAL DE AVELLANEDA", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "7-0080-1", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL MUNICIPAL DE LA MATANZA", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "7-0100-2", httpContext.getMessage( "OBRA SOCIAL PARA EL PERSONAL MUNICIPAL DE TRES DE FEBRERO", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "8-0050-1", httpContext.getMessage( "OBRA SOCIAL ACEROS PARANA", ""), "") ;
      new web.add_obrasocial(remoteHandle, context).execute( AV9CliCod, "9-0010-2", httpContext.getMessage( "OBRA SOCIAL DEL PERSONAL DE EMPRESAS FIAT Y EMPRESAS PEUGEOT CITROEN ARGENTINA", ""), httpContext.getMessage( "OSPEF Y EPCA", "")) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = ini_os.this.AV8os_sdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8os_sdt = new GXBaseCollection<web.Sdtos_sdt_os_sdtItem>(web.Sdtos_sdt_os_sdtItem.class, "os_sdtItem", "PayDay", remoteHandle);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private GXBaseCollection<web.Sdtos_sdt_os_sdtItem>[] aP1 ;
   private GXBaseCollection<web.Sdtos_sdt_os_sdtItem> AV8os_sdt ;
}

