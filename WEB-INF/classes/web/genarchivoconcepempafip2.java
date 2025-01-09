package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class genarchivoconcepempafip2 extends GXProcedure
{
   public genarchivoconcepempafip2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( genarchivoconcepempafip2.class ), "" );
   }

   public genarchivoconcepempafip2( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      genarchivoconcepempafip2.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String[] aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String[] aP0 ,
                             String[] aP1 )
   {
      genarchivoconcepempafip2.this.aP0 = aP0;
      genarchivoconcepempafip2.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV22CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      genarchivoconcepempafip2.this.GXt_int1 = GXv_int2[0] ;
      AV22CliCod = GXt_int1 ;
      GXt_char3 = AV14rutaAplicacion ;
      GXv_char4[0] = GXt_char3 ;
      new web.getdefaultpath(remoteHandle, context).execute( GXv_char4) ;
      genarchivoconcepempafip2.this.GXt_char3 = GXv_char4[0] ;
      AV14rutaAplicacion = GXt_char3 ;
      GXt_char3 = AV14rutaAplicacion ;
      GXv_char4[0] = GXt_char3 ;
      new web.carpetaarchivostemporales(remoteHandle, context).execute( GXv_char4) ;
      genarchivoconcepempafip2.this.GXt_char3 = GXv_char4[0] ;
      AV14rutaAplicacion += GXt_char3 ;
      AV16folder.setSource( AV14rutaAplicacion );
      if ( ! AV16folder.exists() )
      {
         AV16folder.create();
      }
      AV21Random = GXutil.format( "%1%2%3%4%5%6", GXutil.ltrimstr( GXutil.year( GXutil.serverNow( context, remoteHandle, pr_default)), 9, 0), GXutil.ltrimstr( GXutil.month( GXutil.serverNow( context, remoteHandle, pr_default)), 9, 0), GXutil.ltrimstr( GXutil.day( GXutil.serverNow( context, remoteHandle, pr_default)), 9, 0), GXutil.ltrimstr( GXutil.hour( GXutil.serverNow( context, remoteHandle, pr_default)), 9, 0), GXutil.ltrimstr( GXutil.minute( GXutil.serverNow( context, remoteHandle, pr_default)), 9, 0), GXutil.ltrimstr( GXutil.second( GXutil.serverNow( context, remoteHandle, pr_default)), 9, 0), "", "", "") ;
      AV20NombreArchivo = GXutil.format( httpContext.getMessage( "ArchivoConceptos_%1.txt", ""), AV21Random, "", "", "", "", "", "", "", "") ;
      AV9Archivo.setSource( AV14rutaAplicacion+"/"+AV20NombreArchivo );
      if ( AV9Archivo.exists() )
      {
         AV9Archivo.delete();
      }
      AV12SeparadorCampo = "" ;
      AV13SeparadorTexto = "" ;
      AV8Agregar = (short)(0) ;
      AV10libre = " " ;
      AV19archivoAbsolute = AV14rutaAplicacion + "/" + AV20NombreArchivo ;
      AV11Result = context.getSessionInstances().getDelimitedFiles().dfwopen( AV19archivoAbsolute, AV12SeparadorCampo, AV13SeparadorTexto, (byte)(AV8Agregar), "") ;
      AV23calculoTipoConCod = "CAL_ARG" ;
      /* Using cursor P01MI2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV22CliCod), AV23calculoTipoConCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A37TipoConCod = P01MI2_A37TipoConCod[0] ;
         A3CliCod = P01MI2_A3CliCod[0] ;
         A1648ConCodAfip = P01MI2_A1648ConCodAfip[0] ;
         A26ConCodigo = P01MI2_A26ConCodigo[0] ;
         A41ConDescrip = P01MI2_A41ConDescrip[0] ;
         A1472ConSIPAApo = P01MI2_A1472ConSIPAApo[0] ;
         A1473ConSIPACont = P01MI2_A1473ConSIPACont[0] ;
         A1474ConINSSJyPApo = P01MI2_A1474ConINSSJyPApo[0] ;
         A1475ConINSSJyPCont = P01MI2_A1475ConINSSJyPCont[0] ;
         A1476ConObraSocApo = P01MI2_A1476ConObraSocApo[0] ;
         A1477ConObraSocCont = P01MI2_A1477ConObraSocCont[0] ;
         A1478ConFonSolRedApo = P01MI2_A1478ConFonSolRedApo[0] ;
         A1479ConFonSolRedCont = P01MI2_A1479ConFonSolRedCont[0] ;
         A1480ConRenateaApo = P01MI2_A1480ConRenateaApo[0] ;
         A1481ConRenateaCont = P01MI2_A1481ConRenateaCont[0] ;
         A1482ConAsigFamCont = P01MI2_A1482ConAsigFamCont[0] ;
         A1483ConFonNacEmpCont = P01MI2_A1483ConFonNacEmpCont[0] ;
         A1484ConLeyRieTrabCont = P01MI2_A1484ConLeyRieTrabCont[0] ;
         A1485ConRegDifApo = P01MI2_A1485ConRegDifApo[0] ;
         A1486ConRegEspApo = P01MI2_A1486ConRegEspApo[0] ;
         AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A1648ConCodAfip, 6) ;
         AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( A26ConCodigo), 10) ;
         AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A41ConDescrip, 150) ;
         AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( "1", 1) ;
         if ( GXutil.strcmp(A37TipoConCod, "DES_ARG") == 0 )
         {
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( "                   ", 19) ;
         }
         else
         {
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( GXutil.str( A1472ConSIPAApo, 1, 0)), 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( GXutil.str( A1473ConSIPACont, 1, 0)), 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( GXutil.str( A1474ConINSSJyPApo, 1, 0)), 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( GXutil.str( A1475ConINSSJyPCont, 1, 0)), 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( GXutil.str( A1476ConObraSocApo, 1, 0)), 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( GXutil.str( A1477ConObraSocCont, 1, 0)), 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( GXutil.str( A1478ConFonSolRedApo, 1, 0)), 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( GXutil.str( A1479ConFonSolRedCont, 1, 0)), 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( GXutil.str( A1480ConRenateaApo, 1, 0)), 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( GXutil.str( A1481ConRenateaCont, 1, 0)), 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( AV10libre, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( GXutil.str( A1482ConAsigFamCont, 1, 0)), 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( AV10libre, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( GXutil.str( A1483ConFonNacEmpCont, 1, 0)), 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( AV10libre, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( GXutil.str( A1484ConLeyRieTrabCont, 1, 0)), 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( GXutil.str( A1485ConRegDifApo, 1, 0)), 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( AV10libre, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( GXutil.str( A1486ConRegEspApo, 1, 0)), 1) ;
         }
         AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( AV10libre, 9) ;
         AV11Result = context.getSessionInstances().getDelimitedFiles().dfwnext( ) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV11Result = context.getSessionInstances().getDelimitedFiles().dfwclose( ) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = genarchivoconcepempafip2.this.AV19archivoAbsolute;
      this.aP1[0] = genarchivoconcepempafip2.this.AV20NombreArchivo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19archivoAbsolute = "" ;
      AV20NombreArchivo = "" ;
      GXv_int2 = new int[1] ;
      AV14rutaAplicacion = "" ;
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      AV16folder = new com.genexus.util.GXDirectory();
      AV21Random = "" ;
      AV9Archivo = new com.genexus.util.GXFile();
      AV12SeparadorCampo = "" ;
      AV13SeparadorTexto = "" ;
      AV10libre = "" ;
      AV23calculoTipoConCod = "" ;
      scmdbuf = "" ;
      P01MI2_A37TipoConCod = new String[] {""} ;
      P01MI2_A3CliCod = new int[1] ;
      P01MI2_A1648ConCodAfip = new String[] {""} ;
      P01MI2_A26ConCodigo = new String[] {""} ;
      P01MI2_A41ConDescrip = new String[] {""} ;
      P01MI2_A1472ConSIPAApo = new byte[1] ;
      P01MI2_A1473ConSIPACont = new byte[1] ;
      P01MI2_A1474ConINSSJyPApo = new byte[1] ;
      P01MI2_A1475ConINSSJyPCont = new byte[1] ;
      P01MI2_A1476ConObraSocApo = new byte[1] ;
      P01MI2_A1477ConObraSocCont = new byte[1] ;
      P01MI2_A1478ConFonSolRedApo = new byte[1] ;
      P01MI2_A1479ConFonSolRedCont = new byte[1] ;
      P01MI2_A1480ConRenateaApo = new byte[1] ;
      P01MI2_A1481ConRenateaCont = new byte[1] ;
      P01MI2_A1482ConAsigFamCont = new byte[1] ;
      P01MI2_A1483ConFonNacEmpCont = new byte[1] ;
      P01MI2_A1484ConLeyRieTrabCont = new byte[1] ;
      P01MI2_A1485ConRegDifApo = new byte[1] ;
      P01MI2_A1486ConRegEspApo = new byte[1] ;
      A37TipoConCod = "" ;
      A1648ConCodAfip = "" ;
      A26ConCodigo = "" ;
      A41ConDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.genarchivoconcepempafip2__default(),
         new Object[] {
             new Object[] {
            P01MI2_A37TipoConCod, P01MI2_A3CliCod, P01MI2_A1648ConCodAfip, P01MI2_A26ConCodigo, P01MI2_A41ConDescrip, P01MI2_A1472ConSIPAApo, P01MI2_A1473ConSIPACont, P01MI2_A1474ConINSSJyPApo, P01MI2_A1475ConINSSJyPCont, P01MI2_A1476ConObraSocApo,
            P01MI2_A1477ConObraSocCont, P01MI2_A1478ConFonSolRedApo, P01MI2_A1479ConFonSolRedCont, P01MI2_A1480ConRenateaApo, P01MI2_A1481ConRenateaCont, P01MI2_A1482ConAsigFamCont, P01MI2_A1483ConFonNacEmpCont, P01MI2_A1484ConLeyRieTrabCont, P01MI2_A1485ConRegDifApo, P01MI2_A1486ConRegEspApo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1472ConSIPAApo ;
   private byte A1473ConSIPACont ;
   private byte A1474ConINSSJyPApo ;
   private byte A1475ConINSSJyPCont ;
   private byte A1476ConObraSocApo ;
   private byte A1477ConObraSocCont ;
   private byte A1478ConFonSolRedApo ;
   private byte A1479ConFonSolRedCont ;
   private byte A1480ConRenateaApo ;
   private byte A1481ConRenateaCont ;
   private byte A1482ConAsigFamCont ;
   private byte A1483ConFonNacEmpCont ;
   private byte A1484ConLeyRieTrabCont ;
   private byte A1485ConRegDifApo ;
   private byte A1486ConRegEspApo ;
   private short AV8Agregar ;
   private short AV11Result ;
   private short Gx_err ;
   private int AV22CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int A3CliCod ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private String AV12SeparadorCampo ;
   private String AV13SeparadorTexto ;
   private String AV10libre ;
   private String AV23calculoTipoConCod ;
   private String scmdbuf ;
   private String A37TipoConCod ;
   private String A1648ConCodAfip ;
   private String A26ConCodigo ;
   private String AV19archivoAbsolute ;
   private String AV20NombreArchivo ;
   private String AV14rutaAplicacion ;
   private String AV21Random ;
   private String A41ConDescrip ;
   private com.genexus.util.GXFile AV9Archivo ;
   private com.genexus.util.GXDirectory AV16folder ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P01MI2_A37TipoConCod ;
   private int[] P01MI2_A3CliCod ;
   private String[] P01MI2_A1648ConCodAfip ;
   private String[] P01MI2_A26ConCodigo ;
   private String[] P01MI2_A41ConDescrip ;
   private byte[] P01MI2_A1472ConSIPAApo ;
   private byte[] P01MI2_A1473ConSIPACont ;
   private byte[] P01MI2_A1474ConINSSJyPApo ;
   private byte[] P01MI2_A1475ConINSSJyPCont ;
   private byte[] P01MI2_A1476ConObraSocApo ;
   private byte[] P01MI2_A1477ConObraSocCont ;
   private byte[] P01MI2_A1478ConFonSolRedApo ;
   private byte[] P01MI2_A1479ConFonSolRedCont ;
   private byte[] P01MI2_A1480ConRenateaApo ;
   private byte[] P01MI2_A1481ConRenateaCont ;
   private byte[] P01MI2_A1482ConAsigFamCont ;
   private byte[] P01MI2_A1483ConFonNacEmpCont ;
   private byte[] P01MI2_A1484ConLeyRieTrabCont ;
   private byte[] P01MI2_A1485ConRegDifApo ;
   private byte[] P01MI2_A1486ConRegEspApo ;
}

final  class genarchivoconcepempafip2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01MI2", "SELECT TipoConCod, CliCod, ConCodAfip, ConCodigo, ConDescrip, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo FROM Concepto WHERE (CliCod = ?) AND (TipoConCod <> ( ?)) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((byte[]) buf[14])[0] = rslt.getByte(15);
               ((byte[]) buf[15])[0] = rslt.getByte(16);
               ((byte[]) buf[16])[0] = rslt.getByte(17);
               ((byte[]) buf[17])[0] = rslt.getByte(18);
               ((byte[]) buf[18])[0] = rslt.getByte(19);
               ((byte[]) buf[19])[0] = rslt.getByte(20);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

