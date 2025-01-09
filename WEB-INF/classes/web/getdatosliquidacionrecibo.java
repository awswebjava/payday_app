package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdatosliquidacionrecibo extends GXProcedure
{
   public getdatosliquidacionrecibo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdatosliquidacionrecibo.class ), "" );
   }

   public getdatosliquidacionrecibo( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           String aP4 ,
                                           String aP5 ,
                                           String aP6 ,
                                           String[] aP7 ,
                                           String[] aP8 ,
                                           java.util.Date[] aP9 ,
                                           java.util.Date[] aP10 ,
                                           java.util.Date[] aP11 ,
                                           String[] aP12 ,
                                           String[] aP13 ,
                                           java.math.BigDecimal[] aP14 ,
                                           java.math.BigDecimal[] aP15 ,
                                           java.math.BigDecimal[] aP16 ,
                                           java.math.BigDecimal[] aP17 ,
                                           String[] aP18 )
   {
      getdatosliquidacionrecibo.this.aP19 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19);
      return aP19[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String[] aP7 ,
                        String[] aP8 ,
                        java.util.Date[] aP9 ,
                        java.util.Date[] aP10 ,
                        java.util.Date[] aP11 ,
                        String[] aP12 ,
                        String[] aP13 ,
                        java.math.BigDecimal[] aP14 ,
                        java.math.BigDecimal[] aP15 ,
                        java.math.BigDecimal[] aP16 ,
                        java.math.BigDecimal[] aP17 ,
                        String[] aP18 ,
                        java.math.BigDecimal[] aP19 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             java.util.Date[] aP9 ,
                             java.util.Date[] aP10 ,
                             java.util.Date[] aP11 ,
                             String[] aP12 ,
                             String[] aP13 ,
                             java.math.BigDecimal[] aP14 ,
                             java.math.BigDecimal[] aP15 ,
                             java.math.BigDecimal[] aP16 ,
                             java.math.BigDecimal[] aP17 ,
                             String[] aP18 ,
                             java.math.BigDecimal[] aP19 )
   {
      getdatosliquidacionrecibo.this.AV20CliCod = aP0;
      getdatosliquidacionrecibo.this.AV8EmpCod = aP1;
      getdatosliquidacionrecibo.this.AV9LiqNro = aP2;
      getdatosliquidacionrecibo.this.AV23LegNumero = aP3;
      getdatosliquidacionrecibo.this.AV31remuTipoConCod = aP4;
      getdatosliquidacionrecibo.this.AV32noRemuTipoConCod = aP5;
      getdatosliquidacionrecibo.this.AV33descuTipoConCod = aP6;
      getdatosliquidacionrecibo.this.aP7 = aP7;
      getdatosliquidacionrecibo.this.aP8 = aP8;
      getdatosliquidacionrecibo.this.aP9 = aP9;
      getdatosliquidacionrecibo.this.aP10 = aP10;
      getdatosliquidacionrecibo.this.aP11 = aP11;
      getdatosliquidacionrecibo.this.aP12 = aP12;
      getdatosliquidacionrecibo.this.aP13 = aP13;
      getdatosliquidacionrecibo.this.aP14 = aP14;
      getdatosliquidacionrecibo.this.aP15 = aP15;
      getdatosliquidacionrecibo.this.aP16 = aP16;
      getdatosliquidacionrecibo.this.aP17 = aP17;
      getdatosliquidacionrecibo.this.aP18 = aP18;
      getdatosliquidacionrecibo.this.aP19 = aP19;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00KU2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV20CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV23LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A33LiqDepBanCod = P00KU2_A33LiqDepBanCod[0] ;
         n33LiqDepBanCod = P00KU2_n33LiqDepBanCod[0] ;
         A6LegNumero = P00KU2_A6LegNumero[0] ;
         A31LiqNro = P00KU2_A31LiqNro[0] ;
         A1EmpCod = P00KU2_A1EmpCod[0] ;
         A3CliCod = P00KU2_A3CliCod[0] ;
         A340TliqDesc = P00KU2_A340TliqDesc[0] ;
         A280LiqFecPago = P00KU2_A280LiqFecPago[0] ;
         A581LiqDepPrvFec = P00KU2_A581LiqDepPrvFec[0] ;
         A513LiqPerSinDia = P00KU2_A513LiqPerSinDia[0] ;
         A580LiqDepPrvPer = P00KU2_A580LiqDepPrvPer[0] ;
         A283LiqPeriodo = P00KU2_A283LiqPeriodo[0] ;
         A582LiqDepBanDescrip = P00KU2_A582LiqDepBanDescrip[0] ;
         A32TLiqCod = P00KU2_A32TLiqCod[0] ;
         n32TLiqCod = P00KU2_n32TLiqCod[0] ;
         A33LiqDepBanCod = P00KU2_A33LiqDepBanCod[0] ;
         n33LiqDepBanCod = P00KU2_n33LiqDepBanCod[0] ;
         A280LiqFecPago = P00KU2_A280LiqFecPago[0] ;
         A581LiqDepPrvFec = P00KU2_A581LiqDepPrvFec[0] ;
         A513LiqPerSinDia = P00KU2_A513LiqPerSinDia[0] ;
         A580LiqDepPrvPer = P00KU2_A580LiqDepPrvPer[0] ;
         A582LiqDepBanDescrip = P00KU2_A582LiqDepBanDescrip[0] ;
         A340TliqDesc = P00KU2_A340TliqDesc[0] ;
         AV13TliqDesc = A340TliqDesc ;
         AV18LiqFecPago = A280LiqFecPago ;
         AV21LiqDepPrvFec = A581LiqDepPrvFec ;
         AV22LiqPerSinDia = A513LiqPerSinDia ;
         AV24LiqDepPrvPer = A580LiqDepPrvPer ;
         AV19LiqPeriodo = A283LiqPeriodo ;
         AV29LiqDepBanDescrip = A582LiqDepBanDescrip ;
         AV24LiqDepPrvPer = A580LiqDepPrvPer ;
         AV21LiqDepPrvFec = A581LiqDepPrvFec ;
         AV17TLiqCod = A32TLiqCod ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      GXv_char1[0] = AV35Parmvalue ;
      new web.getparametro(remoteHandle, context).execute( AV20CliCod, httpContext.getMessage( "testX", ""), GXv_char1) ;
      getdatosliquidacionrecibo.this.AV35Parmvalue = GXv_char1[0] ;
      AV34testEs = GXutil.boolval( AV35Parmvalue) ;
      if ( ! AV34testEs )
      {
         GXv_decimal2[0] = AV30LiqLegImpDescuNeg ;
         GXv_decimal3[0] = AV26LiqLegImpTotRemu ;
         GXv_decimal4[0] = AV28LiqLegImpTotNoRemu ;
         GXv_decimal5[0] = AV27LiqLegImpTotDescu ;
         new web.calculaimportesliqlegrecibo(remoteHandle, context).execute( AV20CliCod, AV8EmpCod, AV9LiqNro, AV23LegNumero, AV31remuTipoConCod, AV32noRemuTipoConCod, AV33descuTipoConCod, GXv_decimal2, GXv_decimal3, GXv_decimal4, GXv_decimal5) ;
         getdatosliquidacionrecibo.this.AV30LiqLegImpDescuNeg = GXv_decimal2[0] ;
         getdatosliquidacionrecibo.this.AV26LiqLegImpTotRemu = GXv_decimal3[0] ;
         getdatosliquidacionrecibo.this.AV28LiqLegImpTotNoRemu = GXv_decimal4[0] ;
         getdatosliquidacionrecibo.this.AV27LiqLegImpTotDescu = GXv_decimal5[0] ;
      }
      AV25LiqImpNeto = AV26LiqLegImpTotRemu.add(AV28LiqLegImpTotNoRemu).subtract(AV27LiqLegImpTotDescu).add(AV30LiqLegImpDescuNeg) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = getdatosliquidacionrecibo.this.AV13TliqDesc;
      this.aP8[0] = getdatosliquidacionrecibo.this.AV17TLiqCod;
      this.aP9[0] = getdatosliquidacionrecibo.this.AV18LiqFecPago;
      this.aP10[0] = getdatosliquidacionrecibo.this.AV21LiqDepPrvFec;
      this.aP11[0] = getdatosliquidacionrecibo.this.AV19LiqPeriodo;
      this.aP12[0] = getdatosliquidacionrecibo.this.AV22LiqPerSinDia;
      this.aP13[0] = getdatosliquidacionrecibo.this.AV24LiqDepPrvPer;
      this.aP14[0] = getdatosliquidacionrecibo.this.AV25LiqImpNeto;
      this.aP15[0] = getdatosliquidacionrecibo.this.AV26LiqLegImpTotRemu;
      this.aP16[0] = getdatosliquidacionrecibo.this.AV27LiqLegImpTotDescu;
      this.aP17[0] = getdatosliquidacionrecibo.this.AV28LiqLegImpTotNoRemu;
      this.aP18[0] = getdatosliquidacionrecibo.this.AV29LiqDepBanDescrip;
      this.aP19[0] = getdatosliquidacionrecibo.this.AV30LiqLegImpDescuNeg;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13TliqDesc = "" ;
      AV17TLiqCod = "" ;
      AV18LiqFecPago = GXutil.nullDate() ;
      AV21LiqDepPrvFec = GXutil.nullDate() ;
      AV19LiqPeriodo = GXutil.nullDate() ;
      AV22LiqPerSinDia = "" ;
      AV24LiqDepPrvPer = "" ;
      AV25LiqImpNeto = DecimalUtil.ZERO ;
      AV26LiqLegImpTotRemu = DecimalUtil.ZERO ;
      AV27LiqLegImpTotDescu = DecimalUtil.ZERO ;
      AV28LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      AV29LiqDepBanDescrip = "" ;
      AV30LiqLegImpDescuNeg = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P00KU2_A33LiqDepBanCod = new String[] {""} ;
      P00KU2_n33LiqDepBanCod = new boolean[] {false} ;
      P00KU2_A6LegNumero = new int[1] ;
      P00KU2_A31LiqNro = new int[1] ;
      P00KU2_A1EmpCod = new short[1] ;
      P00KU2_A3CliCod = new int[1] ;
      P00KU2_A340TliqDesc = new String[] {""} ;
      P00KU2_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P00KU2_A581LiqDepPrvFec = new java.util.Date[] {GXutil.nullDate()} ;
      P00KU2_A513LiqPerSinDia = new String[] {""} ;
      P00KU2_A580LiqDepPrvPer = new String[] {""} ;
      P00KU2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00KU2_A582LiqDepBanDescrip = new String[] {""} ;
      P00KU2_A32TLiqCod = new String[] {""} ;
      P00KU2_n32TLiqCod = new boolean[] {false} ;
      A33LiqDepBanCod = "" ;
      A340TliqDesc = "" ;
      A280LiqFecPago = GXutil.nullDate() ;
      A581LiqDepPrvFec = GXutil.nullDate() ;
      A513LiqPerSinDia = "" ;
      A580LiqDepPrvPer = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A582LiqDepBanDescrip = "" ;
      A32TLiqCod = "" ;
      AV35Parmvalue = "" ;
      GXv_char1 = new String[1] ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getdatosliquidacionrecibo__default(),
         new Object[] {
             new Object[] {
            P00KU2_A33LiqDepBanCod, P00KU2_n33LiqDepBanCod, P00KU2_A6LegNumero, P00KU2_A31LiqNro, P00KU2_A1EmpCod, P00KU2_A3CliCod, P00KU2_A340TliqDesc, P00KU2_A280LiqFecPago, P00KU2_A581LiqDepPrvFec, P00KU2_A513LiqPerSinDia,
            P00KU2_A580LiqDepPrvPer, P00KU2_A283LiqPeriodo, P00KU2_A582LiqDepBanDescrip, P00KU2_A32TLiqCod, P00KU2_n32TLiqCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV20CliCod ;
   private int AV9LiqNro ;
   private int AV23LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private java.math.BigDecimal AV25LiqImpNeto ;
   private java.math.BigDecimal AV26LiqLegImpTotRemu ;
   private java.math.BigDecimal AV27LiqLegImpTotDescu ;
   private java.math.BigDecimal AV28LiqLegImpTotNoRemu ;
   private java.math.BigDecimal AV30LiqLegImpDescuNeg ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private String AV31remuTipoConCod ;
   private String AV32noRemuTipoConCod ;
   private String AV33descuTipoConCod ;
   private String AV17TLiqCod ;
   private String AV22LiqPerSinDia ;
   private String AV24LiqDepPrvPer ;
   private String scmdbuf ;
   private String A33LiqDepBanCod ;
   private String A513LiqPerSinDia ;
   private String A580LiqDepPrvPer ;
   private String A32TLiqCod ;
   private String GXv_char1[] ;
   private java.util.Date AV18LiqFecPago ;
   private java.util.Date AV21LiqDepPrvFec ;
   private java.util.Date AV19LiqPeriodo ;
   private java.util.Date A280LiqFecPago ;
   private java.util.Date A581LiqDepPrvFec ;
   private java.util.Date A283LiqPeriodo ;
   private boolean n33LiqDepBanCod ;
   private boolean n32TLiqCod ;
   private boolean AV34testEs ;
   private String AV35Parmvalue ;
   private String AV13TliqDesc ;
   private String AV29LiqDepBanDescrip ;
   private String A340TliqDesc ;
   private String A582LiqDepBanDescrip ;
   private java.math.BigDecimal[] aP19 ;
   private String[] aP7 ;
   private String[] aP8 ;
   private java.util.Date[] aP9 ;
   private java.util.Date[] aP10 ;
   private java.util.Date[] aP11 ;
   private String[] aP12 ;
   private String[] aP13 ;
   private java.math.BigDecimal[] aP14 ;
   private java.math.BigDecimal[] aP15 ;
   private java.math.BigDecimal[] aP16 ;
   private java.math.BigDecimal[] aP17 ;
   private String[] aP18 ;
   private IDataStoreProvider pr_default ;
   private String[] P00KU2_A33LiqDepBanCod ;
   private boolean[] P00KU2_n33LiqDepBanCod ;
   private int[] P00KU2_A6LegNumero ;
   private int[] P00KU2_A31LiqNro ;
   private short[] P00KU2_A1EmpCod ;
   private int[] P00KU2_A3CliCod ;
   private String[] P00KU2_A340TliqDesc ;
   private java.util.Date[] P00KU2_A280LiqFecPago ;
   private java.util.Date[] P00KU2_A581LiqDepPrvFec ;
   private String[] P00KU2_A513LiqPerSinDia ;
   private String[] P00KU2_A580LiqDepPrvPer ;
   private java.util.Date[] P00KU2_A283LiqPeriodo ;
   private String[] P00KU2_A582LiqDepBanDescrip ;
   private String[] P00KU2_A32TLiqCod ;
   private boolean[] P00KU2_n32TLiqCod ;
}

final  class getdatosliquidacionrecibo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00KU2", "SELECT T2.LiqDepBanCod AS LiqDepBanCod, T1.LegNumero, T1.LiqNro, T1.EmpCod, T1.CliCod, T4.TliqDesc, T2.LiqFecPago, T2.LiqDepPrvFec, T2.LiqPerSinDia, T2.LiqDepPrvPer, T1.LiqPeriodo, T3.BanDescrip AS LiqDepBanDescrip, T1.TLiqCod FROM (((LiquidacionLegajo T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) LEFT JOIN Banco T3 ON T3.CliCod = T1.CliCod AND T3.BanCod = T2.LiqDepBanCod) LEFT JOIN TipoLiquidacion T4 ON T4.CliCod = T1.CliCod AND T4.TLiqCod = T1.TLiqCod) WHERE T1.CliCod = ? and T1.EmpCod = ? and T1.LiqNro = ? and T1.LegNumero = ? ORDER BY T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((String[]) buf[9])[0] = rslt.getString(9, 20);
               ((String[]) buf[10])[0] = rslt.getString(10, 20);
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDate(11);
               ((String[]) buf[12])[0] = rslt.getVarchar(12);
               ((String[]) buf[13])[0] = rslt.getString(13, 20);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

