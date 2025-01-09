package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_modprom extends GXProcedure
{
   public ini_modprom( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_modprom.class ), "" );
   }

   public ini_modprom( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtsdt_modprom_sdt_modpromItem> executeUdp( )
   {
      ini_modprom.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtsdt_modprom_sdt_modpromItem>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<web.Sdtsdt_modprom_sdt_modpromItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<web.Sdtsdt_modprom_sdt_modpromItem>[] aP0 )
   {
      ini_modprom.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "000", httpContext.getMessage( "Contrato modalidad promovida. Reduccion 0%", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "001", httpContext.getMessage( "A tiempo parcial indeterminado", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "002", httpContext.getMessage( "Becarios", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "003", httpContext.getMessage( "De aprendizaje L.25013", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "004", httpContext.getMessage( "Especial de fomento del empleo L.24465", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "005", httpContext.getMessage( "Fomento del empleo L.24013 y L.24465", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "006", httpContext.getMessage( "Lanzamiento nueva actividad L.24013 y L.24465", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "007", httpContext.getMessage( "Periodo de prueba L.24465 y L.25013", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "008", httpContext.getMessage( "A tiempo completo indeterminado", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "009", httpContext.getMessage( "Practica laboral para jovenes", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "010", httpContext.getMessage( "Programa nacional de pasantias D.340/92 y L.25165", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "011", httpContext.getMessage( "Trabajo de temporada", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "012", httpContext.getMessage( "Trabajo eventual", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "013", httpContext.getMessage( "Trabajo formacion", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "014", httpContext.getMessage( "Nuevo periodo de prueba", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "015", httpContext.getMessage( "Puesto nuevo v. 25 a 44 y m. 25 o mas", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "016", httpContext.getMessage( "Nuevo per. prueba. Trab. discap. Art.34 L.24147", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "017", httpContext.getMessage( "P. nuevo men. 25, v. 45 o mas y m. jefe de fam.", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "018", httpContext.getMessage( "Trabajador discapacitado Art.34 L.24147", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "019", httpContext.getMessage( "P. nuevo v. 25 a 44 y m. 25 o mas Art.34 L.24147", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "020", httpContext.getMessage( "P. n. m. 25, v. 45 o mas y m. j./f. Art.34 L24147", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "021", httpContext.getMessage( "A tiempo parcial determinado", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "022", httpContext.getMessage( "A tiempo completo determinado", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "023", httpContext.getMessage( "Trabajador Agrario. Personal no Permamente. L.2224", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "024", httpContext.getMessage( "Personal de la construccion Ley 22250", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "025", httpContext.getMessage( "Empleo Publico provincial", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "026", httpContext.getMessage( "Beneficiario de Programas de Empleo y Capacitacion", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "027", httpContext.getMessage( "Pasantias Decreto 1227/01", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "028", httpContext.getMessage( "Jefes y Jefas de hogar - Dcto. 565/02", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "029", httpContext.getMessage( "Decreto Nro.1212/03 - Aportante Autonomo", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "030", httpContext.getMessage( "Nuevo per. prueba. Trab. Discap. Art.87 L.24013", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "031", httpContext.getMessage( "Trabajador Discapacitado Art.87 Ley 24013", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "032", httpContext.getMessage( "Periodo de Prueba Art.6 Ley 25877", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "033", httpContext.getMessage( "Per.Prueba Art.6 L.25877 Benefic. Planes Jefes/as", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "034", httpContext.getMessage( "Periodo de Prueba Art.6 Ley 25877 Art.34 Ley 24147", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "035", httpContext.getMessage( "Per.Prueba A.6 L.25877 A.34 L.24147 Benefic Planes", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "036", httpContext.getMessage( "Per.Prueba A.6 L.25877 Trab.Discap. A.87 L.24013", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "037", httpContext.getMessage( "P.P. A6 L25877 Trab.Disc. A87 L24013 Benef.Planes", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "038", httpContext.getMessage( "Puesto Nuevo Art.6 Ley 25877", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "039", httpContext.getMessage( "Puesto Nuevo A.6 L.25877 Benefic. Planes Jefes/as", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "040", httpContext.getMessage( "Puesto Nuevo Art.6 Ley 25877 Art.34 Ley 24147", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "041", httpContext.getMessage( "Puesto Nuevo A.6 L.25877 A.34 L.24147 Benef.Planes", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "042", httpContext.getMessage( "Puesto Nuevo A.6 L.25877 Trab.Discap. A.87 L.24013", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "043", httpContext.getMessage( "P.N. A6 L25877 Trab.Disc. A87 L24013 Benef. Planes", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "044", httpContext.getMessage( "Changa Solidaria CCT 62/75", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "045", httpContext.getMessage( "Personal no perm. hoteles Art. 68 del CCT 362/03", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "046", httpContext.getMessage( "Planta transit. Adm Publica Nac., Prov. y/o Munic.", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "047", httpContext.getMessage( "Representacion gramial", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "048", httpContext.getMessage( "Art.4 de la ley Nro 24.241. Traslado temporario", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "050", httpContext.getMessage( "Contrato modalidad promovida Reduccion 50%", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "099", httpContext.getMessage( "LRT (Directores SA, municipios, org, cent y ...", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "100", httpContext.getMessage( "Contrato modalidad promovida. Reduccion 100%", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "101", httpContext.getMessage( "Pre-SIJP (Anterior a 07/1994)", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( "201", httpContext.getMessage( "Puesto Nuevo Art. 16 Ley 26476", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( httpContext.getMessage( "PPR", ""), httpContext.getMessage( "PERIODO DE PRUEBA", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] = AV8sdt_modprom ;
      new web.add_modprom(remoteHandle, context).execute( httpContext.getMessage( "PR5", ""), httpContext.getMessage( "PROMOCION 50%", ""), GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1) ;
      AV8sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = ini_modprom.this.AV8sdt_modprom;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8sdt_modprom = new GXBaseCollection<web.Sdtsdt_modprom_sdt_modpromItem>(web.Sdtsdt_modprom_sdt_modpromItem.class, "sdt_modpromItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1 = new GXBaseCollection[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBaseCollection<web.Sdtsdt_modprom_sdt_modpromItem>[] aP0 ;
   private GXBaseCollection<web.Sdtsdt_modprom_sdt_modpromItem> AV8sdt_modprom ;
   private GXBaseCollection<web.Sdtsdt_modprom_sdt_modpromItem> GXv_objcol_Sdtsdt_modprom_sdt_modpromItem1[] ;
}

