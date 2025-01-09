package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class devuelveparametrosgrabados extends GXProcedure
{
   public devuelveparametrosgrabados( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( devuelveparametrosgrabados.class ), "" );
   }

   public devuelveparametrosgrabados( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>[] aP4 )
   {
      devuelveparametrosgrabados.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>[] aP4 ,
                             String[] aP5 )
   {
      devuelveparametrosgrabados.this.AV13CliCod = aP0;
      devuelveparametrosgrabados.this.AV12ConCodigo = aP1;
      devuelveparametrosgrabados.this.AV8ConOpeId = aP2;
      devuelveparametrosgrabados.this.AV14ConOperFor = aP3;
      devuelveparametrosgrabados.this.aP4 = aP4;
      devuelveparametrosgrabados.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&ConCodigo: \"", "")+AV12ConCodigo+"\"") ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&ConOpeId: \"", "")+AV8ConOpeId+"\"") ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&ConOperFor: \"", "")+AV14ConOperFor+"\"") ;
      AV18GXLvl7 = (byte)(0) ;
      /* Using cursor P01ZJ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), AV12ConCodigo, AV8ConOpeId, AV14ConOperFor});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A923ConOperFor = P01ZJ2_A923ConOperFor[0] ;
         A2119ConOpeId = P01ZJ2_A2119ConOpeId[0] ;
         A26ConCodigo = P01ZJ2_A26ConCodigo[0] ;
         A3CliCod = P01ZJ2_A3CliCod[0] ;
         A2118ConOpeParError = P01ZJ2_A2118ConOpeParError[0] ;
         AV18GXLvl7 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, "2") ;
         if ( ! (GXutil.strcmp("", A2118ConOpeParError)==0) )
         {
            AV11error = A2118ConOpeParError ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, "3") ;
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV18GXLvl7 == 0 )
      {
         AV11error = httpContext.getMessage( "No existen los parámetros ", "") + GXutil.trim( AV14ConOperFor) + httpContext.getMessage( " para el cálculo ", "") + GXutil.trim( AV8ConOpeId) + httpContext.getMessage( " en el concepto ", "") + GXutil.trim( AV12ConCodigo) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      /* Using cursor P01ZJ3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV13CliCod), AV12ConCodigo, AV8ConOpeId, AV14ConOperFor});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A923ConOperFor = P01ZJ3_A923ConOperFor[0] ;
         A2119ConOpeId = P01ZJ3_A2119ConOpeId[0] ;
         A26ConCodigo = P01ZJ3_A26ConCodigo[0] ;
         A3CliCod = P01ZJ3_A3CliCod[0] ;
         A2116ConOpeParId = P01ZJ3_A2116ConOpeParId[0] ;
         A2117ConOpeParValor = P01ZJ3_A2117ConOpeParValor[0] ;
         AV10item = (web.Sdtcal_par_valores_cal_par_valoresItem)new web.Sdtcal_par_valores_cal_par_valoresItem(remoteHandle, context);
         AV10item.setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid( A2116ConOpeParId );
         AV10item.setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value( A2117ConOpeParValor );
         AV9cal_par_valores.add(AV10item, 0);
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, "4") ;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      if ( false )
      {
         new web.pendientesdeoptimizarcasesensitive(remoteHandle, context).execute( ) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = devuelveparametrosgrabados.this.AV9cal_par_valores;
      this.aP5[0] = devuelveparametrosgrabados.this.AV11error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9cal_par_valores = new GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>(web.Sdtcal_par_valores_cal_par_valoresItem.class, "cal_par_valoresItem", "PayDay", remoteHandle);
      AV11error = "" ;
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      P01ZJ2_A923ConOperFor = new String[] {""} ;
      P01ZJ2_A2119ConOpeId = new String[] {""} ;
      P01ZJ2_A26ConCodigo = new String[] {""} ;
      P01ZJ2_A3CliCod = new int[1] ;
      P01ZJ2_A2118ConOpeParError = new String[] {""} ;
      A923ConOperFor = "" ;
      A2119ConOpeId = "" ;
      A26ConCodigo = "" ;
      A2118ConOpeParError = "" ;
      P01ZJ3_A923ConOperFor = new String[] {""} ;
      P01ZJ3_A2119ConOpeId = new String[] {""} ;
      P01ZJ3_A26ConCodigo = new String[] {""} ;
      P01ZJ3_A3CliCod = new int[1] ;
      P01ZJ3_A2116ConOpeParId = new String[] {""} ;
      P01ZJ3_A2117ConOpeParValor = new String[] {""} ;
      A2116ConOpeParId = "" ;
      A2117ConOpeParValor = "" ;
      AV10item = new web.Sdtcal_par_valores_cal_par_valoresItem(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.devuelveparametrosgrabados__default(),
         new Object[] {
             new Object[] {
            P01ZJ2_A923ConOperFor, P01ZJ2_A2119ConOpeId, P01ZJ2_A26ConCodigo, P01ZJ2_A3CliCod, P01ZJ2_A2118ConOpeParError
            }
            , new Object[] {
            P01ZJ3_A923ConOperFor, P01ZJ3_A2119ConOpeId, P01ZJ3_A26ConCodigo, P01ZJ3_A3CliCod, P01ZJ3_A2116ConOpeParId, P01ZJ3_A2117ConOpeParValor
            }
         }
      );
      AV17Pgmname = "devuelveParametrosGrabados" ;
      /* GeneXus formulas. */
      AV17Pgmname = "devuelveParametrosGrabados" ;
      Gx_err = (short)(0) ;
   }

   private byte AV18GXLvl7 ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int A3CliCod ;
   private String AV12ConCodigo ;
   private String AV8ConOpeId ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String A2119ConOpeId ;
   private String A26ConCodigo ;
   private String A2116ConOpeParId ;
   private boolean returnInSub ;
   private String AV14ConOperFor ;
   private String AV11error ;
   private String A923ConOperFor ;
   private String A2118ConOpeParError ;
   private String A2117ConOpeParValor ;
   private String[] aP5 ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01ZJ2_A923ConOperFor ;
   private String[] P01ZJ2_A2119ConOpeId ;
   private String[] P01ZJ2_A26ConCodigo ;
   private int[] P01ZJ2_A3CliCod ;
   private String[] P01ZJ2_A2118ConOpeParError ;
   private String[] P01ZJ3_A923ConOperFor ;
   private String[] P01ZJ3_A2119ConOpeId ;
   private String[] P01ZJ3_A26ConCodigo ;
   private int[] P01ZJ3_A3CliCod ;
   private String[] P01ZJ3_A2116ConOpeParId ;
   private String[] P01ZJ3_A2117ConOpeParValor ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> AV9cal_par_valores ;
   private web.Sdtcal_par_valores_cal_par_valoresItem AV10item ;
}

