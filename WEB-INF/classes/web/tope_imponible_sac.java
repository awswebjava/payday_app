package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tope_imponible_sac extends GXProcedure
{
   public tope_imponible_sac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tope_imponible_sac.class ), "" );
   }

   public tope_imponible_sac( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             byte[] aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             short[] aP11 ,
                             String[] aP12 )
   {
      tope_imponible_sac.this.aP13 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        byte[] aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        short[] aP11 ,
                        String[] aP12 ,
                        String[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             byte[] aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             short[] aP11 ,
                             String[] aP12 ,
                             String[] aP13 )
   {
      tope_imponible_sac.this.AV19CliCod = aP0;
      tope_imponible_sac.this.AV23EmpCod = aP1;
      tope_imponible_sac.this.AV25LiqNro = aP2;
      tope_imponible_sac.this.AV77LiqRelNro = aP3;
      tope_imponible_sac.this.AV24LegNumero = aP4;
      tope_imponible_sac.this.AV21LiqPeriodo = aP5;
      tope_imponible_sac.this.AV70ProcesoLiquidacion = aP6;
      tope_imponible_sac.this.AV71insertandoConceptos = aP7;
      tope_imponible_sac.this.aP8 = aP8;
      tope_imponible_sac.this.aP9 = aP9;
      tope_imponible_sac.this.aP10 = aP10;
      tope_imponible_sac.this.aP11 = aP11;
      tope_imponible_sac.this.aP12 = aP12;
      tope_imponible_sac.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV45esAporte = true ;
      AV9LiqDCalculado = (byte)(1) ;
      AV11hastaTipoConCod = "REM_ARG" ;
      GXt_char1 = AV27subtipoSAC ;
      GXv_char2[0] = GXt_char1 ;
      new web.subtiposac(remoteHandle, context).execute( GXv_char2) ;
      tope_imponible_sac.this.GXt_char1 = GXv_char2[0] ;
      AV27subtipoSAC = GXt_char1 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV80Pgmname, "1") ;
      GXt_char1 = AV30subtipo2SACPropor ;
      GXv_char2[0] = GXt_char1 ;
      new web.subtipo2sacpropor(remoteHandle, context).execute( GXv_char2) ;
      tope_imponible_sac.this.GXt_char1 = GXv_char2[0] ;
      AV30subtipo2SACPropor = GXt_char1 ;
      AV81GXLvl14 = (byte)(0) ;
      /* Using cursor P01572 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV19CliCod), Short.valueOf(AV23EmpCod), Integer.valueOf(AV24LegNumero), Integer.valueOf(AV25LiqNro), Integer.valueOf(AV77LiqRelNro), AV21LiqPeriodo, AV11hastaTipoConCod, AV27subtipoSAC});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2112LiqRelNro = P01572_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01572_n2112LiqRelNro[0] ;
         A468DSubTipoConCod1 = P01572_A468DSubTipoConCod1[0] ;
         n468DSubTipoConCod1 = P01572_n468DSubTipoConCod1[0] ;
         A464DTipoConCod = P01572_A464DTipoConCod[0] ;
         A6LegNumero = P01572_A6LegNumero[0] ;
         A283LiqPeriodo = P01572_A283LiqPeriodo[0] ;
         A31LiqNro = P01572_A31LiqNro[0] ;
         A1EmpCod = P01572_A1EmpCod[0] ;
         A3CliCod = P01572_A3CliCod[0] ;
         A732DSubTipoConCod2 = P01572_A732DSubTipoConCod2[0] ;
         n732DSubTipoConCod2 = P01572_n732DSubTipoConCod2[0] ;
         A764LiqDImpReCalcu = P01572_A764LiqDImpReCalcu[0] ;
         A394DConCodigo = P01572_A394DConCodigo[0] ;
         A507LiqDCalculado = P01572_A507LiqDCalculado[0] ;
         A763LiqDRecalculado = P01572_A763LiqDRecalculado[0] ;
         A393DConDescrip = P01572_A393DConDescrip[0] ;
         A81LiqDSecuencial = P01572_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P01572_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01572_n2112LiqRelNro[0] ;
         A283LiqPeriodo = P01572_A283LiqPeriodo[0] ;
         AV81GXLvl14 = (byte)(1) ;
         if ( GXutil.strcmp(A732DSubTipoConCod2, AV30subtipo2SACPropor) == 0 )
         {
            AV31sacProporcionalImportes = AV31sacProporcionalImportes.add(A764LiqDImpReCalcu) ;
         }
         else
         {
            AV32sacImportes = AV32sacImportes.add(A764LiqDImpReCalcu) ;
         }
         new web.dependenciasesion(remoteHandle, context).execute( A394DConCodigo) ;
         GXv_int3[0] = AV74auxLiqDCalculado ;
         new web.dependenciaresuelta2(remoteHandle, context).execute( AV19CliCod, A394DConCodigo, AV70ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int3) ;
         tope_imponible_sac.this.AV74auxLiqDCalculado = GXv_int3[0] ;
         if ( AV74auxLiqDCalculado == 0 )
         {
            AV9LiqDCalculado = (byte)(0) ;
            AV35error = httpContext.getMessage( "Falta calcular ", "") + GXutil.trim( A393DConDescrip) ;
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV81GXLvl14 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV80Pgmname, httpContext.getMessage( "none", "")) ;
      }
      GXv_int4[0] = AV17dias_mes ;
      new web.diasmes(remoteHandle, context).execute( AV19CliCod, AV21LiqPeriodo, GXv_int4) ;
      tope_imponible_sac.this.AV17dias_mes = GXv_int4[0] ;
      GXv_int3[0] = AV74auxLiqDCalculado ;
      GXv_char2[0] = AV75auxLiqDLog ;
      GXv_char5[0] = AV76auxError ;
      GXv_decimal6[0] = AV55baseImportes ;
      GXv_decimal7[0] = AV8Importe ;
      GXv_int4[0] = AV56cantidadCalculada ;
      new web.maximo_imponible_sac(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV25LiqNro, AV77LiqRelNro, AV24LegNumero, AV21LiqPeriodo, AV17dias_mes, AV32sacImportes, AV31sacProporcionalImportes, AV45esAporte, AV70ProcesoLiquidacion, AV71insertandoConceptos, GXv_int3, GXv_char2, GXv_char5, GXv_decimal6, GXv_decimal7, GXv_int4) ;
      tope_imponible_sac.this.AV74auxLiqDCalculado = GXv_int3[0] ;
      tope_imponible_sac.this.AV75auxLiqDLog = GXv_char2[0] ;
      tope_imponible_sac.this.AV76auxError = GXv_char5[0] ;
      tope_imponible_sac.this.AV55baseImportes = GXv_decimal6[0] ;
      tope_imponible_sac.this.AV8Importe = GXv_decimal7[0] ;
      tope_imponible_sac.this.AV56cantidadCalculada = GXv_int4[0] ;
      if ( AV74auxLiqDCalculado == 0 )
      {
         AV9LiqDCalculado = (byte)(0) ;
         AV35error = GXutil.trim( AV76auxError) ;
         AV57LiqDLog = GXutil.trim( AV35error) ;
      }
      else
      {
         AV57LiqDLog += AV75auxLiqDLog ;
         if ( AV8Importe.doubleValue() > 0 )
         {
            GXt_char1 = AV64baseImpSacConCodigo ;
            GXt_char8 = AV64baseImpSacConCodigo ;
            GXv_char5[0] = GXt_char8 ;
            new web.concepto_topeimponiblesac_codigoparam(remoteHandle, context).execute( GXv_char5) ;
            tope_imponible_sac.this.GXt_char8 = GXv_char5[0] ;
            GXv_char2[0] = GXt_char1 ;
            new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char8, GXv_char2) ;
            tope_imponible_sac.this.GXt_char1 = GXv_char2[0] ;
            AV64baseImpSacConCodigo = GXt_char1 ;
            GXv_decimal7[0] = AV65baseImpSacLiqDImpCalcu ;
            new web.getliqdimpcalcu_periodoliqant(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV25LiqNro, AV24LegNumero, AV21LiqPeriodo, AV64baseImpSacConCodigo, false, GXv_decimal7) ;
            tope_imponible_sac.this.AV65baseImpSacLiqDImpCalcu = GXv_decimal7[0] ;
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65baseImpSacLiqDImpCalcu)==0) )
            {
               AV8Importe = AV8Importe.subtract(AV65baseImpSacLiqDImpCalcu) ;
               AV57LiqDLog += httpContext.getMessage( ". Se resta ", "") + GXutil.trim( GXutil.str( AV65baseImpSacLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " correspondientes a liquidaciones anteriores del periodo", "") ;
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = tope_imponible_sac.this.AV8Importe;
      this.aP9[0] = tope_imponible_sac.this.AV9LiqDCalculado;
      this.aP10[0] = tope_imponible_sac.this.AV55baseImportes;
      this.aP11[0] = tope_imponible_sac.this.AV56cantidadCalculada;
      this.aP12[0] = tope_imponible_sac.this.AV35error;
      this.aP13[0] = tope_imponible_sac.this.AV57LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Importe = DecimalUtil.ZERO ;
      AV55baseImportes = DecimalUtil.ZERO ;
      AV35error = "" ;
      AV57LiqDLog = "" ;
      AV11hastaTipoConCod = "" ;
      AV27subtipoSAC = "" ;
      AV80Pgmname = "" ;
      AV30subtipo2SACPropor = "" ;
      scmdbuf = "" ;
      P01572_A2112LiqRelNro = new int[1] ;
      P01572_n2112LiqRelNro = new boolean[] {false} ;
      P01572_A468DSubTipoConCod1 = new String[] {""} ;
      P01572_n468DSubTipoConCod1 = new boolean[] {false} ;
      P01572_A464DTipoConCod = new String[] {""} ;
      P01572_A6LegNumero = new int[1] ;
      P01572_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01572_A31LiqNro = new int[1] ;
      P01572_A1EmpCod = new short[1] ;
      P01572_A3CliCod = new int[1] ;
      P01572_A732DSubTipoConCod2 = new String[] {""} ;
      P01572_n732DSubTipoConCod2 = new boolean[] {false} ;
      P01572_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01572_A394DConCodigo = new String[] {""} ;
      P01572_A507LiqDCalculado = new byte[1] ;
      P01572_A763LiqDRecalculado = new short[1] ;
      P01572_A393DConDescrip = new String[] {""} ;
      P01572_A81LiqDSecuencial = new int[1] ;
      A468DSubTipoConCod1 = "" ;
      A464DTipoConCod = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A732DSubTipoConCod2 = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A394DConCodigo = "" ;
      A393DConDescrip = "" ;
      AV31sacProporcionalImportes = DecimalUtil.ZERO ;
      AV32sacImportes = DecimalUtil.ZERO ;
      GXv_int3 = new byte[1] ;
      AV75auxLiqDLog = "" ;
      AV76auxError = "" ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXv_int4 = new short[1] ;
      AV64baseImpSacConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char8 = "" ;
      GXv_char5 = new String[1] ;
      GXv_char2 = new String[1] ;
      AV65baseImpSacLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tope_imponible_sac__default(),
         new Object[] {
             new Object[] {
            P01572_A2112LiqRelNro, P01572_n2112LiqRelNro, P01572_A468DSubTipoConCod1, P01572_n468DSubTipoConCod1, P01572_A464DTipoConCod, P01572_A6LegNumero, P01572_A283LiqPeriodo, P01572_A31LiqNro, P01572_A1EmpCod, P01572_A3CliCod,
            P01572_A732DSubTipoConCod2, P01572_n732DSubTipoConCod2, P01572_A764LiqDImpReCalcu, P01572_A394DConCodigo, P01572_A507LiqDCalculado, P01572_A763LiqDRecalculado, P01572_A393DConDescrip, P01572_A81LiqDSecuencial
            }
         }
      );
      AV80Pgmname = "tope_imponible_sac" ;
      /* GeneXus formulas. */
      AV80Pgmname = "tope_imponible_sac" ;
      Gx_err = (short)(0) ;
   }

   private byte AV9LiqDCalculado ;
   private byte AV81GXLvl14 ;
   private byte A507LiqDCalculado ;
   private byte AV74auxLiqDCalculado ;
   private byte GXv_int3[] ;
   private short AV23EmpCod ;
   private short AV56cantidadCalculada ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short AV17dias_mes ;
   private short GXv_int4[] ;
   private short Gx_err ;
   private int AV19CliCod ;
   private int AV25LiqNro ;
   private int AV77LiqRelNro ;
   private int AV24LegNumero ;
   private int A2112LiqRelNro ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV8Importe ;
   private java.math.BigDecimal AV55baseImportes ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal AV31sacProporcionalImportes ;
   private java.math.BigDecimal AV32sacImportes ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal AV65baseImpSacLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private String AV70ProcesoLiquidacion ;
   private String AV11hastaTipoConCod ;
   private String AV27subtipoSAC ;
   private String AV80Pgmname ;
   private String AV30subtipo2SACPropor ;
   private String scmdbuf ;
   private String A468DSubTipoConCod1 ;
   private String A464DTipoConCod ;
   private String A732DSubTipoConCod2 ;
   private String A394DConCodigo ;
   private String AV64baseImpSacConCodigo ;
   private String GXt_char1 ;
   private String GXt_char8 ;
   private String GXv_char5[] ;
   private String GXv_char2[] ;
   private java.util.Date AV21LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private boolean AV71insertandoConceptos ;
   private boolean AV45esAporte ;
   private boolean n2112LiqRelNro ;
   private boolean n468DSubTipoConCod1 ;
   private boolean n732DSubTipoConCod2 ;
   private boolean returnInSub ;
   private String AV57LiqDLog ;
   private String AV75auxLiqDLog ;
   private String AV35error ;
   private String A393DConDescrip ;
   private String AV76auxError ;
   private String[] aP13 ;
   private java.math.BigDecimal[] aP8 ;
   private byte[] aP9 ;
   private java.math.BigDecimal[] aP10 ;
   private short[] aP11 ;
   private String[] aP12 ;
   private IDataStoreProvider pr_default ;
   private int[] P01572_A2112LiqRelNro ;
   private boolean[] P01572_n2112LiqRelNro ;
   private String[] P01572_A468DSubTipoConCod1 ;
   private boolean[] P01572_n468DSubTipoConCod1 ;
   private String[] P01572_A464DTipoConCod ;
   private int[] P01572_A6LegNumero ;
   private java.util.Date[] P01572_A283LiqPeriodo ;
   private int[] P01572_A31LiqNro ;
   private short[] P01572_A1EmpCod ;
   private int[] P01572_A3CliCod ;
   private String[] P01572_A732DSubTipoConCod2 ;
   private boolean[] P01572_n732DSubTipoConCod2 ;
   private java.math.BigDecimal[] P01572_A764LiqDImpReCalcu ;
   private String[] P01572_A394DConCodigo ;
   private byte[] P01572_A507LiqDCalculado ;
   private short[] P01572_A763LiqDRecalculado ;
   private String[] P01572_A393DConDescrip ;
   private int[] P01572_A81LiqDSecuencial ;
}

