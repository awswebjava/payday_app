package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class f1357_calcularincrementadas extends GXProcedure
{
   public f1357_calcularincrementadas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( f1357_calcularincrementadas.class ), "" );
   }

   public f1357_calcularincrementadas( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           short aP2 ,
                                           int aP3 ,
                                           String aP4 ,
                                           java.math.BigDecimal[] aP5 )
   {
      f1357_calcularincrementadas.this.aP6 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        int aP3 ,
                        String aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        java.math.BigDecimal[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             int aP3 ,
                             String aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             java.math.BigDecimal[] aP6 )
   {
      f1357_calcularincrementadas.this.AV9CliCod = aP0;
      f1357_calcularincrementadas.this.AV10EmpCod = aP1;
      f1357_calcularincrementadas.this.AV8LiqPerAno = aP2;
      f1357_calcularincrementadas.this.AV18Legnumero = aP3;
      f1357_calcularincrementadas.this.AV12dedEspecialIncrementadaConCodigo = aP4;
      f1357_calcularincrementadas.this.aP5 = aP5;
      f1357_calcularincrementadas.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "!incremen 1 &LiqPerAno ", "")+GXutil.trim( GXutil.str( AV8LiqPerAno, 4, 0))) ;
      AV11p = (short)(0) ;
      /* Using cursor P00V12 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), Short.valueOf(AV8LiqPerAno)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00V12_A3CliCod[0] ;
         A1EmpCod = P00V12_A1EmpCod[0] ;
         A585LiqPerAno = P00V12_A585LiqPerAno[0] ;
         A283LiqPeriodo = P00V12_A283LiqPeriodo[0] ;
         A31LiqNro = P00V12_A31LiqNro[0] ;
         A746LiqPerUltNorm = P00V12_A746LiqPerUltNorm[0] ;
         if ( !( GXutil.dateCompare(GXutil.resetTime(A746LiqPerUltNorm), GXutil.resetTime(AV27ultimoLiqPerUltNorm)) ) )
         {
            AV11p = (short)(AV11p+1) ;
            if ( AV11p <= 2 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "incremen 2 &p ", "")+GXutil.trim( GXutil.str( AV11p, 4, 0))+httpContext.getMessage( " LiqPerUltNorm ", "")+GXutil.trim( localUtil.dtoc( A746LiqPerUltNorm, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " LiqNro ", "")+GXutil.trim( GXutil.str( A31LiqNro, 8, 0))+httpContext.getMessage( " LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( A283LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
               AV16LiqNro = A31LiqNro ;
               AV17LiqPeriodo = A283LiqPeriodo ;
               /* Execute user subroutine: 'RECORRER' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               if ( AV11p == 1 )
               {
                  AV14F1357LDPEspIncremen1 = AV14F1357LDPEspIncremen1.add(AV13LiqDImpCalcu) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "&LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV13LiqDImpCalcu, 14, 2))+httpContext.getMessage( " &F1357LDPEspIncremen1 ", "")+GXutil.trim( GXutil.str( AV14F1357LDPEspIncremen1, 16, 2))) ;
               }
               else
               {
                  AV15F1357LDPEspIncremen2 = AV15F1357LDPEspIncremen2.add(AV13LiqDImpCalcu) ;
               }
            }
         }
         AV27ultimoLiqPerUltNorm = A746LiqPerUltNorm ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   public void S111( )
   {
      /* 'RECORRER' Routine */
      returnInSub = false ;
      GXt_char1 = AV23totalPalabra ;
      GXv_char2[0] = GXt_char1 ;
      new web.totalpalabra(remoteHandle, context).execute( AV9CliCod, GXv_char2) ;
      f1357_calcularincrementadas.this.GXt_char1 = GXv_char2[0] ;
      AV23totalPalabra = GXt_char1 ;
      AV19cantidadPalabra = httpContext.getMessage( "C", "") ;
      GXv_char2[0] = AV25conceptoPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV9CliCod, "{concepto}", false, true, GXv_char2) ;
      f1357_calcularincrementadas.this.AV25conceptoPalabra = GXv_char2[0] ;
      AV26tramoPalabra = "tramoGanancias" ;
      AV24operandoPalabra = GXutil.trim( AV25conceptoPalabra) + " " + GXutil.trim( AV12dedEspecialIncrementadaConCodigo) + " " + GXutil.trim( AV26tramoPalabra) ;
      AV29CriterioBusqueda = AV26tramoPalabra ;
      GXt_char1 = AV28Calculo ;
      GXv_char2[0] = GXt_char1 ;
      new web.sumapalabra(remoteHandle, context).execute( AV9CliCod, GXv_char2) ;
      f1357_calcularincrementadas.this.GXt_char1 = GXv_char2[0] ;
      AV28Calculo = GXt_char1 ;
      GXv_decimal3[0] = AV13LiqDImpCalcu ;
      GXv_boolean4[0] = false ;
      GXv_int5[0] = (short)(0) ;
      GXv_char2[0] = "" ;
      GXv_char6[0] = "" ;
      new web.obtvalformulacc2(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV16LiqNro, 0, "", AV17LiqPeriodo, "Recalculo", AV18Legnumero, AV12dedEspecialIncrementadaConCodigo, AV30ConceptoTipo, "", false, AV19cantidadPalabra, AV23totalPalabra, AV23totalPalabra, AV24operandoPalabra, AV29CriterioBusqueda, AV28Calculo, 0, "", GXv_decimal3, GXv_boolean4, GXv_int5, GXv_char2, GXv_char6) ;
      f1357_calcularincrementadas.this.AV13LiqDImpCalcu = GXv_decimal3[0] ;
   }

   protected void cleanup( )
   {
      this.aP5[0] = f1357_calcularincrementadas.this.AV14F1357LDPEspIncremen1;
      this.aP6[0] = f1357_calcularincrementadas.this.AV15F1357LDPEspIncremen2;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14F1357LDPEspIncremen1 = DecimalUtil.ZERO ;
      AV15F1357LDPEspIncremen2 = DecimalUtil.ZERO ;
      AV33Pgmname = "" ;
      scmdbuf = "" ;
      P00V12_A3CliCod = new int[1] ;
      P00V12_A1EmpCod = new short[1] ;
      P00V12_A585LiqPerAno = new short[1] ;
      P00V12_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00V12_A31LiqNro = new int[1] ;
      P00V12_A746LiqPerUltNorm = new java.util.Date[] {GXutil.nullDate()} ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A746LiqPerUltNorm = GXutil.nullDate() ;
      AV27ultimoLiqPerUltNorm = GXutil.nullDate() ;
      AV17LiqPeriodo = GXutil.nullDate() ;
      AV13LiqDImpCalcu = DecimalUtil.ZERO ;
      AV23totalPalabra = "" ;
      AV19cantidadPalabra = "" ;
      AV25conceptoPalabra = "" ;
      AV26tramoPalabra = "" ;
      AV24operandoPalabra = "" ;
      AV29CriterioBusqueda = "" ;
      AV28Calculo = "" ;
      GXt_char1 = "" ;
      AV30ConceptoTipo = "" ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_boolean4 = new boolean[1] ;
      GXv_int5 = new short[1] ;
      GXv_char2 = new String[1] ;
      GXv_char6 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.f1357_calcularincrementadas__default(),
         new Object[] {
             new Object[] {
            P00V12_A3CliCod, P00V12_A1EmpCod, P00V12_A585LiqPerAno, P00V12_A283LiqPeriodo, P00V12_A31LiqNro, P00V12_A746LiqPerUltNorm
            }
         }
      );
      AV33Pgmname = "F1357_calcularIncrementadas" ;
      /* GeneXus formulas. */
      AV33Pgmname = "F1357_calcularIncrementadas" ;
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short AV8LiqPerAno ;
   private short AV11p ;
   private short A1EmpCod ;
   private short A585LiqPerAno ;
   private short GXv_int5[] ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV18Legnumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int AV16LiqNro ;
   private java.math.BigDecimal AV14F1357LDPEspIncremen1 ;
   private java.math.BigDecimal AV15F1357LDPEspIncremen2 ;
   private java.math.BigDecimal AV13LiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private String AV12dedEspecialIncrementadaConCodigo ;
   private String AV33Pgmname ;
   private String scmdbuf ;
   private String AV23totalPalabra ;
   private String AV19cantidadPalabra ;
   private String AV25conceptoPalabra ;
   private String AV26tramoPalabra ;
   private String AV24operandoPalabra ;
   private String AV29CriterioBusqueda ;
   private String AV28Calculo ;
   private String GXt_char1 ;
   private String AV30ConceptoTipo ;
   private String GXv_char2[] ;
   private String GXv_char6[] ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date A746LiqPerUltNorm ;
   private java.util.Date AV27ultimoLiqPerUltNorm ;
   private java.util.Date AV17LiqPeriodo ;
   private boolean returnInSub ;
   private boolean GXv_boolean4[] ;
   private java.math.BigDecimal[] aP6 ;
   private java.math.BigDecimal[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P00V12_A3CliCod ;
   private short[] P00V12_A1EmpCod ;
   private short[] P00V12_A585LiqPerAno ;
   private java.util.Date[] P00V12_A283LiqPeriodo ;
   private int[] P00V12_A31LiqNro ;
   private java.util.Date[] P00V12_A746LiqPerUltNorm ;
}

final  class f1357_calcularincrementadas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00V12", "SELECT CliCod, EmpCod, LiqPerAno, LiqPeriodo, LiqNro, LiqPerUltNorm FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqPerAno = ? ORDER BY CliCod, EmpCod, LiqPerAno, LiqPerUltNorm, LiqNro DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