final  class devuelveparametrosgrabados__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01ZJ2", "SELECT ConOperFor, ConOpeId, ConCodigo, CliCod, ConOpeParError FROM concepto_operandos WHERE (CliCod = ?) AND (UPPER(RTRIM(LTRIM(ConCodigo))) = ( UPPER(RTRIM(LTRIM(?))))) AND (UPPER(RTRIM(LTRIM(ConOpeId))) = ( UPPER(RTRIM(LTRIM(?))))) AND (UPPER(RTRIM(LTRIM(ConOperFor))) = ( UPPER(RTRIM(LTRIM(?))))) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01ZJ3", "SELECT ConOperFor, ConOpeId, ConCodigo, CliCod, ConOpeParId, ConOpeParValor FROM concepto_operandosParametros WHERE (CliCod = ?) AND (UPPER(RTRIM(LTRIM(ConCodigo))) = ( UPPER(RTRIM(LTRIM(?))))) AND (UPPER(RTRIM(LTRIM(ConOpeId))) = ( UPPER(RTRIM(LTRIM(?))))) AND (UPPER(RTRIM(LTRIM(ConOperFor))) = ( UPPER(RTRIM(LTRIM(?))))) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 40);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
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
               stmt.setString(3, (String)parms[2], 40);
               stmt.setVarchar(4, (String)parms[3], 100);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 40);
               stmt.setVarchar(4, (String)parms[3], 100);
               return;
      }
   }

}

