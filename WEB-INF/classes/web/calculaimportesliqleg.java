package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calculaimportesliqleg extends GXProcedure
{
   public calculaimportesliqleg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculaimportesliqleg.class ), "" );
   }

   public calculaimportesliqleg( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            int aP3 ,
                            String aP4 ,
                            String aP5 ,
                            String aP6 ,
                            java.math.BigDecimal[] aP7 ,
                            java.math.BigDecimal[] aP8 ,
                            java.math.BigDecimal[] aP9 ,
                            java.math.BigDecimal[] aP10 ,
                            java.math.BigDecimal[] aP11 ,
                            java.math.BigDecimal[] aP12 ,
                            java.math.BigDecimal[] aP13 ,
                            java.math.BigDecimal[] aP14 ,
                            java.math.BigDecimal[] aP15 ,
                            java.math.BigDecimal[] aP16 ,
                            java.math.BigDecimal[] aP17 )
   {
      calculaimportesliqleg.this.aP18 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18);
      return aP18[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        java.math.BigDecimal[] aP11 ,
                        java.math.BigDecimal[] aP12 ,
                        java.math.BigDecimal[] aP13 ,
                        java.math.BigDecimal[] aP14 ,
                        java.math.BigDecimal[] aP15 ,
                        java.math.BigDecimal[] aP16 ,
                        java.math.BigDecimal[] aP17 ,
                        short[] aP18 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             java.math.BigDecimal[] aP11 ,
                             java.math.BigDecimal[] aP12 ,
                             java.math.BigDecimal[] aP13 ,
                             java.math.BigDecimal[] aP14 ,
                             java.math.BigDecimal[] aP15 ,
                             java.math.BigDecimal[] aP16 ,
                             java.math.BigDecimal[] aP17 ,
                             short[] aP18 )
   {
      calculaimportesliqleg.this.AV22CliCod = aP0;
      calculaimportesliqleg.this.AV25EmpCod = aP1;
      calculaimportesliqleg.this.AV34LiqNro = aP2;
      calculaimportesliqleg.this.AV27LegNumero = aP3;
      calculaimportesliqleg.this.AV15pagosAcuentaConCodigo = aP4;
      calculaimportesliqleg.this.AV17sacConCodigo = aP5;
      calculaimportesliqleg.this.AV19sacproporConCodigo = aP6;
      calculaimportesliqleg.this.aP7 = aP7;
      calculaimportesliqleg.this.aP8 = aP8;
      calculaimportesliqleg.this.aP9 = aP9;
      calculaimportesliqleg.this.aP10 = aP10;
      calculaimportesliqleg.this.aP11 = aP11;
      calculaimportesliqleg.this.aP12 = aP12;
      calculaimportesliqleg.this.aP13 = aP13;
      calculaimportesliqleg.this.aP14 = aP14;
      calculaimportesliqleg.this.aP15 = aP15;
      calculaimportesliqleg.this.aP16 = aP16;
      calculaimportesliqleg.this.aP17 = aP17;
      calculaimportesliqleg.this.aP18 = aP18;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV16retGanConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV22CliCod, new web.retencionganancias_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      calculaimportesliqleg.this.AV16retGanConCodigo = GXv_char1[0] ;
      GXv_char1[0] = AV8adelantoRetGanConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV22CliCod, new web.adelantoretencionganancias_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      calculaimportesliqleg.this.AV8adelantoRetGanConCodigo = GXv_char1[0] ;
      GXv_char1[0] = AV9DevGanConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV22CliCod, new web.concepto_devolucionganancias_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      calculaimportesliqleg.this.AV9DevGanConCodigo = GXv_char1[0] ;
      GXv_char1[0] = AV37remuTipoConCod ;
      GXv_char2[0] = AV35noRemuTipoConCod ;
      GXv_char3[0] = AV23descuTipoConCod ;
      new web.gettiposconceptocod(remoteHandle, context).execute( AV22CliCod, GXv_char1, GXv_char2, GXv_char3) ;
      calculaimportesliqleg.this.AV37remuTipoConCod = GXv_char1[0] ;
      calculaimportesliqleg.this.AV35noRemuTipoConCod = GXv_char2[0] ;
      calculaimportesliqleg.this.AV23descuTipoConCod = GXv_char3[0] ;
      AV38TipoConCod.add(AV37remuTipoConCod, 0);
      AV38TipoConCod.add(AV35noRemuTipoConCod, 0);
      AV38TipoConCod.add(AV23descuTipoConCod, 0);
      AV26i = (short)(1) ;
      while ( AV26i <= AV38TipoConCod.size() )
      {
         AV24DTipoConCod = (String)AV38TipoConCod.elementAt(-1+AV26i) ;
         AV45GXLvl21 = (byte)(0) ;
         /* Using cursor P02CI2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV22CliCod), Short.valueOf(AV25EmpCod), Integer.valueOf(AV34LiqNro), Integer.valueOf(AV27LegNumero), AV24DTipoConCod});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A464DTipoConCod = P02CI2_A464DTipoConCod[0] ;
            A6LegNumero = P02CI2_A6LegNumero[0] ;
            A31LiqNro = P02CI2_A31LiqNro[0] ;
            A1EmpCod = P02CI2_A1EmpCod[0] ;
            A3CliCod = P02CI2_A3CliCod[0] ;
            A764LiqDImpReCalcu = P02CI2_A764LiqDImpReCalcu[0] ;
            A394DConCodigo = P02CI2_A394DConCodigo[0] ;
            A732DSubTipoConCod2 = P02CI2_A732DSubTipoConCod2[0] ;
            n732DSubTipoConCod2 = P02CI2_n732DSubTipoConCod2[0] ;
            A468DSubTipoConCod1 = P02CI2_A468DSubTipoConCod1[0] ;
            n468DSubTipoConCod1 = P02CI2_n468DSubTipoConCod1[0] ;
            A270LiqDErrorDesc = P02CI2_A270LiqDErrorDesc[0] ;
            n270LiqDErrorDesc = P02CI2_n270LiqDErrorDesc[0] ;
            A81LiqDSecuencial = P02CI2_A81LiqDSecuencial[0] ;
            AV45GXLvl21 = (byte)(1) ;
            if ( GXutil.strcmp(A464DTipoConCod, "DES_ARG") == 0 )
            {
               AV39DetColumna1 = DecimalUtil.ZERO ;
               AV40DetColumna2 = DecimalUtil.ZERO ;
               if ( A764LiqDImpReCalcu.doubleValue() < 0 )
               {
                  AV21totalSumanImportes = AV21totalSumanImportes.add((A764LiqDImpReCalcu.multiply(DecimalUtil.doubleToDec(-1)))) ;
                  AV42descuentosNegativos = AV42descuentosNegativos.add((A764LiqDImpReCalcu.multiply(DecimalUtil.doubleToDec(-1)))) ;
               }
               else
               {
                  AV20totalRestanImportes = AV20totalRestanImportes.add((A764LiqDImpReCalcu.multiply(DecimalUtil.doubleToDec(-1)))) ;
               }
               if ( A764LiqDImpReCalcu.doubleValue() > 0 )
               {
                  AV41DetColumna3 = A764LiqDImpReCalcu ;
               }
               else
               {
                  AV41DetColumna3 = DecimalUtil.doubleToDec(0) ;
               }
               if ( ( GXutil.strcmp(GXutil.trim( A394DConCodigo), GXutil.trim( AV16retGanConCodigo)) == 0 ) || ( GXutil.strcmp(GXutil.trim( A394DConCodigo), GXutil.trim( AV8adelantoRetGanConCodigo)) == 0 ) || ( GXutil.strcmp(GXutil.trim( A394DConCodigo), GXutil.trim( AV9DevGanConCodigo)) == 0 ) )
               {
                  AV14LiqLegImpTotRetGan = AV14LiqLegImpTotRetGan.subtract(AV41DetColumna3) ;
               }
               else
               {
                  AV11LiqLegImpOtrDescu = AV11LiqLegImpOtrDescu.add(AV41DetColumna3) ;
               }
            }
            else if ( GXutil.strcmp(A464DTipoConCod, "NRE_ARG") == 0 )
            {
               AV39DetColumna1 = DecimalUtil.ZERO ;
               AV40DetColumna2 = A764LiqDImpReCalcu ;
               if ( AV40DetColumna2.doubleValue() >= 0 )
               {
                  AV21totalSumanImportes = AV21totalSumanImportes.add(AV40DetColumna2) ;
               }
               else
               {
                  AV20totalRestanImportes = AV20totalRestanImportes.add(AV40DetColumna2) ;
               }
               AV41DetColumna3 = DecimalUtil.ZERO ;
               if ( GXutil.strcmp(A394DConCodigo, AV15pagosAcuentaConCodigo) == 0 )
               {
                  AV12LiqLegImpPagosACuen = AV12LiqLegImpPagosACuen.add(AV40DetColumna2) ;
               }
            }
            else if ( GXutil.strcmp(A464DTipoConCod, "REM_ARG") == 0 )
            {
               AV39DetColumna1 = A764LiqDImpReCalcu ;
               if ( AV39DetColumna1.doubleValue() >= 0 )
               {
                  AV21totalSumanImportes = AV21totalSumanImportes.add(AV39DetColumna1) ;
               }
               else
               {
                  AV20totalRestanImportes = AV20totalRestanImportes.add(AV39DetColumna1) ;
               }
               AV40DetColumna2 = DecimalUtil.ZERO ;
               AV41DetColumna3 = DecimalUtil.ZERO ;
               if ( ( GXutil.strcmp(A394DConCodigo, AV17sacConCodigo) == 0 ) || ( GXutil.strcmp(A394DConCodigo, AV19sacproporConCodigo) == 0 ) )
               {
                  AV18sacImportes = AV18sacImportes.add(AV39DetColumna1) ;
               }
               else
               {
                  if ( ( GXutil.strcmp(A468DSubTipoConCod1, new web.subtiponormal(remoteHandle, context).executeUdp( )) == 0 ) && ( GXutil.strcmp(A732DSubTipoConCod2, new web.conceptoafipsueldo(remoteHandle, context).executeUdp( )) == 0 ) )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     AV10LiqLegImpBasico = AV10LiqLegImpBasico.add(AV39DetColumna1) ;
                  }
               }
            }
            AV13LiqLegImpTotRemu = AV13LiqLegImpTotRemu.add(AV39DetColumna1) ;
            AV33LiqLegImpTotNoRemu = AV33LiqLegImpTotNoRemu.add(AV40DetColumna2) ;
            AV32LiqLegImpTotDescu = AV32LiqLegImpTotDescu.add(AV41DetColumna3) ;
            if ( ( A764LiqDImpReCalcu.doubleValue() > 0 ) || ! (GXutil.strcmp("", A270LiqDErrorDesc)==0) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV31LiqLegCntConc = (short)(AV31LiqLegCntConc+1) ;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV45GXLvl21 == 0 )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
         }
         AV26i = (short)(AV26i+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = calculaimportesliqleg.this.AV21totalSumanImportes;
      this.aP8[0] = calculaimportesliqleg.this.AV42descuentosNegativos;
      this.aP9[0] = calculaimportesliqleg.this.AV20totalRestanImportes;
      this.aP10[0] = calculaimportesliqleg.this.AV14LiqLegImpTotRetGan;
      this.aP11[0] = calculaimportesliqleg.this.AV11LiqLegImpOtrDescu;
      this.aP12[0] = calculaimportesliqleg.this.AV12LiqLegImpPagosACuen;
      this.aP13[0] = calculaimportesliqleg.this.AV18sacImportes;
      this.aP14[0] = calculaimportesliqleg.this.AV10LiqLegImpBasico;
      this.aP15[0] = calculaimportesliqleg.this.AV13LiqLegImpTotRemu;
      this.aP16[0] = calculaimportesliqleg.this.AV33LiqLegImpTotNoRemu;
      this.aP17[0] = calculaimportesliqleg.this.AV32LiqLegImpTotDescu;
      this.aP18[0] = calculaimportesliqleg.this.AV31LiqLegCntConc;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21totalSumanImportes = DecimalUtil.ZERO ;
      AV42descuentosNegativos = DecimalUtil.ZERO ;
      AV20totalRestanImportes = DecimalUtil.ZERO ;
      AV14LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      AV11LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      AV12LiqLegImpPagosACuen = DecimalUtil.ZERO ;
      AV18sacImportes = DecimalUtil.ZERO ;
      AV10LiqLegImpBasico = DecimalUtil.ZERO ;
      AV13LiqLegImpTotRemu = DecimalUtil.ZERO ;
      AV33LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      AV32LiqLegImpTotDescu = DecimalUtil.ZERO ;
      AV16retGanConCodigo = "" ;
      AV8adelantoRetGanConCodigo = "" ;
      AV9DevGanConCodigo = "" ;
      AV37remuTipoConCod = "" ;
      GXv_char1 = new String[1] ;
      AV35noRemuTipoConCod = "" ;
      GXv_char2 = new String[1] ;
      AV23descuTipoConCod = "" ;
      GXv_char3 = new String[1] ;
      AV38TipoConCod = new GXSimpleCollection<String>(String.class, "internal", "");
      AV24DTipoConCod = "" ;
      scmdbuf = "" ;
      P02CI2_A464DTipoConCod = new String[] {""} ;
      P02CI2_A6LegNumero = new int[1] ;
      P02CI2_A31LiqNro = new int[1] ;
      P02CI2_A1EmpCod = new short[1] ;
      P02CI2_A3CliCod = new int[1] ;
      P02CI2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02CI2_A394DConCodigo = new String[] {""} ;
      P02CI2_A732DSubTipoConCod2 = new String[] {""} ;
      P02CI2_n732DSubTipoConCod2 = new boolean[] {false} ;
      P02CI2_A468DSubTipoConCod1 = new String[] {""} ;
      P02CI2_n468DSubTipoConCod1 = new boolean[] {false} ;
      P02CI2_A270LiqDErrorDesc = new String[] {""} ;
      P02CI2_n270LiqDErrorDesc = new boolean[] {false} ;
      P02CI2_A81LiqDSecuencial = new int[1] ;
      A464DTipoConCod = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A394DConCodigo = "" ;
      A732DSubTipoConCod2 = "" ;
      A468DSubTipoConCod1 = "" ;
      A270LiqDErrorDesc = "" ;
      AV39DetColumna1 = DecimalUtil.ZERO ;
      AV40DetColumna2 = DecimalUtil.ZERO ;
      AV41DetColumna3 = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calculaimportesliqleg__default(),
         new Object[] {
             new Object[] {
            P02CI2_A464DTipoConCod, P02CI2_A6LegNumero, P02CI2_A31LiqNro, P02CI2_A1EmpCod, P02CI2_A3CliCod, P02CI2_A764LiqDImpReCalcu, P02CI2_A394DConCodigo, P02CI2_A732DSubTipoConCod2, P02CI2_n732DSubTipoConCod2, P02CI2_A468DSubTipoConCod1,
            P02CI2_n468DSubTipoConCod1, P02CI2_A270LiqDErrorDesc, P02CI2_n270LiqDErrorDesc, P02CI2_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV45GXLvl21 ;
   private short AV25EmpCod ;
   private short AV31LiqLegCntConc ;
   private short AV26i ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV22CliCod ;
   private int AV34LiqNro ;
   private int AV27LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV21totalSumanImportes ;
   private java.math.BigDecimal AV42descuentosNegativos ;
   private java.math.BigDecimal AV20totalRestanImportes ;
   private java.math.BigDecimal AV14LiqLegImpTotRetGan ;
   private java.math.BigDecimal AV11LiqLegImpOtrDescu ;
   private java.math.BigDecimal AV12LiqLegImpPagosACuen ;
   private java.math.BigDecimal AV18sacImportes ;
   private java.math.BigDecimal AV10LiqLegImpBasico ;
   private java.math.BigDecimal AV13LiqLegImpTotRemu ;
   private java.math.BigDecimal AV33LiqLegImpTotNoRemu ;
   private java.math.BigDecimal AV32LiqLegImpTotDescu ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal AV39DetColumna1 ;
   private java.math.BigDecimal AV40DetColumna2 ;
   private java.math.BigDecimal AV41DetColumna3 ;
   private String AV15pagosAcuentaConCodigo ;
   private String AV17sacConCodigo ;
   private String AV19sacproporConCodigo ;
   private String AV16retGanConCodigo ;
   private String AV8adelantoRetGanConCodigo ;
   private String AV9DevGanConCodigo ;
   private String AV37remuTipoConCod ;
   private String GXv_char1[] ;
   private String AV35noRemuTipoConCod ;
   private String GXv_char2[] ;
   private String AV23descuTipoConCod ;
   private String GXv_char3[] ;
   private String AV24DTipoConCod ;
   private String scmdbuf ;
   private String A464DTipoConCod ;
   private String A394DConCodigo ;
   private String A732DSubTipoConCod2 ;
   private String A468DSubTipoConCod1 ;
   private boolean n732DSubTipoConCod2 ;
   private boolean n468DSubTipoConCod1 ;
   private boolean n270LiqDErrorDesc ;
   private boolean Cond_result ;
   private String A270LiqDErrorDesc ;
   private short[] aP18 ;
   private java.math.BigDecimal[] aP7 ;
   private java.math.BigDecimal[] aP8 ;
   private java.math.BigDecimal[] aP9 ;
   private java.math.BigDecimal[] aP10 ;
   private java.math.BigDecimal[] aP11 ;
   private java.math.BigDecimal[] aP12 ;
   private java.math.BigDecimal[] aP13 ;
   private java.math.BigDecimal[] aP14 ;
   private java.math.BigDecimal[] aP15 ;
   private java.math.BigDecimal[] aP16 ;
   private java.math.BigDecimal[] aP17 ;
   private IDataStoreProvider pr_default ;
   private String[] P02CI2_A464DTipoConCod ;
   private int[] P02CI2_A6LegNumero ;
   private int[] P02CI2_A31LiqNro ;
   private short[] P02CI2_A1EmpCod ;
   private int[] P02CI2_A3CliCod ;
   private java.math.BigDecimal[] P02CI2_A764LiqDImpReCalcu ;
   private String[] P02CI2_A394DConCodigo ;
   private String[] P02CI2_A732DSubTipoConCod2 ;
   private boolean[] P02CI2_n732DSubTipoConCod2 ;
   private String[] P02CI2_A468DSubTipoConCod1 ;
   private boolean[] P02CI2_n468DSubTipoConCod1 ;
   private String[] P02CI2_A270LiqDErrorDesc ;
   private boolean[] P02CI2_n270LiqDErrorDesc ;
   private int[] P02CI2_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV38TipoConCod ;
}

final  class calculaimportesliqleg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02CI2", "SELECT DTipoConCod, LegNumero, LiqNro, EmpCod, CliCod, LiqDImpReCalcu, DConCodigo, DSubTipoConCod2, DSubTipoConCod1, LiqDErrorDesc, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DTipoConCod = ( ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DTipoConCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((int[]) buf[13])[0] = rslt.getInt(11);
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
               stmt.setString(5, (String)parms[4], 20);
               return;
      }
   }

}

