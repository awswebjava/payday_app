package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdatosliqlegtest extends GXProcedure
{
   public getdatosliqlegtest( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdatosliqlegtest.class ), "" );
   }

   public getdatosliqlegtest( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           short aP4 ,
                                           java.math.BigDecimal[] aP5 ,
                                           java.math.BigDecimal[] aP6 ,
                                           java.math.BigDecimal[] aP7 ,
                                           java.math.BigDecimal[] aP8 ,
                                           short[] aP9 ,
                                           short[] aP10 ,
                                           short[] aP11 )
   {
      getdatosliqlegtest.this.aP12 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        short aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        short[] aP9 ,
                        short[] aP10 ,
                        short[] aP11 ,
                        java.math.BigDecimal[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             short aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             short[] aP9 ,
                             short[] aP10 ,
                             short[] aP11 ,
                             java.math.BigDecimal[] aP12 )
   {
      getdatosliqlegtest.this.AV20CliCod = aP0;
      getdatosliqlegtest.this.AV8EmpCod = aP1;
      getdatosliqlegtest.this.AV9LiqNro = aP2;
      getdatosliqlegtest.this.AV23LegNumero = aP3;
      getdatosliqlegtest.this.AV36TestNro = aP4;
      getdatosliqlegtest.this.aP5 = aP5;
      getdatosliqlegtest.this.aP6 = aP6;
      getdatosliqlegtest.this.aP7 = aP7;
      getdatosliqlegtest.this.aP8 = aP8;
      getdatosliqlegtest.this.aP9 = aP9;
      getdatosliqlegtest.this.aP10 = aP10;
      getdatosliqlegtest.this.aP11 = aP11;
      getdatosliqlegtest.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "1 "+GXutil.trim( GXutil.str( AV23LegNumero, 8, 0))) ;
      /* Using cursor P016J2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV20CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV23LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P016J2_A6LegNumero[0] ;
         A1EmpCod = P016J2_A1EmpCod[0] ;
         A3CliCod = P016J2_A3CliCod[0] ;
         A281LiqLegImpTotal = P016J2_A281LiqLegImpTotal[0] ;
         A757LiqLegImpTotRetGan = P016J2_A757LiqLegImpTotRetGan[0] ;
         A31LiqNro = P016J2_A31LiqNro[0] ;
         A577LiqLegImpTotRemu = P016J2_A577LiqLegImpTotRemu[0] ;
         A579LiqLegImpTotDescu = P016J2_A579LiqLegImpTotDescu[0] ;
         A578LiqLegImpTotNoRemu = P016J2_A578LiqLegImpTotNoRemu[0] ;
         A883LIqLegIteraciones = P016J2_A883LIqLegIteraciones[0] ;
         AV25LiqImpNeto = AV25LiqImpNeto.add(A281LiqLegImpTotal) ;
         AV37LiqLegImpTotRetGan = AV37LiqLegImpTotRetGan.add(A757LiqLegImpTotRetGan) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "LiqLegImpTotal ", "")+GXutil.trim( GXutil.str( A281LiqLegImpTotal, 14, 2))+httpContext.getMessage( " &LiqImpNeto ", "")+GXutil.str( AV25LiqImpNeto, 14, 2)+httpContext.getMessage( " liqnro ", "")+GXutil.trim( GXutil.str( A31LiqNro, 8, 0))) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "3") ;
         AV26LiqLegImpTotRemu = AV26LiqLegImpTotRemu.add(A577LiqLegImpTotRemu) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "4") ;
         AV27LiqLegImpTotDescu = AV27LiqLegImpTotDescu.add(A579LiqLegImpTotDescu) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "5") ;
         AV28LiqLegImpTotNoRemu = AV28LiqLegImpTotNoRemu.add(A578LiqLegImpTotNoRemu) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "6") ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "7") ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "8") ;
         if ( (0==AV34LIqLegIteraciones) )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "9") ;
            AV34LIqLegIteraciones = A883LIqLegIteraciones ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "10") ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "11") ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "12") ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "15") ;
      AV31TestSegTotal = (short)(DecimalUtil.decToDouble(AV35totalLiqSegundos)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "16") ;
      AV32TestVueltas = AV34LIqLegIteraciones ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "17") ;
      /* Using cursor P016J3 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV36TestNro)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A1083TestNro = P016J3_A1083TestNro[0] ;
         A1088TestSegLiq = P016J3_A1088TestSegLiq[0] ;
         A1089TestSegTotal = P016J3_A1089TestSegTotal[0] ;
         A1090TestVueltas = P016J3_A1090TestVueltas[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "18") ;
         A1088TestSegLiq = AV30TestSegLiq ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "19") ;
         A1089TestSegTotal = AV31TestSegTotal ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "20") ;
         A1090TestVueltas = AV32TestVueltas ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "21") ;
         /* Using cursor P016J4 */
         pr_default.execute(2, new Object[] {Short.valueOf(A1088TestSegLiq), Short.valueOf(A1089TestSegTotal), Short.valueOf(A1090TestVueltas), Short.valueOf(A1083TestNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Test");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
      new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "22") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getdatosliqlegtest.this.AV25LiqImpNeto;
      this.aP6[0] = getdatosliqlegtest.this.AV26LiqLegImpTotRemu;
      this.aP7[0] = getdatosliqlegtest.this.AV28LiqLegImpTotNoRemu;
      this.aP8[0] = getdatosliqlegtest.this.AV27LiqLegImpTotDescu;
      this.aP9[0] = getdatosliqlegtest.this.AV30TestSegLiq;
      this.aP10[0] = getdatosliqlegtest.this.AV31TestSegTotal;
      this.aP11[0] = getdatosliqlegtest.this.AV32TestVueltas;
      this.aP12[0] = getdatosliqlegtest.this.AV37LiqLegImpTotRetGan;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV25LiqImpNeto = DecimalUtil.ZERO ;
      AV26LiqLegImpTotRemu = DecimalUtil.ZERO ;
      AV28LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      AV27LiqLegImpTotDescu = DecimalUtil.ZERO ;
      AV37LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      AV40Pgmname = "" ;
      scmdbuf = "" ;
      P016J2_A6LegNumero = new int[1] ;
      P016J2_A1EmpCod = new short[1] ;
      P016J2_A3CliCod = new int[1] ;
      P016J2_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P016J2_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P016J2_A31LiqNro = new int[1] ;
      P016J2_A577LiqLegImpTotRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P016J2_A579LiqLegImpTotDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P016J2_A578LiqLegImpTotNoRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P016J2_A883LIqLegIteraciones = new short[1] ;
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      A757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      A577LiqLegImpTotRemu = DecimalUtil.ZERO ;
      A579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      A578LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      AV35totalLiqSegundos = DecimalUtil.ZERO ;
      P016J3_A1083TestNro = new short[1] ;
      P016J3_A1088TestSegLiq = new short[1] ;
      P016J3_A1089TestSegTotal = new short[1] ;
      P016J3_A1090TestVueltas = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getdatosliqlegtest__default(),
         new Object[] {
             new Object[] {
            P016J2_A6LegNumero, P016J2_A1EmpCod, P016J2_A3CliCod, P016J2_A281LiqLegImpTotal, P016J2_A757LiqLegImpTotRetGan, P016J2_A31LiqNro, P016J2_A577LiqLegImpTotRemu, P016J2_A579LiqLegImpTotDescu, P016J2_A578LiqLegImpTotNoRemu, P016J2_A883LIqLegIteraciones
            }
            , new Object[] {
            P016J3_A1083TestNro, P016J3_A1088TestSegLiq, P016J3_A1089TestSegTotal, P016J3_A1090TestVueltas
            }
            , new Object[] {
            }
         }
      );
      AV40Pgmname = "getDatosLiqLegTest" ;
      /* GeneXus formulas. */
      AV40Pgmname = "getDatosLiqLegTest" ;
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short AV36TestNro ;
   private short AV30TestSegLiq ;
   private short AV31TestSegTotal ;
   private short AV32TestVueltas ;
   private short A1EmpCod ;
   private short A883LIqLegIteraciones ;
   private short AV34LIqLegIteraciones ;
   private short A1083TestNro ;
   private short A1088TestSegLiq ;
   private short A1089TestSegTotal ;
   private short A1090TestVueltas ;
   private short Gx_err ;
   private int AV20CliCod ;
   private int AV9LiqNro ;
   private int AV23LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private java.math.BigDecimal AV25LiqImpNeto ;
   private java.math.BigDecimal AV26LiqLegImpTotRemu ;
   private java.math.BigDecimal AV28LiqLegImpTotNoRemu ;
   private java.math.BigDecimal AV27LiqLegImpTotDescu ;
   private java.math.BigDecimal AV37LiqLegImpTotRetGan ;
   private java.math.BigDecimal A281LiqLegImpTotal ;
   private java.math.BigDecimal A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal A577LiqLegImpTotRemu ;
   private java.math.BigDecimal A579LiqLegImpTotDescu ;
   private java.math.BigDecimal A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal AV35totalLiqSegundos ;
   private String AV40Pgmname ;
   private String scmdbuf ;
   private java.math.BigDecimal[] aP12 ;
   private java.math.BigDecimal[] aP5 ;
   private java.math.BigDecimal[] aP6 ;
   private java.math.BigDecimal[] aP7 ;
   private java.math.BigDecimal[] aP8 ;
   private short[] aP9 ;
   private short[] aP10 ;
   private short[] aP11 ;
   private IDataStoreProvider pr_default ;
   private int[] P016J2_A6LegNumero ;
   private short[] P016J2_A1EmpCod ;
   private int[] P016J2_A3CliCod ;
   private java.math.BigDecimal[] P016J2_A281LiqLegImpTotal ;
   private java.math.BigDecimal[] P016J2_A757LiqLegImpTotRetGan ;
   private int[] P016J2_A31LiqNro ;
   private java.math.BigDecimal[] P016J2_A577LiqLegImpTotRemu ;
   private java.math.BigDecimal[] P016J2_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] P016J2_A578LiqLegImpTotNoRemu ;
   private short[] P016J2_A883LIqLegIteraciones ;
   private short[] P016J3_A1083TestNro ;
   private short[] P016J3_A1088TestSegLiq ;
   private short[] P016J3_A1089TestSegTotal ;
   private short[] P016J3_A1090TestVueltas ;
}

final  class getdatosliqlegtest__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P016J2", "SELECT LegNumero, EmpCod, CliCod, LiqLegImpTotal, LiqLegImpTotRetGan, LiqNro, LiqLegImpTotRemu, LiqLegImpTotDescu, LiqLegImpTotNoRemu, LIqLegIteraciones FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P016J3", "SELECT TestNro, TestSegLiq, TestSegTotal, TestVueltas FROM Test WHERE TestNro = ? ORDER BY TestNro  FOR UPDATE OF Test",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P016J4", "SAVEPOINT gxupdate;UPDATE Test SET TestSegLiq=?, TestSegTotal=?, TestVueltas=?  WHERE TestNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

