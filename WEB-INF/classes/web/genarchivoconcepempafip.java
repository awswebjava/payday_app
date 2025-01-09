package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class genarchivoconcepempafip extends GXProcedure
{
   public genarchivoconcepempafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( genarchivoconcepempafip.class ), "" );
   }

   public genarchivoconcepempafip( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      genarchivoconcepempafip.this.aP1 = new String[] {""};
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
      genarchivoconcepempafip.this.aP0 = aP0;
      genarchivoconcepempafip.this.aP1 = aP1;
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
      genarchivoconcepempafip.this.GXt_int1 = GXv_int2[0] ;
      AV22CliCod = GXt_int1 ;
      GXt_char3 = AV14rutaAplicacion ;
      GXv_char4[0] = GXt_char3 ;
      new web.getdefaultpath(remoteHandle, context).execute( GXv_char4) ;
      genarchivoconcepempafip.this.GXt_char3 = GXv_char4[0] ;
      AV14rutaAplicacion = GXt_char3 ;
      GXt_char3 = AV14rutaAplicacion ;
      GXv_char4[0] = GXt_char3 ;
      new web.carpetaarchivostemporales(remoteHandle, context).execute( GXv_char4) ;
      genarchivoconcepempafip.this.GXt_char3 = GXv_char4[0] ;
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
      /* Using cursor P00DK2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV22CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00DK2_A3CliCod[0] ;
         A386ConAFIPConcepto = P00DK2_A386ConAFIPConcepto[0] ;
         n386ConAFIPConcepto = P00DK2_n386ConAFIPConcepto[0] ;
         A73ConCodPropio = P00DK2_A73ConCodPropio[0] ;
         A383ConAfipDesc = P00DK2_A383ConAfipDesc[0] ;
         A134ConAFIPMarcaRep = P00DK2_A134ConAFIPMarcaRep[0] ;
         A380ConAFIPTipo = P00DK2_A380ConAFIPTipo[0] ;
         A141ConAFIPSIPAApo = P00DK2_A141ConAFIPSIPAApo[0] ;
         A142ConAFIPSIPACont = P00DK2_A142ConAFIPSIPACont[0] ;
         A131ConAFIPINSSJyPApo = P00DK2_A131ConAFIPINSSJyPApo[0] ;
         A132ConAFIPINSSJyPCont = P00DK2_A132ConAFIPINSSJyPCont[0] ;
         A135ConAFIPObraSocApo = P00DK2_A135ConAFIPObraSocApo[0] ;
         A136ConAFIPObraSocCont = P00DK2_A136ConAFIPObraSocCont[0] ;
         A129ConAFIPFonSolRedApo = P00DK2_A129ConAFIPFonSolRedApo[0] ;
         A130ConAFIPFonSolRedCont = P00DK2_A130ConAFIPFonSolRedCont[0] ;
         A139ConAFIPRenateaApo = P00DK2_A139ConAFIPRenateaApo[0] ;
         A140ConAFIPRenateaCont = P00DK2_A140ConAFIPRenateaCont[0] ;
         A127ConAFIPAsigFamCont = P00DK2_A127ConAFIPAsigFamCont[0] ;
         A128ConAFIPFonNacEmpCont = P00DK2_A128ConAFIPFonNacEmpCont[0] ;
         A133ConAFIPLeyRieTrabCont = P00DK2_A133ConAFIPLeyRieTrabCont[0] ;
         A137ConAFIPRegDifApo = P00DK2_A137ConAFIPRegDifApo[0] ;
         A138ConAFIPRegEspApo = P00DK2_A138ConAFIPRegEspApo[0] ;
         AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A386ConAFIPConcepto, 6) ;
         AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( GXutil.trim( A73ConCodPropio), 10) ;
         AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A383ConAfipDesc, 150) ;
         AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A134ConAFIPMarcaRep, 1) ;
         if ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 )
         {
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( "                   ", 19) ;
         }
         else
         {
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A141ConAFIPSIPAApo, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A142ConAFIPSIPACont, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A131ConAFIPINSSJyPApo, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A132ConAFIPINSSJyPCont, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A135ConAFIPObraSocApo, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A136ConAFIPObraSocCont, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A129ConAFIPFonSolRedApo, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A130ConAFIPFonSolRedCont, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A139ConAFIPRenateaApo, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A140ConAFIPRenateaCont, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( AV10libre, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A127ConAFIPAsigFamCont, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( AV10libre, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A128ConAFIPFonNacEmpCont, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( AV10libre, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A133ConAFIPLeyRieTrabCont, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A137ConAFIPRegDifApo, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( AV10libre, 1) ;
            AV11Result = context.getSessionInstances().getDelimitedFiles().dfwptxt( A138ConAFIPRegEspApo, 1) ;
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
      this.aP0[0] = genarchivoconcepempafip.this.AV19archivoAbsolute;
      this.aP1[0] = genarchivoconcepempafip.this.AV20NombreArchivo;
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
      scmdbuf = "" ;
      P00DK2_A3CliCod = new int[1] ;
      P00DK2_A386ConAFIPConcepto = new String[] {""} ;
      P00DK2_n386ConAFIPConcepto = new boolean[] {false} ;
      P00DK2_A73ConCodPropio = new String[] {""} ;
      P00DK2_A383ConAfipDesc = new String[] {""} ;
      P00DK2_A134ConAFIPMarcaRep = new String[] {""} ;
      P00DK2_A380ConAFIPTipo = new String[] {""} ;
      P00DK2_A141ConAFIPSIPAApo = new String[] {""} ;
      P00DK2_A142ConAFIPSIPACont = new String[] {""} ;
      P00DK2_A131ConAFIPINSSJyPApo = new String[] {""} ;
      P00DK2_A132ConAFIPINSSJyPCont = new String[] {""} ;
      P00DK2_A135ConAFIPObraSocApo = new String[] {""} ;
      P00DK2_A136ConAFIPObraSocCont = new String[] {""} ;
      P00DK2_A129ConAFIPFonSolRedApo = new String[] {""} ;
      P00DK2_A130ConAFIPFonSolRedCont = new String[] {""} ;
      P00DK2_A139ConAFIPRenateaApo = new String[] {""} ;
      P00DK2_A140ConAFIPRenateaCont = new String[] {""} ;
      P00DK2_A127ConAFIPAsigFamCont = new String[] {""} ;
      P00DK2_A128ConAFIPFonNacEmpCont = new String[] {""} ;
      P00DK2_A133ConAFIPLeyRieTrabCont = new String[] {""} ;
      P00DK2_A137ConAFIPRegDifApo = new String[] {""} ;
      P00DK2_A138ConAFIPRegEspApo = new String[] {""} ;
      A386ConAFIPConcepto = "" ;
      A73ConCodPropio = "" ;
      A383ConAfipDesc = "" ;
      A134ConAFIPMarcaRep = "" ;
      A380ConAFIPTipo = "" ;
      A141ConAFIPSIPAApo = "" ;
      A142ConAFIPSIPACont = "" ;
      A131ConAFIPINSSJyPApo = "" ;
      A132ConAFIPINSSJyPCont = "" ;
      A135ConAFIPObraSocApo = "" ;
      A136ConAFIPObraSocCont = "" ;
      A129ConAFIPFonSolRedApo = "" ;
      A130ConAFIPFonSolRedCont = "" ;
      A139ConAFIPRenateaApo = "" ;
      A140ConAFIPRenateaCont = "" ;
      A127ConAFIPAsigFamCont = "" ;
      A128ConAFIPFonNacEmpCont = "" ;
      A133ConAFIPLeyRieTrabCont = "" ;
      A137ConAFIPRegDifApo = "" ;
      A138ConAFIPRegEspApo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.genarchivoconcepempafip__default(),
         new Object[] {
             new Object[] {
            P00DK2_A3CliCod, P00DK2_A386ConAFIPConcepto, P00DK2_n386ConAFIPConcepto, P00DK2_A73ConCodPropio, P00DK2_A383ConAfipDesc, P00DK2_A134ConAFIPMarcaRep, P00DK2_A380ConAFIPTipo, P00DK2_A141ConAFIPSIPAApo, P00DK2_A142ConAFIPSIPACont, P00DK2_A131ConAFIPINSSJyPApo,
            P00DK2_A132ConAFIPINSSJyPCont, P00DK2_A135ConAFIPObraSocApo, P00DK2_A136ConAFIPObraSocCont, P00DK2_A129ConAFIPFonSolRedApo, P00DK2_A130ConAFIPFonSolRedCont, P00DK2_A139ConAFIPRenateaApo, P00DK2_A140ConAFIPRenateaCont, P00DK2_A127ConAFIPAsigFamCont, P00DK2_A128ConAFIPFonNacEmpCont, P00DK2_A133ConAFIPLeyRieTrabCont,
            P00DK2_A137ConAFIPRegDifApo, P00DK2_A138ConAFIPRegEspApo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

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
   private String scmdbuf ;
   private String A386ConAFIPConcepto ;
   private String A73ConCodPropio ;
   private String A134ConAFIPMarcaRep ;
   private String A380ConAFIPTipo ;
   private String A141ConAFIPSIPAApo ;
   private String A142ConAFIPSIPACont ;
   private String A131ConAFIPINSSJyPApo ;
   private String A132ConAFIPINSSJyPCont ;
   private String A135ConAFIPObraSocApo ;
   private String A136ConAFIPObraSocCont ;
   private String A129ConAFIPFonSolRedApo ;
   private String A130ConAFIPFonSolRedCont ;
   private String A139ConAFIPRenateaApo ;
   private String A140ConAFIPRenateaCont ;
   private String A127ConAFIPAsigFamCont ;
   private String A128ConAFIPFonNacEmpCont ;
   private String A133ConAFIPLeyRieTrabCont ;
   private String A137ConAFIPRegDifApo ;
   private String A138ConAFIPRegEspApo ;
   private boolean n386ConAFIPConcepto ;
   private String AV19archivoAbsolute ;
   private String AV20NombreArchivo ;
   private String AV14rutaAplicacion ;
   private String AV21Random ;
   private String A383ConAfipDesc ;
   private com.genexus.util.GXFile AV9Archivo ;
   private com.genexus.util.GXDirectory AV16folder ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P00DK2_A3CliCod ;
   private String[] P00DK2_A386ConAFIPConcepto ;
   private boolean[] P00DK2_n386ConAFIPConcepto ;
   private String[] P00DK2_A73ConCodPropio ;
   private String[] P00DK2_A383ConAfipDesc ;
   private String[] P00DK2_A134ConAFIPMarcaRep ;
   private String[] P00DK2_A380ConAFIPTipo ;
   private String[] P00DK2_A141ConAFIPSIPAApo ;
   private String[] P00DK2_A142ConAFIPSIPACont ;
   private String[] P00DK2_A131ConAFIPINSSJyPApo ;
   private String[] P00DK2_A132ConAFIPINSSJyPCont ;
   private String[] P00DK2_A135ConAFIPObraSocApo ;
   private String[] P00DK2_A136ConAFIPObraSocCont ;
   private String[] P00DK2_A129ConAFIPFonSolRedApo ;
   private String[] P00DK2_A130ConAFIPFonSolRedCont ;
   private String[] P00DK2_A139ConAFIPRenateaApo ;
   private String[] P00DK2_A140ConAFIPRenateaCont ;
   private String[] P00DK2_A127ConAFIPAsigFamCont ;
   private String[] P00DK2_A128ConAFIPFonNacEmpCont ;
   private String[] P00DK2_A133ConAFIPLeyRieTrabCont ;
   private String[] P00DK2_A137ConAFIPRegDifApo ;
   private String[] P00DK2_A138ConAFIPRegEspApo ;
}

final  class genarchivoconcepempafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00DK2", "SELECT CliCod, ConAFIPConcepto, ConCodPropio, ConAfipDesc, ConAFIPMarcaRep, ConAFIPTipo, ConAFIPSIPAApo, ConAFIPSIPACont, ConAFIPINSSJyPApo, ConAFIPINSSJyPCont, ConAFIPObraSocApo, ConAFIPObraSocCont, ConAFIPFonSolRedApo, ConAFIPFonSolRedCont, ConAFIPRenateaApo, ConAFIPRenateaCont, ConAFIPAsigFamCont, ConAFIPFonNacEmpCont, ConAFIPLeyRieTrabCont, ConAFIPRegDifApo, ConAFIPRegEspApo FROM ConceptoAFIP WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getString(5, 1);
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((String[]) buf[7])[0] = rslt.getString(7, 1);
               ((String[]) buf[8])[0] = rslt.getString(8, 1);
               ((String[]) buf[9])[0] = rslt.getString(9, 1);
               ((String[]) buf[10])[0] = rslt.getString(10, 1);
               ((String[]) buf[11])[0] = rslt.getString(11, 1);
               ((String[]) buf[12])[0] = rslt.getString(12, 1);
               ((String[]) buf[13])[0] = rslt.getString(13, 1);
               ((String[]) buf[14])[0] = rslt.getString(14, 1);
               ((String[]) buf[15])[0] = rslt.getString(15, 1);
               ((String[]) buf[16])[0] = rslt.getString(16, 1);
               ((String[]) buf[17])[0] = rslt.getString(17, 1);
               ((String[]) buf[18])[0] = rslt.getString(18, 1);
               ((String[]) buf[19])[0] = rslt.getString(19, 1);
               ((String[]) buf[20])[0] = rslt.getString(20, 1);
               ((String[]) buf[21])[0] = rslt.getString(21, 1);
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
               return;
      }
   }

}

