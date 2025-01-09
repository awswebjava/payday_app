package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptoaplicatipoliqyconvenio extends GXProcedure
{
   public conceptoaplicatipoliqyconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptoaplicatipoliqyconvenio.class ), "" );
   }

   public conceptoaplicatipoliqyconvenio( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              String aP4 ,
                              String aP5 ,
                              String aP6 )
   {
      conceptoaplicatipoliqyconvenio.this.aP7 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        boolean[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             boolean[] aP7 )
   {
      conceptoaplicatipoliqyconvenio.this.AV8CliCod = aP0;
      conceptoaplicatipoliqyconvenio.this.AV11EmpCod = aP1;
      conceptoaplicatipoliqyconvenio.this.AV9LiqNro = aP2;
      conceptoaplicatipoliqyconvenio.this.AV21LegNumero = aP3;
      conceptoaplicatipoliqyconvenio.this.AV12ConCodigo = aP4;
      conceptoaplicatipoliqyconvenio.this.AV19parmTLiqCod = aP5;
      conceptoaplicatipoliqyconvenio.this.AV20parmConveCodigo = aP6;
      conceptoaplicatipoliqyconvenio.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( (GXutil.strcmp("", AV19parmTLiqCod)==0) )
      {
         GXv_char1[0] = AV10TLiqCod ;
         new web.gettipoliq(remoteHandle, context).execute( AV8CliCod, AV11EmpCod, AV9LiqNro, GXv_char1) ;
         conceptoaplicatipoliqyconvenio.this.AV10TLiqCod = GXv_char1[0] ;
      }
      else
      {
         AV10TLiqCod = AV19parmTLiqCod ;
      }
      if ( (GXutil.strcmp("", AV20parmConveCodigo)==0) )
      {
         GXv_char1[0] = AV22ConveCodigo ;
         new web.empleadogetconvenio(remoteHandle, context).execute( AV8CliCod, AV11EmpCod, AV21LegNumero, GXv_char1) ;
         conceptoaplicatipoliqyconvenio.this.AV22ConveCodigo = GXv_char1[0] ;
      }
      else
      {
         AV22ConveCodigo = AV20parmConveCodigo ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "&LiqNro ", "")+GXutil.trim( GXutil.str( AV9LiqNro, 8, 0))+httpContext.getMessage( " &ConCodigo ", "")+GXutil.trim( AV12ConCodigo)+httpContext.getMessage( " tliqcod ", "")+GXutil.trim( AV10TLiqCod)) ;
      /* Using cursor P011D2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV12ConCodigo, AV10TLiqCod, AV22ConveCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1645ConceptoConveCodigo = P011D2_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P011D2_n1645ConceptoConveCodigo[0] ;
         A32TLiqCod = P011D2_A32TLiqCod[0] ;
         A26ConCodigo = P011D2_A26ConCodigo[0] ;
         A3CliCod = P011D2_A3CliCod[0] ;
         A1645ConceptoConveCodigo = P011D2_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P011D2_n1645ConceptoConveCodigo[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, "1") ;
         AV13aplica = true ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, "2") ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = conceptoaplicatipoliqyconvenio.this.AV13aplica;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10TLiqCod = "" ;
      AV22ConveCodigo = "" ;
      GXv_char1 = new String[1] ;
      AV28Pgmname = "" ;
      scmdbuf = "" ;
      P011D2_A1645ConceptoConveCodigo = new String[] {""} ;
      P011D2_n1645ConceptoConveCodigo = new boolean[] {false} ;
      P011D2_A32TLiqCod = new String[] {""} ;
      P011D2_A26ConCodigo = new String[] {""} ;
      P011D2_A3CliCod = new int[1] ;
      A1645ConceptoConveCodigo = "" ;
      A32TLiqCod = "" ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptoaplicatipoliqyconvenio__default(),
         new Object[] {
             new Object[] {
            P011D2_A1645ConceptoConveCodigo, P011D2_n1645ConceptoConveCodigo, P011D2_A32TLiqCod, P011D2_A26ConCodigo, P011D2_A3CliCod
            }
         }
      );
      AV28Pgmname = "ConceptoAplicaTipoLiqYConvenio" ;
      /* GeneXus formulas. */
      AV28Pgmname = "ConceptoAplicaTipoLiqYConvenio" ;
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV9LiqNro ;
   private int AV21LegNumero ;
   private int A3CliCod ;
   private String AV12ConCodigo ;
   private String AV19parmTLiqCod ;
   private String AV20parmConveCodigo ;
   private String AV10TLiqCod ;
   private String AV22ConveCodigo ;
   private String GXv_char1[] ;
   private String AV28Pgmname ;
   private String scmdbuf ;
   private String A1645ConceptoConveCodigo ;
   private String A32TLiqCod ;
   private String A26ConCodigo ;
   private boolean AV13aplica ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean[] aP7 ;
   private IDataStoreProvider pr_default ;
   private String[] P011D2_A1645ConceptoConveCodigo ;
   private boolean[] P011D2_n1645ConceptoConveCodigo ;
   private String[] P011D2_A32TLiqCod ;
   private String[] P011D2_A26ConCodigo ;
   private int[] P011D2_A3CliCod ;
}

final  class conceptoaplicatipoliqyconvenio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P011D2", "SELECT T2.ConceptoConveCodigo, T1.TLiqCod, T1.ConCodigo, T1.CliCod FROM (ConceptoTipoLiquidacion T1 INNER JOIN Concepto T2 ON T2.CliCod = T1.CliCod AND T2.ConCodigo = T1.ConCodigo) WHERE (T1.CliCod = ? and T1.ConCodigo = ( ?) and T1.TLiqCod = ( ?)) AND (T2.ConceptoConveCodigo IS NULL or T2.ConceptoConveCodigo = ( ?)) ORDER BY T1.CliCod, T1.ConCodigo, T1.TLiqCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
               ((int[]) buf[4])[0] = rslt.getInt(4);
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
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

