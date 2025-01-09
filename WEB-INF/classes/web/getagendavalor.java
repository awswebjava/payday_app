package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getagendavalor extends GXProcedure
{
   public getagendavalor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getagendavalor.class ), "" );
   }

   public getagendavalor( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              java.util.Date aP4 ,
                              java.util.Date aP5 ,
                              java.util.Date aP6 ,
                              String aP7 ,
                              boolean aP8 ,
                              java.math.BigDecimal[] aP9 ,
                              java.math.BigDecimal[] aP10 ,
                              java.math.BigDecimal[] aP11 )
   {
      getagendavalor.this.aP12 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        java.util.Date aP5 ,
                        java.util.Date aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        java.math.BigDecimal[] aP11 ,
                        boolean[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             java.util.Date aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             java.math.BigDecimal[] aP11 ,
                             boolean[] aP12 )
   {
      getagendavalor.this.AV16CliCod = aP0;
      getagendavalor.this.AV14EmpCod = aP1;
      getagendavalor.this.AV15LiqNro = aP2;
      getagendavalor.this.AV8LegNumero = aP3;
      getagendavalor.this.AV18paramLiqPeriodo = aP4;
      getagendavalor.this.AV22parmAgeFecDes = aP5;
      getagendavalor.this.AV23parmAgeFecHas = aP6;
      getagendavalor.this.AV9ConCodigo = aP7;
      getagendavalor.this.AV24soloAgendaLibre = aP8;
      getagendavalor.this.aP9 = aP9;
      getagendavalor.this.aP10 = aP10;
      getagendavalor.this.aP11 = aP11;
      getagendavalor.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, "1") ;
      if ( ! (0==AV15LiqNro) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, "2") ;
         /* Using cursor P00CL2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV16CliCod), Short.valueOf(AV14EmpCod), Integer.valueOf(AV15LiqNro)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A31LiqNro = P00CL2_A31LiqNro[0] ;
            A1EmpCod = P00CL2_A1EmpCod[0] ;
            A3CliCod = P00CL2_A3CliCod[0] ;
            A283LiqPeriodo = P00CL2_A283LiqPeriodo[0] ;
            AV17LiqPeriodo = A283LiqPeriodo ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, "3") ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         AV21AgeFecHas = AV17LiqPeriodo ;
         AV20AgeFecDes = AV17LiqPeriodo ;
      }
      else
      {
         AV21AgeFecHas = AV23parmAgeFecHas ;
         AV20AgeFecDes = AV22parmAgeFecDes ;
      }
      GXv_decimal1[0] = AV11AgeCanti ;
      GXv_decimal2[0] = AV12AgeVUnit ;
      GXv_decimal3[0] = AV13AgeImporte ;
      GXv_boolean4[0] = AV19existe ;
      new web.getagendavalorenrango(remoteHandle, context).execute( AV16CliCod, AV14EmpCod, AV8LegNumero, AV9ConCodigo, AV20AgeFecDes, AV21AgeFecHas, (short)(0), AV24soloAgendaLibre, GXv_decimal1, GXv_decimal2, GXv_decimal3, GXv_boolean4) ;
      getagendavalor.this.AV11AgeCanti = GXv_decimal1[0] ;
      getagendavalor.this.AV12AgeVUnit = GXv_decimal2[0] ;
      getagendavalor.this.AV13AgeImporte = GXv_decimal3[0] ;
      getagendavalor.this.AV19existe = GXv_boolean4[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "4 &AgeFecHas ", "")+GXutil.trim( localUtil.dtoc( AV21AgeFecHas, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &AgeFecDes ", "")+GXutil.trim( localUtil.dtoc( AV20AgeFecDes, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &ConCodigo ", "")+AV9ConCodigo+httpContext.getMessage( " &AgeCanti ", "")+GXutil.trim( GXutil.str( AV11AgeCanti, 9, 2))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = getagendavalor.this.AV11AgeCanti;
      this.aP10[0] = getagendavalor.this.AV12AgeVUnit;
      this.aP11[0] = getagendavalor.this.AV13AgeImporte;
      this.aP12[0] = getagendavalor.this.AV19existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11AgeCanti = DecimalUtil.ZERO ;
      AV12AgeVUnit = DecimalUtil.ZERO ;
      AV13AgeImporte = DecimalUtil.ZERO ;
      AV27Pgmname = "" ;
      scmdbuf = "" ;
      P00CL2_A31LiqNro = new int[1] ;
      P00CL2_A1EmpCod = new short[1] ;
      P00CL2_A3CliCod = new int[1] ;
      P00CL2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      A283LiqPeriodo = GXutil.nullDate() ;
      AV17LiqPeriodo = GXutil.nullDate() ;
      AV21AgeFecHas = GXutil.nullDate() ;
      AV20AgeFecDes = GXutil.nullDate() ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_boolean4 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getagendavalor__default(),
         new Object[] {
             new Object[] {
            P00CL2_A31LiqNro, P00CL2_A1EmpCod, P00CL2_A3CliCod, P00CL2_A283LiqPeriodo
            }
         }
      );
      AV27Pgmname = "getAgendaValor" ;
      /* GeneXus formulas. */
      AV27Pgmname = "getAgendaValor" ;
      Gx_err = (short)(0) ;
   }

   private short AV14EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV16CliCod ;
   private int AV15LiqNro ;
   private int AV8LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private java.math.BigDecimal AV11AgeCanti ;
   private java.math.BigDecimal AV12AgeVUnit ;
   private java.math.BigDecimal AV13AgeImporte ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private String AV9ConCodigo ;
   private String AV27Pgmname ;
   private String scmdbuf ;
   private java.util.Date AV18paramLiqPeriodo ;
   private java.util.Date AV22parmAgeFecDes ;
   private java.util.Date AV23parmAgeFecHas ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date AV17LiqPeriodo ;
   private java.util.Date AV21AgeFecHas ;
   private java.util.Date AV20AgeFecDes ;
   private boolean AV24soloAgendaLibre ;
   private boolean AV19existe ;
   private boolean Cond_result ;
   private boolean GXv_boolean4[] ;
   private boolean[] aP12 ;
   private java.math.BigDecimal[] aP9 ;
   private java.math.BigDecimal[] aP10 ;
   private java.math.BigDecimal[] aP11 ;
   private IDataStoreProvider pr_default ;
   private int[] P00CL2_A31LiqNro ;
   private short[] P00CL2_A1EmpCod ;
   private int[] P00CL2_A3CliCod ;
   private java.util.Date[] P00CL2_A283LiqPeriodo ;
}

final  class getagendavalor__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00CL2", "SELECT LiqNro, EmpCod, CliCod, LiqPeriodo FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

