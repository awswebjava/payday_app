package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtoperandosformula2 extends GXProcedure
{
   public obtoperandosformula2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtoperandosformula2.class ), "" );
   }

   public obtoperandosformula2( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.SdtSDTOperandosFormula> executeUdp( int aP0 ,
                                                                   String aP1 ,
                                                                   String aP2 ,
                                                                   java.math.BigDecimal aP3 ,
                                                                   java.math.BigDecimal aP4 ,
                                                                   java.math.BigDecimal aP5 )
   {
      obtoperandosformula2.this.aP6 = new GXBaseCollection[] {new GXBaseCollection<web.SdtSDTOperandosFormula>()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        java.math.BigDecimal aP3 ,
                        java.math.BigDecimal aP4 ,
                        java.math.BigDecimal aP5 ,
                        GXBaseCollection<web.SdtSDTOperandosFormula>[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             java.math.BigDecimal aP3 ,
                             java.math.BigDecimal aP4 ,
                             java.math.BigDecimal aP5 ,
                             GXBaseCollection<web.SdtSDTOperandosFormula>[] aP6 )
   {
      obtoperandosformula2.this.AV27CliCod = aP0;
      obtoperandosformula2.this.AV18ConCodigo = aP1;
      obtoperandosformula2.this.AV12LiqDFormula = aP2;
      obtoperandosformula2.this.AV22LiqDCanti = aP3;
      obtoperandosformula2.this.AV24LiqDImporte = aP4;
      obtoperandosformula2.this.AV26LiqDValUni = aP5;
      obtoperandosformula2.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV21mismaCantidadPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV27CliCod, "[novedad_cantidad]", false, false, GXv_char1) ;
      obtoperandosformula2.this.AV21mismaCantidadPalabra = GXv_char1[0] ;
      GXv_char1[0] = AV23mismoImportePalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV27CliCod, "[novedad_importe]", false, false, GXv_char1) ;
      obtoperandosformula2.this.AV23mismoImportePalabra = GXv_char1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV27CliCod, 6, 0))+httpContext.getMessage( " &ConCodigo ", "")+GXutil.trim( AV18ConCodigo)) ;
      AV31GXLvl11 = (byte)(0) ;
      /* Using cursor P00ZX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV27CliCod), AV18ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P00ZX2_A26ConCodigo[0] ;
         A3CliCod = P00ZX2_A3CliCod[0] ;
         A923ConOperFor = P00ZX2_A923ConOperFor[0] ;
         A2119ConOpeId = P00ZX2_A2119ConOpeId[0] ;
         AV31GXLvl11 = (byte)(1) ;
         AV16SDTOperandosItem = (web.SdtSDTOperandosFormula)new web.SdtSDTOperandosFormula(remoteHandle, context);
         AV16SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Operandooriginal( A923ConOperFor );
         AV16SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Length( (short)(GXutil.len( A923ConOperFor)) );
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( A923ConOperFor)), GXutil.upper( GXutil.trim( AV21mismaCantidadPalabra))) == 0 )
         {
            AV16SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Operandocambiado( GXutil.trim( GXutil.str( AV22LiqDCanti, 14, 2)) );
            AV16SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Operandocambiado( localUtil.format( AV22LiqDCanti, "ZZ,ZZZ,ZZZ,ZZ9.99") );
            if ( GXutil.strcmp(AV18ConCodigo, httpContext.getMessage( "REM001", "")) == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "pone ", "")+GXutil.trim( GXutil.str( AV22LiqDCanti, 14, 2))) ;
            }
            AV16SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Operandocambiado2( localUtil.format( AV22LiqDCanti, "ZZ,ZZZ,ZZZ,ZZ9.99") );
         }
         AV15SDTOperandos.add(AV16SDTOperandosItem, 0);
         new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&SDTOperandos.Add(&SDTOperandosItem)", "")) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV31GXLvl11 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = obtoperandosformula2.this.AV15SDTOperandos;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15SDTOperandos = new GXBaseCollection<web.SdtSDTOperandosFormula>(web.SdtSDTOperandosFormula.class, "SDTOperandosFormula", "PayDay", remoteHandle);
      AV21mismaCantidadPalabra = "" ;
      AV23mismoImportePalabra = "" ;
      GXv_char1 = new String[1] ;
      AV30Pgmname = "" ;
      scmdbuf = "" ;
      P00ZX2_A26ConCodigo = new String[] {""} ;
      P00ZX2_A3CliCod = new int[1] ;
      P00ZX2_A923ConOperFor = new String[] {""} ;
      P00ZX2_A2119ConOpeId = new String[] {""} ;
      A26ConCodigo = "" ;
      A923ConOperFor = "" ;
      A2119ConOpeId = "" ;
      AV16SDTOperandosItem = new web.SdtSDTOperandosFormula(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtoperandosformula2__default(),
         new Object[] {
             new Object[] {
            P00ZX2_A26ConCodigo, P00ZX2_A3CliCod, P00ZX2_A923ConOperFor, P00ZX2_A2119ConOpeId
            }
         }
      );
      AV30Pgmname = "ObtOperandosFormula2" ;
      /* GeneXus formulas. */
      AV30Pgmname = "ObtOperandosFormula2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV31GXLvl11 ;
   private short Gx_err ;
   private int AV27CliCod ;
   private int A3CliCod ;
   private java.math.BigDecimal AV22LiqDCanti ;
   private java.math.BigDecimal AV24LiqDImporte ;
   private java.math.BigDecimal AV26LiqDValUni ;
   private String AV18ConCodigo ;
   private String AV21mismaCantidadPalabra ;
   private String AV23mismoImportePalabra ;
   private String GXv_char1[] ;
   private String AV30Pgmname ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A2119ConOpeId ;
   private String AV12LiqDFormula ;
   private String A923ConOperFor ;
   private GXBaseCollection<web.SdtSDTOperandosFormula>[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P00ZX2_A26ConCodigo ;
   private int[] P00ZX2_A3CliCod ;
   private String[] P00ZX2_A923ConOperFor ;
   private String[] P00ZX2_A2119ConOpeId ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> AV15SDTOperandos ;
   private web.SdtSDTOperandosFormula AV16SDTOperandosItem ;
}

final  class obtoperandosformula2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00ZX2", "SELECT ConCodigo, CliCod, ConOperFor, ConOpeId FROM concepto_operandos WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
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
               return;
      }
   }

}