final  class tope_imponible_sac__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01572", "SELECT T2.LiqRelNro, T1.DSubTipoConCod1, T1.DTipoConCod, T1.LegNumero, T2.LiqPeriodo, T1.LiqNro, T1.EmpCod, T1.CliCod, T1.DSubTipoConCod2, T1.LiqDImpReCalcu, T1.DConCodigo, T1.LiqDCalculado, T1.LiqDRecalculado, T1.DConDescrip, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?) AND (T1.LiqNro <= ?) AND (T2.LiqRelNro IS NULL or T2.LiqRelNro = ?) AND (T2.LiqPeriodo = ?) AND (T1.DTipoConCod = ( ?)) AND (T1.DSubTipoConCod1 = ( ?)) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 20);
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(5);
               ((int[]) buf[7])[0] = rslt.getInt(6);
               ((short[]) buf[8])[0] = rslt.getShort(7);
               ((int[]) buf[9])[0] = rslt.getInt(8);
               ((String[]) buf[10])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(10,2);
               ((String[]) buf[13])[0] = rslt.getString(11, 10);
               ((byte[]) buf[14])[0] = rslt.getByte(12);
               ((short[]) buf[15])[0] = rslt.getShort(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((int[]) buf[17])[0] = rslt.getInt(15);
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
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setString(8, (String)parms[7], 20);
               return;
      }
   }

}

